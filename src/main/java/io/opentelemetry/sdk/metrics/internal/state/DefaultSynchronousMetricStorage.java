package io.opentelemetry.sdk.metrics.internal.state;

import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import io.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultSynchronousMetricStorage<T, U extends ExemplarData> implements SynchronousMetricStorage {
    private final Aggregator<T, U> aggregator;
    private final AttributesProcessor attributesProcessor;
    private final MetricDescriptor metricDescriptor;
    private final RegisteredReader registeredReader;
    private final TemporalMetricStorage<T, U> temporalMetricStorage;
    private static final ThrottlingLogger logger = new ThrottlingLogger(Logger.getLogger(DefaultSynchronousMetricStorage.class.getName()));
    private static final BoundStorageHandle NOOP_STORAGE_HANDLE = new NoopBoundHandle();
    private final ConcurrentHashMap<Attributes, AggregatorHandle<T, U>> activeCollectionStorage = new ConcurrentHashMap<>();
    private final BoundStorageHandle lateBoundStorageHandle = new BoundStorageHandle() { // from class: io.opentelemetry.sdk.metrics.internal.state.DefaultSynchronousMetricStorage.1
        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j, Attributes attributes, Context context) {
            DefaultSynchronousMetricStorage.this.recordLong(j, attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d, Attributes attributes, Context context) {
            DefaultSynchronousMetricStorage.this.recordDouble(d, attributes, context);
        }
    };

    DefaultSynchronousMetricStorage(RegisteredReader registeredReader, MetricDescriptor metricDescriptor, Aggregator<T, U> aggregator, AttributesProcessor attributesProcessor) {
        this.registeredReader = registeredReader;
        this.metricDescriptor = metricDescriptor;
        AggregationTemporality aggregationTemporality = registeredReader.getReader().getAggregationTemporality(metricDescriptor.getSourceInstrument().getType());
        this.aggregator = aggregator;
        this.temporalMetricStorage = new TemporalMetricStorage<>(aggregator, true, registeredReader, aggregationTemporality, metricDescriptor);
        this.attributesProcessor = attributesProcessor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public BoundStorageHandle bind(Attributes attributes) {
        Objects.requireNonNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
        if (this.attributesProcessor.usesContext()) {
            return this.lateBoundStorageHandle;
        }
        return doBind(this.attributesProcessor.process(attributes, Context.current()));
    }

    private BoundStorageHandle doBind(Attributes attributes) {
        AggregatorHandle<T, U> aggregatorHandle = this.activeCollectionStorage.get(attributes);
        if (aggregatorHandle != null && aggregatorHandle.acquire()) {
            return aggregatorHandle;
        }
        AggregatorHandle<T, U> aggregatorHandleCreateHandle = this.aggregator.createHandle();
        while (this.activeCollectionStorage.size() < 2000) {
            AggregatorHandle<T, U> aggregatorHandlePutIfAbsent = this.activeCollectionStorage.putIfAbsent(attributes, aggregatorHandleCreateHandle);
            if (aggregatorHandlePutIfAbsent == null) {
                return aggregatorHandleCreateHandle;
            }
            if (aggregatorHandlePutIfAbsent.acquire()) {
                return aggregatorHandlePutIfAbsent;
            }
            this.activeCollectionStorage.remove(attributes, aggregatorHandlePutIfAbsent);
        }
        logger.log(Level.WARNING, "Instrument " + this.metricDescriptor.getSourceInstrument().getName() + " has exceeded the maximum allowed accumulations (2000).");
        return NOOP_STORAGE_HANDLE;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public void recordLong(long j, Attributes attributes, Context context) {
        Objects.requireNonNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
        Attributes attributesProcess = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle boundStorageHandleDoBind = doBind(attributesProcess);
        try {
            boundStorageHandleDoBind.recordLong(j, attributesProcess, context);
        } finally {
            boundStorageHandleDoBind.release();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage
    public void recordDouble(double d, Attributes attributes, Context context) {
        Objects.requireNonNull(attributes, NativeAuthConstants.GrantType.ATTRIBUTES);
        Attributes attributesProcess = this.attributesProcessor.process(attributes, context);
        BoundStorageHandle boundStorageHandleDoBind = doBind(attributesProcess);
        try {
            boundStorageHandleDoBind.recordDouble(d, attributesProcess, context);
        } finally {
            boundStorageHandleDoBind.release();
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2) {
        HashMap map = new HashMap();
        for (Map.Entry<Attributes, AggregatorHandle<T, U>> entry : this.activeCollectionStorage.entrySet()) {
            if (entry.getValue().tryUnmap()) {
                this.activeCollectionStorage.remove(entry.getKey(), entry.getValue());
            }
            T tAccumulateThenReset = entry.getValue().accumulateThenReset(entry.getKey());
            if (tAccumulateThenReset != null) {
                map.put(entry.getKey(), tAccumulateThenReset);
            }
        }
        return this.temporalMetricStorage.buildMetricFor(resource, instrumentationScopeInfo, map, j, j2);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.state.MetricStorage
    public RegisteredReader getRegisteredReader() {
        return this.registeredReader;
    }

    private static class NoopBoundHandle implements BoundStorageHandle {
        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordDouble(double d, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void recordLong(long j, Attributes attributes, Context context) {
        }

        @Override // io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle
        public void release() {
        }

        private NoopBoundHandle() {
        }
    }
}
