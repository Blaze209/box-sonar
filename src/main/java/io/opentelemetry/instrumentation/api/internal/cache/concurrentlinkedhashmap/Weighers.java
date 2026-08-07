package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class Weighers {

    enum SingletonEntryWeigher implements EntryWeigher<Object, Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public int weightOf(Object obj, Object obj2) {
            return 1;
        }
    }

    enum SingletonWeigher implements Weigher<Object> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(Object obj) {
            return 1;
        }
    }

    private Weighers() {
        throw new AssertionError();
    }

    public static <K, V> EntryWeigher<K, V> asEntryWeigher(Weigher<? super V> weigher) {
        if (weigher == singleton()) {
            return entrySingleton();
        }
        return new EntryWeigherView(weigher);
    }

    public static <K, V> EntryWeigher<K, V> entrySingleton() {
        return SingletonEntryWeigher.INSTANCE;
    }

    public static <V> Weigher<V> singleton() {
        return SingletonWeigher.INSTANCE;
    }

    public static Weigher<byte[]> byteArray() {
        return ByteArrayWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Iterable<E>> iterable() {
        return IterableWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Collection<E>> collection() {
        return CollectionWeigher.INSTANCE;
    }

    public static <E> Weigher<? super List<E>> list() {
        return ListWeigher.INSTANCE;
    }

    public static <E> Weigher<? super Set<E>> set() {
        return SetWeigher.INSTANCE;
    }

    public static <A, B> Weigher<? super Map<A, B>> map() {
        return MapWeigher.INSTANCE;
    }

    static final class EntryWeigherView<K, V> implements EntryWeigher<K, V>, Serializable {
        static final long serialVersionUID = 1;
        final Weigher<? super V> weigher;

        EntryWeigherView(Weigher<? super V> weigher) {
            ConcurrentLinkedHashMap.checkNotNull(weigher);
            this.weigher = weigher;
        }

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.EntryWeigher
        public int weightOf(K k, V v) {
            return this.weigher.weightOf(v);
        }
    }

    enum ByteArrayWeigher implements Weigher<byte[]> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(byte[] bArr) {
            return bArr.length;
        }
    }

    enum IterableWeigher implements Weigher<Iterable<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(Iterable<?> iterable) {
            if (iterable instanceof Collection) {
                return ((Collection) iterable).size();
            }
            Iterator<?> it = iterable.iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                i++;
            }
            return i;
        }
    }

    enum CollectionWeigher implements Weigher<Collection<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(Collection<?> collection) {
            return collection.size();
        }
    }

    enum ListWeigher implements Weigher<List<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(List<?> list) {
            return list.size();
        }
    }

    enum SetWeigher implements Weigher<Set<?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(Set<?> set) {
            return set.size();
        }
    }

    enum MapWeigher implements Weigher<Map<?, ?>> {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.Weigher
        public int weightOf(Map<?, ?> map) {
            return map.size();
        }
    }
}
