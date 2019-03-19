package yc.com.hooliganstepone.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;

import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by 5C_R&D on 2019/3/19.
 *
 * @author yc
 */

public class MyService extends Service {
    private static final int SERVICE_ID = 1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            startForeground(SERVICE_ID, new Notification());
        } else if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            startService(new Intent(MyService.this, InteriorService.class));
            startForeground(SERVICE_ID, new Notification());
        } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager systemService = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel("yc", "xxx", NotificationManager.IMPORTANCE_MIN);
            if (null != systemService) {
                systemService.createNotificationChannel(notificationChannel);
                Notification build = new NotificationCompat.Builder(this, "yc").build();
                startForeground(SERVICE_ID, build);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }



    /**
     * sdk18也就是Android4.4之后创建前台服务会在通知栏显示
     * 这里开启一个同名的再关闭让系统以为已经关闭了
     * 一定要记得写static哦
     */
    public static class InteriorService extends Service {

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            startForeground(SERVICE_ID, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, flags, startId);
        }
    }
}
