package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse {
    private String mErrorCodes;

    public AzureActiveDirectoryAuthorizationErrorResponse(String str, String str2) {
        super(str, str2);
    }

    public String getErrorCodes() {
        return this.mErrorCodes;
    }

    public void setErrorCodes(String str) {
        this.mErrorCodes = str;
    }
}
