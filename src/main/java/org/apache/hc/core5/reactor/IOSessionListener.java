package org.apache.hc.core5.reactor;

/* JADX INFO: loaded from: classes5.dex */
public interface IOSessionListener {
    void connected(IOSession iOSession);

    void disconnected(IOSession iOSession);

    void exception(IOSession iOSession, Exception exc);

    void inputReady(IOSession iOSession);

    void outputReady(IOSession iOSession);

    void startTls(IOSession iOSession);

    void timeout(IOSession iOSession);
}
