package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassNames {
    private static final Cache<Class<?>, String> simpleNames = Cache.weak();

    public static String simpleName(Class<?> cls) {
        return simpleNames.computeIfAbsent(cls, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.ClassNames$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ClassNames.computeSimpleName((Class) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String computeSimpleName(Class<?> cls) {
        if (!cls.isAnonymousClass()) {
            return cls.getSimpleName();
        }
        String name = cls.getName();
        if (cls.getPackage() != null) {
            String name2 = cls.getPackage().getName();
            if (!name2.isEmpty()) {
                return name.substring(name2.length() + 1);
            }
        }
        return name;
    }

    private ClassNames() {
    }
}
