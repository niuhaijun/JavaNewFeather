package java8.future.cascadeapi.server;

import static java8.future.cascadeapi.obj.ConstantMap.THREE_MAP;

import java8.future.cascadeapi.obj.ObjThree;

/**
 * @author niuhaijun
 * @date 2018/12/6 12:00
 */
public class ServerThree {

  public static ObjThree get(String id) {

//    DelayServer.randomDelay();
    DelayServer.fixedDelay();
    return THREE_MAP.get(id);
  }
}
