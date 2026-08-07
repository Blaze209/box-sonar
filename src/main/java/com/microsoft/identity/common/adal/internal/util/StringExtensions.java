package com.microsoft.identity.common.adal.internal.util;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes14.dex */
public final class StringExtensions {
    public static final String ENCODING_UTF8 = "UTF-8";
    private static final String TAG = "StringExtensions";
    private static final String TOKEN_HASH_ALGORITHM = "SHA256";

    private StringExtensions() {
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String createHash(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return !isNullOrBlank(str) ? new String(Base64.encode(MessageDigest.getInstance(TOKEN_HASH_ALGORITHM).digest(str.getBytes("UTF-8")), 2), "UTF-8") : str;
    }

    public static String urlFormEncode(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8");
    }

    public static String urlFormDecode(String str) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, "UTF-8");
    }

    public static URL getUrl(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            Log.e(TAG, ErrorStrings.AUTHORITY_URL_NOT_VALID);
            return null;
        }
    }

    public static HashMap<String, String> getUrlParameters(String str) {
        String str2 = TAG + ":getUrlParameters";
        Uri uri = Uri.parse(str);
        if (!HashMapExtensions.urlFormDecode(uri.getFragment()).isEmpty()) {
            Logger.warn(str2, "Received url contains unexpected fragment parameters.");
            Logger.warnPII(str2, "Unexpected fragment: " + uri.getFragment());
        }
        return HashMapExtensions.urlFormDecode(uri.getEncodedQuery());
    }

    public static List<String> getStringTokens(String str, String str2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (!isNullOrBlank(strNextToken)) {
                arrayList.add(strNextToken);
            }
        }
        return arrayList;
    }

    public static ArrayList<String> splitWithQuotes(String str, char c) {
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == c && !z) {
                String strSubstring = str.substring(i, i2);
                if (!isNullOrBlank(strSubstring.trim())) {
                    arrayList.add(strSubstring);
                }
                i = i2 + 1;
            } else if (str.charAt(i2) == '\"') {
                z = !z;
            }
        }
        String strSubstring2 = str.substring(i);
        if (!isNullOrBlank(strSubstring2.trim())) {
            arrayList.add(strSubstring2);
        }
        return arrayList;
    }

    public static String removeQuoteInHeaderValue(String str) {
        if (isNullOrBlank(str)) {
            return null;
        }
        return str.replace("\"", "");
    }

    public static boolean hasPrefixInHeader(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length() + 2 && Character.isWhitespace(str.charAt(str2.length()));
    }

    public static String appendQueryParameterToUrl(String str, Map<String, String> map) throws UnsupportedEncodingException {
        if (isNullOrBlank(str)) {
            throw new IllegalArgumentException("Empty authority endpoint parameter.");
        }
        if (map.isEmpty()) {
            return str;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    public static String removeQueryParameterFromUrl(String str) throws URISyntaxException {
        URI uri = new URI(str);
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
    }
}
