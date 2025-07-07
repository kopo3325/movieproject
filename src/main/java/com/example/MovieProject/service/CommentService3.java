package com.example.MovieProject.service;
import com.example.MovieProject.dto.CommentDto;
import com.example.MovieProject.entity.Comment3;
import com.example.MovieProject.entity.Movie3;
import com.example.MovieProject.repository.CommentRepository3;
import com.example.MovieProject.repository.MovieRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService3 {
    @Autowired
    private CommentRepository3 commentRepository3;
    @Autowired
    private MovieRepository3 movieRepository;

    public List<CommentDto> comments(Long movieId) {
        List<Comment3> comments = commentRepository3.findByMovieId(movieId);
        return commentRepository3.findByMovieId(movieId)
                .stream()
                .map(comment -> CommentDto.createCommentDto3(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto createComment3(Long movieId, CommentDto commentDto) {
        Movie3 movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음"));

        Comment3 comment = Comment3.createComment3(commentDto, movie);

        Comment3 saved = commentRepository3.save(comment);

        //DTO로 변환 후 반환
        return CommentDto.createCommentDto3(saved);
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Comment3 saved = commentRepository3.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정할 댓글이 없음"));

        saved.patch(commentDto);

        Comment3 updated = commentRepository3.save(saved);

        return CommentDto.createCommentDto3(updated);

    }

    @Transactional
    public CommentDto deleteComment(Long id) {
        Comment3 target = commentRepository3.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패, 대상이 없음"));

        commentRepository3.delete(target);

        return CommentDto.createCommentDto3(target);
    }
}
