package expo.modules.localization;

import android.text.TextUtils;
import androidx.core.text.util.LocalePreferences;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalizationUtils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u000e"}, d2 = {"USES_IMPERIAL", "", "", "getUSES_IMPERIAL", "()Ljava/util/List;", "USES_FAHRENHEIT", "getUSES_FAHRENHEIT", "getCountryCode", "locale", "Ljava/util/Locale;", "getSystemProperty", "key", "getRegionCode", "getTemperatureUnit", "expo-localization_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LocalizationUtilsKt {
    private static final List<String> USES_IMPERIAL = CollectionsKt.listOf((Object[]) new String[]{AbstractDevicePopManager.CertificateProperties.COUNTRY, "LR", "MM"});
    private static final List<String> USES_FAHRENHEIT = CollectionsKt.listOf((Object[]) new String[]{"AG", "BZ", "VG", "FM", "MH", "MS", "KN", "BS", "CY", "TC", AbstractDevicePopManager.CertificateProperties.COUNTRY, "LR", "PW", "KY"});

    public static final List<String> getUSES_IMPERIAL() {
        return USES_IMPERIAL;
    }

    public static final List<String> getUSES_FAHRENHEIT() {
        return USES_FAHRENHEIT;
    }

    public static final String getCountryCode(Locale locale) {
        Object objM14780constructorimpl;
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            Result.Companion companion = Result.INSTANCE;
            String country = locale.getCountry();
            if (TextUtils.isEmpty(country)) {
                country = null;
            }
            objM14780constructorimpl = Result.m14780constructorimpl(country);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        return (String) (Result.m14786isFailureimpl(objM14780constructorimpl) ? null : objM14780constructorimpl);
    }

    public static final String getSystemProperty(String key) {
        Object objM14780constructorimpl;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod(PasskeyWebListener.GET_UNIQUE_KEY, String.class).invoke(cls, key);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            objM14780constructorimpl = Result.m14780constructorimpl((String) objInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14786isFailureimpl(objM14780constructorimpl)) {
            objM14780constructorimpl = null;
        }
        String str = (String) objM14780constructorimpl;
        return str == null ? "" : str;
    }

    public static final String getRegionCode(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String systemProperty = getSystemProperty("ro.miui.region");
        if (systemProperty.length() == 0) {
            systemProperty = getCountryCode(locale);
        }
        return systemProperty;
    }

    public static final String getTemperatureUnit(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String regionCode = getRegionCode(locale);
        if (regionCode == null) {
            return null;
        }
        return USES_FAHRENHEIT.contains(regionCode) ? "fahrenheit" : LocalePreferences.TemperatureUnit.CELSIUS;
    }
}
