package io.opentelemetry.exporter.zipkin;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.exporter.internal.ExporterMetrics;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Callback;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.reporter.Sender;

/* JADX INFO: loaded from: classes4.dex */
public final class ZipkinSpanExporter implements SpanExporter {
    public static final String DEFAULT_ENDPOINT = "http://localhost:9411/api/v2/spans";
    public static final Logger baseLogger = Logger.getLogger(ZipkinSpanExporter.class.getName());
    private final BytesEncoder<Span> encoder;
    private final ExporterMetrics exporterMetrics;
    private final ThrottlingLogger logger = new ThrottlingLogger(baseLogger);
    private final Sender sender;
    private final OtelToZipkinSpanTransformer transformer;

    ZipkinSpanExporter(BytesEncoder<Span> bytesEncoder, Sender sender, Supplier<MeterProvider> supplier, OtelToZipkinSpanTransformer otelToZipkinSpanTransformer) {
        ExporterMetrics exporterMetricsCreateHttpProtobuf;
        this.encoder = bytesEncoder;
        this.sender = sender;
        if (sender.encoding() == Encoding.JSON) {
            exporterMetricsCreateHttpProtobuf = ExporterMetrics.createHttpJson("zipkin", "span", supplier);
        } else {
            exporterMetricsCreateHttpProtobuf = ExporterMetrics.createHttpProtobuf("zipkin", "span", supplier);
        }
        this.exporterMetrics = exporterMetricsCreateHttpProtobuf;
        this.transformer = otelToZipkinSpanTransformer;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        final int size = collection.size();
        this.exporterMetrics.addSeen(size);
        ArrayList arrayList = new ArrayList(size);
        Iterator<SpanData> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.encoder.encode(this.transformer.generateSpan(it.next())));
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        this.sender.sendSpans(arrayList).enqueue(new Callback<Void>() { // from class: io.opentelemetry.exporter.zipkin.ZipkinSpanExporter.1
            @Override // zipkin2.Callback
            public void onSuccess(Void r3) {
                ZipkinSpanExporter.this.exporterMetrics.addSuccess(size);
                completableResultCode.succeed();
            }

            @Override // zipkin2.Callback
            public void onError(Throwable th) {
                ZipkinSpanExporter.this.exporterMetrics.addFailed(size);
                ZipkinSpanExporter.this.logger.log(Level.WARNING, "Failed to export spans", th);
                completableResultCode.fail();
            }
        });
        return completableResultCode;
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        try {
            this.sender.close();
        } catch (IOException e) {
            this.logger.log(Level.WARNING, "Exception while closing the Zipkin Sender instance", e);
        }
        return CompletableResultCode.ofSuccess();
    }

    public static ZipkinSpanExporterBuilder builder() {
        return new ZipkinSpanExporterBuilder();
    }
}
