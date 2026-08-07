package org.apache.hc.core5.http.nio;

import org.apache.hc.core5.http.EntityDetails;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncEntityProducer extends AsyncDataProducer, EntityDetails {
    void failed(Exception exc);

    boolean isRepeatable();
}
