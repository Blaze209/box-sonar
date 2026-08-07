package com.microsoft.identity.common.java.providers.microsoft;

import com.box.androidsdk.content.auth.OAuthWebView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.DefaultStateGenerator;
import com.microsoft.identity.common.java.providers.oauth2.PkceChallenge;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import java.net.URL;
import java.util.UUID;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public abstract class MicrosoftAuthorizationRequest<T extends MicrosoftAuthorizationRequest<T>> extends AuthorizationRequest<T> {
    public static final String INSTANCE_AWARE = "instance_aware";
    private static final String TAG = "MicrosoftAuthorizationRequest";
    public static final String WP_AVAILABLE_EXTRA_PARAMETER_NAME = "x-client-WPAvailable";
    private static final long serialVersionUID = 6873634931996113294L;
    private final transient URL mAuthority;

    @SerializedName("client-request-id")
    @Expose
    private final UUID mCorrelationId;

    @SerializedName("x-client-CPU")
    @Expose
    private final String mDiagnosticCPU;

    @SerializedName("x-client-DM")
    @Expose
    private final String mDiagnosticDM;

    @SerializedName(Device.PlatformIdParameters.MANUFACTURER)
    @Expose
    private final String mDiagnosticMN;

    @SerializedName("x-client-OS")
    @Expose
    private final String mDiagnosticOS;

    @SerializedName("x-client-ReleaseOS")
    @Expose
    private final String mDiagnosticReleaseOS;

    @SerializedName("domain_hint")
    private final String mDomainHint;

    @SerializedName("x-client-SKU")
    @Expose
    private final String mLibraryName;

    @SerializedName("x-client-Ver")
    @Expose
    private final String mLibraryVersion;

    @SerializedName("login_hint")
    private final String mLoginHint;

    @SerializedName("instance_aware")
    @Expose
    private final Boolean mMultipleCloudAware;

    @SerializedName(OAuthWebView.CODE_CHALLENGE)
    private final String mPkceCodeChallenge;

    @SerializedName("code_challenge_method")
    private final String mPkceCodeChallengeMethod;
    private final transient String mPkceCodeVerifier;

    @SerializedName("pc")
    @Expose
    private final String mPreferredAuthMethodCode;

    @SerializedName(WP_AVAILABLE_EXTRA_PARAMETER_NAME)
    private final Boolean mWorkProfileAvailable;

    public URL getAuthority() {
        return this.mAuthority;
    }

    public String getLoginHint() {
        return this.mLoginHint;
    }

    public String getDomainHint() {
        return this.mDomainHint;
    }

    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    public String getPkceCodeChallenge() {
        return this.mPkceCodeChallenge;
    }

    public String getPkceCodeChallengeMethod() {
        return this.mPkceCodeChallengeMethod;
    }

    public String getPkceCodeVerifier() {
        return this.mPkceCodeVerifier;
    }

    public String getLibraryVersion() {
        return this.mLibraryVersion;
    }

    public String getLibraryName() {
        return this.mLibraryName;
    }

    public String getDiagnosticOS() {
        return this.mDiagnosticOS;
    }

    public String getDiagnosticReleaseOS() {
        return this.mDiagnosticReleaseOS;
    }

    public String getDiagnosticCPU() {
        return this.mDiagnosticCPU;
    }

    public String getDiagnosticDM() {
        return this.mDiagnosticDM;
    }

    public String getDiagnosticMN() {
        return this.mDiagnosticMN;
    }

    public Boolean getMultipleCloudAware() {
        return this.mMultipleCloudAware;
    }

    public String getPreferredAuthMethodCode() {
        return this.mPreferredAuthMethodCode;
    }

    public Boolean getWorkProfileAvailable() {
        return this.mWorkProfileAvailable;
    }

    protected MicrosoftAuthorizationRequest(Builder builder) {
        PkceChallenge pkceChallengeNewPkceChallenge;
        super(builder);
        this.mAuthority = builder.mAuthority;
        this.mLoginHint = builder.mLoginHint;
        this.mDomainHint = builder.mDomainHint;
        this.mCorrelationId = builder.mCorrelationId;
        if (builder.mPkceChallenge == null) {
            pkceChallengeNewPkceChallenge = PkceChallenge.newPkceChallenge();
        } else {
            pkceChallengeNewPkceChallenge = builder.mPkceChallenge;
        }
        this.mPkceCodeChallengeMethod = pkceChallengeNewPkceChallenge.getCodeChallengeMethod();
        this.mPkceCodeChallenge = pkceChallengeNewPkceChallenge.getCodeChallenge();
        this.mPkceCodeVerifier = pkceChallengeNewPkceChallenge.getCodeVerifier();
        this.mMultipleCloudAware = builder.mMultipleCloudAware;
        this.mLibraryVersion = builder.mLibraryVersion;
        this.mLibraryName = builder.mLibraryName;
        this.mPreferredAuthMethodCode = builder.mPreferredAuthMethod == null ? null : String.valueOf(builder.mPreferredAuthMethod.code);
        this.mDiagnosticOS = Device.getOsForEsts();
        this.mDiagnosticDM = Device.getModel();
        this.mDiagnosticCPU = Device.getCpu();
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_AM_API_WORKPROFILE_EXTRA_QUERY_PARAMETERS)) {
            this.mDiagnosticMN = Device.getManufacturer();
            this.mDiagnosticReleaseOS = Device.getAndroidReleaseOs();
            this.mWorkProfileAvailable = Device.isInPersonalProfileButClouddpcWorkProfileAvailable();
        } else {
            this.mDiagnosticMN = null;
            this.mDiagnosticReleaseOS = null;
            this.mWorkProfileAvailable = null;
        }
    }

    public static abstract class Builder<B extends Builder<B>> extends AuthorizationRequest.Builder<B> {
        private URL mAuthority;
        private UUID mCorrelationId;
        private String mDomainHint;
        private String mLibraryName;
        private String mLibraryVersion;
        private String mLoginHint;
        private Boolean mMultipleCloudAware;
        private PkceChallenge mPkceChallenge;
        private PreferredAuthMethod mPreferredAuthMethod;

        @Override // com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest.Builder
        public abstract B self();

        public Builder() {
            setState(new DefaultStateGenerator().generate());
        }

        public B setAuthority(URL url) {
            this.mAuthority = url;
            return (B) self();
        }

        public B setLibraryVersion(String str) {
            this.mLibraryVersion = str;
            return (B) self();
        }

        public B setLibraryName(String str) {
            this.mLibraryName = str;
            return (B) self();
        }

        public B setMultipleCloudAware(boolean z) {
            this.mMultipleCloudAware = Boolean.valueOf(z);
            return (B) self();
        }

        public B setCorrelationId(UUID uuid) {
            this.mCorrelationId = uuid;
            return (B) self();
        }

        public B setLoginHint(String str) {
            this.mLoginHint = str;
            return (B) self();
        }

        public B setDomainHint(String str) {
            this.mDomainHint = str;
            return (B) self();
        }

        public B setPreferredAuthMethod(@Nullable PreferredAuthMethod preferredAuthMethod) {
            this.mPreferredAuthMethod = preferredAuthMethod;
            return (B) self();
        }

        public B setPkceChallenge(PkceChallenge pkceChallenge) {
            if (pkceChallenge == null) {
                throw new NullPointerException("pkceChallenge is marked non-null but is null");
            }
            this.mPkceChallenge = pkceChallenge;
            return (B) self();
        }
    }
}
