package com.example.mvc.springweb.board.controller;


import com.example.mvc.springweb.board.repository.BoardRepository;
import com.example.mvc.springweb.board.service.BoardService;
import com.example.mvc.springweb.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    //의존 관계 설정
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    //글 작성 화면 요청
    @GetMapping("/board/write")
    public String write() {
        return "board/write";
    }
    //글 작성 처리 요청
    @PostMapping("/board/write")
    public String write(Board article) {
        System.out.println(article);
        boardRepository.insertArticle(article);
        return "redirect:/board/list";
    }
    //글 목록 요청
    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("articles",boardRepository.getArticles());
        return "board/list";
    }
}
