package com.microsoft.intune.mam.client.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class MAMActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMActivityLifecycleCallbacks.class);
    private final Application.ActivityLifecycleCallbacks mCallbacks;
    private final LifecycleSuppressionRegistry mLifecycleSuppressionRegistry;
    private boolean mIsActivityCallback = false;
    private Set<Activity> mCreateSuppressedActivities = new HashSet();
    private Set<Activity> mResumeSuppressedActivities = new HashSet();

    public MAMActivityLifecycleCallbacks(LifecycleSuppressionRegistry lifecycleSuppressionRegistry, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mLifecycleSuppressionRegistry = lifecycleSuppressionRegistry;
        this.mCallbacks = activityLifecycleCallbacks;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        this.mCallbacks.onActivityPreCreated(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.mCreateSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityCreated for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        if (this.mCreateSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPostCreated for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPostCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
        this.mCallbacks.onActivityPreStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mCallbacks.onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        this.mCallbacks.onActivityPostStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
        this.mCallbacks.onActivityPreResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this.mResumeSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityResumed for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        if (this.mResumeSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPostResumed for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPostResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        if (this.mResumeSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPrePaused for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPrePaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.mResumeSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPaused for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
        if (this.mResumeSuppressedActivities.contains(activity)) {
            this.mResumeSuppressedActivities.remove(activity);
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPostPaused for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPostPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        this.mCallbacks.onActivityPreStopped(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mCallbacks.onActivityStopped(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
        this.mCallbacks.onActivityPostStopped(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
        this.mCallbacks.onActivityPreSaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.mCallbacks.onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        this.mCallbacks.onActivityPostSaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        if (this.mCreateSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPreDestroyed for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPreDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.mCreateSuppressedActivities.contains(activity)) {
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityDestroyed for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
        if (this.mIsActivityCallback) {
            this.mLifecycleSuppressionRegistry.unregisterWrappedCallbacks(this.mCallbacks);
        }
        if (this.mCreateSuppressedActivities.contains(activity)) {
            this.mCreateSuppressedActivities.remove(activity);
            LOGGER.info("Skipping " + this.mCallbacks + " onActivityPostDestroyed for suppressed activity " + activity.getLocalClassName(), new Object[0]);
        } else {
            this.mCallbacks.onActivityPostDestroyed(activity);
        }
    }

    public void onActivityCreateSuppressed(Activity activity) {
        this.mCreateSuppressedActivities.add(activity);
    }

    public void onActivityResumeSuppressed(Activity activity) {
        this.mResumeSuppressedActivities.add(activity);
    }

    public void setIsActivityCallback() {
        this.mIsActivityCallback = true;
    }
}
