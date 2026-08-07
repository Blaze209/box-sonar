package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.DelegatingSpanData;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
final class SplunkSpanDataModifier implements SpanExporter {
    private final SpanExporter delegate;
    private final boolean reactNativeEnabled;
    static final AttributeKey<String> SPLUNK_OPERATION_KEY = AttributeKey.stringKey("_splunk_operation");
    static final AttributeKey<String> REACT_NATIVE_TRACE_ID_KEY = AttributeKey.stringKey("_reactnative_traceId");
    static final AttributeKey<String> REACT_NATIVE_SPAN_ID_KEY = AttributeKey.stringKey("_reactnative_spanId");
    private static final Set<AttributeKey<String>> resourceAttributesToCopy = Collections.unmodifiableSet(new HashSet(Arrays.asList(ResourceAttributes.DEPLOYMENT_ENVIRONMENT, ResourceAttributes.DEVICE_MODEL_NAME, ResourceAttributes.DEVICE_MODEL_IDENTIFIER, ResourceAttributes.OS_NAME, ResourceAttributes.OS_TYPE, ResourceAttributes.OS_VERSION, SplunkRum.APP_NAME_KEY, SplunkRum.RUM_VERSION_KEY)));

    SplunkSpanDataModifier(SpanExporter spanExporter, boolean z) {
        this.delegate = spanExporter;
        this.reactNativeEnabled = z;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        return this.delegate.export((Collection) collection.stream().map(new Function() { // from class: com.splunk.rum.SplunkSpanDataModifier$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.modify((SpanData) obj);
            }
        }).collect(Collectors.toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpanData modify(SpanData spanData) {
        SpanContext spanContext;
        ArrayList arrayList = new ArrayList(spanData.getEvents().size());
        AttributesBuilder builder = spanData.getAttributes().toBuilder();
        if (this.reactNativeEnabled) {
            spanContext = extractReactNativeIdsIfPresent(spanData);
            builder.remove(REACT_NATIVE_TRACE_ID_KEY);
            builder.remove(REACT_NATIVE_SPAN_ID_KEY);
        } else {
            spanContext = spanData.getSpanContext();
        }
        SpanContext spanContext2 = spanContext;
        for (EventData eventData : spanData.getEvents()) {
            if (eventData.getName().equals("exception")) {
                builder.putAll(extractExceptionAttributes(eventData));
            } else {
                arrayList.add(eventData);
            }
        }
        builder.put(SPLUNK_OPERATION_KEY, spanData.getName());
        for (AttributeKey<String> attributeKey : resourceAttributesToCopy) {
            String str = (String) spanData.getResource().getAttribute(attributeKey);
            if (str != null) {
                builder.put(attributeKey, str);
            }
        }
        return new SplunkSpan(spanData, spanContext2, arrayList, builder.build());
    }

    private SpanContext extractReactNativeIdsIfPresent(SpanData spanData) {
        Attributes attributes = spanData.getAttributes();
        SpanContext spanContext = spanData.getSpanContext();
        String str = (String) attributes.get(REACT_NATIVE_TRACE_ID_KEY);
        String str2 = (String) attributes.get(REACT_NATIVE_SPAN_ID_KEY);
        if (str == null || str2 == null) {
            return spanContext;
        }
        if (spanContext.isRemote()) {
            return SpanContext.createFromRemoteParent(str, str2, spanContext.getTraceFlags(), spanContext.getTraceState());
        }
        return SpanContext.create(str, str2, spanContext.getTraceFlags(), spanContext.getTraceState());
    }

    private static Attributes extractExceptionAttributes(EventData eventData) {
        String strSubstring = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_TYPE);
        String str = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_MESSAGE);
        String str2 = (String) eventData.getAttributes().get(SemanticAttributes.EXCEPTION_STACKTRACE);
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        if (strSubstring != null) {
            int iLastIndexOf = strSubstring.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                strSubstring = strSubstring.substring(iLastIndexOf + 1);
            }
            attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_TYPE, strSubstring);
            attributesBuilderBuilder.put(SplunkRum.ERROR_TYPE_KEY, strSubstring);
        }
        if (str != null) {
            attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_MESSAGE, str);
            attributesBuilderBuilder.put(SplunkRum.ERROR_MESSAGE_KEY, str);
        }
        if (str2 != null) {
            attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_STACKTRACE, str2);
        }
        return attributesBuilderBuilder.build();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return this.delegate.flush();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return this.delegate.shutdown();
    }

    private static final class SplunkSpan extends DelegatingSpanData {
        private final Attributes modifiedAttributes;
        private final List<EventData> modifiedEvents;
        private final SpanContext spanContext;

        private SplunkSpan(SpanData spanData, SpanContext spanContext, List<EventData> list, Attributes attributes) {
            super(spanData);
            this.spanContext = spanContext;
            this.modifiedEvents = list;
            this.modifiedAttributes = attributes;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public SpanContext getSpanContext() {
            return this.spanContext;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public List<EventData> getEvents() {
            return this.modifiedEvents;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public int getTotalRecordedEvents() {
            return this.modifiedEvents.size();
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public Attributes getAttributes() {
            return this.modifiedAttributes;
        }

        @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
        public int getTotalAttributeCount() {
            return this.modifiedAttributes.size();
        }
    }
}
