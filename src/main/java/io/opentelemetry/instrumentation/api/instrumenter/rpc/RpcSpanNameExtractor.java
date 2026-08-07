package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* JADX INFO: loaded from: classes4.dex */
public final class RpcSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final RpcAttributesGetter<REQUEST> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        return new RpcSpanNameExtractor(rpcAttributesGetter);
    }

    private RpcSpanNameExtractor(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        this.getter = rpcAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public String extract(REQUEST request) {
        String strService = this.getter.service(request);
        String strMethod = this.getter.method(request);
        if (strService == null || strMethod == null) {
            return "RPC request";
        }
        return strService + '/' + strMethod;
    }
}
