package dagger.internal;

import dagger.Lazy;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {
    public static <K, V> Builder<K, V> builder(int size) {
        return new Builder<>(size);
    }

    private MapProviderFactory(Map<K, Provider<V>> contributingMap) {
        super(contributingMap);
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Provider<V>> get() {
        return contributingMap();
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        private Builder(int size) {
            super(size);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K key, Provider<V> providerOfValue) {
            super.put((Object) key, (Provider) providerOfValue);
            return this;
        }

        @Deprecated
        public Builder<K, V> put(K key, javax.inject.Provider<V> providerOfValue) {
            return put((Object) key, (Provider) Providers.asDaggerProvider(providerOfValue));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> mapProviderFactory) {
            super.putAll((Provider) mapProviderFactory);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(final javax.inject.Provider<Map<K, javax.inject.Provider<V>>> mapProviderFactory) {
            return putAll((Provider) new Provider<Map<K, Provider<V>>>() { // from class: dagger.internal.MapProviderFactory.Builder.1
                @Override // javax.inject.Provider, jakarta.inject.Provider
                public Map<K, Provider<V>> get() {
                    Map map = (Map) mapProviderFactory.get();
                    if (map.isEmpty()) {
                        return Collections.emptyMap();
                    }
                    LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(map.size());
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), Providers.asDaggerProvider((javax.inject.Provider) entry.getValue()));
                    }
                    return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
                }
            });
        }

        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
        }
    }
}
