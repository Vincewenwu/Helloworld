package zuweie.bankoo.co.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "BActivity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tx = (TextView) findViewById(R.id.textview);
        //tx.setText(getIntent().getStringExtra("param1"));

        start_c_btn = (Button) findViewById(R.id.start_c_btn);
        start_c_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(BActivity.this, CActivity.class);
                startActivity(it);
            }
        });
    }

    TextView tx;
    Button start_c_btn ;

}
