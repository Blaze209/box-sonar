package io.split.android.client.network;

import com.microsoft.identity.client.internal.MsalUtils;
import io.split.android.client.utils.Utils;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes4.dex */
public class SdkTargetPath {
    public static final String EVENTS = "/events/bulk";
    public static final String IMPRESSIONS = "/testImpressions/bulk";
    public static final String IMPRESSIONS_COUNT = "/testImpressions/count";
    public static final String MEMBERSHIPS = "/memberships";
    public static final String SPLIT_CHANGES = "/splitChanges";
    public static final String SSE_AUTHENTICATION = "/auth";
    public static final String TELEMETRY_CONFIG = "/metrics/config";
    public static final String TELEMETRY_STATS = "/metrics/usage";
    public static final String UNIQUE_KEYS = "/keys/cs";

    public static URI splitChanges(String baseUrl, String queryString) throws URISyntaxException {
        return buildUrl(baseUrl, SPLIT_CHANGES, queryString);
    }

    public static URI mySegments(String baseUrl, String key) throws URISyntaxException {
        return buildUrl(baseUrl, "/memberships/" + getUrlEncodedKey(key));
    }

    public static URI events(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, EVENTS);
    }

    public static URI impressions(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, IMPRESSIONS);
    }

    public static URI impressionsCount(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, IMPRESSIONS_COUNT);
    }

    public static URI sseAuthentication(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, SSE_AUTHENTICATION);
    }

    public static URI telemetryConfig(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, TELEMETRY_CONFIG);
    }

    public static URI telemetryStats(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, TELEMETRY_STATS);
    }

    public static URI uniqueKeys(String baseUrl) throws URISyntaxException {
        return buildUrl(baseUrl, UNIQUE_KEYS);
    }

    private static URI buildUrl(String baseUrl, String path) throws URISyntaxException {
        return buildUrl(baseUrl, path, null);
    }

    private static URI buildUrl(String baseUrl, String path, String queryString) throws URISyntaxException {
        if (baseUrl != null && baseUrl.endsWith("/")) {
            baseUrl = removeLastChar(baseUrl);
        }
        String str = baseUrl + path;
        if (!Utils.isNullOrEmpty(queryString)) {
            str = str + MsalUtils.QUERY_STRING_SYMBOL + queryString;
        }
        return new URI(str);
    }

    private static String removeLastChar(String sourceString) {
        return (sourceString == null || sourceString.length() == 0) ? sourceString : sourceString.substring(0, sourceString.length() - 1);
    }

    private static String getUrlEncodedKey(String key) {
        if (key != null) {
            return UrlEscapers.urlPathSegmentEscaper().escape(key);
        }
        return null;
    }
}
