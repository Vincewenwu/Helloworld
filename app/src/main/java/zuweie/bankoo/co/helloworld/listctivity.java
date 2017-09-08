package zuweie.bankoo.co.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listctivity extends BaseActivity {

    @Override
    public String getTag() {
        return "listctivity";
    }
    Context context=this;
    ListView listView;
    JsonAdapter jsonAdapter;
    String url="http://www.showfm.net/api/novel.asp";//这个url随你设置的php页面而变动。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        调到一个界面
        setContentView(R.layout.activity_listview);
//        List<Map<String,Object>> datalist=new ArrayList<Map<String,Object>>();
//        ListView lv=(ListView) findViewById(R.id.lv);
//
//        Map<String,Object> map1=new HashMap<String,Object>();
//        map1.put("image",R.mipmap.ic_launcher);
//        map1.put("title","AIDE资源");
//        map1.put("context","AIDE   资源  分享");
//        Map<String,Object> map2=new HashMap<String,Object>();
//        map2.put("image",R.mipmap.ic_launcher);
//        map2.put("title","了解AIDE");
//        map2.put("context","AIDE   了解  分享");
//        Map<String,Object> map3=new HashMap<String,Object>();
//        map3.put("image",R.mipmap.ic_launcher);
//        map3.put("title","玩转AIDE");
//        map3.put("context","AIDE   玩转  分享");
//        Map<String,Object> map4=new HashMap<String,Object>();
//        map4.put("image",R.mipmap.ic_launcher);
//        map4.put("title","控件之TextView");
//        map4.put("context","AIDE   TextView  分享");
//
//        datalist.add(map1);
//        datalist.add(map2);
//        datalist.add(map3);
//        datalist.add(map4);
//
//        lv.setAdapter(new SimpleAdapter(this,datalist,R.layout.list_item,new String[]{"image","title","context"},new int[]{R.id.image,R.id.title,R.id.context}));
//        lv.setOnItemClickListener(new OnItemClickListener(){
//            //list点击事件
//            @Override
//            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
//            {
//                // TODO: Implement this method
//                switch(p3){
//                    case 0://第一个item
//                        Toast.makeText(listctivity.this,"AIDE   资源  分享",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 1://第二个item
//                        Toast.makeText(listctivity.this,"AIDE   了解  分享",Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2://第三个item
//                        Toast.makeText(listctivity.this,"AIDE   玩转  分享",Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//
//
//        });
//        这是静态listview



//        Intent it = new Intent();
//        it.putExtra("result", "something not ok");
//        setResult(RESULT_CANCELED, it);
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AActivity.this.finish();
//            }
//        }, 5000); zh
        listView= (ListView) findViewById(R.id.listview);
        handler=new Handler();//获得一个handler对象，为后面的各个线程提供处理UI的依据
        new JsonThread(context, listView, url,handler).start();
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
                setTitle("你点击了第"+arg2+"行");//设置标题栏显示点击的行
            }
        });

    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
    }

    Button start_b_btn;
    Handler handler = new Handler();
}
