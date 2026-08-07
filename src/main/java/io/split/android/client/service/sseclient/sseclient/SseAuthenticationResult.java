package io.split.android.client.service.sseclient.sseclient;

import io.split.android.client.service.sseclient.SseJwtToken;

/* JADX INFO: loaded from: classes4.dex */
public class SseAuthenticationResult {
    private final Integer httpStatus;
    private boolean isErrorRecoverable;
    private SseJwtToken jwtToken;
    private boolean pushEnabled;
    private long sseConnectionDelay;
    private boolean success;

    public SseAuthenticationResult(boolean success, boolean isErrorRecoverable, boolean pushEnabled, long sseConnectionDelay, SseJwtToken jwtToken, Integer httpStatus) {
        this.success = success;
        this.isErrorRecoverable = isErrorRecoverable;
        this.pushEnabled = pushEnabled;
        this.sseConnectionDelay = sseConnectionDelay;
        this.jwtToken = jwtToken;
        this.httpStatus = httpStatus;
    }

    public SseAuthenticationResult(boolean success, boolean isErrorRecoverable, boolean pushEnabled, long sseConnectionDelay, SseJwtToken jwtToken) {
        this(success, isErrorRecoverable, pushEnabled, sseConnectionDelay, jwtToken, null);
    }

    public SseAuthenticationResult(boolean success, boolean isErrorRecoverable) {
        this(success, isErrorRecoverable, false, 0L, null);
    }

    public SseAuthenticationResult(int httpStatus) {
        this(false, true, false, 0L, null, Integer.valueOf(httpStatus));
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isErrorRecoverable() {
        return this.isErrorRecoverable;
    }

    public boolean isPushEnabled() {
        return this.pushEnabled;
    }

    public long getSseConnectionDelay() {
        return this.sseConnectionDelay;
    }

    public SseJwtToken getJwtToken() {
        return this.jwtToken;
    }

    public Integer getHttpStatus() {
        return this.httpStatus;
    }
}
