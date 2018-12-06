package java8.future.cascadeapi.obj;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:45
 */
public class ConstantMap {

  public static Map<String, ObjOne> ONE_MAP = new HashMap<String, ObjOne>() {
    {
      put("111", new ObjOne("111", "aaa"));
      put("222", new ObjOne("222", "bbb"));
      put("333", new ObjOne("333", "ccc"));
      put("444", new ObjOne("444", "ddd"));
      put("555", new ObjOne("555", "eee"));
    }
  };

  public static Map<String, ObjTwo> TWO_MAP = new HashMap<String, ObjTwo>() {
    {
      put("aaa", new ObjTwo("aaa", "niu1", ",,,"));
      put("bbb", new ObjTwo("bbb", "niu2", "..."));
      put("ccc", new ObjTwo("ccc", "niu3", ";;;"));
      put("ddd", new ObjTwo("ddd", "niu4", ":::"));
      put("eee", new ObjTwo("eee", "niu5", "==="));
    }
  };

  public static Map<String, ObjThree> THREE_MAP = new HashMap<String, ObjThree>() {
    {
      put(",,,", new ObjThree(",,,", "picUrl1"));
      put("...", new ObjThree("...", "picUrl2"));
      put(";;;", new ObjThree(";;;", "picUrl3"));
      put(":::", new ObjThree(":::", "picUrl4"));
      put("===", new ObjThree("===", "picUrl5"));
    }
  };

}
