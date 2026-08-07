package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
final class Constants {
    public static final String AUTHORIZATION_FINAL_URL = "com.microsoft.aad.adal:BrowserFinalUrl";
    public static final String CUSTOM_TAB_REDIRECT = "com.microsoft.identity.customtab.redirect";
    public static final String REQUEST_ID = "com.microsoft.aad.adal:RequestId";
    public static final String REQUEST_URL_KEY = "com.microsoft.identity.request.url.key";
    public static final String TELEMETRY_REQUEST_ID = "com.microsoft.identity.telemetry.request.id";
    public static final String WEBVIEW_SELECTION = "com.microsoft.identity.webview.selection";

    private Constants() {
    }

    static final class UIResponse {
        static final int AUTH_CODE_COMPLETE = 2003;
        static final int AUTH_CODE_ERROR = 2002;
        static final int CANCEL = 2001;
        static final String ERROR_CODE = "error_code";
        static final String ERROR_DESCRIPTION = "error_description";

        UIResponse() {
        }
    }

    static final class MsalErrorMessage {
        static final String AUTHORIZATION_SERVER_INVALID_RESPONSE = "The authorization server returned an invalid response.";
        static final String STATE_NOT_RETURNED = "State is not returned";
        static final String STATE_NOT_THE_SAME = "Returned state from authorize endpoint is not the same as the one sent";
        static final String USER_CANCELLED_FLOW = "User pressed device back button to cancel the flow.";

        MsalErrorMessage() {
        }
    }

    static final class MsalInternalError {
        static final String AUTHORIZATION_FAILED = "authorization_failed";
        static final String USER_CANCEL = "user_cancelled";

        MsalInternalError() {
        }
    }
}
