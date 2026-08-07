package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.AuthenticationSchemeFactory;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.challengehandlers.PKeyAuthChallengeFactory;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.LibraryInfoHelper;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfigurationClient;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsOAuth2Strategy extends OAuth2Strategy<MicrosoftStsAccessToken, MicrosoftStsAccount, MicrosoftStsAuthorizationRequest, MicrosoftStsAuthorizationRequest.Builder, IAuthorizationStrategy, MicrosoftStsOAuth2Configuration, OAuth2StrategyParameters, MicrosoftStsAuthorizationResponse, MicrosoftStsRefreshToken, MicrosoftStsTokenRequest, MicrosoftStsTokenResponse, TokenResult, AuthorizationResult> {
    private static final String RESOURCE_DEFAULT_SCOPE = "/.default";
    private static final String TAG = "MicrosoftStsOAuth2Strategy";
    private final HttpClient httpClient;
    private OpenIdProviderConfiguration mOpenIdProviderConfiguration;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateAuthorizationRequest(MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateTokenRequest(MicrosoftStsTokenRequest microsoftStsTokenRequest) {
    }

    public MicrosoftStsOAuth2Strategy(MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration, OAuth2StrategyParameters oAuth2StrategyParameters) throws ClientException {
        super(microsoftStsOAuth2Configuration, oAuth2StrategyParameters);
        this.httpClient = UrlConnectionHttpClient.getDefaultInstance();
        if (microsoftStsOAuth2Configuration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (oAuth2StrategyParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (oAuth2StrategyParameters.isUsingOpenIdConfiguration()) {
            try {
                if (microsoftStsOAuth2Configuration.getSlice() != null && microsoftStsOAuth2Configuration.getSlice().getDataCenter() != null) {
                    loadOpenIdProviderConfiguration("?dc=" + microsoftStsOAuth2Configuration.getSlice().getDataCenter());
                } else {
                    loadOpenIdProviderConfiguration();
                }
                String tokenEndpoint = this.mOpenIdProviderConfiguration.getTokenEndpoint();
                if (!StringUtil.isNullOrEmpty(tokenEndpoint)) {
                    setTokenEndpoint(tokenEndpoint);
                    return;
                } else {
                    setTokenEndpoint(microsoftStsOAuth2Configuration.getTokenEndpoint().toString());
                    return;
                }
            } catch (ServiceException e) {
                Logger.error(TAG, "There was a problem with loading the openIdConfiguration", e);
                setTokenEndpoint(microsoftStsOAuth2Configuration.getTokenEndpoint().toString());
                return;
            }
        }
        setTokenEndpoint(microsoftStsOAuth2Configuration.getTokenEndpoint().toString());
    }

    public static String getScopeFromResource(String str) {
        if (str == null) {
            throw new NullPointerException("resource is marked non-null but is null");
        }
        return str + RESOURCE_DEFAULT_SCOPE;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AuthorizationResultFactory getAuthorizationResultFactory() {
        return new MicrosoftStsAuthorizationResultFactory();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public String getIssuerCacheIdentifier(MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) {
        if (microsoftStsAuthorizationRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        URL authority = microsoftStsAuthorizationRequest.getAuthority();
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(authority);
        if (azureActiveDirectoryCloud != null) {
            String preferredCacheHostName = azureActiveDirectoryCloud.getPreferredCacheHostName();
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            Logger.verbose(sb.append(str).append(":getIssuerCacheIdentifier").toString(), "Using preferred cache host name...");
            Logger.verbose(str + ":getIssuerCacheIdentifier", "Preferred cache hostname: [" + preferredCacheHostName + "]");
            return preferredCacheHostName;
        }
        return authority.getHost();
    }

    private String getIssuerCacheIdentifierFromAuthority(URL url) {
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(url);
        if (azureActiveDirectoryCloud != null) {
            String preferredCacheHostName = azureActiveDirectoryCloud.getPreferredCacheHostName();
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            Logger.info(sb.append(str).append(":getIssuerCacheIdentifierFromAuthority").toString(), "Using preferred cache host name...");
            Logger.infoPII(str + ":getIssuerCacheIdentifierFromAuthority", "Preferred cache hostname: [" + preferredCacheHostName + "]");
            return preferredCacheHostName;
        }
        return url.getHost();
    }

    public String getIssuerCacheIdentifierFromTokenEndpoint() {
        URL url;
        try {
            url = new URL(this.mTokenEndpoint);
        } catch (MalformedURLException e) {
            Logger.error(TAG + ":getIssuerCacheIdentifierFromTokenEndpoint", "Getting issuer cache identifier from token endpoint failed due to malformed URL (mTokenEndpoint)...", e);
            url = null;
        }
        if (url != null) {
            return getIssuerCacheIdentifierFromAuthority(url);
        }
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsAccessToken getAccessTokenFromResponse(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        Logger.verbose(TAG + ":getAccessTokenFromResponse", "Getting AT from TokenResponse...");
        return new MicrosoftStsAccessToken(microsoftStsTokenResponse);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsRefreshToken getRefreshTokenFromResponse(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        Logger.verbose(TAG + ":getRefreshTokenFromResponse", "Getting RT from TokenResponse...");
        return new MicrosoftStsRefreshToken(microsoftStsTokenResponse);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsAccount createAccount(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        Logger.verbose(TAG + ":createAccount", "Creating account from TokenResponse...");
        try {
            MicrosoftStsAccount microsoftStsAccount = new MicrosoftStsAccount(new IDToken(microsoftStsTokenResponse.getIdToken()), new ClientInfo(microsoftStsTokenResponse.getClientInfo()));
            microsoftStsAccount.setEnvironment(getIssuerCacheIdentifierFromTokenEndpoint());
            return microsoftStsAccount;
        } catch (ServiceException e) {
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            Logger.error(sb.append(str).append(":createAccount").toString(), "Failed to construct IDToken or ClientInfo", null);
            Logger.errorPII(str + ":createAccount", "Failed with Exception", e);
            throw new RuntimeException();
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsAuthorizationRequest.Builder createAuthorizationRequestBuilder() {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":createAuthorizationRequestBuilder").toString(), "Creating AuthorizationRequestBuilder...");
        MicrosoftStsAuthorizationRequest.Builder builder = new MicrosoftStsAuthorizationRequest.Builder();
        builder.setAuthority(((MicrosoftStsOAuth2Configuration) this.mConfig).getAuthorityUrl());
        if (((MicrosoftStsOAuth2Configuration) this.mConfig).getSlice() != null) {
            Logger.info(str + ":createAuthorizationRequestBuilder", "Setting slice params...");
            builder.setSlice(((MicrosoftStsOAuth2Configuration) this.mConfig).getSlice());
        }
        builder.setLibraryName(LibraryInfoHelper.getLibraryName());
        builder.setLibraryVersion(LibraryInfoHelper.getLibraryVersion());
        builder.setFlightParameters(((MicrosoftStsOAuth2Configuration) this.mConfig).getFlightParameters());
        builder.setMultipleCloudAware(((MicrosoftStsOAuth2Configuration) this.mConfig).getMultipleCloudsSupported());
        builder.setOpenIdProviderConfiguration(this.mOpenIdProviderConfiguration);
        return builder;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsAuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord iAccountRecord) {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":createAuthorizationRequestBuilder").toString(), "Creating AuthorizationRequestBuilder");
        MicrosoftStsAuthorizationRequest.Builder builderCreateAuthorizationRequestBuilder = createAuthorizationRequestBuilder();
        if (iAccountRecord != null) {
            Map.Entry<String, String> tenantInfo = StringUtil.getTenantInfo(iAccountRecord.getHomeAccountId());
            if (!StringUtil.isNullOrEmpty(tenantInfo.getKey()) && !StringUtil.isNullOrEmpty(tenantInfo.getValue())) {
                builderCreateAuthorizationRequestBuilder.setUid(tenantInfo.getKey());
                builderCreateAuthorizationRequestBuilder.setUtid(tenantInfo.getValue());
                Logger.infoPII(str + ":createAuthorizationRequestBuilder", "Builder w/ uid: [" + tenantInfo.getKey() + "]");
                Logger.infoPII(str + ":createAuthorizationRequestBuilder", "Builder w/ utid: [" + tenantInfo.getValue() + "]");
            }
        }
        return builderCreateAuthorizationRequestBuilder;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsTokenRequest createTokenRequest(MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest, MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse, AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException {
        if (microsoftStsAuthorizationRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (microsoftStsAuthorizationResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":createTokenRequest").toString(), "Creating TokenRequest...");
        if (((MicrosoftStsOAuth2Configuration) this.mConfig).getMultipleCloudsSupported() || microsoftStsAuthorizationRequest.getMultipleCloudAware().booleanValue()) {
            Logger.verbose(str, "get cloud specific authority based on authorization response.");
            setTokenEndpoint(getCloudSpecificTokenEndpoint(microsoftStsAuthorizationResponse));
        }
        MicrosoftStsTokenRequest microsoftStsTokenRequest = new MicrosoftStsTokenRequest();
        microsoftStsTokenRequest.setCodeVerifier(microsoftStsAuthorizationRequest.getPkceCodeVerifier());
        microsoftStsTokenRequest.setCode(microsoftStsAuthorizationResponse.getCode());
        microsoftStsTokenRequest.setRedirectUri(microsoftStsAuthorizationRequest.getRedirectUri());
        microsoftStsTokenRequest.setClientId(microsoftStsAuthorizationRequest.getClientId());
        microsoftStsTokenRequest.setScope(microsoftStsAuthorizationRequest.getTokenScope());
        microsoftStsTokenRequest.setClaims(microsoftStsAuthorizationRequest.getClaims());
        setTokenRequestCorrelationId(microsoftStsTokenRequest);
        if (microsoftStsAuthorizationResponse.getDeviceCode() != null) {
            microsoftStsTokenRequest.setGrantType(TokenRequest.GrantTypes.DEVICE_CODE);
            microsoftStsTokenRequest.setDeviceCode(microsoftStsAuthorizationResponse.getDeviceCode());
        } else {
            microsoftStsTokenRequest.setGrantType("authorization_code");
        }
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeInternal) {
            microsoftStsTokenRequest.setTokenType(TokenRequest.TokenType.POP);
            IDevicePopManager defaultDevicePopManager = this.mStrategyParameters.getPlatformComponents().getDefaultDevicePopManager();
            if (!defaultDevicePopManager.asymmetricKeyExists()) {
                Logger.verbosePII(str, "Generated new PoP asymmetric key with thumbprint: " + defaultDevicePopManager.generateAsymmetricKey());
            }
            microsoftStsTokenRequest.setRequestConfirmation(defaultDevicePopManager.getRequestConfirmation());
            return microsoftStsTokenRequest;
        }
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal) {
            microsoftStsTokenRequest.setTokenType(TokenRequest.TokenType.POP);
            microsoftStsTokenRequest.setRequestConfirmation(((PopAuthenticationSchemeWithClientKeyInternal) abstractAuthenticationScheme).getRequestConfirmation());
        }
        return microsoftStsTokenRequest;
    }

    private void setTokenRequestCorrelationId(MicrosoftStsTokenRequest microsoftStsTokenRequest) {
        if (microsoftStsTokenRequest == null) {
            throw new NullPointerException("tokenRequest is marked non-null but is null");
        }
        try {
            microsoftStsTokenRequest.setCorrelationId(UUID.fromString(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id")));
        } catch (IllegalArgumentException e) {
            Logger.error("MicrosoftSTSOAuth2Strategy", "Correlation id on diagnostic context is not a UUID.", e);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        Logger.verbose(TAG + ":createRefreshTokenRequest", "Creating refresh token request");
        MicrosoftStsTokenRequest microsoftStsTokenRequest = new MicrosoftStsTokenRequest();
        microsoftStsTokenRequest.setGrantType("refresh_token");
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeInternal) {
            microsoftStsTokenRequest.setTokenType(TokenRequest.TokenType.POP);
            IDevicePopManager defaultDevicePopManager = this.mStrategyParameters.getPlatformComponents().getDefaultDevicePopManager();
            if (!defaultDevicePopManager.asymmetricKeyExists()) {
                defaultDevicePopManager.generateAsymmetricKey();
            }
            microsoftStsTokenRequest.setRequestConfirmation(defaultDevicePopManager.getRequestConfirmation());
            return microsoftStsTokenRequest;
        }
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal) {
            microsoftStsTokenRequest.setTokenType(TokenRequest.TokenType.POP);
            microsoftStsTokenRequest.setRequestConfirmation(((PopAuthenticationSchemeWithClientKeyInternal) abstractAuthenticationScheme).getRequestConfirmation());
        }
        return microsoftStsTokenRequest;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public MicrosoftStsTokenRequest createRopcTokenRequest(RopcTokenCommandParameters ropcTokenCommandParameters) throws ClientException {
        if (ropcTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        Logger.verbose(TAG + ":createPasswordTokenRequest", "Creating password token request");
        MicrosoftStsRopcTokenRequest microsoftStsRopcTokenRequest = new MicrosoftStsRopcTokenRequest();
        microsoftStsRopcTokenRequest.setGrantType("password");
        microsoftStsRopcTokenRequest.setUsername(ropcTokenCommandParameters.getUsername());
        microsoftStsRopcTokenRequest.setPassword(ropcTokenCommandParameters.getPassword());
        microsoftStsRopcTokenRequest.setClaims(ropcTokenCommandParameters.getClaimsRequestJson());
        microsoftStsRopcTokenRequest.setClientId(ropcTokenCommandParameters.getClientId());
        microsoftStsRopcTokenRequest.setRedirectUri(ropcTokenCommandParameters.getRedirectUri());
        microsoftStsRopcTokenRequest.setScope(StringUtil.join(" ", ropcTokenCommandParameters.getScopes()));
        setTokenRequestCorrelationId(microsoftStsRopcTokenRequest);
        if (AuthenticationSchemeFactory.isPopAuthenticationScheme(ropcTokenCommandParameters.getAuthenticationScheme())) {
            throw new UnsupportedOperationException("MSAL Android supports ROPC on Bearer flows only for testing purposes.");
        }
        return microsoftStsRopcTokenRequest;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public HttpResponse performTokenRequest(MicrosoftStsTokenRequest microsoftStsTokenRequest) throws IOException, ClientException {
        HttpResponse httpResponsePerformTokenRequest = super.performTokenRequest(microsoftStsTokenRequest);
        if (httpResponsePerformTokenRequest.getStatusCode() != 401 || httpResponsePerformTokenRequest.getHeaders() == null || !httpResponsePerformTokenRequest.getHeaders().containsKey("WWW-Authenticate")) {
            return httpResponsePerformTokenRequest;
        }
        Logger.info(TAG + ":performTokenRequest", "Receiving device certificate challenge request. ");
        return performPKeyAuthRequest(httpResponsePerformTokenRequest, microsoftStsTokenRequest);
    }

    private HttpResponse performPKeyAuthRequest(HttpResponse httpResponse, MicrosoftStsTokenRequest microsoftStsTokenRequest) throws IOException, ClientException {
        if (httpResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        if (microsoftStsTokenRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(microsoftStsTokenRequest);
        TreeMap treeMap = new TreeMap();
        treeMap.put("client-request-id", DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        treeMap.putAll(Device.getPlatformIdParameters());
        treeMap.put("x-client-SKU", LibraryInfoHelper.getLibraryName());
        treeMap.put("x-client-Ver", LibraryInfoHelper.getLibraryVersion());
        treeMap.put("x-app-name", microsoftStsTokenRequest.getClientAppName());
        treeMap.put("x-app-ver", microsoftStsTokenRequest.getClientAppVersion());
        String str = httpResponse.getHeaders().get("WWW-Authenticate").get(0);
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        Logger.info(sb.append(str2).append("#performPkeyAuthRequest").toString(), "Device certificate challenge request. ");
        Logger.infoPII(str2 + "#performPkeyAuthRequest", "Challenge header: " + str);
        try {
            PKeyAuthChallengeFactory pKeyAuthChallengeFactory = new PKeyAuthChallengeFactory();
            URL url = new URL(this.mTokenEndpoint);
            treeMap.putAll(pKeyAuthChallengeFactory.getPKeyAuthChallengeFromTokenEndpointResponse(str, url.toString()).getChallengeHeader());
            treeMap.put("Content-Type", "application/x-www-form-urlencoded");
            return this.httpClient.post(url, treeMap, strSerializeObjectToFormUrlEncoded.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new ClientException("unsupported_encoding", "Unsupported encoding", e);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    protected TokenResult getTokenResultFromHttpResponse(HttpResponse httpResponse) throws ClientException {
        if (httpResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        return new MicrosoftStsTokenResponseHandler().handleTokenResponse(httpResponse);
    }

    protected String getBodyFromSuccessfulResponse(String str) throws ClientException {
        if (str != null) {
            return str;
        }
        throw new NullPointerException("responseBody is marked non-null but is null");
    }

    protected String getBodyFromUnsuccessfulResponse(String str) throws ClientException {
        if (str != null) {
            return str.isEmpty() ? "{}" : str;
        }
        throw new NullPointerException("responseBody is marked non-null but is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateTokenResponse(MicrosoftStsTokenRequest microsoftStsTokenRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) throws ClientException {
        if (microsoftStsTokenRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        validateAuthScheme(microsoftStsTokenRequest, microsoftStsTokenResponse);
        validateTokensAreInResponse(microsoftStsTokenRequest, microsoftStsTokenResponse);
    }

    private void validateAuthScheme(MicrosoftStsTokenRequest microsoftStsTokenRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) throws ClientException {
        if (microsoftStsTokenRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        String tokenType = microsoftStsTokenRequest.getTokenType();
        String tokenType2 = microsoftStsTokenResponse.getTokenType();
        if (tokenType != null && !tokenType.equalsIgnoreCase(tokenType2)) {
            throw new ClientException(ClientException.AUTH_SCHEME_MISMATCH, "Expected: [" + tokenType + "]\nActual: [" + tokenType2 + "]");
        }
    }

    private void validateTokensAreInResponse(MicrosoftStsTokenRequest microsoftStsTokenRequest, MicrosoftStsTokenResponse microsoftStsTokenResponse) throws ClientException {
        String str;
        if (microsoftStsTokenRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        boolean zContainsSubString = StringUtil.containsSubString(microsoftStsTokenRequest.getScope(), "urn:aad:tb:update:prt/.default");
        String str2 = ClientException.TOKENS_MISSING;
        String strConcat = "";
        if (zContainsSubString || !StringUtil.isNullOrEmpty(microsoftStsTokenResponse.getAccessToken())) {
            str = null;
        } else {
            strConcat = "".concat("access_token");
            str = ClientException.TOKENS_MISSING;
        }
        if (!TokenRequest.GrantTypes.CLIENT_CREDENTIALS.equalsIgnoreCase(microsoftStsTokenRequest.getGrantType()) && StringUtil.isNullOrEmpty(microsoftStsTokenResponse.getIdToken())) {
            strConcat = strConcat.concat(" id_token");
            str = ClientException.TOKENS_MISSING;
        }
        if (TokenRequest.GrantTypes.CLIENT_CREDENTIALS.equalsIgnoreCase(microsoftStsTokenRequest.getGrantType()) || !StringUtil.isNullOrEmpty(microsoftStsTokenResponse.getRefreshToken())) {
            str2 = str;
        } else {
            strConcat = strConcat.concat(" refresh_token");
        }
        if (str2 != null) {
            throw new ClientException(str2, String.format("Missing required tokens of type: %s", strConcat));
        }
    }

    private String buildCloudSpecificTokenEndpoint(MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse) throws ClientException {
        if (microsoftStsAuthorizationResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        if (!StringUtil.isNullOrEmpty(microsoftStsAuthorizationResponse.getCloudInstanceHostName())) {
            try {
                return new CommonURIBuilder(this.mTokenEndpoint).setHost(microsoftStsAuthorizationResponse.getCloudInstanceHostName()).build().toString();
            } catch (URISyntaxException e) {
                throw new ClientException("malformed_url", "Failed to construct token endpoint from getCloudInstanceHostName()", e);
            }
        }
        return this.mTokenEndpoint;
    }

    private String getCloudSpecificTokenEndpoint(MicrosoftAuthorizationResponse microsoftAuthorizationResponse) throws ClientException {
        if (StringUtil.isNullOrEmpty(microsoftAuthorizationResponse.getCloudInstanceHostName())) {
            return this.mTokenEndpoint;
        }
        return buildCloudSpecificTokenEndpoint((MicrosoftStsAuthorizationResponse) microsoftAuthorizationResponse);
    }

    public String getDeviceAtPopThumbprint() {
        IDevicePopManager defaultDevicePopManager;
        if (this.mStrategyParameters.getAuthenticationScheme() instanceof PopAuthenticationSchemeWithClientKeyInternal) {
            return ((PopAuthenticationSchemeWithClientKeyInternal) this.mStrategyParameters.getAuthenticationScheme()).getKid();
        }
        try {
            defaultDevicePopManager = this.mStrategyParameters.getPlatformComponents().getDefaultDevicePopManager();
        } catch (ClientException e) {
            Logger.error(TAG, e.getMessage(), e);
            defaultDevicePopManager = null;
        }
        if (defaultDevicePopManager != null) {
            if (defaultDevicePopManager.asymmetricKeyExists()) {
                try {
                    return defaultDevicePopManager.getAsymmetricKeyThumbprint();
                } catch (ClientException e2) {
                    Logger.error(TAG, "Key exists. But failed to load thumbprint.", e2);
                    throw new RuntimeException(e2);
                }
            }
            throw new RuntimeException("Symmetric keys do not exist.");
        }
        Logger.warn(TAG, "DevicePopManager does not exist.");
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public boolean validateCachedResult(AbstractAuthenticationScheme abstractAuthenticationScheme, ICacheRecord iCacheRecord) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        super.validateCachedResult(abstractAuthenticationScheme, iCacheRecord);
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeInternal) {
            return cachedAccessTokenKidMatchesKeystoreKid(iCacheRecord.getAccessToken().getKid());
        }
        if (abstractAuthenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal) {
            return ((PopAuthenticationSchemeWithClientKeyInternal) abstractAuthenticationScheme).getKid().equalsIgnoreCase(iCacheRecord.getAccessToken().getKid());
        }
        return true;
    }

    private boolean cachedAccessTokenKidMatchesKeystoreKid(String str) {
        String deviceAtPopThumbprint = getDeviceAtPopThumbprint();
        if (StringUtil.isNullOrEmpty(deviceAtPopThumbprint)) {
            return false;
        }
        return deviceAtPopThumbprint.equals(str);
    }

    private void loadOpenIdProviderConfiguration() throws ServiceException {
        this.mOpenIdProviderConfiguration = new OpenIdProviderConfigurationClient().loadOpenIdProviderConfigurationFromAuthority(((MicrosoftStsOAuth2Configuration) this.mConfig).getAuthorityUrl().toString());
    }

    private void loadOpenIdProviderConfiguration(String str) throws ServiceException {
        if (str == null) {
            throw new NullPointerException("extraParams is marked non-null but is null");
        }
        this.mOpenIdProviderConfiguration = new OpenIdProviderConfigurationClient().loadOpenIdProviderConfigurationFromAuthorityWithExtraParams(((MicrosoftStsOAuth2Configuration) this.mConfig).getAuthorityUrl().toString(), str);
    }
}
