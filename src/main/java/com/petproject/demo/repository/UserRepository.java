package com.petproject.demo.repository;

import com.petproject.demo.model.Film;
import com.petproject.demo.model.Users;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, String> {
    @Query(value = "SELECT * FROM users WHERE id= :id", nativeQuery = true)
    Users getUsersById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO film_users (users_id, film_film_id) VALUES (:userid,:filmid)", nativeQuery = true)
    void addToWatchlist(@Param("userid") String userid, @Param("filmid") int filmid);

}
