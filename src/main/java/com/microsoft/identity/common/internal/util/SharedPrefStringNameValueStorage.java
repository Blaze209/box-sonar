package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class SharedPrefStringNameValueStorage extends AbstractSharedPrefNameValueStorage<String> {
    public SharedPrefStringNameValueStorage(IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        super(iMultiTypeNameValueStorage);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public String get(String str) {
        if (str != null) {
            return this.mManager.getString(str);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Map<String, String> getAll() {
        return this.mManager.getAll();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.putString(str, str2);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        return this.mManager.getAllFilteredByKey(predicate);
    }
}
