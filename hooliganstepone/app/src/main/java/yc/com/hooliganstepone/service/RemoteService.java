package yc.com.hooliganstepone.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by 5C_R&D on 2019/3/19.
 *
 * @author yc
 */

public class RemoteService extends MyService {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        bindService(new Intent(RemoteService.this,BrightService.class),serviceConnection,BIND_IMPORTANT);
        return super.onStartCommand(intent, flags, startId);
    }
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //链接断开
            startService(new Intent(RemoteService.this,BrightService.class));
            bindService(new Intent(RemoteService.this,BrightService.class),serviceConnection,BIND_IMPORTANT);
        }
    };
}
