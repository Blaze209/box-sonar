package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MapBackedPreferencesManager implements IMultiTypeNameValueStorage {
    private final Map<String, String> mBackingStore = new HashMap();

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putString(String str, String str2) {
        this.mBackingStore.put(str, str2);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public String getString(String str) {
        return this.mBackingStore.get(str);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putLong(String str, long j) {
        this.mBackingStore.put(str, Long.toString(j));
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public long getLong(String str) {
        String str2 = this.mBackingStore.get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.parseLong(str2);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Map<String, String> getAll() {
        return new HashMap(this.mBackingStore);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.mBackingStore.entrySet()) {
            if (predicate.test(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map.entrySet().iterator();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public boolean contains(String str) {
        return this.mBackingStore.containsKey(str);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void clear() {
        this.mBackingStore.clear();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void remove(String str) {
        this.mBackingStore.remove(str);
    }
}
