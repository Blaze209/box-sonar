package io.opentelemetry.context.propagation;

/* JADX INFO: loaded from: classes4.dex */
public class NoopContextPropagators {
    public static ContextPropagators getInstance() {
        return DefaultContextPropagators.noop();
    }
}
