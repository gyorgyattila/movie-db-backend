package com.petproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int ID;
    private String comment;
    @JoinColumn(name = "userName")
    private String userName;
    private int voteNumber;
    @ManyToOne
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film filmId;
    @OneToMany
    private List<Vote> votes = new ArrayList<>();


    public Comment(String comment, Film filmId, String userName, int voteNumber) {
        this.comment = comment;
        this.filmId = filmId;
        this.userName = userName;
        this.voteNumber = voteNumber;
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


    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVoteNumber() {
        return voteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        this.voteNumber = voteNumber;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID=" + ID +
                "username " + userName +
                ", comment='" + comment + '\'' +
                ", filmId=" + filmId +
                ", voteNumber=" + voteNumber +
                '}';
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
