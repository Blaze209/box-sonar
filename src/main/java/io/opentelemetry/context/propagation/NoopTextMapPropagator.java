package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class NoopTextMapPropagator implements TextMapPropagator {
    private static final NoopTextMapPropagator INSTANCE = new NoopTextMapPropagator();

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
    }

    NoopTextMapPropagator() {
    }

    static TextMapPropagator getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        return Collections.emptyList();
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        return context == null ? Context.root() : context;
    }

    public String toString() {
        return "NoopTextMapPropagator";
    }
}
