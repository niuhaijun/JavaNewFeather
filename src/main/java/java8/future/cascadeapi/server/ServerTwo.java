package java8.future.cascadeapi.server;


import static java8.future.cascadeapi.obj.ConstantMap.TWO_MAP;

import java8.future.cascadeapi.obj.ObjTwo;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:58
 */
public class ServerTwo {

  public static ObjTwo get(String id) {

//    DelayServer.randomDelay();
    DelayServer.fixedDelay();
    return TWO_MAP.get(id);
  }
}
