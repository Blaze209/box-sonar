package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryInstanceResponse {

    @SerializedName("api-version")
    private String mApiVersion;

    @SerializedName("metadata")
    private ArrayList<AzureActiveDirectoryCloud> mClouds;

    @SerializedName("tenant_discovery_endpoint")
    private String mTestDiscoveryEndpoint;

    public String getTestDiscoveryEndpoint() {
        return this.mTestDiscoveryEndpoint;
    }

    public String getApiVersion() {
        return this.mApiVersion;
    }

    public ArrayList<AzureActiveDirectoryCloud> getClouds() {
        return this.mClouds;
    }
}
