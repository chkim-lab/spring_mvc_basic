package com.example.mvc.springweb.board.repository;

import com.example.mvc.springweb.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("jdbcBoardRepo")
public class JdbcBoardRepository implements BoardRepository{

    //설정정보 필드 등록
    private String userId = "java_web1";
    private String userPw = "202104";
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"; //db접속 위치
    private String driverName = "oracle.jdbc.driver.OracleDriver"; //드라이버 클래스이름

    @Override
    public List<Board> getArticles() {

        List<Board> boardList = new ArrayList<>();

        Connection connection = null;

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            String sql = "SELECT * FROM tbl_board";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            System.out.println("resultSet = " + resultSet);

            while (resultSet.next()) {
                System.out.println("select start");
                Board findBoard = new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
                boardList.add(findBoard);
            }
            System.out.println("select end");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return boardList;
    }

    @Override
    public void insertArticle(Board article) {
        Connection connection = null;
        try {
            //드라이버 클래스 로딩
            Class.forName(driverName);

            //DB연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            //SQL 작성
            String sql = "INSERT INTO tbl_board " +
                    "(board_no, writer, title, content) " +
                    "VALUES (seq_board.nextval, ?, ?, ?)";

            //SQL을 실행할 객체 PrepareStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            //?값 채우기
            statement.setString(1, article.getWriter());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getContent());

            //sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();

            System.out.println("success data insert");

        } catch (Exception e) {
            System.out.println("fail data insert!");
            e.printStackTrace();
        } finally {
            //db접속 해제
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void deleteArticle(int boardNo) {
        Connection connection = null;
        try {
            //드라이버 클래스 로딩
            Class.forName(driverName);

            //DB연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            //SQL 작성
            String sql = "DELETE FROM tbl_board WHERE board_no=?";

            //SQL을 실행할 객체 PrepareStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            //?값 채우기
            statement.setInt(1, boardNo);

            //sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();

            System.out.println("데이터 삭제 성공!");

        } catch (Exception e) {
            System.out.println("데이터 삭제 실패!");
        } finally {
            //db접속 해제
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    @Override
    public Board getContent(int boardNo) {
        Connection connection = null;

        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            String sql = "SELECT * FROM tbl_board WHERE board_no = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, boardNo);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void modifyArticle(Board article) {
        Connection connection = null;
        try {
            //드라이버 클래스 로딩
            Class.forName(driverName);

            //DB연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            //SQL 작성
            String sql = "UPDATE tbl_board SET writer=?, title=?, content=? " +
                    "WHERE board_no=?";

            //SQL을 실행할 객체 PrepareStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            //?값 채우기
            statement.setString(1, article.getWriter());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getContent());
            statement.setInt(4, article.getBoardNo());

            //sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();

            System.out.println("success data modify");

        } catch (Exception e) {
            System.out.println("fail data modify!");
            e.printStackTrace();
        } finally {
            //db접속 해제
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
