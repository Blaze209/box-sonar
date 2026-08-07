package io.opencensus.common;

import java.io.Closeable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface NonThrowingCloseable extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
