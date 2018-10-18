package com.petproject.demo.repository;

import com.petproject.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "SELECT * FROM film ORDER BY popularity DESC LIMIT 4", nativeQuery = true)
    List<Film> getTopFourFilms();

    @Query(value = "SELECT * FROM film ORDER BY popularity DESC", nativeQuery = true)
    List<Film> getAllNowPlayingFilms();

    @Query(value = "SELECT * FROM film WHERE film_id = :film_id", nativeQuery = true)
    Film getFilmBYFilmID(@Param("film_id") int film_id);

}
