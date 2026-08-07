package com.microsoft.identity.client.exception;

import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;

/* JADX INFO: loaded from: classes14.dex */
public class MsalUnsupportedBrokerException extends MsalException {
    private final String mActiveBrokerPackageName;

    public String getActiveBrokerPackageName() {
        return this.mActiveBrokerPackageName;
    }

    public MsalUnsupportedBrokerException(UnsupportedBrokerException unsupportedBrokerException) {
        super(unsupportedBrokerException.getErrorCode(), unsupportedBrokerException.getMessage());
        if (unsupportedBrokerException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        this.mActiveBrokerPackageName = unsupportedBrokerException.getActiveBrokerPackageName();
    }
}
