package com.example.prac2.service;

import com.example.prac2.dto.RequestDto;
import com.example.prac2.dto.ResponseDto;
import com.example.prac2.entity.Board;
import com.example.prac2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    //게시글 생성
    @Transactional
    public ResponseDto<?> createBoard(RequestDto requestDto) {

        Board board = new Board(requestDto);

        boardRepository.save(board);

        return ResponseDto.success(board);
    }
    //게시글 전체조회
    @Transactional
    public ResponseDto<?> getAllBoard(){
        return ResponseDto.success(boardRepository.findAllByOrderByModifiedAtDesc());
    }
    //게시글 하나조회
    @Transactional
    public ResponseDto<?> getBoard(Long id){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        //optionnalPost안에 없으면 없다고 메세지를 남기고, 있으면 가져와라
        if (optionalBoard.isEmpty()){
            return ResponseDto.fail("NULL_POST_ID","post id isn't exist");

        }
        return ResponseDto.success(optionalBoard.get());
    }
    @Transactional
    public ResponseDto<?> updateBoard(Long id,RequestDto requestDto){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        //optionnalPost안에 없으면 없다고 메세지를 남기고, 있으면 가져와라
        if (optionalBoard.isEmpty()){
            return ResponseDto.fail("NULL_POST_ID","post id isn't exist");
        }
        Board board = optionalBoard.get();
        board.update(requestDto);
        return ResponseDto.success(board);
    }
    @Transactional
    public ResponseDto<?> deleteBoard(Long id){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        }
        Board board = optionalBoard.get();
        boardRepository.delete(board);
        return ResponseDto.success(true);
    }
}
