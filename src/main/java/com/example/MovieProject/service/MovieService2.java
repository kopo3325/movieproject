package com.example.MovieProject.service;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie2;
import com.example.MovieProject.repository.MovieRepository2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MovieService2 {
    @Autowired
    private MovieRepository2 movieRepository;

    public List<Movie2> movies() {
        return movieRepository.findAll();
    }

    public Movie2 movie(Long id) {
        return  movieRepository.findById(id).orElse(null);
    }

    public Movie2 create(Movieform dto) {
        Movie2 movie = dto.toEntity2();
        if(movie.getId() != null) {
            return null;
        }
        return movieRepository.save(movie);
    }

    public Movie2 update(Long id, Movieform dto) {
        Movie2 movie = dto.toEntity2();
        Movie2 dbData = movieRepository.findById(id).orElse(null);
        dbData.patch(movie);
        Movie2 updated = movieRepository.save(dbData);
        return updated;
    }

    public Movie2 delete(Long id) {
        Movie2 deleted =  movieRepository.findById(id).orElse(null);
        if(deleted == null) {
            return null;
        }
        movieRepository.delete(deleted);
        return deleted;
    }

    @Transactional
    public List<Movie2> createMovies(List<Movieform> dtos) {
        List<Movie2> movieList = dtos.stream()
                .map(dto -> dto.toEntity2())
                .collect(Collectors.toList());

        movieList.stream()
                .forEach(movie -> movieRepository.save(movie));

        movieRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패"));

        //리턴
        return movieList;
    }
}
