package com.petproject.demo.repository;

import com.petproject.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query(value = "SELECT * FROM film ORDER BY popularity DESC LIMIT 5", nativeQuery = true)
    List<Film> getTopFiveFilms();


}
