package yc.com.hooliganstepone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import yc.com.hooliganstepone.manage.PixelManage;

/**
 * @author 5C_R&D
 */
public class PixelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //设置窗口在左上角
        window.setGravity(Gravity.START|Gravity.TOP);
        WindowManager.LayoutParams attributes = window.getAttributes();
        //设置宽高坐标
        attributes.width=1;
        attributes.height=1;
        attributes.x=0;
        attributes.y=0;
        window.setAttributes(attributes);
        PixelManage.getInstance().setWeakReference(this);
    }
}
