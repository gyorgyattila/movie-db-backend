package com.petproject.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vote {
    @Id
    private int id;
    @ManyToOne
    private Comment comment;
    @ManyToOne
    private Users user;
    private int value;

    public Vote(Comment comment, Users user, int value) {
        this.comment = comment;
        this.user = user;
        this.value = value;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
