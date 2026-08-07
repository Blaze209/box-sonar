package com.microsoft.identity.client.exception;

import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class MsalDeclinedScopeException extends MsalException {
    private List<String> mDeclinedScopes;
    private List<String> mGrantedScopes;
    private AcquireTokenSilentParameters mSilentParametersForGrantedScopes;

    public MsalDeclinedScopeException(List<String> list, List<String> list2, AcquireTokenSilentParameters acquireTokenSilentParameters) {
        super(ErrorStrings.DECLINED_SCOPE_ERROR_CODE, ErrorStrings.DECLINED_SCOPE_ERROR_MESSAGE);
        this.mGrantedScopes = list;
        this.mDeclinedScopes = list2;
        this.mSilentParametersForGrantedScopes = acquireTokenSilentParameters;
    }

    public List<String> getGrantedScopes() {
        return this.mGrantedScopes;
    }

    public List<String> getDeclinedScopes() {
        return this.mDeclinedScopes;
    }

    public AcquireTokenSilentParameters getSilentParametersForGrantedScopes() {
        return this.mSilentParametersForGrantedScopes;
    }
}
