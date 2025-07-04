package com.example.MovieProject.dto;

import com.example.MovieProject.entity.Movie;
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

    public Movie toEntity() {
        return new Movie(id, username, content);
    }
}
