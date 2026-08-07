package io.split.android.client.service.synchronizer.attributes;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesSynchronizerRegistryImpl implements AttributesSynchronizerRegistry, AttributesSynchronizer {
    private final AtomicBoolean mLoadedAttributesFromCache = new AtomicBoolean(false);
    private final ConcurrentMap<String, AttributesSynchronizer> mAttributesSynchronizers = new ConcurrentHashMap();

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public synchronized void registerAttributesSynchronizer(String userKey, AttributesSynchronizer attributesSynchronizer) {
        this.mAttributesSynchronizers.put(userKey, attributesSynchronizer);
        if (this.mLoadedAttributesFromCache.get()) {
            attributesSynchronizer.loadAttributesFromCache();
        }
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerRegistry
    public void unregisterAttributesSynchronizer(String userKey) {
        this.mAttributesSynchronizers.remove(userKey);
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizer
    public synchronized void loadAttributesFromCache() {
        Iterator<AttributesSynchronizer> it = this.mAttributesSynchronizers.values().iterator();
        while (it.hasNext()) {
            it.next().loadAttributesFromCache();
        }
        this.mLoadedAttributesFromCache.set(true);
    }
}
