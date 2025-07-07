package com.example.MovieProject.repository;

import com.example.MovieProject.entity.Movie1;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface MovieRepository1 extends CrudRepository<Movie1, Long> {
    @Override
    ArrayList<Movie1> findAll();
}
