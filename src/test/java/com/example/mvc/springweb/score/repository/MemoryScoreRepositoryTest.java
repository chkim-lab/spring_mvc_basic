package com.example.mvc.springweb.score.repository;

import com.example.mvc.springweb.score.domain.Score;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryScoreRepositoryTest {

    @Test
    void repoTest() {

        ScoreRepository repository = new MemoryScoreRepository();

        Score test1 = new Score();
        test1.setName("김철수");
        test1.setKor(100);
        test1.setEng(98);
        test1.setMath(87);

        Score test2 = new Score();
        test2.setName("박영희");
        test2.setKor(96);
        test2.setEng(85);
        test2.setMath(100);

        repository.insertScore(test1);
        repository.insertScore(test2);

        //전체 조회 테스트
        List<Score> scoreList = repository.selectAllScores();
        System.out.println(scoreList);

        //개별 조회 테스트
        Score selectOne = repository.selectOne(2);
        System.out.println("selectOne = " + selectOne);

        //삭제 테스트
        repository.deleteScore(1);

        Score delOne = repository.selectOne(1);
        System.out.println("delOne = " + delOne);

    }

}