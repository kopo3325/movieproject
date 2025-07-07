package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Movie3;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface MovieRepository3 extends CrudRepository<Movie3, Long> {
    @Override
    ArrayList<Movie3> findAll();
}
