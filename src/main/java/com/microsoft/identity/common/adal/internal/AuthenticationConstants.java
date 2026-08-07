package com.microsoft.identity.common.adal.internal;

import com.microsoft.identity.common.internal.logging.Logger;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes14.dex */
public final class AuthenticationConstants {
    public static final String ADAL_PACKAGE_NAME = "com.microsoft.aad.adal";
    public static final String BUNDLE_MESSAGE = "Message";
    public static final int DEFAULT_EXPIRATION_TIME_SEC = 3600;
    public static final String ENCODING_UTF8 = "UTF-8";
    public static final String FIVE_POINT_ZERO = "5.0";
    public static final String FOUR_POINT_ZERO = "4.0";
    public static final String MS_FAMILY_ID = "1";
    public static final String ONE_POINT_ZERO = "1.0";
    public static final String SP800_108_LABEL = "AzureAD-SecureConversation";
    private static final String TAG = "AuthenticationConstants";
    public static final String THREE_POINT_ZERO = "3.0";
    public static final String TWO_POINT_ZERO = "2.0";
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    public static final Charset CHARSET_ASCII = Charset.forName("ASCII");

    public static final class AuthorizationIntentAction {
        public static final String DESTROY_REDIRECT_RECEIVING_ACTIVITY_ACTION = "destroy_redirect_receiving_activity_action";
        public static final String REDIRECT_RETURNED_ACTION = "redirect_returned_action";
        public static final String REFRESH_TO_CLOSE = "refresh_to_close";
    }

    public static final class AuthorizationIntentKey {
        public static final String AUTHORIZATION_AGENT = "com.microsoft.identity.client.authorization.agent";
        public static final String AUTHORIZATION_FINAL_URL = "com.microsoft.identity.client.final.url";
        public static final String AUTH_INTENT = "com.microsoft.identity.auth.intent";
        public static final String OTEL_CONTEXT_CARRIER = "otel_context_carrier";
        public static final String POST_PAGE_LOADED_URL = "com.microsoft.identity.post.page.loaded.url";
        public static final String REDIRECT_URI = "com.microsoft.identity.request.redirect.uri";
        public static final String REQUEST_HEADERS = "com.microsoft.identity.request.headers";
        public static final String REQUEST_ID = "com.microsoft.identity.request.id";
        public static final String REQUEST_URL = "com.microsoft.identity.request.url";
        public static final String WEB_VIEW_SILENT_AUTHORIZATION_FLOW_TIMEOUT = "com.microsoft.identity.web.view.silent.authorization.flow.timeout";
        public static final String WEB_VIEW_WEB_CP_ENABLED = "com.microsoft.identity.web.view.web.cp.enabled";
        public static final String WEB_VIEW_ZOOM_CONTROLS_ENABLED = "com.microsoft.identity.web.view.zoom.controls.enabled";
        public static final String WEB_VIEW_ZOOM_ENABLED = "com.microsoft.identity.web.view.zoom.enabled";
    }

    public static final class CompanyPortalContentProviderCall {
        public static final String COMPANY_PORTAL_CONTENT_PROVIDER_AUTHORITY = "content://com.microsoft.intune.omadm.authenticator";
        public static final String COMPANY_PORTAL_CONTENT_PROVIDER_METHOD_ON_GLOBAL_SIGNOUT = "onGlobalSignOut";
    }

    public static final class IntuneContentProviderCall {
        public static final String APP_DATA_CLEAR_SUPPORTED = "SUPPORTED";
        public static final String APP_DATA_CLEAR_UNSUPPORTED = "UNSUPPORTED";
        public static final String AUTHORITY = "content://com.microsoft.intune.shareduserlessdataclear/datacollection";
        public static final String INTUNE_PENDING_INTENT = "AppDataClearIntent";
        public static final String IS_APP_DATA_CLEAR_ACTION = "AppDataClearResult";
    }

    public static final class LtwContentProviderCall {
        public static final String LTW_CONTENT_PROVIDER_AUTHORITY = "content://com.microsoft.appmanager.accountstateprovider";
        public static final String LTW_CONTENT_PROVIDER_METHOD_IS_PRE_INSTALL_LTW = "isPreinstallLTW";
    }

    public static final class SdkPlatformFields {
        public static final String PRODUCT = "x-client-SKU";

        @Deprecated
        public static final String VERSION = "x-client-Ver";
    }

    public static final class TelemetryEvents {
        public static final String DECRYPTION_ERROR = "decryption_error_v2";
        public static final String KEYSTORE_READ_END = "keychain_read_v2_end";
        public static final String KEYSTORE_READ_START = "keychain_read_v2_start";
        public static final String KEYSTORE_WRITE_END = "keychain_write_v2_end";
        public static final String KEYSTORE_WRITE_START = "keychain_write_v2_start";
        public static final String KEY_CREATED = "key_created_v2";
        public static final String KEY_DISTRIBUTION_END = "key_distribution_v2_end";
        public static final String KEY_DISTRIBUTION_START = "key_distribution_v2_start";
        public static final String KEY_RETRIEVAL_END = "key_retrieval_v2_end";
        public static final String KEY_RETRIEVAL_START = "key_retrieval_v2_start";
        public static final String SHARED_DEVICE_REGISTERED = "shared_device_registered";
        public static final String USER_SIGNED_INTO_SHARED_DEVICE = "user_signed_into_shared_device";
        public static final String USER_SIGNED_OUT_FROM_SHARED_DEVICE = "user_signed_out_from_shared_device";
    }

    private AuthenticationConstants() {
    }

