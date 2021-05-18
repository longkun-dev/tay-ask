package com.ask.qa_service.aspect;

import com.ask.qa_service.constant.RoleEnum;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/18 21:53
 */
public class PermissionCheckAspectTest {

    @Test
    public void arrayTest() {
        RoleEnum[] roleEnums = new RoleEnum[2];
        roleEnums[0] = RoleEnum.R_USER;
        roleEnums[1] = RoleEnum.R_ADMIN;
        String[] roles = (String[]) Arrays.stream(roleEnums).map(RoleEnum::getRoleCode).toArray();
        System.out.println(Arrays.toString(roles));
    }
}