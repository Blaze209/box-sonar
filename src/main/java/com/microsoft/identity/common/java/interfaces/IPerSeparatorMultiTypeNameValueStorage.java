package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public interface IPerSeparatorMultiTypeNameValueStorage<T> {
    void clear(T t);

    Map<String, String> getAll(T t);

    Iterator<Map.Entry<String, String>> getAllFilteredByKey(T t, Predicate<String> predicate);

    long getLong(T t, String str);

    String getString(T t, String str);

    Set<String> keySet(T t);

    void putLong(T t, String str, long j);

    void putString(T t, String str, String str2);

    void remove(T t, String str);
}
