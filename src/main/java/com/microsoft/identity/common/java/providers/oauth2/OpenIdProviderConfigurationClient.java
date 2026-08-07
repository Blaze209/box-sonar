package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.Gson;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpClient;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.java.util.StringUtil;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public class OpenIdProviderConfigurationClient {
    private static final String TAG = "OpenIdProviderConfigurationClient";
    private static final String V2_0_PATH = "/v2.0";
    private static final String WELL_KNOWN_CONFIG_PATH = "/.well-known/openid-configuration";
    private static final Map<URI, OpenIdProviderConfiguration> sConfigCache = new HashMap();
    private static final HttpClient httpClient = UrlConnectionHttpClient.getDefaultInstance();
    private static final LongCounter sOpenIdProviderConfigurationIssuerValidationFailedCount = OTelUtility.createLongCounter("openid_provider_configuration_issuer_validation_failed_count", "Track failure in validating OpenID Provider configuration issuer");
    private static final Gson GSON = new Gson();

    public synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationFromAuthority(String str) throws ServiceException {
        try {
            if (str == null) {
                throw new NullPointerException("authorityUrl is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return loadOpenIdProviderConfigurationInternal(str, null);
    }

    public synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationFromAuthorityWithExtraParams(String str, String str2) throws ServiceException {
        try {
            if (str == null) {
                throw new NullPointerException("authorityUrl is marked non-null but is null");
            }
            if (str2 == null) {
                throw new NullPointerException("extraParams is marked non-null but is null");
            }
        } catch (Throwable th) {
            throw th;
        }
        return loadOpenIdProviderConfigurationInternal(str, str2);
    }

    private synchronized OpenIdProviderConfiguration loadOpenIdProviderConfigurationInternal(String str, String str2) throws ServiceException {
        String str3;
        Attributes attributesValidateIssuer;
        try {
            if (str == null) {
                throw new NullPointerException("tenantedAuthorityString is marked non-null but is null");
            }
            String str4 = TAG + ":loadOpenIdProviderConfigurationInternal";
            try {
                String configRequestBaseUrl = getConfigRequestBaseUrl(str);
                if (str2 != null) {
                    str3 = configRequestBaseUrl + WELL_KNOWN_CONFIG_PATH + str2;
                } else {
                    str3 = configRequestBaseUrl + WELL_KNOWN_CONFIG_PATH;
                }
                URI uri = new URI(str3);
                OpenIdProviderConfiguration openIdProviderConfiguration = sConfigCache.get(uri);
                if (openIdProviderConfiguration != null) {
                    Logger.info(str4, "Using cached metadata result.");
                    return openIdProviderConfiguration;
                }
                Logger.verbose(str4, "Config URL is valid.");
                Logger.verbosePII(str4, "Using request URL: " + uri);
                HttpResponse httpResponse = httpClient.get(uri.toURL(), new HashMap());
                int statusCode = httpResponse.getStatusCode();
                if (200 != statusCode || StringUtil.isNullOrEmpty(httpResponse.getBody())) {
                    throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "OpenId Provider Configuration metadata failed to load with status: " + statusCode, null);
                }
                OpenIdProviderConfiguration metadata = parseMetadata(httpResponse.getBody());
                if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_OPENID_ISSUER_VALIDATION_REPORTING) && (attributesValidateIssuer = validateIssuer(metadata, configRequestBaseUrl)) != null) {
                    sOpenIdProviderConfigurationIssuerValidationFailedCount.add(1L, attributesValidateIssuer);
                }
                cacheConfiguration(uri, metadata);
                return metadata;
            } catch (ClientException | MalformedURLException | URISyntaxException e) {
                throw new ServiceException(ServiceException.OPENID_PROVIDER_CONFIGURATION_FAILED_TO_LOAD, "IOException while requesting metadata", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void cacheConfiguration(URI uri, OpenIdProviderConfiguration openIdProviderConfiguration) {
        if (uri == null) {
            throw new NullPointerException("configUrl is marked non-null but is null");
        }
        if (openIdProviderConfiguration == null) {
            throw new NullPointerException("parsedConfig is marked non-null but is null");
        }
        sConfigCache.put(uri, openIdProviderConfiguration);
    }

    private OpenIdProviderConfiguration parseMetadata(String str) {
        if (str == null) {
            throw new NullPointerException("body is marked non-null but is null");
        }
        return (OpenIdProviderConfiguration) GSON.fromJson(str, OpenIdProviderConfiguration.class);
    }

    Attributes validateIssuer(OpenIdProviderConfiguration openIdProviderConfiguration, String str) {
        if (openIdProviderConfiguration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("requestAuthorityStr is marked non-null but is null");
        }
        String str2 = TAG + ":validateIssuer";
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        if (StringUtil.isNullOrEmpty(openIdProviderConfiguration.getIssuer())) {
            Logger.warn(str2, "Issuer is missing in the metadata.");
            attributesBuilderBuilder.put(AttributeName.openid_issuer_invalid_reason.name(), "issuer_missing");
            return attributesBuilderBuilder.build();
        }
        String issuer = openIdProviderConfiguration.getIssuer();
        if (str.equals(issuer)) {
            return null;
        }
        attributesBuilderBuilder.put(AttributeName.openid_config_request_authority.name(), str);
        attributesBuilderBuilder.put(AttributeName.openid_issuer.name(), issuer);
        try {
            URL url = new URL(issuer);
            try {
                AzureActiveDirectory.ensureCloudDiscoveryComplete();
                URL url2 = new URL(str);
                AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(url2);
                if (azureActiveDirectoryCloud != null && azureActiveDirectoryCloud.isValidated()) {
                    AzureActiveDirectoryCloud azureActiveDirectoryCloud2 = AzureActiveDirectory.getAzureActiveDirectoryCloud(url);
                    if (azureActiveDirectoryCloud2 != null && azureActiveDirectoryCloud2.isValidated() && (Objects.equals(azureActiveDirectoryCloud, azureActiveDirectoryCloud2) || AzureActiveDirectory.isPublicAzureActiveDirectoryCloud(url2))) {
                        return null;
                    }
                    attributesBuilderBuilder.put(AttributeName.openid_issuer_invalid_reason.name(), "issuer_aad_host_mismatch");
                    return attributesBuilderBuilder.build();
                }
            } catch (ClientException e) {
                Logger.error(str2, "Failed to complete AAD cloud discovery.", e);
            } catch (MalformedURLException e2) {
                Logger.error(str2, "Request URL is malformed.", e2);
            }
            attributesBuilderBuilder.put(AttributeName.openid_issuer_invalid_reason.name(), "issuer_validation_skipped");
            return attributesBuilderBuilder.build();
        } catch (MalformedURLException e3) {
            Logger.warn(str2, "Issuer URL is malformed. " + e3.getMessage());
            attributesBuilderBuilder.put(AttributeName.openid_issuer_invalid_reason.name(), "issuer_malformed");
            return attributesBuilderBuilder.build();
        }
    }

    private String getConfigRequestBaseUrl(String str) {
        if (str == null) {
            throw new NullPointerException("issuerUrl is marked non-null but is null");
        }
        String strTrim = str.trim();
        if (str.endsWith("/")) {
            strTrim = str.substring(0, strTrim.length() - 1);
        }
        return strTrim + V2_0_PATH;
    }
}
