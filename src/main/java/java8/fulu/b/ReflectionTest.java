package java8.fulu.b;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/11/28 23:21
 */
public class ReflectionTest {

  public void print(final String name) {

    System.out.println(name);
  }

  @Test
  public void test() {

    Class<ReflectionTest> clazz = ReflectionTest.class;
    Method[] methods = clazz.getMethods();
    Method method = methods[0];

    System.out.println(method.getName());
    Parameter[] parameters = method.getParameters();

    System.out.println(parameters[0].getType().getName());
  }
}
