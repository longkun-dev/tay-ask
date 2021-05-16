package com.ask.qa_service.common;

import java.util.UUID;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/14 11:32 PM
 */
public class UUIDUtils {

    /**
     * 生成32位UUID，无"-"
     * <p>
     * 例如: 98dbe4ef03beb3ea77d3d856808c7d67
     * </p>
     *
     * @return 无"-"的32位UUID
     */
    public static String randomUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成带"-"的36位UUID
     * <p>
     * 例如: 98dbe4ef-03be-b3ea-77d3-d856808c7d67
     * </p>
     *
     * @return 带"-"的36位UUID
     */
    public static String randomUUID36() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成全部大写的32位UUID，无"-"
     * <p>
     * 例如: 98DBE4EF03BEB3EA77D3D856808C7D67
     * </p>
     *
     * @return 无"-"全部大写的32位UUID
     */
    public static String randomUpperCaseUUID32() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

    /**
     * 生成全部大写的带"-"的36位UUID
     * <p>
     * 例如: 98DBE4EF-03BE-B3EA-77D3-D856808C7D67
     * </p>
     *
     * @return 带"-"全部大写的36位UUID
     */
    public static String randomUpperCaseUUID36() {
        return UUID.randomUUID().toString().toUpperCase();
    }
}
