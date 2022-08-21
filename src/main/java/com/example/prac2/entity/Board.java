package com.example.prac2.entity;

import com.example.prac2.dto.RequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")//columnDefinition = "TEXT" 이게뭐지?
    private String content;
    @Column(nullable = false)
    private String author;
    @JsonIgnore                 //이게있어야 비밀번호가 postman에서 안보임
    @Column(nullable = false)
    private String password;


    public Board(RequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
    public void update(RequestDto requestDto){  //여기에 왜 void가붙지 ?
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
    }
}
