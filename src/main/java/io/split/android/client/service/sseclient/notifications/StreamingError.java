package io.split.android.client.service.sseclient.notifications;

/* JADX INFO: loaded from: classes4.dex */
public class StreamingError {
    private final int code;
    private final String message;
    private final int statusCode;

    public StreamingError(String message, int code, int statusCode) {
        this.message = message;
        this.code = code;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean shouldBeIgnored() {
        int i = this.code;
        return i < 40000 || i > 49999;
    }

    public boolean isRetryable() {
        int i = this.code;
        return i >= 40140 && i <= 40149;
    }
}
