package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;

/* JADX INFO: loaded from: classes14.dex */
public class ActiveDirectoryFederationServicesAuthorizationRequest extends MicrosoftAuthorizationRequest<ActiveDirectoryFederationServicesAuthorizationRequest> {
    private static final long serialVersionUID = -3028954460087575031L;

    private ActiveDirectoryFederationServicesAuthorizationRequest(Builder builder) {
        super(builder);
    }

    public static final class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public ActiveDirectoryFederationServicesAuthorizationRequest build() {
            return new ActiveDirectoryFederationServicesAuthorizationRequest(this);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
