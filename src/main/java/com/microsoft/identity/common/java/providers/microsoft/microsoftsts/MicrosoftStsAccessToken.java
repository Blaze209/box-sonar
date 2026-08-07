package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.oauth2.AccessToken;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAccessToken extends AccessToken {
    private Long mExtExpiresIn;

    public MicrosoftStsAccessToken(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        super(microsoftStsTokenResponse);
        this.mExtExpiresIn = microsoftStsTokenResponse.getExtExpiresIn();
    }

    protected Long getExtExpiresIn() {
        return this.mExtExpiresIn;
    }

    protected void setExtExpiresIn(Long l) {
        this.mExtExpiresIn = l;
    }
}
