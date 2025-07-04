package com.example.MovieProject.controller;

import com.example.MovieProject.dto.Movieform;
import com.example.MovieProject.entity.Movie;
import com.example.MovieProject.repository.MovieRepository;
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
    private MovieRepository movieRepository;
    @Autowired
    //##### 나중에 풀어주기 private CommentService commentService;


    @GetMapping("/movie/new")
    public String newMovieForm() {
        return "movies/new";
    }

    @PostMapping("/movie/create")
    public String newMovie(Movieform movieform) {

        Movie movie = movieform.toEntity();

        Movie saved = movieRepository.save(movie);

        return "redirect:/movie/" + saved.getId();
    }

    @GetMapping("/movie/{number}")
    public String movieShow(@PathVariable Long number, Model model) {

        Movie saved = movieRepository.findById(number).orElse(null);
        //###### 나중에 꼭 풀어주기List<CommentDto> commentDtos = commentService.comments(number);

        model.addAttribute("movie", saved);
        //####나중에 꼭 풀어주기 model.addAttribute("commentDtos", commentDtos);

        return "movies/show";
    }

    @GetMapping("/movies")
    public String movieAll(Model model) {
        ArrayList<Movie> movies = movieRepository.findAll();

        model.addAttribute("movies", movies);

        return "movies/list";
    }

    @GetMapping("/img")
    public String movieImg(Model model) {
        model.addAttribute("imgPath", "/img.jpg");
        return "img";
    }

    @GetMapping("/movie/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        Movie saved = movieRepository.findById(id).orElse(null);

        model.addAttribute("movie", saved);

        return "movies/edit";
    }

    @PostMapping("/movie/update")
    public String update(Movieform movieform) {

        Movie movie = movieform.toEntity() ;

        Movie getData = movieRepository.findById(movie.getId()).orElse(null);

        if(getData != null) {
            Movie saved = movieRepository.save(movie);
        }
        return "redirect:/movie/" + movie.getId();
    }

    @GetMapping("/movie/{id}/delete")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes rttr) {

        Movie saved = movieRepository.findById(id).orElse(null);

        if(saved != null) {
            movieRepository.delete(saved);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다!");
        }
        return "redirect:/movies";
    }


}
