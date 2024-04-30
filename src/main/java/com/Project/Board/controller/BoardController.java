package com.Project.Board.controller;

import com.Project.Board.dto.BoardDTO;
import com.Project.Board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")   // 하위 메서드에서 /board 안붙여도 됨
public class BoardController {

    private final BoardService boardService;

    // 게시판으로 이동
    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "board";
    }

    // 글 작성 페이지로 이동
    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    // 글 작성
    @PostMapping("/write")
    public String write(@ModelAttribute BoardDTO boardDTO) {
        boardService.write(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {
        boardService.updateHits(id);    // 조회수 올림
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);

        return "post";
    }

}