    public static final class Browser {
        public static final String ACTION_CANCEL = "com.microsoft.aad.adal:BrowserCancel";
        public static final String LOGOUT_ENDPOINT_V2 = "https://login.microsoftonline.com/common/oauth2/v2.0/logout";
        public static final String REQUEST_ID = "com.microsoft.aad.adal:RequestId";
        public static final String REQUEST_MESSAGE = "com.microsoft.aad.adal:BrowserRequestMessage";
        public static final String RESPONSE = "com.microsoft.aad.adal:BrokerResponse";
        public static final String RESPONSE_AUTHENTICATION_EXCEPTION = "com.microsoft.aad.adal:AuthenticationException";
        public static final String RESPONSE_ERROR_CODE = "com.microsoft.aad.adal:BrowserErrorCode";
        public static final String RESPONSE_ERROR_MESSAGE = "com.microsoft.aad.adal:BrowserErrorMessage";
        public static final String RESPONSE_ERROR_SUBCODE = "com.microsoft.aad.adal:BrowserErrorSubCode";
        public static final String RESPONSE_FINAL_URL = "com.microsoft.aad.adal:BrowserFinalUrl";
        public static final String RESPONSE_REQUEST_INFO = "com.microsoft.aad.adal:BrowserRequestInfo";
        public static final String SSL_HELP_URL = "https://go.microsoft.com/fwlink/?linkid=2138180";
        public static final String SUB_ERROR_UI_CANCEL = "cancel";
        public static final String WEBVIEW_INVALID_REQUEST = "Invalid request";

        private Browser() {
        }
    }

    public static final class OAuth2 {
        public static final String AAD_PREFERRED_USERNAME = "preferred_username";
        public static final String AAD_VERSION = "ver";
        public static final String AAD_VERSION_V1 = "1.0";
        public static final String AAD_VERSION_V2 = "2.0";
        public static final String ACCESS_TOKEN = "access_token";
        public static final String ADAL_CLIENT_FAMILY_ID = "foci";
        public static final String AUTHORITY = "authority";
        public static final String AUTHORIZATION_CODE = "authorization_code";
        public static final String CLAIMS = "claims";
        public static final String CLIENT_CAPABILITIES_CLAIMS_LIST = "xms_cc";
        public static final String CLIENT_CAPABILITY_ACCESS_TOKEN = "access_token";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_INFO = "client_info";
        public static final String CLIENT_INFO_TRUE = "1";
        public static final String CLIENT_SECRET = "client_secret";
        public static final String CLOUD_INSTANCE_HOST_NAME = "cloud_instance_host_name";
        public static final String CODE = "code";
        public static final String ERROR = "error";
        public static final String ERROR_CODES = "error_codes";
        public static final String ERROR_DESCRIPTION = "error_description";
        public static final String EXPIRES_IN = "expires_in";
        public static final String EXT_EXPIRES_IN = "ext_expires_in";
        public static final String GRANT_TYPE = "grant_type";
        public static final String HAS_CHROME = "haschrome";
        public static final String HTTP_RESPONSE_BODY = "response_body";
        public static final String HTTP_RESPONSE_HEADER = "response_headers";
        public static final String HTTP_STATUS_CODE = "status_code";
        public static final String ID_TOKEN = "id_token";
        public static final String ID_TOKEN_EMAIL = "email";
        public static final String ID_TOKEN_FAMILY_NAME = "family_name";
        public static final String ID_TOKEN_GIVEN_NAME = "given_name";
        public static final String ID_TOKEN_IDENTITY_PROVIDER = "idp";
        public static final String ID_TOKEN_OBJECT_ID = "oid";
        public static final String ID_TOKEN_PASSWORD_CHANGE_URL = "pwd_url";
        public static final String ID_TOKEN_PASSWORD_EXPIRATION = "pwd_exp";
        public static final String ID_TOKEN_SUBJECT = "sub";
        public static final String ID_TOKEN_TENANTID = "tid";
        public static final String ID_TOKEN_UNIQUE_NAME = "unique_name";
        public static final String ID_TOKEN_UPN = "upn";
        public static final String IT_VER_PARAM = "itver";
        public static final String REDIRECT_URI = "redirect_uri";
        public static final String REFRESH_TOKEN = "refresh_token";
        public static final String RESPONSE_TYPE = "response_type";
        public static final String SCOPE = "scope";
        public static final String SESSION_KEY_JWE = "session_key_jwe";
        public static final String STATE = "state";
        public static final String SUBERROR = "suberror";
        public static final String TOKEN_TYPE = "token_type";

        private OAuth2() {
        }
    }

    public static final class AAD {
        public static final String ADAL_BROKER_VERSION = "x-client-brkrver";
        public static final String ADAL_ID_CPU = "x-client-CPU";
        public static final String ADAL_ID_DM = "x-client-DM";
        public static final String ADAL_ID_OS_VER = "x-client-OS";
        public static final String ADAL_ID_PLATFORM = "x-client-SKU";
        public static final String ADAL_ID_PLATFORM_VALUE = "Android";
        public static final String ADAL_ID_VERSION = "x-client-Ver";
        public static final String APP_PACKAGE_NAME = "x-app-name";
        public static final String APP_VERSION = "x-app-ver";
        public static final String AUTHORIZATION_URI = "authorization_uri";
        public static final String CLIENT_REQUEST_ID = "client-request-id";
        public static final String CORRELATION_ID = "correlation_id";
        public static final String LOGIN_HINT = "login_hint";
        public static final String QUERY_PROMPT = "prompt";
        public static final String QUERY_PROMPT_REFRESH_SESSION_VALUE = "refresh_session";
        public static final String QUERY_PROMPT_VALUE = "login";
        public static final String REALM = "realm";
        public static final String REQUEST_ID_HEADER = "x-ms-request-id";
        public static final String RESOURCE = "resource";
        public static final String RETURN_CLIENT_REQUEST_ID = "return-client-request-id";
        public static final String WEB_UI_CANCEL = "access_denied";

        private AAD() {
        }
    }

