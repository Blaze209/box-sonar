package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.context.propagation.TextMapSetter;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public final class TextMapPropagatorExtension {
    private static final String TAG = "TextMapPropagatorExtension";

    private TextMapPropagatorExtension() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static HashMap<String, String> inject(Context context) {
        try {
            HashMap<String, String> map = new HashMap<>();
            if (context == null) {
                context = Context.current();
            }
            TextMapPropagator.composite(W3CTraceContextPropagator.getInstance(), W3CBaggagePropagator.getInstance()).inject(context, map, new TextMapSetter<Map<String, String>>() { // from class: com.microsoft.identity.common.java.opentelemetry.TextMapPropagatorExtension.1
                @Override // io.opentelemetry.context.propagation.TextMapSetter
                public void set(Map<String, String> map2, String str, String str2) {
                    if (map2 == null || str == null || str2 == null) {
                        return;
                    }
                    map2.put(str, str2);
                }
            });
            return map;
        } catch (Exception | NoSuchMethodError e) {
            Logger.error(TAG + ":inject", "Failed to inject context", e);
            return new HashMap<>();
        }
    }

    @Nullable
    public static Context extract(Map<String, String> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    return TextMapPropagator.composite(W3CTraceContextPropagator.getInstance(), W3CBaggagePropagator.getInstance()).extract(Context.current(), map, new TextMapGetter<Map<String, String>>() { // from class: com.microsoft.identity.common.java.opentelemetry.TextMapPropagatorExtension.2
                        @Override // io.opentelemetry.context.propagation.TextMapGetter
                        public String get(Map<String, String> map2, String str) {
                            return map2.get(str);
                        }

                        @Override // io.opentelemetry.context.propagation.TextMapGetter
                        public Iterable<String> keys(Map<String, String> map2) {
                            return map2.keySet();
                        }
                    });
                }
            } catch (Exception | NoSuchMethodError e) {
                Logger.error(TAG + ":extract", "Failed to extract context", e);
                return null;
            }
        }
        return Context.current();
    }
}
