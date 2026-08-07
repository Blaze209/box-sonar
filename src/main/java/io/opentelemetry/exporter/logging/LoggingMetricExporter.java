package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class LoggingMetricExporter implements MetricExporter {
    private static final Logger logger = Logger.getLogger(LoggingMetricExporter.class.getName());
    private final AggregationTemporality aggregationTemporality;

    public static LoggingMetricExporter create() {
        return create(AggregationTemporality.CUMULATIVE);
    }

    public static LoggingMetricExporter create(AggregationTemporality aggregationTemporality) {
        return new LoggingMetricExporter(aggregationTemporality);
    }

    @Deprecated
    public LoggingMetricExporter() {
        this(AggregationTemporality.CUMULATIVE);
    }

    private LoggingMetricExporter(AggregationTemporality aggregationTemporality) {
        this.aggregationTemporality = aggregationTemporality;
    }

    @Deprecated
    public AggregationTemporality getPreferredTemporality() {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode export(Collection<MetricData> collection) {
        logger.info("Received a collection of " + collection.size() + " metrics for export.");
        Iterator<MetricData> it = collection.iterator();
        while (it.hasNext()) {
            logger.log(Level.INFO, "metric: {0}", it.next());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode flush() {
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                return completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // io.opentelemetry.sdk.metrics.export.MetricExporter
    public CompletableResultCode shutdown() {
        flush();
        return CompletableResultCode.ofSuccess();
    }
}
