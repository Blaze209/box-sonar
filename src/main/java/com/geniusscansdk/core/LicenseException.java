package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
public class LicenseException extends Exception {
    public final ErrorCode errorCode;

    public enum ErrorCode {
        InvalidKey,
        ExpiredKey,
        InvalidDate,
        ExpiredDemo
    }

    public LicenseException(ErrorCode errorCode, String str) {
        super(str);
        this.errorCode = errorCode;
    }
}
