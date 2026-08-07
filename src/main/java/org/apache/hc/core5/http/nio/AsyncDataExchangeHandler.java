package org.apache.hc.core5.http.nio;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncDataExchangeHandler extends AsyncDataConsumer, AsyncDataProducer {
    void failed(Exception exc);
}
