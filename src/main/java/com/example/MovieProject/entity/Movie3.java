package com.example.MovieProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@ToString
@Slf4j
public class Movie3 {  //드래곤 길들이기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String content;

    public void patch(Movie3 movie) {
        if(movie.username != null) {
            this.username = movie.username;
        }
        if(movie.content != null) {
            this.content = movie.content;
        }
    }
}
