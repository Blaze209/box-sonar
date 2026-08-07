package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageWriter<T extends MessageHeaders> {
    void write(T t, SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream) throws HttpException, IOException;
}
