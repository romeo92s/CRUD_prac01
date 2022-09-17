package com.example.prac2.repository;

import com.example.prac2.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    //게시글 전체조회
    List<Board> findAllByOrderByModifiedAtDesc();

    //게시글 하나조회 //게시글 수정 /// 게시글 삭제
    Optional<Board> findById(Long id);
}
