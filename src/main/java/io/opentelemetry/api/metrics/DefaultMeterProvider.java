package io.opentelemetry.api.metrics;

/* JADX INFO: loaded from: classes4.dex */
class DefaultMeterProvider implements MeterProvider {
    private static final DefaultMeterProvider INSTANCE = new DefaultMeterProvider();
    private static final MeterBuilder BUILDER_INSTANCE = new NoopMeterBuilder();

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public MeterBuilder meterBuilder(String str) {
        return BUILDER_INSTANCE;
    }

    static MeterProvider getInstance() {
        return INSTANCE;
    }

    private DefaultMeterProvider() {
    }

    private static class NoopMeterBuilder implements MeterBuilder {
        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setInstrumentationVersion(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setSchemaUrl(String str) {
            return this;
        }

        private NoopMeterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public Meter build() {
            return DefaultMeter.getInstance();
        }
    }
}
