package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsRefreshToken extends MicrosoftRefreshToken {
    public MicrosoftStsRefreshToken(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        super(microsoftStsTokenResponse);
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
    }
}
