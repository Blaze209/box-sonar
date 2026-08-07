package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityLifecycleMonitorBase implements Application.ActivityLifecycleCallbacks {
    private Set<Activity> mLiveActivities = new HashSet();
    private Activity mForegroundActivity = null;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized Activity[] getAppActivities() {
        return (Activity[]) this.mLiveActivities.toArray(new Activity[0]);
    }

    public synchronized Activity getForegroundActivity() {
        return this.mForegroundActivity;
    }

    public synchronized boolean isAppInForeground() {
        return this.mForegroundActivity != null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        this.mLiveActivities.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityDestroyed(Activity activity) {
        this.mLiveActivities.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        this.mForegroundActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityPaused(Activity activity) {
        this.mForegroundActivity = null;
    }
}
