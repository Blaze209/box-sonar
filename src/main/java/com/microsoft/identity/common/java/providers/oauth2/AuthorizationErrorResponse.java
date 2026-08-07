package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;

/* JADX INFO: loaded from: classes14.dex */
public class AuthorizationErrorResponse implements IErrorResponse {

    @Expose
    private String mError;

    @Expose
    private String mErrorDescription;
    private boolean mTokenProtectionRequired;
    private String mUpnToWpj;

    public static class Fields {
        public static final String ERROR = "error";
        public static final String ERROR_DESCRIPTION = "error_description";
    }

    public void setError(String str) {
        this.mError = str;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public void setTokenProtectionRequired(boolean z) {
        this.mTokenProtectionRequired = z;
    }

    public void setUpnToWpj(String str) {
        this.mUpnToWpj = str;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getError() {
        return this.mError;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public String getUpnToWpj() {
        return this.mUpnToWpj;
    }

    public boolean isTokenProtectionRequired() {
        return this.mTokenProtectionRequired;
    }

    public AuthorizationErrorResponse(String str, String str2) {
        this.mError = str;
        this.mErrorDescription = str2;
    }
}
