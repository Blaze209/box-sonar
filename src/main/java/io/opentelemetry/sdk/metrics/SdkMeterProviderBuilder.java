package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.view.RegisteredView;
import io.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkMeterProviderBuilder {
    private static final ExemplarFilter DEFAULT_EXEMPLAR_FILTER = ExemplarFilter.traceBased();
    private Clock clock = Clock.getDefault();
    private Resource resource = Resource.getDefault();
    private final List<MetricReader> metricReaders = new ArrayList();
    private final List<RegisteredView> registeredViews = new ArrayList();
    private ExemplarFilter exemplarFilter = DEFAULT_EXEMPLAR_FILTER;

    SdkMeterProviderBuilder() {
    }

    public SdkMeterProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkMeterProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    SdkMeterProviderBuilder setExemplarFilter(ExemplarFilter exemplarFilter) {
        this.exemplarFilter = exemplarFilter;
        return this;
    }

    public SdkMeterProviderBuilder registerView(InstrumentSelector instrumentSelector, View view) {
        Objects.requireNonNull(instrumentSelector, "selector");
        Objects.requireNonNull(view, "view");
        this.registeredViews.add(RegisteredView.create(instrumentSelector, view, view.getAttributesProcessor(), SourceInfo.fromCurrentStack()));
        return this;
    }

    public SdkMeterProviderBuilder registerMetricReader(MetricReader metricReader) {
        this.metricReaders.add(metricReader);
        return this;
    }

    public SdkMeterProvider build() {
        return new SdkMeterProvider(this.registeredViews, this.metricReaders, this.clock, this.resource, this.exemplarFilter);
    }
}
