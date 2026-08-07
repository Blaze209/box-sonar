package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryB2CAuthorizationRequest extends MicrosoftAuthorizationRequest<AzureActiveDirectoryB2CAuthorizationRequest> {
    private static final long serialVersionUID = -3380061616328869269L;
    private String mPrompt;

    private AzureActiveDirectoryB2CAuthorizationRequest(Builder builder) {
        super(builder);
        this.mPrompt = builder.mPrompt;
    }

    public static final class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        private String mPrompt;

        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        public Builder setPrompt(String str) {
            this.mPrompt = str;
            return this;
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public AzureActiveDirectoryB2CAuthorizationRequest build() {
            return new AzureActiveDirectoryB2CAuthorizationRequest(this);
        }
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() {
        throw new UnsupportedOperationException("Not implemented.");
    }
}
