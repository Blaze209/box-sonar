package com.splunk.rum;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import io.opentelemetry.api.trace.Tracer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class RumFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    private final Tracer tracer;
    private final Map<String, FragmentTracer> tracersByFragmentClassName = new HashMap();
    private final VisibleScreenTracker visibleScreenTracker;

    RumFragmentLifecycleCallbacks(Tracer tracer, VisibleScreenTracker visibleScreenTracker) {
        this.tracer = tracer;
        this.visibleScreenTracker = visibleScreenTracker;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentPreAttached(fragmentManager, fragment, context);
        getTracer(fragment).startFragmentCreation().addEvent("fragmentPreAttached");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        addEvent(fragment, "fragmentAttached");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentPreCreated(fragmentManager, fragment, bundle);
        addEvent(fragment, "fragmentPreCreated");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentCreated(fragmentManager, fragment, bundle);
        addEvent(fragment, "fragmentCreated");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        getTracer(fragment).startSpanIfNoneInProgress("Restored").addEvent("fragmentViewCreated");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        addEvent(fragment, "fragmentStarted");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        getTracer(fragment).startSpanIfNoneInProgress("Resumed").addEvent("fragmentResumed").addPreviousScreenAttribute().endActiveSpan();
        this.visibleScreenTracker.fragmentResumed(fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        this.visibleScreenTracker.fragmentPaused(fragment);
        getTracer(fragment).startSpanIfNoneInProgress("Paused").addEvent("fragmentPaused");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        getTracer(fragment).addEvent("fragmentStopped").endActiveSpan();
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        super.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentViewDestroyed(fragmentManager, fragment);
        getTracer(fragment).startSpanIfNoneInProgress("ViewDestroyed").addEvent("fragmentViewDestroyed").endActiveSpan();
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDestroyed(fragmentManager, fragment);
        getTracer(fragment).startSpanIfNoneInProgress("Destroyed").addEvent("fragmentDestroyed");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        getTracer(fragment).startSpanIfNoneInProgress("Detached").addEvent("fragmentDetached").endActiveSpan();
    }

    private void addEvent(Fragment fragment, String str) {
        FragmentTracer fragmentTracer = this.tracersByFragmentClassName.get(fragment.getClass().getName());
        if (fragmentTracer != null) {
            fragmentTracer.addEvent(str);
        }
    }

    private FragmentTracer getTracer(Fragment fragment) {
        FragmentTracer fragmentTracer = this.tracersByFragmentClassName.get(fragment.getClass().getName());
        if (fragmentTracer != null) {
            return fragmentTracer;
        }
        FragmentTracer fragmentTracer2 = new FragmentTracer(fragment, this.tracer, this.visibleScreenTracker);
        this.tracersByFragmentClassName.put(fragment.getClass().getName(), fragmentTracer2);
        return fragmentTracer2;
    }
}
