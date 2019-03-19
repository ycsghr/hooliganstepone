package yc.com.hooliganstepone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import yc.com.hooliganstepone.manage.PixelManage;
import yc.com.hooliganstepone.service.BrightService;
import yc.com.hooliganstepone.service.MyService;
import yc.com.hooliganstepone.service.RemoteService;

/**
 * 这两个保活主要就是通过提高应用的adj来实现的
 * 如果想查看自己应用的adj可以通过
 * cat /proc/进程id（这个可以在as上看也可以通过ps命令来看）/oom_adj
 * 记住了cat后面有一个空格啊
 */
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
