package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.LoggerBuilder;
import io.opentelemetry.api.logs.LoggerProvider;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import io.opentelemetry.sdk.resources.Resource;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkLoggerProvider implements LoggerProvider, Closeable {
    static final String DEFAULT_LOGGER_NAME = "unknown";
    private static final Logger LOGGER = Logger.getLogger(SdkLoggerProvider.class.getName());
    private final boolean isNoopLogRecordProcessor;
    private final ComponentRegistry<SdkLogger> loggerComponentRegistry;
    private final LoggerSharedState sharedState;

    public static SdkLoggerProviderBuilder builder() {
        return new SdkLoggerProviderBuilder();
    }

    SdkLoggerProvider(Resource resource, Supplier<LogLimits> supplier, List<LogRecordProcessor> list, Clock clock) {
        LogRecordProcessor logRecordProcessorComposite = LogRecordProcessor.composite(list);
        this.sharedState = new LoggerSharedState(resource, supplier, logRecordProcessorComposite, clock);
        this.loggerComponentRegistry = new ComponentRegistry<>(new Function() { // from class: io.opentelemetry.sdk.logs.SdkLoggerProvider$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m14760lambda$new$0$ioopentelemetrysdklogsSdkLoggerProvider((InstrumentationScopeInfo) obj);
            }
        });
        this.isNoopLogRecordProcessor = logRecordProcessorComposite instanceof NoopLogRecordProcessor;
    }

    /* JADX INFO: renamed from: lambda$new$0$io-opentelemetry-sdk-logs-SdkLoggerProvider, reason: not valid java name */
    /* synthetic */ SdkLogger m14760lambda$new$0$ioopentelemetrysdklogsSdkLoggerProvider(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkLogger(this.sharedState, instrumentationScopeInfo);
    }

    @Override // io.opentelemetry.api.logs.LoggerProvider
    public io.opentelemetry.api.logs.Logger get(String str) {
        return this.loggerComponentRegistry.get(instrumentationNameOrDefault(str), null, null, Attributes.empty());
    }

    @Override // io.opentelemetry.api.logs.LoggerProvider
    public LoggerBuilder loggerBuilder(String str) {
        if (this.isNoopLogRecordProcessor) {
            return LoggerProvider.noop().loggerBuilder(str);
        }
        return new SdkLoggerBuilder(this.loggerComponentRegistry, instrumentationNameOrDefault(str));
    }

    private static String instrumentationNameOrDefault(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            return str;
        }
        LOGGER.fine("Logger requested without instrumentation scope name.");
        return "unknown";
    }

    public CompletableResultCode forceFlush() {
        return this.sharedState.getLogRecordProcessor().forceFlush();
    }

    public CompletableResultCode shutdown() {
        if (this.sharedState.hasBeenShutdown()) {
            LOGGER.log(Level.WARNING, "Calling shutdown() multiple times.");
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public String toString() {
        return "SdkLoggerProvider{clock=" + this.sharedState.getClock() + ", resource=" + this.sharedState.getResource() + ", logLimits=" + this.sharedState.getLogLimits() + ", logRecordProcessor=" + this.sharedState.getLogRecordProcessor() + AbstractJsonLexerKt.END_OBJ;
    }
}
