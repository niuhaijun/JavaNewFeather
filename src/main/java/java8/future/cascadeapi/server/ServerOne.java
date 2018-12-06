package java8.future.cascadeapi.server;

import static java8.future.cascadeapi.obj.ConstantMap.ONE_MAP;

import java8.future.cascadeapi.obj.ObjOne;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:37
 */
public class ServerOne {

  public static ObjOne get(String id) {

//    DelayServer.randomDelay();
    DelayServer.fixedDelay();
    return ONE_MAP.get(id);

  }
}
