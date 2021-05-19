package com.ask.qa_service.local;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/19 23:47
 */
public class Test {

    @org.junit.Test
    public void test1() {
        String value = "Q20210514123459";
        String substring = value.substring(0, 9);
        System.out.println(substring);
    }
}
