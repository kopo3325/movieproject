package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Comment1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CommentRepository1 extends JpaRepository<Comment1, Long> {
    @Query(value = "SELECT * FROM comment1 WHERE MOVIE_ID = :movieId",
            nativeQuery = true)
    List<Comment1> findByMovieId (Long movieId);

    //특정 닉네임의 모든 댓글 조회
    List<Comment1> findByNickname(String nickname);
}
