package com.example.MovieProject.api;

import com.example.MovieProject.dto.CommentDto;
import com.example.MovieProject.service.CommentService1;
import com.example.MovieProject.service.CommentService2;
import com.example.MovieProject.service.CommentService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService1 commentService1;
    @Autowired
    private CommentService2 commentService2;
    @Autowired
    private CommentService3 commentService3;

    //C 생성
    @PostMapping("/api/movies/1/{movieId}/comments")  //쥬라기 월드
    public ResponseEntity<CommentDto> createComment1(
            @PathVariable Long movieId,
            @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService1.createComment1(movieId, commentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/api/movies/2/{movieId}/comments")  //F1
    public ResponseEntity<CommentDto> createComment2(
            @PathVariable Long movieId,
            @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService2.createComment2(movieId, commentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/api/movies/3/{movieId}/comments")  //드래곤 길들이기
    public ResponseEntity<CommentDto> createComment3(
            @PathVariable Long movieId,
            @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService3.createComment3(movieId, commentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    //R 조회
    @GetMapping("/api/movies/1/comments")  //쥬라기 월드
    public ResponseEntity<List<CommentDto>> comments1(@PathVariable Long movieId) {

        List<CommentDto> dtos = commentService1.comments(movieId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/api/movies/2/comments")  //F1
    public ResponseEntity<List<CommentDto>> comments2(@PathVariable Long movieId) {

        List<CommentDto> dtos = commentService2.comments(movieId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/api/movies/3/comments")  //드래곤 길들이기
    public ResponseEntity<List<CommentDto>> comments3(@PathVariable Long movieId) {

        List<CommentDto> dtos = commentService3.comments(movieId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //U 수정
    @PatchMapping("/api/comments/1/{id}")  //쥬라기 월드
    public  ResponseEntity<CommentDto> updateComment1(@PathVariable Long id, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService1.updateComment(id, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/api/comments/2/{id}")  //F1
    public  ResponseEntity<CommentDto> updateComment2(@PathVariable Long id, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService2.updateComment(id, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/api/comments/3/{id}")  //드래곤 길들이기
    public  ResponseEntity<CommentDto> updateComment3(@PathVariable Long id, @RequestBody CommentDto commentDto) {

        CommentDto dto = commentService3.updateComment(id, commentDto);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //D 삭제
    @DeleteMapping("/api/comments/1/{id}")  //쥬라기 월드
    public  ResponseEntity<CommentDto> deleteComment1(@PathVariable Long id) {

        CommentDto dto = commentService1.deleteComment(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/api/comments/2/{id}")  //F1
    public  ResponseEntity<CommentDto> deleteComment2(@PathVariable Long id) {

        CommentDto dto = commentService2.deleteComment(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping("/api/comments/3/{id}")  //드래곤 길들이기
    public  ResponseEntity<CommentDto> deleteComment3(@PathVariable Long id) {

        CommentDto dto = commentService3.deleteComment(id);

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
