package com.petproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    @Id
    @Column(name = "film_id")
    private int id;
    private String title;
    @ElementCollection
    private List<String> genre_ids = new ArrayList<>();
    private String poster_path;
    private float vote_average;
    @Column(columnDefinition = "text")
    private String overview;
    @OneToMany(mappedBy = "filmId")
    private List<Comment> comment = new ArrayList<>();
    private float popularity;
    private float mymdbRate;
    private String trailer;
    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Users> users = new ArrayList<>();

    public Film(List<String> genre_ids, int id, String poster_path, float vote_average, String overview, String title) {
        this.genre_ids = genre_ids;
        this.id = id;
        this.poster_path = poster_path;
        this.vote_average = vote_average;
        this.overview = overview;
        this.title = title;
    }

    public Film() {
    }

    public List<String> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<String> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getFilmId() {
        return id;
    }

    public void setFilmId(int id) {
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

    @Override
    public String toString() {
        return "Film{" +
//                "ID=" + ID +
                ", title='" + title + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", poster_path='" + poster_path + '\'' +
                ", vote_average=" + vote_average +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                '}';
    }

    public float getMymdbRate() {
        return mymdbRate;
    }

    public void setMymdbRate(float mymdbRate) {
        this.mymdbRate = mymdbRate;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTrailer() {
        return trailer;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
