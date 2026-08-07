package dagger.internal;

import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        Builder(int size) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(size);
        }

        Builder<K, V, V2> put(K k, Provider<V> provider) {
            this.map.put((K) Preconditions.checkNotNull(k, "key"), (Provider) Preconditions.checkNotNull(provider, NativeFormNotifications.PROVIDER_INDEX_INFO_KEY));
            return this;
        }

        Builder<K, V, V2> putAll(Provider<Map<K, V2>> mapOfProviders) {
            if (!(mapOfProviders instanceof DelegateFactory)) {
                this.map.putAll(((AbstractMapFactory) mapOfProviders).contributingMap);
                return this;
            }
            return putAll(((DelegateFactory) mapOfProviders).getDelegate());
        }
    }
}
