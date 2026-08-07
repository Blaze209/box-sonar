package com.microsoft.identity.common.java.exception;

/* JADX INFO: loaded from: classes14.dex */
public class ClientException extends BaseException {
    public static final String ACCESS_DENIED = "access_denied";
    public static final String ACCOUNT_MANAGER_FAILED = "account_manager_failed";
    public static final String ACCOUNT_MANAGER_OPERATION_ERROR = "account_manager_operation_error";
    public static final String ACCOUNT_NOT_FOUND = "account_not_found";
    static final String ADFS_AUTHORITY_VALIDATION_FAILED = "adfs_authority_validation_failed";
    public static final String ANDROID_KEYSTORE_UNAVAILABLE = "android_keystore_unavailable";
    public static final String AUTHORITY_VALIDATION_NOT_SUPPORTED = "authority_validation_not_supported";
    public static final String AUTHORIZATION_RESULT_NULL_ERROR_RESPONSE = "authorization_result_null_error_response";
    public static final String AUTH_SCHEME_MISMATCH = "auth_scheme_mismatch";
    public static final String AUTH_SCHEME_NOT_SUPPORTED = "auth_scheme_not_supported";
    public static final String BAD_KEY_SIZE = "keystore_produced_invalid_cert";
    public static final String BAD_PADDING = "bad_padding";
    public static final String BOUND_SERVICE_UNAVAILABLE_OR_NOT_SUPPORTED = "bound_service_unavaliable_or_not_supported";
    public static final String BROKER_VERIFICATION_FAILED_ERROR = "broker_app_verification_failed";
    public static final String BRT_TENANT_MISMATCH = "brt_tenant_mismatch";
    public static final String CERTIFICATE_LOAD_FAILURE = "certificate_load_failure";
    public static final String CHROME_NOT_INSTALLED = "chrome_not_installed";
    public static final String CLIENT_UPDATE_REQUIRED = "client_update_required";
    public static final String DATA_MALFORMED = "data_malformed";
    public static final String DECRYPTION_FAILURE = "failed_to_decrypt";
    public static final String DEVICE_NETWORK_NOT_AVAILABLE = "device_network_not_available";
    public static final String DEVICE_NOT_SUPPORT_HARDWARE_WRAPPED_KEY_IMPORT = "device_not_supported_hardware_wrapped_key_import";
    public static final String DEVICE_TOKEN_EMPTY_OR_NULL = "device_token_empty_or_null";
    public static final String DUPLICATE_COMMAND = "duplicate_command";
    public static final String DUPLICATE_QUERY_PARAMETER = "duplicate_query_parameter";
    public static final String ENVIRONMENT_NOT_PRESENT = "environment_token_not_present";
    public static final String EXECUTOR_ERROR = "executor_error";
    public static final String HMAC_MISMATCH = "hmac_mismatch";
    public static final String INSTALL_CERT_ERROR = "install_cert_error";
    public static final String INTERRUPTED_OPERATION = "operation_interrupted";
    public static final String INVALID_ALG = "keystore_initialization_failed";
    public static final String INVALID_ALG_PARAMETER = "invalid_algorithm_parameter";
    public static final String INVALID_BLOCK_SIZE = "invalid_block_size";
    public static final String INVALID_BROKER_BUNDLE = "invalid_broker_bundle";
    public static final String INVALID_CERTIFICATE_REQUEST = "invalid_cert_request";
    public static final String INVALID_JWT = "invalid_jwt";
    public static final String INVALID_KEY = "invalid_key";
    public static final String INVALID_KEY_MISSING = "invalid_key_private_key_missing";
    public static final String INVALID_KEY_SPEC = "invalid_key_spec";
    public static final String INVALID_POWERLIFT_API_KEY = "invalid_powerlift_api_key";
    public static final String INVALID_PROTECTION_PARAMS = "protection_params_invalid";
    public static final String IO_ERROR = "io_error";
    public static final String JSON_CONSTRUCTION_FAILED = "json_construction_failed";
    public static final String JSON_PARSE_FAILURE = "json_parse_failure";
    public static final String JWT_SIGNING_FAILURE = "failed_to_sign_jwt";
    public static final String KEYSTORE_NOT_INITIALIZED = "keystore_not_initialized";
    public static final String KEY_LOAD_FAILURE = "key_load_failure";
    public static final String KEY_MANAGEMENT_FAILURE = "key_management_failure";
    public static final String KEY_RING_READ_FAILURE = "storage_keyring_read_failure";
    public static final String KEY_RING_WRITE_FAILURE = "storage_keyring_write_failure";
    public static final String LOG_UPLOAD_FAILURE = "log_upload_failure";
    public static final String LOG_UPLOAD_TO_POWERLIFT_FEATURE_DISABLED = "log_upload_to_powerlift_feature_disabled";
    public static final String MALFORMED_URL = "malformed_url";
    public static final String MISSING_PARAMETER = "missing_parameter";
    public static final String MULTIPLE_MATCHING_TOKENS_DETECTED = "multiple_matching_tokens_detected";
    public static final String MULTIPLE_PARALLEL_INTERACTIVE_REQUEST_ERROR = "multiple_parallel_interactive_request_error";
    public static final String NATIVE_AUTH_INVALID_CIAM_AUTHORITY = "native_auth_invalid_ciam_authority";
    public static final String NESTED_APP_AUTH_NOT_SUPPORTED = "nested_app_auth_not_supported";
    public static final String NESTED_APP_INVALID_PARAMETERS = "nested_app_invalid_parameters";
    public static final String NON_ACTIVE_BROKER_ERROR = "non_active_broker_error";
    public static final String NOT_VALID_BROKER_FOUND = "not_valid_broker_found";
    public static final String NO_BROWSERS_AVAILABLE = "no_browsers_available";
    public static final String NO_SUCH_ALGORITHM = "no_such_algorithm";
    public static final String NO_SUCH_PADDING = "no_such_padding";
    public static final String NO_SUCH_PROVIDER = "no_such_provider";
    public static final String NULL_OBJECT = "null_object";
    public static final String NULL_POINTER_ERROR = "null_pointer_error";
    public static final String ONLY_SUPPORTS_ACCOUNT_MANAGER_ERROR_CODE = "ONLY_SUPPORTS_ACCOUNT_MANAGER_ERROR_CODE";
    public static final String OUT_OF_MEMORY = "out_of_memory";
    public static final String PASSKEY_PROTOCOL_REQUEST_PARSING_ERROR = "passkey_protocol_request_parsing_error";
    public static final String PKCE_FAILURE = "pkce_failure";
    public static final String PKCS_FAILURE = "pkcs_failure";
    public static final String REQUEST_IN_PROGRESS = "request_in_progress";
    public static final String SCOPE_EMPTY_OR_NULL = "scope_empty_or_null";
    public static final String SIGNING_FAILURE = "failed_to_sign";
    public static final String SIGN_IN_WITH_GOOGLE_FAILED = "sign_in_with_google_failed";
    public static final String STATE_MISMATCH = "state_mismatch";
    public static final String THUMBPRINT_COMPUTATION_FAILURE = "failed_to_compute_thumbprint_with_sha256";
    public static final String TIMED_OUT = "timed_out";
    public static final String TOKENS_MISSING = "tokens_missing";
    public static final String TOKEN_CACHE_ITEM_NOT_FOUND = "token_cache_item_not_found";
    public static final String TOKEN_SHARING_DESERIALIZATION_ERROR = "token_sharing_deserialization_error";
    public static final String TOKEN_SHARING_MSA_PERSISTENCE_ERROR = "failed_to_persist_msa_credential";
    public static final String UNEXPECTED_HMAC_LENGTH = "unexpected_hmac_length";
    public static final String UNKNOWN_AUTHORITY = "unknown_authority";
    public static final String UNKNOWN_CRYPTO_ERROR = "unknown_crypto_error";
    public static final String UNKNOWN_ERROR = "unknown_error";
    public static final String UNKNOWN_EXPORT_FORMAT = "unknown_public_key_export_format";
    public static final String UNSUPPORTED_ANDROID_API_VERSION = "unsupported_android_api_version";
    public static final String UNSUPPORTED_ENCODING = "unsupported_encoding";
    public static final String UNSUPPORTED_OPERATION = "unsupported_operation";
    public static final String UNSUPPORTED_URL = "unsupported_url";
    public static final String USER_MISMATCH = "user_mismatch";
    public static final String WORKPLACE_JOIN_DATA_NULL = "workplace_join_data_null";
    public static final String sName = "com.microsoft.identity.common.exception.ClientException";
    private static final long serialVersionUID = -2318746536590284648L;

    public ClientException(String str) {
        super(str);
    }

    public ClientException(String str, String str2) {
        super(str, str2);
    }

    public ClientException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }
}
