package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
public class AcquireTokenSilentParameters extends TokenParameters {
    private SilentAuthenticationCallback mCallback;
    private boolean mForceRefresh;

    public AcquireTokenSilentParameters(Builder builder) {
        super(builder);
        this.mForceRefresh = builder.mForceRefresh;
        this.mCallback = builder.mCallback;
    }

    void setCallback(SilentAuthenticationCallback silentAuthenticationCallback) {
        this.mCallback = silentAuthenticationCallback;
    }

    public SilentAuthenticationCallback getCallback() {
        return this.mCallback;
    }

    public void setForceRefresh(boolean z) {
        this.mForceRefresh = z;
    }

    public boolean getForceRefresh() {
        return this.mForceRefresh;
    }

    public static class Builder extends TokenParameters.Builder<Builder> {
        private SilentAuthenticationCallback mCallback;
        private boolean mForceRefresh;

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        public Builder forceRefresh(boolean z) {
            this.mForceRefresh = z;
            return self();
        }

        public Builder withCallback(SilentAuthenticationCallback silentAuthenticationCallback) {
            this.mCallback = silentAuthenticationCallback;
            return this;
        }

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public AcquireTokenSilentParameters build() {
            return new AcquireTokenSilentParameters(this);
        }
    }
}
