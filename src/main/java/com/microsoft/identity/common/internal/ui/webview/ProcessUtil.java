package com.microsoft.identity.common.internal.ui.webview;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

/* JADX INFO: loaded from: classes14.dex */
public class ProcessUtil {
    public static final String AuthServiceProcess = "auth";

    public static boolean isRunningOnAuthService(Context context) {
        String str = context.getPackageName() + ":auth";
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid && runningAppProcessInfo.processName.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
