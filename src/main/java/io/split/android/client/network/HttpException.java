package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
public class HttpException extends Exception {
    private final Integer mStatusCode;

    public HttpException(String message) {
        super("HttpException: " + message);
        this.mStatusCode = null;
    }

    public HttpException(String message, int statusCode) {
        super("HttpException: " + message);
        this.mStatusCode = Integer.valueOf(statusCode);
    }

    public Integer getStatusCode() {
        return this.mStatusCode;
    }
}
