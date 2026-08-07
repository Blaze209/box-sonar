package io.opentelemetry.exporter.internal;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ExporterMetrics {

    @Nullable
    private volatile LongCounter exported;
    private final String exporterName;
    private final Attributes failedAttrs;
    private final Supplier<MeterProvider> meterProviderSupplier;

    @Nullable
    private volatile LongCounter seen;
    private final Attributes seenAttrs;
    private final Attributes successAttrs;
    private final String transportName;
    private static final AttributeKey<String> ATTRIBUTE_KEY_TYPE = AttributeKey.stringKey("type");
    private static final AttributeKey<Boolean> ATTRIBUTE_KEY_SUCCESS = AttributeKey.booleanKey("success");

    private ExporterMetrics(Supplier<MeterProvider> supplier, String str, String str2, String str3) {
        this.meterProviderSupplier = supplier;
        this.exporterName = str;
        this.transportName = str3;
        Attributes attributesBuild = Attributes.builder().put(ATTRIBUTE_KEY_TYPE, str2).build();
        this.seenAttrs = attributesBuild;
        AttributesBuilder builder = attributesBuild.toBuilder();
        AttributeKey<Boolean> attributeKey = ATTRIBUTE_KEY_SUCCESS;
        this.successAttrs = builder.put((AttributeKey<boolean>) attributeKey, true).build();
        this.failedAttrs = attributesBuild.toBuilder().put((AttributeKey<boolean>) attributeKey, false).build();
    }

    public void addSeen(long j) {
        seen().add(j, this.seenAttrs);
    }

    public void addSuccess(long j) {
        exported().add(j, this.successAttrs);
    }

    public void addFailed(long j) {
        exported().add(j, this.failedAttrs);
    }

    private LongCounter seen() {
        LongCounter longCounter = this.seen;
        if (longCounter != null) {
            return longCounter;
        }
        LongCounter longCounterBuild = meter().counterBuilder(this.exporterName + ".exporter.seen").build();
        this.seen = longCounterBuild;
        return longCounterBuild;
    }

    private LongCounter exported() {
        LongCounter longCounter = this.exported;
        if (longCounter != null) {
            return longCounter;
        }
        LongCounter longCounterBuild = meter().counterBuilder(this.exporterName + ".exporter.exported").build();
        this.exported = longCounterBuild;
        return longCounterBuild;
    }

    private Meter meter() {
        return this.meterProviderSupplier.get().get("io.opentelemetry.exporters." + this.exporterName + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + this.transportName);
    }

    public static ExporterMetrics createGrpc(String str, String str2, Supplier<MeterProvider> supplier) {
        return new ExporterMetrics(supplier, str, str2, SemanticAttributes.RpcSystemValues.GRPC);
    }

    public static ExporterMetrics createGrpcOkHttp(String str, String str2, Supplier<MeterProvider> supplier) {
        return new ExporterMetrics(supplier, str, str2, "grpc-okhttp");
    }

    public static ExporterMetrics createHttpProtobuf(String str, String str2, Supplier<MeterProvider> supplier) {
        return new ExporterMetrics(supplier, str, str2, "http");
    }

    public static ExporterMetrics createHttpJson(String str, String str2, Supplier<MeterProvider> supplier) {
        return new ExporterMetrics(supplier, str, str2, "http-json");
    }
}
