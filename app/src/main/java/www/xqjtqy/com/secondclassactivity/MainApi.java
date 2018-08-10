package www.xqjtqy.com.secondclassactivity;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import www.xqjtqy.com.secondclassactivity.common.Credential;
import www.xqjtqy.com.secondclassactivity.common.exception.TencentCloudSDKException;

import www.xqjtqy.com.secondclassactivity.scf.v20180416.ScfClient;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeRequest;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeResponse;

public class MainApi {
    static String [] idData = new String[10];
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
        }
        return re;
    }

    public static void parseJSONWithJSONObject(String re) {
        String id;
//        String rs="";
        try {
            re = "["+re+"]" ;
//            JSONArray jsonArray = new JSONArray(re);
//            for (int i = 0 ; i< jsonArray.length() ; i++){
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                result = jsonObject.getString("Result");
//                Log.d("JSTS", result);
//            }
//            result = "["+result+"]";
//            JSONArray jsonArray1 = new JSONArray(result);
//            for (int j = 0 ; j<jsonArray1.length() ; j++){
//                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
//                rs = jsonObject1.getString("Log");
//                Log.d("JSTS2", "logb"+rs);
//            }
            String data = re.substring(re.indexOf("[{'id'"),re.indexOf("}]")+2);
            Log.d("JSTS3",data);
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0 ; i< jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("id");
                Log.d("JSTS", id);
                idData[i]=id;
            }



        } catch (Exception e) {
            e.printStackTrace();
        }




    }


}
