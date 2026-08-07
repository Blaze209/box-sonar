package com.microsoft.identity.common.java.controllers;

import com.google.gson.JsonSyntaxException;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.constants.OAuth2ErrorCode;
import com.microsoft.identity.common.java.constants.OAuth2SubErrorCode;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.DeviceRegistrationRequiredException;
import com.microsoft.identity.common.java.exception.InsufficientDeviceRegistrationException;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.StrongDeviceRegistrationRequiredException;
import com.microsoft.identity.common.java.exception.TerminalException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.telemetry.CliTelemInfo;
import com.microsoft.identity.common.java.util.HeaderSerializationUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import io.opentelemetry.api.trace.Span;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
public class ExceptionAdapter {
    private static final String TAG = "ExceptionAdapter";

    public static BaseException exceptionFromAcquireTokenResult(AcquireTokenResult acquireTokenResult, CommandParameters commandParameters) {
        AuthorizationResult authorizationResult = acquireTokenResult.getAuthorizationResult();
        if (authorizationResult != null) {
            if (!authorizationResult.getSuccess()) {
                return exceptionFromAuthorizationResult(authorizationResult, commandParameters);
            }
        } else {
            Logger.warn(TAG + ":exceptionFromAcquireTokenResult", "AuthorizationResult was null -- expected for ATS cases.");
        }
        return exceptionFromTokenResult(acquireTokenResult.getTokenResult(), commandParameters);
    }

