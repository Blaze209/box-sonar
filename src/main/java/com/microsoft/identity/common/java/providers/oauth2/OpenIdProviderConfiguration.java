package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class OpenIdProviderConfiguration {

    @SerializedName(SerializedNames.ACR_VALUES_SUPPORTED)
    private List<String> mAcrValuesSupported;

    @SerializedName(SerializedNames.AUTHORIZATION_ENDPOINT)
    private String mAuthorizationEndpoint;

    @SerializedName(SerializedNames.CHECK_SESSION_IFRAME)
    private String mCheckSessionIFrame;

    @SerializedName(SerializedNames.CLAIM_TYPES_SUPPORTED)
    private List<String> mClaimTypesSupported;

    @SerializedName(SerializedNames.CLAIMS_LOCALES_SUPPORTED)
    private List<String> mClaimsLocalesSupported;

    @SerializedName(SerializedNames.CLAIMS_PARAMETER_SUPPORTED)
    private Boolean mClaimsParameterSupported;

    @SerializedName(SerializedNames.CLAIMS_SUPPORTED)
    private List<String> mClaimsSupported;

    @SerializedName("cloud_graph_host_name")
    private String mCloudGraphHostName;

    @SerializedName("cloud_instance_name")
    private String mCloudInstanceName;

    @SerializedName(SerializedNames.DEVICE_AUTHORIZATION_ENDPOINT)
    private String mDeviceAuthorizationEndpoint;

    @SerializedName(SerializedNames.DISPLAY_VALUES_SUPPORTED)
    private List<String> mDisplayValuesSupported;

    @SerializedName(SerializedNames.END_SESSION_ENDPOINT)
    private String mEndSessionEndpoint;

    @SerializedName(SerializedNames.FRONTCHANNEL_LOGOUT_SUPPORTED)
    private Boolean mFrontChannelLogoutSupported;

    @SerializedName(SerializedNames.GRANT_TYPES_SUPPORTED)
    private List<String> mGrantTypesSupported;

    @SerializedName(SerializedNames.HTTP_LOGOUT_SUPPORTED)
    private Boolean mHttpLogoutSupported;

    @SerializedName(SerializedNames.ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED)
    private List<String> mIdTokenEncryptionAlgValuesSupported;

    @SerializedName(SerializedNames.ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED)
    private List<String> mIdTokenEncryptionEncValuesSupported;

    @SerializedName(SerializedNames.ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED)
    private List<String> mIdTokenSigningAlgValuesSupported;

    @SerializedName(SerializedNames.ISSUER)
    private String mIssuer;

    @SerializedName(SerializedNames.JWKS_URI)
    private String mJwksUri;

    @SerializedName(SerializedNames.MSGRAPH_HOST)
    private String mMsGraphHost;

    @SerializedName(SerializedNames.OP_POLICY_URI)
    private String mOpPolicyUri;

    @SerializedName(SerializedNames.OP_TOS_URI)
    private String mOpTosUri;

    @SerializedName(SerializedNames.RBAC_URL)
    private String mRbacUrl;

    @SerializedName(SerializedNames.REGISTRATION_ENDPOINT)
    private String mRegistrationEndpoint;

    @SerializedName(SerializedNames.REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED)
    private List<String> mRequestObjectEncryptionAlgValuesSupported;

    @SerializedName(SerializedNames.REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED)
    private List<String> mRequestObjectEncryptionEncValuesSupported;

    @SerializedName(SerializedNames.REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED)
    private List<String> mRequestObjectSigningAlgValuesSupported;

    @SerializedName(SerializedNames.REQUEST_PARAMETER_SUPPORTED)
    private Boolean mRequestParameterSupported;

    @SerializedName(SerializedNames.REQUEST_URI_PARAMETER_SUPPORTED)
    private Boolean mRequestUriParameterSupported;

    @SerializedName(SerializedNames.REQUIRE_REQUEST_URI_REGISTRATION)
    private Boolean mRequireRequestUriRegistration;

    @SerializedName(SerializedNames.RESPONSE_MODES_SUPPORTED)
    private List<String> mResponseModesSupported;

    @SerializedName(SerializedNames.RESPONSE_TYPES_SUPPORTED)
    private List<String> mResponseTypesSupported;

    @SerializedName(SerializedNames.SCOPES_SUPPORTED)
    private List<String> mScopesSupported;

    @SerializedName(SerializedNames.SERVICE_DOCUMENTATION)
    private String mServiceDocumentation;

    @SerializedName(SerializedNames.SUBJECT_TYPES_SUPPORTED)
    private List<String> mSubjectTypesSupported;

    @SerializedName(SerializedNames.TENANT_REGION_SCOPE)
    private String mTenantRegionScope;

    @SerializedName(SerializedNames.TENANT_REGION_SUB_SCOPE)
    private String mTenantRegionSubScope;

    @SerializedName(SerializedNames.TOKEN_ENDPOINT)
    private String mTokenEndpoint;

    @SerializedName(SerializedNames.TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED)
    private List<String> mTokenEndpointAuthMethodsSupported;

    @SerializedName(SerializedNames.TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED)
    private List<String> mTokenEndpointAuthSigningAlgValuesSupported;

    @SerializedName(SerializedNames.UI_LOCALES_SUPPORTED)
    private List<String> mUiLocalesSupported;

    @SerializedName(SerializedNames.USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED)
    private List<String> mUserInfoEncryptionAlgValuesSupported;

    @SerializedName(SerializedNames.USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED)
    private List<String> mUserInfoEncryptionEncValueSupported;

    @SerializedName(SerializedNames.USERINFO_ENDPOINT)
    private String mUserInfoEndpoint;

    @SerializedName(SerializedNames.USERINFO_SIGNING_ALG_VALUES_SUPPORTED)
    private List<String> mUserInfoSigningAlgValuesSupported;

    public static final class SerializedNames {
        public static final String ACR_VALUES_SUPPORTED = "acr_values_supported";
        public static final String AUTHORIZATION_ENDPOINT = "authorization_endpoint";
        public static final String CHECK_SESSION_IFRAME = "check_session_iframe";
        public static final String CLAIMS_LOCALES_SUPPORTED = "claims_locales_supported";
        public static final String CLAIMS_PARAMETER_SUPPORTED = "claims_parameter_supported";
        public static final String CLAIMS_SUPPORTED = "claims_supported";
        public static final String CLAIM_TYPES_SUPPORTED = "claim_types_supported";
        public static final String CLOUD_GRAPH_HOST_NAME = "cloud_graph_host_name";
        public static final String CLOUD_INSTANCE_NAME = "cloud_instance_name";
        public static final String DEVICE_AUTHORIZATION_ENDPOINT = "device_authorization_endpoint";
        public static final String DISPLAY_VALUES_SUPPORTED = "display_values_supported";
        public static final String END_SESSION_ENDPOINT = "end_session_endpoint";
        public static final String FRONTCHANNEL_LOGOUT_SUPPORTED = "frontchannel_logout_supported";
        public static final String GRANT_TYPES_SUPPORTED = "grant_types_supported";
        public static final String HTTP_LOGOUT_SUPPORTED = "http_logout_supported";
        public static final String ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED = "id_token_encryption_alg_values_supported";
        public static final String ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED = "id_token_encryption_enc_values_supported";
        public static final String ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED = "id_token_signing_alg_values_supported";
        public static final String ISSUER = "issuer";
        public static final String JWKS_URI = "jwks_uri";
        public static final String MSGRAPH_HOST = "msgraph_host";
        public static final String OP_POLICY_URI = "op_policy_uri";
        public static final String OP_TOS_URI = "op_tos_uri";
        public static final String RBAC_URL = "rbac_url";
        public static final String REGISTRATION_ENDPOINT = "registration_endpoint";
        public static final String REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED = "request_object_encryption_alg_values_supported";
        public static final String REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED = "request_object_encryption_enc_values_supported";
        public static final String REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED = "request_object_signing_alg_values_supported";
        public static final String REQUEST_PARAMETER_SUPPORTED = "request_parameter_supported";
        public static final String REQUEST_URI_PARAMETER_SUPPORTED = "request_uri_parameter_supported";
        public static final String REQUIRE_REQUEST_URI_REGISTRATION = "require_request_uri_registration";
        public static final String RESPONSE_MODES_SUPPORTED = "response_modes_supported";
        public static final String RESPONSE_TYPES_SUPPORTED = "response_types_supported";
        public static final String SCOPES_SUPPORTED = "scopes_supported";
        public static final String SERVICE_DOCUMENTATION = "service_documentation";
        public static final String SUBJECT_TYPES_SUPPORTED = "subject_types_supported";
        public static final String TENANT_REGION_SCOPE = "tenant_region_scope";
        public static final String TENANT_REGION_SUB_SCOPE = "tenant_region_sub_scope";
        public static final String TOKEN_ENDPOINT = "token_endpoint";
        public static final String TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED = "token_endpoint_auth_methods_supported";
        public static final String TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED = "token_endpoint_auth_signing_alg_values_supported";
        public static final String UI_LOCALES_SUPPORTED = "ui_locales_supported";
        public static final String USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED = "userinfo_encryption_alg_values_supported";
        public static final String USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED = "userinfo_encryption_enc_values_supported";
        public static final String USERINFO_ENDPOINT = "userinfo_endpoint";
        public static final String USERINFO_SIGNING_ALG_VALUES_SUPPORTED = "userinfo_signing_alg_values_supported";
    }

    public String getAuthorizationEndpoint() {
        return this.mAuthorizationEndpoint;
    }

    public String getDeviceAuthorizationEndpoint() {
        return this.mDeviceAuthorizationEndpoint;
    }

    public String getTokenEndpoint() {
        return this.mTokenEndpoint;
    }

    public List<String> getTokenEndpointAuthMethodsSupported() {
        return this.mTokenEndpointAuthMethodsSupported;
    }

    public String getJwksUri() {
        return this.mJwksUri;
    }

    public List<String> getResponseModesSupported() {
        return this.mResponseModesSupported;
    }

    public List<String> getSubjectTypesSupported() {
        return this.mSubjectTypesSupported;
    }

    public List<String> getIdTokenSigningAlgValuesSupported() {
        return this.mIdTokenSigningAlgValuesSupported;
    }

    public Boolean getHttpLogoutSupported() {
        return this.mHttpLogoutSupported;
    }

    public Boolean getFrontChannelLogoutSupported() {
        return this.mFrontChannelLogoutSupported;
    }

    public String getEndSessionEndpoint() {
        return this.mEndSessionEndpoint;
    }

    public List<String> getResponseTypesSupported() {
        return this.mResponseTypesSupported;
    }

    public List<String> getScopesSupported() {
        return this.mScopesSupported;
    }

    public String getIssuer() {
        return this.mIssuer;
    }

    public List<String> getClaimsSupported() {
        return this.mClaimsSupported;
    }

    public Boolean getRequestUriParameterSupported() {
        return this.mRequestUriParameterSupported;
    }

    public String getUserInfoEndpoint() {
        return this.mUserInfoEndpoint;
    }

    public String getTenantRegionScope() {
        return this.mTenantRegionScope;
    }

    public String getTenantRegionSubScope() {
        return this.mTenantRegionSubScope;
    }

    public String getCloudInstanceName() {
        return this.mCloudInstanceName;
    }

    public String getCloudGraphHostName() {
        return this.mCloudGraphHostName;
    }

    public String getMsGraphHost() {
        return this.mMsGraphHost;
    }

    public String getRbacUrl() {
        return this.mRbacUrl;
    }

    public String getRegistrationEndpoint() {
        return this.mRegistrationEndpoint;
    }

    public List<String> getGrantTypesSupported() {
        return this.mGrantTypesSupported;
    }

    public List<String> getAcrValuesSupported() {
        return this.mAcrValuesSupported;
    }

    public List<String> getIdTokenEncryptionAlgValuesSupported() {
        return this.mIdTokenEncryptionAlgValuesSupported;
    }

    public List<String> getIdTokenEncryptionEncValuesSupported() {
        return this.mIdTokenEncryptionEncValuesSupported;
    }

    public List<String> getUserInfoSigningAlgValuesSupported() {
        return this.mUserInfoSigningAlgValuesSupported;
    }

    public List<String> getUserInfoEncryptionAlgValuesSupported() {
        return this.mUserInfoEncryptionAlgValuesSupported;
    }

    public List<String> getUserInfoEncryptionEncValueSupported() {
        return this.mUserInfoEncryptionEncValueSupported;
    }

    public List<String> getRequestObjectSigningAlgValuesSupported() {
        return this.mRequestObjectSigningAlgValuesSupported;
    }

    public List<String> getRequestObjectEncryptionAlgValuesSupported() {
        return this.mRequestObjectEncryptionAlgValuesSupported;
    }

    public List<String> getRequestObjectEncryptionEncValuesSupported() {
        return this.mRequestObjectEncryptionEncValuesSupported;
    }

    public List<String> getTokenEndpointAuthSigningAlgValuesSupported() {
        return this.mTokenEndpointAuthSigningAlgValuesSupported;
    }

    public List<String> getDisplayValuesSupported() {
        return this.mDisplayValuesSupported;
    }

    public List<String> getClaimTypesSupported() {
        return this.mClaimTypesSupported;
    }

    public String getServiceDocumentation() {
        return this.mServiceDocumentation;
    }

    public List<String> getClaimsLocalesSupported() {
        return this.mClaimsLocalesSupported;
    }

    public List<String> getUiLocalesSupported() {
        return this.mUiLocalesSupported;
    }

    public Boolean getClaimsParameterSupported() {
        return this.mClaimsParameterSupported;
    }

    public Boolean getRequestParameterSupported() {
        return this.mRequestParameterSupported;
    }

    public Boolean getRequireRequestUriRegistration() {
        return this.mRequireRequestUriRegistration;
    }

    public String getOpPolicyUri() {
        return this.mOpPolicyUri;
    }

    public String getOpTosUri() {
        return this.mOpTosUri;
    }

    public String getCheckSessionIFrame() {
        return this.mCheckSessionIFrame;
    }
}
