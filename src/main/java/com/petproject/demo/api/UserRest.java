package com.petproject.demo.api;

import com.petproject.demo.model.Film;
import com.petproject.demo.model.Users;
import com.petproject.demo.repository.UserRepository;
import com.petproject.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class UserRest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(FilmRest.class);

    @CrossOrigin
    @GetMapping(value = "/user")
    public ResponseEntity<Users> getUser(@RequestHeader Map<String, String> header) {
        return userService.getUser(header.get("authorization"));
    }

    @CrossOrigin
    @PostMapping(value = "/add-watchlist/{id}", consumes = "application/json")
    public ResponseEntity addToWatchList(@PathVariable("id") String filmId, @RequestHeader Map<String, String> header) {
        userRepository.addToWatchlist(header.get("userid"), Integer.parseInt(filmId));
        logger.info("added to watchlist");
        return new ResponseEntity(HttpStatus.OK);
    }
}
