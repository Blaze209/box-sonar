package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAuthorizationResult extends MicrosoftAuthorizationResult<AzureActiveDirectoryAuthorizationResponse, AzureActiveDirectoryAuthorizationErrorResponse> {
    public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus authorizationStatus, AzureActiveDirectoryAuthorizationResponse azureActiveDirectoryAuthorizationResponse) {
        super(authorizationStatus, azureActiveDirectoryAuthorizationResponse);
    }

    public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus authorizationStatus, AzureActiveDirectoryAuthorizationErrorResponse azureActiveDirectoryAuthorizationErrorResponse) {
        super(authorizationStatus, azureActiveDirectoryAuthorizationErrorResponse);
    }
}
