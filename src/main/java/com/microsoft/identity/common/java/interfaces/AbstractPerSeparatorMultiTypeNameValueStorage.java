package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractPerSeparatorMultiTypeNameValueStorage<T> implements IPerSeparatorMultiTypeNameValueStorage<T> {
    protected abstract IMultiTypeNameValueStorage getStoreForSeparator(T t);

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public String getString(T t, String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        return getStoreForSeparator(t).getString(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void putString(T t, String str, String str2) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).putString(str, str2);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void putLong(T t, String str, long j) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).putLong(str, j);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public long getLong(T t, String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        return getStoreForSeparator(t).getLong(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public Map<String, String> getAll(T t) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        return getStoreForSeparator(t).getAll();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void remove(T t, String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).remove(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void clear(T t) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        getStoreForSeparator(t).clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public Set<String> keySet(T t) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        return getStoreForSeparator(t).getAll().keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(T t, Predicate<String> predicate) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (predicate == null) {
            throw new NullPointerException("keyFilter is marked non-null but is null");
        }
        return getStoreForSeparator(t).getAllFilteredByKey(predicate);
    }
}
