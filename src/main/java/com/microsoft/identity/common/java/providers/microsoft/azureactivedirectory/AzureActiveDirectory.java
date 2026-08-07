package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.java.authorities.Environment;
import com.microsoft.identity.common.java.cache.HttpCache;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfigurationClient;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectory extends IdentityProvider<AzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryOAuth2Configuration> {
    private static final String AAD_INSTANCE_DISCOVERY_ENDPOINT = "/common/discovery/instance";
    private static final String API_VERSION = "api-version";
    private static final String API_VERSION_VALUE = "1.1";
    private static final String AUTHORIZATION_ENDPOINT = "authorization_endpoint";
    private static final String AUTHORIZATION_ENDPOINT_VALUE = "https://login.microsoftonline.com/common/oauth2/v2.0/authorize";
    private static final String METADATA = "metadata";
    private static final String TAG = "AzureActiveDirectory";
    private static final String TENANT_DISCOVERY_ENDPOINT = "tenant_discovery_endpoint";
    private static ConcurrentMap<String, AzureActiveDirectoryCloud> sAadClouds = new ConcurrentHashMap();
    private static boolean sIsInitialized = false;
    private static Environment sEnvironment = Environment.Production;
    private static final HttpClient httpClient = UrlConnectionHttpClient.getDefaultInstance();

    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public AzureActiveDirectoryOAuth2Strategy createOAuth2Strategy(AzureActiveDirectoryOAuth2Configuration azureActiveDirectoryOAuth2Configuration, IPlatformComponents iPlatformComponents) throws ClientException {
        if (azureActiveDirectoryOAuth2Configuration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (iPlatformComponents == null) {
            throw new NullPointerException("commonComponents is marked non-null but is null");
        }
        return new AzureActiveDirectoryOAuth2Strategy(azureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
    }

    public static synchronized boolean hasCloudHost(URL url) {
        try {
            if (url == null) {
                throw new NullPointerException("authorityUrl is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return sAadClouds.containsKey(url.getHost().toLowerCase(Locale.US));
    }

    public static synchronized boolean isValidCloudHost(URL url) {
        try {
            if (url == null) {
                throw new NullPointerException("authorityUrl is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return hasCloudHost(url) && getAzureActiveDirectoryCloud(url).isValidated();
    }

    public static synchronized boolean isInitialized() {
        return sIsInitialized;
    }

    public static synchronized void setEnvironment(Environment environment) {
        try {
            if (environment == null) {
                throw new NullPointerException("environment is marked non-null but is null");
            }
            if (environment != sEnvironment) {
                sIsInitialized = false;
                sEnvironment = environment;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized Environment getEnvironment() {
        return sEnvironment;
    }

    public static synchronized AzureActiveDirectoryCloud getAzureActiveDirectoryCloud(URL url) {
        try {
            if (url == null) {
                throw new NullPointerException("authorityUrl is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return sAadClouds.get(url.getHost().toLowerCase(Locale.US));
    }

    public static synchronized AzureActiveDirectoryCloud getAzureActiveDirectoryCloudFromHostName(String str) {
        try {
            if (str == null) {
                throw new NullPointerException("preferredCacheHostName is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return sAadClouds.get(str.toLowerCase(Locale.US));
    }

    public static synchronized boolean isPublicAzureActiveDirectoryCloud(URL url) throws ClientException {
        if (url == null) {
            throw new NullPointerException("authorityUrl is marked non-null but is null");
        }
        try {
        } catch (MalformedURLException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
        return Objects.equals(getAzureActiveDirectoryCloud(url), getAzureActiveDirectoryCloud(new URL(getDefaultCloudUrl())));
    }

    public static synchronized void putCloud(String str, AzureActiveDirectoryCloud azureActiveDirectoryCloud) {
        try {
            if (str == null) {
                throw new NullPointerException("host is marked non-null but is null");
            }
            sAadClouds.put(str.toLowerCase(Locale.US), azureActiveDirectoryCloud);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void initializeCloudMetadata(String str, Map<String, String> map) throws JSONException {
        try {
            if (str == null) {
                throw new NullPointerException("authorityHost is marked non-null but is null");
            }
            if (map == null) {
                throw new NullPointerException("discoveryResponse is marked non-null but is null");
            }
            boolean zContainsKey = map.containsKey(TENANT_DISCOVERY_ENDPOINT);
            String str2 = map.get("metadata");
            if (!zContainsKey) {
                sAadClouds.put(str, new AzureActiveDirectoryCloud(false));
                return;
            }
            if (StringUtil.isNullOrEmpty(str2)) {
                sAadClouds.put(str, new AzureActiveDirectoryCloud(str, str));
                return;
            }
            for (AzureActiveDirectoryCloud azureActiveDirectoryCloud : deserializeClouds(str2)) {
                azureActiveDirectoryCloud.setIsValidated(true);
                Iterator<String> it = azureActiveDirectoryCloud.getHostAliases().iterator();
                while (it.hasNext()) {
                    sAadClouds.put(it.next().toLowerCase(Locale.US), azureActiveDirectoryCloud);
                }
            }
            sIsInitialized = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized String getDefaultCloudUrl() {
        if (sEnvironment == Environment.PreProduction) {
            return AzureActiveDirectoryEnvironment.PREPRODUCTION_CLOUD_URL;
        }
        if (sEnvironment == Environment.OneBox) {
            return AzureActiveDirectoryEnvironment.ONEBOX_CLOUD_URL;
        }
        return AzureActiveDirectoryEnvironment.PRODUCTION_CLOUD_URL;
    }

    public static synchronized void performCloudDiscovery() throws ClientException {
        try {
            HttpResponse httpResponse = httpClient.get(UrlUtil.makeUrl(new CommonURIBuilder(getDefaultCloudUrl() + AAD_INSTANCE_DISCOVERY_ENDPOINT).setParameter(API_VERSION, "1.1").setParameter("authorization_endpoint", AUTHORIZATION_ENDPOINT_VALUE).build().toString()), new HashMap());
            if (httpResponse.getStatusCode() >= 400) {
                Logger.warn(TAG + ":performCloudDiscovery", "Error getting cloud information");
            } else {
                HttpCache.flush();
                AzureActiveDirectoryInstanceResponse azureActiveDirectoryInstanceResponse = (AzureActiveDirectoryInstanceResponse) ObjectMapper.deserializeJsonStringToObject(httpResponse.getBody(), AzureActiveDirectoryInstanceResponse.class);
                Logger.verbose(TAG + ":performCloudDiscovery", "Discovered [" + azureActiveDirectoryInstanceResponse.getClouds().size() + "] clouds.");
                for (AzureActiveDirectoryCloud azureActiveDirectoryCloud : azureActiveDirectoryInstanceResponse.getClouds()) {
                    azureActiveDirectoryCloud.setIsValidated(true);
                    Iterator<String> it = azureActiveDirectoryCloud.getHostAliases().iterator();
                    while (it.hasNext()) {
                        sAadClouds.put(it.next().toLowerCase(Locale.US), azureActiveDirectoryCloud);
                    }
                }
                sIsInitialized = true;
            }
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    public static synchronized void ensureCloudDiscoveryComplete() throws ClientException {
        String str = TAG + ":ensureCloudDiscoveryComplete";
        if (!sIsInitialized) {
            Logger.info(str, "Cloud metadata is not initialized. Performing cloud discovery.");
            performCloudDiscovery();
        }
    }

    public static synchronized Set<String> getHosts() {
        ConcurrentMap<String, AzureActiveDirectoryCloud> concurrentMap = sAadClouds;
        if (concurrentMap == null) {
            return null;
        }
        return concurrentMap.keySet();
    }

    public static synchronized List<AzureActiveDirectoryCloud> getClouds() {
        if (sAadClouds != null) {
            return new ArrayList(sAadClouds.values());
        }
        return new ArrayList();
    }

    public static OpenIdProviderConfiguration loadOpenIdProviderConfigurationMetadataForTenant(String str) throws ServiceException, ClientException {
        if (str == null) {
            throw new NullPointerException("tenant is marked non-null but is null");
        }
        try {
            return new OpenIdProviderConfigurationClient().loadOpenIdProviderConfigurationFromAuthority(new CommonURIBuilder(getDefaultCloudUrl()).setPathSegments(str).build().toString());
        } catch (URISyntaxException e) {
            throw new ClientException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "URISyntaxException while requesting metadata", e);
        }
    }

    private static List<AzureActiveDirectoryCloud> deserializeClouds(String str) throws JSONException {
        return (List) new Gson().fromJson(str, TypeToken.getParameterized(List.class, AzureActiveDirectoryCloud.class).getType());
    }
}
