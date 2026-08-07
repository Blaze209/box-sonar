package io.opentelemetry.instrumentation.api.internal.cache.weaklockfree;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractWeakConcurrentMap<K, V, L> implements Iterable<Map.Entry<K, V>> {
    private static final ReferenceQueue<Object> REFERENCE_QUEUE = new ReferenceQueue<>();
    final ConcurrentMap<WeakKey<K>, V> target;
    private final WeakReference<ConcurrentMap<WeakKey<K>, ?>> weakTarget;

    protected V defaultValue(K k) {
        return null;
    }

    protected abstract L getLookupKey(K k);

    protected abstract void resetLookupKey(L l);

    protected AbstractWeakConcurrentMap() {
        this(new ConcurrentHashMap());
    }

    protected AbstractWeakConcurrentMap(ConcurrentMap<WeakKey<K>, V> concurrentMap) {
        this.target = concurrentMap;
        this.weakTarget = new WeakReference<>(concurrentMap);
    }

    public V get(K k) {
        V vPutIfAbsent;
        k.getClass();
        L lookupKey = getLookupKey(k);
        try {
            V v = this.target.get(lookupKey);
            resetLookupKey(lookupKey);
            if (v != null) {
                return v;
            }
            V vDefaultValue = defaultValue(k);
            return (vDefaultValue == null || (vPutIfAbsent = this.target.putIfAbsent(new WeakKey<>(k, this.weakTarget), vDefaultValue)) == null) ? vDefaultValue : vPutIfAbsent;
        } catch (Throwable th) {
            resetLookupKey(lookupKey);
            throw th;
        }
    }

    public V getIfPresent(K k) {
        k.getClass();
        L lookupKey = getLookupKey(k);
        try {
            return this.target.get(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public boolean containsKey(K k) {
        k.getClass();
        L lookupKey = getLookupKey(k);
        try {
            return this.target.containsKey(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V put(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        return this.target.put(new WeakKey<>(k, this.weakTarget), v);
    }

    public V putIfAbsent(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        L lookupKey = getLookupKey(k);
        try {
            V v2 = this.target.get(lookupKey);
            resetLookupKey(lookupKey);
            return v2 == null ? this.target.putIfAbsent(new WeakKey<>(k, this.weakTarget), v) : v2;
        } catch (Throwable th) {
            resetLookupKey(lookupKey);
            throw th;
        }
    }

    public V computeIfAbsent(final K k, final Function<? super K, ? extends V> function) {
        if (k == null || function == null) {
            throw null;
        }
        L lookupKey = getLookupKey(k);
        try {
            V v = this.target.get(lookupKey);
            resetLookupKey(lookupKey);
            return v == null ? this.target.computeIfAbsent(new WeakKey<>(k, this.weakTarget), new Function() { // from class: io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.AbstractWeakConcurrentMap$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return function.apply(k);
                }
            }) : v;
        } catch (Throwable th) {
            resetLookupKey(lookupKey);
            throw th;
        }
    }

    public V putIfProbablyAbsent(K k, V v) {
        if (k == null || v == null) {
            throw null;
        }
        return this.target.putIfAbsent(new WeakKey<>(k, this.weakTarget), v);
    }

    public V remove(K k) {
        k.getClass();
        L lookupKey = getLookupKey(k);
        try {
            return this.target.remove(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public void clear() {
        this.target.clear();
    }

    public static void expungeStaleEntries() {
        while (true) {
            Reference<? extends Object> referencePoll = REFERENCE_QUEUE.poll();
            if (referencePoll == null) {
                return;
            } else {
                removeWeakKey((WeakKey) referencePoll);
            }
        }
    }

    private static void removeWeakKey(WeakKey<?> weakKey) {
        ConcurrentMap concurrentMap = (ConcurrentMap) ((WeakKey) weakKey).ownerRef.get();
        if (concurrentMap != null) {
            concurrentMap.remove(weakKey);
        }
    }

    public int approximateSize() {
        return this.target.size();
    }

    static void runCleanup() {
        while (!Thread.interrupted()) {
            try {
                Reference<? extends Object> referenceRemove = REFERENCE_QUEUE.remove();
                if (referenceRemove != null) {
                    removeWeakKey((WeakKey) referenceRemove);
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new EntryIterator(this.target.entrySet().iterator());
    }

    public String toString() {
        return this.target.toString();
    }

    static final class WeakKey<K> extends WeakReference<K> {
        private final int hashCode;
        private final WeakReference<ConcurrentMap<WeakKey<K>, ?>> ownerRef;

        WeakKey(K k, WeakReference<ConcurrentMap<WeakKey<K>, ?>> weakReference) {
            super(k, AbstractWeakConcurrentMap.REFERENCE_QUEUE);
            this.hashCode = System.identityHashCode(k);
            this.ownerRef = weakReference;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof WeakKey) {
                return ((WeakKey) obj).get() == get();
            }
            return obj.equals(this);
        }

        public String toString() {
            return String.valueOf(get());
        }
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private final Iterator<Map.Entry<WeakKey<K>, V>> iterator;
        private Map.Entry<WeakKey<K>, V> nextEntry;
        private K nextKey;

        private EntryIterator(Iterator<Map.Entry<WeakKey<K>, V>> it) {
            this.iterator = it;
            findNext();
        }

        private void findNext() {
            while (this.iterator.hasNext()) {
                Map.Entry<WeakKey<K>, V> next = this.iterator.next();
                this.nextEntry = next;
                K k = (K) next.getKey().get();
                this.nextKey = k;
                if (k != null) {
                    return;
                }
            }
            this.nextEntry = null;
            this.nextKey = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextKey != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.nextKey == null) {
                throw new NoSuchElementException();
            }
            try {
                return new SimpleEntry(this.nextKey, this.nextEntry);
            } finally {
                findNext();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class SimpleEntry implements Map.Entry<K, V> {
        final Map.Entry<WeakKey<K>, V> entry;
        private final K key;

        private SimpleEntry(K k, Map.Entry<WeakKey<K>, V> entry) {
            this.key = k;
            this.entry = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            v.getClass();
            return this.entry.setValue(v);
        }
    }
}
