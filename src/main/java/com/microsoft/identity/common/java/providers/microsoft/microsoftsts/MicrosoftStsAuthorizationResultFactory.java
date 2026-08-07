package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.AuthenticationConstants;
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
public class MicrosoftStsAuthorizationResultFactory extends AuthorizationResultFactory<MicrosoftStsAuthorizationResult, MicrosoftStsAuthorizationRequest> {
    private static final String TAG = "MicrosoftStsAuthorizationResultFactory";

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    protected /* bridge */ /* synthetic */ AuthorizationResult validateAndCreateAuthorizationResult(Map map, String str, String str2) {
        return validateAndCreateAuthorizationResult((Map<String, String>) map, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2) {
        if (str == null) {
            throw new NullPointerException("error is marked non-null but is null");
        }
        String str3 = TAG + ":createAuthorizationResultWithErrorResponse";
        Logger.info(str3, "Error is returned from webview redirect");
        Logger.infoPII(str3, "error: " + str + " errorDescription: " + str2);
        return new MicrosoftStsAuthorizationResult(authorizationStatus, new MicrosoftStsAuthorizationErrorResponse(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    public MicrosoftStsAuthorizationResult parseRedirectUriAndCreateAuthorizationResult(URI uri, String str) {
        if (uri == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        String str2 = TAG + ":parseUrlAndCreateAuthorizationResponse";
        Map<String, String> parameters = UrlUtil.getParameters(uri);
        if (parameters.isEmpty()) {
            Logger.warn(str2, "Invalid server response, empty query string from the webview redirect.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
        }
        if (parameters.containsKey("code")) {
            return validateAndCreateAuthorizationResult(parameters, str, (String) null);
        }
        if (parameters.containsKey("error")) {
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, parameters.get("error"), parameters.get(AuthenticationConstants.OAuth2.ERROR_SUBCODE), parameters.get("error_description"));
        }
        return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
    }

    private MicrosoftStsAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2, String str3) {
        String str4 = TAG + ":createAuthorizationResultWithErrorResponse";
        Logger.info(str4, "Error is returned from webview redirect");
        Logger.infoPII(str4, "error: " + str + "error subcode:" + str2 + " errorDescription: " + str3);
        return new MicrosoftStsAuthorizationResult(authorizationStatus, new MicrosoftStsAuthorizationErrorResponse(str, str2, str3));
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory
    protected MicrosoftStsAuthorizationResult validateAndCreateAuthorizationResult(Map<String, String> map, String str, String str2) {
        if (map == null) {
            throw new NullPointerException("urlParameters is marked non-null but is null");
        }
        String str3 = TAG + ":validateAndCreateAuthorizationResult";
        String str4 = map.get("state");
        String str5 = map.get("code");
        if (StringUtil.isNullOrEmpty(str4)) {
            Logger.warn(str3, "State parameter is not returned from the webview redirect.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_RETURNED);
        }
        if (StringUtil.isNullOrEmpty(str) || !str.equals(str4)) {
            Logger.warn(str3, "State parameter returned from the redirect is not same as the one sent in request.");
            return createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, "state_mismatch", MicrosoftAuthorizationErrorResponse.STATE_NOT_THE_SAME);
        }
        Logger.info(str3, "Auth code is successfully returned from webview redirect.");
        return new MicrosoftStsAuthorizationResult(AuthorizationStatus.SUCCESS, new MicrosoftStsAuthorizationResponse(str5, str4, map));
    }
}
