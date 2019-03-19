package yc.com.hooliganstepone.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import yc.com.hooliganstepone.manage.PixelManage;

/**
 * Created by 5C_R&D on 2019/3/19.
 *
 * @author yc
 */

public class PixelReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            //关闭屏幕
            case Intent.ACTION_SCREEN_OFF:
                PixelManage.getInstance().startPixelActivity(context);
                break;
                //打开屏幕
            case Intent.ACTION_SCREEN_ON:
                PixelManage.getInstance().finishPixelActivity();
                break;
            default:
                break;
        }
    }
}
