package designpattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niuhaijun
 * @date 2018/12/26 15:07
 */
public class Moon {

  private final List<LandingObserver> observers = new ArrayList<>();

  public void land(String name) {

    for (LandingObserver observer : observers) {
      observer.observeLanding(name);
    }
  }

  public void startSpying(LandingObserver observer) {

    observers.add(observer);
  }
}
