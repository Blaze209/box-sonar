package com.microsoft.identity.client.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.browser.customtabs.CustomTabsService;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.BrowserTabActivity;
import com.microsoft.identity.client.CurrentTaskBrowserTabActivity;
import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class MsalUtils {
    public static final String CHROME_PACKAGE = "com.android.chrome";
    public static final int DEFAULT_EXPIRATION_TIME_SEC = 3600;
    public static final String ENCODING_UTF8 = "UTF-8";
    public static final String QUERY_STRING_DELIMITER = "&";
    public static final String QUERY_STRING_SYMBOL = "?";
    private static final String TAG = "MsalUtils";
    private static final String TOKEN_HASH_ALGORITHM = "SHA256";

    private MsalUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static void validateNonNullArgument(Object obj, String str) {
        if (obj == null || ((obj instanceof CharSequence) && TextUtils.isEmpty((CharSequence) obj))) {
            throw new IllegalArgumentException(str + " cannot be null or empty");
        }
    }

    public static void validateNonNullArg(Object obj, String str) throws MsalArgumentException {
        if (obj == null || (((obj instanceof CharSequence) && TextUtils.isEmpty((CharSequence) obj)) || (((obj instanceof List) && ((List) obj).isEmpty()) || ((obj instanceof Map) && ((Map) obj).isEmpty())))) {
            throw new MsalArgumentException(str, str + " cannot be null or empty");
        }
    }

    public static String urlFormEncode(String str) throws UnsupportedEncodingException {
        if (isEmpty(str)) {
            return "";
        }
        return URLEncoder.encode(str, "UTF-8");
    }

    public static String urlFormDecode(String str) throws UnsupportedEncodingException {
        if (isEmpty(str)) {
            return "";
        }
        return URLDecoder.decode(str, "UTF-8");
    }

    public static Map<String, String> extractJsonObjectIntoMap(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return Collections.unmodifiableMap(map);
    }

    public static Date calculateExpiresOn(String str) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.add(13, getExpiryOrDefault(str));
        return gregorianCalendar.getTime();
    }

    public static int getExpiryOrDefault(String str) {
        if (isEmpty(str)) {
            return 3600;
        }
        return Integer.parseInt(str);
    }

    public static Set<String> getScopesAsSet(String str) {
        if (isEmpty(str)) {
            return new HashSet();
        }
        String[] strArrSplit = str.toLowerCase(Locale.US).split(" ");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!isEmpty(strArrSplit[i])) {
                hashSet.add(strArrSplit[i]);
            }
        }
        return hashSet;
    }

    @Deprecated
    public static boolean hasCustomTabRedirectActivity(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setDataAndNormalize(Uri.parse(str));
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, intent, 64);
        String name = BrowserTabActivity.class.getName();
        if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask()) {
            name = CurrentTaskBrowserTabActivity.class.getName();
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!it.next().activityInfo.name.equals(name)) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static String getChromePackageWithCustomTabSupport(Context context) {
        String str = TAG + ":getChromePackageWithCustomTabSupport";
        if (context.getPackageManager() == null) {
            Logger.warn(str, "getPackageManager() returned null.");
            return null;
        }
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(context.getPackageManager(), new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            Logger.warn(str, "No Service responded to Intent: android.support.customtabs.action.CustomTabsService");
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            if (serviceInfo != null && CHROME_PACKAGE.equals(serviceInfo.packageName)) {
                return serviceInfo.packageName;
            }
        }
        Logger.warn(str, "No pkg with CustomTab support found.");
        return null;
    }

    public static String getChromePackage(Context context) {
        String str = TAG + ":getChromePackage";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = MAMPackageManagement.getPackageInfo(packageManager, CHROME_PACKAGE, 1).applicationInfo;
            if (applicationInfo == null || !applicationInfo.enabled) {
                return null;
            }
            return CHROME_PACKAGE;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error(str, "Failed to retrieve chrome package info.", e);
            return null;
        }
    }

    public static Map<String, String> decodeUrlToMap(String str, String str2) {
        String str3 = TAG + ":decodeUrlToMap";
        HashMap map = new HashMap();
        if (!isEmpty(str) && str2 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
            while (stringTokenizer.hasMoreTokens()) {
                String[] strArrSplit = stringTokenizer.nextToken().split(SimpleComparison.EQUAL_TO_OPERATION);
                if (strArrSplit.length == 2) {
                    try {
                        String strUrlFormDecode = urlFormDecode(strArrSplit[0]);
                        String strUrlFormDecode2 = urlFormDecode(strArrSplit[1]);
                        if (!isEmpty(strUrlFormDecode) && !isEmpty(strUrlFormDecode2)) {
                            map.put(strUrlFormDecode, strUrlFormDecode2);
                        }
                    } catch (UnsupportedEncodingException e) {
                        Logger.errorPII(str3, "URL form decode failed.", e);
                    }
                }
            }
        }
        return map;
    }

    public static String appendQueryParameterToUrl(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String str2;
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty authority string");
        }
        if (map.isEmpty()) {
            return str;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashSet.add(entry.getKey() + SimpleComparison.EQUAL_TO_OPERATION + urlFormEncode(entry.getValue()));
        }
        String strConvertSetToString = StringUtil.convertSetToString(hashSet, QUERY_STRING_DELIMITER);
        if (str.contains(QUERY_STRING_SYMBOL)) {
            str2 = str.endsWith(QUERY_STRING_DELIMITER) ? "%s%s" : "%s&%s";
        } else {
            str2 = "%s?%s";
        }
        return String.format(str2, str, strConvertSetToString);
    }

    public static String base64UrlEncodeToString(String str) {
        return Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 10);
    }

    public static boolean isScopeIntersects(Set<String> set, Set<String> set2) {
        Iterator<String> it = set2.iterator();
        while (it.hasNext()) {
            if (set.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String createHash(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return !isEmpty(str) ? new String(Base64.encode(MessageDigest.getInstance(TOKEN_HASH_ALGORITHM).digest(str.getBytes("UTF-8")), 2), "UTF-8") : str;
    }

    public static String getUniqueUserIdentifier(String str, String str2) {
        return base64UrlEncodeToString(str) + "." + base64UrlEncodeToString(str2);
    }

    public static long getExpiresOn(long j) {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + j;
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return MAMPackageManagement.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalStateException("Unable to find the package info, unable to proceed");
        }
    }

    public static Set<String> convertArrayToSet(String[] strArr) {
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                if (!isEmpty(strArr[i])) {
                    hashSet.add(strArr[i]);
                }
            }
        }
        return hashSet;
    }

    public static void throwOnMainThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("method: " + str + " may not be called from main thread.");
        }
    }

    public static void throwOnMainThread(BaseException baseException) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(baseException);
        }
    }
}
