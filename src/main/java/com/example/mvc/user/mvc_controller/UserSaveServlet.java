package com.example.mvc.user.mvc_controller;

import com.example.mvc.user.domain.User;
import com.example.mvc.user.repository.MemoryUserRepository;
import com.example.mvc.user.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-save")
public class UserSaveServlet extends HttpServlet {

    private UserRepository repository = new MemoryUserRepository();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //쿼리 파리미터를 읽어야 함
        String name = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        User newUser = new User(name, age);
        //회원저장소 저장
        repository.save(newUser);

        //회원 목록조회 요청
        resp.sendRedirect("/find-users");

    }
}
