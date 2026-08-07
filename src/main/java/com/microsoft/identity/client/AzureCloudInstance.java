package com.microsoft.identity.client;

import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryEnvironment;

/* JADX INFO: loaded from: classes14.dex */
public enum AzureCloudInstance {
    AzurePublic(AzureActiveDirectoryEnvironment.PRODUCTION_CLOUD_URL),
    AzureChina("https://login.partner.microsoftonline.cn"),
    AzureGermany("https://login.microsoftonline.de"),
    AzureUsGov("https://login.microsoftonline.us");

    private String cloudInstanceUri;

    AzureCloudInstance(String str) {
        this.cloudInstanceUri = str;
    }

    public String getCloudInstanceUri() {
        return this.cloudInstanceUri;
    }
}
