package com.box.android.common.utilities;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MetroDevSettings.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R,\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/box/android/common/utilities/MetroDevSettings;", "", "<init>", "()V", "PREF_NAME", "", "KEY_USE_METRO_SERVER", "KEY_METRO_URL", "DEFAULT_METRO_URL", "sharedPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSharedPrefs$annotations", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "setSharedPrefs", "(Landroid/content/SharedPreferences;)V", "value", "", "useMetroServer", "getUseMetroServer", "()Z", "setUseMetroServer", "(Z)V", "metroUrl", "getMetroUrl", "()Ljava/lang/String;", "setMetroUrl", "(Ljava/lang/String;)V", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetroDevSettings {
    public static final String DEFAULT_METRO_URL = "10.0.2.2:8081";
    private static final String KEY_METRO_URL = "metro_url";
    private static final String KEY_USE_METRO_SERVER = "use_metro_server";
    public static final MetroDevSettings INSTANCE = new MetroDevSettings();
    private static final String PREF_NAME = "cirrus_metro_dev_prefs";
    private static SharedPreferences sharedPrefs = ApplicationProvider.getApplication().getSharedPreferences(PREF_NAME, 0);

    public static /* synthetic */ void getSharedPrefs$annotations() {
    }

    private MetroDevSettings() {
    }

    public final SharedPreferences getSharedPrefs() {
        return sharedPrefs;
    }

    public final void setSharedPrefs(SharedPreferences sharedPreferences) {
        sharedPrefs = sharedPreferences;
    }

    public final boolean getUseMetroServer() {
        return BuildConfigProvider.INSTANCE.isDebugBuild() && sharedPrefs.getBoolean(KEY_USE_METRO_SERVER, false);
    }

    public final void setUseMetroServer(boolean z) {
        sharedPrefs.edit().putBoolean(KEY_USE_METRO_SERVER, z).apply();
    }

    public final String getMetroUrl() {
        String string = sharedPrefs.getString(KEY_METRO_URL, "10.0.2.2:8081");
        if (string != null) {
            if (StringsKt.isBlank(string)) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return "10.0.2.2:8081";
    }

    public final void setMetroUrl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        sharedPrefs.edit().putString(KEY_METRO_URL, value).apply();
    }
}
