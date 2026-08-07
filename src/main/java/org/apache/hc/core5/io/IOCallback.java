package org.apache.hc.core5.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface IOCallback<T> {
    void execute(T t) throws IOException;
}
