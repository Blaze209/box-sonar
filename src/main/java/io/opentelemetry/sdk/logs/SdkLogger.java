package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.logs.EventBuilder;
import io.opentelemetry.api.logs.LogRecordBuilder;
import io.opentelemetry.api.logs.Logger;
import io.opentelemetry.api.logs.LoggerProvider;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import java.util.logging.Level;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLogger implements Logger {
    private static final Logger NOOP_LOGGER_WITH_DOMAIN = LoggerProvider.noop().loggerBuilder("unused").setEventDomain("unused").build();

    @Nullable
    private final String eventDomain;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final LoggerSharedState loggerSharedState;

    SdkLogger(LoggerSharedState loggerSharedState, InstrumentationScopeInfo instrumentationScopeInfo) {
        this(loggerSharedState, instrumentationScopeInfo, null);
    }

    SdkLogger(LoggerSharedState loggerSharedState, InstrumentationScopeInfo instrumentationScopeInfo, @Nullable String str) {
        this.loggerSharedState = loggerSharedState;
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.eventDomain = str;
    }

    SdkLogger withEventDomain(String str) {
        return !str.equals(this.eventDomain) ? new SdkLogger(this.loggerSharedState, this.instrumentationScopeInfo, str) : this;
    }

    @Override // io.opentelemetry.api.logs.Logger
    public EventBuilder eventBuilder(String str) {
        if (this.eventDomain == null) {
            ValidationUtil.log("Cannot emit event from Logger without event domain. Please use LoggerBuilder#setEventDomain(String) when obtaining Logger.", Level.WARNING);
            return NOOP_LOGGER_WITH_DOMAIN.eventBuilder(str);
        }
        return new SdkLogRecordBuilder(this.loggerSharedState, this.instrumentationScopeInfo).setAttribute(AttributeKey.stringKey("event.domain"), this.eventDomain).setAttribute(AttributeKey.stringKey("event.name"), str);
    }

    @Override // io.opentelemetry.api.logs.Logger
    public LogRecordBuilder logRecordBuilder() {
        return new SdkLogRecordBuilder(this.loggerSharedState, this.instrumentationScopeInfo);
    }

    InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }
}
