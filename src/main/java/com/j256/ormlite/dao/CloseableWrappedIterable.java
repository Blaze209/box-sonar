package com.j256.ormlite.dao;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes14.dex */
public interface CloseableWrappedIterable<T> extends CloseableIterable<T> {
    void close() throws SQLException;
}
