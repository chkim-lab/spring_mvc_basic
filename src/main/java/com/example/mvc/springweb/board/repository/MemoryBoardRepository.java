package com.example.mvc.springweb.board.repository;

import com.example.mvc.springweb.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryBoardRepository implements BoardRepository{

    private static Map<Integer, Board> boardMap = new HashMap<>();

    static {
        boardMap.put(1 ,new Board("김철수","안녕하심까.","저는 김철수입니다."));
        boardMap.put(2 ,new Board("박영희","무서운 꿈을 꾸었습니다..","어제밤 악몽을 꾸었습니다."));
        boardMap.put(3 ,new Board("고길동","내집에서 나가.","파럼치한"));
    }

    @Override
    public List<Board> getArticles() {
        //map을 반복문으로 돌려서 value만 싹 빼서 리스트에 담아서 리턴
        List<Board> articles= new ArrayList<>();
        for (int boardNo : boardMap.keySet()){
            Board article = boardMap.get(boardNo);
            articles.add(article);
        }
        return articles;
    }

    //map을 반복문으로 돌려서 value만 싹 빼서 리스트에 담아서 리턴


    @Override
    public void insertArticle(Board article) {
        boardMap.put(article.getBoardNo(),article);
        System.out.println(boardMap);
    }

    @Override
    public void deleteArticle(int boardNo) {
        boardMap.remove(boardNo);
    }

    @Override
    public Board getContent(int boardNo) {
        return boardMap.get(boardNo);
    }

    @Override
    public void modifyArticle(Board article) {
        boardMap.put(article.getBoardNo(),article);
    }
}
