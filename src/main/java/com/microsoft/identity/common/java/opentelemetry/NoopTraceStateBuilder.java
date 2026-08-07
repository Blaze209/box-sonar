package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;

/* JADX INFO: loaded from: classes14.dex */
public class NoopTraceStateBuilder implements TraceStateBuilder {
    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder put(String str, String str2) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder remove(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceState build() {
        return new NoopTraceState();
    }
}
