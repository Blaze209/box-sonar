package io.opentelemetry.instrumentation.api.internal;

import java.util.Locale;
import javax.annotation.Nullable;
import org.apache.commons.codec.language.Soundex;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ConfigPropertiesUtil {
    public static boolean getBoolean(String str, boolean z) {
        String string = getString(str);
        return string == null ? z : Boolean.parseBoolean(string);
    }

    @Nullable
    public static String getString(String str) {
        String property = System.getProperty(str);
        return property != null ? property : System.getenv(toEnvVarName(str));
    }

    private static String toEnvVarName(String str) {
        return str.toUpperCase(Locale.ROOT).replace(Soundex.SILENT_MARKER, SessionDataKt.UNDERSCORE).replace('.', SessionDataKt.UNDERSCORE);
    }

    private ConfigPropertiesUtil() {
    }
}
