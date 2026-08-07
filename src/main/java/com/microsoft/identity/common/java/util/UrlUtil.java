package com.microsoft.identity.common.java.util;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes14.dex */
public class UrlUtil {
    private static final String TAG = "UrlUtil";

    public static URL appendPathToURL(URL url, String str) throws MalformedURLException, URISyntaxException {
        if (url == null) {
            throw new NullPointerException("urlToAppend is marked non-null but is null");
        }
        return appendPathAndQueryToURL(url, str, null);
    }

    public static URL appendPathAndQueryToURL(URL url, String str, Map<String, String> map) throws MalformedURLException, URISyntaxException {
        if (url == null) {
            throw new NullPointerException("urlToAppend is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            return url;
        }
        CommonURIBuilder commonURIBuilder = new CommonURIBuilder();
        commonURIBuilder.setPath(str);
        List<String> pathSegments = commonURIBuilder.getPathSegments();
        CommonURIBuilder commonURIBuilder2 = new CommonURIBuilder(url.toString());
        ArrayList arrayList = new ArrayList(commonURIBuilder2.getPathSegments());
        if (arrayList.size() > 0) {
            int size = arrayList.size() - 1;
            if (((String) arrayList.get(size)).equals("") && !commonURIBuilder.isPathEmpty()) {
                arrayList.remove(size);
            }
        }
        for (String str2 : pathSegments) {
            if (!StringUtil.isNullOrEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        commonURIBuilder2.setPathSegments(arrayList);
        commonURIBuilder2.addParametersIfAbsent(map);
        return commonURIBuilder2.build().toURL();
    }

    public static Map<String, String> getParameters(String str) throws ClientException {
        if (StringUtil.isNullOrEmpty(str)) {
            Logger.warn(TAG, "url string is null.");
            return Collections.emptyMap();
        }
        try {
            return getParameters(new URI(str));
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", "Cannot extract parameter from a malformed URL string.", e);
        }
    }

    public static Map<String, String> getParameters(URI uri) {
        if (uri == null) {
            Logger.warn(TAG, "uri is null.");
            return Collections.emptyMap();
        }
        if (uri.isOpaque()) {
            try {
                return getParameters(new URI("scheme://" + uri.toString()));
            } catch (URISyntaxException unused) {
                Logger.warn(TAG, "Cannot convert opaque URI.");
                return Collections.emptyMap();
            }
        }
        String fragment = uri.getFragment();
        if (!StringUtil.isNullOrEmpty(fragment) && !urlFormDecode(fragment).isEmpty()) {
            String str = TAG;
            Logger.warn(str, "Received url contains unexpected fragment parameters.");
            Logger.warnPII(str, "Unexpected fragment: " + uri.getFragment());
        }
        if (StringUtil.isNullOrEmpty(uri.getQuery())) {
            Logger.info(TAG + ":getUrlParameters", "URL does not contain query parameter");
            return Collections.emptyMap();
        }
        return urlFormDecode(uri.getRawQuery());
    }

    public static Map<String, String> urlFormDecode(String str) {
        if (str == null) {
            throw new NullPointerException("urlParameter is marked non-null but is null");
        }
        return urlFormDecodeData(str, MsalUtils.QUERY_STRING_DELIMITER);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0014 A[SYNTHETIC] */
    static Map<String, String> urlFormDecodeData(String str, String str2) {
        String strUrlFormDecode;
        String strUrlFormDecode2;
        if (str == null) {
            throw new NullPointerException("urlParameter is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("delimiter is marked non-null but is null");
        }
        HashMap map = new HashMap();
        if (!StringUtil.isNullOrEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().split(SimpleComparison.EQUAL_TO_OPERATION, 2);
                if (strArrSplit.length == 2) {
                    try {
                        strUrlFormDecode = StringUtil.urlFormDecode(strArrSplit[0].trim());
                        strUrlFormDecode2 = StringUtil.urlFormDecode(strArrSplit[1].trim());
                        if (!StringUtil.isNullOrEmpty(strUrlFormDecode)) {
                            map.put(strUrlFormDecode, strUrlFormDecode2);
                        }
                    } catch (UnsupportedEncodingException e) {
                        Logger.errorPII(TAG + ":urlFormDecodeData", "Encoding format is not supported", e);
                    }
                } else {
                    if (strArrSplit.length == 1) {
                        try {
                            strUrlFormDecode = StringUtil.urlFormDecode(strArrSplit[0].trim());
                            strUrlFormDecode2 = "";
                        } catch (UnsupportedEncodingException e2) {
                            Logger.errorPII(TAG + ":urlFormDecodeData", "Encoding format is not supported", e2);
                        }
                    } else {
                        strUrlFormDecode = null;
                        strUrlFormDecode2 = null;
                    }
                    if (!StringUtil.isNullOrEmpty(strUrlFormDecode)) {
                        map.put(strUrlFormDecode, strUrlFormDecode2);
                    }
                }
            }
        }
        return map;
    }

    public static URL makeUrlSilent(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL makeUrl(String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("urlString is marked non-null but is null");
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    public static String removeTrailingSlash(String str) {
        if (str == null) {
            throw new NullPointerException("urlString is marked non-null but is null");
        }
        return str.replaceFirst("/*$", "");
    }
}
