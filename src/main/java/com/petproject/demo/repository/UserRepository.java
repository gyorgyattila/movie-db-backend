package com.petproject.demo.repository;

import com.petproject.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT * FROM users WHERE id= :id", nativeQuery = true)
    Users getUsersById(@Param("id") String id);
}
