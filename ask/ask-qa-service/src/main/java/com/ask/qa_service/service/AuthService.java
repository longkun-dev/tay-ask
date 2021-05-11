package com.ask.qa_service.service;

import com.ask.qa_service.entity.po.AskUserPo;

/**
 * 用户身份认证接口
 *
 * @author zhulongkun20@163.com
 * @since 2021/5/9 4:23 PM
 */
public interface AuthService {

    /**
     * 登录接口
     *
     * @param userPo userId 和 password
     * @return 登录成功或错误信息
     */
    String login(AskUserPo userPo);

}
