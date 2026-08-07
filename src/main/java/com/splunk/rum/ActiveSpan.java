package com.splunk.rum;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ActiveSpan {
    private Scope scope;
    private Span span;
    private final VisibleScreenTracker visibleScreenTracker;

    ActiveSpan(VisibleScreenTracker visibleScreenTracker) {
        this.visibleScreenTracker = visibleScreenTracker;
    }

    boolean spanInProgress() {
        return this.span != null;
    }

    void startSpan(Supplier<Span> supplier) {
        if (this.span != null) {
            return;
        }
        Span span = supplier.get();
        this.span = span;
        this.scope = span.makeCurrent();
    }

    void endActiveSpan() {
        Scope scope = this.scope;
        if (scope != null) {
            scope.close();
            this.scope = null;
        }
        Span span = this.span;
        if (span != null) {
            span.end();
            this.span = null;
        }
    }

    void addEvent(String str) {
        Span span = this.span;
        if (span != null) {
            span.addEvent(str);
        }
    }

    void addPreviousScreenAttribute(String str) {
        String previouslyVisibleScreen;
        if (this.span == null || (previouslyVisibleScreen = this.visibleScreenTracker.getPreviouslyVisibleScreen()) == null || str.equals(previouslyVisibleScreen)) {
            return;
        }
        this.span.setAttribute(SplunkRum.LAST_SCREEN_NAME_KEY, previouslyVisibleScreen);
    }
}
