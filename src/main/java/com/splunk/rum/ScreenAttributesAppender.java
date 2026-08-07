package com.splunk.rum;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;

/* JADX INFO: loaded from: classes3.dex */
class ScreenAttributesAppender implements SpanProcessor {
    private final VisibleScreenTracker visibleScreenTracker;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
    }

    ScreenAttributesAppender(VisibleScreenTracker visibleScreenTracker) {
        this.visibleScreenTracker = visibleScreenTracker;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAttribute(SplunkRum.SCREEN_NAME_KEY, this.visibleScreenTracker.getCurrentlyVisibleScreen());
    }
}
