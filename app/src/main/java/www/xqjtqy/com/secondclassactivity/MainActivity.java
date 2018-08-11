package www.xqjtqy.com.secondclassactivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myBtn = this.findViewById(R.id.button1);
        myBtn.setOnClickListener(v -> {
            Intent intent = new Intent("DisplayActivity.Action_START");
            startActivity(intent);
        });

    }


}


