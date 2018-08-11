package www.xqjtqy.com.secondclassactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    protected Handler mHandler = new Handler();
    String iData[] = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        try {
            iData[0] = "编号：" + MainApi.idData[DisplayActivity.pos];
            iData[1] = "名称：" + MainApi.nameData[DisplayActivity.pos];
            iData[2] = "分类：" + MainApi.categoryData[DisplayActivity.pos];
            iData[3] = "开始时间：" + new TimeConvert(MainApi.startData[DisplayActivity.pos]).Convert();
            iData[4] = "结束时间：" + new TimeConvert(MainApi.endData[DisplayActivity.pos]).Convert();
            iData[5] = "地址：" + MainApi.addrData[DisplayActivity.pos];
            iData[6] = "状态：" + MainApi.statusData[DisplayActivity.pos];
            iData[7] = "老师：" + MainApi.teacherData[DisplayActivity.pos];
            iData[8] = "学分：" + MainApi.creditData[DisplayActivity.pos];
            iData[9] = "详细地址：" + MainApi.dAddrData[DisplayActivity.pos];


            new Thread(() -> mHandler.post(() -> {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(DetailActivity.this, android.R.layout.simple_list_item_1, iData);
                ListView listView = findViewById(R.id.list_view2);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener((adapterView, view, position, id) -> {
                    Toast.makeText(DetailActivity.this, "已经到底啦！", Toast.LENGTH_SHORT).show();
                });
            })).start();
        } catch (Exception nep) {
            Toast.makeText(DetailActivity.this, "获取失败！", Toast.LENGTH_SHORT).show();

        }
    }


}
