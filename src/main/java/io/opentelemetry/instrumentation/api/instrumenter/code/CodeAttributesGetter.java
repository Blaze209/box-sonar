package io.opentelemetry.instrumentation.api.instrumenter.code;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface CodeAttributesGetter<REQUEST> {
    @Nullable
    Class<?> codeClass(REQUEST request);

    @Nullable
    String methodName(REQUEST request);
}