    public static final class SWITCH_BROWSER {
        public static final String ACTION_URI = "action_uri";
        public static final String CLIENT_SUPPORTS_FLOW = "switch_browser";
        public static final String CODE = "code";
        public static final String REQUEST_PATH = "switch_browser";
        public static final String RESUME_PATH = "switch_browser_resume";
        public static final String STATE = "state";

        private SWITCH_BROWSER() {
        }
    }

    public static final class Broker {
        public static final String AAD_CHINA_URL_HOST_SUFFIX = ".microsoftonline.cn";
        public static final String AAD_GLOBAL_URL_HOST_SUFFIX = ".microsoftonline.com";
        public static final String AAD_INTUNE_MDM_URL_HOST_SUFFIX = ".microsoft.com";
        public static final String AAD_US_URL_HOST_SUFFIX = ".microsoftonline.us";
        public static final String ACCOUNT = "account.object";
        public static final String ACCOUNT_ACCESS_TOKEN = "account.access.token";
        public static final String ACCOUNT_ADD_NEW = "account.add.new";
        public static final String ACCOUNT_AUTHORITY = "account.authority";
        public static final String ACCOUNT_CLAIMS = "account.claims";
        public static final String ACCOUNT_CLIENTID_KEY = "account.clientid.key";
        public static final String ACCOUNT_CLIENT_SECRET_KEY = "account.client.secret.key";
        public static final String ACCOUNT_CORRELATIONID = "account.correlationid";
        public static final String ACCOUNT_DEFAULT_NAME = "Default";
        public static final String ACCOUNT_EXPIREDATE = "account.expiredate";
        public static final String ACCOUNT_EXTRA_QUERY_PARAM = "account.extra.query.param";
        public static final String ACCOUNT_HOME_ACCOUNT_ID = "account.home.account.id";
        public static final String ACCOUNT_IDTOKEN = "account.idtoken";
        public static final String ACCOUNT_INITIAL_NAME = "aad";
        public static final String ACCOUNT_INITIAL_REQUEST = "account.initial.request";
        public static final String ACCOUNT_LOCAL_ACCOUNT_ID = "account.local.account.id";
        public static final String ACCOUNT_LOGIN_HINT = "account.login.hint";
        public static final int ACCOUNT_MANAGER_REMOVE_ACCOUNT_TIMEOUT_IN_MILLISECONDS = 5000;
        public static final String ACCOUNT_NAME = "account.name";
        public static final String ACCOUNT_PROMPT = "account.prompt";
        public static final String ACCOUNT_REDIRECT = "account.redirect";
        public static final String ACCOUNT_REFRESH_TOKEN = "account.refresh.token";
        public static final String ACCOUNT_REMOVE_TOKENS = "account.remove.tokens";
        public static final String ACCOUNT_REMOVE_TOKENS_VALUE = "account.remove.tokens.value";
        public static final String ACCOUNT_REQUEST_TYPE = "broker.request.type";
        public static final String ACCOUNT_RESOLVE_INTERRUPT = "account.resolve.interrupt";
        public static final String ACCOUNT_RESOURCE = "account.resource";
        public static final String ACCOUNT_RESULT = "account.result";
        public static final String ACCOUNT_UID_CACHES = "account.uid.caches";
        public static final String ACCOUNT_USERINFO_AUTHORITY_TYPE = "account.userinfo.authority.type";
        public static final String ACCOUNT_USERINFO_ENVIRONMENT = "account.userinfo.environment";
        public static final String ACCOUNT_USERINFO_FAMILY_NAME = "account.userinfo.family.name";
        public static final String ACCOUNT_USERINFO_GIVEN_NAME = "account.userinfo.given.name";
        public static final String ACCOUNT_USERINFO_IDENTITY_PROVIDER = "account.userinfo.identity.provider";
        public static final String ACCOUNT_USERINFO_ID_TOKEN = "account.userinfo.id.token";
        public static final String ACCOUNT_USERINFO_TENANTID = "account.userinfo.tenantid";
        public static final String ACCOUNT_USERINFO_USERID = "account.userinfo.userid";
        public static final String ACCOUNT_USERINFO_USERID_DISPLAYABLE = "account.userinfo.userid.displayable";
        public static final String ACCOUNT_USERINFO_USERID_LIST = "account.userinfo.userid.list";
        public static final String ADAL_VERSION_KEY = "adal.version.key";
        public static final String AMAZON_APP_REDIRECT_PREFIX = "aea://";
        public static final String AUTHENTICATOR_MFA_LINKING_PREFIX = "microsoft-authenticator://activatemfa";
        public static final String AUTHTOKEN_TYPE = "adal.authtoken.type";
        public static final String AUTH_RESPONSE_TYPE = "response_type";
        public static final String AUTH_SCHEME_PARAMS_POP = "pop_parameters";
        public static final String AUTH_SCOPE = "scope";
        public static final String AUTH_STATE = "state";
        public static final String AZURE_AUTHENTICATOR_APP_DEBUG_SIGNATURE_SHA512 = "pdAtoxfsEwbpQsIaua5Uobl5AQEjqt40aPXI7UY1lIW0NTmg0G4jHQ5T5mujSjjU06q4mEHs5hb6z/Mr0PNlmQ==";
        public static final String AZURE_AUTHENTICATOR_APP_PACKAGE_NAME = "com.azure.authenticator";
        public static final String AZURE_AUTHENTICATOR_APP_RELEASE_SIGNATURE_SHA512 = "Gu8CuaYmSV5CHWd6dz3tGPXIE+YTalCVIXi5lEBXpvUgsMKoHbU9Rqou3WNRNU1tsz8pvEADTCCJ5f02fbw9qw==";
        public static final String BACKGROUND_REQUEST_MESSAGE = "background.request";
        public static final String BROKER_ACCOUNTS = "broker_accounts";
        public static final String BROKER_ACCOUNTS_COMPRESSED = "broker_accounts_compressed";
        public static final String BROKER_ACCOUNT_MANAGER_OPERATION_KEY = "com.microsoft.broker_accountmanager_operation_key";
        public static final String BROKER_ACTIVITY_NAME = "broker.activity.name";
        public static final String BROKER_API_TO_BROKER_PROTOCOL_NAME = "broker.api.to.broker";
        public static final String BROKER_APP_LINK_REDIRECT_URL_HOST = "login.microsoftonline.com";
        public static final String BROKER_APP_LINK_REDIRECT_URL_PATH_PREFIX = "androidbroker";
        public static final String BROKER_APP_LINK_REDIRECT_URL_SCHEME = "https";
        public static final String BROKER_DCF_AUTH_RESULT = "broker_dcf_auth_result";
        public static final String BROKER_DEVICE_MODE = "broker_device_mode";
        public static final String BROKER_FEATURE_MULTI_USER = "broker.feature.multi.user";
        public static final String BROKER_FINAL_URL = "adal.final.url";
        public static final String BROKER_FLIGHT_MAP_KEY = "broker.flight.map";
        public static final String BROKER_FORCE_REFRESH = "force.refresh";
        public static final String BROKER_GENERATE_ALL_SSO_TOKENS_RESULT = "broker_generate_all_sso_tokens";
        public static final String BROKER_GENERATE_SHR_RESULT = "broker_generate_shr_result";
        public static final String BROKER_GENERATE_SSO_TOKEN_RESULT = "broker_generate_sso_token";
        public static final String BROKER_HOST_APP_PACKAGE_NAME = "com.microsoft.identity.testuserapp";
        public static final String BROKER_HOST_APP_SIGNATURE_SHA512 = "xxAk8S05zu0Nkce+X2J6IKJ2e7YE4F9ZorZj0YnYUQ2vw8vLc8VGGOqJdTnVySbbcy9VY8UDbOfeOETSErYllw==";
        public static final String BROKER_KEYSTORE_SYMMETRIC_KEY = "broker_keystore_symmetric_key";
        public static final String BROKER_PACKAGE_NAME = "broker.package.name";
        public static final String BROKER_PROTOCOL_VERSION = "v2";
        public static final String BROKER_REDIRECT_URI = "urn:ietf:wg:oauth:2.0:oob";
        public static final String BROKER_REQUEST = "com.microsoft.aadbroker.adal.broker.request";
        public static final int BROKER_REQUEST_ID = 1177;
        public static final String BROKER_REQUEST_RESUME = "com.microsoft.aadbroker.adal.broker.request.resume";
        public static final String BROKER_REQUEST_V2 = "broker_request_v2";
        public static final String BROKER_REQUEST_V2_COMPRESSED = "broker_request_v2_compressed";
        public static final String BROKER_REQUEST_V2_SUCCESS = "broker_request_v2_success";
        public static final String BROKER_RESULT_RETURNED = "broker.result.returned";
        public static final String BROKER_RESULT_V2 = "broker_result_v2";
        public static final String BROKER_RESULT_V2_COMPRESSED = "broker_result_v2_compressed";
        public static final String BROKER_RETURN_JSON = "broker.json";
        public static final String BROKER_SKIP_CACHE = "skip.cache";
        public static final String BROKER_SSO_URL_KEY = "ssoUrl";
        public static final String BROKER_VERSION = "broker.version";
        public static final String BROKER_WEBAPPS_GET_CONTRACTS_RESULT = "contracts";
        public static final String BROKER_WEB_APPS_ERROR = "error";
        public static final String BROKER_WEB_APPS_REQUEST = "request";
        public static final String BROKER_WEB_APPS_RESPONSE = "response";
        public static final String BROWSER_DEVICE_CA_URL_QUERY_STRING_PARAMETER = "&ismdmurl=1";
        public static final String BROWSER_EXT_INSTALL_PREFIX = "msauth://";
        public static final String BROWSER_EXT_PREFIX = "browser://";
        public static final String BROWSER_EXT_WEB_CP = "companyportal://";
        public static final String CALLER_CACHEKEY_PREFIX = "|";
        public static final String CALLER_INFO_PACKAGE = "caller.info.package";
        public static final String CALLER_INFO_UID = "caller.info.uid";
        public static final String CAN_FOCI_APPS_CONSTRUCT_ACCOUNTS_FROM_PRT_ID_TOKEN_KEY = "can.construct.accounts.from.prt.id.token";
        public static final String CHALLENGE_REQUEST_CERT_AUTH_DELIMETER = ";";
        public static final String CHALLENGE_REQUEST_HEADER = "WWW-Authenticate";
        public static final String CHALLENGE_RESPONSE_CONTEXT = "Context";
        public static final String CHALLENGE_RESPONSE_HEADER = "Authorization";
        public static final String CHALLENGE_RESPONSE_TOKEN = "AuthToken";
        public static final String CHALLENGE_RESPONSE_TYPE = "PKeyAuth";
        public static final String CHALLENGE_TLS_INCAPABLE = "x-ms-PKeyAuth";
        public static final String CHALLENGE_TLS_INCAPABLE_VERSION = "1.0";
        public static final String CLIENT_ADVERTISED_MAXIMUM_BP_VERSION_KEY = "broker.protocol.version.name";
        public static final String CLIENT_APP_PACKAGE_NAME = "client_app_package_name";
        public static final String CLIENT_CONFIGURED_MINIMUM_BP_VERSION_KEY = "required.broker.protocol.version.name";
        public static final String CLIENT_MAX_PROTOCOL_VERSION = "19.0";
        public static final String CLIENT_TLS_NOT_SUPPORTED = " PKeyAuth/1.0";
        public static final String COMPANY_PORTAL_APP_DEBUG_SIGNATURE_SHA512 = "oIuNoUwMsxC10VneTQXnt/GXN+Pjqd6mpOKEMF/cH3i06K93TZMBWq+fHN/zt4zUe/W6zGj6YLymd1/tGuypNQ==";
        public static final String COMPANY_PORTAL_APP_LAUNCH_ACTIVITY_NAME = "com.microsoft.windowsintune.companyportal.views.SplashActivity";
        public static final String COMPANY_PORTAL_APP_PACKAGE_NAME = "com.microsoft.windowsintune.companyportal";

