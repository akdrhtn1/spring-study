package com.mystudy.firstproject.controller.board;

import com.mystudy.firstproject.Validator.BoardValidator;

import com.mystudy.firstproject.domain.dto.board.BoardForm;
import com.mystudy.firstproject.domain.entity.board.Board;
import com.mystudy.firstproject.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/boards")
public class BoardApiController {

    private ModelMapper modelMapper;
    private BoardService boardService;
    private BoardValidator boardValidator;

    @Autowired
    public BoardApiController(ModelMapper modelMapper, BoardService boardService, BoardValidator boardValidator) {
        this.modelMapper = modelMapper;
        this.boardService = boardService;
        this.boardValidator = boardValidator;
    }

    @GetMapping("")
    List<Board> all(@RequestParam(required = false, defaultValue = "")String title,
                    @RequestParam(required = false, defaultValue = "")String content){
        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)){
            return boardService.listAll();
        }else{
            return boardService.findByTitleOrContent(title,content);
        }

    }
    @PostMapping("")
    Board newBoard(@RequestBody BoardForm boardForm){
        Board board = modelMapper.map(boardForm,Board.class);
        return boardService.join(board);
    }

    @GetMapping("/{id}")
    Board one(@PathVariable long id){
        return boardService.findById(id).orElse(null);
    }
    @PutMapping("/{id}")
    Board replaceBoard(@RequestBody BoardForm newBoard, @PathVariable Long id){

        return boardService.findById(id).map(board -> {
            board.setTitle(newBoard.getTitle());
            board.setContent(newBoard.getContent());
            return boardService.join(board);
        }).orElseGet(() -> {
           newBoard.setId(id);
           Board board = modelMapper.map(newBoard,Board.class);
           return boardService.join(board);
        });
    }

    @DeleteMapping("/{id}")
    void deleteBoard(@PathVariable long id){
        boardService.deleteBoard(id);
    }

}
