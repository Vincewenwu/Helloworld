package zuweie.bankoo.co.helloworld;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class WidgetActivity extends BaseActivity {

    @Override
    public String getTag() {
        return "Widgets Activity";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(WidgetActivity.this);
                builder.setTitle("这是一个password输入");
                //View contentView = WidgetActivity.this.getLayoutInflater().inflate(R.layout.password_input, null);
                //dlgEditText = (EditText) contentView.findViewById(R.id.dlg_input);
                //builder.setView(contentView);
                builder.setMessage("Message");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        String etx = dlgEditText.getText().toString();
//                        Toast.makeText(WidgetActivity.this, "Password is " + etx, Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                if (curr_progress < 100) {
                    curr_progress += 1;
                }

                if (curr_sec_progress <= 97) {
                    curr_sec_progress += 3;
                }else {
                    curr_sec_progress = 100;
                }

                progressbar.setProgress(curr_progress);
                progressbar.setSecondaryProgress(curr_sec_progress);

            }
        });
        progressbar =(ProgressBar) findViewById(R.id.progressbar);
        progressbar.setMax(100);

        editText = (EditText) findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    Button button;
    ProgressBar progressbar;
    TextView textView;
    EditText editText;
    int curr_progress = 0;
    int curr_sec_progress = 0;
    EditText dlgEditText;


}
