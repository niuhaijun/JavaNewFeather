package java8.future.cascadeapi.obj;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:43
 */
public class ObjEnd {

  private String id;
  private String teacherId;
  private String teacherName;
  private String pictureId;
  private String pictureUrl;

  public ObjEnd(String id, String teacherId, String teacherName, String pictureId,
      String pictureUrl) {

    this.id = id;
    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.pictureId = pictureId;
    this.pictureUrl = pictureUrl;
  }

  public ObjEnd() {

  }

  public String getId() {

    return id;
  }

  public void setId(String id) {

    this.id = id;
  }

  public String getTeacherId() {

    return teacherId;
  }

  public void setTeacherId(String teacherId) {

    this.teacherId = teacherId;
  }

  public String getTeacherName() {

    return teacherName;
  }

  public void setTeacherName(String teacherName) {

    this.teacherName = teacherName;
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
