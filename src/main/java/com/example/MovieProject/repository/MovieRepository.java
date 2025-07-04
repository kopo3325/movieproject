package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Override
    ArrayList<Movie> findAll();
}
