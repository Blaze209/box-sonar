package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
public class DeviceCodeFlowParameters extends TokenParameters {
    public DeviceCodeFlowParameters(Builder builder) {
        super(builder);
    }

    public static class Builder extends TokenParameters.Builder<Builder> {
        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public Builder self() {
            return this;
        }

        @Override // com.microsoft.identity.client.TokenParameters.Builder
        public DeviceCodeFlowParameters build() {
            return new DeviceCodeFlowParameters(this);
        }
    }
}
