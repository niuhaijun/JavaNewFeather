package javacoretechnology36course.teach06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author niuhaijun
 * @date 2018/12/12 11:34
 */
public class MyInvocationHandler implements InvocationHandler {

  private Object target;

  public MyInvocationHandler(Object target) {

    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println("invoking sayHello");

    Object result = method.invoke(target, args);

    return result;
  }
}
