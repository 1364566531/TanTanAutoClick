package com.vipheyue.tantanautoclick;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;


public class AutoClickService extends AccessibilityService {
    public AutoClickService() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
                AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
//                List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId();

                Log.d("AutoClickService", "用户界面改动");

                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                Log.d("AutoClickService", "界面文字改动");
                break;
        }
    }

    @Override
    public void onInterrupt() {
        Toast.makeText(this, "中断探探自动点击服务", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Toast.makeText(this, "已连接探探自动点击服务", Toast.LENGTH_SHORT).show();
    }

}
