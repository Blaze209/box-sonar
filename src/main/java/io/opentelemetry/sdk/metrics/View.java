package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import java.util.StringJoiner;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class View {
    public abstract Aggregation getAggregation();

    abstract AttributesProcessor getAttributesProcessor();

    @Nullable
    public abstract String getDescription();

    @Nullable
    public abstract String getName();

    public static ViewBuilder builder() {
        return new ViewBuilder();
    }

    static View create(@Nullable String str, @Nullable String str2, Aggregation aggregation, AttributesProcessor attributesProcessor) {
        return new AutoValue_View(str, str2, aggregation, attributesProcessor);
    }

    View() {
    }

    public final String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "View{", "}");
        if (getName() != null) {
            stringJoiner.add("name=" + getName());
        }
        if (getDescription() != null) {
            stringJoiner.add("description=" + getDescription());
        }
        stringJoiner.add("aggregation=" + getAggregation());
        stringJoiner.add("attributesProcessor=" + getAttributesProcessor());
        return stringJoiner.toString();
    }
}
