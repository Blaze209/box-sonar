package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.LibraryInfoHelper;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenRequest;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.AccessToken;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.UiShownEvent;
import com.microsoft.identity.common.java.util.ClientExtraSku;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.IClockSkewManager;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes14.dex */
public abstract class OAuth2Strategy<GenericAccessToken extends AccessToken, GenericAccount extends BaseAccount, GenericAuthorizationRequest extends AuthorizationRequest, GenericAuthorizationRequestBuilder extends AuthorizationRequest.Builder, GenericAuthorizationStrategy extends IAuthorizationStrategy, GenericOAuth2Configuration extends OAuth2Configuration, GenericOAuth2StrategyParameters extends OAuth2StrategyParameters, GenericAuthorizationResponse extends AuthorizationResponse, GenericRefreshToken extends RefreshToken, GenericTokenRequest extends TokenRequest, GenericTokenResponse extends TokenResponse, GenericTokenResult extends TokenResult, GenericAuthorizationResult extends AuthorizationResult> {
    protected static final String DEVICE_CODE_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String TAG = "OAuth2Strategy";
    protected static final String TOKEN_REQUEST_CONTENT_TYPE = "application/x-www-form-urlencoded";
    protected final HttpClient httpClient = UrlConnectionHttpClient.getDefaultInstance();
    protected String mAuthorizationEndpoint;
    protected final IClockSkewManager mClockSkewManager;
    protected final GenericOAuth2Configuration mConfig;
    private URI mIssuer;
    protected final GenericOAuth2StrategyParameters mStrategyParameters;
    protected String mTokenEndpoint;

    public abstract GenericAccount createAccount(GenericTokenResponse generictokenresponse);

    public abstract GenericAuthorizationRequestBuilder createAuthorizationRequestBuilder();

    public abstract GenericAuthorizationRequestBuilder createAuthorizationRequestBuilder(IAccountRecord iAccountRecord);

    public abstract GenericTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException;

    public abstract GenericTokenRequest createRopcTokenRequest(RopcTokenCommandParameters ropcTokenCommandParameters) throws ClientException;

    public abstract GenericTokenRequest createTokenRequest(GenericAuthorizationRequest genericauthorizationrequest, GenericAuthorizationResponse genericauthorizationresponse, AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException;

    public abstract GenericAccessToken getAccessTokenFromResponse(GenericTokenResponse generictokenresponse);

    public abstract AuthorizationResultFactory getAuthorizationResultFactory();

    public abstract String getIssuerCacheIdentifier(GenericAuthorizationRequest genericauthorizationrequest) throws ClientException;

    public abstract GenericRefreshToken getRefreshTokenFromResponse(GenericTokenResponse generictokenresponse);

    protected abstract GenericTokenResult getTokenResultFromHttpResponse(HttpResponse httpResponse) throws ClientException;

    protected abstract void validateAuthorizationRequest(GenericAuthorizationRequest genericauthorizationrequest);

    protected abstract void validateTokenRequest(GenericTokenRequest generictokenrequest);

    protected abstract void validateTokenResponse(GenericTokenRequest generictokenrequest, GenericTokenResponse generictokenresponse) throws ClientException;

    public OAuth2Strategy(GenericOAuth2Configuration genericoauth2configuration, GenericOAuth2StrategyParameters genericoauth2strategyparameters) {
        this.mConfig = genericoauth2configuration;
        this.mStrategyParameters = genericoauth2strategyparameters;
        if (genericoauth2strategyparameters.getPlatformComponents() != null) {
            this.mClockSkewManager = genericoauth2strategyparameters.getPlatformComponents().getClockSkewManager();
        } else {
            Logger.info(TAG, "No valid platform component to initialize ClockSkewManager with!");
            this.mClockSkewManager = null;
        }
    }

    public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest genericauthorizationrequest, GenericAuthorizationStrategy genericauthorizationstrategy) throws ClientException {
        validateAuthorizationRequest(genericauthorizationrequest);
        Future<AuthorizationResult> futureRequestAuthorization = genericauthorizationstrategy.requestAuthorization(genericauthorizationrequest, this);
        Telemetry.emit(new UiShownEvent().putVisible(TelemetryEventStrings.Value.TRUE));
        return futureRequestAuthorization;
    }

