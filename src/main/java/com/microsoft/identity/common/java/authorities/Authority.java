package com.microsoft.identity.common.java.authorities;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public abstract class Authority {
    public static final String AAD_NA = "AAD_NA";
    private static final String ADFS_PATH_SEGMENT = "adfs";
    public static final String B2C = "B2C";
    private static final String B2C_PATH_SEGMENT = "tfp";
    public static final String CIAM = "CIAM";
    private static final String TAG = "Authority";
    private static final List<Authority> knownAuthorities = new ArrayList();
    private static final Object sLock = new Object();

    @SerializedName("type")
    protected String mAuthorityTypeString;

    @SerializedName("authority_url")
    protected String mAuthorityUrlString;

    @SerializedName("default")
    protected boolean mIsDefault = false;

    @SerializedName(AzureActiveDirectorySlice.SLICE_PARAMETER)
    public AzureActiveDirectorySlice mSlice;

    public abstract OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters oAuth2StrategyParameters) throws ClientException;

    public AzureActiveDirectorySlice getSlice() {
        return this.mSlice;
    }

    public void setSlice(AzureActiveDirectorySlice azureActiveDirectorySlice) {
        this.mSlice = azureActiveDirectorySlice;
    }

    public URI getAuthorityUri() {
        try {
            return new URI(this.mAuthorityUrlString);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Authority URL is not a URI.", e);
        }
    }

    public URL getAuthorityURL() {
        try {
            return getAuthorityUri().toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Authority URI is not a URL.", e);
        }
    }

    public boolean getDefault() {
        return this.mIsDefault;
    }

    public String getAuthorityTypeString() {
        return this.mAuthorityTypeString;
    }

    public void setDefault(Boolean bool) {
        this.mIsDefault = bool.booleanValue();
    }

    public Authority() {
        if (StringUtil.isNullOrEmpty("") && StringUtil.isNullOrEmpty("")) {
            return;
        }
        AzureActiveDirectorySlice azureActiveDirectorySlice = new AzureActiveDirectorySlice();
        azureActiveDirectorySlice.setSlice("");
        azureActiveDirectorySlice.setDataCenter("");
        this.mSlice = azureActiveDirectorySlice;
    }

    public static Authority getAuthorityFromAuthorityUrl(String str) {
        return getAuthorityFromAuthorityUrl(str, null);
    }

    public static Authority getAuthorityFromAuthorityUrl(String str, String str2) {
        try {
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder(str);
            List<String> pathSegments = commonURIBuilder.getPathSegments();
            if (pathSegments.size() == 0 || (pathSegments.size() == 1 && pathSegments.get(0).equals(""))) {
                if (str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT)) {
                    return new CIAMAuthority(CIAMAuthority.getTenantNameVariantUrlFromAuthorityWithoutPath(str));
                }
                return new UnknownAuthority();
            }
            if (authorityIsKnownFromConfiguration(str)) {
                Authority equivalentConfiguredAuthority = getEquivalentConfiguredAuthority(str);
                String str3 = equivalentConfiguredAuthority.mAuthorityTypeString;
                if (B2C.equalsIgnoreCase(str3)) {
                    return new AzureActiveDirectoryB2CAuthority(str);
                }
                if (CIAM.equalsIgnoreCase(str3)) {
                    return new CIAMAuthority(str);
                }
                if (!AAD_NA.equalsIgnoreCase(str3) || !(equivalentConfiguredAuthority instanceof NativeAuthCIAMAuthority)) {
                    return createAadAuthority(commonURIBuilder, pathSegments);
                }
                if (str2 == null) {
                    return new CIAMAuthority(str);
                }
                return new NativeAuthCIAMAuthority(str, str2);
            }
            String lowerCase = pathSegments.get(0).toLowerCase(Locale.ROOT);
            if (lowerCase.equals("adfs")) {
                Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is ADFS");
                return new ActiveDirectoryFederationServicesAuthority(str);
            }
            if (lowerCase.equals(B2C_PATH_SEGMENT)) {
                Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is B2C");
                return new AzureActiveDirectoryB2CAuthority(str);
            }
            if (str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT)) {
                Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type is CIAM");
                return new CIAMAuthority(str);
            }
            Logger.verbose(TAG + ":getAuthorityFromAuthorityUrl", "Authority type default: AAD");
            return createAadAuthority(commonURIBuilder, pathSegments);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Invalid authority URL");
        }
    }

    private static Authority getEquivalentConfiguredAuthority(String str) {
        if (str == null) {
            throw new NullPointerException("authorityStr is marked non-null but is null");
        }
        try {
            String authority = new URL(str).getAuthority();
            for (Authority authority2 : knownAuthorities) {
                if (!StringUtil.isNullOrEmpty(authority2.mAuthorityUrlString) && authority.equalsIgnoreCase(new URL(authority2.mAuthorityUrlString).getAuthority())) {
                    return authority2;
                }
            }
            return null;
        } catch (MalformedURLException e) {
            Logger.errorPII(TAG, "Error parsing authority", e);
            return null;
        }
    }

    private static boolean authorityIsKnownFromConfiguration(String str) {
        if (str != null) {
            return getEquivalentConfiguredAuthority(str) != null;
        }
        throw new NullPointerException("authorityStr is marked non-null but is null");
    }

    private static Authority createAadAuthority(CommonURIBuilder commonURIBuilder, List<String> list) {
        String str;
        if (commonURIBuilder == null) {
            throw new NullPointerException("uriBuilder is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("pathSegments is marked non-null but is null");
        }
        if (commonURIBuilder.getPort() != -1) {
            str = commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost() + ":" + commonURIBuilder.getPort();
        } else {
            str = commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost();
        }
        return new AzureActiveDirectoryAuthority(AzureActiveDirectoryAudience.getAzureActiveDirectoryAudience(str, list.get(0)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Authority)) {
            return false;
        }
        Authority authority = (Authority) obj;
        if (this.mAuthorityTypeString.equals(authority.mAuthorityTypeString)) {
            return getAuthorityUri().equals(authority.getAuthorityUri());
        }
        return false;
    }

    public int hashCode() {
        return (this.mAuthorityTypeString.hashCode() * 31) + getAuthorityUri().hashCode();
    }

    private static void performCloudDiscovery() throws ClientException {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":performCloudDiscovery").toString(), "Performing cloud discovery...");
        synchronized (sLock) {
            if (!AzureActiveDirectory.isInitialized()) {
                Logger.verbose(str + ":performCloudDiscovery", "Not initialized. Starting request.");
                AzureActiveDirectory.performCloudDiscovery();
                Logger.info(str + ":performCloudDiscovery", "Loaded cloud metadata.");
            }
        }
    }

    public static void addKnownAuthorities(List<Authority> list) {
        synchronized (sLock) {
            knownAuthorities.addAll(list);
        }
    }

    public static boolean isKnownAuthority(Authority authority) {
        boolean z;
        if (authority == null) {
            Logger.warn(TAG + ":isKnownAuthority", "Authority is null");
            return false;
        }
        Iterator<Authority> it = knownAuthorities.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Authority next = it.next();
            if (next.mAuthorityUrlString != null && authority.getAuthorityURL() != null && authority.getAuthorityURL().getAuthority() != null && next.mAuthorityUrlString.toLowerCase(Locale.ROOT).contains(authority.getAuthorityURL().getAuthority().toLowerCase(Locale.ROOT))) {
                z = true;
                break;
            }
        }
        boolean zHasCloudHost = AzureActiveDirectory.hasCloudHost(authority.getAuthorityURL());
        boolean z2 = z || zHasCloudHost;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(sb.append(str).append(":isKnownAuthority").toString(), "Authority is known to developer? [" + z + "]");
        Logger.verbose(str + ":isKnownAuthority", "Authority is known to Microsoft? [" + zHasCloudHost + "]");
        return z2;
    }

    public static KnownAuthorityResult getKnownAuthorityResult(Authority authority) {
        Logger.verbose(TAG + ":getKnownAuthorityResult", "Getting known authority result...");
        try {
            performCloudDiscovery();
            e = null;
        } catch (ClientException e) {
            e = e;
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(sb.append(str).append(":getKnownAuthorityResult").toString(), "Cloud discovery complete.");
        boolean z = false;
        if (e == null) {
            if (!isKnownAuthority(authority)) {
                e = new ClientException("unknown_authority", "Provided authority is not known.  MSAL will only make requests to known authorities");
            } else {
                Logger.info(str + ":getKnownAuthorityResult", "Cloud is known.");
                z = true;
            }
        }
        return new KnownAuthorityResult(z, e);
    }

    public static class KnownAuthorityResult {
        private ClientException mClientException;
        private boolean mKnown;

        KnownAuthorityResult(boolean z, ClientException clientException) {
            this.mKnown = z;
            this.mClientException = clientException;
        }

        public boolean getKnown() {
            return this.mKnown;
        }

        public ClientException getClientException() {
            return this.mClientException;
        }
    }
}
