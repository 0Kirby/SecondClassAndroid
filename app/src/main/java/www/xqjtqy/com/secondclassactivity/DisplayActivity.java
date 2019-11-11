package www.xqjtqy.com.secondclassactivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class DisplayActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();
    static int pos = 0;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        setContentView(R.layout.activity_display);
        progressBar = findViewById(R.id.progress_bar);


        new Thread(() -> {
            try {
                final String res = MainApi.getApi();
                if (MainApi.error) {
                    mHandler.post(() -> {
                        Toast.makeText(DisplayActivity.this, "获取失败！请返回并再试一次！", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    });
                    MainApi.error = false;

                } else
                    mHandler.post(() -> {
                        progressBar.setVisibility(View.GONE);
                        MainApi.parseJSONWithJSONObject(res);
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1, MainApi.nameData);
                        ListView listView = findViewById(R.id.list_view);
                        listView.setAdapter(adapter);
                        Toast.makeText(DisplayActivity.this, "本活动"+MainApi.returnCode[1] + "！共有" + MainApi.returnCode[0] + "个活动！", Toast.LENGTH_LONG).show();
                        listView.setOnItemClickListener((parent, view, position, id) -> {
                            pos = position;
                            Intent intent = new Intent("DetailActivity.Action_START");
                            startActivity(intent);

                        });


                    });

            } catch (Exception npe) {
                npe.printStackTrace();
                Toast.makeText(DisplayActivity.this, "获取失败！", Toast.LENGTH_SHORT).show();
            }
        }).start();
    }
}




