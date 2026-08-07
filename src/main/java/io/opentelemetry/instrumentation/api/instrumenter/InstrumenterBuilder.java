package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapSetter;
import io.opentelemetry.instrumentation.api.internal.ConfigPropertiesUtil;
import io.opentelemetry.instrumentation.api.internal.EmbeddedInstrumentationProperties;
import io.opentelemetry.instrumentation.api.internal.SpanKey;
import io.opentelemetry.instrumentation.api.internal.SpanKeyProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class InstrumenterBuilder<REQUEST, RESPONSE> {
    private static final SpanSuppressionStrategy spanSuppressionStrategy = SpanSuppressionStrategy.fromConfig(ConfigPropertiesUtil.getString("otel.instrumentation.experimental.span-suppression-strategy"));
    final String instrumentationName;

    @Nullable
    private String instrumentationVersion;
    final OpenTelemetry openTelemetry;
    final SpanNameExtractor<? super REQUEST> spanNameExtractor;
    final List<SpanLinksExtractor<? super REQUEST>> spanLinksExtractors = new ArrayList();
    final List<AttributesExtractor<? super REQUEST, ? super RESPONSE>> attributesExtractors = new ArrayList();
    final List<ContextCustomizer<? super REQUEST>> contextCustomizers = new ArrayList();
    private final List<OperationListener> operationListeners = new ArrayList();
    private final List<OperationMetrics> operationMetrics = new ArrayList();

    @Nullable
    private String schemaUrl = null;
    SpanKindExtractor<? super REQUEST> spanKindExtractor = SpanKindExtractor.alwaysInternal();
    SpanStatusExtractor<? super REQUEST, ? super RESPONSE> spanStatusExtractor = SpanStatusExtractor.getDefault();
    ErrorCauseExtractor errorCauseExtractor = ErrorCauseExtractor.getDefault();
    boolean enabled = true;

    InstrumenterBuilder(OpenTelemetry openTelemetry, String str, SpanNameExtractor<? super REQUEST> spanNameExtractor) {
        this.openTelemetry = openTelemetry;
        this.instrumentationName = str;
        this.spanNameExtractor = spanNameExtractor;
        this.instrumentationVersion = EmbeddedInstrumentationProperties.findVersion(str);
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> setInstrumentationVersion(String str) {
        this.instrumentationVersion = (String) Objects.requireNonNull(str, "instrumentationVersion");
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> setSchemaUrl(String str) {
        this.schemaUrl = (String) Objects.requireNonNull(str, "schemaUrl");
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> setSpanStatusExtractor(SpanStatusExtractor<? super REQUEST, ? super RESPONSE> spanStatusExtractor) {
        this.spanStatusExtractor = (SpanStatusExtractor) Objects.requireNonNull(spanStatusExtractor, "spanStatusExtractor");
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addAttributesExtractor(AttributesExtractor<? super REQUEST, ? super RESPONSE> attributesExtractor) {
        this.attributesExtractors.add((AttributesExtractor) Objects.requireNonNull(attributesExtractor, "attributesExtractor"));
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addAttributesExtractors(Iterable<? extends AttributesExtractor<? super REQUEST, ? super RESPONSE>> iterable) {
        iterable.forEach(new Consumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.addAttributesExtractor((AttributesExtractor) obj);
            }
        });
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addSpanLinksExtractor(SpanLinksExtractor<REQUEST> spanLinksExtractor) {
        this.spanLinksExtractors.add((SpanLinksExtractor) Objects.requireNonNull(spanLinksExtractor, "spanLinksExtractor"));
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addContextCustomizer(ContextCustomizer<? super REQUEST> contextCustomizer) {
        this.contextCustomizers.add((ContextCustomizer) Objects.requireNonNull(contextCustomizer, "contextCustomizer"));
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addOperationListener(OperationListener operationListener) {
        this.operationListeners.add((OperationListener) Objects.requireNonNull(operationListener, "operationListener"));
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> addOperationMetrics(OperationMetrics operationMetrics) {
        this.operationMetrics.add((OperationMetrics) Objects.requireNonNull(operationMetrics, "operationMetrics"));
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> setErrorCauseExtractor(ErrorCauseExtractor errorCauseExtractor) {
        this.errorCauseExtractor = (ErrorCauseExtractor) Objects.requireNonNull(errorCauseExtractor, "errorCauseExtractor");
        return this;
    }

    public InstrumenterBuilder<REQUEST, RESPONSE> setEnabled(boolean z) {
        this.enabled = z;
        return this;
    }

    public Instrumenter<REQUEST, RESPONSE> buildClientInstrumenter(TextMapSetter<REQUEST> textMapSetter) {
        return buildInstrumenter(InstrumenterConstructor.propagatingToDownstream((TextMapSetter) Objects.requireNonNull(textMapSetter, "setter")), SpanKindExtractor.alwaysClient());
    }

    public Instrumenter<REQUEST, RESPONSE> buildServerInstrumenter(TextMapGetter<REQUEST> textMapGetter) {
        return buildInstrumenter(InstrumenterConstructor.propagatingFromUpstream((TextMapGetter) Objects.requireNonNull(textMapGetter, "getter")), SpanKindExtractor.alwaysServer());
    }

    public Instrumenter<REQUEST, RESPONSE> buildProducerInstrumenter(TextMapSetter<REQUEST> textMapSetter) {
        return buildInstrumenter(InstrumenterConstructor.propagatingToDownstream((TextMapSetter) Objects.requireNonNull(textMapSetter, "setter")), SpanKindExtractor.alwaysProducer());
    }

    public Instrumenter<REQUEST, RESPONSE> buildConsumerInstrumenter(TextMapGetter<REQUEST> textMapGetter) {
        return buildInstrumenter(InstrumenterConstructor.propagatingFromUpstream((TextMapGetter) Objects.requireNonNull(textMapGetter, "getter")), SpanKindExtractor.alwaysConsumer());
    }

    public Instrumenter<REQUEST, RESPONSE> buildInstrumenter() {
        return buildInstrumenter(InstrumenterConstructor.internal(), SpanKindExtractor.alwaysInternal());
    }

    public Instrumenter<REQUEST, RESPONSE> buildInstrumenter(SpanKindExtractor<? super REQUEST> spanKindExtractor) {
        return buildInstrumenter(InstrumenterConstructor.internal(), (SpanKindExtractor) Objects.requireNonNull(spanKindExtractor, "spanKindExtractor"));
    }

    private Instrumenter<REQUEST, RESPONSE> buildInstrumenter(InstrumenterConstructor<REQUEST, RESPONSE> instrumenterConstructor, SpanKindExtractor<? super REQUEST> spanKindExtractor) {
        this.spanKindExtractor = spanKindExtractor;
        return instrumenterConstructor.create(this);
    }

    Tracer buildTracer() {
        TracerBuilder tracerBuilder = this.openTelemetry.getTracerProvider().tracerBuilder(this.instrumentationName);
        String str = this.instrumentationVersion;
        if (str != null) {
            tracerBuilder.setInstrumentationVersion(str);
        }
        String str2 = this.schemaUrl;
        if (str2 != null) {
            tracerBuilder.setSchemaUrl(str2);
        }
        return tracerBuilder.build();
    }

    List<OperationListener> buildOperationListeners() {
        if (this.operationMetrics.isEmpty()) {
            return new ArrayList(this.operationListeners);
        }
        ArrayList arrayList = new ArrayList(this.operationListeners.size() + this.operationMetrics.size());
        arrayList.addAll(this.operationListeners);
        MeterBuilder meterBuilder = this.openTelemetry.getMeterProvider().meterBuilder(this.instrumentationName);
        String str = this.instrumentationVersion;
        if (str != null) {
            meterBuilder.setInstrumentationVersion(str);
        }
        String str2 = this.schemaUrl;
        if (str2 != null) {
            meterBuilder.setSchemaUrl(str2);
        }
        Meter meterBuild = meterBuilder.build();
        Iterator<OperationMetrics> it = this.operationMetrics.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().create(meterBuild));
        }
        return arrayList;
    }

    SpanSuppressor buildSpanSuppressor() {
        return spanSuppressionStrategy.create(getSpanKeysFromAttributesExtractors());
    }

    private Set<SpanKey> getSpanKeysFromAttributesExtractors() {
        Stream<AttributesExtractor<? super REQUEST, ? super RESPONSE>> stream = this.attributesExtractors.stream();
        final Class<SpanKeyProvider> cls = SpanKeyProvider.class;
        Objects.requireNonNull(SpanKeyProvider.class);
        Stream<AttributesExtractor<? super REQUEST, ? super RESPONSE>> streamFilter = stream.filter(new Predicate() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((AttributesExtractor) obj);
            }
        });
        final Class<SpanKeyProvider> cls2 = SpanKeyProvider.class;
        Objects.requireNonNull(SpanKeyProvider.class);
        return (Set) streamFilter.map(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (SpanKeyProvider) cls2.cast((AttributesExtractor) obj);
            }
        }).flatMap(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return InstrumenterBuilder.lambda$getSpanKeysFromAttributesExtractors$0((SpanKeyProvider) obj);
            }
        }).collect(Collectors.toSet());
    }

    static /* synthetic */ Stream lambda$getSpanKeysFromAttributesExtractors$0(SpanKeyProvider spanKeyProvider) {
        SpanKey spanKeyInternalGetSpanKey = spanKeyProvider.internalGetSpanKey();
        return spanKeyInternalGetSpanKey == null ? Stream.of((Object[]) new SpanKey[0]) : Stream.of(spanKeyInternalGetSpanKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface InstrumenterConstructor<RQ, RS> {
        Instrumenter<RQ, RS> create(InstrumenterBuilder<RQ, RS> instrumenterBuilder);

        static <RQ, RS> InstrumenterConstructor<RQ, RS> internal() {
            return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                    return new Instrumenter(instrumenterBuilder);
                }
            };
        }

        static /* synthetic */ Instrumenter lambda$propagatingToDownstream$0(TextMapSetter textMapSetter, InstrumenterBuilder instrumenterBuilder) {
            return new PropagatingToDownstreamInstrumenter(instrumenterBuilder, textMapSetter);
        }

        static <RQ, RS> InstrumenterConstructor<RQ, RS> propagatingToDownstream(final TextMapSetter<RQ> textMapSetter) {
            return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                    return InstrumenterBuilder.InstrumenterConstructor.lambda$propagatingToDownstream$0(textMapSetter, instrumenterBuilder);
                }
            };
        }

        static /* synthetic */ Instrumenter lambda$propagatingFromUpstream$1(TextMapGetter textMapGetter, InstrumenterBuilder instrumenterBuilder) {
            return new PropagatingFromUpstreamInstrumenter(instrumenterBuilder, textMapGetter);
        }

        static <RQ, RS> InstrumenterConstructor<RQ, RS> propagatingFromUpstream(final TextMapGetter<RQ> textMapGetter) {
            return new InstrumenterConstructor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder$InstrumenterConstructor$$ExternalSyntheticLambda2
                @Override // io.opentelemetry.instrumentation.api.instrumenter.InstrumenterBuilder.InstrumenterConstructor
                public final Instrumenter create(InstrumenterBuilder instrumenterBuilder) {
                    return InstrumenterBuilder.InstrumenterConstructor.lambda$propagatingFromUpstream$1(textMapGetter, instrumenterBuilder);
                }
            };
        }
    }
}
