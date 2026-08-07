package io.opentelemetry.instrumentation.okhttp.v3_0.internal;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class OkHttpNetAttributesGetter implements NetClientAttributesGetter<Request, Response> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public String transport(Request request, @Nullable Response response) {
        return SemanticAttributes.NetTransportValues.IP_TCP;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    @Nullable
    public String peerName(Request request) {
        return request.url().host();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter
    public Integer peerPort(Request request) {
        return Integer.valueOf(request.url().port());
    }
}
