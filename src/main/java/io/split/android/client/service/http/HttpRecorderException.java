package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public class HttpRecorderException extends HttpGeneralException {
    public HttpRecorderException(String path, String message, Integer httpStatus) {
        super(path, message, httpStatus);
    }

    public HttpRecorderException(String path, String message) {
        super(path, message);
    }
}
