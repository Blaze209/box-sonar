package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
final class TemporaryMetricsView {
    private static final Set<AttributeKey> durationAlwaysInclude = buildDurationAlwaysInclude();
    private static final Set<AttributeKey> durationClientView = buildDurationClientView();
    private static final Set<AttributeKey> durationServerView = buildDurationServerView();
    private static final Set<AttributeKey> activeRequestsView = buildActiveRequestsView();

    private static Set<AttributeKey> buildDurationAlwaysInclude() {
        HashSet hashSet = new HashSet();
        hashSet.add(SemanticAttributes.HTTP_METHOD);
        hashSet.add(SemanticAttributes.HTTP_STATUS_CODE);
        hashSet.add(SemanticAttributes.HTTP_FLAVOR);
        return hashSet;
    }

    private static Set<AttributeKey> buildDurationClientView() {
        HashSet hashSet = new HashSet(durationAlwaysInclude);
        hashSet.add(SemanticAttributes.NET_PEER_NAME);
        hashSet.add(SemanticAttributes.NET_PEER_PORT);
        hashSet.add(AttributeKey.stringKey("net.peer.sock.addr"));
        return hashSet;
    }

    private static Set<AttributeKey> buildDurationServerView() {
        HashSet hashSet = new HashSet(durationAlwaysInclude);
        hashSet.add(SemanticAttributes.HTTP_SCHEME);
        hashSet.add(SemanticAttributes.NET_HOST_NAME);
        hashSet.add(SemanticAttributes.NET_HOST_PORT);
        hashSet.add(SemanticAttributes.HTTP_ROUTE);
        return hashSet;
    }

    private static Set<AttributeKey> buildActiveRequestsView() {
        HashSet hashSet = new HashSet();
        hashSet.add(SemanticAttributes.HTTP_METHOD);
        hashSet.add(SemanticAttributes.HTTP_SCHEME);
        hashSet.add(SemanticAttributes.HTTP_FLAVOR);
        hashSet.add(SemanticAttributes.NET_HOST_NAME);
        return hashSet;
    }

    static Attributes applyClientDurationAndSizeView(Attributes attributes, Attributes attributes2) {
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        Set<AttributeKey> set = durationClientView;
        applyView(attributesBuilderBuilder, attributes, set);
        applyView(attributesBuilderBuilder, attributes2, set);
        return attributesBuilderBuilder.build();
    }

    static Attributes applyServerDurationAndSizeView(Attributes attributes, Attributes attributes2) {
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        Set<AttributeKey> set = durationServerView;
        applyView(attributesBuilderBuilder, attributes, set);
        applyView(attributesBuilderBuilder, attributes2, set);
        return attributesBuilderBuilder.build();
    }

    static Attributes applyActiveRequestsView(Attributes attributes) {
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        applyView(attributesBuilderBuilder, attributes, activeRequestsView);
        return attributesBuilderBuilder.build();
    }

    private static void applyView(final AttributesBuilder attributesBuilder, Attributes attributes, final Set<AttributeKey> set) {
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.TemporaryMetricsView$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                TemporaryMetricsView.lambda$applyView$0(set, attributesBuilder, (AttributeKey) obj, obj2);
            }
        });
    }

    static /* synthetic */ void lambda$applyView$0(Set set, AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object obj) {
        if (set.contains(attributeKey)) {
            attributesBuilder.put((AttributeKey<Object>) attributeKey, obj);
        }
    }

    private TemporaryMetricsView() {
    }
}
