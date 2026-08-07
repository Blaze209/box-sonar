package io.opentelemetry.instrumentation.api.instrumenter.net;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface NetServerAttributesGetter<REQUEST> {
    @Nullable
    String hostName(REQUEST request);

    @Nullable
    Integer hostPort(REQUEST request);

    @Nullable
    default String sockFamily(REQUEST request) {
        return null;
    }

    @Nullable
    default String sockHostAddr(REQUEST request) {
        return null;
    }

    @Nullable
    default Integer sockHostPort(REQUEST request) {
        return null;
    }

    @Nullable
    default String sockPeerAddr(REQUEST request) {
        return null;
    }

    @Nullable
    default Integer sockPeerPort(REQUEST request) {
        return null;
    }

    @Nullable
    String transport(REQUEST request);
}
