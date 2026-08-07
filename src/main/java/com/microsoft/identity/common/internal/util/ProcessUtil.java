package com.microsoft.identity.common.internal.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.microsoft.identity.common.internal.broker.BrokerData;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class ProcessUtil {
    private ProcessUtil() {
    }

    public static boolean isBrokerProcess(Context context) {
        String processName = getProcessName(context);
        Iterator<BrokerData> it = BrokerData.getKnownBrokerApps().iterator();
        while (it.hasNext()) {
            if ((it.next().getPackageName() + ":auth").equalsIgnoreCase(processName)) {
                return true;
            }
        }
        return false;
    }

    private static String getProcessName(Context context) {
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static Handler getPreferredHandler() {
        if (Looper.myLooper() != null) {
            return new Handler(Looper.myLooper());
        }
        return new Handler(Looper.getMainLooper());
    }
}
