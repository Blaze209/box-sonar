package org.apache.hc.core5.http.impl.nio;

/* JADX INFO: loaded from: classes5.dex */
public enum MessageState {
    IDLE,
    HEADERS,
    ACK,
    BODY,
    COMPLETE
}
