package com.example.MovieProject.dto;

import com.example.MovieProject.entity.Movie1;
import com.example.MovieProject.entity.Movie2;
import com.example.MovieProject.entity.Movie3;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Movieform {
    private Long id;
    private String username;
    private String content;

    public Movie1 toEntity1() {  //쥬라기 월드
        return new Movie1(id, username, content);

    }
    public Movie2 toEntity2() {  //F1
        return new Movie2(id, username, content);

    }
    public Movie3 toEntity3() {  //드래곤 길들이기
        return new Movie3(id, username, content);

    }
}
