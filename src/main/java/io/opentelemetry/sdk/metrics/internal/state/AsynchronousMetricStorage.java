package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import io.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
final class AsynchronousMetricStorage<T, U extends ExemplarData> implements MetricStorage {
    private static final Logger logger = Logger.getLogger(AsynchronousMetricStorage.class.getName());
    private final Aggregator<T, U> aggregator;
    private final AttributesProcessor attributesProcessor;
    private final MetricDescriptor metricDescriptor;
    private final TemporalMetricStorage<T, U> metricStorage;
    private final RegisteredReader registeredReader;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);
    private Map<Attributes, T> accumulations = new HashMap();

    private AsynchronousMetricStorage(RegisteredReader registeredReader, MetricDescriptor metricDescriptor, Aggregator<T, U> aggregator, AttributesProcessor attributesProcessor) {
        this.registeredReader = registeredReader;
        this.metricDescriptor = metricDescriptor;
        this.metricStorage = new TemporalMetricStorage<>(aggregator, false, registeredReader, registeredReader.getReader().getAggregationTemporality(metricDescriptor.getSourceInstrument().getType()), metricDescriptor);
        this.aggregator = aggregator;
        this.attributesProcessor = attributesProcessor;
    }

    static <T, U extends ExemplarData> AsynchronousMetricStorage<T, U> create(RegisteredReader registeredReader, RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor) {
        View view = registeredView.getView();
        return new AsynchronousMetricStorage<>(registeredReader, MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor), ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, ExemplarFilter.alwaysOff()), registeredView.getViewAttributesProcessor());
    }

    void recordLong(long j, Attributes attributes) {
        T tAccumulateLongMeasurement = this.aggregator.accumulateLongMeasurement(j, attributes, Context.current());
        if (tAccumulateLongMeasurement != null) {
            recordAccumulation(tAccumulateLongMeasurement, attributes);
        }
    }

    void recordDouble(double d, Attributes attributes) {
        T tAccumulateDoubleMeasurement = this.aggregator.accumulateDoubleMeasurement(d, attributes, Context.current());
        if (tAccumulateDoubleMeasurement != null) {
            recordAccumulation(tAccumulateDoubleMeasurement, attributes);
        }
    }

    private void recordAccumulation(T t, Attributes attributes) {
        Attributes attributesProcess = this.attributesProcessor.process(attributes, Context.current());
        if (this.accumulations.size() >= 2000) {
            this.throttlingLogger.log(Level.WARNING, "Instrument " + this.metricDescriptor.getSourceInstrument().getName() + " has exceeded the maximum allowed accumulations (2000).");
        } else if (this.accumulations.containsKey(attributes)) {
            this.throttlingLogger.log(Level.WARNING, "Instrument " + this.metricDescriptor.getSourceInstrument().getName() + " has recorded multiple values for the same attributes.");
        } else {
            this.accumulations.put(attributesProcess, t);
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public RegisteredReader getRegisteredReader() {
        return this.registeredReader;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2) {
        Map<Attributes, T> map = this.accumulations;
        this.accumulations = new HashMap();
        return this.metricStorage.buildMetricFor(resource, instrumentationScopeInfo, map, j, j2);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public boolean isEmpty() {
        return this.aggregator == Aggregator.drop();
    }
}
