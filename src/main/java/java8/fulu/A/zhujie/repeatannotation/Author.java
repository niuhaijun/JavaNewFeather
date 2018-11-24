package java8.fulu.a.zhujie.repeatannotation;

import java.lang.annotation.Repeatable;

/**
 * 可重复注解：可以声明多次的注解
 *
 * 实现步骤
 *    1、定义会被多次声明的注解，并在该注解上标注@Repeatable（XXX.class）
 *    2、定义一个名为{XXX}的注解，
 *
 * @author niuhaijun
 * @date 2018/11/17 15:32
 */
@Repeatable(value = Authors.class)
public @interface Author {

  String name();
}
