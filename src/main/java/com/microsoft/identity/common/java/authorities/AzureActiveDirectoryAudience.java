package com.microsoft.identity.common.java.authorities;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfigurationClient;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AzureActiveDirectoryAudience {
    public static final String ALL = "common";
    public static final String CONSUMERS = "consumers";
    public static final String MSA_MEGA_TENANT_ID = "9188040d-6c67-4c5b-b112-36a304b66dad";
    public static final String ORGANIZATIONS = "organizations";
    private static final String TAG = "AzureActiveDirectoryAudience";
    private String mCloudUrl;

    @SerializedName("tenant_id")
    private String mTenantId;

    public String getCloudUrl() {
        String str = this.mCloudUrl;
        return str == null ? AzureActiveDirectory.getDefaultCloudUrl() : str;
    }

    public void setCloudUrl(String str) {
        this.mCloudUrl = str;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    public String getTenantUuidForAlias(String str) throws ServiceException, ClientException {
        if (str == null) {
            throw new NullPointerException("authority is marked non-null but is null");
        }
        if (StringUtil.isUuid(this.mTenantId)) {
            return this.mTenantId;
        }
        return getTenantIdFromOpenIdProviderConfiguration(loadOpenIdProviderConfigurationMetadata(str));
    }

    public static String getTenantIdFromOpenIdProviderConfiguration(OpenIdProviderConfiguration openIdProviderConfiguration) throws ClientException {
        if (openIdProviderConfiguration == null) {
            throw new NullPointerException("configuration is marked non-null but is null");
        }
        try {
            List<String> pathSegments = new CommonURIBuilder(openIdProviderConfiguration.getIssuer()).getPathSegments();
            if (pathSegments.isEmpty()) {
                Logger.error(TAG, "OpenId Metadata did not contain a path to the tenant", null);
                throw new ClientException("OpenId Metadata did not contain a path to the tenant");
            }
            String str = pathSegments.get(0);
            if (StringUtil.isUuid(str)) {
                return str;
            }
            Logger.error(TAG, "OpenId Metadata did not contain UUID in the path ", null);
            throw new ClientException("OpenId Metadata did not contain UUID in the path ");
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", "Failed to construct issuerUri", e);
        }
    }

    public static boolean isHomeTenantAlias(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("common") || str.equalsIgnoreCase("consumers") || str.equalsIgnoreCase(ORGANIZATIONS);
        }
        throw new NullPointerException("tenantId is marked non-null but is null");
    }

    private static OpenIdProviderConfiguration loadOpenIdProviderConfigurationMetadata(String str) throws ServiceException, ClientException {
        if (str == null) {
            throw new NullPointerException("requestAuthority is marked non-null but is null");
        }
        Logger.info(TAG + ":loadOpenIdProviderConfigurationMetadata", "Loading OpenId Provider Metadata...");
        return new OpenIdProviderConfigurationClient().loadOpenIdProviderConfigurationFromAuthority(str);
    }

    public void setTenantId(String str) {
        this.mTenantId = str;
    }

    public static AzureActiveDirectoryAudience getAzureActiveDirectoryAudience(String str, String str2) {
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "organizations":
                Logger.verbose(TAG + ":getAzureActiveDirectoryAudience", "Audience: AnyOrganizationalAccount");
                return new AnyOrganizationalAccount(str);
            case "common":
                Logger.verbose(TAG + ":getAzureActiveDirectoryAudience", "Audience: AllAccounts");
                return new AllAccounts(str);
            case "consumers":
                Logger.verbose(TAG + ":getAzureActiveDirectoryAudience", "Audience: AnyPersonalAccount");
                return new AnyPersonalAccount(str);
            default:
                Logger.verbose(TAG + ":getAzureActiveDirectoryAudience", "Audience: AccountsInOneOrganization");
                return new AccountsInOneOrganization(str, str2);
        }
    }
}
