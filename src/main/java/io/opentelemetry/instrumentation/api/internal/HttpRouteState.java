package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import io.opentelemetry.context.ImplicitContextKeyed;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpRouteState implements ImplicitContextKeyed {
    private static final ContextKey<HttpRouteState> KEY = ContextKey.named("opentelemetry-http-server-route-key");

    @Nullable
    private volatile String route;
    private volatile int updatedBySourceOrder;

    @Nullable
    public static HttpRouteState fromContextOrNull(Context context) {
        return (HttpRouteState) context.get(KEY);
    }

    public static HttpRouteState create(int i, @Nullable String str) {
        return new HttpRouteState(i, str);
    }

    private HttpRouteState(int i, @Nullable String str) {
        this.updatedBySourceOrder = i;
        this.route = str;
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    public Context storeInContext(Context context) {
        return context.with(KEY, this);
    }

    public int getUpdatedBySourceOrder() {
        return this.updatedBySourceOrder;
    }

    @Nullable
    public String getRoute() {
        return this.route;
    }

    public void update(Context context, int i, String str) {
        this.updatedBySourceOrder = i;
        this.route = str;
    }
}
