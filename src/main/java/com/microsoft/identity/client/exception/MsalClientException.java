package com.microsoft.identity.client.exception;

/* JADX INFO: loaded from: classes14.dex */
public final class MsalClientException extends MsalException {
    static final String ADFS_AUTHORITY_VALIDATION_FAILED = "adfs_authority_validation_failed";
    public static final String APP_MANIFEST_VALIDATION_ERROR = "app_manifest_validation_error";
    public static final String AUTHORITY_VALIDATION_NOT_SUPPORTED = "authority_validation_not_supported";
    public static final String BROKER_BIND_FAILURE = "Failed to bind the service in broker app";
    public static final String BROKER_NOT_INSTALLED = "broker_not_installed";
    public static final String CHROME_NOT_INSTALLED = "chrome_not_installed";
    public static final String CURRENT_ACCOUNT_MISMATCH = "current_account_mismatch";
    public static final String CURRENT_ACCOUNT_MISMATCH_ERROR_MESSAGE = "The signed in account does not match with the provided account.";
    public static final String DEVICE_NETWORK_NOT_AVAILABLE = "device_network_not_available";
    public static final String DUPLICATE_COMMAND = "duplicate_command";
    public static final String DUPLICATE_QUERY_PARAMETER = "duplicate_query_parameter";
    public static final String INVALID_JWT = "invalid_jwt";
    public static final String INVALID_PARAMETER = "invalid_parameter";
    public static final String IO_ERROR = "io_error";
    public static final String JSON_PARSE_FAILURE = "json_parse_failure";
    public static final String MALFORMED_URL = "malformed_url";
    public static final String MULTIPLE_APPS_LISTENING_CUSTOM_URL_SCHEME = "multiple_apps_listening_url_scheme";
    public static final String MULTIPLE_MATCHING_TOKENS_DETECTED = "multiple_matching_tokens_detected";
    public static final String NATIVE_AUTH_APPLICATION_CREATION_UNKNOWN_ERROR_MESSAGE = "Unexpected error while initializing PCA.";
    public static final String NATIVE_AUTH_ATTEMPTING_TO_USE_BROKER_ERROR_CODE = "native_auth_attempting_to_use_broker";
    public static final String NATIVE_AUTH_ATTEMPTING_TO_USE_BROKER_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot use broker";
    public static final String NATIVE_AUTH_EMPTY_CHALLENGE_TYPE_ERROR_CODE = "native_auth_empty_challenge_type";
    public static final String NATIVE_AUTH_EMPTY_CHALLENGE_TYPE_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used without challenge types";
    public static final String NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_CODE = "native_auth_invalid_account_mode_config";
    public static final String NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_MESSAGE = "NativeAuthPublicClientApplication Native auth apps cannot be used with anything other than SINGLE account mode";
    public static final String NATIVE_AUTH_INVALID_CAPABILITY_ERROR_CODE = "native_auth_invalid_capability";
    public static final String NATIVE_AUTH_INVALID_CAPABILITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication detected invalid capability.";
    public static final String NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_CODE = "native_auth_invalid_challenge_type";
    public static final String NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_MESSAGE = "NativeAuthPublicClientApplication detected invalid challenge type.";
    public static final String NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_CODE = "native_auth_invalid_ciam_authority";
    public static final String NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can only be used with a valid CIAM Authority";
    public static final String NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_CODE = "native_auth_shared_device_mode";
    public static final String NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used in shared device mode";
    public static final String NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_CODE = "native_auth_use_without_client_id";
    public static final String NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used without a client ID";
    public static final String NATIVE_AUTH_USE_WITHOUT_TENANT_ERROR_CODE = "native_auth_use_without_tenant";
    public static final String NATIVE_AUTH_USE_WITHOUT_TENANT_ERROR_MESSAGE = "NativeAuthPublicClientApplication cannot be used without a tenant";
    public static final String NATIVE_AUTH_USE_WITH_BAD_REDIRECT_URI_ERROR_CODE = "native_auth_use_with_bad_redirect_uri";
    public static final String NATIVE_AUTH_USE_WITH_BAD_REDIRECT_URI_ERROR_MESSAGE = "NativeAuthPublicClientApplication was given an empty or invalid redirect uri";
    public static final String NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_CODE = "native_auth_use_with_multi_authority";
    public static final String NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used with multiple authorities";
    public static final String NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_CODE = "native_auth_use_with_no_authority";
    public static final String NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_MESSAGE = "NativeAuthPublicClientApplication can't be used with no authority.";
    public static final String NOT_ELIGIBLE_TO_USE_BROKER = "not_eligible_to_use_broker";
    public static final String NO_CURRENT_ACCOUNT = "no_current_account";
    public static final String NO_CURRENT_ACCOUNT_ERROR_MESSAGE = "There is no signed in account.";
    public static final String NO_SUCH_ALGORITHM = "no_such_algorithm";
    public static final String REDIRECT_URI_VALIDATION_ERROR = "redirect_uri_validation_error";
    public static final String SAPCA_USE_WITH_MULTI_POLICY_B2C = "SingleAccountPublicClientApplication cannot be used with multiple B2C policies.";
    public static final String SCOPE_EMPTY_OR_NULL = "scope_empty_or_null";
    public static final String STATE_MISMATCH = "state_mismatch";
    public static final String UNKNOWN_AUTHORITY = "unknown_authority";
    public static final String UNKNOWN_ERROR = "unknown_error";
    public static final String UNSUPPORTED_ENCODING = "unsupported_encoding";
    public static final String UNSUPPORTED_URL = "unsupported_url";
    public static final String USER_MISMATCH = "user_mismatch";

    public MsalClientException(String str) {
        super(str);
    }

    public MsalClientException(String str, String str2) {
        super(str, str2);
    }

    public MsalClientException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }
}
