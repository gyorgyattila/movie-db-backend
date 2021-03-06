package com.petproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    private String id;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany
    private List<Comment> comments = new ArrayList<>();
    private String picture;
    @ManyToMany
    private List<Film> watchList = new ArrayList<>();
    @OneToMany
    private List<Vote> votes  = new ArrayList<>();

    public Users(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public Users() {
    }

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Film> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<Film> watchList) {
        this.watchList = watchList;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
