package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HttpGeneralException extends Exception {
    private final Integer mHttpStatus;

    public HttpGeneralException(String path, String message, Integer httpStatus) {
        super(getMessage(path, message, httpStatus));
        this.mHttpStatus = httpStatus;
    }

    public HttpGeneralException(String path, String message) {
        super(getMessage(path, message, null));
        this.mHttpStatus = null;
    }

    private static String getMessage(String path, String message, Integer httpStatus) {
        return String.format("Error while sending data to %s: %s%s", path, message, httpStatus != null ? ". Http status: " + httpStatus : "");
    }

    public Integer getHttpStatus() {
        return this.mHttpStatus;
    }
}
