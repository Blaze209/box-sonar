package org.apache.hc.core5.http.nio;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncDataProducer extends ResourceHolder {
    int available();

    void produce(DataStreamChannel dataStreamChannel) throws IOException;
}
