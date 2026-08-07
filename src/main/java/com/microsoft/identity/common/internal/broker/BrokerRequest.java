package com.microsoft.identity.common.internal.broker;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleCredential;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import java.io.Serializable;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerRequest implements Serializable {
    private static final long serialVersionUID = -543392127065130474L;

    @SerializedName("account_transfer_token")
    private String mAccountTransferToken;

    @SerializedName("client_app_name")
    private String mApplicationName;

    @SerializedName("client_app_version")
    private String mApplicationVersion;

    @SerializedName(ArgumentException.AUTHENTICATION_SCHEME_ARGUMENT_NAME)
    private AbstractAuthenticationScheme mAuthenticationScheme;

    @SerializedName("authority")
    private String mAuthority;

    @SerializedName("authorization_agent")
    private String mAuthorizationAgent;

    @SerializedName("child_client_id")
    private String mChildClientId;

    @SerializedName("child_redirect_uri")
    private String mChildRedirectUri;

    @SerializedName("claims")
    private String mClaims;

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName("correlation_id")
    private String mCorrelationId;

    @SerializedName("environment")
    private String mEnvironment;

    @SerializedName("extra_options")
    private String mExtraOptions;

    @SerializedName("extra_query_param")
    private String mExtraQueryStringParameter;

    @SerializedName("force_refresh")
    private boolean mForceRefresh;

    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @SerializedName(AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID)
    private String mLocalAccountId;

    @SerializedName("client_version")
    private String mMsalVersion;

    @SerializedName("multiple_clouds_supported")
    private boolean mMultipleCloudsSupported;

    @SerializedName("power_opt_check_enabled")
    private boolean mPowerOptCheckEnabled;

    @SerializedName("preferred_auth_method")
    private PreferredAuthMethod mPreferredAuthMethod;

    @SerializedName("preferred_browser")
    private BrowserDescriptor mPreferredBrowser;

    @SerializedName(AuthenticationConstants.AAD.QUERY_PROMPT)
    private String mPrompt;

    @SerializedName("redirect_uri")
    private String mRedirect;

    @SerializedName("scopes")
    private String mScope;

    @SerializedName("client_sdk_type")
    private SdkType mSdkType;

    @SerializedName("sign_in_with_google_credential")
    private SignInWithGoogleCredential mSignInWithGoogleCredential;

    @SerializedName("span_context")
    private SerializableSpanContext mSpanContext;

    @SerializedName("suppress_account_picker")
    private boolean mSuppressAccountPicker;

    @SerializedName("tenant_id")
    private String mTenantId;

    @SerializedName("username")
    private String mUserName;

    public static class BrokerRequestBuilder {
        private String accountTransferToken;
        private String applicationName;
        private String applicationVersion;
        private AbstractAuthenticationScheme authenticationScheme;
        private String authority;
        private String authorizationAgent;
        private String childClientId;
        private String childRedirectUri;
        private String claims;
        private String clientId;
        private String correlationId;
        private String environment;
        private String extraOptions;
        private String extraQueryStringParameter;
        private boolean forceRefresh;
        private String homeAccountId;
        private String localAccountId;
        private String msalVersion;
        private boolean multipleCloudsSupported;
        private boolean powerOptCheckEnabled;
        private PreferredAuthMethod preferredAuthMethod;
        private BrowserDescriptor preferredBrowser;
        private String prompt;
        private String redirect;
        private String scope;
        private SdkType sdkType;
        private SignInWithGoogleCredential signInWithGoogleCredential;
        private SerializableSpanContext spanContext;
        private boolean suppressAccountPicker;
        private String tenantId;
        private String userName;

        BrokerRequestBuilder() {
        }

        public BrokerRequestBuilder accountTransferToken(String str) {
            this.accountTransferToken = str;
            return this;
        }

        public BrokerRequestBuilder applicationName(String str) {
            if (str == null) {
                throw new NullPointerException("applicationName is marked non-null but is null");
            }
            this.applicationName = str;
            return this;
        }

        public BrokerRequestBuilder applicationVersion(String str) {
            if (str == null) {
                throw new NullPointerException("applicationVersion is marked non-null but is null");
            }
            this.applicationVersion = str;
            return this;
        }

        public BrokerRequestBuilder authenticationScheme(AbstractAuthenticationScheme abstractAuthenticationScheme) {
            this.authenticationScheme = abstractAuthenticationScheme;
            return this;
        }

        public BrokerRequestBuilder authority(String str) {
            this.authority = str;
            return this;
        }

        public BrokerRequestBuilder authorizationAgent(String str) {
            this.authorizationAgent = str;
            return this;
        }

        public BrokerRequest build() {
            return new BrokerRequest(this.authority, this.scope, this.redirect, this.clientId, this.userName, this.homeAccountId, this.localAccountId, this.extraQueryStringParameter, this.extraOptions, this.correlationId, this.prompt, this.childRedirectUri, this.childClientId, this.claims, this.forceRefresh, this.applicationName, this.applicationVersion, this.msalVersion, this.sdkType, this.environment, this.multipleCloudsSupported, this.authorizationAgent, this.authenticationScheme, this.powerOptCheckEnabled, this.spanContext, this.preferredBrowser, this.preferredAuthMethod, this.accountTransferToken, this.suppressAccountPicker, this.signInWithGoogleCredential, this.tenantId);
        }

        public BrokerRequestBuilder childClientId(String str) {
            this.childClientId = str;
            return this;
        }

        public BrokerRequestBuilder childRedirectUri(String str) {
            this.childRedirectUri = str;
            return this;
        }

        public BrokerRequestBuilder claims(String str) {
            this.claims = str;
            return this;
        }

        public BrokerRequestBuilder clientId(String str) {
            if (str == null) {
                throw new NullPointerException("clientId is marked non-null but is null");
            }
            this.clientId = str;
            return this;
        }

        public BrokerRequestBuilder correlationId(String str) {
            if (str == null) {
                throw new NullPointerException("correlationId is marked non-null but is null");
            }
            this.correlationId = str;
            return this;
        }

        public BrokerRequestBuilder environment(String str) {
            if (str == null) {
                throw new NullPointerException("environment is marked non-null but is null");
            }
            this.environment = str;
            return this;
        }

        public BrokerRequestBuilder extraOptions(String str) {
            this.extraOptions = str;
            return this;
        }

        public BrokerRequestBuilder extraQueryStringParameter(String str) {
            this.extraQueryStringParameter = str;
            return this;
        }

        public BrokerRequestBuilder forceRefresh(boolean z) {
            this.forceRefresh = z;
            return this;
        }

        public BrokerRequestBuilder homeAccountId(String str) {
            this.homeAccountId = str;
            return this;
        }

        public BrokerRequestBuilder localAccountId(String str) {
            this.localAccountId = str;
            return this;
        }

        public BrokerRequestBuilder msalVersion(String str) {
            if (str == null) {
                throw new NullPointerException("msalVersion is marked non-null but is null");
            }
            this.msalVersion = str;
            return this;
        }

        public BrokerRequestBuilder multipleCloudsSupported(boolean z) {
            this.multipleCloudsSupported = z;
            return this;
        }

        public BrokerRequestBuilder powerOptCheckEnabled(boolean z) {
            this.powerOptCheckEnabled = z;
            return this;
        }

        public BrokerRequestBuilder preferredAuthMethod(PreferredAuthMethod preferredAuthMethod) {
            this.preferredAuthMethod = preferredAuthMethod;
            return this;
        }

        public BrokerRequestBuilder preferredBrowser(BrowserDescriptor browserDescriptor) {
            this.preferredBrowser = browserDescriptor;
            return this;
        }

        public BrokerRequestBuilder prompt(String str) {
            this.prompt = str;
            return this;
        }

        public BrokerRequestBuilder redirect(String str) {
            if (str == null) {
                throw new NullPointerException("redirect is marked non-null but is null");
            }
            this.redirect = str;
            return this;
        }

        public BrokerRequestBuilder scope(String str) {
            this.scope = str;
            return this;
        }

        public BrokerRequestBuilder sdkType(SdkType sdkType) {
            if (sdkType == null) {
                throw new NullPointerException("sdkType is marked non-null but is null");
            }
            this.sdkType = sdkType;
            return this;
        }

        public BrokerRequestBuilder signInWithGoogleCredential(SignInWithGoogleCredential signInWithGoogleCredential) {
            this.signInWithGoogleCredential = signInWithGoogleCredential;
            return this;
        }

        public BrokerRequestBuilder spanContext(SerializableSpanContext serializableSpanContext) {
            this.spanContext = serializableSpanContext;
            return this;
        }

        public BrokerRequestBuilder suppressAccountPicker(boolean z) {
            this.suppressAccountPicker = z;
            return this;
        }

        public BrokerRequestBuilder tenantId(String str) {
            this.tenantId = str;
            return this;
        }

        public String toString() {
            return "BrokerRequest.BrokerRequestBuilder(authority=" + this.authority + ", scope=" + this.scope + ", redirect=" + this.redirect + ", clientId=" + this.clientId + ", userName=" + this.userName + ", homeAccountId=" + this.homeAccountId + ", localAccountId=" + this.localAccountId + ", extraQueryStringParameter=" + this.extraQueryStringParameter + ", extraOptions=" + this.extraOptions + ", correlationId=" + this.correlationId + ", prompt=" + this.prompt + ", childRedirectUri=" + this.childRedirectUri + ", childClientId=" + this.childClientId + ", claims=" + this.claims + ", forceRefresh=" + this.forceRefresh + ", applicationName=" + this.applicationName + ", applicationVersion=" + this.applicationVersion + ", msalVersion=" + this.msalVersion + ", sdkType=" + this.sdkType + ", environment=" + this.environment + ", multipleCloudsSupported=" + this.multipleCloudsSupported + ", authorizationAgent=" + this.authorizationAgent + ", authenticationScheme=" + this.authenticationScheme + ", powerOptCheckEnabled=" + this.powerOptCheckEnabled + ", spanContext=" + this.spanContext + ", preferredBrowser=" + this.preferredBrowser + ", preferredAuthMethod=" + this.preferredAuthMethod + ", accountTransferToken=" + this.accountTransferToken + ", suppressAccountPicker=" + this.suppressAccountPicker + ", signInWithGoogleCredential=" + this.signInWithGoogleCredential + ", tenantId=" + this.tenantId + ")";
        }

        public BrokerRequestBuilder userName(String str) {
            this.userName = str;
            return this;
        }
    }

    BrokerRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, boolean z, String str15, String str16, String str17, SdkType sdkType, String str18, boolean z2, String str19, AbstractAuthenticationScheme abstractAuthenticationScheme, boolean z3, SerializableSpanContext serializableSpanContext, BrowserDescriptor browserDescriptor, PreferredAuthMethod preferredAuthMethod, String str20, boolean z4, SignInWithGoogleCredential signInWithGoogleCredential, String str21) {
        if (str3 == null) {
            throw new NullPointerException("redirect is marked non-null but is null");
        }
        if (str4 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str10 == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (str15 == null) {
            throw new NullPointerException("applicationName is marked non-null but is null");
        }
        if (str16 == null) {
            throw new NullPointerException("applicationVersion is marked non-null but is null");
        }
        if (str17 == null) {
            throw new NullPointerException("msalVersion is marked non-null but is null");
        }
        if (sdkType == null) {
            throw new NullPointerException("sdkType is marked non-null but is null");
        }
        if (str18 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        this.mAuthority = str;
        this.mScope = str2;
        this.mRedirect = str3;
        this.mClientId = str4;
        this.mUserName = str5;
        this.mHomeAccountId = str6;
        this.mLocalAccountId = str7;
        this.mExtraQueryStringParameter = str8;
        this.mExtraOptions = str9;
        this.mCorrelationId = str10;
        this.mPrompt = str11;
        this.mChildRedirectUri = str12;
        this.mChildClientId = str13;
        this.mClaims = str14;
        this.mForceRefresh = z;
        this.mApplicationName = str15;
        this.mApplicationVersion = str16;
        this.mMsalVersion = str17;
        this.mSdkType = sdkType;
        this.mEnvironment = str18;
        this.mMultipleCloudsSupported = z2;
        this.mAuthorizationAgent = str19;
        this.mAuthenticationScheme = abstractAuthenticationScheme;
        this.mPowerOptCheckEnabled = z3;
        this.mSpanContext = serializableSpanContext;
        this.mPreferredBrowser = browserDescriptor;
        this.mPreferredAuthMethod = preferredAuthMethod;
        this.mAccountTransferToken = str20;
        this.mSuppressAccountPicker = z4;
        this.mSignInWithGoogleCredential = signInWithGoogleCredential;
        this.mTenantId = str21;
    }

    public static BrokerRequestBuilder builder() {
        return new BrokerRequestBuilder();
    }

    private static final class SerializedNames {
        static final String ACCOUNT_TRANSFER_TOKEN = "account_transfer_token";
        static final String AUTHENTICATION_SCHEME = "authentication_scheme";
        static final String AUTHORITY = "authority";
        static final String AUTHORIZATION_AGENT = "authorization_agent";
        static final String CHILD_CLIENT_ID = "child_client_id";
        static final String CHILD_REDIRECT_URI = "child_redirect_uri";
        static final String CLAIMS = "claims";
        static final String CLIENT_APP_NAME = "client_app_name";
        static final String CLIENT_APP_VERSION = "client_app_version";
        static final String CLIENT_ID = "client_id";
        static final String CLIENT_SDK_TYPE = "client_sdk_type";
        static final String CLIENT_VERSION = "client_version";
        static final String CORRELATION_ID = "correlation_id";
        static final String ENVIRONMENT = "environment";
        static final String EXTRA_OPTIONS = "extra_options";
        static final String EXTRA_QUERY_STRING_PARAMETER = "extra_query_param";
        static final String FORCE_REFRESH = "force_refresh";
        static final String HOME_ACCOUNT_ID = "home_account_id";
        static final String LOCAL_ACCOUNT_ID = "local_account_id";
        static final String MULTIPLE_CLOUDS_SUPPORTED = "multiple_clouds_supported";
        static final String POWER_OPT_CHECK_ENABLED = "power_opt_check_enabled";
        static final String PREFERRED_AUTH_METHOD = "preferred_auth_method";
        static final String PREFERRED_BROWSER = "preferred_browser";
        static final String PROMPT = "prompt";
        static final String REDIRECT = "redirect_uri";
        static final String SCOPE = "scopes";
        static final String SIGN_IN_WITH_GOOGLE_CREDENTIAL = "sign_in_with_google_credential";
        static final String SPAN_CONTEXT = "span_context";
        static final String SUPPRESS_ACCOUNT_PICKER = "suppress_account_picker";
        static final String TENANT_ID = "tenant_id";
        static final String USERNAME = "username";

        private SerializedNames() {
        }
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getRedirect() {
        return this.mRedirect;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getLocalAccountId() {
        return this.mLocalAccountId;
    }

    public String getExtraQueryStringParameter() {
        return this.mExtraQueryStringParameter;
    }

    public String getExtraOptions() {
        return this.mExtraOptions;
    }

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public String getChildRedirectUri() {
        return this.mChildRedirectUri;
    }

    public String getChildClientId() {
        return this.mChildClientId;
    }

    public String getClaims() {
        return this.mClaims;
    }

    public boolean isForceRefresh() {
        return this.mForceRefresh;
    }

    public String getApplicationName() {
        return this.mApplicationName;
    }

    public String getApplicationVersion() {
        return this.mApplicationVersion;
    }

    public String getMsalVersion() {
        return this.mMsalVersion;
    }

    public SdkType getSdkType() {
        return this.mSdkType;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public boolean isMultipleCloudsSupported() {
        return this.mMultipleCloudsSupported;
    }

    public String getAuthorizationAgent() {
        return this.mAuthorizationAgent;
    }

    public AbstractAuthenticationScheme getAuthenticationScheme() {
        return this.mAuthenticationScheme;
    }

    public boolean isPowerOptCheckEnabled() {
        return this.mPowerOptCheckEnabled;
    }

    public SerializableSpanContext getSpanContext() {
        return this.mSpanContext;
    }

    public BrowserDescriptor getPreferredBrowser() {
        return this.mPreferredBrowser;
    }

    public PreferredAuthMethod getPreferredAuthMethod() {
        return this.mPreferredAuthMethod;
    }

    public String getAccountTransferToken() {
        return this.mAccountTransferToken;
    }

    public boolean isSuppressAccountPicker() {
        return this.mSuppressAccountPicker;
    }

    public SignInWithGoogleCredential getSignInWithGoogleCredential() {
        return this.mSignInWithGoogleCredential;
    }

    public String getTenantId() {
        return this.mTenantId;
    }
}
