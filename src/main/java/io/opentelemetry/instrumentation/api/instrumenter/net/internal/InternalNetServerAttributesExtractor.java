package io.opentelemetry.instrumentation.api.instrumenter.net.internal;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.function.BiPredicate;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalNetServerAttributesExtractor<REQUEST> {
    private final BiPredicate<Integer, REQUEST> captureHostPortCondition;
    private final FallbackNamePortGetter<REQUEST> fallbackNamePortGetter;
    private final NetServerAttributesGetter<REQUEST> getter;

    public InternalNetServerAttributesExtractor(NetServerAttributesGetter<REQUEST> netServerAttributesGetter, BiPredicate<Integer, REQUEST> biPredicate, FallbackNamePortGetter<REQUEST> fallbackNamePortGetter) {
        this.getter = netServerAttributesGetter;
        this.captureHostPortCondition = biPredicate;
        this.fallbackNamePortGetter = fallbackNamePortGetter;
    }

    public void onStart(AttributesBuilder attributesBuilder, REQUEST request) {
        boolean z;
        String strSockFamily;
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_TRANSPORT, this.getter.transport(request));
        String strSockPeerAddr = this.getter.sockPeerAddr(request);
        boolean z2 = true;
        if (strSockPeerAddr != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_PEER_ADDR, strSockPeerAddr);
            Integer numSockPeerPort = this.getter.sockPeerPort(request);
            if (numSockPeerPort != null && numSockPeerPort.intValue() > 0) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_PEER_PORT, Long.valueOf(numSockPeerPort.intValue()));
            }
            z = true;
        } else {
            z = false;
        }
        String strExtractHostName = extractHostName(request);
        Integer numExtractHostPort = extractHostPort(request);
        if (strExtractHostName != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_HOST_NAME, strExtractHostName);
            if (numExtractHostPort != null && numExtractHostPort.intValue() > 0 && this.captureHostPortCondition.test(numExtractHostPort, request)) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_HOST_PORT, Long.valueOf(numExtractHostPort.intValue()));
            }
        }
        String strSockHostAddr = this.getter.sockHostAddr(request);
        if (strSockHostAddr == null || strSockHostAddr.equals(strExtractHostName)) {
            z2 = z;
        } else {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_HOST_ADDR, strSockHostAddr);
            Integer numSockHostPort = this.getter.sockHostPort(request);
            if (numSockHostPort != null && numSockHostPort.intValue() > 0 && !numSockHostPort.equals(numExtractHostPort)) {
                AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_HOST_PORT, Long.valueOf(numSockHostPort.intValue()));
            }
        }
        if (!z2 || (strSockFamily = this.getter.sockFamily(request)) == null || strSockFamily.equals(SemanticAttributes.NetSockFamilyValues.INET)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_FAMILY, strSockFamily);
    }

    private String extractHostName(REQUEST request) {
        String strHostName = this.getter.hostName(request);
        return strHostName == null ? this.fallbackNamePortGetter.name(request) : strHostName;
    }

    private Integer extractHostPort(REQUEST request) {
        Integer numHostPort = this.getter.hostPort(request);
        return numHostPort == null ? this.fallbackNamePortGetter.port(request) : numHostPort;
    }
}
