package www.xqjtqy.com.secondclassactivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class DisplayActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();
    static int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        try {

            new Thread(() -> {
                final String res = MainApi.getApi();

                mHandler.post(() -> {
                    MainApi.parseJSONWithJSONObject(res);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1, MainApi.nameData);
                    ListView listView = findViewById(R.id.list_view);
                    listView.setAdapter(adapter);
                    Toast.makeText(DisplayActivity.this, "共有" + MainApi.returnCode[0] + "个活动，返回值为" + MainApi.returnCode[1], Toast.LENGTH_LONG).show();
                    listView.setOnItemClickListener((parent, view, position, id) -> {
                        pos = position;
                        Intent intent = new Intent("DetailActivity.Action_START");
                        startActivity(intent);

                    });


                });
            }).start();
        } catch (Exception npe) {
            Toast.makeText(DisplayActivity.this, "获取失败！", Toast.LENGTH_SHORT).show();
        }
    }


}
