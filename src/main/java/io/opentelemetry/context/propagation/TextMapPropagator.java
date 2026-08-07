package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface TextMapPropagator {
    <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter);

    Collection<String> fields();

    <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter);

    static TextMapPropagator composite(TextMapPropagator... textMapPropagatorArr) {
        return composite(Arrays.asList(textMapPropagatorArr));
    }

    static TextMapPropagator composite(Iterable<TextMapPropagator> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<TextMapPropagator> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopTextMapPropagator.getInstance();
        }
        if (arrayList.size() == 1) {
            return (TextMapPropagator) arrayList.get(0);
        }
        return new MultiTextMapPropagator(arrayList);
    }

    static TextMapPropagator noop() {
        return NoopTextMapPropagator.getInstance();
    }
}
