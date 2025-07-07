package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Movie2;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface MovieRepository2 extends CrudRepository<Movie2, Long> {
    @Override
    ArrayList<Movie2> findAll();
}
