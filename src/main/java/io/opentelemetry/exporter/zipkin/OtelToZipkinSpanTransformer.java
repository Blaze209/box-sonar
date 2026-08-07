package io.opentelemetry.exporter.zipkin;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributeType;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.data.EventData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import zipkin2.Endpoint;
import zipkin2.Span;

/* JADX INFO: loaded from: classes4.dex */
final class OtelToZipkinSpanTransformer {
    static final String KEY_INSTRUMENTATION_LIBRARY_NAME = "otel.library.name";
    static final String KEY_INSTRUMENTATION_LIBRARY_VERSION = "otel.library.version";
    static final String KEY_INSTRUMENTATION_SCOPE_NAME = "otel.scope.name";
    static final String KEY_INSTRUMENTATION_SCOPE_VERSION = "otel.scope.version";
    static final String OTEL_DROPPED_ATTRIBUTES_COUNT = "otel.dropped_attributes_count";
    static final String OTEL_DROPPED_EVENTS_COUNT = "otel.dropped_events_count";
    static final String OTEL_STATUS_CODE = "otel.status_code";
    static final AttributeKey<String> STATUS_ERROR = AttributeKey.stringKey("error");
    private final Supplier<InetAddress> ipAddressSupplier;

    static OtelToZipkinSpanTransformer create(Supplier<InetAddress> supplier) {
        return new OtelToZipkinSpanTransformer(supplier);
    }

    private OtelToZipkinSpanTransformer(Supplier<InetAddress> supplier) {
        this.ipAddressSupplier = supplier;
    }

