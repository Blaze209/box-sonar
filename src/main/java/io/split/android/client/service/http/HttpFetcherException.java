package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public class HttpFetcherException extends HttpGeneralException {
    public HttpFetcherException(String path, String message, Integer httpStatus) {
        super(path, message, httpStatus);
    }

    public HttpFetcherException(String path, String message) {
        super(path, message);
    }
}
