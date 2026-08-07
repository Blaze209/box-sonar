package com.microsoft.identity.common.java.exception;

/* JADX INFO: loaded from: classes14.dex */
public final class InsufficientDeviceRegistrationException extends BaseException {
    public InsufficientDeviceRegistrationException(String str, String str2, String str3) {
        super(str, str2);
        if (str == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("errorDescription is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("userName is marked non-null but is null");
        }
        super.setUsername(str3);
    }
}
