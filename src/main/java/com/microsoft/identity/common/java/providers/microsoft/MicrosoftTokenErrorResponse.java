package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftTokenErrorResponse extends TokenErrorResponse {

    @SerializedName("correlation_id")
    private String mCorrelationId;

    @SerializedName("error_codes")
    private List<Long> mErrorCodes;

    @SerializedName("oAuth_metadata")
    private String mOAuthErrorMetadata;

    @SerializedName("timestamp")
    private String mTimeStamp;

    @SerializedName("trace_id")
    private String mTraceId;

    public List<Long> getErrorCodes() {
        return this.mErrorCodes;
    }

    public void setErrorCodes(List<Long> list) {
        this.mErrorCodes = list;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public void setCorrelationId(String str) {
        this.mCorrelationId = str;
    }

    public String getOAuthErrorMetadata() {
        return this.mOAuthErrorMetadata;
    }

    public void setOAuthErrorMetadata(String str) {
        this.mOAuthErrorMetadata = str;
    }
}
