package www.xqjtqy.com.secondclassactivity;
import www.xqjtqy.com.secondclassactivity.common.Credential;
import www.xqjtqy.com.secondclassactivity.common.exception.TencentCloudSDKException;

import www.xqjtqy.com.secondclassactivity.scf.v20180416.ScfClient;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeRequest;
import www.xqjtqy.com.secondclassactivity.scf.v20180416.models.InvokeResponse;
public class MainApi {

    public static String getApi(){
        String re;
        try{
            Credential cre = new Credential("AKIDIOEo8Dddy3sDKCxFOO9gy2rXyA7qeceQ","f5F9oDQO8dtviGafU3MPBk7E5h271f29");
            ScfClient client = new ScfClient(cre, "ap-guangzhou");
            InvokeRequest inrq = new InvokeRequest();
            inrq.setFunctionName("Hello");
            inrq.setLogType("Tail");
            InvokeResponse inrs = client.Invoke(inrq);
            re = InvokeResponse.toJsonString(inrs);
        }
        catch (TencentCloudSDKException e) {
            re =e.toString();
        }
        return re;
    }

}
