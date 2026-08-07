package io.opentelemetry.api.metrics;

/* JADX INFO: loaded from: classes4.dex */
public interface MeterBuilder {
    Meter build();

    MeterBuilder setInstrumentationVersion(String str);

    MeterBuilder setSchemaUrl(String str);
}
