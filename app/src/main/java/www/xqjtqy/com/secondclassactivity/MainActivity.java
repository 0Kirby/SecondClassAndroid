package www.xqjtqy.com.secondclassactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = this.findViewById(R.id.textView1);
        Button myBtn = this.findViewById(R.id.button1);
        myBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread() {
                    //在新线程中发送网络请求
                    public void run() {
                        final String res = MainApi.getApi();

                        mHandler.post(new Thread() {
                            public void run() {
                                txt.setMovementMethod(ScrollingMovementMethod.getInstance());
                                txt.setText(res);
                                Toast.makeText(MainActivity.this,"成功！" , Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }.start();


            }
        });
    }
}




