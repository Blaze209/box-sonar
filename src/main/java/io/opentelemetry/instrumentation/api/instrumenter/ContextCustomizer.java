package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface ContextCustomizer<REQUEST> {
    Context onStart(Context context, REQUEST request, Attributes attributes);
}
