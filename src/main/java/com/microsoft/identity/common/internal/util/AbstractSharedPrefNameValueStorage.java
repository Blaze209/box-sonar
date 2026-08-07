package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractSharedPrefNameValueStorage<T> implements INameValueStorage<T> {
    protected IMultiTypeNameValueStorage mManager;

    public AbstractSharedPrefNameValueStorage(IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        this.mManager = iMultiTypeNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.remove(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mManager.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Set<String> keySet() {
        return this.mManager.getAll().keySet();
    }
}
