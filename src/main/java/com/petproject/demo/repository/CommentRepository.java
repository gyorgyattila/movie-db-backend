package com.petproject.demo.repository;

import com.petproject.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comment WHERE film_id = :film_id ORDER BY vote_number DESC ", nativeQuery = true)
    List<Comment> getCommentsByFilmId(@Param("film_id") int film_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE comment SET vote_number=vote_number+1 WHERE id=:id", nativeQuery = true)
    void incrementVoteNumber(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE comment SET vote_number=vote_number-1 WHERE id=:id", nativeQuery = true)
    void decrementVoteNumber(@Param("id") int id);
}
