package javacoretechnology36course.teach06;

import java.lang.reflect.Proxy;

/**
 * @author niuhaijun
 * @date 2018/12/12 11:38
 */
public class MyDynamicProxy {

  public static void main(String[] args) {

    HelloImpl hello = new HelloImpl();

    MyInvocationHandler handler = new MyInvocationHandler(hello);

    Hello proxyHello = (Hello) Proxy
        .newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(),
            handler);

    proxyHello.sayHello();
  }

}
