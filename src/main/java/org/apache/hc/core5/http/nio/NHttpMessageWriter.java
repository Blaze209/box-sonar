package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface NHttpMessageWriter<T extends MessageHeaders> {
    void reset();

    void write(T t, SessionOutputBuffer sessionOutputBuffer) throws HttpException, IOException;
}
