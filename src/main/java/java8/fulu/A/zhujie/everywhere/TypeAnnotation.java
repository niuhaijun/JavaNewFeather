package java8.fulu.a.zhujie.everywhere;

import com.sun.istack.internal.NotNull;

/**
 * 类型注解，顾名思义就是可以当作"类型"使用了。
 *    从java8开始，注解已经能应用于任何类型（最好的例子就是集合类）
 *    其中包括
 *        1、new操作符
 *        2、类型转换
 *        3、instanceof检查
 *        4、泛型类型参数
 *        5、implements
 *        6、throws子句
 *
 * @author niuhaijun
 * @date 2018/11/17 16:04
 */
public class TypeAnnotation {

  public static void main(String[] args) {

    @NotNull String name = null;
  }
}
