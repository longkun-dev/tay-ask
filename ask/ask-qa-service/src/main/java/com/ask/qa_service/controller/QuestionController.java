package com.ask.qa_service.controller;

import com.ask.qa_service.common.ResponseEntity;
import com.ask.qa_service.common.ResponseUtils;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.service.QuestionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:54 PM
 */
@RestController
@RequestMapping("/")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @PostMapping("/question")
    public ResponseEntity<String> newQuestion(@RequestBody AskQuestionPo questionPo) {
        String resultMsg = questionService.newQuestion(questionPo);
        if (StringUtils.isNotEmpty(resultMsg) && !resultMsg.contains("失败")) {
            return ResponseUtils.success(resultMsg);
        } else {
            return ResponseUtils.error(resultMsg);
        }
    }

    @DeleteMapping("/question/{questionNo}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("questionNo") String questionNo) {
        return null;
    }
}
