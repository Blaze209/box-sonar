package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.request.SdkType;

/* JADX INFO: loaded from: classes14.dex */
public interface IAccountCredentialAdapter<T extends OAuth2Strategy, U extends AuthorizationRequest, V extends TokenResponse, W extends BaseAccount, X extends RefreshToken> {
    AccountRecord asAccount(W w);

    IdTokenRecord asIdToken(W w, X x);

    RefreshTokenRecord asRefreshToken(X x);

    AccessTokenRecord createAccessToken(T t, U u, V v);

    AccessTokenRecord createAccessTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, V v) throws ClientException;

    AccountRecord createAccount(T t, U u, V v);

    AccountRecord createAccountRecord(TokenCommandParameters tokenCommandParameters, SdkType sdkType, V v) throws ServiceException;

    IdTokenRecord createIdToken(T t, U u, V v);

    IdTokenRecord createIdTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, V v);

    RefreshTokenRecord createRefreshToken(T t, U u, V v);

    RefreshTokenRecord createRefreshTokenRecord(TokenCommandParameters tokenCommandParameters, AccountRecord accountRecord, V v);
}
