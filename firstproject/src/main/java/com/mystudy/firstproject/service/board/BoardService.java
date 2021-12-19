package com.mystudy.firstproject.service.board;

import com.mystudy.firstproject.domain.entity.board.Board;
import com.mystudy.firstproject.repository.board.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board join(Board board){
        return boardRepository.save(board);
    }
    public List<Board> listAll(){

        return boardRepository.findAll();
    }
    public Page<Board> listAllPage(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Optional<Board> findById(long id){
        return boardRepository.findById(id);
    }

    public List<Board> findByTitle(String title){
        return boardRepository.findByTitle(title);
    }

    public List<Board> findByTitleOrContent(String title, String content){
        return boardRepository.findByTitleOrContent(title,content);
    }
    public void deleteBoard(long id){boardRepository.deleteById(id);}

    //내용, 제목 찾기
    public Page<Board> findByTitleOrContentContain(String title, String content,Pageable pageable){
        return boardRepository.findByTitleContainingOrContentContaining(title,content,pageable);
    }
}
