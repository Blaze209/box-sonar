package io.split.android.client.service.http;

/* JADX INFO: loaded from: classes4.dex */
public enum HttpStatus {
    URI_TOO_LONG(414, "URI Too Long"),
    FORBIDDEN(403, "Forbidden"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_NON_RETRYABLE(9009, "Non retryable"),
    INTERNAL_PROXY_OUTDATED(9010, "Split Proxy outdated");

    private final int mCode;
    private final String mDescription;

    HttpStatus(int code, String description) {
        this.mCode = code;
        this.mDescription = description;
    }

    public int getCode() {
        return this.mCode;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public static HttpStatus fromCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (HttpStatus httpStatus : values()) {
            if (httpStatus.getCode() == code.intValue()) {
                return httpStatus;
            }
        }
        return null;
    }

    public static boolean isNotRetryable(HttpStatus httpStatus) {
        return httpStatus == URI_TOO_LONG || httpStatus == FORBIDDEN || httpStatus == INTERNAL_NON_RETRYABLE;
    }

    public static boolean isNotRetryable(Integer code) {
        return isNotRetryable(fromCode(code));
    }

    public static boolean isProxyOutdated(HttpStatus status) {
        return status == INTERNAL_PROXY_OUTDATED;
    }
}
