package com.petproject.demo.api;

import com.google.gson.Gson;
import com.petproject.demo.model.Film;
import com.petproject.demo.repository.CommentRepository;
import com.petproject.demo.repository.FilmRepository;
import com.petproject.demo.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;


@RestController
public class FilmRest {

    private Logger logger = LoggerFactory.getLogger(FilmRest.class);
    private static final String URL = "https://api.themoviedb.org/3/movie/";

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    Gson gson;
    @Autowired
    CommentRepository commentRepository;


    Retrofit getRetrofit(String url) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder.build();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getFilms() {
        Retrofit retrofit = getRetrofit(URL);
        FilmService filmService = retrofit.create(FilmService.class);
        int page = 1;
        int maxPage = 2;
        while (page <= maxPage) {
            Call<MovieApiResult> response = filmService.getFilms(System.getenv("apiKey"), page, "US");
            try {
                List<Film> repos = response.execute().body().getResults();
                maxPage = response.clone().execute().body().getTotal_pages();
                page++;
                for (Film film : repos) {
                    filmRepository.save(film);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("DB is Ready");
    }

    @CrossOrigin
    @GetMapping("/topFourFilms")
    public List<Film> getIndexPage() {
        List<Film> topFourFilms = filmRepository.getTopFourFilms();
        return topFourFilms;
    }

    @CrossOrigin
    @GetMapping("/now-playing")
    public List<Film> getNowPlayingFilms() {
        List<Film> nowPlaying = filmRepository.getAllNowPlayingFilms();
        return nowPlaying;
    }

    @CrossOrigin
    @GetMapping("/film/{id}")
    public Film getFilm(@PathVariable("id") String id) {
        Film film = filmRepository.getFilmBYFilmID(Integer.parseInt(id));
        return film;
    }

}
