package com.mystudy.firstproject.controller.board;

import com.mystudy.firstproject.domain.dto.board.BoardForm;
import com.mystudy.firstproject.domain.entity.board.Board;
import com.mystudy.firstproject.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("board")
@Slf4j
public class BoardController {

    private ModelMapper modelMapper;
    private BoardService boardService;

    @Autowired
    public BoardController(ModelMapper modelMapper, BoardService boardService) {
        this.modelMapper = modelMapper;
        this.boardService = boardService;
    }

    @PostMapping("/boardInsert")
    public String boardInsert(BoardForm boardForm){
        log.info(boardForm.toString());

        Board board = modelMapper.map(boardForm,Board.class);

        for(int i =0; i<15; i++){
            boardService.join(board);
            log.info("board : " + board.toString());
        }


        return  "redirect:/";
    }
}
