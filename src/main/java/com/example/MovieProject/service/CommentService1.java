package com.example.MovieProject.service;

import com.example.MovieProject.dto.CommentDto;
import com.example.MovieProject.entity.Comment1;
import com.example.MovieProject.entity.Movie1;
import com.example.MovieProject.repository.CommentRepository1;
import com.example.MovieProject.repository.MovieRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService1 {
    @Autowired
    private CommentRepository1 commentRepository1;
    @Autowired
    private MovieRepository1 movieRepository;

    public List<CommentDto> comments(Long movieId) {
        List<Comment1> comments = commentRepository1.findByMovieId(movieId);
        return commentRepository1.findByMovieId(movieId)
                .stream()
                .map(comment -> CommentDto.createCommentDto1(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto createComment1(Long movieId, CommentDto commentDto) {
        Movie1 movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음"));

        Comment1 comment = Comment1.createComment1(commentDto, movie);

        Comment1 saved = commentRepository1.save(comment);

        //DTO로 변환 후 반환
        return CommentDto.createCommentDto1(saved);
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Comment1 saved = commentRepository1.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 댓글이 없음"));

        saved.patch(commentDto);

        Comment1 updated = commentRepository1.save(saved);

        return  CommentDto.createCommentDto1(updated);

    }

    @Transactional
    public CommentDto deleteComment(Long id) {
        Comment1 target = commentRepository1.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패, 대상이 없음"));

        commentRepository1.delete(target);

        return CommentDto.createCommentDto1(target);
    }
}
