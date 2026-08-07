package io.opentelemetry.instrumentation.api.instrumenter.util;

import io.opentelemetry.instrumentation.api.internal.ClassNames;
import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanNames {
    private static final Cache<Class<?>, Map<String, String>> spanNameCaches = Cache.weak();

    public static String fromMethod(Method method) {
        return fromMethod(method.getDeclaringClass(), method.getName());
    }

    public static String fromMethod(Class<?> cls, String str) {
        Map<String, String> mapComputeIfAbsent = spanNameCaches.computeIfAbsent(cls, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.util.SpanNames$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return SpanNames.lambda$fromMethod$0((Class) obj);
            }
        });
        String str2 = mapComputeIfAbsent.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = ClassNames.simpleName(cls) + "." + str;
        mapComputeIfAbsent.put(str, str3);
        return str3;
    }

    static /* synthetic */ Map lambda$fromMethod$0(Class cls) {
        return new ConcurrentHashMap();
    }

    private SpanNames() {
    }
}
