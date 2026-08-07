package com.microsoft.identity.common.java.controllers;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.ITokenAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MicrosoftStsAccountCredentialAdapter;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.constants.OAuth2SubErrorCode;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.foci.FociQueryUtilities;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IResult;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.CliTelemInfo;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.events.CacheEndEvent;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.ResultUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BaseController {
    private static final String TAG = "BaseController";

    public abstract AcquireTokenResult acquireDeviceCodeFlowToken(AuthorizationResult authorizationResult, DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws Exception;

    public abstract AcquireTokenResult acquireToken(InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws Exception;

    public abstract AcquireTokenResult acquireTokenSilent(SilentTokenCommandParameters silentTokenCommandParameters) throws Exception;

    public abstract AuthorizationResult deviceCodeFlowAuthRequest(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws Exception;

    public abstract GenerateShrResult generateSignedHttpRequest(GenerateShrCommandParameters generateShrCommandParameters) throws Exception;

    public abstract List<ICacheRecord> getAccounts(CommandParameters commandParameters) throws Exception;

    public abstract List<ICacheRecord> getCurrentAccount(CommandParameters commandParameters) throws Exception;

    public abstract boolean getDeviceMode(CommandParameters commandParameters) throws Exception;

    public abstract PreferredAuthMethod getPreferredAuthMethod() throws Exception;

    public int hashCode() {
        return 1;
    }

    public abstract void onFinishAuthorizationSession(int i, int i2, PropertyBag propertyBag);

    public abstract boolean removeAccount(RemoveAccountCommandParameters removeAccountCommandParameters) throws Exception;

    public abstract boolean removeCurrentAccount(RemoveAccountCommandParameters removeAccountCommandParameters) throws Exception;

    protected boolean canEqual(Object obj) {
        return obj instanceof BaseController;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BaseController) && ((BaseController) obj).canEqual(this);
    }

    public static String getDelimitedDefaultScopeString() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = AuthenticationConstants.DEFAULT_SCOPES.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public AcquireTokenResult acquireTokenWithPassword(RopcTokenCommandParameters ropcTokenCommandParameters) throws Exception {
        if (ropcTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":acquireToken").toString(), "Acquiring token...");
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        ropcTokenCommandParameters.validate();
        RopcTokenCommandParameters ropcTokenCommandParametersBuild = ((RopcTokenCommandParameters.RopcTokenCommandParametersBuilder) ropcTokenCommandParameters.toBuilder().scopes(addDefaultScopes(ropcTokenCommandParameters))).build();
        logParameters(str, ropcTokenCommandParametersBuild);
        ropcTokenCommandParametersBuild.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(ropcTokenCommandParametersBuild.isPowerOptCheckEnabled());
        Authority.KnownAuthorityResult knownAuthorityResult = Authority.getKnownAuthorityResult(ropcTokenCommandParametersBuild.getAuthority());
        if (!knownAuthorityResult.getKnown()) {
            Logger.error(str + ":acquireToken", "Authority is not known.", knownAuthorityResult.getClientException());
            throw knownAuthorityResult.getClientException();
        }
        OAuth2Strategy oAuth2StrategyCreateOAuth2Strategy = ropcTokenCommandParametersBuild.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(ropcTokenCommandParameters.getPlatformComponents()).authenticationScheme(ropcTokenCommandParameters.getAuthenticationScheme()).build());
        TokenResult tokenResultRequestToken = oAuth2StrategyCreateOAuth2Strategy.requestToken(oAuth2StrategyCreateOAuth2Strategy.createRopcTokenRequest(ropcTokenCommandParametersBuild));
        acquireTokenResult.setTokenResult(tokenResultRequestToken);
        OAuth2TokenCache oAuth2TokenCache = ropcTokenCommandParameters.getOAuth2TokenCache();
        if (tokenResultRequestToken != null && tokenResultRequestToken.getSuccess()) {
            List<ICacheRecord> listSaveAndLoadAggregatedAccountData = oAuth2TokenCache.saveAndLoadAggregatedAccountData(oAuth2StrategyCreateOAuth2Strategy, getAuthorizationRequest(oAuth2StrategyCreateOAuth2Strategy, ropcTokenCommandParameters), tokenResultRequestToken.getTokenResponse());
            LocalAuthenticationResult localAuthenticationResult = new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveAndLoadAggregatedAccountData.get(0), ropcTokenCommandParameters.getAuthenticationScheme()), listSaveAndLoadAggregatedAccountData, ropcTokenCommandParameters.getSdkType(), false);
            if (tokenResultRequestToken.getCliTelemInfo() != null) {
                CliTelemInfo cliTelemInfo = tokenResultRequestToken.getCliTelemInfo();
                localAuthenticationResult.setSpeRing(cliTelemInfo.getSpeRing());
                localAuthenticationResult.setRefreshTokenAge(cliTelemInfo.getRefreshTokenAge());
                Telemetry.emit(new CacheEndEvent().putSpeInfo(tokenResultRequestToken.getCliTelemInfo().getSpeRing()));
            } else {
                Telemetry.emit(new CacheEndEvent());
            }
            acquireTokenResult.setLocalAuthenticationResult(localAuthenticationResult);
        }
        return acquireTokenResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final AuthorizationRequest.Builder initializeAuthorizationRequestBuilder(AuthorizationRequest.Builder builder, TokenCommandParameters tokenCommandParameters) {
        UUID uuidFromString;
        if (builder == null) {
            throw new NullPointerException("builder is marked non-null but is null");
        }
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        try {
            uuidFromString = UUID.fromString(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        } catch (IllegalArgumentException e) {
            Logger.error(TAG, "correlation id from diagnostic context is not a UUID", e);
            uuidFromString = null;
        }
        if (tokenCommandParameters.hasNestedAppParameters()) {
            builder.setBrkRedirectUri(tokenCommandParameters.getRedirectUri()).setBrkClientId(tokenCommandParameters.getClientId()).setClientId(tokenCommandParameters.getChildClientId()).setRedirectUri(tokenCommandParameters.getChildRedirectUri());
        } else {
            builder.setClientId(tokenCommandParameters.getClientId()).setRedirectUri(tokenCommandParameters.getRedirectUri());
        }
        boolean z = builder instanceof MicrosoftAuthorizationRequest.Builder;
        if (z) {
            ((MicrosoftAuthorizationRequest.Builder) builder).setCorrelationId(uuidFromString);
        }
        boolean z2 = builder instanceof MicrosoftStsAuthorizationRequest.Builder;
        if (z2) {
            ((MicrosoftStsAuthorizationRequest.Builder) builder).setApplicationIdentifier(tokenCommandParameters.getApplicationIdentifier());
        }
        Set<String> scopes = tokenCommandParameters.getScopes();
        if (tokenCommandParameters instanceof InteractiveTokenCommandParameters) {
            InteractiveTokenCommandParameters interactiveTokenCommandParameters = (InteractiveTokenCommandParameters) tokenCommandParameters;
            if (z) {
                MicrosoftStsAuthorizationRequest.Builder builder2 = (MicrosoftStsAuthorizationRequest.Builder) builder;
                builder2.setTokenScope(StringUtil.join(" ", tokenCommandParameters.getScopes()));
                if (interactiveTokenCommandParameters.getAuthority() instanceof AzureActiveDirectoryAuthority) {
                    AzureActiveDirectoryAuthority azureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority) interactiveTokenCommandParameters.getAuthority();
                    ((MicrosoftStsAuthorizationRequest.Builder) builder2.setAuthority(azureActiveDirectoryAuthority.getAuthorityURL()).setMultipleCloudAware(azureActiveDirectoryAuthority.isMultipleCloudsSupported()).setState(interactiveTokenCommandParameters.getPlatformComponents().getStateGenerator().generate())).setSlice(azureActiveDirectoryAuthority.mSlice).setApplicationIdentifier(tokenCommandParameters.getApplicationIdentifier());
                }
            }
            if (interactiveTokenCommandParameters.getExtraScopesToConsent() != null) {
                scopes.addAll(interactiveTokenCommandParameters.getExtraScopesToConsent());
            }
            HashMap<String, String> map = new HashMap<>();
            if (interactiveTokenCommandParameters.getRequestHeaders() != null) {
                map.putAll(interactiveTokenCommandParameters.getRequestHeaders());
            }
            map.put("x-app-name", tokenCommandParameters.getApplicationName());
            map.put("x-app-ver", tokenCommandParameters.getApplicationVersion());
            map.put("x-ms-PKeyAuth", "1.0");
            setBuilderProperties(builder, tokenCommandParameters, interactiveTokenCommandParameters, map);
            if (!StringUtil.isNullOrEmpty(interactiveTokenCommandParameters.getLoginHint()) && interactiveTokenCommandParameters.getPrompt() == OpenIdConnectPromptParameter.SELECT_ACCOUNT && z2) {
                ((MicrosoftStsAuthorizationRequest.Builder) builder).setPrompt(null);
            }
        }
        builder.setScope(StringUtil.join(" ", scopes));
        return builder;
    }

    private void setBuilderProperties(AuthorizationRequest.Builder builder, TokenCommandParameters tokenCommandParameters, InteractiveTokenCommandParameters interactiveTokenCommandParameters, HashMap<String, String> map) {
        if (builder == null) {
            throw new NullPointerException("builder is marked non-null but is null");
        }
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        builder.setExtraQueryParams(interactiveTokenCommandParameters.getExtraQueryStringParameters()).setClaims(tokenCommandParameters.getClaimsRequestJson()).setRequestHeaders(map).setWebViewZoomEnabled(interactiveTokenCommandParameters.isWebViewZoomEnabled()).setWebViewZoomControlsEnabled(interactiveTokenCommandParameters.isWebViewZoomControlsEnabled());
        if (builder instanceof MicrosoftStsAuthorizationRequest.Builder) {
            MicrosoftStsAuthorizationRequest.Builder builder2 = (MicrosoftStsAuthorizationRequest.Builder) builder;
            builder2.setLoginHint(interactiveTokenCommandParameters.getLoginHint()).setDomainHint(interactiveTokenCommandParameters.getDomainHint()).setPrompt(interactiveTokenCommandParameters.getPrompt().toString()).setPreferredAuthMethod(interactiveTokenCommandParameters.getPreferredAuthMethod());
            String installedCompanyPortalVersion = tokenCommandParameters.getPlatformComponents().getPlatformUtil().getInstalledCompanyPortalVersion();
            if (StringUtil.isNullOrEmpty(installedCompanyPortalVersion)) {
                return;
            }
            builder2.setInstalledCompanyPortalVersion(installedCompanyPortalVersion);
        }
    }

    protected AuthorizationRequest getAuthorizationRequest(OAuth2Strategy oAuth2Strategy, TokenCommandParameters tokenCommandParameters) {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (tokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        AuthorizationRequest.Builder builderCreateAuthorizationRequestBuilder = oAuth2Strategy.createAuthorizationRequestBuilder(tokenCommandParameters.getAccount());
        initializeAuthorizationRequestBuilder(builderCreateAuthorizationRequestBuilder, tokenCommandParameters);
        return builderCreateAuthorizationRequestBuilder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected TokenResult performTokenRequest(OAuth2Strategy oAuth2Strategy, AuthorizationRequest authorizationRequest, AuthorizationResponse authorizationResponse, InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws IOException, ClientException {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (authorizationRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (authorizationResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        if (interactiveTokenCommandParameters == 0) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        interactiveTokenCommandParameters.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(interactiveTokenCommandParameters.isPowerOptCheckEnabled());
        TokenRequest tokenRequestCreateTokenRequest = oAuth2Strategy.createTokenRequest(authorizationRequest, authorizationResponse, interactiveTokenCommandParameters.getAuthenticationScheme());
        if (tokenRequestCreateTokenRequest instanceof MicrosoftTokenRequest) {
            MicrosoftTokenRequest microsoftTokenRequest = (MicrosoftTokenRequest) tokenRequestCreateTokenRequest;
            microsoftTokenRequest.setClientAppName(interactiveTokenCommandParameters.getApplicationName());
            microsoftTokenRequest.setClientAppVersion(interactiveTokenCommandParameters.getApplicationVersion());
        }
        if (interactiveTokenCommandParameters instanceof IHasExtraParameters) {
            tokenRequestCreateTokenRequest.setExtraParameters(((IHasExtraParameters) interactiveTokenCommandParameters).getExtraParameters());
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        ResultUtil.logExposedFieldsOfObject(sb.append(str).append(":performTokenRequest").toString(), tokenRequestCreateTokenRequest);
        TokenResult tokenResultRequestToken = oAuth2Strategy.requestToken(tokenRequestCreateTokenRequest);
        ResultUtil.logResult(str, tokenResultRequestToken);
        return tokenResultRequestToken;
    }

    protected TokenResult performTokenRequest(OAuth2Strategy oAuth2Strategy, AuthorizationRequest authorizationRequest, AuthorizationResponse authorizationResponse, DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws ServiceException, IOException, ClientException {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (authorizationRequest == null) {
            throw new NullPointerException("authorizationRequest is marked non-null but is null");
        }
        if (authorizationResponse == null) {
            throw new NullPointerException("authorizationResponse is marked non-null but is null");
        }
        if (deviceCodeFlowCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String string = sb.append(str).append(":performTokenRequest").toString();
        deviceCodeFlowCommandParameters.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(deviceCodeFlowCommandParameters.isPowerOptCheckEnabled());
        TokenRequest tokenRequestCreateTokenRequest = oAuth2Strategy.createTokenRequest(authorizationRequest, authorizationResponse, deviceCodeFlowCommandParameters.getAuthenticationScheme());
        ResultUtil.logExposedFieldsOfObject(string, tokenRequestCreateTokenRequest);
        TokenResult tokenResultRequestToken = oAuth2Strategy.requestToken(tokenRequestCreateTokenRequest);
        validateDeviceCodeFlowServiceResult(tokenResultRequestToken);
        ResultUtil.logResult(str, tokenResultRequestToken);
        return tokenResultRequestToken;
    }

    protected void renewAccessToken(SilentTokenCommandParameters silentTokenCommandParameters, AcquireTokenResult acquireTokenResult, OAuth2TokenCache oAuth2TokenCache, OAuth2Strategy oAuth2Strategy, ICacheRecord iCacheRecord) throws ServiceException, IOException, ClientException {
        List<ICacheRecord> listSaveAndLoadAggregatedAccountData;
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (acquireTokenResult == null) {
            throw new NullPointerException("acquireTokenSilentResult is marked non-null but is null");
        }
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("tokenCache is marked non-null but is null");
        }
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        String str = TAG + ":renewAccessToken";
        Logger.info(str, "Renewing access token...");
        RefreshTokenRecord refreshToken = iCacheRecord.getRefreshToken();
        logParameters(str, silentTokenCommandParameters);
        TokenResult tokenResultPerformSilentTokenRequest = performSilentTokenRequest(oAuth2Strategy, refreshToken, silentTokenCommandParameters);
        acquireTokenResult.setTokenResult(tokenResultPerformSilentTokenRequest);
        ResultUtil.logResult(str, tokenResultPerformSilentTokenRequest);
        if (tokenResultPerformSilentTokenRequest.getSuccess()) {
            Logger.info(str, "Token request was successful");
            if (silentTokenCommandParameters.hasNestedAppParameters()) {
                listSaveAndLoadAggregatedAccountData = getAcquireTokenResultRecords((MicrosoftStsTokenResponse) tokenResultPerformSilentTokenRequest.getTokenResponse(), (MicrosoftStsOAuth2Strategy) oAuth2Strategy, (MicrosoftStsAuthorizationRequest) getAuthorizationRequest(oAuth2Strategy, silentTokenCommandParameters));
            } else {
                listSaveAndLoadAggregatedAccountData = oAuth2TokenCache.saveAndLoadAggregatedAccountData(oAuth2Strategy, getAuthorizationRequest(oAuth2Strategy, silentTokenCommandParameters), tokenResultPerformSilentTokenRequest.getTokenResponse());
            }
            LocalAuthenticationResult localAuthenticationResult = new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveAndLoadAggregatedAccountData.get(0), silentTokenCommandParameters.getAuthenticationScheme()), listSaveAndLoadAggregatedAccountData, silentTokenCommandParameters.getSdkType(), false);
            if (tokenResultPerformSilentTokenRequest.getCliTelemInfo() != null) {
                CliTelemInfo cliTelemInfo = tokenResultPerformSilentTokenRequest.getCliTelemInfo();
                localAuthenticationResult.setSpeRing(cliTelemInfo.getSpeRing());
                localAuthenticationResult.setRefreshTokenAge(cliTelemInfo.getRefreshTokenAge());
                Telemetry.emit(new CacheEndEvent().putSpeInfo(tokenResultPerformSilentTokenRequest.getCliTelemInfo().getSpeRing()));
            } else {
                Telemetry.emit(new CacheEndEvent());
            }
            acquireTokenResult.setLocalAuthenticationResult(localAuthenticationResult);
            return;
        }
        if (tokenResultPerformSilentTokenRequest.getErrorResponse() != null) {
            String error = tokenResultPerformSilentTokenRequest.getErrorResponse().getError();
            String subError = tokenResultPerformSilentTokenRequest.getErrorResponse().getSubError();
            Logger.info(str, "Error: " + error + " Suberror: " + subError);
            if ("invalid_grant".equals(error) && OAuth2SubErrorCode.BAD_TOKEN.equals(subError)) {
                Logger.info(str, "Refresh token is invalid, attempting to delete the RT from cache, result:" + oAuth2TokenCache.removeCredential(iCacheRecord.getRefreshToken()));
            }
            if ("service_not_available".equals(error)) {
                throw new ServiceException("service_not_available", "AAD is not available.", tokenResultPerformSilentTokenRequest.getErrorResponse().getStatusCode(), null);
            }
            return;
        }
        Logger.warn(str, "Invalid state, No token success or error response on the token result");
    }

    public TokenResult renewAccessToken(SilentTokenCommandParameters silentTokenCommandParameters) throws ServiceException, IOException, ClientException {
        List<ICacheRecord> acquireTokenResultRecords;
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String string = sb.append(str).append(":renewAccessToken").toString();
        Logger.info(string, "Renewing access token...");
        OAuth2Strategy strategy = getStrategy(silentTokenCommandParameters);
        OAuth2TokenCache tokenCache = getTokenCache(silentTokenCommandParameters);
        ICacheRecord cacheRecord = getCacheRecord(silentTokenCommandParameters);
        Logger.info(string, "Attempting renewal of Access Token because it's refresh-expired. RefreshIn was expired at " + cacheRecord.getAccessToken().getRefreshOn() + ". Regular expiry is at " + cacheRecord.getAccessToken().getExpiresOn() + ".Currently executing acquireTokenSilent(..), SilentTokenCommand with CorrelationId: " + silentTokenCommandParameters.getCorrelationId());
        RefreshTokenRecord refreshToken = cacheRecord.getRefreshToken();
        logParameters(str, silentTokenCommandParameters);
        TokenResult tokenResultPerformSilentTokenRequest = performSilentTokenRequest(strategy, refreshToken, silentTokenCommandParameters);
        logResult(string, tokenResultPerformSilentTokenRequest);
        if (tokenResultPerformSilentTokenRequest.getSuccess()) {
            Logger.info(string, "Token request was successful");
            if (!silentTokenCommandParameters.hasNestedAppParameters()) {
                Logger.info(string, "Access token is refresh-expired. Removing from cache...");
                tokenCache.removeCredential(cacheRecord.getAccessToken());
                acquireTokenResultRecords = tokenCache.saveAndLoadAggregatedAccountData(strategy, getAuthorizationRequest(strategy, silentTokenCommandParameters), tokenResultPerformSilentTokenRequest.getTokenResponse());
            } else {
                acquireTokenResultRecords = getAcquireTokenResultRecords((MicrosoftStsTokenResponse) tokenResultPerformSilentTokenRequest.getTokenResponse(), (MicrosoftStsOAuth2Strategy) strategy, (MicrosoftStsAuthorizationRequest) getAuthorizationRequest(strategy, silentTokenCommandParameters));
            }
            finalizeCacheRecordForResult(acquireTokenResultRecords.get(0), silentTokenCommandParameters.getAuthenticationScheme());
            if (tokenResultPerformSilentTokenRequest.getCliTelemInfo() != null) {
                Telemetry.emit(new CacheEndEvent().putSpeInfo(tokenResultPerformSilentTokenRequest.getCliTelemInfo().getSpeRing()));
                return tokenResultPerformSilentTokenRequest;
            }
            Telemetry.emit(new CacheEndEvent());
            return tokenResultPerformSilentTokenRequest;
        }
        if (tokenResultPerformSilentTokenRequest.getErrorResponse() != null) {
            String error = tokenResultPerformSilentTokenRequest.getErrorResponse().getError();
            String subError = tokenResultPerformSilentTokenRequest.getErrorResponse().getSubError();
            Logger.warn(string, "Error: " + error + " Suberror: " + subError);
            if ("invalid_grant".equals(error) && OAuth2SubErrorCode.BAD_TOKEN.equals(subError)) {
                Logger.info(string, "Refresh token is invalid, attempting to delete the RT from cache, result:" + tokenCache.removeCredential(cacheRecord.getRefreshToken()));
            }
            if ("service_not_available".equals(error)) {
                throw new ServiceException("service_not_available", "AAD is not available.", tokenResultPerformSilentTokenRequest.getErrorResponse().getStatusCode(), null);
            }
            return tokenResultPerformSilentTokenRequest;
        }
        Logger.warn(string, "Invalid state, No token success or error response on the token result");
        return tokenResultPerformSilentTokenRequest;
    }

    private List<ICacheRecord> getAcquireTokenResultRecords(MicrosoftStsTokenResponse microsoftStsTokenResponse, MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) {
        if (microsoftStsTokenResponse == null) {
            throw new NullPointerException("microsoftStsTokenResponse is marked non-null but is null");
        }
        if (microsoftStsOAuth2Strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (microsoftStsAuthorizationRequest == null) {
            throw new NullPointerException("authorizationRequest is marked non-null but is null");
        }
        MicrosoftStsAccountCredentialAdapter microsoftStsAccountCredentialAdapter = new MicrosoftStsAccountCredentialAdapter();
        CacheRecord cacheRecordBuild = CacheRecord.builder().idToken(microsoftStsAccountCredentialAdapter.createIdToken(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, microsoftStsTokenResponse)).accessToken(microsoftStsAccountCredentialAdapter.createAccessToken(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, microsoftStsTokenResponse)).account(microsoftStsAccountCredentialAdapter.createAccount(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, microsoftStsTokenResponse)).refreshToken(microsoftStsAccountCredentialAdapter.createRefreshToken(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, microsoftStsTokenResponse)).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(cacheRecordBuild);
        return arrayList;
    }

    public OAuth2Strategy getStrategy(SilentTokenCommandParameters silentTokenCommandParameters) throws ClientException {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        return silentTokenCommandParameters.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(silentTokenCommandParameters.getPlatformComponents()).authenticationScheme(silentTokenCommandParameters.getAuthenticationScheme()).build());
    }

    public ICacheRecord getCacheRecord(SilentTokenCommandParameters silentTokenCommandParameters) throws ClientException {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        return silentTokenCommandParameters.getOAuth2TokenCache().loadWithAggregatedAccountData(silentTokenCommandParameters.getClientId(), silentTokenCommandParameters.getApplicationIdentifier(), silentTokenCommandParameters.getMamEnrollmentId(), StringUtil.join(" ", silentTokenCommandParameters.getScopes()), getCachedAccountRecord(silentTokenCommandParameters), silentTokenCommandParameters.getAuthenticationScheme()).get(0);
    }

    public OAuth2TokenCache getTokenCache(SilentTokenCommandParameters silentTokenCommandParameters) {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        return silentTokenCommandParameters.getOAuth2TokenCache();
    }

    public static void logResult(String str, IResult iResult) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (iResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        String str2 = str + ":" + iResult.getClass().getSimpleName();
        if (iResult.getSuccess()) {
            Logger.info(str2, "Success Result");
            ResultUtil.logExposedFieldsOfObject(str2, iResult.getSuccessResponse());
        } else {
            Logger.warn(str2, "Failure Result");
            if (iResult.getErrorResponse() != null) {
                if (iResult.getErrorResponse().getError() != null) {
                    Logger.warn(str2, "Error: " + iResult.getErrorResponse().getError());
                }
                if (iResult.getErrorResponse().getErrorDescription() != null) {
                    Logger.warnPII(str2, "Description: " + iResult.getErrorResponse().getErrorDescription());
                }
                ResultUtil.logExposedFieldsOfObject(str2, iResult.getErrorResponse());
            }
        }
        if (iResult instanceof AuthorizationResult) {
            AuthorizationResult authorizationResult = (AuthorizationResult) iResult;
            if (authorizationResult.getAuthorizationStatus() != null) {
                Logger.info(str2, "Authorization Status: " + authorizationResult.getAuthorizationStatus().toString());
            }
        }
    }

    protected void logParameters(String str, Object obj) {
        String str2 = str + ":" + obj.getClass().getSimpleName();
        if (Logger.isAllowPii()) {
            Logger.infoPII(str2, ObjectMapper.serializeObjectToJsonString(obj));
        } else {
            Logger.info(str2, ObjectMapper.serializeExposedFieldsOfObjectToJsonString(obj));
        }
    }

    protected TokenResult performSilentTokenRequest(OAuth2Strategy oAuth2Strategy, RefreshTokenRecord refreshTokenRecord, SilentTokenCommandParameters silentTokenCommandParameters) throws IOException, ClientException {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":performSilentTokenRequest").toString(), "Requesting tokens...");
        silentTokenCommandParameters.getPlatformComponents().getPlatformUtil().throwIfNetworkNotAvailable(silentTokenCommandParameters.isPowerOptCheckEnabled());
        Authority.KnownAuthorityResult knownAuthorityResult = Authority.getKnownAuthorityResult(silentTokenCommandParameters.getAuthority());
        if (!knownAuthorityResult.getKnown()) {
            throw knownAuthorityResult.getClientException();
        }
        TokenRequest tokenRequestCreateRefreshTokenRequest = oAuth2Strategy.createRefreshTokenRequest(silentTokenCommandParameters.getAuthenticationScheme());
        if (silentTokenCommandParameters.hasNestedAppParameters()) {
            tokenRequestCreateRefreshTokenRequest.setClientId(silentTokenCommandParameters.getChildClientId());
            tokenRequestCreateRefreshTokenRequest.setBrkClientId(silentTokenCommandParameters.getClientId());
            tokenRequestCreateRefreshTokenRequest.setRedirectUri(silentTokenCommandParameters.getChildRedirectUri());
            tokenRequestCreateRefreshTokenRequest.setBrkRedirectUri(silentTokenCommandParameters.getRedirectUri());
        } else {
            tokenRequestCreateRefreshTokenRequest.setClientId(silentTokenCommandParameters.getClientId());
        }
        tokenRequestCreateRefreshTokenRequest.setScope(StringUtil.join(" ", silentTokenCommandParameters.getScopes()));
        tokenRequestCreateRefreshTokenRequest.setRefreshToken(refreshTokenRecord.getSecret());
        if (tokenRequestCreateRefreshTokenRequest instanceof MicrosoftTokenRequest) {
            MicrosoftTokenRequest microsoftTokenRequest = (MicrosoftTokenRequest) tokenRequestCreateRefreshTokenRequest;
            microsoftTokenRequest.setClaims(silentTokenCommandParameters.getClaimsRequestJson());
            microsoftTokenRequest.setClientAppName(silentTokenCommandParameters.getApplicationName());
            microsoftTokenRequest.setClientAppVersion(silentTokenCommandParameters.getApplicationVersion());
            if (silentTokenCommandParameters.getSdkType() == SdkType.ADAL) {
                microsoftTokenRequest.setIdTokenVersion("1");
            }
            if (silentTokenCommandParameters instanceof BrokerSilentTokenCommandParameters) {
                BrokerSilentTokenCommandParameters brokerSilentTokenCommandParameters = (BrokerSilentTokenCommandParameters) silentTokenCommandParameters;
                microsoftTokenRequest.setBrokerVersion(brokerSilentTokenCommandParameters.getBrokerVersion());
                microsoftTokenRequest.setPKeyAuthHeaderAllowed(brokerSilentTokenCommandParameters.isPKeyAuthHeaderAllowed());
                if (!StringUtil.isNullOrEmpty(silentTokenCommandParameters.getMamEnrollmentId())) {
                    microsoftTokenRequest.setMicrosoftEnrollmentId(silentTokenCommandParameters.getMamEnrollmentId());
                }
            }
        }
        if (!StringUtil.isNullOrEmpty(tokenRequestCreateRefreshTokenRequest.getScope())) {
            Logger.infoPII(str + ":performSilentTokenRequest", "Scopes: [" + tokenRequestCreateRefreshTokenRequest.getScope() + "]");
        }
        return strategyRequestToken(oAuth2Strategy, tokenRequestCreateRefreshTokenRequest);
    }

    private TokenResult strategyRequestToken(OAuth2Strategy oAuth2Strategy, TokenRequest tokenRequest) throws IOException, ClientException {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        return oAuth2Strategy.requestToken(tokenRequest);
    }

    protected List<ICacheRecord> saveTokens(OAuth2Strategy oAuth2Strategy, AuthorizationRequest authorizationRequest, TokenResponse tokenResponse, OAuth2TokenCache oAuth2TokenCache) throws ClientException {
        if (oAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (authorizationRequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (tokenResponse == null) {
            throw new NullPointerException("tokenResponse is marked non-null but is null");
        }
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("tokenCache is marked non-null but is null");
        }
        Logger.info(TAG + ":saveTokens", "Saving tokens...");
        return oAuth2TokenCache.saveAndLoadAggregatedAccountData(oAuth2Strategy, authorizationRequest, tokenResponse);
    }

    protected boolean refreshTokenIsNull(ICacheRecord iCacheRecord) {
        if (iCacheRecord != null) {
            return iCacheRecord.getRefreshToken() == null;
        }
        throw new NullPointerException("cacheRecord is marked non-null but is null");
    }

    protected boolean accessTokenIsNull(ICacheRecord iCacheRecord) {
        if (iCacheRecord != null) {
            return iCacheRecord.getAccessToken() == null;
        }
        throw new NullPointerException("cacheRecord is marked non-null but is null");
    }

    protected boolean idTokenIsNull(ICacheRecord iCacheRecord, SdkType sdkType) {
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        if (sdkType != null) {
            return (sdkType == SdkType.ADAL ? iCacheRecord.getV1IdToken() : iCacheRecord.getIdToken()) == null;
        }
        throw new NullPointerException("sdkType is marked non-null but is null");
    }

    protected Set<String> addDefaultScopes(TokenCommandParameters tokenCommandParameters) {
        if (tokenCommandParameters == null) {
            throw new NullPointerException("commandParameters is marked non-null but is null");
        }
        Set<String> scopes = tokenCommandParameters.getScopes();
        scopes.addAll(AuthenticationConstants.DEFAULT_SCOPES);
        scopes.removeAll(Arrays.asList("", null));
        return scopes;
    }

    protected AccountRecord getCachedAccountRecord(SilentTokenCommandParameters silentTokenCommandParameters) throws ClientException {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        String str = TAG + ":getCachedAccountRecord";
        if (silentTokenCommandParameters.getAccount() == null) {
            throw new ClientException("no_account_found", "No cached accounts found for the supplied homeAccountId and clientId");
        }
        boolean zEqualsIgnoreCase = Authority.B2C.equalsIgnoreCase(silentTokenCommandParameters.getAuthority().getAuthorityTypeString());
        AccountRecord cachedAccountRecordFromCallingAppCache = getCachedAccountRecordFromCallingAppCache(silentTokenCommandParameters);
        if (cachedAccountRecordFromCallingAppCache != null) {
            return cachedAccountRecordFromCallingAppCache;
        }
        Logger.info(str, "Account not found in app cache..");
        AccountRecord cachedAccountRecordFromAllCaches = getCachedAccountRecordFromAllCaches(silentTokenCommandParameters);
        if (cachedAccountRecordFromAllCaches != null) {
            return cachedAccountRecordFromAllCaches;
        }
        String clientId = silentTokenCommandParameters.getClientId();
        String homeAccountId = silentTokenCommandParameters.getAccount().getHomeAccountId();
        if (Logger.isAllowPii()) {
            Logger.errorPII(str, "No accounts found for clientId [" + clientId + "], homeAccountId [" + homeAccountId + "]", null);
        } else {
            Logger.error(str, "No accounts found for clientId [" + clientId + "]", null);
        }
        throw new ClientException("no_account_found", "No cached accounts found for the supplied ".concat(zEqualsIgnoreCase ? "homeAccountId" : "localAccountId"));
    }

    private AccountRecord getCachedAccountRecordFromCallingAppCache(SilentTokenCommandParameters silentTokenCommandParameters) {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        boolean zEqualsIgnoreCase = Authority.B2C.equalsIgnoreCase(silentTokenCommandParameters.getAuthority().getAuthorityTypeString());
        String clientId = silentTokenCommandParameters.getClientId();
        String homeAccountId = silentTokenCommandParameters.getAccount().getHomeAccountId();
        String localAccountId = silentTokenCommandParameters.getAccount().getLocalAccountId();
        String environment = silentTokenCommandParameters.getAccount().getEnvironment();
        if (zEqualsIgnoreCase) {
            return silentTokenCommandParameters.getOAuth2TokenCache().getAccountByHomeAccountId(null, clientId, homeAccountId);
        }
        return silentTokenCommandParameters.getOAuth2TokenCache().getAccountByLocalAccountId(environment, clientId, localAccountId);
    }

    protected AccountRecord getCachedAccountRecordFromAllCaches(SilentTokenCommandParameters silentTokenCommandParameters) throws ClientException {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (silentTokenCommandParameters.getOAuth2TokenCache() instanceof MsalOAuth2TokenCache) {
            return getAccountWithFRTIfAvailable(silentTokenCommandParameters, (MsalOAuth2TokenCache) silentTokenCommandParameters.getOAuth2TokenCache());
        }
        return null;
    }

    private AccountRecord getAccountWithFRTIfAvailable(SilentTokenCommandParameters silentTokenCommandParameters, MsalOAuth2TokenCache msalOAuth2TokenCache) {
        if (silentTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        if (msalOAuth2TokenCache == null) {
            throw new NullPointerException("msalOAuth2TokenCache is marked non-null but is null");
        }
        String str = TAG + ":getAccountWithFRTIfAvailable";
        String homeAccountId = silentTokenCommandParameters.getAccount().getHomeAccountId();
        String clientId = silentTokenCommandParameters.getClientId();
        RefreshTokenRecord familyRefreshTokenForHomeAccountId = msalOAuth2TokenCache.getFamilyRefreshTokenForHomeAccountId(homeAccountId);
        if (familyRefreshTokenForHomeAccountId != null) {
            try {
                FociQueryUtilities.tryFociTokenWithGivenClientId(silentTokenCommandParameters.getOAuth2TokenCache(), clientId, silentTokenCommandParameters.getRedirectUri(), familyRefreshTokenForHomeAccountId, silentTokenCommandParameters.getAccount());
                return silentTokenCommandParameters.getOAuth2TokenCache().getAccountByLocalAccountId(null, clientId, silentTokenCommandParameters.getAccount().getLocalAccountId());
            } catch (ClientException | IOException e) {
                Logger.warn(str, "Error while attempting to validate client: " + clientId + " is part of family " + e.getMessage());
            }
        } else {
            Logger.info(str, "No Foci tokens found for homeAccountId " + homeAccountId);
        }
        return null;
    }

    protected boolean isRequestAuthorityRealmSameAsATRealm(Authority authority, AccessTokenRecord accessTokenRecord) throws ServiceException, ClientException {
        if (authority == null) {
            throw new NullPointerException("requestAuthority is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        if (!(authority instanceof AzureActiveDirectoryAuthority)) {
            return true;
        }
        AzureActiveDirectoryAuthority azureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority) authority;
        if (AzureActiveDirectoryAudience.isHomeTenantAlias(azureActiveDirectoryAuthority.getAudience().getTenantId())) {
            return accessTokenRecord.getHomeAccountId().split(Pattern.quote("."))[1].equalsIgnoreCase(accessTokenRecord.getRealm());
        }
        return azureActiveDirectoryAuthority.getAudience().getTenantUuidForAlias(authority.getAuthorityURL().toString()).equalsIgnoreCase(accessTokenRecord.getRealm());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ICacheRecord finalizeCacheRecordForResult(ICacheRecord iCacheRecord, AbstractAuthenticationScheme abstractAuthenticationScheme) throws ClientException {
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == 0) {
            throw new NullPointerException("scheme is marked non-null but is null");
        }
        if ((abstractAuthenticationScheme instanceof ITokenAuthenticationSchemeInternal) && !StringUtil.isNullOrEmpty(iCacheRecord.getAccessToken().getSecret())) {
            iCacheRecord.getAccessToken().setSecret(((ITokenAuthenticationSchemeInternal) abstractAuthenticationScheme).getAccessTokenForScheme(iCacheRecord.getAccessToken().getSecret()));
        }
        return iCacheRecord;
    }

    protected void validateDeviceCodeFlowServiceResult(IResult iResult) throws ServiceException {
        String str;
        if (iResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        if (iResult.getSuccess()) {
            return;
        }
        String error = iResult.getErrorResponse().getError();
        error.hashCode();
        switch (error) {
            case "bad_verification_code":
                str = ErrorStrings.DEVICE_CODE_FLOW_BAD_VERIFICATION_ERROR_MESSAGE;
                break;
            case "invalid_grant":
                str = ErrorStrings.DEVICE_CODE_FLOW_INVALID_GRANT_ERROR_MESSAGE;
                break;
            case "invalid_scope":
                str = ErrorStrings.DEVICE_CODE_FLOW_INVALID_SCOPE_ERROR_MESSAGE;
                break;
            case "authorization_declined":
                str = ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_DECLINED_ERROR_MESSAGE;
                break;
            case "expired_token":
                str = ErrorStrings.DEVICE_CODE_FLOW_EXPIRED_TOKEN_ERROR_MESSAGE;
                break;
            default:
                str = ErrorStrings.DEVICE_CODE_FLOW_DEFAULT_ERROR_MESSAGE;
                break;
        }
        throw new ServiceException(error, str, 0, null);
    }

    public IControllerFactory asControllerFactory() {
        return new IControllerFactory() { // from class: com.microsoft.identity.common.java.controllers.BaseController.1
            @Override // com.microsoft.identity.common.java.controllers.IControllerFactory
            public BaseController getDefaultController() {
                return this;
            }

            @Override // com.microsoft.identity.common.java.controllers.IControllerFactory
            public List<BaseController> getAllControllers() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this);
                return arrayList;
            }
        };
    }
}
