package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAuthorizationResult extends MicrosoftAuthorizationResult<MicrosoftStsAuthorizationResponse, MicrosoftStsAuthorizationErrorResponse> {
    public MicrosoftStsAuthorizationResult(AuthorizationStatus authorizationStatus, MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse) {
        super(authorizationStatus, microsoftStsAuthorizationResponse);
    }

    public MicrosoftStsAuthorizationResult(AuthorizationStatus authorizationStatus, MicrosoftStsAuthorizationErrorResponse microsoftStsAuthorizationErrorResponse) {
        super(authorizationStatus, microsoftStsAuthorizationErrorResponse);
    }
}
