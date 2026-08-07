package com.microsoft.identity.client.internal.api;

import android.content.Context;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public final class BrokerClientIdRefreshTokenAccessor {
    private static final String TAG = "BrokerClientIdRefreshTokenAccessor";

    public static String get(Context context, String str) throws MsalClientException {
        String str2 = TAG + ":get";
        throwIfNotValidBroker(context);
        MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> msalOAuth2TokenCacheCreate = MsalOAuth2TokenCache.create(AndroidPlatformComponentsFactory.createFromContext(context));
        ICacheRecord cacheRecordForIdentifier = getCacheRecordForIdentifier(msalOAuth2TokenCacheCreate, str, String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, null, null));
        if (cacheRecordForIdentifier == null) {
            Logger.verbose(str2, "No cache record found.");
            return null;
        }
        msalOAuth2TokenCacheCreate.removeCredential(cacheRecordForIdentifier.getRefreshToken());
        msalOAuth2TokenCacheCreate.removeCredential(cacheRecordForIdentifier.getAccessToken());
        if (cacheRecordForIdentifier.getRefreshToken() == null) {
            Logger.verbose(str2, "Refresh token record is empty.");
            return null;
        }
        return cacheRecordForIdentifier.getRefreshToken().getSecret();
    }

    private static ICacheRecord getCacheRecordForIdentifier(MsalOAuth2TokenCache msalOAuth2TokenCache, String str, String str2) throws MsalClientException {
        AccountRecord accountByLocalAccountId = msalOAuth2TokenCache.getAccountByLocalAccountId(null, AuthenticationConstants.Broker.BROKER_CLIENT_ID, str);
        if (accountByLocalAccountId == null) {
            throw new MsalClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND);
        }
        return msalOAuth2TokenCache.load(AuthenticationConstants.Broker.BROKER_CLIENT_ID, str2, null, null, accountByLocalAccountId, new BearerAuthenticationSchemeInternal());
    }

    private static void throwIfNotValidBroker(Context context) throws MsalClientException {
        if (!new BrokerValidator(context).isValidBrokerPackage(context.getPackageName())) {
            throw new MsalClientException(MsalClientException.NOT_ELIGIBLE_TO_USE_BROKER, "This can only be invoked by Broker apps.");
        }
    }
}
