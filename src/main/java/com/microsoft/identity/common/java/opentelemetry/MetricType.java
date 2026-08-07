package com.microsoft.identity.common.java.opentelemetry;

import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultBenchmarkSpanPrinter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/java/opentelemetry/MetricType;", "", "displayName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "AVERAGE", "P50", "P75", "P90", "P95", "P99", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum MetricType {
    AVERAGE("Avg"),
    P50("P50"),
    P75("P75"),
    P90("P90"),
    P95("P95"),
    P99("P99");

    private final String displayName;

    MetricType(String str) {
        this.displayName = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
