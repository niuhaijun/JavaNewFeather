package java8.future.cascadeapi.obj;

/**
 * @author niuhaijun
 * @date 2018/12/6 11:38
 */
public class ObjOne {
  private String id ;
  private String teacherId;

  public ObjOne(String id, String teacherId) {

    this.id = id;
    this.teacherId = teacherId;
  }

  public ObjOne() {

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
}
