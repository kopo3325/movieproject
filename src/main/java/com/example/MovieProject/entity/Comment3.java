package com.example.MovieProject.entity;

import com.example.MovieProject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "comment3")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Comment3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie3 movie;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment3 createComment3(CommentDto commentDto, Movie3 movie) {
        if (commentDto.getId() != null)
            throw new IllegalArgumentException("댓글의 id가 존재하여 생성에 실패함");

        if (commentDto.getMovieId() != movie.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됨");

        return new Comment3(
                commentDto.getId(),
                movie,
                commentDto.getNickname(),
                commentDto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if(this.id != dto.getId())
            throw  new IllegalArgumentException("잘못된 입력 예외 발생");
        if(dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();

    }
}
