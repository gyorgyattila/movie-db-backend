package com.petproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int ID;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;
    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film filmId;
    @JsonIgnore
    private int voteNumber;

    public Comment(String comment, Film filmId) {
        this.comment = comment;
        this.filmId = filmId;
    }

    public Comment() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID=" + ID +
                ", comment='" + comment + '\'' +
                ", user=" + user +
                ", filmId=" + filmId +
                ", voteNumber=" + voteNumber +
                '}';
    }
}
