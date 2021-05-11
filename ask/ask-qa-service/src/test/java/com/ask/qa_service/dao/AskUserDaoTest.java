package com.ask.qa_service.dao;

import com.ask.qa_service.entity.po.AskUserPo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/11 11:54 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AskUserDaoTest {

    @Autowired
    private AskUserDao askUserDao;

    @Test
    public void queryByUserId() {
        AskUserPo askUserPo = askUserDao.queryByUserId("U0001");
        assertNotNull(askUserPo);
        log.info("userInfo: {}", askUserPo);
    }
}