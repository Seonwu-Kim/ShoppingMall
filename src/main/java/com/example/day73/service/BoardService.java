package com.example.day73.service;


import com.example.day73.domain.Board;
import com.example.day73.domain.BoardRepository;
import com.example.day73.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public  Long update(Long id, BoardRequestDto boardRequestDto){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지않음.")
        );
        board.update(boardRequestDto);
        return board.getId();
    }
}
