package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;

/* JADX INFO: loaded from: classes4.dex */
public interface SynchronousMetricStorage extends MetricStorage, WriteableMetricStorage {
    static SynchronousMetricStorage empty() {
        return EmptyMetricStorage.INSTANCE;
    }

    static <T, U extends ExemplarData> SynchronousMetricStorage create(RegisteredReader registeredReader, RegisteredView registeredView, InstrumentDescriptor instrumentDescriptor, ExemplarFilter exemplarFilter) {
        View view = registeredView.getView();
        MetricDescriptor metricDescriptorCreate = MetricDescriptor.create(view, registeredView.getViewSourceInfo(), instrumentDescriptor);
        Aggregator<T, U> aggregatorCreateAggregator = ((AggregatorFactory) view.getAggregation()).createAggregator(instrumentDescriptor, exemplarFilter);
        if (Aggregator.drop() == aggregatorCreateAggregator) {
            return empty();
        }
        return new DefaultSynchronousMetricStorage(registeredReader, metricDescriptorCreate, aggregatorCreateAggregator, registeredView.getViewAttributesProcessor());
    }
}
