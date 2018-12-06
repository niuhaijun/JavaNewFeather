package java8.future.cascadeapi.obj;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:41
 */
public class ObjThree {

  private String pictureId;
  private String pictureUrl;

  public ObjThree(String pictureId, String pictureUrl) {

    this.pictureId = pictureId;
    this.pictureUrl = pictureUrl;
  }

  public ObjThree() {

  }

  public String getPictureId() {

    return pictureId;
  }

  public void setPictureId(String pictureId) {

    this.pictureId = pictureId;
  }

  public String getPictureUrl() {

    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {

    this.pictureUrl = pictureUrl;
  }
}