    public static BaseException exceptionFromAuthorizationResult(AuthorizationResult authorizationResult, CommandParameters commandParameters) {
        if (authorizationResult == null) {
            throw new NullPointerException("authorizationResult is marked non-null but is null");
        }
        String str = TAG + ":exceptionFromAuthorizationResult";
        AuthorizationErrorResponse authorizationErrorResponse = authorizationResult.getAuthorizationErrorResponse();
        if (authorizationErrorResponse == null) {
            Logger.warn(str, "AuthorizationErrorResponse is not set");
            return new ClientException(ClientException.AUTHORIZATION_RESULT_NULL_ERROR_RESPONSE, "Authorization error response is null. Authorization Status: " + authorizationResult.getAuthorizationStatus());
        }
        int i = AnonymousClass1.$SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus[authorizationResult.getAuthorizationStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new ClientException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription());
            }
            if (i == 3) {
                return new UserCancelException();
            }
            Logger.warn(str, "No AuthorizationResult status set");
            return new ClientException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription());
        }
        if (authorizationErrorResponse instanceof MicrosoftAuthorizationErrorResponse) {
            MicrosoftAuthorizationErrorResponse microsoftAuthorizationErrorResponse = (MicrosoftAuthorizationErrorResponse) authorizationErrorResponse;
            if (MicrosoftAuthorizationErrorResponse.DEVICE_REGISTRATION_NEEDED.equals(microsoftAuthorizationErrorResponse.getError())) {
                if (microsoftAuthorizationErrorResponse.isTokenProtectionRequired()) {
                    return new StrongDeviceRegistrationRequiredException(microsoftAuthorizationErrorResponse.getError(), microsoftAuthorizationErrorResponse.getErrorDescription(), microsoftAuthorizationErrorResponse.getUpnToWpj());
                }
                return new DeviceRegistrationRequiredException(microsoftAuthorizationErrorResponse.getError(), microsoftAuthorizationErrorResponse.getErrorDescription(), microsoftAuthorizationErrorResponse.getUpnToWpj());
            }
            if (MicrosoftAuthorizationErrorResponse.INSUFFICIENT_DEVICE_REGISTRATION.equals(microsoftAuthorizationErrorResponse.getError())) {
                return new InsufficientDeviceRegistrationException(microsoftAuthorizationErrorResponse.getError(), microsoftAuthorizationErrorResponse.getErrorDescription(), microsoftAuthorizationErrorResponse.getUpnToWpj());
            }
        }
        return new ServiceException(authorizationErrorResponse.getError(), authorizationErrorResponse.getErrorDescription(), 0, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.controllers.ExceptionAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus;

        static {
            int[] iArr = new int[AuthorizationStatus.values().length];
            $SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus = iArr;
            try {
                iArr[AuthorizationStatus.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus[AuthorizationStatus.SDK_CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$providers$oauth2$AuthorizationStatus[AuthorizationStatus.USER_CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static ServiceException exceptionFromTokenResult(TokenResult tokenResult, CommandParameters commandParameters) {
        if (tokenResult != null && !tokenResult.getSuccess() && tokenResult.getErrorResponse() != null && !StringUtil.isNullOrEmpty(tokenResult.getErrorResponse().getError())) {
            ServiceException exceptionFromTokenErrorResponse = getExceptionFromTokenErrorResponse(commandParameters, tokenResult.getErrorResponse());
            applyCliTelemInfo(tokenResult.getCliTelemInfo(), exceptionFromTokenErrorResponse);
            return exceptionFromTokenErrorResponse;
        }
        Logger.warn(TAG + ":exceptionFromTokenResult", "Unknown error, Token result is null [" + (tokenResult == null) + "]");
        return new ServiceException("unknown_error", "Request failed, but no error returned back from service.", null);
    }

    private static boolean shouldBeConvertedToUiRequiredException(String str) {
        return "invalid_grant".equalsIgnoreCase(str) || OAuth2ErrorCode.INTERACTION_REQUIRED.equalsIgnoreCase(str);
    }

    static ServiceException getExceptionFromTokenErrorResponse(TokenErrorResponse tokenErrorResponse) {
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        return getExceptionFromTokenErrorResponse(tokenErrorResponse, true);
    }

    static ServiceException getExceptionFromTokenErrorResponse(TokenErrorResponse tokenErrorResponse, boolean z) {
        ServiceException serviceException;
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        if (z && shouldBeConvertedToUiRequiredException(tokenErrorResponse.getError())) {
            serviceException = new UiRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription());
        } else {
            serviceException = new ServiceException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), null);
        }
        serviceException.setSubErrorCode(tokenErrorResponse.getSubError());
        setHttpResponseUsingTokenErrorResponse(serviceException, tokenErrorResponse);
        return serviceException;
    }

    public static ServiceException convertToNativeAuthException(ServiceException serviceException) {
        String str;
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        if (isNativeAuthenticationMFAException(serviceException)) {
            str = "Multi-factor authentication is required, which can't be fulfilled as part of this flow. Please sign out and perform a new sign in operation. Please see exception details for more information.";
        } else if (!isNativeAuthenticationResetPasswordRequiredException(serviceException)) {
            str = "";
        } else {
            str = "User password change is required, which can't be fulfilled as part of this flow.Please reset the password and perform a new sign in operation. Please see exception details for more information.";
        }
        ServiceException serviceException2 = new ServiceException(serviceException.getErrorCode(), str + serviceException.getMessage(), serviceException.getHttpStatusCode(), serviceException);
        serviceException2.setSubErrorCode(serviceException.getSubErrorCode());
        serviceException2.setHttpResponseHeaders(serviceException.getHttpResponseHeaders());
        serviceException2.setHttpResponseBody(serviceException.getHttpResponseBody());
        return serviceException2;
    }

    public static ServiceException getExceptionFromTokenErrorResponse(CommandParameters commandParameters, TokenErrorResponse tokenErrorResponse) {
        IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException;
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        if (isIntunePolicyRequiredError(tokenErrorResponse)) {
            if (isBrokerTokenCommandParameters(commandParameters)) {
                if (commandParameters instanceof BrokerInteractiveTokenCommandParameters) {
                    intuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), (BrokerInteractiveTokenCommandParameters) commandParameters);
                } else {
                    intuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(tokenErrorResponse.getError(), tokenErrorResponse.getErrorDescription(), (BrokerSilentTokenCommandParameters) commandParameters);
                }
                intuneAppProtectionPolicyRequiredException.setSubErrorCode(tokenErrorResponse.getSubError());
                setHttpResponseUsingTokenErrorResponse(intuneAppProtectionPolicyRequiredException, tokenErrorResponse);
                return intuneAppProtectionPolicyRequiredException;
            }
            Logger.warn(TAG, "In order to properly construct the IntuneAppProtectionPolicyRequiredException we need the command parameters to be supplied.  Returning as service exception instead.");
            return getExceptionFromTokenErrorResponse(tokenErrorResponse);
        }
        if (commandParameters instanceof BrokerSilentTokenCommandParameters) {
            return getExceptionFromTokenErrorResponse(tokenErrorResponse, !((BrokerSilentTokenCommandParameters) commandParameters).isRequestForResourceAccount());
        }
        return getExceptionFromTokenErrorResponse(tokenErrorResponse);
    }

    private static void setHttpResponseUsingTokenErrorResponse(ServiceException serviceException, TokenErrorResponse tokenErrorResponse) {
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        if (tokenErrorResponse == null) {
            throw new NullPointerException("errorResponse is marked non-null but is null");
        }
        try {
            serviceException.setHttpResponse(synthesizeHttpResponse(tokenErrorResponse.getStatusCode(), tokenErrorResponse.getResponseHeadersJson(), tokenErrorResponse.getResponseBody()));
        } catch (JSONException unused) {
            Logger.warn(TAG, "Failed to deserialize error data: status, headers, response body.");
        }
    }

    private static boolean isBrokerTokenCommandParameters(CommandParameters commandParameters) {
        return (commandParameters instanceof BrokerSilentTokenCommandParameters) || (commandParameters instanceof BrokerInteractiveTokenCommandParameters);
    }

    public static void applyCliTelemInfo(CliTelemInfo cliTelemInfo, BaseException baseException) {
        if (baseException == null) {
            throw new NullPointerException("outErr is marked non-null but is null");
        }
        if (cliTelemInfo != null) {
            baseException.setSpeRing(cliTelemInfo.getSpeRing());
            baseException.setRefreshTokenAge(cliTelemInfo.getRefreshTokenAge());
            baseException.setCliTelemErrorCode(cliTelemInfo.getServerErrorCode());
            baseException.setCliTelemSubErrorCode(cliTelemInfo.getServerSubErrorCode());
        }
    }

    private static HttpResponse synthesizeHttpResponse(int i, String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            return new HttpResponse(i, str2, HeaderSerializationUtil.fromJson(str));
        } catch (JsonSyntaxException unused) {
            Logger.warn(TAG + ":applyHttpErrorResponseData", "Failed to deserialize error data: status, headers, response body.");
            return null;
        }
    }

    public static BaseException baseExceptionFromException(Throwable th) {
        if ((th instanceof ExecutionException) && th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof BaseException) {
            return (BaseException) th;
        }
        return clientExceptionFromException(th);
    }

    public static ClientException clientExceptionFromException(Throwable th) {
        if (th == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        if (th instanceof ClientException) {
            return (ClientException) th;
        }
        Throwable cause = (!(th instanceof ExecutionException) || th.getCause() == null) ? th : th.getCause();
        if (cause instanceof TerminalException) {
            String errorCode = ((TerminalException) cause).getErrorCode();
            Throwable cause2 = th.getCause();
            if (cause2 != null) {
                cause = cause2;
            }
            return new ClientException(errorCode, "An unhandled exception occurred with message: " + cause.getMessage(), cause);
        }
        if (cause instanceof IOException) {
            return new ClientException("io_error", "An IO error occurred with message: " + cause.getMessage(), cause);
        }
        if (cause instanceof InterruptedException) {
            return new ClientException(ClientException.INTERRUPTED_OPERATION, "SDK cancelled operation, the thread execution was interrupted", cause);
        }
        if (cause instanceof TimeoutException) {
            return new ClientException(ClientException.TIMED_OUT, "A blocking operation has timed out: " + cause.getMessage(), cause);
        }
        if (cause instanceof NullPointerException) {
            return new ClientException(ClientException.NULL_POINTER_ERROR, cause.getMessage(), cause);
        }
        if (cause instanceof OutOfMemoryError) {
            String str = TAG;
            Logger.warn(str, "Received an out of memory error, attempting to attach stacktrace...");
            try {
                Span spanCurrent = SpanExtension.current();
                spanCurrent.setAttribute(AttributeName.out_of_memory_exception_stacktrace.name(), StringUtil.getStacktraceAsStringFromElementArray(cause.getStackTrace()));
                Logger.warn(str, "Received an out of memory error, stacktrace attached to span with id: " + spanCurrent.getSpanContext().getSpanId());
            } catch (Throwable unused) {
                Logger.warn(TAG, "Failed to emit telemetry for out of memory exception.");
            }
            return new ClientException(ClientException.OUT_OF_MEMORY, cause.getMessage(), cause);
        }
        if (cause instanceof GeneralSecurityException) {
            if (cause instanceof CertificateException) {
                return new ClientException(ClientException.CERTIFICATE_LOAD_FAILURE, cause.getMessage(), cause);
            }
            if (cause instanceof KeyStoreException) {
                return new ClientException(ClientException.KEYSTORE_NOT_INITIALIZED, cause.getMessage(), cause);
            }
            if (cause instanceof NoSuchAlgorithmException) {
                return new ClientException("no_such_algorithm", cause.getMessage(), cause);
            }
            if (cause instanceof InvalidAlgorithmParameterException) {
                return new ClientException(ClientException.INVALID_ALG_PARAMETER, cause.getMessage(), cause);
            }
            if (cause instanceof UnrecoverableEntryException) {
                return new ClientException(ClientException.INVALID_PROTECTION_PARAMS, cause.getMessage(), cause);
            }
            if (cause instanceof InvalidKeyException) {
                return new ClientException(ClientException.INVALID_KEY, cause.getMessage(), cause);
            }
        }
        return new ClientException("unknown_error", cause.getMessage(), cause);
    }

    private static boolean isIntunePolicyRequiredError(TokenErrorResponse tokenErrorResponse) {
        if (tokenErrorResponse != null) {
            return !StringUtil.isNullOrEmpty(tokenErrorResponse.getError()) && !StringUtil.isNullOrEmpty(tokenErrorResponse.getSubError()) && tokenErrorResponse.getError().equalsIgnoreCase("unauthorized_client") && tokenErrorResponse.getSubError().equalsIgnoreCase(OAuth2SubErrorCode.PROTECTION_POLICY_REQUIRED);
        }
        throw new NullPointerException("errorResponse is marked non-null but is null");
    }

    private static boolean isNativeAuthenticationMFAException(ServiceException serviceException) {
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        return doesExceptionContainsErrorCode(50076, serviceException);
    }

    private static boolean isNativeAuthenticationResetPasswordRequiredException(ServiceException serviceException) {
        if (serviceException == null) {
            throw new NullPointerException("exception is marked non-null but is null");
        }
        return doesExceptionContainsErrorCode(50142, serviceException);
    }

    private static boolean doesExceptionContainsErrorCode(int i, ServiceException serviceException) {
        if (serviceException != null) {
            return serviceException.getCliTelemErrorCode() != null && serviceException.getCliTelemErrorCode().equalsIgnoreCase(String.valueOf(i));
        }
        throw new NullPointerException("exception is marked non-null but is null");
    }
}
