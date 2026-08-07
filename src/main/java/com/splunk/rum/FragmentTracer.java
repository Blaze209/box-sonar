package com.splunk.rum;

import androidx.fragment.app.Fragment;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class FragmentTracer {
    static final AttributeKey<String> FRAGMENT_NAME_KEY = AttributeKey.stringKey("fragmentName");
    private final ActiveSpan activeSpan;
    private final String fragmentName;
    private final String screenName;
    private final Tracer tracer;

    FragmentTracer(Fragment fragment, Tracer tracer, VisibleScreenTracker visibleScreenTracker) {
        this.tracer = tracer;
        String simpleName = fragment.getClass().getSimpleName();
        this.fragmentName = simpleName;
        RumScreenName rumScreenName = (RumScreenName) fragment.getClass().getAnnotation(RumScreenName.class);
        this.screenName = rumScreenName != null ? rumScreenName.value() : simpleName;
        this.activeSpan = new ActiveSpan(visibleScreenTracker);
    }

    FragmentTracer startSpanIfNoneInProgress(final String str) {
        if (this.activeSpan.spanInProgress()) {
            return this;
        }
        this.activeSpan.startSpan(new Supplier() { // from class: com.splunk.rum.FragmentTracer$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14334lambda$startSpanIfNoneInProgress$0$comsplunkrumFragmentTracer(str);
            }
        });
        return this;
    }

    /* JADX INFO: renamed from: lambda$startFragmentCreation$1$com-splunk-rum-FragmentTracer, reason: not valid java name */
    /* synthetic */ Span m14333lambda$startFragmentCreation$1$comsplunkrumFragmentTracer() {
        return m14334lambda$startSpanIfNoneInProgress$0$comsplunkrumFragmentTracer("Created");
    }

    FragmentTracer startFragmentCreation() {
        this.activeSpan.startSpan(new Supplier() { // from class: com.splunk.rum.FragmentTracer$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14333lambda$startFragmentCreation$1$comsplunkrumFragmentTracer();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createSpan, reason: merged with bridge method [inline-methods] */
    public Span m14334lambda$startSpanIfNoneInProgress$0$comsplunkrumFragmentTracer(String str) {
        Span spanStartSpan = this.tracer.spanBuilder(str).setAttribute(FRAGMENT_NAME_KEY, this.fragmentName).setAttribute(SplunkRum.COMPONENT_KEY, "ui").startSpan();
        spanStartSpan.setAttribute(SplunkRum.SCREEN_NAME_KEY, this.screenName);
        return spanStartSpan;
    }

    void endActiveSpan() {
        this.activeSpan.endActiveSpan();
    }

    FragmentTracer addPreviousScreenAttribute() {
        this.activeSpan.addPreviousScreenAttribute(this.fragmentName);
        return this;
    }

    FragmentTracer addEvent(String str) {
        this.activeSpan.addEvent(str);
        return this;
    }
}
