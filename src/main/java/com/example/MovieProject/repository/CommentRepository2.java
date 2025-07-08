package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Comment2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository2 extends JpaRepository<Comment2, Long> {
    @Query(value = "SELECT * FROM comment2 WHERE MOVIE_ID = :movieId",
            nativeQuery = true)
    List<Comment2> findByMovieId (Long movieId);

    List<Comment2> findByNickname(String nickname);
}
