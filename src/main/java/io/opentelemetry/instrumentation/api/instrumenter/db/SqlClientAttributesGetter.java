package io.opentelemetry.instrumentation.api.instrumenter.db;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface SqlClientAttributesGetter<REQUEST> extends DbClientCommonAttributesGetter<REQUEST> {
    @Nullable
    String rawStatement(REQUEST request);
}
