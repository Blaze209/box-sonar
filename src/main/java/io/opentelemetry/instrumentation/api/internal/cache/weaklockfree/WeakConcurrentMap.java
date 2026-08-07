package io.opentelemetry.instrumentation.api.internal.cache.weaklockfree;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class WeakConcurrentMap<K, V> extends AbstractWeakConcurrentMap<K, V, LookupKey<K>> {
    private static final ThreadLocal<LookupKey<?>> LOOKUP_KEY_CACHE = new ThreadLocal<LookupKey<?>>() { // from class: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public LookupKey<?> initialValue() {
            return new LookupKey<>();
        }
    };
    private final boolean reuseKeys;

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ int approximateSize() {
        return super.approximateSize();
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return super.computeIfAbsent(obj, function);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object get(Object obj) {
        return super.get(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object getIfPresent(Object obj) {
        return super.getIfPresent(obj);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return super.putIfAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
        return super.putIfProbablyAbsent(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public WeakConcurrentMap() {
        this(isPersistentClassLoader(LookupKey.class.getClassLoader()));
    }

    private static boolean isPersistentClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            return true;
        }
        try {
            return classLoader == ClassLoader.getSystemClassLoader() || classLoader == ClassLoader.getSystemClassLoader().getParent();
        } catch (Throwable unused) {
        }
    }

    public WeakConcurrentMap(boolean z) {
        this(z, new ConcurrentHashMap());
    }

    public WeakConcurrentMap(boolean z, ConcurrentMap<AbstractWeakConcurrentMap.WeakKey<K>, V> concurrentMap) {
        super(concurrentMap);
        this.reuseKeys = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public LookupKey<K> getLookupKey(K k) {
        LookupKey<?> lookupKey;
        if (this.reuseKeys) {
            lookupKey = LOOKUP_KEY_CACHE.get();
        } else {
            lookupKey = new LookupKey<>();
        }
        return lookupKey.withValue(k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
    public void resetLookupKey(LookupKey<K> lookupKey) {
        lookupKey.reset();
    }

    static final class LookupKey<K> {
        private int hashCode;
        private K key;

        LookupKey() {
        }

        LookupKey<K> withValue(K k) {
            this.key = k;
            this.hashCode = System.identityHashCode(k);
            return this;
        }

        void reset() {
            this.key = null;
            this.hashCode = 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof LookupKey) {
                return ((LookupKey) obj).key == this.key;
            }
            return ((AbstractWeakConcurrentMap.WeakKey) obj).get() == this.key;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public static class WithInlinedExpunction<K, V> extends WeakConcurrentMap<K, V> {
        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ Object getLookupKey(Object obj) {
            return super.getLookupKey(obj);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ Object putIfProbablyAbsent(Object obj, Object obj2) {
            return super.putIfProbablyAbsent(obj, obj2);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        protected /* bridge */ /* synthetic */ void resetLookupKey(Object obj) {
            super.resetLookupKey((LookupKey) obj);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V get(K k) {
            expungeStaleEntries();
            return (V) super.get(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V getIfPresent(K k) {
            expungeStaleEntries();
            return (V) super.getIfPresent(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public boolean containsKey(K k) {
            expungeStaleEntries();
            return super.containsKey(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V put(K k, V v) {
            expungeStaleEntries();
            return (V) super.put(k, v);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V putIfAbsent(K k, V v) {
            expungeStaleEntries();
            return (V) super.putIfAbsent(k, v);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            expungeStaleEntries();
            return (V) super.computeIfAbsent(k, function);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public V remove(K k) {
            expungeStaleEntries();
            return (V) super.remove(k);
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            expungeStaleEntries();
            return super.iterator();
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap, io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap
        public int approximateSize() {
            expungeStaleEntries();
            return super.approximateSize();
        }
    }
}
