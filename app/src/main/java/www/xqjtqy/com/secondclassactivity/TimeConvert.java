package www.xqjtqy.com.secondclassactivity;

import java.util.Calendar;

public class TimeConvert {

    private String t;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    TimeConvert(){

    }

    TimeConvert(String t){
        this.t=t;
    }

    public String Convert() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((Long.parseLong(this.t)));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        return (year + "年" + (month + 1) + "月" + day + "日"
                + hour + "时" + minute + "分" + second + "秒");
    }
}
