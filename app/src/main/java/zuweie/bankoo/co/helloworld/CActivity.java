package zuweie.bankoo.co.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "C Activity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        back_to_a = (Button) findViewById(R.id.back_a_btn);
        back_to_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent it = new Intent(CActivity.this, AActivity.class);

                Intent it = new Intent (CActivity.this, AActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                startActivity(it);

            }
        });
    }

    Button back_to_a;
}
