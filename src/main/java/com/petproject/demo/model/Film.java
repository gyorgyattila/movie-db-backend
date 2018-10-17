package com.petproject.demo.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Film {
    List<String> genres =new ArrayList<>();
    Long id;
    String posterPath;
    float vote_average;
    String overwiev;
    Comment comment;
}
