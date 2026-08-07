package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsTokenResponse extends MicrosoftTokenResponse {

    @SerializedName("not_before")
    private String mExpiresNotBefore;

    public String getExpiresNotBefore() {
        return this.mExpiresNotBefore;
    }

    public void setExpiresNotBefore(String str) {
        this.mExpiresNotBefore = str;
    }
}
