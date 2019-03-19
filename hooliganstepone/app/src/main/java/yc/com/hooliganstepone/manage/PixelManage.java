package yc.com.hooliganstepone.manage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.lang.ref.WeakReference;

import yc.com.hooliganstepone.PixelActivity;
import yc.com.hooliganstepone.receiver.PixelReceiver;

/**
 * Created by 5C_R&D on 2019/3/19.
 *
 * @author yc
 */

public class PixelManage {
    private static PixelManage pixelManage = new PixelManage();
    private PixelReceiver pixelReceiver;

    public static PixelManage getInstance() {
        return pixelManage;
    }

    /**
     * 注册PixelReceiver
     * @param context
     */
    public void registerReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        pixelReceiver = new PixelReceiver();
        context.registerReceiver(pixelReceiver, intentFilter);
    }

    /**
     * 解除注册
     * @param context
     */
    public void unRegisterReceiver(Context context) {
        if (null!=pixelReceiver){
            context.unregisterReceiver(pixelReceiver);
        }
    }



    /**
     * 启动1px activity
     * @param context
     */
    public void startPixelActivity(Context context){
        context.startActivity(new Intent(context, PixelActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    /**
     * 弱引用pixel activity
     */
    private WeakReference<Activity> weakReference;

    /**
     * 关闭1像素activity
     */
    public void finishPixelActivity(){
        if (null!=weakReference){
            Activity activity = weakReference.get();
            if (null!=activity){
                activity.finish();
            }
        }
    }

    /**
     * 设置好activity
     * @param activity
     */
    public void setWeakReference(Activity activity){
        weakReference=new WeakReference<Activity>(activity);
    }
}
