package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.oauth2.AccessToken;
import com.microsoft.identity.common.java.util.CopyUtil;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAccessToken extends AccessToken {
    private final Date mExpiresOn;
    private final Date mExtendedExpiresOn;

    public AzureActiveDirectoryAccessToken(AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        super(azureActiveDirectoryTokenResponse);
        if (azureActiveDirectoryTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        this.mExpiresOn = CopyUtil.copyIfNotNull(azureActiveDirectoryTokenResponse.getExpiresOn());
        this.mExtendedExpiresOn = CopyUtil.copyIfNotNull(azureActiveDirectoryTokenResponse.getExtExpiresOn());
    }

    public Date getExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExpiresOn);
    }

    public Date getExtendedExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExtendedExpiresOn);
    }
}
