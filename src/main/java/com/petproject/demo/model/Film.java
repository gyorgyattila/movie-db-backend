package com.petproject.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ElementCollection
    private List<String> genres = new ArrayList<>();
    private Long film_id;
    private String posterPath;
    private float vote_average;
    private String overwiev;
    @OneToMany
    private List<Comment> comment = new ArrayList<>();

    public Film(List<String> genres, Long film_id, String posterPath, float vote_average, String overwiev) {
        this.genres = genres;
        this.film_id = film_id;
        this.posterPath = posterPath;
        this.vote_average = vote_average;
        this.overwiev = overwiev;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverwiev() {
        return overwiev;
    }

    public void setOverwiev(String overwiev) {
        this.overwiev = overwiev;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
