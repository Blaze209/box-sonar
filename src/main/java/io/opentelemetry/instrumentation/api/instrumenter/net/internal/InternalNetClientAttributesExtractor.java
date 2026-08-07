package io.opentelemetry.instrumentation.api.instrumenter.net.internal;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.instrumentation.api.instrumenter.net.NetClientAttributesGetter;
import io.opentelemetry.instrumentation.api.internal.AttributesExtractorUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.function.BiPredicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InternalNetClientAttributesExtractor<REQUEST, RESPONSE> {
    private final BiPredicate<Integer, REQUEST> capturePeerPortCondition;
    private final FallbackNamePortGetter<REQUEST> fallbackNamePortGetter;
    private final NetClientAttributesGetter<REQUEST, RESPONSE> getter;

    public InternalNetClientAttributesExtractor(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter, BiPredicate<Integer, REQUEST> biPredicate, FallbackNamePortGetter<REQUEST> fallbackNamePortGetter) {
        this.getter = netClientAttributesGetter;
        this.capturePeerPortCondition = biPredicate;
        this.fallbackNamePortGetter = fallbackNamePortGetter;
    }

    public void onStart(AttributesBuilder attributesBuilder, REQUEST request) {
        String strExtractPeerName = extractPeerName(request);
        if (strExtractPeerName != null) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_PEER_NAME, strExtractPeerName);
            Integer numExtractPeerPort = extractPeerPort(request);
            if (numExtractPeerPort == null || numExtractPeerPort.intValue() <= 0 || !this.capturePeerPortCondition.test(numExtractPeerPort, request)) {
                return;
            }
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_PEER_PORT, Long.valueOf(numExtractPeerPort.intValue()));
        }
    }

    public void onEnd(AttributesBuilder attributesBuilder, REQUEST request, @Nullable RESPONSE response) {
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_TRANSPORT, this.getter.transport(request, response));
        String strExtractPeerName = extractPeerName(request);
        String strSockPeerAddr = this.getter.sockPeerAddr(request, response);
        if (strSockPeerAddr == null || strSockPeerAddr.equals(strExtractPeerName)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_PEER_ADDR, strSockPeerAddr);
        Integer numExtractPeerPort = extractPeerPort(request);
        Integer numSockPeerPort = this.getter.sockPeerPort(request, response);
        if (numSockPeerPort != null && numSockPeerPort.intValue() > 0 && !numSockPeerPort.equals(numExtractPeerPort)) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_PEER_PORT, Long.valueOf(numSockPeerPort.intValue()));
        }
        String strSockFamily = this.getter.sockFamily(request, response);
        if (strSockFamily != null && !strSockFamily.equals(SemanticAttributes.NetSockFamilyValues.INET)) {
            AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_FAMILY, strSockFamily);
        }
        String strSockPeerName = this.getter.sockPeerName(request, response);
        if (strSockPeerName == null || strSockPeerName.equals(strExtractPeerName)) {
            return;
        }
        AttributesExtractorUtil.internalSet(attributesBuilder, SemanticAttributes.NET_SOCK_PEER_NAME, strSockPeerName);
    }

    private String extractPeerName(REQUEST request) {
        String strPeerName = this.getter.peerName(request);
        return strPeerName == null ? this.fallbackNamePortGetter.name(request) : strPeerName;
    }

    private Integer extractPeerPort(REQUEST request) {
        Integer numPeerPort = this.getter.peerPort(request);
        return numPeerPort == null ? this.fallbackNamePortGetter.port(request) : numPeerPort;
    }
}
