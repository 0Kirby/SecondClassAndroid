package www.xqjtqy.com.secondclassactivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.lang.Thread.*;

public class CrashHandler implements UncaughtExceptionHandler {
    private static CrashHandler INSTANCE = new CrashHandler();
    private Context mContext;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);

    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        new Thread() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, MainActivity.class);
                PendingIntent restartIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
                );
                AlarmManager mgr = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, restartIntent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }.start();
    }
}