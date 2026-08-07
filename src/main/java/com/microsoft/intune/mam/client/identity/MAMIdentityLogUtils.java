package com.microsoft.intune.mam.client.identity;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMIdentityLogUtils {
    private static final String EMPTY = "<empty>";
    private static final String EMPTY_IDENTITY = "<empty identity>";
    private static final String NULL = "<null>";
    private static final String NULL_IDENTITY = "<null identity>";

    public static String formatForLog(MAMIdentity mAMIdentity, boolean z) {
        if (mAMIdentity == null) {
            return NULL_IDENTITY;
        }
        return formatForLog(mAMIdentity.rawUPN(), mAMIdentity.aadId(), z);
    }

    public static String formatForLog(String str, String str2, boolean z) {
        if (str == null && str2 == null) {
            return NULL_IDENTITY;
        }
        if (str != null && str.isEmpty() && str2 != null && str2.isEmpty()) {
            return EMPTY_IDENTITY;
        }
        String value = formatValue(str, z);
        String value2 = formatValue(str2, z);
        if (z) {
            return value + AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER + value2;
        }
        return "User" + value + "." + value2;
    }

    private static String formatValue(String str, boolean z) {
        if (str == null) {
            return NULL;
        }
        if (str.isEmpty()) {
            return EMPTY;
        }
        return z ? str : String.valueOf(Math.abs(MAMIdentity.canonicalize(str).hashCode()));
    }

    private MAMIdentityLogUtils() {
    }
}
