package com.splunk.rum;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;

/* JADX INFO: loaded from: classes3.dex */
final class NetworkAttributesAppender implements SpanProcessor {
    private final ConnectionUtil connectionUtil;
    private final CurrentNetworkAttributesExtractor networkAttributesExtractor = new CurrentNetworkAttributesExtractor();

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

    NetworkAttributesAppender(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAllAttributes(this.networkAttributesExtractor.extract(this.connectionUtil.getActiveNetwork()));
    }
}
