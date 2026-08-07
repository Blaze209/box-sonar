package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class TokenErrorResponse implements IErrorResponse {

    @SerializedName("error")
    @Expose
    private String mError;

    @SerializedName("error_description")
    @Expose
    private String mErrorDescription;

    @SerializedName("error_uri")
    @Expose
    private String mErrorUri;
    private String mResponseBody;

    @Expose
    private String mResponseHeadersJson;

    @Expose
    private int mStatusCode;

    @SerializedName("suberror")
    @Expose
    private String mSubError;

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getError() {
        return this.mError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public String getSubError() {
        return this.mSubError;
    }

    public void setSubError(String str) {
        this.mSubError = str;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public String getErrorUri() {
        return this.mErrorUri;
    }

    public void setErrorUri(String str) {
        this.mErrorUri = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int i) {
        this.mStatusCode = i;
    }

    public String getResponseBody() {
        return this.mResponseBody;
    }

    public void setResponseBody(String str) {
        this.mResponseBody = str;
    }

    public String getResponseHeadersJson() {
        return this.mResponseHeadersJson;
    }

    public void setResponseHeadersJson(String str) {
        this.mResponseHeadersJson = str;
    }

    public String toString() {
        return "TokenErrorResponse{mStatusCode=" + this.mStatusCode + ", mResponseBody='" + this.mResponseBody + "', mResponseHeadersJson=" + this.mResponseHeadersJson + ", mError='" + this.mError + "', mSubError='" + this.mSubError + "', mErrorDescription='" + this.mErrorDescription + "', mErrorUri='" + this.mErrorUri + "'}";
    }
}
