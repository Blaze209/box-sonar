package io.opentelemetry.sdk.autoconfigure.spi;

import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.sdk.logs.SdkLoggerProviderBuilder;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public interface AutoConfigurationCustomizer {
    default AutoConfigurationCustomizer addLogRecordExporterCustomizer(BiFunction<? super LogRecordExporter, ConfigProperties, ? extends LogRecordExporter> biFunction) {
        return this;
    }

    default AutoConfigurationCustomizer addLoggerProviderCustomizer(BiFunction<SdkLoggerProviderBuilder, ConfigProperties, SdkLoggerProviderBuilder> biFunction) {
        return this;
    }

    default AutoConfigurationCustomizer addMeterProviderCustomizer(BiFunction<SdkMeterProviderBuilder, ConfigProperties, SdkMeterProviderBuilder> biFunction) {
        return this;
    }

    default AutoConfigurationCustomizer addMetricExporterCustomizer(BiFunction<? super MetricExporter, ConfigProperties, ? extends MetricExporter> biFunction) {
        return this;
    }

    AutoConfigurationCustomizer addPropagatorCustomizer(BiFunction<? super TextMapPropagator, ConfigProperties, ? extends TextMapPropagator> biFunction);

    default AutoConfigurationCustomizer addPropertiesCustomizer(Function<ConfigProperties, Map<String, String>> function) {
        return this;
    }

    AutoConfigurationCustomizer addPropertiesSupplier(Supplier<Map<String, String>> supplier);

    AutoConfigurationCustomizer addResourceCustomizer(BiFunction<? super Resource, ConfigProperties, ? extends Resource> biFunction);

    AutoConfigurationCustomizer addSamplerCustomizer(BiFunction<? super Sampler, ConfigProperties, ? extends Sampler> biFunction);

    AutoConfigurationCustomizer addSpanExporterCustomizer(BiFunction<? super SpanExporter, ConfigProperties, ? extends SpanExporter> biFunction);

    default AutoConfigurationCustomizer addTracerProviderCustomizer(BiFunction<SdkTracerProviderBuilder, ConfigProperties, SdkTracerProviderBuilder> biFunction) {
        return this;
    }
}
