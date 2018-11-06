package com.petproject.demo.repository;

import com.petproject.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users WHERE id= :id", nativeQuery = true)
    Users getUsersById(@Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users_watch_list (users_id, watch_list_film_id) VALUES (:userid,:filmid)", nativeQuery = true)
    void addToWatchlist(@Param("userid") String userid, @Param("filmid") int filmid);
}
