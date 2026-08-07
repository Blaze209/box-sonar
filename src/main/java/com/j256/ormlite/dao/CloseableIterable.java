package com.j256.ormlite.dao;

/* JADX INFO: loaded from: classes14.dex */
public interface CloseableIterable<T> extends Iterable<T> {
    CloseableIterator<T> closeableIterator();
}
