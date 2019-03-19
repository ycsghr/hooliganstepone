package yc.com.hooliganstepone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yc.com.hooliganstepone.manage.PixelManage;
import yc.com.hooliganstepone.service.BrightService;
import yc.com.hooliganstepone.service.MyService;
import yc.com.hooliganstepone.service.RemoteService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PixelManage.getInstance().registerReceiver(this);
//        startService(new Intent(this, MyService.class));
        startService(new Intent(this, BrightService.class));
        startService(new Intent(this, RemoteService.class));
   }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PixelManage.getInstance().unRegisterReceiver(this);
    }
}
