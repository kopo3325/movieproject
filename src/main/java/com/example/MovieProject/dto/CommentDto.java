package com.example.MovieProject.dto;

import com.example.MovieProject.entity.Comment1;
import com.example.MovieProject.entity.Comment2;
import com.example.MovieProject.entity.Comment3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long id;
    private Long movieId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto1(Comment1 comment) {
        return new CommentDto(
                comment.getId(),  //댓글의 index
                comment.getMovie().getId(),  //댓글이 바라보는 게시글의 id
                comment.getNickname(),  //댓글 작성자
                comment.getBody()  //댓글 내용
        );
    }
    public static CommentDto createCommentDto2(Comment2 comment) {
        return new CommentDto(
                comment.getId(),  //댓글의 index
                comment.getMovie().getId(),  //댓글이 바라보는 게시글의 id
                comment.getNickname(),  //댓글 작성자
                comment.getBody()  //댓글 내용
        );
    }
    public static CommentDto createCommentDto3(Comment3 comment) {
        return new CommentDto(
                comment.getId(),  //댓글의 index
                comment.getMovie().getId(),  //댓글이 바라보는 게시글의 id
                comment.getNickname(),  //댓글 작성자
                comment.getBody()  //댓글 내용
        );
    }
}
