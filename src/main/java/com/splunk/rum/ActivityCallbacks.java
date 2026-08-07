package com.splunk.rum;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import io.opentelemetry.api.trace.Tracer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
class ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final AppStartupTimer startupTimer;
    private final Tracer tracer;
    private final VisibleScreenTracker visibleScreenTracker;
    private final Map<String, ActivityTracer> tracersByActivityClassName = new HashMap();
    private final AtomicReference<String> initialAppActivity = new AtomicReference<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    ActivityCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.tracer = tracer;
        this.visibleScreenTracker = visibleScreenTracker;
        this.startupTimer = appStartupTimer;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        getTracer(activity).startActivityCreation().addEvent("activityPreCreated");
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new RumFragmentLifecycleCallbacks(this.tracer, this.visibleScreenTracker), true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.startupTimer.startUiInit();
        addEvent(activity, "activityCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        addEvent(activity, "activityPostCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(Activity activity) {
        getTracer(activity).initiateRestartSpanIfNecessary(this.tracersByActivityClassName.size() > 1).addEvent("activityPreStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        addEvent(activity, "activityStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        addEvent(activity, "activityPostStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Resumed").addEvent("activityPreResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        addEvent(activity, "activityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        getTracer(activity).addEvent("activityPostResumed").addPreviousScreenAttribute().endSpanForActivityResumed();
        this.visibleScreenTracker.activityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Paused").addEvent("activityPrePaused");
        this.visibleScreenTracker.activityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        addEvent(activity, "activityPaused");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(Activity activity) {
        getTracer(activity).addEvent("activityPostPaused").endActiveSpan();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Stopped").addEvent("activityPreStopped");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        addEvent(activity, "activityStopped");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(Activity activity) {
        getTracer(activity).addEvent("activityPostStopped").endActiveSpan();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Destroyed").addEvent("activityPreDestroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        addEvent(activity, "activityDestroyed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(Activity activity) {
        getTracer(activity).addEvent("activityPostDestroyed").endActiveSpan();
    }

    private void addEvent(Activity activity, String str) {
        getTracer(activity).addEvent(str);
    }

    private ActivityTracer getTracer(Activity activity) {
        ActivityTracer activityTracer = this.tracersByActivityClassName.get(activity.getClass().getName());
        if (activityTracer != null) {
            return activityTracer;
        }
        ActivityTracer activityTracer2 = new ActivityTracer(activity, this.initialAppActivity, this.tracer, this.visibleScreenTracker, this.startupTimer);
        this.tracersByActivityClassName.put(activity.getClass().getName(), activityTracer2);
        return activityTracer2;
    }
}
