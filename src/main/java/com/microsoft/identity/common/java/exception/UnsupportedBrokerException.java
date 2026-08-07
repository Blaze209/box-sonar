package com.microsoft.identity.common.java.exception;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class UnsupportedBrokerException extends BaseException {
    private final String mActiveBrokerPackageName;

    public String getActiveBrokerPackageName() {
        return this.mActiveBrokerPackageName;
    }

    public UnsupportedBrokerException(String str) {
        this(str, ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_CODE, ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_MESSAGE);
        if (str == null) {
            throw new NullPointerException("activeBrokerPackageName is marked non-null but is null");
        }
    }

    public UnsupportedBrokerException(String str, String str2, @Nullable String str3) {
        super(str2, str3);
        if (str == null) {
            throw new NullPointerException("activeBrokerPackageName is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        this.mActiveBrokerPackageName = str;
    }
}
