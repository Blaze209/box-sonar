package io.opentelemetry.context.propagation;

/* JADX INFO: loaded from: classes4.dex */
final class DefaultContextPropagators implements ContextPropagators {
    private static final ContextPropagators NOOP = new DefaultContextPropagators(NoopTextMapPropagator.getInstance());
    private final TextMapPropagator textMapPropagator;

    static ContextPropagators noop() {
        return NOOP;
    }

    @Override // io.opentelemetry.context.propagation.ContextPropagators
    public TextMapPropagator getTextMapPropagator() {
        return this.textMapPropagator;
    }

    DefaultContextPropagators(TextMapPropagator textMapPropagator) {
        this.textMapPropagator = textMapPropagator;
    }

    public String toString() {
        return "DefaultContextPropagators{textMapPropagator=" + this.textMapPropagator + "}";
    }
}
