package com.microsoft.identity.common.java.cache;

import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface ISimpleCache<T> {
    boolean clear();

    List<T> getAll();

    boolean insert(T t);

    boolean remove(T t);
}
