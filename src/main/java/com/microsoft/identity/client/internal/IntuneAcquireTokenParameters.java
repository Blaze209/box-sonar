package com.microsoft.identity.client.internal;

import com.microsoft.identity.client.AcquireTokenParameters;

/* JADX INFO: loaded from: classes14.dex */
public class IntuneAcquireTokenParameters extends AcquireTokenParameters {
    private boolean mBrokerBrowserSupportEnabled;

    private IntuneAcquireTokenParameters(Builder builder) {
        super(builder);
        this.mBrokerBrowserSupportEnabled = builder.mBrokerBrowserSupportEnabled;
    }

    public boolean isBrokerBrowserSupportEnabled() {
        return this.mBrokerBrowserSupportEnabled;
    }

    public static class Builder extends AcquireTokenParameters.Builder {
        private boolean mBrokerBrowserSupportEnabled;

        @Override // com.microsoft.identity.client.AcquireTokenParameters.Builder, com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        public Builder brokerBrowserSupportEnabled(boolean z) {
            this.mBrokerBrowserSupportEnabled = z;
            return this;
        }

        @Override // com.microsoft.identity.client.AcquireTokenParameters.Builder, com.microsoft.identity.client.TokenParameters.Builder
        public IntuneAcquireTokenParameters build() {
            return new IntuneAcquireTokenParameters(this);
        }
    }
}
