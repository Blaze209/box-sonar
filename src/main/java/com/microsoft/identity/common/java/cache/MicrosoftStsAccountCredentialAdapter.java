package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAccount;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.DateUtilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAccountCredentialAdapter implements IAccountCredentialAdapter<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> {
    private static final String TAG = "MicrosoftStsAccountCredentialAdapter";

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public AccountRecord createAccount(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        Logger.verbose(TAG, "Creating Account");
        return new AccountRecord(microsoftStsOAuth2Strategy.createAccount(microsoftStsTokenResponse));
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public AccessTokenRecord createAccessToken(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        try {
            long cachedAt = getCachedAt();
            long expiresOn = getExpiresOn(microsoftStsTokenResponse);
            long refreshOn = getRefreshOn(microsoftStsTokenResponse);
            ClientInfo clientInfo = new ClientInfo(microsoftStsTokenResponse.getClientInfo());
            AccessTokenRecord accessTokenRecord = new AccessTokenRecord();
            accessTokenRecord.setCredentialType(getCredentialType(StringUtil.sanitizeNull(microsoftStsTokenResponse.getTokenType())));
            accessTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(clientInfo));
            accessTokenRecord.setRealm(getRealm(microsoftStsOAuth2Strategy, microsoftStsTokenResponse));
            accessTokenRecord.setEnvironment(microsoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
            accessTokenRecord.setClientId(microsoftStsAuthorizationRequest.getClientId());
            accessTokenRecord.setTarget(getTarget(microsoftStsAuthorizationRequest.getScope(), microsoftStsTokenResponse.getScope()));
            accessTokenRecord.setCachedAt(String.valueOf(cachedAt));
            accessTokenRecord.setExpiresOn(String.valueOf(expiresOn));
            accessTokenRecord.setRefreshOn(String.valueOf(refreshOn));
            accessTokenRecord.setSecret(microsoftStsTokenResponse.getAccessToken());
            accessTokenRecord.setExtendedExpiresOn(getExtendedExpiresOn(microsoftStsTokenResponse));
            accessTokenRecord.setAuthority(microsoftStsOAuth2Strategy.getAuthorityFromTokenEndpoint());
            accessTokenRecord.setAccessTokenType(microsoftStsTokenResponse.getTokenType());
            accessTokenRecord.setApplicationIdentifier(microsoftStsAuthorizationRequest.getApplicationIdentifier());
            accessTokenRecord.setMamEnrollmentIdentifier(microsoftStsAuthorizationRequest.getMamEnrollmentIdentifier());
            if (TokenRequest.TokenType.POP.equalsIgnoreCase(microsoftStsTokenResponse.getTokenType())) {
                accessTokenRecord.setKid(microsoftStsOAuth2Strategy.getDeviceAtPopThumbprint());
            }
            return accessTokenRecord;
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCredentialType(String str) {
        if (str != null) {
            return TokenRequest.TokenType.POP.equalsIgnoreCase(str) ? CredentialType.AccessToken_With_AuthScheme.name() : CredentialType.AccessToken.name();
        }
        throw new NullPointerException("tokenType is marked non-null but is null");
    }

    private String getTarget(String str, String str2) {
        if (!StringUtil.isNullOrEmpty(str2)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = new HashSet(Arrays.asList(str.split("\\s+")));
        hashSet.removeAll(AuthenticationConstants.DEFAULT_SCOPES);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next()).append(' ');
        }
        return sb.toString().trim();
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public RefreshTokenRecord createRefreshToken(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        try {
            long cachedAt = getCachedAt();
            ClientInfo clientInfo = new ClientInfo(microsoftStsTokenResponse.getClientInfo());
            RefreshTokenRecord refreshTokenRecord = new RefreshTokenRecord();
            refreshTokenRecord.setCredentialType(CredentialType.RefreshToken.name());
            refreshTokenRecord.setEnvironment(microsoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
            refreshTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(clientInfo));
            refreshTokenRecord.setClientId(microsoftStsAuthorizationRequest.getClientId());
            refreshTokenRecord.setSecret(microsoftStsTokenResponse.getRefreshToken());
            refreshTokenRecord.setFamilyId(microsoftStsTokenResponse.getFamilyId());
            refreshTokenRecord.setTarget(getTarget(microsoftStsAuthorizationRequest.getScope(), microsoftStsTokenResponse.getScope()));
            refreshTokenRecord.setCachedAt(String.valueOf(cachedAt));
            return refreshTokenRecord;
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public IdTokenRecord createIdToken(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        try {
            ClientInfo clientInfo = new ClientInfo(microsoftStsTokenResponse.getClientInfo());
            IdTokenRecord idTokenRecord = new IdTokenRecord();
            idTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(clientInfo));
            idTokenRecord.setEnvironment(microsoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
            idTokenRecord.setRealm(getRealm(microsoftStsOAuth2Strategy, microsoftStsTokenResponse));
            idTokenRecord.setCredentialType(SchemaUtil.getCredentialTypeFromVersion(microsoftStsTokenResponse.getIdToken()));
            idTokenRecord.setClientId(microsoftStsAuthorizationRequest.getClientId());
            idTokenRecord.setSecret(microsoftStsTokenResponse.getIdToken());
            idTokenRecord.setAuthority(microsoftStsOAuth2Strategy.getAuthorityFromTokenEndpoint());
            return idTokenRecord;
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public RefreshTokenRecord asRefreshToken(MicrosoftRefreshToken microsoftRefreshToken) {
        if (microsoftRefreshToken == null) {
            throw new NullPointerException("refreshTokenIn is marked non-null but is null");
        }
        RefreshTokenRecord refreshTokenRecord = new RefreshTokenRecord();
        refreshTokenRecord.setHomeAccountId(microsoftRefreshToken.getHomeAccountId());
        refreshTokenRecord.setEnvironment(microsoftRefreshToken.getEnvironment());
        refreshTokenRecord.setCredentialType(CredentialType.RefreshToken.name());
        refreshTokenRecord.setClientId(microsoftRefreshToken.getClientId());
        refreshTokenRecord.setSecret(microsoftRefreshToken.getSecret());
        refreshTokenRecord.setTarget(microsoftRefreshToken.getTarget());
        refreshTokenRecord.setCachedAt(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        refreshTokenRecord.setFamilyId(microsoftRefreshToken.getFamilyId());
        return refreshTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public AccountRecord asAccount(MicrosoftAccount microsoftAccount) {
        return new AccountRecord(microsoftAccount);
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public IdTokenRecord asIdToken(MicrosoftAccount microsoftAccount, MicrosoftRefreshToken microsoftRefreshToken) {
        long cachedAt = getCachedAt();
        IDToken iDToken = microsoftAccount.getIDToken();
        IdTokenRecord idTokenRecord = new IdTokenRecord();
        idTokenRecord.setHomeAccountId(microsoftRefreshToken.getHomeAccountId());
        idTokenRecord.setEnvironment(microsoftRefreshToken.getEnvironment());
        idTokenRecord.setRealm(microsoftAccount.getRealm());
        idTokenRecord.setCredentialType(CredentialType.IdToken.name());
        idTokenRecord.setClientId(microsoftRefreshToken.getClientId());
        idTokenRecord.setSecret(iDToken.getRawIDToken());
        idTokenRecord.setCachedAt(String.valueOf(cachedAt));
        idTokenRecord.setAuthority(SchemaUtil.getAuthority(iDToken));
        return idTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public AccountRecord createAccountRecord(TokenCommandParameters tokenCommandParameters, SdkType sdkType, MicrosoftStsTokenResponse microsoftStsTokenResponse) throws ServiceException {
        AccountRecord accountRecord;
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("microsoftStsTokenResponse is marked non-null but is null");
        }
        String str = TAG + ":createAccountRecord";
        ClientInfo clientInfo = new ClientInfo(microsoftStsTokenResponse.getClientInfo());
        if (sdkType.equals(SdkType.ADAL)) {
            accountRecord = new AccountRecord(new AzureActiveDirectoryAccount(new IDToken(microsoftStsTokenResponse.getIdToken()), clientInfo));
        } else {
            accountRecord = new AccountRecord(new MicrosoftStsAccount(new IDToken(microsoftStsTokenResponse.getIdToken()), clientInfo));
        }
        URL authorityURL = tokenCommandParameters.getAuthority().getAuthorityURL();
        if (!microsoftStsTokenResponse.getAuthority().isEmpty()) {
            try {
                authorityURL = new URL(microsoftStsTokenResponse.getAuthority());
            } catch (MalformedURLException e) {
                Logger.error(str, "Authority url construction failed, setting request authority to result", e);
            }
        }
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(authorityURL);
        if (azureActiveDirectoryCloud != null) {
            Logger.info(str, "Using preferred cache host name...");
            accountRecord.setEnvironment(azureActiveDirectoryCloud.getPreferredCacheHostName());
        } else {
            accountRecord.setEnvironment(authorityURL.getHost());
        }
        return accountRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public AccessTokenRecord createAccessTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, MicrosoftStsTokenResponse microsoftStsTokenResponse) throws ClientException {
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        String str = TAG + ":createAccessTokenRecord";
        AccessTokenRecord accessTokenRecord = new AccessTokenRecord();
        accessTokenRecord.setHomeAccountId(accountRecord.getHomeAccountId());
        accessTokenRecord.setRealm(accountRecord.getRealm());
        AbstractAuthenticationScheme authenticationScheme = tokenCommandParameters.getAuthenticationScheme();
        if (authenticationScheme instanceof PopAuthenticationSchemeInternal) {
            IDevicePopManager defaultDevicePopManager = tokenCommandParameters.getPlatformComponents().getDefaultDevicePopManager();
            accessTokenRecord.setCredentialType(CredentialType.AccessToken_With_AuthScheme.name());
            accessTokenRecord.setKid(defaultDevicePopManager.getAsymmetricKeyThumbprint());
        } else if (authenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal) {
            accessTokenRecord.setCredentialType(CredentialType.AccessToken_With_AuthScheme.name());
            accessTokenRecord.setKid(((PopAuthenticationSchemeWithClientKeyInternal) authenticationScheme).getKid());
        } else {
            accessTokenRecord.setCredentialType(CredentialType.AccessToken.name());
        }
        accessTokenRecord.setClientId(tokenCommandParameters.getClientId());
        accessTokenRecord.setApplicationIdentifier(tokenCommandParameters.getApplicationIdentifier());
        accessTokenRecord.setSecret(microsoftStsTokenResponse.getAccessToken());
        accessTokenRecord.setAccessTokenType(microsoftStsTokenResponse.getTokenType());
        accessTokenRecord.setTarget(getTarget(StringUtil.join(" ", tokenCommandParameters.getScopes()), microsoftStsTokenResponse.getScope()));
        setCredentialEnvironment(accessTokenRecord, tokenCommandParameters.getAuthority(), microsoftStsTokenResponse, str);
        if (microsoftStsTokenResponse.getExpiresIn() != null) {
            accessTokenRecord.setExpiresOn(String.valueOf(DateUtilities.getExpiresOn(microsoftStsTokenResponse.getExpiresIn().longValue())));
        }
        if (microsoftStsTokenResponse.getExtExpiresIn() != null) {
            accessTokenRecord.setExtendedExpiresOn(String.valueOf(DateUtilities.getExpiresOn(microsoftStsTokenResponse.getExtExpiresIn().longValue())));
        }
        accessTokenRecord.setCachedAt(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        return accessTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public RefreshTokenRecord createRefreshTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        String str = TAG + ":createRefreshTokenRecord";
        RefreshTokenRecord refreshTokenRecord = new RefreshTokenRecord();
        refreshTokenRecord.setHomeAccountId(accountRecord.getHomeAccountId());
        refreshTokenRecord.setCredentialType(CredentialType.RefreshToken.name());
        setCredentialEnvironment(refreshTokenRecord, tokenCommandParameters.getAuthority(), microsoftStsTokenResponse, str);
        refreshTokenRecord.setClientId(tokenCommandParameters.getClientId());
        refreshTokenRecord.setSecret(microsoftStsTokenResponse.getRefreshToken());
        refreshTokenRecord.setFamilyId(microsoftStsTokenResponse.getFamilyId());
        refreshTokenRecord.setTarget(getTarget(StringUtil.join(" ", tokenCommandParameters.getScopes()), microsoftStsTokenResponse.getScope()));
        refreshTokenRecord.setCachedAt(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
        return refreshTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialAdapter
    public IdTokenRecord createIdTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        String str = TAG + ":createIdTokenRecord";
        IdTokenRecord idTokenRecord = new IdTokenRecord();
        idTokenRecord.setHomeAccountId(accountRecord.getHomeAccountId());
        idTokenRecord.setRealm(accountRecord.getRealm());
        idTokenRecord.setCredentialType(SchemaUtil.getCredentialTypeFromVersion(microsoftStsTokenResponse.getIdToken()));
        idTokenRecord.setClientId(tokenCommandParameters.getClientId());
        idTokenRecord.setSecret(microsoftStsTokenResponse.getIdToken());
        setCredentialEnvironment(idTokenRecord, tokenCommandParameters.getAuthority(), microsoftStsTokenResponse, str);
        return idTokenRecord;
    }

    private void setCredentialEnvironment(Credential credential, Authority authority, MicrosoftTokenResponse microsoftTokenResponse, String str) {
        if (credential == null) {
            throw new NullPointerException("credential is marked non-null but is null");
        }
        if (authority == null) {
            throw new NullPointerException("requestAuthority is marked non-null but is null");
        }
        if (microsoftTokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("callingMethodTag is marked non-null but is null");
        }
        String str2 = str + ":setCredentialEnvironment";
        URL authorityURL = authority.getAuthorityURL();
        if (!microsoftTokenResponse.getAuthority().isEmpty()) {
            try {
                authorityURL = new URL(microsoftTokenResponse.getAuthority());
            } catch (MalformedURLException e) {
                Logger.error(str2, "Authority url construction failed, setting request authority to result", e);
            }
        }
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(authorityURL);
        if (azureActiveDirectoryCloud != null) {
            Logger.info(str2, "Using preferred cache host name...");
            credential.setEnvironment(azureActiveDirectoryCloud.getPreferredCacheHostName());
        } else {
            credential.setEnvironment(authorityURL.getHost());
        }
        if (credential instanceof IdTokenRecord) {
            ((IdTokenRecord) credential).setAuthority(authorityURL.toString());
        }
        if (credential instanceof AccessTokenRecord) {
            ((AccessTokenRecord) credential).setAuthority(authorityURL.toString());
        }
    }

    private String getExtendedExpiresOn(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + (microsoftStsTokenResponse.getExtExpiresIn() == null ? 0L : microsoftStsTokenResponse.getExtExpiresIn().longValue()));
    }

    private String getRealm(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        return microsoftStsOAuth2Strategy.createAccount(microsoftStsTokenResponse).getRealm();
    }

    private long getCachedAt() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    private long getExpiresOn(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + microsoftStsTokenResponse.getExpiresIn().longValue();
    }

    private long getRefreshOn(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + (microsoftStsTokenResponse.getRefreshIn() == null ? microsoftStsTokenResponse.getExpiresIn() : microsoftStsTokenResponse.getRefreshIn()).longValue();
    }
}
