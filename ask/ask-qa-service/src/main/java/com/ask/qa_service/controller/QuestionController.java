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
@Api(tags = "问题api")
@RestController
@RequestMapping("/")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @ApiOperation(value = "创建新的问题", notes = "创建一个新的问题")
    @ApiParam(name = "问题是实体类", value = "questionPo")
    @PostMapping("/question")
    public ResponseEntity<String> newQuestion(@RequestBody AskQuestionPo questionPo) {
        String resultMsg = questionService.newQuestion(questionPo);
        if (StringUtils.isNotEmpty(resultMsg) && !resultMsg.contains("失败")) {
            return ResponseUtils.success(resultMsg);
        } else {
            return ResponseUtils.error(resultMsg);
        }
    }

    @ApiOperation(value = "根据问题编号删除一个问题", notes = "根据问题编号删除一个问题")
    @ApiParam(name = "问题编号", value = "questionNo")
    @DeleteMapping("/question/{questionNo}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("questionNo") String questionNo) {
        return null;
    }
}
