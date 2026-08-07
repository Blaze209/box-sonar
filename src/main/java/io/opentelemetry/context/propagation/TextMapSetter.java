package io.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface TextMapSetter<C> {
    void set(@Nullable C c, String str, String str2);
}
