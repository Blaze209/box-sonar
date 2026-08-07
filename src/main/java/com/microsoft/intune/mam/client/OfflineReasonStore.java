package com.microsoft.intune.mam.client;

import com.microsoft.intune.mam.log.ExceptionUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineReasonStore {
    private static Exception mEx;
    private static String mReason;

    public static synchronized void setOfflineReason(String str, Exception exc) {
        mReason = str;
        mEx = exc;
    }

    public static synchronized void setOfflineReason(String str) {
        setOfflineReason(str, null);
    }

    public static synchronized String getOfflineReasonForLog() {
        String str = mReason;
        if (str == null) {
            return "";
        }
        if (mEx == null) {
            return str;
        }
        return mReason + ": " + ExceptionUtils.describeException(mEx);
    }

    private OfflineReasonStore() {
    }
}
