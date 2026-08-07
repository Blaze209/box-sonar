package io.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface TextMapGetter<C> {
    @Nullable
    String get(@Nullable C c, String str);

    Iterable<String> keys(C c);
}
