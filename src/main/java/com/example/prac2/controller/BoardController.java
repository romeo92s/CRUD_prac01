package com.example.prac2.controller;

import com.example.prac2.dto.PasswordDto;
import com.example.prac2.dto.RequestDto;
import com.example.prac2.dto.ResponseDto;
import com.example.prac2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    //게시글 작성
    @PostMapping("/api/posts")
    public ResponseDto<?> createBoard(@RequestBody RequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }      //response필요, request필요 db에 보내줄려면 service로 보내줘야함

    //게시글 전체조회
    @GetMapping("/api/posts")
    public ResponseDto<?> getAllBoard(){
        return boardService.getAllBoard();
    }
    //게시글 하나조회
    @GetMapping("/api/posts/{id}")
    public ResponseDto<?> getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }
    //게시글 업데이트
    @PutMapping("/api/posts/{id}")
    public ResponseDto<?> update(@PathVariable Long id,@RequestBody RequestDto requestDto){
        return boardService.updateBoard(id,requestDto);
    }
    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public ResponseDto<?> delete(@PathVariable Long id){
        return boardService.deleteBoard(id);
    }
    //게시글 비밀번호 확인 api
    @PostMapping("/api/posts/{id}")
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id,@RequestBody PasswordDto password){
        return boardService.validateAuthorByPassword(id,password);
    }
}

