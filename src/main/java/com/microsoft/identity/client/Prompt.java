package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.oauth2.OpenIdConnectPromptParameter;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public enum Prompt {
    SELECT_ACCOUNT,
    LOGIN,
    CONSENT,
    CREATE,
    WHEN_REQUIRED;

    /* JADX INFO: renamed from: com.microsoft.identity.client.Prompt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$client$Prompt;

        static {
            int[] iArr = new int[Prompt.values().length];
            $SwitchMap$com$microsoft$identity$client$Prompt = iArr;
            try {
                iArr[Prompt.SELECT_ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.CONSENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.WHEN_REQUIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$client$Prompt[Prompt.CREATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$identity$client$Prompt[ordinal()];
        if (i == 1) {
            return SELECT_ACCOUNT.name().toLowerCase(Locale.ROOT);
        }
        if (i == 2) {
            return LOGIN.name().toLowerCase(Locale.ROOT);
        }
        if (i == 3) {
            return CONSENT.name().toLowerCase(Locale.ROOT);
        }
        if (i == 4) {
            return WHEN_REQUIRED.name().toLowerCase(Locale.ROOT);
        }
        if (i == 5) {
            return CREATE.name().toLowerCase(Locale.ROOT);
        }
        throw new IllegalArgumentException();
    }

    public OpenIdConnectPromptParameter toOpenIdConnectPromptParameter() {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$identity$client$Prompt[ordinal()];
        if (i == 2) {
            return OpenIdConnectPromptParameter.LOGIN;
        }
        if (i == 3) {
            return OpenIdConnectPromptParameter.CONSENT;
        }
        if (i == 4) {
            return OpenIdConnectPromptParameter.UNSET;
        }
        if (i == 5) {
            return OpenIdConnectPromptParameter.CREATE;
        }
        return OpenIdConnectPromptParameter.SELECT_ACCOUNT;
    }
}
