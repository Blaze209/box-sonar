package org.apache.hc.core5.http;

/* JADX INFO: loaded from: classes5.dex */
public class RequestNotExecutedException extends ConnectionClosedException {
    public RequestNotExecutedException() {
        super("Connection is closed");
    }

    public RequestNotExecutedException(String str) {
        super(str);
    }
}