        @Deprecated
        public static final String COMPANY_PORTAL_APP_RELEASE_SIGNATURE = "1L4Z9FJCgn5c0VLhyAxC5O9LdlE=";
        public static final String COMPANY_PORTAL_APP_RELEASE_SIGNATURE_SHA512 = "jPpMoaNvcxSLMX4yG4C3Gf86rtTqh33SqpuRKg4WOP+MnnpA52zZgvKLW76U4Cqqf68iaBk9W7k/jhciiSAtgQ==";
        public static final String DEFAULT_BROWSER_PACKAGE_NAME = "default.browser.package.name";
        public static final String DEFAULT_MAX_BROKER_PROTOCOL_VERSION = "13.0";
        public static final String ENVIRONMENT = "environment";
        public static final String EXPIRATION_BUFFER = "expiration.buffer";
        public static final String FLIGHT_INFO = "com.microsoft.identity.broker.flights";
        public static final String GET_FLIGHTS_RESULT = "active_flights";
        public static final String GET_NUMBER_MATCH_RESULT = "number_match";
        public static final String HELLO_ERROR_CODE = "error";
        public static final String HELLO_ERROR_MESSAGE = "error_description";
        public static final String HTTPS_SCHEME = "https";
        public static final String INTENT_PREFIX = "intent://";
        public static final String INTUNE_APP_PACKAGE_NAME = "com.microsoft.intune";
        public static final String INTUNE_APP_SHA512_DEBUG_SIGNATURE = "F+Tat7A/mlOJCzRYEmj9DgLRHU2Nb0VSQjgZEyAehqW9+cOT0oYjkT/fa33hYcVMwUzaSy0hUOVt9KQtyFRnVQ==";
        public static final String INTUNE_APP_SHA512_RELEASE_SIGNATURE = "jPpMoaNvcxSLMX4yG4C3Gf86rtTqh33SqpuRKg4WOP+MnnpA52zZgvKLW76U4Cqqf68iaBk9W7k/jhciiSAtgQ==";
        public static final String IPPHONE_APP_PACKAGE_NAME = "com.microsoft.skype.teams.ipphone";
        public static final String IPPHONE_APP_SHA512_DEBUG_SIGNATURE = "FOoI98kyj+dXPZYW191TjF6017ljKj47G+RCQPYjIcXD7uhhTpw7pqznTABB0ZjB1/DZetRgr284pyLumvXN6A==";
        public static final String IPPHONE_APP_SHA512_RELEASE_SIGNATURE = "iPULpH0pq8ms1Qy7cOzGsVRQN7/zW4IbW+UKcajvtrTrzM5o5VcaghNEA1Ho4Wq7ay0efqqJcalxa8eHxVnHKA==";
        public static final String LATEST_MSAL_TO_BROKER_PROTOCOL_VERSION_CODE = "19.0";
        public static final String LIB_NAME = "library_name";
        public static final String LIB_VERSION = "library_version";
        public static final String LTW_APP_PACKAGE_NAME = "com.microsoft.appmanager";
        public static final String LTW_APP_SHA512_DEBUG_SIGNATURE = "5PAhhZNSRRvq7vpTT5vrYJbSLh05AU8USf7oUTS239PEltebX87uGN7GhAe5244lJepwZ5RU4vu8N6ospXVOlg==";
        public static final String LTW_APP_SHA512_RELEASE_SIGNATURE = "WhUdh04ZkQLmNb//lKmohyqDdPMWXHcI0O3AvoLMtgF/smnED4r+Vguvgj6d4QG77Jl3avUKt6LeqF2TJPZVzg==";
        public static final String MOCK_AUTH_APP_PACKAGE_NAME = "com.microsoft.mockauthapp";
        public static final String MOCK_AUTH_APP_SIGNATURE_SHA512 = "QhjKSYYD31K7+C4q4Mpd08crE0LN/3GgnKVVuej4JWckUTc0Wp/i//LWLQnANaWiAjdESJJrjavu0cE6hkQihQ==";
        public static final String MOCK_CP_PACKAGE_NAME = "com.microsoft.mockcp";
        public static final String MOCK_CP_SIGNATURE_SHA512 = "EZ2RCcsmf869Ec41PgHHnFdI0MgmVsADFFy8AtcfEKsjD1YAPtKxCMZVdT+y+K1IWRnPk4Lf2PUAcL5N49OqAA==";
        public static final String MOCK_LTW_PACKAGE_NAME = "com.microsoft.mockltw";
        public static final String MOCK_LTW_SIGNATURE_SHA512 = "felxzv/rpqa69dOADXVVKnawk5x8snBW2k/kDxzQLVkbcdzAvrGm8gcBRItzUGIQTupHCTWksN6WBGbn+b0KIA==";
        public static final String MSAL_TO_BROKER_PROTOCOL_NAME = "msal.to.broker";
        public static final String MULTI_RESOURCE_TOKEN = "account.multi.resource.token";
        public static final String NEGOTIATED_BP_VERSION_KEY = "common.broker.protocol.version.name";
        public static final String NEW_BROKER_REDIRECT_URI = "msauth://Microsoft.AAD.BrokerPlugin";
        public static final String PKCE_CHALLENGE = "PkceChallenge";
        public static final String PKEYAUTH_REDIRECT = "urn:http-auth:PKeyAuth";
        public static final String PLAY_STORE_INSTALL_APP_PREFIX = "https://play.google.com/store/apps/details?id=";
        public static final String PLAY_STORE_INSTALL_PREFIX = "market://details?id=";
        public static final String POWERLIFT_API_KEY = "powerLiftApiKey";
        public static final String POWERLIFT_INCIDENT_ID = "powerLiftincidentId";
        public static final String POWERLIFT_TENANT_ID = "powerLiftTenantId";
        public static final String PREFERRED_AUTH_METHOD_CODE = "preferred_auth_method_CODE";
        public static final String PRT_NONCE = "nonce";
        public static final String PRT_RESPONSE_HEADER = "x-ms-RefreshTokenCredential";
        public static final String REDIRECT_PREFIX = "msauth";
        public static final String REDIRECT_SSL_PREFIX = "https://";
        public static final String REMOVE_BROKER_ACCOUNT_SUCCEEDED = "remove_broker_account_succeeded";
        public static final String REQUEST_AUTHORITY = "request.authority";
        public static final String RESTORED_BROKER_MSA_ACCOUNT_NAMES = "restored_broker_msa_account_names";
        public static final String SESSION_ID = "session_id";
        public static final String SET_FLIGHTS_SUCCEEDED = "set_flights_succeeded";
        public static final String SHOULD_POPULATE_IF_MSA_ACCOUNT_IS_BACKED_UP_KEY = "should.populate.if.msa.account.is.backed.up.key";
        public static final String SHOULD_SEND_PKEYAUTH_HEADER_TO_THE_TOKEN_ENDPOINT = "should.send.pkeyauth.header";
        public static final String SSO_NONCE_PARAMETER = "sso_nonce";
        public static final String SSO_TOKEN_CLIENT_ID = "broker.sso.clientId";
        public static final String UPDATE_BROKER_RT_SUCCEEDED = "update_broker_rt_succeeded";
        public static final String UPLOAD_BROKER_LOGS_RESULT = "upload_broker_logs_result";
        public static final String USERDATA_BROKER_PRT_RT = "userdata.broker.prt.rt";
        public static final String USERDATA_BROKER_PRT_SESSION_KEY = "userdata.broker.prt.session.key";
        public static final String USERDATA_BROKER_RT = "userdata.broker.rt";
        public static final String USERDATA_CALLER_CACHEKEYS = "userdata.caller.cachekeys";
        public static final String USERDATA_PREFIX = "userdata.prefix";
        public static final String USERDATA_UID_KEY = "calling.uid.key";
        public static final String WEBCP_CLIENT_ID = "74bcdadc-2fdc-4bb3-8459-76d06952a0e9";
        public static final String WEBCP_ENROLLMENT_URL = "https://enterprise.google.com/android/enroll";
        public static final String WEBCP_LAUNCH_COMPANY_PORTAL_URL = "companyportal://enrollment";
        public static final String BROKER_API_TO_BROKER_PROTOCOL_VERSION_CODE = computeMaxHostBrokerProtocol();
        public static final Object REDIRECT_DELIMETER_ENCODED = "%2C";

