package com.petproject.demo.api;

import com.petproject.demo.model.Users;
import com.petproject.demo.repository.UserRepository;
import com.petproject.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity<Users> getUser(@RequestHeader Map<String, String> header) {
        return userService.getUser(header.get("authorization"));
    }
}
