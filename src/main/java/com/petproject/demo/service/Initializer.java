package com.petproject.demo.service;

import com.petproject.demo.model.Comment;
import com.petproject.demo.repository.CommentRepository;
import com.petproject.demo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    FilmRepository filmRepository;

    @PostConstruct
    public void initializer() {
        commentRepository.save(new Comment("ez egy comment", filmRepository.getFilmBYFilmID(335983)));
        commentRepository.save(new Comment("ez egy masik comment", filmRepository.getFilmBYFilmID(335983)));

    }
}
