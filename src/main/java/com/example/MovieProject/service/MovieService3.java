package com.example.MovieProject.service;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie3;
import com.example.MovieProject.repository.MovieRepository3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService3 {  //드래곤 길들이기
    @Autowired
    private MovieRepository3 movieRepository;

    public List<Movie3> movies() {
        return movieRepository.findAll();
    }

    public Movie3 movie(Long id) {
        return  movieRepository.findById(id).orElse(null);
    }

    public Movie3 create(Movieform dto) {
        Movie3 movie = dto.toEntity3();
        if(movie.getId() != null) {
            return null;
        }
        return movieRepository.save(movie);
    }

    public Movie3 update(Long id, Movieform dto) {
        Movie3 movie = dto.toEntity3();
        Movie3 dbData = movieRepository.findById(id).orElse(null);
        dbData.patch(movie);
        Movie3 updated = movieRepository.save(dbData);
        return updated;
    }

    public Movie3 delete(Long id) {
        Movie3 deleted =  movieRepository.findById(id).orElse(null);
        if(deleted == null) {
            return null;
        }
        movieRepository.delete(deleted);
        return deleted;
    }

    @Transactional
    public List<Movie3> createMovies(List<Movieform> dtos) {
        List<Movie3> movieList = dtos.stream()
                .map(dto -> dto.toEntity3())
                .collect(Collectors.toList());

        movieList.stream()
                .forEach(movie -> movieRepository.save(movie));

        movieRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패"));

        return movieList;
    }
}
