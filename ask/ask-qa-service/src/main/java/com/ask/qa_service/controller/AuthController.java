package com.ask.qa_service.controller;

import com.ask.qa_service.common.ResponseEntity;
import com.ask.qa_service.common.ResponseUtils;
import com.ask.qa_service.entity.po.AskUserPo;
import com.ask.qa_service.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/11 11:40 PM
 */
@Api(tags = "Auth Api")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @ApiOperation(value = "登录接口", notes = "用户登录请求接口")
    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestBody AskUserPo userPo) {
        String result = authService.login(userPo);
        if (result.contains("失败")) {
            return ResponseUtils.error(result);
        } else {
            return ResponseUtils.success(result);
        }
    }
}
