package com.microsoft.identity.common.java.providers.oauth2;

import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public enum OpenIdConnectPromptParameter {
    UNSET,
    NONE,
    SELECT_ACCOUNT,
    LOGIN,
    CONSENT,
    CREATE;

    @Override // java.lang.Enum
    public String toString() {
        if (this == UNSET) {
            return "";
        }
        return name().toLowerCase(Locale.ROOT);
    }

    public static OpenIdConnectPromptParameter _fromPromptBehavior(String str) {
        if (str != null && str.equals("FORCE_PROMPT")) {
            return LOGIN;
        }
        return UNSET;
    }
}
