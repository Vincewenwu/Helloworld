package zuweie.bankoo.co.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class HelloWorldService extends Service {
    public HelloWorldService() {
    }

    @Override
    public void onCreate () {
        super.onCreate();
        Log.d("Service","Service on Create");
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startId ) {
        Log.d("Service", "Service on Start");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy () {
        Log.d("Servie", "Service on Destroy");
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
