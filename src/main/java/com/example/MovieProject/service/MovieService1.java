package com.example.MovieProject.service;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie1;
import com.example.MovieProject.repository.MovieRepository1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService1 {  //쥬라기 월드
    @Autowired
    private MovieRepository1 movieRepository;

    public List<Movie1> movies() {
        return movieRepository.findAll();
    }

    public Movie1 movie(Long id) {
        return  movieRepository.findById(id).orElse(null);
    }

    public Movie1 create(Movieform dto) {
        Movie1 movie = dto.toEntity1();
        if(movie.getId() != null) {
            return null;
        }
        return movieRepository.save(movie);
    }

    public Movie1 update(Long id, Movieform dto) {
        Movie1 movie = dto.toEntity1();
        Movie1 dbData = movieRepository.findById(id).orElse(null);
        dbData.patch(movie);
        Movie1 updated = movieRepository.save(dbData);
        return updated;
    }

    public Movie1 delete(Long id) {
        Movie1 deleted =  movieRepository.findById(id).orElse(null);
        if(deleted == null) {
            return null;
        }
        movieRepository.delete(deleted);
        return deleted;
    }

    @Transactional
    public List<Movie1> createMovies(List<Movieform> dtos) {
        List<Movie1> movieList = dtos.stream()
                .map(dto -> dto.toEntity1())
                .collect(Collectors.toList());

        movieList.stream()
                .forEach(movie -> movieRepository.save(movie));

        movieRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패"));

        return movieList;
    }
}
