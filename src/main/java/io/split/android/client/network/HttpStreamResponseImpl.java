package io.split.android.client.network;

import java.io.BufferedReader;

/* JADX INFO: loaded from: classes4.dex */
public class HttpStreamResponseImpl extends BaseHttpResponseImpl implements HttpStreamResponse {
    private final BufferedReader mData;

    HttpStreamResponseImpl(int httpStatus) {
        this(httpStatus, null);
    }

    public HttpStreamResponseImpl(int httpStatus, BufferedReader data) {
        super(httpStatus);
        this.mData = data;
    }

    @Override // io.split.android.client.network.HttpStreamResponse
    public BufferedReader getBufferedReader() {
        return this.mData;
    }
}
