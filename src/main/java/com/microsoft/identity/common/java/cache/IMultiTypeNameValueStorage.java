package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IMultiTypeNameValueStorage {
    void clear();

    boolean contains(String str);

    Map<String, String> getAll();

    Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate);

    long getLong(String str);

    String getString(String str);

    void putLong(String str, long j);

    void putString(String str, String str2);

    void remove(String str);
}
