package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Comment3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository3 extends JpaRepository<Comment3, Long> {
    @Query(value = "SELECT * FROM comment3 WHERE MOVIE_ID = :movieId",
            nativeQuery = true)
    List<Comment3> findByMovieId (Long movieId);

    List<Comment3> findByNickname(String nickname);
}
