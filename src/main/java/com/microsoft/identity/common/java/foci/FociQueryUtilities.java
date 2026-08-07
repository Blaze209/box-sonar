package com.microsoft.identity.common.java.foci;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.ObjectUtils;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class FociQueryUtilities {
    private static final String TAG = "FociQueryUtilities";

    public static boolean tryFociTokenWithGivenClientId(BrokerOAuth2TokenCache brokerOAuth2TokenCache, String str, String str2, ICacheRecord iCacheRecord) throws IOException, ClientException {
        if (brokerOAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        return tryFociTokenWithGivenClientId(brokerOAuth2TokenCache, str, str2, iCacheRecord.getRefreshToken(), iCacheRecord.getAccount());
    }

    public static boolean tryFociTokenWithGivenClientId(OAuth2TokenCache oAuth2TokenCache, String str, String str2, RefreshTokenRecord refreshTokenRecord, IAccountRecord iAccountRecord) throws IOException, ClientException {
        String delimitedDefaultScopeString;
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenRecord is marked non-null but is null");
        }
        if (iAccountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
        CommonURIBuilder commonURIBuilder = new CommonURIBuilder();
        commonURIBuilder.setScheme("https").setHost(refreshTokenRecord.getEnvironment()).setPath(StringUtil.isNullOrEmpty(iAccountRecord.getRealm()) ? "common" : iAccountRecord.getRealm());
        try {
            microsoftStsOAuth2Configuration.setAuthorityUrl(new URL(commonURIBuilder.build().toString()));
            MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy = new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2Configuration, OAuth2StrategyParameters.builder().build());
            String secret = refreshTokenRecord.getSecret();
            if (ObjectUtils.equals(str, "87749df4-7ccf-48f8-aa87-704bad0e0e16")) {
                Span spanCreateSpan = OTelUtility.createSpan(SpanName.SetScopeForDMAgentForFoci.name());
                try {
                    Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
                    try {
                        delimitedDefaultScopeString = "https://devicemgmt.teams.microsoft.com/.default " + BaseController.getDelimitedDefaultScopeString();
                        Logger.info(TAG + ":tryFociTokenWithGivenClientId", "Teams agent client ID - making a test request with teams agent resource.");
                        if (scopeMakeCurrentSpan != null) {
                            scopeMakeCurrentSpan.close();
                        }
                        spanCreateSpan.end();
                    } catch (Throwable th) {
                        if (scopeMakeCurrentSpan == null) {
                            throw th;
                        }
                        try {
                            scopeMakeCurrentSpan.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    spanCreateSpan.end();
                    throw th3;
                }
            } else {
                delimitedDefaultScopeString = BaseController.getDelimitedDefaultScopeString();
            }
            String str3 = delimitedDefaultScopeString;
            UUID uuidRandomUUID = UUID.randomUUID();
            StringBuilder sb = new StringBuilder();
            String str4 = TAG;
            Logger.verbose(sb.append(str4).append(":tryFociTokenWithGivenClientId").toString(), "Create the token request with correlationId [" + uuidRandomUUID + "]");
            MicrosoftStsTokenRequest microsoftStsTokenRequestCreateTokenRequest = createTokenRequest(str, str3, secret, str2, microsoftStsOAuth2Strategy, uuidRandomUUID, "2");
            Logger.verbose(str4 + ":tryFociTokenWithGivenClientId", "Start refreshing token (to verify foci) with correlationId [" + uuidRandomUUID + "]");
            TokenResult tokenResultRequestToken = microsoftStsOAuth2Strategy.requestToken(microsoftStsTokenRequestCreateTokenRequest);
            Logger.verbose(str4 + ":tryFociTokenWithGivenClientId", "Is the client ID able to use the foci? [" + tokenResultRequestToken.getSuccess() + "] with correlationId [" + uuidRandomUUID + "]");
            if (tokenResultRequestToken.getSuccess()) {
                MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequestCreateAuthRequest = createAuthRequest(microsoftStsOAuth2Strategy, str, str2, str3, iAccountRecord, uuidRandomUUID);
                Logger.verbose(str4 + ":tryFociTokenWithGivenClientId", "Saving records to cache with client id" + str);
                brokerOAuth2TokenCacheSave(oAuth2TokenCache, microsoftStsOAuth2Strategy, tokenResultRequestToken, microsoftStsAuthorizationRequestCreateAuthRequest);
            }
            return tokenResultRequestToken.getSuccess();
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    public static MicrosoftStsTokenRequest createTokenRequest(String str, String str2, String str3, String str4, MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, UUID uuid, String str5) throws ClientException {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        if (str4 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (microsoftStsOAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (str5 == null) {
            throw new NullPointerException("idTokenVersion is marked non-null but is null");
        }
        MicrosoftStsTokenRequest microsoftStsTokenRequestCreateRefreshTokenRequest = microsoftStsOAuth2Strategy.createRefreshTokenRequest((AbstractAuthenticationScheme) new BearerAuthenticationSchemeInternal());
        microsoftStsTokenRequestCreateRefreshTokenRequest.setClientId(str);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setScope(str2);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setCorrelationId(uuid);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setRefreshToken(str3);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setRedirectUri(str4);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setIdTokenVersion(str5);
        return microsoftStsTokenRequestCreateRefreshTokenRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static MicrosoftStsAuthorizationRequest createAuthRequest(MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, String str, String str2, String str3, IAccountRecord iAccountRecord, UUID uuid) {
        if (microsoftStsOAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("scope is marked non-null but is null");
        }
        if (iAccountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        return ((MicrosoftStsAuthorizationRequest.Builder) ((MicrosoftStsAuthorizationRequest.Builder) ((MicrosoftStsAuthorizationRequest.Builder) microsoftStsOAuth2Strategy.createAuthorizationRequestBuilder(iAccountRecord).setClientId(str)).setRedirectUri(str2)).setCorrelationId(uuid).setScope(str3)).build();
    }

    private static void brokerOAuth2TokenCacheSave(OAuth2TokenCache oAuth2TokenCache, MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, TokenResult tokenResult, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) throws ClientException {
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        oAuth2TokenCache.save(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, (MicrosoftTokenResponse) tokenResult.getTokenResponse());
    }
}
