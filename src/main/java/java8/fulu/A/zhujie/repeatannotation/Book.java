package java8.fulu.a.zhujie.repeatannotation;

/**
 * @author niuhaijun
 * @date 2018/11/17 15:35
 */
@Author(name = "牛海军")
@Author(name = "黄文君")
public class Book {

  private String time;

  private String old;

  public String getTime() {

    return time;
  }

  public void setTime(String time) {

    this.time = time;
  }

  public String getOld() {

    return old;
  }

  public void setOld(String old) {

    this.old = old;
  }
}
