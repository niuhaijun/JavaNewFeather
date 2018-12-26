package designpattern.commanderpattern;

import org.junit.Test;

/**
 * 命令者模式
 *
 * @author niuhaijun
 * @date 2018/12/26 12:07
 */
public class CommanderModeTest {

  @Test
  public void test() {

    Macro macro = new Macro();
    Editor editor = new TextEditor();
    /**
     * old
     */
    macro.record(new OpenAction(editor));
    macro.record(new SaveAction(editor));
    macro.record(new CloseAction(editor));
    /**
     * new
     */
    macro.record(editor::open);
    macro.record(editor::save);
    macro.record(editor::close);
    macro.run();
  }
}