    Span generateSpan(SpanData spanData) {
        long epochMicros = toEpochMicros(spanData.getStartEpochNanos());
        final Span.Builder builderRemoteEndpoint = Span.newBuilder().traceId(spanData.getTraceId()).id(spanData.getSpanId()).kind(toSpanKind(spanData)).name(spanData.getName()).timestamp(toEpochMicros(spanData.getStartEpochNanos())).duration(Math.max(1L, toEpochMicros(spanData.getEndEpochNanos()) - epochMicros)).localEndpoint(getLocalEndpoint(spanData)).remoteEndpoint(getRemoteEndpoint(spanData));
        if (spanData.getParentSpanContext().isValid()) {
            builderRemoteEndpoint.parentId(spanData.getParentSpanId());
        }
        Attributes attributes = spanData.getAttributes();
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.exporter.zipkin.OtelToZipkinSpanTransformer$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AttributeKey attributeKey = (AttributeKey) obj;
                builderRemoteEndpoint.putTag(attributeKey.getKey(), OtelToZipkinSpanTransformer.valueToString(attributeKey, obj2));
            }
        });
        int totalAttributeCount = spanData.getTotalAttributeCount() - attributes.size();
        if (totalAttributeCount > 0) {
            builderRemoteEndpoint.putTag(OTEL_DROPPED_ATTRIBUTES_COUNT, String.valueOf(totalAttributeCount));
        }
        StatusData status = spanData.getStatus();
        if (status.getStatusCode() != StatusCode.UNSET) {
            builderRemoteEndpoint.putTag(OTEL_STATUS_CODE, status.getStatusCode().toString());
            if (status.getStatusCode() == StatusCode.ERROR) {
                AttributeKey<String> attributeKey = STATUS_ERROR;
                if (attributes.get(attributeKey) == null) {
                    builderRemoteEndpoint.putTag(attributeKey.getKey(), nullToEmpty(status.getDescription()));
                }
            }
        }
        InstrumentationScopeInfo instrumentationScopeInfo = spanData.getInstrumentationScopeInfo();
        if (!instrumentationScopeInfo.getName().isEmpty()) {
            builderRemoteEndpoint.putTag(KEY_INSTRUMENTATION_SCOPE_NAME, instrumentationScopeInfo.getName());
            builderRemoteEndpoint.putTag(KEY_INSTRUMENTATION_LIBRARY_NAME, instrumentationScopeInfo.getName());
        }
        if (instrumentationScopeInfo.getVersion() != null) {
            builderRemoteEndpoint.putTag(KEY_INSTRUMENTATION_SCOPE_VERSION, instrumentationScopeInfo.getVersion());
            builderRemoteEndpoint.putTag(KEY_INSTRUMENTATION_LIBRARY_VERSION, instrumentationScopeInfo.getVersion());
        }
        for (EventData eventData : spanData.getEvents()) {
            builderRemoteEndpoint.addAnnotation(toEpochMicros(eventData.getEpochNanos()), EventDataToAnnotation.apply(eventData));
        }
        int totalRecordedEvents = spanData.getTotalRecordedEvents() - spanData.getEvents().size();
        if (totalRecordedEvents > 0) {
            builderRemoteEndpoint.putTag(OTEL_DROPPED_EVENTS_COUNT, String.valueOf(totalRecordedEvents));
        }
        return builderRemoteEndpoint.build();
    }

    private static String nullToEmpty(@Nullable String str) {
        return str != null ? str : "";
    }

    private Endpoint getLocalEndpoint(SpanData spanData) {
        Attributes attributes = spanData.getResource().getAttributes();
        Endpoint.Builder builderNewBuilder = Endpoint.newBuilder();
        builderNewBuilder.ip(this.ipAddressSupplier.get());
        String str = (String) attributes.get(ResourceAttributes.SERVICE_NAME);
        if (str == null) {
            str = (String) Resource.getDefault().getAttribute(ResourceAttributes.SERVICE_NAME);
        }
        if (str != null) {
            builderNewBuilder.serviceName(str);
        }
        return builderNewBuilder.build();
    }

    @Nullable
    private static Endpoint getRemoteEndpoint(SpanData spanData) {
        if (spanData.getKind() != SpanKind.CLIENT && spanData.getKind() != SpanKind.PRODUCER) {
            return null;
        }
        Attributes attributes = spanData.getAttributes();
        String str = (String) attributes.get(SemanticAttributes.PEER_SERVICE);
        if (str == null) {
            return null;
        }
        Endpoint.Builder builderNewBuilder = Endpoint.newBuilder();
        builderNewBuilder.serviceName(str);
        builderNewBuilder.ip((String) attributes.get(SemanticAttributes.NET_SOCK_PEER_ADDR));
        Long l = (Long) attributes.get(SemanticAttributes.NET_PEER_PORT);
        if (l != null) {
            builderNewBuilder.port(l.intValue());
        }
        return builderNewBuilder.build();
    }

    @Nullable
    private static Span.Kind toSpanKind(SpanData spanData) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$api$trace$SpanKind[spanData.getKind().ordinal()];
        if (i == 1) {
            return Span.Kind.SERVER;
        }
        if (i == 2) {
            return Span.Kind.CLIENT;
        }
        if (i == 3) {
            return Span.Kind.PRODUCER;
        }
        if (i != 4) {
            return null;
        }
        return Span.Kind.CONSUMER;
    }

    private static long toEpochMicros(long j) {
        return TimeUnit.NANOSECONDS.toMicros(j);
    }

    /* JADX INFO: renamed from: io.opentelemetry.exporter.zipkin.OtelToZipkinSpanTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$common$AttributeType;
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$trace$SpanKind;

        static {
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$io$opentelemetry$api$common$AttributeType = iArr;
            try {
                iArr[AttributeType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.STRING_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.LONG_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SpanKind.values().length];
            $SwitchMap$io$opentelemetry$api$trace$SpanKind = iArr2;
            try {
                iArr2[SpanKind.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.PRODUCER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.CONSUMER.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$trace$SpanKind[SpanKind.INTERNAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static String valueToString(AttributeKey<?> attributeKey, Object obj) {
        AttributeType type = attributeKey.getType();
        switch (AnonymousClass1.$SwitchMap$io$opentelemetry$api$common$AttributeType[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return String.valueOf(obj);
            case 5:
            case 6:
            case 7:
            case 8:
                return commaSeparated((List) obj);
            default:
                throw new IllegalStateException("Unknown attribute type: " + type);
        }
    }

    private static String commaSeparated(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            if (sb.length() != 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
