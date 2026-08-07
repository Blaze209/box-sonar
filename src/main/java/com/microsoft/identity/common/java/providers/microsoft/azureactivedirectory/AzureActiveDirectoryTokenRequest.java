package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryTokenRequest extends TokenRequest {

    @SerializedName("resource")
    private String mResourceId;

    public String getResourceId() {
        return this.mResourceId;
    }

    public void setResourceId(String str) {
        this.mResourceId = str;
    }
}
