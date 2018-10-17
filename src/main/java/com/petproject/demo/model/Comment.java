package com.petproject.demo.model;

import javax.persistence.Entity;

@Entity
public class Comment {
    String comment;
    User user;

}
