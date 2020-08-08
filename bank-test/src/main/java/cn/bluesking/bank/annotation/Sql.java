package cn.bluesking.bank.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在测试类或测试方法上添加的注解，用于声明执行 SQL。
 *
 * @author 随心
 * @date 2020/8/2
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sql {

    @AliasFor("scripts")
    String[] value() default {};

    @AliasFor("value")
    String[] scripts() default {};

    String[] statements() default {};

}
