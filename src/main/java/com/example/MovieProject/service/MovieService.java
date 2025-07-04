package com.example.MovieProject.service;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie;
import com.example.MovieProject.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> movies() {
        return movieRepository.findAll();
    }

    public Movie movie(Long id) {
        return  movieRepository.findById(id).orElse(null);
    }

    public Movie create(Movieform dto) {
        Movie movie = dto.toEntity();
        if(movie.getId() != null) {
            return null;
        }
        return movieRepository.save(movie);
    }

    public Movie update(Long id, Movieform dto) {
        Movie movie = dto.toEntity();
        Movie dbData = movieRepository.findById(id).orElse(null);
        dbData.patch(movie);
        Movie updated = movieRepository.save(dbData);
        return updated;
    }

    public Movie delete(Long id) {
        Movie deleted =  movieRepository.findById(id).orElse(null);
        if(deleted == null) {
            return null;
        }
        movieRepository.delete(deleted);
        return deleted;
    }

    @Transactional
    public List<Movie> createMovies(List<Movieform> dtos) {
        List<Movie> movieList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        movieList.stream()
                .forEach(movie -> movieRepository.save(movie));

        movieRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패"));

        //리턴
        return movieList;
    }
}
