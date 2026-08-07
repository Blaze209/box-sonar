package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class MultiTextMapPropagator implements TextMapPropagator {
    private final Collection<String> allFields;
    private final TextMapPropagator[] textMapPropagators;

    MultiTextMapPropagator(TextMapPropagator... textMapPropagatorArr) {
        this((List<TextMapPropagator>) Arrays.asList(textMapPropagatorArr));
    }

    MultiTextMapPropagator(List<TextMapPropagator> list) {
        TextMapPropagator[] textMapPropagatorArr = new TextMapPropagator[list.size()];
        this.textMapPropagators = textMapPropagatorArr;
        list.toArray(textMapPropagatorArr);
        this.allFields = Collections.unmodifiableList(getAllFields(textMapPropagatorArr));
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        return this.allFields;
    }

    private static List<String> getAllFields(TextMapPropagator[] textMapPropagatorArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TextMapPropagator textMapPropagator : textMapPropagatorArr) {
            linkedHashSet.addAll(textMapPropagator.fields());
        }
        return new ArrayList(linkedHashSet);
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
        if (context == null || textMapSetter == null) {
            return;
        }
        for (TextMapPropagator textMapPropagator : this.textMapPropagators) {
            textMapPropagator.inject(context, c, textMapSetter);
        }
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        if (context == null) {
            return Context.root();
        }
        if (textMapGetter == null) {
            return context;
        }
        for (TextMapPropagator textMapPropagator : this.textMapPropagators) {
            context = textMapPropagator.extract(context, c, textMapGetter);
        }
        return context;
    }

    public String toString() {
        return "MultiTextMapPropagator{textMapPropagators=" + Arrays.toString(this.textMapPropagators) + AbstractJsonLexerKt.END_OBJ;
    }
}
