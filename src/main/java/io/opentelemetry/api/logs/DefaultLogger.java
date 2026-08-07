package io.opentelemetry.api.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
class DefaultLogger implements Logger {
    private final boolean hasDomain;
    private static final Logger INSTANCE_WITH_DOMAIN = new DefaultLogger(true);
    private static final Logger INSTANCE_NO_DOMAIN = new DefaultLogger(false);
    private static final EventBuilder NOOP_LOG_RECORD_BUILDER = new NoopLogRecordBuilder();

    private DefaultLogger(boolean z) {
        this.hasDomain = z;
    }

    static Logger getInstance(boolean z) {
        return z ? INSTANCE_WITH_DOMAIN : INSTANCE_NO_DOMAIN;
    }

    @Override // io.opentelemetry.api.logs.Logger
    public EventBuilder eventBuilder(String str) {
        if (!this.hasDomain) {
            ValidationUtil.log("Cannot emit event from Logger without event domain. Please use LoggerBuilder#setEventDomain(String) when obtaining Logger.", Level.WARNING);
        }
        return NOOP_LOG_RECORD_BUILDER;
    }

    @Override // io.opentelemetry.api.logs.Logger
    public LogRecordBuilder logRecordBuilder() {
        return NOOP_LOG_RECORD_BUILDER;
    }

    private static final class NoopLogRecordBuilder implements EventBuilder {
        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public void emit() {
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public <T> LogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setBody(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setContext(Context context) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setEpoch(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setEpoch(Instant instant) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setSeverity(Severity severity) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LogRecordBuilder
        public LogRecordBuilder setSeverityText(String str) {
            return this;
        }

        private NoopLogRecordBuilder() {
        }
    }
}
