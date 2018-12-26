package designpattern.commanderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuhaijun
 * @date 2018/12/26 12:06
 */
public class Macro {

  private final List<Action> actions;

  public Macro() {

    actions = new ArrayList<>();
  }

  public void record(Action action) {

    actions.add(action);
  }

  public void run() {

    actions.forEach(Action::perform);
  }
}
