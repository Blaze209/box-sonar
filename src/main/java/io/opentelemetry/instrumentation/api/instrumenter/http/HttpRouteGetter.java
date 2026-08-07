package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.context.Context;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface HttpRouteGetter<T> {
    @Nullable
    String get(Context context, T t);
}
