package io.split.android.client.storage.attributes;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesStorageContainerImpl implements AttributesStorageContainer {
    private final ConcurrentMap<String, AttributesStorage> mStorageMap = new ConcurrentHashMap();
    private final Object mLock = new Object();

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public AttributesStorage getStorageForKey(String matchingKey) {
        AttributesStorage attributesStorage;
        synchronized (this.mLock) {
            if (this.mStorageMap.get(matchingKey) == null) {
                this.mStorageMap.put(matchingKey, new AttributesStorageImpl());
            }
            attributesStorage = this.mStorageMap.get(matchingKey);
        }
        return attributesStorage;
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public Map<String, AttributesStorage> getCurrentStorages() {
        return new HashMap(this.mStorageMap);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorageContainer
    public void destroy() {
        this.mStorageMap.clear();
    }
}