        public static final class CliTelemInfo {
            private static final String PREFIX = "cliteleminfo.";
            public static final String RT_AGE = "cliteleminfo.rt_age";
            public static final String SERVER_ERROR = "cliteleminfo.server_error";
            public static final String SERVER_SUBERROR = "cliteleminfo.server_suberror";
            public static final String SPE_RING = "cliteleminfo.spe_ring";
        }

        private Broker() {
        }

        public static String computeMaxHostBrokerProtocol() {
            String str = "1.0";
            float f = 1.0f;
            for (BrokerContentProvider.API api : BrokerContentProvider.API.values()) {
                String brokerVersion = api.getBrokerVersion();
                if (brokerVersion != null) {
                    try {
                        float f2 = Float.parseFloat(brokerVersion);
                        if (f2 > f) {
                            str = brokerVersion;
                            f = f2;
                        }
                    } catch (NumberFormatException e) {
                        Logger.error(AuthenticationConstants.TAG + ":<static initialization>", "Invalid value for protocol version", e);
                    }
                }
            }
            return str;
        }
    }

    public static final class OAuth2Scopes {
        public static final String AZA_SCOPE = "aza";
        public static final String CLAIMS_UPDATE_RESOURCE = "urn:aad:tb:update:prt/.default";
        public static final String EMAIL = "email";
        public static final String OFFLINE_ACCESS_SCOPE = "offline_access";
        public static final String OPEN_ID_SCOPE = "openid";
        public static final String PROFILE_SCOPE = "profile";

