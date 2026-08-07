package com.microsoft.identity.common.java.eststelemetry;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class TelemetryUtils {
    static boolean getBooleanFromString(String str) {
        return str != null && str.equals("1");
    }

    static String getSchemaCompliantStringFromBoolean(boolean z) {
        return z ? "1" : "0";
    }

    static String getSchemaCompliantString(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return "";
        }
        if (str.equals(TelemetryEventStrings.Value.TRUE)) {
            return "1";
        }
        return str.equals("false") ? "0" : str;
    }
}
