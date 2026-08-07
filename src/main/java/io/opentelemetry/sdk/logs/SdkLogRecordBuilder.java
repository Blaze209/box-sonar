package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.logs.EventBuilder;
import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.AttributesMap;
import io.opentelemetry.sdk.logs.data.Body;
import io.opentelemetry.sdk.resources.Resource;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLogRecordBuilder implements EventBuilder {

    @Nullable
    private AttributesMap attributes;

    @Nullable
    private Context context;
    private long epochNanos;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final LogLimits logLimits;
    private final LoggerSharedState loggerSharedState;

    @Nullable
    private String severityText;
    private Severity severity = Severity.UNDEFINED_SEVERITY_NUMBER;
    private Body body = Body.empty();

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public /* bridge */ /* synthetic */ LogRecordBuilder setAttribute(AttributeKey attributeKey, Object obj) {
        return setAttribute((AttributeKey<Object>) attributeKey, obj);
    }

    SdkLogRecordBuilder(LoggerSharedState loggerSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        this.loggerSharedState = loggerSharedState;
        this.logLimits = loggerSharedState.getLogLimits();
        this.instrumentationScopeInfo = instrumentationScopeInfo;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setEpoch(long j, TimeUnit timeUnit) {
        this.epochNanos = timeUnit.toNanos(j);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setEpoch(Instant instant) {
        this.epochNanos = TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano());
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setSeverityText(String str) {
        this.severityText = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public SdkLogRecordBuilder setBody(String str) {
        this.body = Body.string(str);
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public <T> SdkLogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            if (this.attributes == null) {
                this.attributes = AttributesMap.create(this.logLimits.getMaxNumberOfAttributes(), this.logLimits.getMaxAttributeValueLength());
            }
            this.attributes.put((AttributeKey) attributeKey, (Object) t);
        }
        return this;
    }

    @Override // io.opentelemetry.api.logs.LogRecordBuilder
    public void emit() {
        if (this.loggerSharedState.hasBeenShutdown()) {
            return;
        }
        Context contextCurrent = this.context;
        if (contextCurrent == null) {
            contextCurrent = Context.current();
        }
        LogRecordProcessor logRecordProcessor = this.loggerSharedState.getLogRecordProcessor();
        LogLimits logLimits = this.loggerSharedState.getLogLimits();
        Resource resource = this.loggerSharedState.getResource();
        InstrumentationScopeInfo instrumentationScopeInfo = this.instrumentationScopeInfo;
        long jNow = this.epochNanos;
        if (jNow == 0) {
            jNow = this.loggerSharedState.getClock().now();
        }
        logRecordProcessor.onEmit(contextCurrent, SdkReadWriteLogRecord.create(logLimits, resource, instrumentationScopeInfo, jNow, Span.fromContext(contextCurrent).getSpanContext(), this.severity, this.severityText, this.body, this.attributes));
    }
}
