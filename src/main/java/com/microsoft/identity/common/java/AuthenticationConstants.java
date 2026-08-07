package com.microsoft.identity.common.java;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class AuthenticationConstants {
    public static final int DEFAULT_EXPIRATION_TIME_SEC = 3600;
    public static final String ENCODING_ASCII_STRING = "ASCII";
    public static final String ENCODING_UTF8_STRING = "UTF-8";
    public static final String HTTPS_PROTOCOL_STRING = "https";
    public static final String SP800_108_LABEL = "AzureAD-SecureConversation";
    public static final Charset ENCODING_UTF8 = Charset.forName("UTF-8");
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    public static final Charset CHARSET_ASCII = Charset.forName("ASCII");
    public static final Set<String> DEFAULT_SCOPES = Collections.unmodifiableSet(new HashSet(Arrays.asList("openid", "offline_access", "profile")));

    public static final class LocalBroadcasterAliases {
        public static final String CANCEL_AUTHORIZATION_REQUEST = "cancel_authorization_request";
        public static final String RETURN_AUTHORIZATION_REQUEST_RESULT = "return_authorization_request_result";
        public static final String RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT = "return_broker_interactive_acquire_token_result";
    }

    public static final class LocalBroadcasterFields {
        public static final String REQUEST_CODE = "com.microsoft.identity.client.request.code";
        public static final String RESULT_CODE = "com.microsoft.identity.client.result.code";
    }

    public static final class SdkPlatformFields {
        public static final String CLIENT_EXTRA_SKU = "x-client-xtra-sku";
        public static final String PRODUCT = "x-client-SKU";
        public static final String PRODUCT_NAME_MSAL = "MSAL.Android";
        public static final String PRODUCT_NAME_MSAL_CPP = "MSAL.xplat.Android";
        public static final String PRODUCT_NAME_MSAL_XPLAT_LINUX = "MSAL.xplat.Linux";
        public static final String VERSION = "x-client-Ver";
    }

    public static final class UIRequest {
        public static final int BROKER_FLOW = 1003;
        public static final int BROWSER_FLOW = 1001;
        public static final int TOKEN_FLOW = 1002;

        private UIRequest() {
        }
    }

    public static final class BrokerResponse {
        public static final int BROKER_ERROR_RESPONSE = 2002;
        public static final int BROKER_OPERATION_CANCELLED = 2001;
        public static final int BROKER_SUCCESS_RESPONSE = 2004;

        private BrokerResponse() {
        }
    }

    public static final class Browser {
        public static final String REQUEST_MESSAGE = "com.microsoft.aad.adal:BrowserRequestMessage";
        public static final String RESPONSE_ERROR_CODE = "com.microsoft.aad.adal:BrowserErrorCode";
        public static final String RESPONSE_EXCEPTION = "com.microsoft.aad.adal:AuthenticationException";
        public static final String RESPONSE_FINAL_URL = "com.microsoft.aad.adal:BrowserFinalUrl";
        public static final String SUB_ERROR_UI_CANCEL = "cancel";

        private Browser() {
        }
    }

    public static final class OAuth2 {
        public static final String AAD_PREFERRED_USERNAME = "preferred_username";
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
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_CODES = "error_codes";
        public static final String ERROR_DESCRIPTION = "error_description";
        public static final String ERROR_SUBCODE = "error_subcode";
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
        public static final String UTID = "utid";

        private OAuth2() {
        }
    }

    public static final class AAD {
        public static final String AAD_VERSION = "ver";
        public static final String AAD_VERSION_V1 = "1.0";
        public static final String AAD_VERSION_V2 = "2.0";
        public static final String APP_LINK_KEY = "app_link";
        public static final String APP_PACKAGE_NAME = "x-app-name";
        public static final String APP_VERSION = "x-app-ver";
        public static final String AUTHORIZATION = "Authorization";
        public static final String BEARER = "Bearer";
        public static final String CLIENT_REQUEST_ID = "client-request-id";
        public static final String CORRELATION_ID = "correlation_id";
        public static final String DEVICE_REGISTRATION_REDIRECT_URI_HOSTNAME = "wpj";
        public static final String LOGIN_HINT = "login_hint";
        public static final String QUERY_PROMPT_VALUE = "login";
        public static final String REALM = "realm";
        public static final String REDIRECT_PREFIX = "msauth";
        public static final String REQUEST_ID_HEADER = "x-ms-request-id";
        public static final String RESOURCE = "resource";
        public static final String RETURN_CLIENT_REQUEST_ID = "return-client-request-id";
        public static final String TOKEN_PROTECTION_REQUIRED_KEY = "token_protection_required";
        public static final String UPGRADE_DEVICE_REGISTRATION_REDIRECT_URI_HOSTNAME = "upgradeReg";
        public static final String UPN_TO_WPJ_KEY = "username";

        private AAD() {
        }
    }

    public static final class Broker {
        public static final String BROKER_ACCOUNT_TYPE = "com.microsoft.workaccount";
        public static final String BROKER_CLIENT_ID = "29d9ed98-a469-4536-ade2-f981bc1d605e";
        public static final String CHALLENGE_REQUEST_HEADER = "WWW-Authenticate";
        public static final String CHALLENGE_RESPONSE_HEADER = "Authorization";
        public static final String CHALLENGE_RESPONSE_TYPE = "PKeyAuth";
        public static final String PKEYAUTH_HEADER = "x-ms-PKeyAuth";
        public static final String PKEYAUTH_VERSION = "1.0";
        public static final long BROKER_TASK_DEFAULT_TIMEOUT_MILLISECONDS = TimeUnit.SECONDS.toMillis(30);
        public static final long DCF_TOKEN_REQUEST_TIMEOUT_MILLISECONDS = TimeUnit.MINUTES.toMillis(15);

        private Broker() {
        }
    }

    public static final class OAuth2Scopes {
        public static final String AZA_SCOPE = "aza";
        public static final String CLAIMS_UPDATE_RESOURCE = "urn:aad:tb:update:prt/.default";
        public static final String EMAIL_SCOPE = "email";
        public static final String OFFLINE_ACCESS_SCOPE = "offline_access";
        public static final String OPEN_ID_SCOPE = "openid";
        public static final String PROFILE_SCOPE = "profile";
        public static final String TRANSFER_TOKEN_SCOPE = "service::http://Passport.NET/purpose::PURPOSE_TRANSFER_TOKEN_BACKUP_RESTORE";

        private OAuth2Scopes() {
        }
    }
}
