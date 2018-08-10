package www.xqjtqy.com.secondclassactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();
    String [] Data={"12345","67890"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        new Thread(() -> {
            final String res = MainApi.getApi();
            mHandler.post(()->{
                Toast.makeText(DisplayActivity.this, "成功！", Toast.LENGTH_LONG).show();
                MainApi.parseJSONWithJSONObject(res);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(DisplayActivity.this, android.R.layout.simple_list_item_1,MainApi.idData);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(adapter);
            });
        }).start();
    }
}
