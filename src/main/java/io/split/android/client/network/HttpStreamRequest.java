package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
public interface HttpStreamRequest {
    void addHeader(String name, String value);

    void close();

    HttpStreamResponse execute() throws HttpException;
}
