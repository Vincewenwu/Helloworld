package zuweie.bankoo.co.helloworld;

/**
 * Created by Vince on 2017/9/8.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CAPTON on 2016/11/25.
 */
// 适配器，等待被JsonThread调用

public class JsonAdapter extends BaseAdapter {

    List<Student> students;
    Context context;
    LayoutInflater inflater;
    Handler handler;

    public JsonAdapter(Context context,Handler handler,List<Student> students) {
        this.handler=handler;
        this.context=context;
        this.students=students;
//        对于LayoutInflater一定不会陌生，都会知道它主要是用于加载布局的
        inflater=LayoutInflater.from(context);//从MainActivity中上下文对象中获取LayoutInflater；所以说这个context,和handler对象很重要，贯穿整项目
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //重写getView方法，即设置ListView每一项的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if(convertView==null){
            convertView=inflater.inflate(R.layout.student,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);//设置tag
        }else {
            holder= (ViewHolder) convertView.getTag(); //获取tag
        }
//        System.out.println(String.valueOf(students.get(position).age));//测试数据是否正常
//        holder.age.setText(String.valueOf(students.get(position).age));
        holder.name.setText(students.get(position).novel_name);
        System.out.println(students.get(position).novel_name);
        new ImageThread(students.get(position).nj_avatar, handler,holder.image).start();//开启新线程下载图片并在新线程中更新UI，所以要传递handler对象
        return convertView;
    }

    //用于暂时保存视图对象
    class ViewHolder{
        public TextView name;
        public TextView age;
        public ImageView image;

        public ViewHolder(View view){
            name= (TextView) view.findViewById(R.id.name);
            age= (TextView) view.findViewById(R.id.age);
            image= (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
