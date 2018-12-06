package java8.future.cascadeapi.obj;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:40
 */
public class ObjTwo {

  private String teacherId;
  private String teacherName;
  private String pictureId;

  public ObjTwo(String teacherId, String teacherName, String pictureId) {

    this.teacherId = teacherId;
    this.teacherName = teacherName;
    this.pictureId = pictureId;
  }

  public ObjTwo() {

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
}
