package com.microsoft.identity.common.java.storage;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MultiTypeNameValueStorage implements IMultiTypeNameValueStorage {
    private final INameValueStorage<String> mNameValueStringStorage;

    public MultiTypeNameValueStorage(INameValueStorage<String> iNameValueStorage) {
        this.mNameValueStringStorage = iNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putString(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.put(str, str2);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public String getString(String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return this.mNameValueStringStorage.get(str);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putLong(String str, long j) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.put(str, IGenericTypeStringAdapter.LongStringAdapter.adapt(Long.valueOf(j)));
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public long getLong(String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        String str2 = this.mNameValueStringStorage.get(str);
        if (StringUtil.isNullOrEmpty(str2)) {
            return 0L;
        }
        return IGenericTypeStringAdapter.LongStringAdapter.adapt(str2).longValue();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Map<String, String> getAll() {
        return this.mNameValueStringStorage.getAll();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        if (predicate == null) {
            throw new NullPointerException("keyFilter is marked non-null but is null");
        }
        return this.mNameValueStringStorage.getAllFilteredByKey(predicate);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public boolean contains(String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        return !StringUtil.isNullOrEmpty(getString(str));
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void clear() {
        this.mNameValueStringStorage.clear();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void remove(String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.remove(str);
    }
}
