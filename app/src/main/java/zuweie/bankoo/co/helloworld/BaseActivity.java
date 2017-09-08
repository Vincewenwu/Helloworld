package zuweie.bankoo.co.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

abstract class BaseActivity extends AppCompatActivity {
    public abstract String getTag ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getTag());
        Log.d(getTag(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(getTag(), "onStart");
    }

    @Override
    protected void onResume () {
        super.onResume();
        Log.d(getTag(), "OnResume");
    }

    @Override
    protected void onPause () {
        super.onPause();
        Log.d(getTag(), "OnPause" );
    }

    @Override
    protected void onStop (){
        super.onStop();
        Log.d(getTag(), "onStop");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Log.d(getTag(), "onDestroy");
    }

    @Override
    public void onConfigurationChanged (Configuration newConfig){
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(getTag(), "onRestart");
    }

    @Override
    public void onNewIntent (Intent intent) {
        super.onNewIntent(intent);
        Log.d(getTag(), "onNewIntent");
    }
}