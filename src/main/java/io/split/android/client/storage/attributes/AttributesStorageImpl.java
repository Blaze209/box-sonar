package io.split.android.client.storage.attributes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesStorageImpl implements AttributesStorage {
    private final Map<String, Object> mInMemoryAttributes = new ConcurrentHashMap();

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public Object get(String name) {
        return this.mInMemoryAttributes.get(name);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public Map<String, Object> getAll() {
        return new ConcurrentHashMap(this.mInMemoryAttributes);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void set(String name, Object value) {
        this.mInMemoryAttributes.put(name, value);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void set(Map<String, Object> attributes) {
        if (attributes == null) {
            return;
        }
        this.mInMemoryAttributes.putAll(attributes);
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void clear() {
        this.mInMemoryAttributes.clear();
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void destroy() {
        this.mInMemoryAttributes.clear();
    }

    @Override // io.split.android.client.storage.attributes.AttributesStorage
    public void remove(String key) {
        this.mInMemoryAttributes.remove(key);
    }
}
