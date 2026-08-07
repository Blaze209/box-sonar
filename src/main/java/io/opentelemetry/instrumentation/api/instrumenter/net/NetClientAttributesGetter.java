package io.opentelemetry.instrumentation.api.instrumenter.net;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NetClientAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String peerName(REQUEST request);

    @Nullable
    Integer peerPort(REQUEST request);

    @Nullable
    default String sockFamily(REQUEST request, @Nullable RESPONSE response) {
        return null;
    }

    @Nullable
    default String sockPeerAddr(REQUEST request, @Nullable RESPONSE response) {
        return null;
    }

    @Nullable
    default String sockPeerName(REQUEST request, @Nullable RESPONSE response) {
        return null;
    }

    @Nullable
    default Integer sockPeerPort(REQUEST request, @Nullable RESPONSE response) {
        return null;
    }

    @Nullable
    String transport(REQUEST request, @Nullable RESPONSE response);
}
