package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.java.util.UrlUtil;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftStsOAuth2Configuration extends AzureActiveDirectoryOAuth2Configuration {
    private static final String AUTHORIZE_ENDPOINT_SUFFIX = "/oAuth2/v2.0/authorize";
    private static final String DEVICE_AUTHORIZE_ENDPOINT_SUFFIX = "/oAuth2/v2.0/devicecode";
    private static final String ENDPOINT_SUFFIX = "/oAuth2/v2.0";
    private static final String TAG = "MicrosoftStsOAuth2Configuration";
    private static final String TOKEN_ENDPOINT_SUFFIX = "/oAuth2/v2.0/token";

    public URL getAuthorizationEndpoint() {
        return getEndpointUrlFromRootAndSuffix(getAuthorityUrl(), AUTHORIZE_ENDPOINT_SUFFIX);
    }

    public URL getDeviceAuthorizationEndpoint() {
        return getEndpointUrlFromRootAndSuffix(getAuthorityUrl(), DEVICE_AUTHORIZE_ENDPOINT_SUFFIX);
    }

    public URL getTokenEndpoint() {
        return getEndpointUrlFromRootAndSuffix(getAuthorityUrl(), TOKEN_ENDPOINT_SUFFIX);
    }

    private URL getEndpointUrlFromRootAndSuffix(URL url, String str) {
        if (url == null) {
            throw new NullPointerException("root is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("endpointSuffix is marked non-null but is null");
        }
        try {
            return UrlUtil.appendPathToURL(url, str);
        } catch (MalformedURLException | URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            String str2 = TAG;
            Logger.error(sb.append(str2).append(":getEndpointUrlFromRootAndSuffix").toString(), "Unable to create URL from provided root and suffix.", null);
            Logger.errorPII(str2 + ":getEndpointUrlFromRootAndSuffix", e.getMessage() + " Unable to create URL from provided root and suffix. root = " + url.toString() + " suffix = " + str, e);
            return null;
        }
    }
}
