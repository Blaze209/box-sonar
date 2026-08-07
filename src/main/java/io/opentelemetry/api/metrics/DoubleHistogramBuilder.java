package io.opentelemetry.api.metrics;

/* JADX INFO: loaded from: classes4.dex */
public interface DoubleHistogramBuilder {
    DoubleHistogram build();

    LongHistogramBuilder ofLongs();

    DoubleHistogramBuilder setDescription(String str);

    DoubleHistogramBuilder setUnit(String str);
}
