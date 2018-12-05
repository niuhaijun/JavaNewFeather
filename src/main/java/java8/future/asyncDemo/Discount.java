package java8.future.asyncDemo;

/**
 * 远程服务
 *
 * @author niuhaijun
 * @date 2018/12/5 10:00
 */
public class Discount {

  public enum Code {

    NONE(0),
    SILVER(5),
    GOLD(10),
    PLATINUM(15),
    DIAMOND(20);


    private final int percentage;

    Code(int percentage) {

      this.percentage = percentage;
    }
  }

  /**
   * 计算商品折扣后的价格
   *
   * @param quote 集合体
   * @return 商品折扣后的价格
   */
  public static String applyDiscount(Quote quote) {

    return quote.getShopName() + " price is " + apply(quote.getPrice(), quote.getDiscountCode());
  }

  private static double apply(double price, Code coe) {

    Shop.delay();
    return price * (100 - coe.percentage) / 100;
  }

}
