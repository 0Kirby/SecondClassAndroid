package www.xqjtqy.com.secondclassactivity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import www.xqjtqy.com.secondclassactivity.common.Credential;
import www.xqjtqy.com.secondclassactivity.common.exception.TencentCloudSDKException;

import www.xqjtqy.com.secondclassactivity.scf.v20180416.ScfClient;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeRequest;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeResponse;

public class MainApi {
    static String[] idData = new String[10];
    static String[] nameData = new String[10];
    static String[] categoryData = new String[10];
    static String[] startData = new String[10];
    static String[] endData = new String[10];
    static String[] addrData = new String[10];
    static String[] statusData = new String[10];
    static String[] teacherData = new String[10];
    static String[] creditData = new String[10];
    static String[] dAddrData = new String[10];
    static String[] returnCode = new String[2];
    static boolean error = false;

    public static String getApi() {
        String re;
        try {
            Credential cre = new Credential("AKIDIOEo8Dddy3sDKCxFOO9gy2rXyA7qeceQ", "f5F9oDQO8dtviGafU3MPBk7E5h271f29");
            ScfClient client = new ScfClient(cre, "ap-guangzhou");
            InvokeRequest inrq = new InvokeRequest();
            inrq.setFunctionName("Hello");
            inrq.setLogType("Tail");
            InvokeResponse inrs = client.Invoke(inrq);
            re = InvokeResponse.toJsonString(inrs);

        } catch (TencentCloudSDKException e) {
            re = e.toString();
            error = true;
        }
        return re;
    }

    public static void parseJSONWithJSONObject(String re) {
        String id, name, category, startTime, endTime, addr, status, teacher, credit, detailAddress;
        try {
            String number = re.substring(re.indexOf("RetMsg\":\"["));
            returnCode[0] = number.substring(10, number.indexOf(","));
            returnCode[1] = number.substring(number.indexOf(", ") + 1, number.indexOf("]"));
        } catch (StringIndexOutOfBoundsException sioobe) {
            sioobe.printStackTrace();
        }
        try {
            re = "[" + re + "]";
            String data = re.substring(re.indexOf("[{'id'"), re.indexOf("}]") + 2);
            Log.d("JSTS3", data);
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("id");
                name = jsonObject.getString("name");
                category = jsonObject.getString("category");
                startTime = jsonObject.getString("startDate");
                endTime = jsonObject.getString("endDate");
                addr = jsonObject.getString("addr");
                status = jsonObject.getString("status");
                teacher = jsonObject.getString("teacher");
                credit = jsonObject.getString("credit");
                detailAddress = jsonObject.getString("detailAddress");
                Log.d("JSTS", id);
                Log.d("JSTS", name);
                idData[i] = id;
                nameData[i] = name;
                categoryData[i] = category;
                startData[i] = startTime;
                endData[i] = endTime;
                addrData[i] = addr;
                statusData[i] = status;
                teacherData[i] = teacher;
                creditData[i] = credit;
                dAddrData[i] = detailAddress;
            }

        }
     catch(
    JSONException je)

    {
        je.printStackTrace();
        getApi();
    }


}


}
