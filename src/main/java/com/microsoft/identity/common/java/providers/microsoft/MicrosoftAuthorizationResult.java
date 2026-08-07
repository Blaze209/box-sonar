package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: loaded from: classes14.dex */
public abstract class MicrosoftAuthorizationResult<GenericMicrosoftAuthorizationResponse extends MicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse> extends AuthorizationResult<GenericMicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse> {
    public MicrosoftAuthorizationResult(AuthorizationStatus authorizationStatus, GenericMicrosoftAuthorizationResponse genericmicrosoftauthorizationresponse) {
        super(genericmicrosoftauthorizationresponse, null);
        setAuthorizationStatus(authorizationStatus);
        setAuthorizationResponse(genericmicrosoftauthorizationresponse);
    }

    public MicrosoftAuthorizationResult(AuthorizationStatus authorizationStatus, GenericMicrosoftAuthorizationErrorResponse genericmicrosoftauthorizationerrorresponse) {
        super(null, genericmicrosoftauthorizationerrorresponse);
        setAuthorizationStatus(authorizationStatus);
        setAuthorizationErrorResponse(genericmicrosoftauthorizationerrorresponse);
    }
}
