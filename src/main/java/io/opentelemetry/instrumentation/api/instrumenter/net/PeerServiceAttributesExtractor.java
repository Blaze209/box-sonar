package io.opentelemetry.instrumentation.api.instrumenter.net;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class PeerServiceAttributesExtractor<REQUEST, RESPONSE> implements AttributesExtractor<REQUEST, RESPONSE> {
    private final NetClientAttributesGetter<REQUEST, RESPONSE> attributesGetter;
    private final Map<String, String> peerServiceMapping;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request) {
    }

    PeerServiceAttributesExtractor(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter, Map<String, String> map) {
        this.attributesGetter = netClientAttributesGetter;
        this.peerServiceMapping = map;
    }

    public static <REQUEST, RESPONSE> PeerServiceAttributesExtractor<REQUEST, RESPONSE> create(NetClientAttributesGetter<REQUEST, RESPONSE> netClientAttributesGetter, Map<String, String> map) {
        return new PeerServiceAttributesExtractor<>(netClientAttributesGetter, map);
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th) {
        String strMapToPeerService;
        if (this.peerServiceMapping.isEmpty() || (strMapToPeerService = mapToPeerService(this.attributesGetter.peerName(request))) == null) {
            return;
        }
        attributesBuilder.put(SemanticAttributes.PEER_SERVICE, strMapToPeerService);
    }

    @Nullable
    private String mapToPeerService(String str) {
        if (str == null) {
            return null;
        }
        return this.peerServiceMapping.get(str);
    }
}
