package com.microsoft.identity.client;

import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;

/* JADX INFO: loaded from: classes14.dex */
public enum AadAuthorityAudience {
    AzureAdAndPersonalMicrosoftAccount("common"),
    AzureAdMultipleOrgs(AzureActiveDirectoryAudience.ORGANIZATIONS),
    PersonalMicrosoftAccount("consumers"),
    AzureAdMyOrg(null);

    private String audienceValue;

    AadAuthorityAudience(String str) {
        this.audienceValue = str;
    }

    public String getAudienceValue() {
        return this.audienceValue;
    }
}
