package com.example.mvc.springweb.controller;

import com.example.mvc.springweb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

//스프링의 디스패처 서블릿에 컨트롤러가 등록
@Controller
public class RequestController {

    //요청 처리 메서드 ( 요청 처리 서블릿 역할 )
    @GetMapping("/req/test")    //해당 URL에 따른 get요청을 처리하게 함
    public String testCall() {
        System.out.println("========================");
        System.out.println("\n## GET: /req/test!!!\n");
        System.out.println("========================");
        return "test"; //리턴은 뷰 파일 포워딩 개념
    }

    //request폴더에 있는 req-ex01.jsp를 열기 위한 요청
    @GetMapping("/request")
    public String req() {
        return "/request/req-ex01";
    }

    //GET: "/request/basic01" 처리 메서드
    @GetMapping("/request/basic01")
    public String basicGet() {
        System.out.println("\n## /request/basic01 : GET");
        return "request/req-ex01";
    }
    //POST: "/request/basic01" 처리 메서드
    @PostMapping("/request/basic01")
    public String basicPost() {
        System.out.println("\n## /request/basic01 : POST");
        return "request/req-ex01";
    }

    //요청 파라미터 받아보기
    @GetMapping("/request/param")
    public String param(HttpServletRequest request) {
        String money = request.getParameter("money");
        System.out.println("money = " + money);
        return "test";
    }

    @GetMapping("/request/param2")
    public String param2(int money, String name) {

        System.out.println("money = " + (money * 2));
        System.out.println("money = " + name);
        return "test";
    }

    //커맨드 객체를 통한 요청 파라미터 처리
    @PostMapping("/request/param3")
    public String param3(User user) {
        System.out.println(user);
        return "test";
    }

    //GET요청으로 /request/join-form 이 들어왔을때 join.jsp를 여는 메서드를 만드세요.
    @GetMapping("/request/join-form")
    public String join_form(User user) {
        System.out.println(user);
        return "request/join";
    }

    @PostMapping("/request/quiz")
    public String quiz(String id, String pw) {

        System.out.println("money = " + id);
        System.out.println("money = " + pw);
        if (id.equals("abc1234")  && pw.equals("xxx4321")) {
            return "request/success";
        } else {
            return "request/fail";
        }
    }

    //GET요청으로 /request/req-quiz 이 들어왔을때 req-quiz.jsp를 여는 메서드를 만드세요.
    @GetMapping("/request/req-quiz")
    public String req_quiz(User user) {
        System.out.println(user);
        return "request/req-quiz";
    }

}
