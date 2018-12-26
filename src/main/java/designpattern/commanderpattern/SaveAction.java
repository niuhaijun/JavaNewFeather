package designpattern.commanderpattern;

/**
 * @author niuhaijun
 * @date 2018/12/26 12:02
 */
public class SaveAction implements Action {

  private final Editor editor;

  public SaveAction(Editor editor) {

    this.editor = editor;
  }

  @Override
  public void perform() {

    editor.save();
  }
}