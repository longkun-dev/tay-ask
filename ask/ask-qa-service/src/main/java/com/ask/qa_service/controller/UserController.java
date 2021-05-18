package com.ask.qa_service.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhulongkun20@163.com
 * @since 2021/4/26 9:54 PM
 */
@Api(tags = "User Api")
@RestController
@RequestMapping("/test")
public class UserController {

//    @Value("${config.param1}")
    private String param1;

    @GetMapping("/param1")
    public String getParam1() {
        return param1;
    }
}
