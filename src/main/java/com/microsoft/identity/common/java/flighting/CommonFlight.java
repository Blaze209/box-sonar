package com.microsoft.identity.common.java.flighting;

/* JADX INFO: loaded from: classes14.dex */
public enum CommonFlight implements IFlightConfig {
    USE_NETWORK_CAPABILITY_FOR_NETWORK_CHECK("UseNetworkCapabilityForNetworkCheck", false),
    EXPOSE_CCS_REQUEST_ID_IN_TOKENRESPONSE("ExposeCcsRequestIdInTokenResponse", true),
    EXPOSE_CCS_REQUEST_SEQUENCE_IN_TOKENRESPONSE("ExposeCcsRequestSequenceInTokenResponse", true),
    ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS("AcquireTokenSilentTimeoutMilliSeconds", 30000),
    ENABLE_PASSKEY_REGISTRATION("EnablePasskeyRegistration", false),
    URL_CONNECTION_CONNECT_TIME_OUT("UrlConnectionConnectTimeOut", 30000),
    URL_CONNECTION_READ_TIME_OUT("UrlConnectionReadTimeOut", 30000),
    DISABLE_NETWORK_CONNECTIVITY_CHECK("DisableNetworkConnectivityCheck", true),
    STOP_RETURNING_AAD_RT_BACK_TO_CALLING_APP("StopReturningAadRtBackToCallingApp", false),
    ENABLE_LEGACY_FIDO_SECURITY_KEY_LOGIC("EnableLegacyFidoSecurityKeyLogic", true),
    ENABLE_ATTACH_NEW_PRT_HEADER_WHEN_NONCE_EXPIRED("EnableAttachNewPrtHeaderWhenNonceExpired", true),
    ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITH_PURPOSE_WRAP_KEY("EnableNewKeyGenSpecForWrapWithPurposeWrapKey", true),
    ENABLE_ATTACH_PRT_HEADER_WHEN_CROSS_CLOUD("EnableAttachPrtHeaderWhenCrossCloud", true),
    SWITCH_BROWSER_PROTOCOL_REQUIRES_STATE("SwitchBrowserProtocolRequiresState", false),
    ENABLE_AM_API_WORKPROFILE_EXTRA_QUERY_PARAMETERS("EnableAmApiWorkProfileExtraQueryParameters", true),
    ENABLE_NEW_KEY_GEN_SPEC_FOR_WRAP_WITHOUT_PURPOSE_WRAP_KEY("EnableNewKeyGenSpecForWrapWithoutPurposeWrapKey", true),
    ENABLE_JS_API_FOR_AUTHUX("EnableJsApiForAuthUx", true),
    ENABLE_OAEP_WITH_SHA_AND_MGF1_PADDING("EnableOAEPWithSHAAndMGF1Padding", false),
    ENABLE_KEYSTORE_BACKED_SECRET_KEY_PROVIDER("EnableKeyStoreBackedSecretKeyProvider", true),
    WRAPPED_SECRET_KEY_SERIALIZER_VERSION("WrappedSecretKeySerializerVersion", 0),
    ENABLE_HANDLING_FOR_EDGE_TO_EDGE("EnableHandlingEdgeToEdge", true),
    ENABLE_WEB_CP_IN_WEBVIEW("EnableWebCpInWebView", false),
    ENABLE_PLAYSTORE_URL_LAUNCH("EnablePlaystoreUrlLaunch", false),
    SHOULD_PRESERVE_WEBVIEW_FLOW_ON_SSL_ERROR("ShouldPreserveWebViewFlowOnSslError", true),
    ADD_USERNAME_IN_UI_REQUIRED_EXCEPTION_BROKER_RESULT("AddUsernameInUiRequiredExceptionBrokerResult", true),
    WEB_CP_WAIT_TIMEOUT_FOR_FLIGHTS("WebCpWaitTimeoutForFlights", 3000),
    ENABLE_WEBVIEW_SECURITY_SETTINGS("EnableWebViewSecuritySettings", false),
    SKIP_ESTS_TELEMETRY("SkipEstsTelemetry", false),
    ENABLE_OPENID_ISSUER_VALIDATION_REPORTING("EnableOpenIdIssuerValidationReporting", true);

    private Object defaultValue;
    private String key;

    CommonFlight(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (obj == null) {
            throw new NullPointerException("defaultValue is marked non-null but is null");
        }
        this.key = str;
        this.defaultValue = obj;
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightConfig
    public String getKey() {
        return this.key;
    }

    @Override // com.microsoft.identity.common.java.flighting.IFlightConfig
    public Object getDefaultValue() {
        return this.defaultValue;
    }
}
