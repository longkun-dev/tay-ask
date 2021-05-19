package com.ask.qa_service.service.impl;

import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/14 11:20 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class QuestionServiceImplTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void newQuestionTest() {
        AskQuestionPo questionPo = new AskQuestionPo();
        questionPo.setQuestionTitle("测试问题标题");
        questionPo.setQuestionContent("为什么先上车的人不想让后来的人上车？");
        questionPo.setTags("标签1;标签2;标签3");
        questionService.newQuestion(questionPo);
    }

    @Test
    public void generateQuestionIdTest() {
        String questionId = "Q20210514123456";
        String result = questionId.substring(0, 9);
        System.out.println(result);
        System.out.println(Integer.parseInt(questionId.substring(9)) + 1);
    }

    @Test
    public void generateQuestionNoTest() {
        String questionNo = questionService.generateQuestionNo();
        log.info("questionNo: {}", questionNo);
    }
}