package com.microsoft.intune.mam.client.lifecycle;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineActivityLifecycleCallbacksFactory {
    private final LifecycleSuppressionRegistry mLifecycleSuppressionRegistry;

    public OfflineActivityLifecycleCallbacksFactory(LifecycleSuppressionRegistry lifecycleSuppressionRegistry) {
        this.mLifecycleSuppressionRegistry = lifecycleSuppressionRegistry;
    }

    public MAMActivityLifecycleCallbacks create(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        return new MAMActivityLifecycleCallbacks(this.mLifecycleSuppressionRegistry, activityLifecycleCallbacks);
    }
}
