package com.ask.qa_service.common;

import java.lang.annotation.*;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/13 12:15 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    String value() default "";

}
