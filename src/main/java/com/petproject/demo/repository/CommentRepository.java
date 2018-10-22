package com.petproject.demo.repository;

import com.petproject.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comment WHERE film_id = :film_id", nativeQuery = true)
    List<Comment> getCommentsByFilmId(@Param("film_id") int film_id);
}
