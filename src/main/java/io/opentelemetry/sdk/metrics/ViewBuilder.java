package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewBuilder {

    @Nullable
    private String description;

    @Nullable
    private String name;
    private Aggregation aggregation = Aggregation.defaultAggregation();
    private AttributesProcessor processor = AttributesProcessor.noop();

    ViewBuilder() {
    }

    public ViewBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public ViewBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public ViewBuilder setAggregation(Aggregation aggregation) {
        if (!(aggregation instanceof AggregatorFactory)) {
            throw new IllegalArgumentException("Custom Aggregation implementations are currently not supported. Use one of the standard implementations returned by the static factories in the Aggregation class.");
        }
        this.aggregation = aggregation;
        return this;
    }

    public ViewBuilder setAttributeFilter(Predicate<String> predicate) {
        Objects.requireNonNull(predicate, "keyFilter");
        return addAttributesProcessor(AttributesProcessor.filterByKeyName(predicate));
    }

    ViewBuilder addAttributesProcessor(AttributesProcessor attributesProcessor) {
        this.processor = this.processor.then(attributesProcessor);
        return this;
    }

    public View build() {
        return View.create(this.name, this.description, this.aggregation, this.processor);
    }
}
