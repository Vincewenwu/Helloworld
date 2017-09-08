package zuweie.bankoo.co.helloworld;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "A Activity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        调到一个界面
        setContentView(R.layout.activity_a);
        start_b_btn = (Button) findViewById(R.id.start_b_btn);
        start_b_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AActivity.this, BActivity.class);
//                Intent it = new Intent(AActivity.this, AActivity.class);
                startActivity(it);
            }
        });

//        Intent it = new Intent();
//        it.putExtra("result", "something not ok");
//        setResult(RESULT_CANCELED, it);
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AActivity.this.finish();
//            }
//        }, 5000);

    }
    @Override
    protected void onDestroy () {
        super.onDestroy();
    }

    Button start_b_btn;
    Handler handler = new Handler();
}
