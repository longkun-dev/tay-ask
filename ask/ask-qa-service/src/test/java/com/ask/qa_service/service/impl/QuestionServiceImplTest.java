package com.ask.qa_service.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/14 11:20 PM
 */
public class QuestionServiceImplTest {

    @Test
    public void newQuestion() {
    }

    @Test
    public void generateQuestionIdTest() {
        String questionId = "Q20210514123456";
        String result = questionId.substring(0, 9);
        System.out.println(result);
        System.out.println(Integer.parseInt(questionId.substring(9)) + 1);
    }
}