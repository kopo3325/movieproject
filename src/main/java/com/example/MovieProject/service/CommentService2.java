package com.example.MovieProject.service;
import com.example.MovieProject.dto.CommentDto;
import com.example.MovieProject.entity.Comment2;
import com.example.MovieProject.entity.Movie2;
import com.example.MovieProject.repository.CommentRepository2;
import com.example.MovieProject.repository.MovieRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService2 {
    @Autowired
    private CommentRepository2 commentRepository2;
    @Autowired
    private MovieRepository2 movieRepository;

    public List<CommentDto> comments(Long movieId) {
        List<Comment2> comments = commentRepository2.findByMovieId(movieId);
        return commentRepository2.findByMovieId(movieId)
                .stream()
                .map(comment -> CommentDto.createCommentDto2(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto createComment2(Long movieId, CommentDto commentDto) {
        Movie2 movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음"));

        Comment2 comment = Comment2.createComment2(commentDto, movie);

        Comment2 saved = commentRepository2.save(comment);

        //DTO로 변환 후 반환
        return CommentDto.createCommentDto2(saved);
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Comment2 saved = commentRepository2.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 댓글이 없음"));

        saved.patch(commentDto);

        Comment2 updated = commentRepository2.save(saved);

        return  CommentDto.createCommentDto2(updated);

    }

    @Transactional
    public CommentDto deleteComment(Long id) {
        Comment2 target = commentRepository2.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패, 대상이 없음"));

        commentRepository2.delete(target);

        return CommentDto.createCommentDto2(target);
    }
}
