package zuweie.bankoo.co.helloworld;

/**
 * Created by Vince on 2017/9/8.
 */

import android.content.Context;
import android.os.Handler;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CAPTON on 2016/11/25.
 */
//访问目标网址，得到json数据，保存List<Student>数据，等待传入JsonAdapter
public class JsonThread extends Thread {
    Context context;
    ListView listView;
    String url;
    Handler handler;//关键参数 整个小项目中的核心之一，会在JsonThread和JsonAdapter，ImageThread中传递，用于更新UI界面
    List<Student> students;
    JsonAdapter jsonAdapter;

    public JsonThread(Context context, ListView listView, String url,Handler handler ) {
        this.context=context;
        this.listView=listView;
        this.url=url;
        this.handler=handler;
    }
    //从String中解析所需数据，如name，age，url，将他们装入Student中，再将Student逐条加入List<Student>中
    private  List<Student> getStudents(String data){
        List<Student> students=new ArrayList<Student>();
        try {
            JSONObject object=new JSONObject(data);
//            if(object.getInt("info")==1){
                JSONArray jsonArray=object.getJSONArray("novels");
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject studentObject= (JSONObject) jsonArray.get(i);
                    Student student=new Student();
                    student.novel_name=studentObject.getString("novel_name");
                    System.out.println(student.novel_name);
//                    student.age=studentObject.getInt("age");
//                    System.out.println(student.age);
                    student.nj_avatar=studentObject.getString("nj_avatar");
                    System.out.println(student.nj_avatar);
                    students.add(student);
                }
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  students;
    }

    @Override
    public void run() {

        //从网络中获取数据，转换为String类型
        StringBuffer result=new StringBuffer();
        try {
            URL Url=new URL(url);
            HttpURLConnection connection= (HttpURLConnection) Url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            InputStream inputStream=connection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new   InputStreamReader(inputStream));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                result.append(line);
            }
            System.out.println(result);
//            students=getStudents("{'data':1,'students':[{'name':'张三','age':22,'url':'http://static.firefoxchina.cn/img/201709/8_59b1edbde81610.jpg'},{'name':'李四','age':23,'url':'http://192.168.1.103/pictures/pic2.jpg'},{'name':'王五','age':26,'url':'http://192.168.1.103/pictures/pic3.jpg'},{'name':'刘流','age':32,'url':'http://192.168.1.103/pictures/pic4.jpg'},{'name':'陈曦','age':22,'url':'http://192.168.1.103/pictures/pic5.jpg'}]}");//调用解析方法
            students=getStudents(result.toString());//调用解析方法
            inputStream.close();
            bufferedReader.close();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    jsonAdapter=new JsonAdapter(context,handler,students); //传递关键参数MainActivity上下文对象context，MainActivity主线程的handler对象,处理好的List<Student>对象
                    listView.setAdapter(jsonAdapter);//为ListView绑定适配器
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
