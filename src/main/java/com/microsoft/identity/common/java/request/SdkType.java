package com.microsoft.identity.common.java.request;

import com.microsoft.identity.common.java.AuthenticationConstants;

/* JADX INFO: loaded from: classes14.dex */
public enum SdkType {
    ADAL,
    MSAL,
    MSAL_CPP,
    MSAL_XPLAT_LINUX,
    UNKNOWN;

    public String getProductName() {
        if (ADAL == this || MSAL == this) {
            return AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL;
        }
        if (MSAL_CPP == this) {
            return AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL_CPP;
        }
        if (MSAL_XPLAT_LINUX == this) {
            return AuthenticationConstants.SdkPlatformFields.PRODUCT_NAME_MSAL_XPLAT_LINUX;
        }
        return "";
    }

    public boolean isCapableOfMSA() {
        return this == MSAL || this == MSAL_CPP || this == MSAL_XPLAT_LINUX;
    }
}
