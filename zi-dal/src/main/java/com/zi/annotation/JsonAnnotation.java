package com.zi.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/8/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface JsonAnnotation {
    public String value() default "";
}
