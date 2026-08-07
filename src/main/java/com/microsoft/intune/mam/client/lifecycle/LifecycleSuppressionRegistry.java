package com.microsoft.intune.mam.client.lifecycle;

import android.app.Activity;
import android.app.Application;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LifecycleSuppressionRegistry {
    private final Map<Application.ActivityLifecycleCallbacks, MAMActivityLifecycleCallbacks> wrappedCallbacks = new WeakHashMap();

    public synchronized void onActivityCreateSuppressed(Activity activity) {
        Iterator<MAMActivityLifecycleCallbacks> it = this.wrappedCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityCreateSuppressed(activity);
        }
    }

    public synchronized void onActivityResumeSuppressed(Activity activity) {
        Iterator<MAMActivityLifecycleCallbacks> it = this.wrappedCallbacks.values().iterator();
        while (it.hasNext()) {
            it.next().onActivityResumeSuppressed(activity);
        }
    }

    public synchronized void registerWrappedCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, MAMActivityLifecycleCallbacks mAMActivityLifecycleCallbacks) {
        this.wrappedCallbacks.put(activityLifecycleCallbacks, mAMActivityLifecycleCallbacks);
    }

    public synchronized MAMActivityLifecycleCallbacks unregisterWrappedCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        return this.wrappedCallbacks.remove(activityLifecycleCallbacks);
    }
}
