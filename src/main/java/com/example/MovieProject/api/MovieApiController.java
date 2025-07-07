package com.example.MovieProject.api;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie1;
import com.example.MovieProject.service.MovieService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MovieApiController {
    @Autowired
    private MovieService1 movieService;

    @GetMapping("/api/movies")  //db 전체 내용 조회
    public List<Movie1> movies() {
        return movieService.movies();
    }

    @GetMapping("/api/movie/{id}")
    public Movie1 movie(@PathVariable Long id) {
        return movieService.movie(id);
    }

    @PostMapping("/api/movies")
    public ResponseEntity<Movie1> createMovie(@RequestBody Movieform dto) {

        Movie1 created = movieService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PatchMapping("/api/movie/{id}")
    public  ResponseEntity<Movie1> updateMovie(@PathVariable Long id, @RequestBody Movieform dto) {
        Movie1 updated = movieService.update(id, dto);
        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/movie/{id}")
    public ResponseEntity<Movie1> deleteMovie(@PathVariable Long id) {
        Movie1 deleted = movieService.delete(id);
        return (deleted != null) ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/transaction-test")
    public  ResponseEntity<List<Movie1>> transactionTest(@RequestBody List<Movieform> dtos) {
        List<Movie1> createList = movieService.createMovies(dtos);

        return (createList != null) ? ResponseEntity.status(HttpStatus.OK).body(createList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
