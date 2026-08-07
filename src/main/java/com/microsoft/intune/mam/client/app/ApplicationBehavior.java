package com.microsoft.intune.mam.client.app;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface ApplicationBehavior {
    void attachBaseContext(HookedApplication hookedApplication, Context context);

    byte[] generateDefaultADALSecretKey();

    Context getBaseContext();

    void onCreate();

    void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);
}
