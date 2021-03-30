package com.example.mvc.springweb.controller;

import com.example.mvc.springweb.score.domain.Score;
import com.example.mvc.springweb.score.repository.ScoreRepository;
import com.example.mvc.springweb.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ScoreController {

    //의존 관계 설정
    private final ScoreRepository scoreRepository;
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreRepository scoreRepository, ScoreService scoreService) {
        this.scoreRepository = scoreRepository;
        this.scoreService = scoreService;
    }

    //학생 성적 입력화면을 열어주는 요청 처리
    @GetMapping("/score/register")
    public String register() {
        return "score/write-form";
    }

    //학생 성적을 데이터베이스에 등록하는 요청
    @PostMapping("/score/register")
    public String register(Score score) {
        System.out.println(score);

//        scoreRepository.insertScore(score); //Service가 중간에 끼어서 필요없음
        scoreService.insertService(score);
        return "score/write-result";
    }

    //학생 전체 성적 정보 조회 요청처리
    @GetMapping("/score/list")
    public String list(Model model) {
        List<Score> scoreList = scoreRepository.selectAllScores();
        model.addAttribute("scores", scoreList);
        return  "score/score-list";
    }

    //학생 성적정보 삭제 요청 처리
    @GetMapping("/score/delete")
    // RedirectAttributes - 리다이렉트하는 경로로 데이터를 보내주는 객체
    public String delete(int stuNum, RedirectAttributes ra) {

        scoreRepository.deleteScore(stuNum);
        // 삭제 완료 후 /list요청의 jsp페이지로 보낼 데이터 세팅
        ra.addFlashAttribute("msg", "delOK");

        //단순히 score-list.jsp를 열면 조회데이터가 없는 상태로 열리기
        //때문에 아무 데이터도 안나온다.
        //따라서 /score/list로 리다이렉트하여 재요청해야 함.
//        return "score/score-list";
        return "redirect:/score/list";
    }

}