        private OAuth2Scopes() {
        }
    }

    public static final class BrokerAccountManagerOperation {
        public static final String ACQUIRE_TOKEN_DCF = "ACQUIRE_TOKEN_DCF";
        public static final String ACQUIRE_TOKEN_SILENT = "ACQUIRE_TOKEN_SILENT";
        public static final String FETCH_DCF_AUTH_RESULT = "FETCH_DCF_AUTH_RESULT";
        public static final String GENERATE_SHR = "GENERATE_SHR";
        public static final String GET_ACCOUNTS = "GET_ACCOUNTS";
        public static final String GET_CURRENT_ACCOUNT = "GET_CURRENT_ACCOUNT";
        public static final String GET_DEVICE_MODE = "GET_DEVICE_MODE";
        public static final String GET_INTENT_FOR_INTERACTIVE_REQUEST = "GET_INTENT_FOR_INTERACTIVE_REQUEST";
        public static final String HELLO = "HELLO";
        public static final String REMOVE_ACCOUNT = "REMOVE_ACCOUNT";
        public static final String REMOVE_ACCOUNT_FROM_SHARED_DEVICE = "REMOVE_ACCOUNT_FROM_SHARED_DEVICE";

        private BrokerAccountManagerOperation() {
        }
    }

    public static final class BrokerContentProvider {
        public static final String AUTHORITY = "microsoft.identity.broker";
        public static final int BROKER_API_GET_BROKER_ACCOUNTS_CODE = 10;
        public static final String BROKER_API_GET_BROKER_ACCOUNTS_PATH = "/brokerApi/getBrokerAccounts";
        public static final String BROKER_API_GET_FLIGHTS_PATH = "/brokerApi/getFlights";
        public static final String BROKER_API_GET_NUMBER_MATCH_PATH = "/brokerApi/getNumberMatch";
        public static final String BROKER_API_HELLO_PATH = "/brokerApi/hello";
        public static final int BROKER_API_HELLO_URI_CODE = 9;
        public static final int BROKER_API_REMOVE_BROKER_ACCOUNT_CODE = 11;
        public static final String BROKER_API_REMOVE_BROKER_ACCOUNT_PATH = "/brokerApi/removeBrokerAccount";
        public static final String BROKER_API_SET_FLIGHTS_PATH = "/brokerApi/setFlights";
        public static final int BROKER_API_UPDATE_BRT_CODE = 12;
        public static final String BROKER_API_UPDATE_BRT_PATH = "/brokerApi/updateBrt";
        public static final String BROKER_API_UPLOAD_LOGS = "/brokerApi/uploadBrokerLogs";
        public static final String BROKER_DISCOVERY_FROM_SDK_PATH = "/brokerElection/brokerDiscoveryFromSdk";
        public static final String BROKER_DISCOVERY_SET_ACTIVE_BROKER_PATH = "/brokerElection/setActiveBroker";
        public static final String BROKER_INDIVIDUAL_LOGS_UPLOAD_PATH = "/brokerIndividualLogsUpload";
        public static final String BROKER_RESTORE_MSA_ACCOUNTS_WITH_TRANSFER_TOKENS_PATH = "/brokerApi/restoreMsaAccountsWithTransferTokens";
        private static final String BROKER_VERSION_1 = "1.0";
        private static final String BROKER_VERSION_3 = "3.0";
        private static final String BROKER_VERSION_4 = "4.0";
        private static final String BROKER_VERSION_5 = "5.0";
        public static final String CONTENT_SCHEME = "content://";
        public static final String DEVICE_REGISTRATION_PROTOCOLS_PATH = "/multipledeviceRegistration/protocols";
        public static final String GENERATE_SHR_PATH = "/generateShr";
        public static final String GET_AAD_DEVICE_ID_PATH = "/getAadDeviceId";
        public static final String GET_ALL_SSO_TOKENS_PATH = "/allSsoTokens";
        public static final String GET_PREFERRED_AUTH_METHOD = "/getPreferredAuthMethod";
        public static final String GET_SSO_TOKEN_PATH = "/ssoToken";
        public static final String MSAL_ACQUIRE_TOKEN_DCF_PATH = "/acquireTokenDCF";
        public static final int MSAL_ACQUIRE_TOKEN_INTERACTIVE_CODE = 2;
        public static final String MSAL_ACQUIRE_TOKEN_INTERACTIVE_PATH = "/acquireTokenInteractive";
        public static final int MSAL_ACQUIRE_TOKEN_SILENT_CODE = 3;
        public static final String MSAL_ACQUIRE_TOKEN_SILENT_PATH = "/acquireTokenSilent";
        public static final String MSAL_FETCH_DCF_AUTH_RESULT_PATH = "/fetchDCFAuthResult";
        public static final int MSAL_GENERATE_SHR_CODE = 13;
        public static final int MSAL_GET_ACCOUNTS_CODE = 4;
        public static final String MSAL_GET_ACCOUNTS_PATH = "/getAccounts";
        public static final int MSAL_GET_CURRENT_ACCOUNT_SHARED_DEVICE_CODE = 6;
        public static final String MSAL_GET_CURRENT_ACCOUNT_SHARED_DEVICE_PATH = "/getCurrentAccountSharedDevice";
        public static final int MSAL_GET_DEVICE_MODE_CODE = 7;
        public static final String MSAL_GET_DEVICE_MODE_PATH = "/getDeviceMode";
        public static final String MSAL_HELLO_PATH = "/hello";
        public static final int MSAL_HELLO_URI_CODE = 1;
        public static final int MSAL_REMOVE_ACCOUNTS_CODE = 5;
        public static final String MSAL_REMOVE_ACCOUNT_PATH = "/removeAccounts";
        public static final int MSAL_SIGN_OUT_FROM_SHARED_DEVICE_CODE = 8;
        public static final String MSAL_SIGN_OUT_FROM_SHARED_DEVICE_PATH = "/signOutFromSharedDevice";
        public static final String PASSTHROUGH_PATH = "/passthrough";
        public static final String PROVISION_RESOURCE_ACCOUNT_PATH = "/provisionResourceAccount";
        public static final String READ_RESTRICTIONS_MANAGER_PATH = "/readRestrictionsManager";
        public static final String RETRIEVE_BROKER_DISCOVERY_METADATA_PATH = "/brokerElection/brokerDiscoveryMetadataRetrieval";
        private static final String VERSION_1 = "1.0";
        private static final String VERSION_3 = "3.0";
        private static final String VERSION_6 = "6.0";
        private static final String VERSION_7 = "7.0";
        public static final String WEBAPPS_EXECUTE_WEB_APPS_REQUEST_PATH = "/webapp/executeWebAppsRequest";
        public static final String WEBAPPS_GET_SUPPORTED_WEB_APPS_CONTRACTS_PATH = "/webapp/getSupportedWebAppsContracts";

