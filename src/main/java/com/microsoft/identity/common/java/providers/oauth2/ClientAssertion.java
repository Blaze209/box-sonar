package com.microsoft.identity.common.java.providers.oauth2;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ClientAssertion {
    private static final String DEFAULT_CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
    private String mClientAssertion;
    private String mClientAssertionType = DEFAULT_CLIENT_ASSERTION_TYPE;

    public String getClientAssertion() {
        return this.mClientAssertion;
    }

    public void setClientAssertion(String str) {
        this.mClientAssertion = str;
    }

    public String getClientAssertionType() {
        return this.mClientAssertionType;
    }

    public void setClientAssertionType(String str) {
        this.mClientAssertionType = str;
    }
}
