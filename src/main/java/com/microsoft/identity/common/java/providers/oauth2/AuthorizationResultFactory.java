package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.RawAuthorizationResult;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.net.URI;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AuthorizationResultFactory<GenericAuthorizationResult extends AuthorizationResult, GenericAuthorizationRequest extends AuthorizationRequest> {
    private static final String TAG = "AuthorizationResultFactory";

    protected abstract GenericAuthorizationResult createAuthorizationResultWithErrorResponse(AuthorizationStatus authorizationStatus, String str, String str2);

    protected abstract GenericAuthorizationResult parseRedirectUriAndCreateAuthorizationResult(URI uri, String str);

    protected abstract GenericAuthorizationResult validateAndCreateAuthorizationResult(Map<String, String> map, String str, String str2);

    public GenericAuthorizationResult createAuthorizationResult(RawAuthorizationResult rawAuthorizationResult, GenericAuthorizationRequest genericauthorizationrequest) {
        if (rawAuthorizationResult == null) {
            throw new NullPointerException("data is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        String str = TAG + ":createAuthorizationResult";
        URI authorizationFinalUri = rawAuthorizationResult.getAuthorizationFinalUri();
        switch (AnonymousClass1.$SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[rawAuthorizationResult.getResultCode().ordinal()]) {
            case 1:
                Logger.info(str, null, "The authorization request was intentionally cancelled.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.USER_CANCEL, MicrosoftAuthorizationErrorResponse.USER_CANCEL, MicrosoftAuthorizationErrorResponse.USER_CANCELLED_FLOW);
            case 2:
                Logger.info(str, null, "SDK cancelled the authorization request.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.SDK_CANCEL, MicrosoftAuthorizationErrorResponse.SDK_AUTH_CANCEL, MicrosoftAuthorizationErrorResponse.SDK_CANCELLED_FLOW);
            case 3:
                if (authorizationFinalUri == null) {
                    Logger.warn(str, null, "returned URL is null or empty.");
                    return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_FAILED, MicrosoftAuthorizationErrorResponse.AUTHORIZATION_SERVER_INVALID_RESPONSE);
                }
                return (GenericAuthorizationResult) parseRedirectUriAndCreateAuthorizationResult(authorizationFinalUri, genericauthorizationrequest.getState());
            case 4:
                BaseException exception = rawAuthorizationResult.getException();
                if (exception != null) {
                    return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, exception.getErrorCode(), exception.getMessage());
                }
                break;
            case 5:
                break;
            case 6:
                Logger.info(str, "Device Registration needed, need to start WPJ");
                GenericAuthorizationResult genericauthorizationresult = (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED, MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED_ERROR_DESCRIPTION);
                Map<String, String> parameters = UrlUtil.getParameters(authorizationFinalUri);
                genericauthorizationresult.getAuthorizationErrorResponse().setUpnToWpj(parameters.get("username"));
                genericauthorizationresult.getAuthorizationErrorResponse().setTokenProtectionRequired(Boolean.parseBoolean(parameters.get(AuthenticationConstants.AAD.TOKEN_PROTECTION_REQUIRED_KEY)));
                return genericauthorizationresult;
            case 7:
                Logger.info(str, "MDM required. Launching Intune MDM link on browser.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.DEVICE_NEEDS_TO_BE_MANAGED, MicrosoftAuthorizationErrorResponse.DEVICE_NEEDS_TO_BE_MANAGED_ERROR_DESCRIPTION);
            case 8:
                Logger.info(str, "Insufficient Device Registration, need to perform update WPJ with hardware backed keys");
                GenericAuthorizationResult genericauthorizationresult2 = (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.INSUFFICIENT_DEVICE_REGISTRATION, MicrosoftAuthorizationErrorResponse.INSUFFICIENT_DEVICE_REGISTRATION_ERROR_DESCRIPTION);
                genericauthorizationresult2.getAuthorizationErrorResponse().setUpnToWpj(UrlUtil.getParameters(authorizationFinalUri).get("username"));
                return genericauthorizationresult2;
            case 9:
                Logger.info(str, null, "The authorization request was intentionally cancelled.");
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.TIMED_OUT, MicrosoftAuthorizationErrorResponse.TIMED_OUT, MicrosoftAuthorizationErrorResponse.TIMED_OUT_DESCRIPTION);
            default:
                return (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR, "Unknown result code returned [" + rawAuthorizationResult.getResultCode() + "]");
        }
        Logger.info(str, "Device needs to have broker installed, we expect the apps to call usback when the broker is installed");
        GenericAuthorizationResult genericauthorizationresult3 = (GenericAuthorizationResult) createAuthorizationResultWithErrorResponse(AuthorizationStatus.FAIL, MicrosoftAuthorizationErrorResponse.BROKER_NEEDS_TO_BE_INSTALLED, MicrosoftAuthorizationErrorResponse.BROKER_NEEDS_TO_BE_INSTALLED_ERROR_DESCRIPTION);
        genericauthorizationresult3.getAuthorizationErrorResponse().setUpnToWpj(UrlUtil.getParameters(authorizationFinalUri).get("username"));
        return genericauthorizationresult3;
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode;

        static {
            int[] iArr = new int[RawAuthorizationResult.ResultCode.values().length];
            $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode = iArr;
            try {
                iArr[RawAuthorizationResult.ResultCode.CANCELLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.SDK_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.NON_OAUTH_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.BROKER_INSTALLATION_TRIGGERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.DEVICE_REGISTRATION_REQUIRED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.MDM_FLOW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.INSUFFICIENT_DEVICE_REGISTRATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$RawAuthorizationResult$ResultCode[RawAuthorizationResult.ResultCode.TIMED_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
