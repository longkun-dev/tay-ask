package com.ask.qa_service.controller;

import com.ask.qa_service.common.RequestUtils;
import com.ask.qa_service.common.ResponseEntity;
import com.ask.qa_service.common.ResponseUtils;
import com.ask.qa_service.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/19 23:00
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试用api")
public class TestController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "测试获取当前用户id", notes = "测试获取当前用户id")
    @GetMapping("/currentUser")
    public ResponseEntity<String> getCurrentUserId() {
        String currentUserId = RequestUtils.getCurrentUserId();
        return ResponseUtils.success(currentUserId);
    }
}
