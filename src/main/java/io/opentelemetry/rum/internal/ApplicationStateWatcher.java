package io.opentelemetry.rum.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
final class ApplicationStateWatcher implements Application.ActivityLifecycleCallbacks {
    private final List<ApplicationStateListener> applicationStateListeners = new CopyOnWriteArrayList();
    private int numberOfOpenActivities = 0;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this.numberOfOpenActivities == 0) {
            Iterator<ApplicationStateListener> it = this.applicationStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onApplicationForegrounded();
            }
        }
        this.numberOfOpenActivities++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.numberOfOpenActivities - 1;
        this.numberOfOpenActivities = i;
        if (i == 0) {
            Iterator<ApplicationStateListener> it = this.applicationStateListeners.iterator();
            while (it.hasNext()) {
                it.next().onApplicationBackgrounded();
            }
        }
    }

    void registerListener(ApplicationStateListener applicationStateListener) {
        this.applicationStateListeners.add(applicationStateListener);
    }
}
