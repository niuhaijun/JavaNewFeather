package designpattern.observerpattern;

/**
 * @author niuhaijun
 * @date 2018/12/26 15:07
 */
public class NasaObserver implements LandingObserver {

  @Override
  public void observeLanding(String name) {

    if (name.contains("Apollo")) {
      System.out.println("We made it!");
    }
  }
}
