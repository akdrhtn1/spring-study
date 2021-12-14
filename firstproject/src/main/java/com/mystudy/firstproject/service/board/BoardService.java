package com.mystudy.firstproject.service.board;

import com.mystudy.firstproject.domain.entity.board.Board;
import com.mystudy.firstproject.repository.board.BoardRepository;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long join(Board board){
        Board save =  boardRepository.save(board);

        return save.getIdx();
    }
}
