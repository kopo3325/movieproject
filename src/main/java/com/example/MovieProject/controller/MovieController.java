package com.example.MovieProject.controller;

import com.example.MovieProject.dto.CommentDto;
import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie1;
import com.example.MovieProject.entity.Movie2;
import com.example.MovieProject.entity.Movie3;
import com.example.MovieProject.repository.MovieRepository1;
import com.example.MovieProject.repository.MovieRepository2;
import com.example.MovieProject.repository.MovieRepository3;
import com.example.MovieProject.service.CommentService1;
import com.example.MovieProject.service.CommentService2;
import com.example.MovieProject.service.CommentService3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class MovieController {
    @Autowired
    private MovieRepository1 movieRepository1;
    @Autowired
    private MovieRepository2 movieRepository2;
    @Autowired
    private MovieRepository3 movieRepository3;

    @Autowired
    private CommentService1 commentService1;
    @Autowired
    private CommentService2 commentService2;
    @Autowired
    private CommentService3 commentService3;

    @GetMapping("/movie/main")
    public String mainPage(Model model) {
        model.addAttribute("imgPath", "/imgs/img1.jpg");

        List<Movie1> movies = movieRepository1.findAll();
        model.addAttribute("movies", movies);
        return "movies/main";
    }

    @GetMapping("/movie/new/1")  //쥬라기 월드
    public String newMovieForm1() {
        return "/movies/new1";
    }

    @GetMapping("/movie/new/2")  //F1
    public String newMovieForm2() {
        return "/movies/new2";
    }

    @GetMapping("/movie/new/3")  //드래곤 길들이기
    public String newMovieForm3() {
        return "/movies/new3";
    }

    @PostMapping("/movie/1/create")  //쥬라기 월드
    public String newMovie1(Movieform movieform) {

        Movie1 movie = movieform.toEntity1();

        Movie1 saved = movieRepository1.save(movie);

        return "redirect:/movie/1/" + saved.getId();
    }

    @PostMapping("/movie/2/create")  //F1
    public String newMovie2(Movieform movieform) {

        Movie2 movie = movieform.toEntity2();

        Movie2 saved = movieRepository2.save(movie);

        return "redirect:/movie/2/" + saved.getId();
    }

    @PostMapping("/movie/3/create")  //드래곤 길들이기
    public String newMovie3(Movieform movieform) {

        Movie3 movie = movieform.toEntity3();

        Movie3 saved = movieRepository3.save(movie);

        return "redirect:/movie/3/" + saved.getId();
    }

    @GetMapping("/movie/1/{number}")  //쥬라기 월드
    public String movieShow1(@PathVariable Long number, Model model) {

        Movie1 saved = movieRepository1.findById(number).orElse(null);
        List<CommentDto> commentDtos = commentService1.comments(number);

        model.addAttribute("movie", saved);
        model.addAttribute("commentDtos", commentDtos);

        return "movies/show1";
    }

    @GetMapping("/movie/2/{number}")  //F1
    public String movieShow2(@PathVariable Long number, Model model) {

        Movie2 saved = movieRepository2.findById(number).orElse(null);
        List<CommentDto> commentDtos = commentService2.comments(number);

        model.addAttribute("movie", saved);
        model.addAttribute("commentDtos", commentDtos);

        return "movies/show2";
    }

    @GetMapping("/movie/3/{number}")  //드래곤 길들이기
    public String movieShow3(@PathVariable Long number, Model model) {

        Movie3 saved = movieRepository3.findById(number).orElse(null);
        List<CommentDto> commentDtos = commentService3.comments(number);

        model.addAttribute("movie", saved);
        model.addAttribute("commentDtos", commentDtos);

        return "movies/show3";
    }

    @GetMapping("/movies1")  //쥬라기 월드
    public String movieAll1(Model model) {
        ArrayList<Movie1> movies = movieRepository1.findAll();

        model.addAttribute("movies", movies);

        return "movies/list1";
    }

    @GetMapping("/movies2")  //F1
    public String movieAll2(Model model) {
        ArrayList<Movie2> movies = movieRepository2.findAll();

        model.addAttribute("movies", movies);

        return "movies/list2";
    }

    @GetMapping("/movies3")  //드래곤 길들이기
    public String movieAll3(Model model) {
        ArrayList<Movie3> movies = movieRepository3.findAll();

        model.addAttribute("movies", movies);

        return "movies/list3";
    }

    @GetMapping("/img")
    public String movieImg(Model model) {
        model.addAttribute("imgPath", "/img.jpg");
        return "img";
    }

    @GetMapping("/movie/1/{id}/edit")  //쥬라기 월드
    public String edit1(@PathVariable Long id, Model model) {

        Movie1 saved = movieRepository1.findById(id).orElse(null);

        model.addAttribute("movie", saved);

        return "movies/edit1";
    }

    @GetMapping("/movie/2/{id}/edit")  //F1
    public String edit2(@PathVariable Long id, Model model) {

        Movie2 saved = movieRepository2.findById(id).orElse(null);

        model.addAttribute("movie", saved);

        return "movies/edit2";
    }

    @GetMapping("/movie/3/{id}/edit")  //드래곤 길들이기
    public String edit3(@PathVariable Long id, Model model) {

        Movie3 saved = movieRepository3.findById(id).orElse(null);

        model.addAttribute("movie", saved);

        return "movies/edit3";
    }

    @PostMapping("/movie/1/update")  //쥬라기 월드
    public String update1(Movieform movieform) {

        Movie1 movie = movieform.toEntity1() ;

        Movie1 getData = movieRepository1.findById(movie.getId()).orElse(null);

        if(getData != null) {
            Movie1 saved = movieRepository1.save(movie);
        }
        return "redirect:/movie/1/" + movie.getId();
    }

    @PostMapping("/movie/2/update")  //F1
    public String update2(Movieform movieform) {

        Movie2 movie = movieform.toEntity2() ;

        Movie2 getData = movieRepository2.findById(movie.getId()).orElse(null);

        if(getData != null) {
            Movie2 saved = movieRepository2.save(movie);
        }
        return "redirect:/movie/2/" + movie.getId();
    }

    @PostMapping("/movie/3/update")  //드래곤 길들이기
    public String update3(Movieform movieform) {

        Movie3 movie = movieform.toEntity3() ;

        Movie3 getData = movieRepository3.findById(movie.getId()).orElse(null);

        if(getData != null) {
            Movie3 saved = movieRepository3.save(movie);
        }
        return "redirect:/movie/3/" + movie.getId();
    }

    @GetMapping("/movie/1/{id}/delete")  //쥬라기 월드
    public String deleteMovie1(@PathVariable Long id, RedirectAttributes rttr) {

        Movie1 saved = movieRepository1.findById(id).orElse(null);

        if(saved != null) {
            movieRepository1.delete(saved);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다!");
        }
        return "redirect:/movies1";
    }

    @GetMapping("/movie/2/{id}/delete")  //F1
    public String deleteMovie2(@PathVariable Long id, RedirectAttributes rttr) {

        Movie2 saved = movieRepository2.findById(id).orElse(null);

        if(saved != null) {
            movieRepository2.delete(saved);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다!");
        }
        return "redirect:/movies2";
    }

    @GetMapping("/movie/3/{id}/delete")  //드래곤 길들이기
    public String deleteMovie3(@PathVariable Long id, RedirectAttributes rttr) {

        Movie3 saved = movieRepository3.findById(id).orElse(null);

        if(saved != null) {
            movieRepository3.delete(saved);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다!");
        }
        return "redirect:/movies3";
    }
}