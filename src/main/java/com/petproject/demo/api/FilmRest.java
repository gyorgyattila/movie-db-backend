package com.petproject.demo.api;

import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
public class FilmRest {

    public static final String URL = "https://api.themoviedb.org/3/movie/";


    Retrofit getRetrofit(String url) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create());
        return retrofitBuilder.build();
    }
}
