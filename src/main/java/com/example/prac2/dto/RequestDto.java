package com.example.prac2.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {


    private String title;
    private String content;
    private String author;
    private String password;

    public RequestDto(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
