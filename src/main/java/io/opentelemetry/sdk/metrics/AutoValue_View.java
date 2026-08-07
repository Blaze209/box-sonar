package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_View extends View {
    private final Aggregation aggregation;
    private final AttributesProcessor attributesProcessor;
    private final String description;
    private final String name;

    AutoValue_View(@Nullable String str, @Nullable String str2, Aggregation aggregation, AttributesProcessor attributesProcessor) {
        this.name = str;
        this.description = str2;
        if (aggregation == null) {
            throw new NullPointerException("Null aggregation");
        }
        this.aggregation = aggregation;
        if (attributesProcessor == null) {
            throw new NullPointerException("Null attributesProcessor");
        }
        this.attributesProcessor = attributesProcessor;
    }

    @Override // io.opentelemetry.sdk.metrics.View
    @Nullable
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.metrics.View
    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Override // io.opentelemetry.sdk.metrics.View
    public Aggregation getAggregation() {
        return this.aggregation;
    }

    @Override // io.opentelemetry.sdk.metrics.View
    AttributesProcessor getAttributesProcessor() {
        return this.attributesProcessor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            String str = this.name;
            if (str != null ? str.equals(view.getName()) : view.getName() == null) {
                String str2 = this.description;
                if (str2 != null ? str2.equals(view.getDescription()) : view.getDescription() == null) {
                    if (this.aggregation.equals(view.getAggregation()) && this.attributesProcessor.equals(view.getAttributesProcessor())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.description;
        return this.attributesProcessor.hashCode() ^ ((((iHashCode ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ this.aggregation.hashCode()) * 1000003);
    }
}
