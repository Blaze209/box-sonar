package com.microsoft.intune.mam.client.app;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedApplication extends HookedContextWrapper {
    Application asApplication();

    byte[] getADALSecretKey();

    void onMAMCreate();

    void registerActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    void unregisterActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);
}
