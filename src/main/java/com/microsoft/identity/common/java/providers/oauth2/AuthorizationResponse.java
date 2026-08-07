package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AuthorizationResponse implements ISuccessResponse {
    private String mCode;
    private transient Iterable<Map.Entry<String, String>> mExtraParameters;

    @Expose
    private String mState;

    public AuthorizationResponse(String str) {
        this(str, null);
    }

    public AuthorizationResponse(String str, String str2) {
        this.mCode = str;
        this.mState = str2;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    public String getState() {
        return this.mState;
    }

    public void setState(String str) {
        this.mState = str;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtraParameters;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtraParameters = iterable;
    }
}
