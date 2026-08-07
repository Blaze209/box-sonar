package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAuthorizationRequest extends MicrosoftAuthorizationRequest {
    private static final long serialVersionUID = 6813760067123426470L;

    @SerializedName("claims")
    private String mClaimsChallenge;

    @SerializedName(AuthenticationConstants.AAD.QUERY_PROMPT)
    private String mPrompt;

    @SerializedName("resource")
    private String mResource;

    public static final class Prompt {
        public static final String ADMIN_CONSENT = "admin_consent";
        public static final String ALWAYS = "login";
        public static final String AUTO = "none";
        public static final String CONSENT = "consent";
        public static final String FORCE_PROMPT = "login";
        public static final String REFRESH_SESSION = "refresh_session";
        public static final String SELECT_ACCOUNT = "select_account";
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() {
        return null;
    }

    protected AzureActiveDirectoryAuthorizationRequest(Builder builder) {
        super(builder);
        this.mResource = builder.mResource;
        this.mPrompt = builder.mPrompt;
        this.mClaimsChallenge = builder.mClaimsChallenge;
    }

    public static class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        private String mClaimsChallenge;
        private String mPrompt;
        private String mResource;

        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        public Builder setResource(String str) {
            this.mResource = str;
            return this;
        }

        public Builder setPrompt(String str) {
            this.mPrompt = str;
            return this;
        }

        public Builder setClaimsChallenge(String str) {
            this.mClaimsChallenge = str;
            return this;
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public AzureActiveDirectoryAuthorizationRequest build() {
            setLibraryName("ADAL.Android");
            setLibraryVersion("1.15.2");
            return new AzureActiveDirectoryAuthorizationRequest(this);
        }
    }

    public String getResource() {
        return this.mResource;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public String getClaimsChallenge() {
        return this.mClaimsChallenge;
    }
}
