package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.net.URI;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAuthorizationResultFactory extends AuthorizationResultFactory<AzureActiveDirectoryAuthorizationResult, AzureActiveDirectoryAuthorizationRequest> {
    private static final String TAG = "AzureActiveDirectoryAuthorizationResultFactory";

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    protected /* bridge */ /* synthetic */ AuthorizationResult validateAndCreateAuthorizationResult(Map map, String str, String str2) {
        return validateAndCreateAuthorizationResult((Map<String, String>) map, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public AzureActiveDirectoryAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2) {
        return new AzureActiveDirectoryAuthorizationResult(authorizationStatus, new AzureActiveDirectoryAuthorizationErrorResponse(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public AzureActiveDirectoryAuthorizationResult parseRedirectUriAndCreateAuthorizationResult(URI uri, String str) {
        Map<String, String> parameters = UrlUtil.getParameters(uri);
        if (parameters == null || parameters.isEmpty()) {
            Logger.warn(TAG, "Invalid server response, empty query string from the webview redirect.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
        }
        String str2 = parameters.get("correlation_id");
        if (parameters.containsKey("code")) {
            return validateAndCreateAuthorizationResult(parameters, str, str2);
        }
        if (!parameters.containsKey("error")) {
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
        }
        return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, parameters.get("error"), parameters.get("error_description"), parameters.get("error_codes"), str2);
    }

    private AzureActiveDirectoryAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2, String str3, String str4) {
        String str5 = TAG + ":createAuthorizationResultWithErrorResponse";
        Logger.info(str5, str4, "Error is returned from webview redirect");
        Logger.infoPII(str5, str4, "error: " + str + " errorDescription: " + str2);
        AzureActiveDirectoryAuthorizationErrorResponse azureActiveDirectoryAuthorizationErrorResponse = new AzureActiveDirectoryAuthorizationErrorResponse(str, str2);
        azureActiveDirectoryAuthorizationErrorResponse.setErrorCodes(str3);
        return new AzureActiveDirectoryAuthorizationResult(authorizationStatus, azureActiveDirectoryAuthorizationErrorResponse);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    protected AzureActiveDirectoryAuthorizationResult validateAndCreateAuthorizationResult(Map<String, String> map, String str, String str2) {
        String str3 = TAG + ":validateAndCreateAuthorizationResult";
        String str4 = map.get("state");
        String str5 = map.get("code");
        if (StringUtil.isNullOrEmpty(str4)) {
            Logger.warn(str3, str2, "State parameter is not returned from the webview redirect.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_RETURNED);
        }
        if (StringUtil.isNullOrEmpty(str) || !str.equals(str4)) {
            Logger.warn(str3, str2, "State parameter returned from the redirect is not same as the one sent in request.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_THE_SAME);
        }
        Logger.info(str3, str2, "Auth code is successfully returned from webview redirect.");
        AzureActiveDirectoryAuthorizationResponse azureActiveDirectoryAuthorizationResponse = new AzureActiveDirectoryAuthorizationResponse(str5, str4);
        azureActiveDirectoryAuthorizationResponse.setCorrelationId(str2);
        return new AzureActiveDirectoryAuthorizationResult(AuthorizationStatus.SUCCESS, azureActiveDirectoryAuthorizationResponse);
    }
}
