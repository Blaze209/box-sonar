package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.TraceFlags;

/* JADX INFO: loaded from: classes14.dex */
public class NoopTraceFlags implements TraceFlags {
    @Override // io.opentelemetry.api.trace.TraceFlags
    public byte asByte() {
        return (byte) 0;
    }

    @Override // io.opentelemetry.api.trace.TraceFlags
    public String asHex() {
        return null;
    }

    @Override // io.opentelemetry.api.trace.TraceFlags
    public boolean isSampled() {
        return false;
    }
}
