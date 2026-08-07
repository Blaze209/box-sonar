package com.microsoft.identity.common.internal.fido;

import com.microsoft.identity.common.java.exception.BaseException;

/* JADX INFO: loaded from: classes14.dex */
public class LegacyFido2ApiException extends BaseException {
    public static final String BAD_ACTIVITY_RESULT_CODE = "bad_activity_result_code";
    public static final String GET_PENDING_INTENT_CANCELED = "get_pending_intent_canceled";
    public static final String GET_PENDING_INTENT_ERROR = "get_pending_intent_error";
    public static final String NULL_OBJECT = "null_object";
    public static final String UNKNOWN_ERROR = "unknown_error";

    public LegacyFido2ApiException(String str) {
        super(str);
    }

    public LegacyFido2ApiException(String str, String str2) {
        super(str, str2);
    }

    public LegacyFido2ApiException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
