package io.opentelemetry.sdk.metrics.internal.debug;

/* JADX INFO: loaded from: classes4.dex */
enum NoSourceInfo implements SourceInfo {
    INSTANCE;

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String shortDebugString() {
        return "unknown source";
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String multiLineDebugString() {
        return "\tat unknown source\n\t\t" + DebugConfig.getHowToEnableMessage();
    }
}
