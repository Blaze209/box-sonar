package org.apache.hc.core5.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface IOEventHandler {
    void connected(IOSession iOSession) throws IOException;

    void disconnected(IOSession iOSession);

    void exception(IOSession iOSession, Exception exc);

    void inputReady(IOSession iOSession, ByteBuffer byteBuffer) throws IOException;

    void outputReady(IOSession iOSession) throws IOException;

    void timeout(IOSession iOSession, Timeout timeout) throws IOException;
}
