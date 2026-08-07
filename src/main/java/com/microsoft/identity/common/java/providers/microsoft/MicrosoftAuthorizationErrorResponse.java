package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.providers.oauth2.AuthorizationErrorResponse;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftAuthorizationErrorResponse extends AuthorizationErrorResponse {
    public static final String AUTHORIZATION_FAILED = "authorization_failed";
    public static final String AUTHORIZATION_SERVER_INVALID_RESPONSE = "The authorization server returned an invalid response.";
    public static final String BROKER_NEEDS_TO_BE_INSTALLED = "broker_needs_to_be_installed";
    public static final String BROKER_NEEDS_TO_BE_INSTALLED_ERROR_DESCRIPTION = "Device needs to have broker installed";
    public static final String DEVICE_NEEDS_TO_BE_MANAGED = "device_needs_to_be_managed";
    public static final String DEVICE_NEEDS_TO_BE_MANAGED_ERROR_DESCRIPTION = "Device needs to be managed to access the resource";
    public static final String DEVICE_REGISTRATION_NEEDED = "device_registration_needed";
    public static final String DEVICE_REGISTRATION_NEEDED_ERROR_DESCRIPTION = "Device needs to be registered to access the resource";
    public static final String INSUFFICIENT_DEVICE_REGISTRATION = "insufficient_device_registration";
    public static final String INSUFFICIENT_DEVICE_REGISTRATION_ERROR_DESCRIPTION = "Device registration needs to be upgraded with strong keys";
    public static final String NULL_INTENT = "Received null intent";
    public static final String SDK_AUTH_CANCEL = "auth_cancelled_by_sdk";
    public static final String SDK_CANCELLED_FLOW = "Sdk cancelled the auth flow as the app launched a new interactive auth request.";
    public static final String STATE_NOT_RETURNED = "State is not returned";
    public static final String STATE_NOT_THE_SAME = "Returned state from authorize endpoint is not the same as the one sent";
    public static final String TIMED_OUT = "authorization_timed_out";
    public static final String TIMED_OUT_DESCRIPTION = "The authorization request timed out.";
    public static final String UNKNOWN_ERROR = "Unknown error";
    public static final String UNKNOWN_RESULT_CODE = "Unknown result code returned ";
    public static final String USER_CANCEL = "user_cancelled";
    public static final String USER_CANCELLED_FLOW = "User pressed device back button to cancel the flow.";

    public MicrosoftAuthorizationErrorResponse(String str, String str2) {
        super(str, str2);
    }
}
