package designpattern.commanderpattern;

/**
 * @author niuhaijun
 * @date 2018/12/26 12:03
 */
public class OpenAction implements Action {

  private final Editor editor;

  public OpenAction(Editor editor) {

    this.editor = editor;
  }

  @Override
  public void perform() {

    editor.open();
  }
}
