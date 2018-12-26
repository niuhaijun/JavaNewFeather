package designpattern.commanderpattern;

/**
 * @author niuhaijun
 * @date 2018/12/26 12:10
 */
public class TextEditor implements Editor {

  @Override
  public void save() {

    System.out.println("save");
  }

  @Override
  public void open() {

    System.out.println("open");
  }

  @Override
  public void close() {

    System.out.println("close");

  }
}
