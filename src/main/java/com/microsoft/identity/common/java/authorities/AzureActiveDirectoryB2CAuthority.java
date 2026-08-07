package com.microsoft.identity.common.java.authorities;

import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryB2CAuthority extends Authority {
    private static final String TAG = "AzureActiveDirectoryB2CAuthority";

    public AzureActiveDirectoryB2CAuthority(String str) {
        this.mAuthorityTypeString = Authority.B2C;
        this.mAuthorityUrlString = str;
    }

    protected MicrosoftStsOAuth2Configuration createOAuth2Configuration() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":createOAuth2Configuration").toString(), "Creating OAuth2Configuration");
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        microsoftStsOAuth2Configuration.setMultipleCloudsSupported(false);
        microsoftStsOAuth2Configuration.setAuthorityUrl(getAuthorityURL());
        if (this.mSlice != null) {
            Logger.info(str + ":createOAuth2Configuration", "Setting slice parameters...");
            AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
            azureActiveDirectorySlice.setSlice(this.mSlice.getSlice());
            azureActiveDirectorySlice.setDataCenter(this.mSlice.getDataCenter());
            microsoftStsOAuth2Configuration.setSlice(azureActiveDirectorySlice);
        }
        return microsoftStsOAuth2Configuration;
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters oAuth2StrategyParameters) throws ClientException {
        if (oAuth2StrategyParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        return new MicrosoftStsOAuth2Strategy(createOAuth2Configuration(), oAuth2StrategyParameters);
    }

    public String getB2CPolicyName() {
        String[] strArrSplit = this.mAuthorityUrlString.split("/");
        return strArrSplit[strArrSplit.length - 1];
    }
}
