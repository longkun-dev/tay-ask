package com.ask.qa_service.controller;

import com.ask.qa_service.common.ResponseEntity;
import com.ask.qa_service.common.ResponseUtils;
import com.ask.qa_service.entity.po.AskQuestionPo;
import com.ask.qa_service.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/30 11:54 PM
 */
@Api(tags = "问题接口")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @ApiOperation(value = "创建问题", notes = "创建新问题")
    @ApiParam(name = "questionPo", required = true)
    @PostMapping("/new")
    public ResponseEntity<String> newQuestion(@RequestBody AskQuestionPo questionPo) {
        String resultMsg = questionService.newQuestion(questionPo);
        if (StringUtils.isNotEmpty(resultMsg) && !resultMsg.contains("失败")) {
            return ResponseUtils.success(resultMsg);
        } else {
            return ResponseUtils.error(resultMsg);
        }
    }

    @ApiOperation(value = "获取问题编号为question的问题的信息", notes = "获取问题编号为question的问题的信息")
    @ApiParam(name = "questionNo", required = true)
    @GetMapping("/question/{questionNo}")
    public ResponseEntity<AskQuestionPo> getQuestion(@PathVariable("questionNo") String questionNo) {
        return ResponseUtils.success(questionService.getQuestion(questionNo));
    }
}
