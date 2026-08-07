package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsAuthorizationRequest extends MicrosoftAuthorizationRequest<MicrosoftStsAuthorizationRequest> {
    private static final String AUTHORIZATION_ENDPOINT = "oAuth2/v2.0/authorize";
    public static final String HIDE_SWITCH_USER_QUERY_PARAMETER = "hsu";
    private static final Object TAG = "MicrosoftStsAuthorizationRequest";
    private static final long serialVersionUID = 6545759826515911472L;
    private final transient String mApplicationIdentifier;

    @SerializedName("cpVersion")
    @Expose
    private final String mCompanyPortalVersion;
    private final transient String mDisplayableId;
    protected transient Map<String, String> mFlightParameters;
    private final transient String mMamEnrollmentIdentifier;
    private final transient OpenIdProviderConfiguration mOpenIdProviderConfiguration;

    @SerializedName(AuthenticationConstants.AAD.QUERY_PROMPT)
    @Expose
    private final String mPrompt;
    protected transient AzureActiveDirectorySlice mSlice;

    @SerializedName("switch_browser")
    private final String mSwitchBrowser;
    private final transient String mTokenScope;

    @SerializedName("login_req")
    private final String mUid;

    @SerializedName("domain_req")
    private final String mUtid;

    public static final class Prompt {
        public static final String CONSENT = "consent";
        public static final String FORCE_LOGIN = "login";
        public static final String SELECT_ACCOUNT = "select_account";
    }

    public String getPrompt() {
        return this.mPrompt;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtid() {
        return this.mUtid;
    }

    public String getApplicationIdentifier() {
        return this.mApplicationIdentifier;
    }

    public String getMamEnrollmentIdentifier() {
        return this.mMamEnrollmentIdentifier;
    }

    public String getDisplayableId() {
        return this.mDisplayableId;
    }

    public String getTokenScope() {
        return this.mTokenScope;
    }

    public String getSwitchBrowser() {
        return this.mSwitchBrowser;
    }

    protected MicrosoftStsAuthorizationRequest(Builder builder) {
        super(builder);
        this.mPrompt = builder.mPrompt;
        this.mUid = builder.mUid;
        this.mUtid = builder.mUtid;
        this.mCompanyPortalVersion = builder.mCompanyPortalVersion;
        this.mDisplayableId = builder.mDisplayableId;
        this.mTokenScope = builder.mTokenScope;
        this.mSlice = builder.mSlice;
        this.mFlightParameters = builder.mFlightParameters;
        this.mApplicationIdentifier = builder.mApplicationIdentifier;
        this.mMamEnrollmentIdentifier = builder.mMamEnrollmentIdentifier;
        this.mOpenIdProviderConfiguration = builder.mOpenIdProviderConfiguration;
        this.mSwitchBrowser = builder.mSwitchBrowser;
    }

    public static class Builder extends MicrosoftAuthorizationRequest.Builder<Builder> {
        private String mApplicationIdentifier;
        private String mCompanyPortalVersion;
        private String mDisplayableId;
        private Map<String, String> mFlightParameters = new HashMap();
        private String mMamEnrollmentIdentifier;
        private OpenIdProviderConfiguration mOpenIdProviderConfiguration;
        private String mPrompt;
        private AzureActiveDirectorySlice mSlice;
        private String mSwitchBrowser;
        private String mTokenScope;
        private String mUid;
        private String mUtid;

        @Override // com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest.Builder, com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public Builder self() {
            return this;
        }

        public Builder setUid(String str) {
            this.mUid = str;
            return self();
        }

        public Builder setUtid(String str) {
            this.mUtid = str;
            return self();
        }

        public Builder setApplicationIdentifier(String str) {
            this.mApplicationIdentifier = str;
            return self();
        }

        public Builder setMamEnrollmentIdentifier(String str) {
            this.mMamEnrollmentIdentifier = str;
            return self();
        }

        public Builder setDisplayableId(String str) {
            this.mDisplayableId = str;
            return self();
        }

        public Builder setTokenScope(String str) {
            this.mTokenScope = str;
            return self();
        }

        public Builder setInstalledCompanyPortalVersion(String str) {
            this.mCompanyPortalVersion = str;
            return self();
        }

        public Builder setPrompt(String str) {
            this.mPrompt = str;
            return self();
        }

        public Builder setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
            this.mSlice = azureActiveDirectorySlice;
            return self();
        }

        public Builder setFlightParameters(Map<String, String> map) {
            this.mFlightParameters = map;
            return self();
        }

        public Builder setOpenIdProviderConfiguration(OpenIdProviderConfiguration openIdProviderConfiguration) {
            this.mOpenIdProviderConfiguration = openIdProviderConfiguration;
            return self();
        }

        public Builder setSwitchBrowser(String str) {
            this.mSwitchBrowser = str;
            return self();
        }

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public MicrosoftStsAuthorizationRequest build() {
            return new MicrosoftStsAuthorizationRequest(this);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public URI getAuthorizationRequestAsHttpRequest() throws ClientException {
        CommonURIBuilder commonURIBuilder = new CommonURIBuilder(super.getAuthorizationRequestAsHttpRequest());
        commonURIBuilder.addParametersIfAbsent(this.mFlightParameters);
        AzureActiveDirectorySlice azureActiveDirectorySlice = this.mSlice;
        if (azureActiveDirectorySlice != null) {
            if (!StringUtil.isNullOrEmpty(azureActiveDirectorySlice.getSlice())) {
                commonURIBuilder.addParameterIfAbsent(AzureActiveDirectorySlice.SLICE_PARAMETER, this.mSlice.getSlice());
            }
            if (!StringUtil.isNullOrEmpty(this.mSlice.getDataCenter())) {
                commonURIBuilder.addParameterIfAbsent("dc", this.mSlice.getDataCenter());
            }
        }
        if (!StringUtil.isNullOrEmpty(getLoginHint())) {
            commonURIBuilder.addParameterIfAbsent(HIDE_SWITCH_USER_QUERY_PARAMETER, "1");
        }
        try {
            return commonURIBuilder.build();
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest
    public String getAuthorizationEndpoint() throws ClientException {
        OpenIdProviderConfiguration openIdProviderConfiguration = this.mOpenIdProviderConfiguration;
        if (openIdProviderConfiguration != null) {
            return openIdProviderConfiguration.getAuthorizationEndpoint();
        }
        if (getAuthority() == null) {
            Logger.error(TAG + ":getAuthorizationEndpoint", "Authority is null. cannot construct authorization endpoint URL.", null);
            throw new IllegalStateException("Authority is null.");
        }
        try {
            return UrlUtil.appendPathToURL(getAuthority(), AUTHORIZATION_ENDPOINT).toString();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }
}
