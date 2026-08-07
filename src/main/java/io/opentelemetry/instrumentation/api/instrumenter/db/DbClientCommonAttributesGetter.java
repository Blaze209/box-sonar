package io.opentelemetry.instrumentation.api.instrumenter.db;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface DbClientCommonAttributesGetter<REQUEST> {
    @Nullable
    String connectionString(REQUEST request);

    @Nullable
    String name(REQUEST request);

    @Nullable
    String system(REQUEST request);

    @Nullable
    String user(REQUEST request);
}
