package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.PlatformVersion;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes14.dex */
public class CommonUtils {
    private static final GmsLogger zza = new GmsLogger("CommonUtils", "");

    private CommonUtils() {
    }

    public static String getAppVersion(Context context) {
        try {
            return String.valueOf(MAMPackageManagement.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            zza.e("CommonUtils", "Exception thrown when trying to get app version ".concat(e.toString()));
            return "";
        }
    }

    public static String languageTagFromLocale(Locale locale) {
        if (PlatformVersion.isAtLeastLollipop()) {
            return locale.toLanguageTag();
        }
        StringBuilder sb = new StringBuilder(locale.getLanguage());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            sb.append(locale.getCountry());
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            sb.append(locale.getVariant());
        }
        return sb.toString();
    }
}
