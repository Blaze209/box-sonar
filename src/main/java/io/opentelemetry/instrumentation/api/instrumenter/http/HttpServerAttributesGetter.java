package io.opentelemetry.instrumentation.api.instrumenter.http;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpServerAttributesGetter<REQUEST, RESPONSE> extends HttpCommonAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String flavor(REQUEST request);

    @Nullable
    String route(REQUEST request);

    @Nullable
    String scheme(REQUEST request);

    @Nullable
    String target(REQUEST request);
}
