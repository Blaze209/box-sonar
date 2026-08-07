package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public interface INameValueStorage<T> {
    void clear();

    T get(String str);

    Map<String, T> getAll();

    Iterator<Map.Entry<String, T>> getAllFilteredByKey(Predicate<String> predicate);

    Set<String> keySet();

    void put(String str, T t);

    void remove(String str);
}
