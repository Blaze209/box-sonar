package org.apache.hc.core5.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class StreamClosedException extends IOException {
    private static final long serialVersionUID = 1;

    public StreamClosedException() {
        super("Stream already closed");
    }

    public StreamClosedException(String str) {
        super(str);
    }
}
