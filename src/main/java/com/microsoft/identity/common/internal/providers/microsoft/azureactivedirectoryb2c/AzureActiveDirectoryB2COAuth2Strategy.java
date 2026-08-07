package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.providers.oauth2.AccessToken;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryB2COAuth2Strategy extends OAuth2Strategy {
    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public BaseAccount createAccount(TokenResponse tokenResponse) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public TokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme abstractAuthenticationScheme) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public TokenRequest createRopcTokenRequest(RopcTokenCommandParameters ropcTokenCommandParameters) throws ClientException {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public TokenRequest createTokenRequest(AuthorizationRequest authorizationRequest, AuthorizationResponse authorizationResponse, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AccessToken getAccessTokenFromResponse(TokenResponse tokenResponse) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public String getIssuerCacheIdentifier(AuthorizationRequest authorizationRequest) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public RefreshToken getRefreshTokenFromResponse(TokenResponse tokenResponse) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    protected TokenResult getTokenResultFromHttpResponse(HttpResponse httpResponse) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    protected void validateAuthorizationRequest(AuthorizationRequest authorizationRequest) {
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    protected void validateTokenRequest(TokenRequest tokenRequest) {
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    protected void validateTokenResponse(TokenRequest tokenRequest, TokenResponse tokenResponse) {
    }

    public AzureActiveDirectoryB2COAuth2Strategy(OAuth2Configuration oAuth2Configuration, OAuth2StrategyParameters oAuth2StrategyParameters) {
        super(oAuth2Configuration, oAuth2StrategyParameters);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public Future<AuthorizationResult> requestAuthorization(AuthorizationRequest authorizationRequest, IAuthorizationStrategy iAuthorizationStrategy) throws ClientException {
        return super.requestAuthorization(authorizationRequest, iAuthorizationStrategy);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AuthorizationResultFactory getAuthorizationResultFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AuthorizationRequest.Builder createAuthorizationRequestBuilder() {
        return new AzureActiveDirectoryB2CAuthorizationRequest.Builder();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord iAccountRecord) {
        return createAuthorizationRequestBuilder();
    }
}
