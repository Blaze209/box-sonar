package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class RpcServerAttributesExtractor<REQUEST, RESPONSE> extends RpcCommonAttributesExtractor<REQUEST, RESPONSE> implements SpanKeyProvider {
    public static <REQUEST, RESPONSE> RpcServerAttributesExtractor<REQUEST, RESPONSE> create(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        return new RpcServerAttributesExtractor<>(rpcAttributesGetter);
    }

    private RpcServerAttributesExtractor(RpcAttributesGetter<REQUEST> rpcAttributesGetter) {
        super(rpcAttributesGetter);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.SpanKeyProvider
    public SpanKey internalGetSpanKey() {
        return SpanKey.RPC_SERVER;
    }
}
