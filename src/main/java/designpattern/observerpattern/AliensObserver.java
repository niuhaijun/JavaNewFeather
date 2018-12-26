package designpattern.observerpattern;

/**
 * @author niuhaijun
 * @date 2018/12/26 15:06
 */

public class AliensObserver implements LandingObserver {

  @Override
  public void observeLanding(String name) {

    if (name.contains("Apollo")) {
      System.out.println("They're distracted, lets invade earth!");
    }
  }
}
