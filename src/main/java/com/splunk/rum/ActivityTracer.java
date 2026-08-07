package com.splunk.rum;

import android.app.Activity;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ActivityTracer {
    static final AttributeKey<String> ACTIVITY_NAME_KEY = AttributeKey.stringKey("activityName");
    static final String APP_START_SPAN_NAME = "AppStart";
    private final ActiveSpan activeSpan;
    private final String activityName;
    private final AppStartupTimer appStartupTimer;
    private final AtomicReference<String> initialAppActivity;
    private final String screenName;
    private final Tracer tracer;

    ActivityTracer(Activity activity, AtomicReference<String> atomicReference, Tracer tracer, VisibleScreenTracker visibleScreenTracker, AppStartupTimer appStartupTimer) {
        this.initialAppActivity = atomicReference;
        this.tracer = tracer;
        String simpleName = activity.getClass().getSimpleName();
        this.activityName = simpleName;
        RumScreenName rumScreenName = (RumScreenName) activity.getClass().getAnnotation(RumScreenName.class);
        this.screenName = rumScreenName != null ? rumScreenName.value() : simpleName;
        this.appStartupTimer = appStartupTimer;
        this.activeSpan = new ActiveSpan(visibleScreenTracker);
    }

    ActivityTracer startSpanIfNoneInProgress(final String str) {
        if (this.activeSpan.spanInProgress()) {
            return this;
        }
        this.activeSpan.startSpan(new Supplier() { // from class: com.splunk.rum.ActivityTracer$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer(str);
            }
        });
        return this;
    }

    ActivityTracer startActivityCreation() {
        this.activeSpan.startSpan(new Supplier() { // from class: com.splunk.rum.ActivityTracer$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.makeCreationSpan();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Span makeCreationSpan() {
        if (this.initialAppActivity.get() == null) {
            return createSpanWithParent("Created", this.appStartupTimer.getStartupSpan());
        }
        if (this.activityName.equals(this.initialAppActivity.get())) {
            return createAppStartSpan("warm");
        }
        return m14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer("Created");
    }

    ActivityTracer initiateRestartSpanIfNecessary(final boolean z) {
        if (this.activeSpan.spanInProgress()) {
            return this;
        }
        this.activeSpan.startSpan(new Supplier() { // from class: com.splunk.rum.ActivityTracer$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14325x121c84f5(z);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: makeRestartSpan, reason: merged with bridge method [inline-methods] */
    public Span m14325x121c84f5(boolean z) {
        if (!z && this.activityName.equals(this.initialAppActivity.get())) {
            return createAppStartSpan("hot");
        }
        return m14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer("Restarted");
    }

    private Span createAppStartSpan(String str) {
        Span spanM14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer = m14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer(APP_START_SPAN_NAME);
        spanM14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer.setAttribute(SplunkRum.START_TYPE_KEY, str);
        spanM14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer.setAttribute(SplunkRum.COMPONENT_KEY, "appstart");
        return spanM14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createSpan, reason: merged with bridge method [inline-methods] */
    public Span m14326lambda$startSpanIfNoneInProgress$0$comsplunkrumActivityTracer(String str) {
        return createSpanWithParent(str, null);
    }

    private Span createSpanWithParent(String str, Span span) {
        SpanBuilder attribute = this.tracer.spanBuilder(str).setAttribute(ACTIVITY_NAME_KEY, this.activityName).setAttribute(SplunkRum.COMPONENT_KEY, "ui");
        if (span != null) {
            attribute.setParent(span.storeInContext(Context.current()));
        }
        Span spanStartSpan = attribute.startSpan();
        spanStartSpan.setAttribute(SplunkRum.SCREEN_NAME_KEY, this.screenName);
        return spanStartSpan;
    }

    void endSpanForActivityResumed() {
        if (this.initialAppActivity.get() == null) {
            this.initialAppActivity.set(this.activityName);
        }
        endActiveSpan();
    }

    void endActiveSpan() {
        this.appStartupTimer.end();
        this.activeSpan.endActiveSpan();
    }

    ActivityTracer addPreviousScreenAttribute() {
        this.activeSpan.addPreviousScreenAttribute(this.activityName);
        return this;
    }

    ActivityTracer addEvent(String str) {
        this.activeSpan.addEvent(str);
        return this;
    }
}
