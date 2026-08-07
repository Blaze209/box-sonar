package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.providers.oauth2.AuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AuthorizationResult<GenericAuthorizationResponse extends AuthorizationResponse, GenericAuthorizationErrorResponse extends AuthorizationErrorResponse> implements IResult {
    private GenericAuthorizationErrorResponse mAuthorizationErrorResponse;
    private GenericAuthorizationResponse mAuthorizationResponse;
    private AuthorizationStatus mAuthorizationStatus;
    private boolean mSuccess;

    public AuthorizationResult(GenericAuthorizationResponse genericauthorizationresponse, GenericAuthorizationErrorResponse genericauthorizationerrorresponse) {
        this.mSuccess = false;
        this.mAuthorizationResponse = genericauthorizationresponse;
        this.mAuthorizationErrorResponse = genericauthorizationerrorresponse;
        if (genericauthorizationresponse != null) {
            this.mSuccess = true;
        }
    }

    public AuthorizationResult(AuthorizationStatus authorizationStatus) {
        this.mSuccess = false;
        this.mAuthorizationStatus = authorizationStatus;
    }

    public AuthorizationResult() {
        this.mSuccess = false;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public boolean getSuccess() {
        return this.mSuccess;
    }

    public AuthorizationStatus getAuthorizationStatus() {
        return this.mAuthorizationStatus;
    }

    public GenericAuthorizationResponse getAuthorizationResponse() {
        return this.mAuthorizationResponse;
    }

    public GenericAuthorizationErrorResponse getAuthorizationErrorResponse() {
        return this.mAuthorizationErrorResponse;
    }

    protected void setAuthorizationErrorResponse(GenericAuthorizationErrorResponse genericauthorizationerrorresponse) {
        this.mAuthorizationErrorResponse = genericauthorizationerrorresponse;
    }

    protected void setAuthorizationResponse(GenericAuthorizationResponse genericauthorizationresponse) {
        this.mAuthorizationResponse = genericauthorizationresponse;
    }

    protected void setAuthorizationStatus(AuthorizationStatus authorizationStatus) {
        this.mAuthorizationStatus = authorizationStatus;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public IErrorResponse getErrorResponse() {
        return this.mAuthorizationErrorResponse;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public ISuccessResponse getSuccessResponse() {
        return this.mAuthorizationResponse;
    }
}
