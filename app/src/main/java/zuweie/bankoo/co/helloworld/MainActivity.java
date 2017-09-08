package zuweie.bankoo.co.helloworld;

import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "MainActivity";
    }

    @Override
//    两个activity之间的通讯可以通过bundle类来实现
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        R.layout.main是个布局文件即控件都是如何摆放如何显示的，
// setContentView就是设置一个Activity的显示界面，这句话就是设置这个这句话所再的Activity
// 采用R.layout下的main布局文件搜索进行布局
        setContentView(R.layout.activity_main);

//        R.id.button是一个资源，你在layout中定义了一个button，
// 名字叫做button，在代码中就可以使用R.id.button来找到这个button对象的引用
        start_a = (Button) findViewById(R.id.start_a_btn);
        start_a_result = (Button) findViewById(R.id.start_a_result_btn);
        //start_a_result.setVisibility(View.INVISIBLE);
        start_a_implicit = (Button) findViewById(R.id.start_a_implicit_btn);
        //start_a_implicit.setVisibility(View.INVISIBLE);
        start_widget = (Button) findViewById(R.id.start_widget_btn);
        btn_listview = (Button) findViewById(R.id.btn_listview);

        start_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, AActivity.class);
                it.putExtra("param1", "started A Activity by MainActivity!");
                startActivity(it);
            }
        });

        start_a_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, AActivity.class);
                startActivityForResult(it, requestCodefromAtivity);
            }
        });

        start_a_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction("guangxin.zuweie.action.HELLO");
                //这个会崩溃
//                it.addCategory("guangxin.zuweie.category.HELLOCATEGORY");

// 监听到这个东西试试干嘛的，set进去   哦 使用来打电话的
                it.setAction(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:110"));


                //it.setAction(Intent.ACTION_VIEW);
                //it.setData(Uri.parse("http://baidu.com"));

//判断下有没有这个活动的预备就是AndroidManifest.xml的监听
                if (it.resolveActivity(getPackageManager())  != null){
                    startActivity(it);
                }else{
                    Toast.makeText(MainActivity.this, "没有处理该Action的Activity", Toast.LENGTH_LONG).show();
                }
                //startActivity(it);
            }
        });

        start_widget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, WidgetActivity.class);
                startActivity(it);
            }
        });
        btn_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, listctivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultcode, Intent data) {
        super.onActivityResult(requestCode, resultcode, data);
        if (resultcode == RESULT_OK){
            Toast.makeText(this, "requestCode "+requestCode+" result is ok " + data.getStringExtra("result"), Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "requestCode "+requestCode+" result is Cancel " + data.getStringExtra("result") , Toast.LENGTH_LONG).show();
        }
    }

    final int requestCodefromAtivity = 111;

    Button start_a, start_a_result, start_a_implicit, start_widget,btn_listview;
}
