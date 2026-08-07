package io.opentelemetry.instrumentation.api.instrumenter.rpc;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
final class MetricsView {
    private static final Set<AttributeKey> alwaysInclude = buildAlwaysInclude();
    private static final Set<AttributeKey> clientView = buildClientView();
    private static final Set<AttributeKey> serverView = buildServerView();
    private static final Set<AttributeKey> serverFallbackView = buildServerFallbackView();

    private static Set<AttributeKey> buildAlwaysInclude() {
        HashSet hashSet = new HashSet();
        hashSet.add(SemanticAttributes.RPC_SYSTEM);
        hashSet.add(SemanticAttributes.RPC_SERVICE);
        hashSet.add(SemanticAttributes.RPC_METHOD);
        hashSet.add(SemanticAttributes.RPC_GRPC_STATUS_CODE);
        return hashSet;
    }

    private static Set<AttributeKey> buildClientView() {
        HashSet hashSet = new HashSet(alwaysInclude);
        hashSet.add(SemanticAttributes.NET_PEER_NAME);
        hashSet.add(SemanticAttributes.NET_PEER_PORT);
        hashSet.add(SemanticAttributes.NET_TRANSPORT);
        return hashSet;
    }

    private static Set<AttributeKey> buildServerView() {
        HashSet hashSet = new HashSet(alwaysInclude);
        hashSet.add(SemanticAttributes.NET_HOST_NAME);
        hashSet.add(SemanticAttributes.NET_TRANSPORT);
        return hashSet;
    }

    private static Set<AttributeKey> buildServerFallbackView() {
        HashSet hashSet = new HashSet(alwaysInclude);
        hashSet.add(SemanticAttributes.NET_SOCK_HOST_ADDR);
        hashSet.add(SemanticAttributes.NET_TRANSPORT);
        return hashSet;
    }

    private static <T> boolean containsAttribute(AttributeKey<T> attributeKey, Attributes attributes, Attributes attributes2) {
        return (attributes.get(attributeKey) == null && attributes2.get(attributeKey) == null) ? false : true;
    }

    static Attributes applyClientView(Attributes attributes, Attributes attributes2) {
        return applyView(clientView, attributes, attributes2);
    }

    static Attributes applyServerView(Attributes attributes, Attributes attributes2) {
        Set<AttributeKey> set = serverView;
        if (!containsAttribute(SemanticAttributes.NET_HOST_NAME, attributes, attributes2)) {
            set = serverFallbackView;
        }
        return applyView(set, attributes, attributes2);
    }

    static Attributes applyView(Set<AttributeKey> set, Attributes attributes, Attributes attributes2) {
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        applyView(attributesBuilderBuilder, attributes, set);
        applyView(attributesBuilderBuilder, attributes2, set);
        return attributesBuilderBuilder.build();
    }

    private static void applyView(final AttributesBuilder attributesBuilder, Attributes attributes, final Set<AttributeKey> set) {
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.rpc.MetricsView$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MetricsView.lambda$applyView$0(set, attributesBuilder, (AttributeKey) obj, obj2);
            }
        });
    }

    static /* synthetic */ void lambda$applyView$0(Set set, AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object obj) {
        if (set.contains(attributeKey)) {
            attributesBuilder.put((AttributeKey<Object>) attributeKey, obj);
        }
    }

    private MetricsView() {
    }
}
