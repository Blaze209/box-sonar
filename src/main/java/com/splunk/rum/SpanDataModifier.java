package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
final class SpanDataModifier implements SpanExporter {
    private final SpanExporter delegate;
    private final Map<AttributeKey<?>, Predicate<?>> rejectSpanAttributesPredicates;
    private final Predicate<String> rejectSpanNamesPredicate;
    private final Map<AttributeKey<?>, Function<?, ?>> spanAttributeReplacements;

    SpanDataModifier(SpanExporter spanExporter, Predicate<String> predicate, Map<AttributeKey<?>, Predicate<?>> map, Map<AttributeKey<?>, Function<?, ?>> map2) {
        this.delegate = spanExporter;
        this.rejectSpanNamesPredicate = predicate;
        this.rejectSpanAttributesPredicates = map;
        this.spanAttributeReplacements = map2;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        ArrayList arrayList = new ArrayList();
        for (SpanData spanData : collection) {
            if (!reject(spanData)) {
                arrayList.add(modify(spanData));
            }
        }
        return this.delegate.export(arrayList);
    }

    private boolean reject(SpanData spanData) {
        if (this.rejectSpanNamesPredicate.test(spanData.getName())) {
            return true;
        }
        Attributes attributes = spanData.getAttributes();
        for (Map.Entry<AttributeKey<?>, Predicate<?>> entry : this.rejectSpanAttributesPredicates.entrySet()) {
            AttributeKey<?> key = entry.getKey();
            Predicate<?> value = entry.getValue();
            if (attributes.get(key) != null && value.test(attributes.get(key))) {
                return true;
            }
        }
        return false;
    }

    private SpanData modify(SpanData spanData) {
        if (this.spanAttributeReplacements.isEmpty()) {
            return spanData;
        }
        final AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        spanData.getAttributes().forEach(new BiConsumer() { // from class: com.splunk.rum.SpanDataModifier$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m14345lambda$modify$0$comsplunkrumSpanDataModifier(attributesBuilderBuilder, (AttributeKey) obj, obj2);
            }
        });
        return new ModifiedSpanData(spanData, attributesBuilderBuilder.build());
    }

    /* JADX INFO: renamed from: lambda$modify$0$com-splunk-rum-SpanDataModifier, reason: not valid java name */
    /* synthetic */ void m14345lambda$modify$0$comsplunkrumSpanDataModifier(AttributesBuilder attributesBuilder, AttributeKey attributeKey, Object obj) {
        Object objApply = this.spanAttributeReplacements.getOrDefault(attributeKey, Function.identity()).apply(obj);
        if (objApply != null) {
            attributesBuilder.put((AttributeKey<Object>) attributeKey, objApply);
        }
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return this.delegate.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return this.delegate.shutdown();
    }
}
