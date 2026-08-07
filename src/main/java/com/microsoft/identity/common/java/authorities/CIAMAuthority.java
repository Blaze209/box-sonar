package com.microsoft.identity.common.java.authorities;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: loaded from: classes14.dex */
public class CIAMAuthority extends Authority {
    public static final String CIAM_LOGIN_URL_SEGMENT = "ciamlogin.com";
    private static final transient String TAG = "CIAMAuthority";
    private final boolean CIAM_USE_OPENID_CONFIGURATION = true;

    public CIAMAuthority(String str) {
        if (str == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        this.mAuthorityTypeString = Authority.CIAM;
        this.mAuthorityUrlString = str;
    }

    private MicrosoftStsOAuth2Configuration createOAuth2Configuration() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":createOAuth2Configuration").toString(), "Creating OAuth2Configuration");
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        microsoftStsOAuth2Configuration.setAuthorityUrl(getAuthorityURL());
        microsoftStsOAuth2Configuration.setMultipleCloudsSupported(false);
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
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2ConfigurationCreateOAuth2Configuration = createOAuth2Configuration();
        oAuth2StrategyParameters.setUsingOpenIdConfiguration(true);
        return new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2ConfigurationCreateOAuth2Configuration, oAuth2StrategyParameters);
    }

    public static String getTenantNameVariantUrlFromAuthorityWithoutPath(String str) {
        if (str == null) {
            throw new NullPointerException("authorityNoPath is marked non-null but is null");
        }
        if (str.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)) {
            str = str.substring(8);
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + str + "/" + str.split("\\.")[0] + ".onmicrosoft.com";
    }

    public static String getTenantIdVariantUrlFromAuthorityWithoutPath(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("authorityNoPath is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("tenantId is marked non-null but is null");
        }
        if (str.startsWith(AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX)) {
            str = str.substring(8);
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return AuthenticationConstants.Broker.REDIRECT_SSL_PREFIX + str + "/" + str2;
    }
}