    public GenericTokenResult requestToken(GenericTokenRequest generictokenrequest) throws IOException, ClientException {
        return (GenericTokenResult) requestToken(generictokenrequest, new ITokenResponseHandler() { // from class: com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy$$ExternalSyntheticLambda0
            @Override // com.microsoft.identity.common.java.providers.oauth2.ITokenResponseHandler
            public final TokenResult handleTokenResponse(HttpResponse httpResponse) {
                return this.f$0.getTokenResultFromHttpResponse(httpResponse);
            }
        });
    }

    public GenericTokenResult requestToken(GenericTokenRequest generictokenrequest, ITokenResponseHandler<GenericTokenResult> iTokenResponseHandler) throws IOException, ClientException {
        if (generictokenrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (iTokenResponseHandler == null) {
            throw new NullPointerException("tokenResponseHandler is marked non-null but is null");
        }
        Logger.verbose(TAG + ":requestToken", "Requesting token...");
        validateTokenRequest(generictokenrequest);
        GenericTokenResult generictokenresult = (GenericTokenResult) iTokenResponseHandler.handleTokenResponse(performTokenRequest(generictokenrequest));
        if (generictokenresult.getTokenResponse() != null) {
            generictokenresult.getTokenResponse().setAuthority(this.mTokenEndpoint);
        }
        if (generictokenresult.getSuccess()) {
            validateTokenResponse(generictokenrequest, generictokenresult);
        }
        return generictokenresult;
    }

    private void validateTokenResponse(GenericTokenRequest generictokenrequest, GenericTokenResult generictokenresult) throws ClientException {
        validateTokenResponse(generictokenrequest, generictokenresult.getSuccessResponse());
    }

    protected HttpResponse performTokenRequest(GenericTokenRequest generictokenrequest) throws IOException, ClientException {
        Logger.verbose(TAG + ":performTokenRequest", "Performing token request...");
        String requestBody = getRequestBody(generictokenrequest);
        TreeMap treeMap = new TreeMap();
        treeMap.put("client-request-id", DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        String libraryName = LibraryInfoHelper.getLibraryName();
        String libraryVersion = LibraryInfoHelper.getLibraryVersion();
        boolean z = generictokenrequest instanceof MicrosoftTokenRequest;
        if (z) {
            MicrosoftTokenRequest microsoftTokenRequest = (MicrosoftTokenRequest) generictokenrequest;
            if (!StringUtil.isNullOrEmpty(microsoftTokenRequest.getBrokerVersion())) {
                treeMap.put("x-client-brkrver", microsoftTokenRequest.getBrokerVersion());
                treeMap.put(AuthenticationConstants.SdkPlatformFields.CLIENT_EXTRA_SKU, ClientExtraSku.builder().srcSku(libraryName).srcSkuVer(libraryVersion).build().toString());
            }
        }
        treeMap.putAll(Device.getPlatformIdParameters());
        treeMap.put("x-client-SKU", libraryName);
        treeMap.put("x-client-Ver", libraryVersion);
        treeMap.putAll(EstsTelemetry.getInstance().getTelemetryHeaders());
        treeMap.put("Content-Type", "application/x-www-form-urlencoded");
        if (z) {
            MicrosoftTokenRequest microsoftTokenRequest2 = (MicrosoftTokenRequest) generictokenrequest;
            treeMap.put("x-app-name", microsoftTokenRequest2.getClientAppName());
            treeMap.put("x-app-ver", microsoftTokenRequest2.getClientAppVersion());
            if (microsoftTokenRequest2.isPKeyAuthHeaderAllowed()) {
                treeMap.put("x-ms-PKeyAuth", "1.0");
            }
        }
        URL url = new URL(getTokenEndpoint());
        long jCurrentTimeMillis = System.currentTimeMillis();
        HttpResponse httpResponsePost = this.httpClient.post(url, treeMap, requestBody.getBytes("UTF-8"));
        SpanExtension.current().setAttribute(AttributeName.elapsed_time_network_acquire_at.name(), System.currentTimeMillis() - jCurrentTimeMillis);
        if (httpResponsePost.getDate() != null) {
            recordClockSkew(httpResponsePost.getDate().getTime());
        }
        return httpResponsePost;
    }

    protected String getTokenEndpoint() {
        return this.mTokenEndpoint;
    }

    protected String getRequestBody(GenericTokenRequest generictokenrequest) throws UnsupportedEncodingException, ClientException {
        return ObjectMapper.serializeObjectToFormUrlEncoded(generictokenrequest);
    }

    private void recordClockSkew(long j) {
        IClockSkewManager iClockSkewManager = this.mClockSkewManager;
        if (iClockSkewManager != null) {
            iClockSkewManager.onTimestampReceived(j);
        }
    }

    protected final void setTokenEndpoint(String str) throws ClientException {
        AzureActiveDirectorySlice slice;
        this.mTokenEndpoint = str;
        GenericOAuth2Configuration genericoauth2configuration = this.mConfig;
        if (genericoauth2configuration == null || !(genericoauth2configuration instanceof MicrosoftStsOAuth2Configuration) || (slice = ((MicrosoftStsOAuth2Configuration) genericoauth2configuration).getSlice()) == null) {
            return;
        }
        try {
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder(this.mTokenEndpoint);
            if (!StringUtil.isNullOrEmpty(slice.getSlice())) {
                commonURIBuilder.setParameter(AzureActiveDirectorySlice.SLICE_PARAMETER, slice.getSlice());
            }
            if (!StringUtil.isNullOrEmpty(slice.getDataCenter())) {
                commonURIBuilder.setParameter("dc", slice.getDataCenter());
            }
            this.mTokenEndpoint = commonURIBuilder.build().toString();
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    public String getAuthorityFromTokenEndpoint() {
        return this.mTokenEndpoint.toLowerCase(Locale.ROOT).replace("oauth2/v2.0/token", "");
    }

    protected final void setAuthorizationEndpoint(String str) {
        this.mAuthorizationEndpoint = str;
    }

    public AuthorizationResult getDeviceCode(MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) throws IOException, ClientException {
        if (microsoftStsAuthorizationRequest == null) {
            throw new NullPointerException("authorizationRequest is marked non-null but is null");
        }
        String strSerializeObjectToFormUrlEncoded = ObjectMapper.serializeObjectToFormUrlEncoded(microsoftStsAuthorizationRequest);
        TreeMap treeMap = new TreeMap();
        treeMap.put("client-request-id", DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        treeMap.putAll(EstsTelemetry.getInstance().getTelemetryHeaders());
        treeMap.put("Content-Type", "application/x-www-form-urlencoded");
        HttpResponse httpResponsePost = this.httpClient.post(((MicrosoftStsOAuth2Configuration) this.mConfig).getDeviceAuthorizationEndpoint(), treeMap, strSerializeObjectToFormUrlEncoded.getBytes("UTF-8"));
        if (httpResponsePost.getStatusCode() < 300) {
            MicrosoftStsAuthorizationResult microsoftStsAuthorizationResult = new MicrosoftStsAuthorizationResult(AuthorizationStatus.SUCCESS, new MicrosoftStsAuthorizationResponse(null, microsoftStsAuthorizationRequest.getState(), (HashMap) new Gson().fromJson(httpResponsePost.getBody(), TypeToken.getParameterized(HashMap.class, String.class, String.class).getType())));
            Logger.verbose(TAG + ":getDeviceCode", "Device Code Flow authorization successful...");
            return microsoftStsAuthorizationResult;
        }
        HashMap map = (HashMap) new Gson().fromJson(httpResponsePost.getBody(), TypeToken.getParameterized(HashMap.class, String.class, Object.class).getType());
        MicrosoftStsAuthorizationResult microsoftStsAuthorizationResult2 = new MicrosoftStsAuthorizationResult(AuthorizationStatus.FAIL, new MicrosoftStsAuthorizationErrorResponse((String) map.get("error"), (String) map.get("error_description")));
        Logger.verbose(TAG + ":getDeviceCode", "Device Code Flow authorization failure...");
        return microsoftStsAuthorizationResult2;
    }

    protected GenericOAuth2Configuration getOAuth2Configuration() {
        return this.mConfig;
    }

    protected URI getIssuer() {
        return this.mIssuer;
    }

    protected final void setIssuer(URI uri) {
        this.mIssuer = uri;
    }

    public boolean validateCachedResult(AbstractAuthenticationScheme abstractAuthenticationScheme, ICacheRecord iCacheRecord) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        if (iCacheRecord != null) {
            return true;
        }
        throw new NullPointerException("cacheRecord is marked non-null but is null");
    }
}
