package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsRopcTokenRequest extends MicrosoftStsTokenRequest {

    @SerializedName("password")
    private String mPassword;

    @SerializedName("username")
    private String mUsername;

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public String getPassword() {
        return this.mPassword;
    }
}
