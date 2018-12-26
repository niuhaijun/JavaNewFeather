package designpattern.commanderpattern;


/**
 * @author niuhaijun
 * @date 2018/12/26 12:04
 */
public class CloseAction implements Action {

  private final Editor editor;

  public CloseAction(Editor editor) {

    this.editor = editor;
  }

  @Override
  public void perform() {
    editor.close();
  }
}
