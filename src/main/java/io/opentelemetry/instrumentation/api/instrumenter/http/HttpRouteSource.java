package io.opentelemetry.instrumentation.api.instrumenter.http;

/* JADX INFO: loaded from: classes4.dex */
public enum HttpRouteSource {
    FILTER(1, false),
    SERVLET(2),
    CONTROLLER(3),
    NESTED_CONTROLLER(4, false);

    final int order;
    final boolean useFirst;

    HttpRouteSource(int i) {
        this(i, true);
    }

    HttpRouteSource(int i, boolean z) {
        this.order = i;
        this.useFirst = z;
    }
}
