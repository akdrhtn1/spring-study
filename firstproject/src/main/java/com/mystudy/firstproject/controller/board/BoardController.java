package com.mystudy.firstproject.controller.board;

import com.mystudy.firstproject.Validator.BoardValidator;
import com.mystudy.firstproject.domain.dto.board.BoardForm;
import com.mystudy.firstproject.domain.entity.board.Board;
import com.mystudy.firstproject.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("board")
@Slf4j
public class BoardController {

    private ModelMapper modelMapper;
    private BoardService boardService;
    private BoardValidator boardValidator;

    @Autowired
    public BoardController(ModelMapper modelMapper, BoardService boardService, BoardValidator boardValidator) {
        this.modelMapper = modelMapper;
        this.boardService = boardService;
        this.boardValidator = boardValidator;
    }

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC,size = 2) Pageable pageable){
        Page<Board> boards = boardService.listAllPage(pageable);
        //현재 페이지 번호 갖고옴
        int startPage = Math.max(1, boards.getPageable().getPageNumber() -4);
        int endPage = Math.min(boards.getTotalPages(),boards.getPageable().getPageNumber() +4);
        log.info(startPage + "" + endPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("boardList",boards);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("boardForm",new BoardForm());
        }else{
            model.addAttribute("boardForm",boardService.findById(id).orElse(null));
        }
        //여기서 값을 넘겨줘야 form에서 object를 쓸 수 있음 동인할 주소 값으로 값을 전달 할 수 있음
        return "board/form";
    }

    @PostMapping("/form")
    public String formSubmit(@Valid BoardForm boardForm, BindingResult bindingResult){
        //Form DTO에서 설정한 값이 유효성 검사에서 에러 뜰떄
        boardValidator.validate(boardForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "board/form";
        }
        log.info(boardForm.toString());
        Board board = modelMapper.map(boardForm,Board.class);
        boardService.join(board);
        log.info(board.toString());
        return "redirect:/board/list"; //controller list로 조회되면서 이동처리
    }
}