        private BrokerContentProvider() {
        }

        public enum API {
            MSAL_HELLO(BrokerContentProvider.MSAL_HELLO_PATH, null, "3.0"),
            ACQUIRE_TOKEN_INTERACTIVE(BrokerContentProvider.MSAL_ACQUIRE_TOKEN_INTERACTIVE_PATH, null, "3.0"),
            ACQUIRE_TOKEN_SILENT(BrokerContentProvider.MSAL_ACQUIRE_TOKEN_SILENT_PATH, null, "3.0"),
            GET_ACCOUNTS(BrokerContentProvider.MSAL_GET_ACCOUNTS_PATH, null, "3.0"),
            REMOVE_ACCOUNT(BrokerContentProvider.MSAL_REMOVE_ACCOUNT_PATH, null, "3.0"),
            GET_CURRENT_ACCOUNT_SHARED_DEVICE(BrokerContentProvider.MSAL_GET_CURRENT_ACCOUNT_SHARED_DEVICE_PATH, null, "3.0"),
            GET_DEVICE_MODE(BrokerContentProvider.MSAL_GET_DEVICE_MODE_PATH, null, "3.0"),
            SIGN_OUT_FROM_SHARED_DEVICE(BrokerContentProvider.MSAL_SIGN_OUT_FROM_SHARED_DEVICE_PATH, null, "3.0"),
            GENERATE_SHR(BrokerContentProvider.GENERATE_SHR_PATH, null, BrokerContentProvider.VERSION_6),
            BROKER_HELLO(BrokerContentProvider.BROKER_API_HELLO_PATH, "1.0", null),
            BROKER_GET_ACCOUNTS(BrokerContentProvider.BROKER_API_GET_BROKER_ACCOUNTS_PATH, "1.0", null),
            BROKER_REMOVE_ACCOUNT(BrokerContentProvider.BROKER_API_REMOVE_BROKER_ACCOUNT_PATH, "1.0", null),
            BROKER_UPDATE_BRT(BrokerContentProvider.BROKER_API_UPDATE_BRT_PATH, "1.0", null),
            BROKER_SET_FLIGHTS(BrokerContentProvider.BROKER_API_SET_FLIGHTS_PATH, "3.0", null),
            BROKER_GET_FLIGHTS(BrokerContentProvider.BROKER_API_GET_FLIGHTS_PATH, "3.0", null),
            GET_SSO_TOKEN(BrokerContentProvider.GET_SSO_TOKEN_PATH, null, BrokerContentProvider.VERSION_7),
            GET_ALL_SSO_TOKENS(BrokerContentProvider.GET_ALL_SSO_TOKENS_PATH, null, null),
            UNKNOWN(null, null, null),
            DEVICE_REGISTRATION_PROTOCOLS(BrokerContentProvider.DEVICE_REGISTRATION_PROTOCOLS_PATH, null, null),
            BROKER_UPLOAD_LOGS(BrokerContentProvider.BROKER_API_UPLOAD_LOGS, "4.0", null),
            FETCH_DCF_AUTH_RESULT(BrokerContentProvider.MSAL_FETCH_DCF_AUTH_RESULT_PATH, null, null),
            ACQUIRE_TOKEN_DCF(BrokerContentProvider.MSAL_ACQUIRE_TOKEN_DCF_PATH, null, null),
            BROKER_DISCOVERY_METADATA_RETRIEVAL(BrokerContentProvider.RETRIEVE_BROKER_DISCOVERY_METADATA_PATH, null, null),
            BROKER_DISCOVERY_FROM_SDK(BrokerContentProvider.BROKER_DISCOVERY_FROM_SDK_PATH, null, null),
            BROKER_DISCOVERY_SET_ACTIVE_BROKER(BrokerContentProvider.BROKER_DISCOVERY_SET_ACTIVE_BROKER_PATH, null, null),
            PASSTHROUGH(BrokerContentProvider.PASSTHROUGH_PATH, null, null),
            READ_RESTRICTIONS_MANAGER(BrokerContentProvider.READ_RESTRICTIONS_MANAGER_PATH, null, null),
            GET_PREFERRED_AUTH_METHOD(BrokerContentProvider.GET_PREFERRED_AUTH_METHOD, null, null),
            BROKER_INDIVIDUAL_LOGS_UPLOAD(BrokerContentProvider.BROKER_INDIVIDUAL_LOGS_UPLOAD_PATH, null, null),
            BROKER_RESTORE_MSA_ACCOUNTS_WITH_TRANSFER_TOKENS(BrokerContentProvider.BROKER_RESTORE_MSA_ACCOUNTS_WITH_TRANSFER_TOKENS_PATH, "5.0", null),
            WEBAPPS_GET_SUPPORTED_WEB_APPS_CONTRACTS(BrokerContentProvider.WEBAPPS_GET_SUPPORTED_WEB_APPS_CONTRACTS_PATH, null, null),
            WEBAPPS_EXECUTE_WEB_APPS_REQUEST(BrokerContentProvider.WEBAPPS_EXECUTE_WEB_APPS_REQUEST_PATH, null, null),
            PROVISION_RESOURCE_ACCOUNT(BrokerContentProvider.PROVISION_RESOURCE_ACCOUNT_PATH, null, null),
            GET_AAD_DEVICE_ID(BrokerContentProvider.GET_AAD_DEVICE_ID_PATH, null, null),
            BROKER_GET_NUMBER_MATCH(BrokerContentProvider.BROKER_API_GET_NUMBER_MATCH_PATH, "3.0", null);

            private final String mBrokerVersion;
            private final String mMsalVersion;
            private final String mPath;

            API(String str, String str2, String str3) {
                this.mPath = str;
                this.mBrokerVersion = str2;
                this.mMsalVersion = str3;
            }

            public String getPath() {
                return this.mPath;
            }

            public String getBrokerVersion() {
                return this.mBrokerVersion;
            }

            public String getMsalVersion() {
                return this.mMsalVersion;
            }
        }
    }
}
