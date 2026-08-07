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
class Pre29ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
    private final AppStartupTimer appStartupTimer;
    private final Tracer tracer;
    private final VisibleScreenTracker visibleScreenTracker;
    private final Map<String, ActivityTracer> tracersByActivityClassName = new HashMap();
    private final AtomicReference<String> initialAppActivity = new AtomicReference<>();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    Pre29ActivityCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.tracer = tracer;
        this.visibleScreenTracker = visibleScreenTracker;
        this.appStartupTimer = appStartupTimer;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.appStartupTimer.startUiInit();
        getTracer(activity).startActivityCreation().addEvent("activityCreated");
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new RumFragmentLifecycleCallbacks(this.tracer, this.visibleScreenTracker), true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        getTracer(activity).initiateRestartSpanIfNecessary(this.tracersByActivityClassName.size() > 1).addEvent("activityStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Resumed").addEvent("activityResumed").addPreviousScreenAttribute().endSpanForActivityResumed();
        this.visibleScreenTracker.activityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Paused").addEvent("activityPaused").endActiveSpan();
        this.visibleScreenTracker.activityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Stopped").addEvent("activityStopped").endActiveSpan();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        getTracer(activity).startSpanIfNoneInProgress("Destroyed").addEvent("activityDestroyed").endActiveSpan();
    }

    private ActivityTracer getTracer(Activity activity) {
        ActivityTracer activityTracer = this.tracersByActivityClassName.get(activity.getClass().getName());
        if (activityTracer != null) {
            return activityTracer;
        }
        ActivityTracer activityTracer2 = new ActivityTracer(activity, this.initialAppActivity, this.tracer, this.visibleScreenTracker, this.appStartupTimer);
        this.tracersByActivityClassName.put(activity.getClass().getName(), activityTracer2);
        return activityTracer2;
    }
}
