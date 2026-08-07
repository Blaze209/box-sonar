package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.instrumentation.api.internal.cache.Cache;
import io.opentelemetry.instrumentation.api.util.VirtualField;
import java.util.function.Function;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RuntimeVirtualFieldSupplier {
    private static final VirtualFieldSupplier DEFAULT;
    private static volatile VirtualFieldSupplier instance;
    private static final Logger logger = Logger.getLogger(RuntimeVirtualFieldSupplier.class.getName());

    public interface VirtualFieldSupplier {
        <U extends T, V extends F, T, F> VirtualField<U, V> find(Class<T> cls, Class<F> cls2);
    }

    static {
        CacheBasedVirtualFieldSupplier cacheBasedVirtualFieldSupplier = new CacheBasedVirtualFieldSupplier();
        DEFAULT = cacheBasedVirtualFieldSupplier;
        instance = cacheBasedVirtualFieldSupplier;
    }

    public static void set(VirtualFieldSupplier virtualFieldSupplier) {
        if (instance != DEFAULT) {
            logger.warning("Runtime VirtualField supplier has already been set up, further set() calls are ignored");
        } else {
            instance = virtualFieldSupplier;
        }
    }

    public static VirtualFieldSupplier get() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CacheBasedVirtualFieldSupplier implements VirtualFieldSupplier {
        private final Cache<Class<?>, Cache<Class<?>, VirtualField<?, ?>>> ownerToFieldToImplementationMap;

        private CacheBasedVirtualFieldSupplier() {
            this.ownerToFieldToImplementationMap = Cache.weak();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.RuntimeVirtualFieldSupplier.VirtualFieldSupplier
        public <U extends T, V extends F, T, F> VirtualField<U, V> find(Class<T> cls, Class<F> cls2) {
            return (VirtualField) this.ownerToFieldToImplementationMap.computeIfAbsent(cls, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.RuntimeVirtualFieldSupplier$CacheBasedVirtualFieldSupplier$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Cache.weak();
                }
            }).computeIfAbsent(cls2, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.RuntimeVirtualFieldSupplier$CacheBasedVirtualFieldSupplier$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return RuntimeVirtualFieldSupplier.CacheBasedVirtualFieldSupplier.lambda$find$1((Class) obj);
                }
            });
        }

        static /* synthetic */ VirtualField lambda$find$1(Class cls) {
            return new CacheBasedVirtualField();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CacheBasedVirtualField<T, F> extends VirtualField<T, F> {
        private final Cache<T, F> cache;

        private CacheBasedVirtualField() {
            this.cache = Cache.weak();
        }

        @Override // io.opentelemetry.instrumentation.api.util.VirtualField
        @Nullable
        public F get(T t) {
            return this.cache.get(t);
        }

        @Override // io.opentelemetry.instrumentation.api.util.VirtualField
        public void set(T t, @Nullable F f) {
            if (f == null) {
                this.cache.remove(t);
            } else {
                this.cache.put(t, f);
            }
        }
    }

    private RuntimeVirtualFieldSupplier() {
    }
}
