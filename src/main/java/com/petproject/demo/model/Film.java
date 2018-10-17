package com.petproject.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String title;
    @ElementCollection
    private List<String> genres = new ArrayList<>();
    @Column(name = "film_id")
    private Long id;
    private String poster_path;
    private float vote_average;
    @Column(columnDefinition = "text")
    private String overview;
    @OneToMany
    private List<Comment> comment = new ArrayList<>();
    private float popularity;

    public Film(List<String> genres, Long id, String poster_path, float vote_average, String overview, String title) {
        this.genres = genres;
        this.id = id;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.overview = overview;
        this.title = title;
    }

    public Film() {
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }
}
