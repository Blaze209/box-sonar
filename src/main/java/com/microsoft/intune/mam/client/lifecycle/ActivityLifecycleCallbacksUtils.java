package com.microsoft.intune.mam.client.lifecycle;

import android.app.Application;
import com.microsoft.intune.mam.client.app.ActivityLifecycleMonitorBase;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityLifecycleCallbacksUtils {
    private ActivityLifecycleCallbacksUtils() {
    }

    public static boolean shouldWrapActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        return !(activityLifecycleCallbacks instanceof ActivityLifecycleMonitorBase);
    }
}
