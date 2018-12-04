package daily.alibabfastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author niuhaijun
 * @date 2018/12/4 11:43
 */
public class JsonArrayTest {

  @Test
  public void test() {

    String jsonStr = "{\n"
        + "  \"body\": [\n"
        + "    {\n"
        + "      \"classId\": \"ff80808166d52a250166e70895f936de\",\n"
        + "      \"left\": \"410\",\n"
        + "      \"teacher\": \"2年级语文辅导老师03\",\n"
        + "      \"teacherId\": \"ff8080815e9b859b015e9e5db80f1285_0\",\n"
        + "      \"tutorRealname\": \"2年级语文辅导老师03\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"classId\": \"ff80808166d52a250166e70895f936de\",\n"
        + "      \"left\": \"410\",\n"
        + "      \"teacher\": \"2年级语文辅导老师03\",\n"
        + "      \"teacherId\": \"ff8080815e9b859b015e9e5db80f1285_1\",\n"
        + "      \"tutorRealname\": \"2年级语文辅导老师03\"\n"
        + "    },\n"
        + "    {\n"
        + "      \"classId\": \"ff80808166d52a250166e70895f936de\",\n"
        + "      \"left\": \"410\",\n"
        + "      \"teacher\": \"2年级语文辅导老师03\",\n"
        + "      \"teacherId\": \"ff8080815e9b859b015e9e5db80f1285_2\",\n"
        + "      \"tutorRealname\": \"2年级语文辅导老师03\"\n"
        + "    }\n"
        + "  ],\n"
        + "  \"retcode\": 200,\n"
        + "  \"retdesc\": \"ok\"\n"
        + "}";

    int splitSize = 2;

    JSONObject obj = JSON.parseObject(jsonStr);
    JSONArray data = obj.getJSONArray("body");
    List<String> teaIdList = new ArrayList<>(data.size() / splitSize + 1);
    StringBuilder builder = new StringBuilder(",");
    for (int index = 0; index < data.size(); index++) {
      JSONObject object = data.getJSONObject(index);
      String teacherId = object.getString("teacherId");

      if (teacherId == null || teacherId.length() < 1) {
        continue;
      }

      builder.append(teacherId + ",");

      if (index != 0 && (index + 1) % splitSize == 0) {
        teaIdList.add(builder.substring(1, builder.length() - 1));
        builder = new StringBuilder(",");
      }
    }

    if (builder.length() > 1) {
      teaIdList.add(builder.substring(1, builder.length() - 1));
    }

    teaIdList.stream().forEach(System.out::println);

    /**
     * 修改JSON对象
     */
    for (int i = 0; i < data.size(); i++) {
      JSONObject object = data.getJSONObject(i);
      object.put("padTutorUrl", "abc");
    }

    System.out.println(data);

  }

  @Test
  public void test1() {
    //language=JSON
    String result = "{\n"
        + "  \"code\": \"10000\",\n"
        + "  \"data\": {\n"
        + "    \"teacherList\": [\n"
        + "      {\n"
        + "        \"accountType\": 0,\n"
        + "        \"branchTeaId\": \"1a9dc0d4a1f5499f976378f747e54625\",\n"
        + "        \"createDate\": 1520313888000,\n"
        + "        \"empNo\": \"XN006435\",\n"
        + "        \"enterpriseEmail\": \"XN006435@xn.com\",\n"
        + "        \"experience\": \"\",\n"
        + "        \"features\": \"\",\n"
        + "        \"isWebShow\": 1,\n"
        + "        \"jobtypeId\": \"33\",\n"
        + "        \"jobtypeName\": \"全职\",\n"
        + "        \"modifyDate\": 1520313888000,\n"
        + "        \"phone\": \"\",\n"
        + "        \"pictureUrl\": \"\",\n"
        + "        \"qualificationCertificate\": \"20134435527549410\",\n"
        + "        \"randomPasswordTime\": 1528096989000,\n"
        + "        \"realName\": \"吕江仪\",\n"
        + "        \"sex\": 0,\n"
        + "        \"state\": 0,\n"
        + "        \"sysName\": \"吕江仪\",\n"
        + "        \"teachResult\": \"\",\n"
        + "        \"teacherCardNumberPassword\": \"51cf08a99f67c60d84f5d08b777e0f70\"\n"
        + "      },\n"
        + "      {\n"
        + "        \"accountType\": 0,\n"
        + "        \"branchTeaId\": \"2bc8af7074454bf3b300a300a9f46349\",\n"
        + "        \"comment\": \"\",\n"
        + "        \"createDate\": 1528182957000,\n"
        + "        \"empNo\": \"XN007812\",\n"
        + "        \"enterpriseEmail\": \"XN007812@xuni.com\",\n"
        + "        \"experience\": \"\",\n"
        + "        \"features\": \"\",\n"
        + "        \"graduationSchool\": \"\",\n"
        + "        \"modifyDate\": 1540881777000,\n"
        + "        \"phone\": \"13581951079\",\n"
        + "        \"pictureUrl\": \"\",\n"
        + "        \"profession\": \"\",\n"
        + "        \"randomPasswordTime\": 1528182956000,\n"
        + "        \"realName\": \"张雪冬\",\n"
        + "        \"schoolDegreeName\": \"\",\n"
        + "        \"state\": 0,\n"
        + "        \"sysName\": \"张雪冬\",\n"
        + "        \"teachResult\": \"\",\n"
        + "        \"teacherCardNumberPassword\": \"fe008700f25cb28940ca8ed91b23b354\"\n"
        + "      }\n"
        + "    ]\n"
        + "  },\n"
        + "  \"message\": \"操作成功\",\n"
        + "  \"rlt\": true\n"
        + "}";

    List<JSONObject> tutorInfoList = new ArrayList<>();
    JSONObject obj = JSON.parseObject(result);

    if (!"10000".equals(obj.getString("code"))) {
    }

    JSONObject dataOfObj = obj.getJSONObject("data");
    JSONArray teacherListOfData = dataOfObj.getJSONArray("teacherList");
    for (int i = 0; i < teacherListOfData.size(); i++) {
      tutorInfoList.add(teacherListOfData.getJSONObject(i));
    }

    System.out.println(tutorInfoList.size());
  }

}
