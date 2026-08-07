package io.opentelemetry.api.logs;

/* JADX INFO: loaded from: classes4.dex */
class DefaultLoggerProvider implements LoggerProvider {
    private static final LoggerProvider INSTANCE = new DefaultLoggerProvider();
    private static final LoggerBuilder NOOP_BUILDER_NO_DOMAIN;
    private static final LoggerBuilder NOOP_BUILDER_WITH_DOMAIN;

    static {
        NOOP_BUILDER_WITH_DOMAIN = new NoopLoggerBuilder(true);
        NOOP_BUILDER_NO_DOMAIN = new NoopLoggerBuilder(false);
    }

    private DefaultLoggerProvider() {
    }

    static LoggerProvider getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.logs.LoggerProvider
    public LoggerBuilder loggerBuilder(String str) {
        return NOOP_BUILDER_NO_DOMAIN;
    }

    private static class NoopLoggerBuilder implements LoggerBuilder {
        private final boolean hasDomain;

        @Override // io.opentelemetry.api.logs.LoggerBuilder
        public LoggerBuilder setInstrumentationVersion(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.logs.LoggerBuilder
        public LoggerBuilder setSchemaUrl(String str) {
            return this;
        }

        private NoopLoggerBuilder(boolean z) {
            this.hasDomain = z;
        }

        @Override // io.opentelemetry.api.logs.LoggerBuilder
        public LoggerBuilder setEventDomain(String str) {
            return str == null ? DefaultLoggerProvider.NOOP_BUILDER_NO_DOMAIN : DefaultLoggerProvider.NOOP_BUILDER_WITH_DOMAIN;
        }

        @Override // io.opentelemetry.api.logs.LoggerBuilder
        public Logger build() {
            return DefaultLogger.getInstance(this.hasDomain);
        }
    }
}
