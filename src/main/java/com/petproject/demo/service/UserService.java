package com.petproject.demo.service;

import com.petproject.demo.model.Users;
import com.petproject.demo.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Users> getUser(String token) {
        Users user = getDataFromUser(token).getBody();
        if (user != null) {
            if (userRepository.getUsersById(user.getID()) == null) {
                userRepository.save(user);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


    private ResponseEntity<Users> getDataFromUser(String token) {
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", header);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<JSONObject> response = restTemplate.exchange(
                    "https://movie-db.eu.auth0.com/userinfo", HttpMethod.GET, entity, JSONObject.class);
            System.out.println("itt a response: " + response);
            Users user = new Users();
            user.setID(response.getBody().get("sub").toString());
            user.setEmail(response.getBody().get("email").toString());
            user.setUserName(response.getBody().get("nickname").toString());
            user.setPicture(response.getBody().get("picture").toString());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}
