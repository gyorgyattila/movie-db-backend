package com.petproject.demo.api;

import com.google.gson.Gson;
import com.petproject.demo.model.Comment;
import com.petproject.demo.repository.CommentRepository;
import com.petproject.demo.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentRest {

    private Logger logger = LoggerFactory.getLogger(FilmRest.class);
    private static final String URL = "https://api.themoviedb.org/3/movie/";

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    Gson gson;
    @Autowired
    CommentRepository commentRepository;


    @CrossOrigin
    @PostMapping(value = "/{filmId}/add-comment", consumes = "application/json")
    public ResponseEntity addComment(@RequestBody Comment comment, @PathVariable("filmId") int filmId) {
        commentRepository.save(new Comment(comment.getComment(), filmRepository.getFilmBYFilmID(filmId)));
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/{filmId}/get-comments", produces = {"application/json"})
    public List<Comment> getComments(@PathVariable("filmId") String filmId) {
        List<Comment> comments = commentRepository.getCommentsByFilmId(Integer.parseInt(filmId));
        return comments;
    }
}
