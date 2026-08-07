package io.opentelemetry.instrumentation.api.instrumenter.http;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class ForwardedHeaderParser {
    @Nullable
    static String extractProtoFromForwardedHeader(String str) {
        int i;
        int iIndexOf = str.toLowerCase().indexOf("proto=");
        if (iIndexOf >= 0 && (i = iIndexOf + 6) < str.length() - 1) {
            return extractProto(str, i);
        }
        return null;
    }

    @Nullable
    static String extractProtoFromForwardedProtoHeader(String str) {
        return extractProto(str, 0);
    }

    @Nullable
    static String extractClientIpFromForwardedHeader(String str) {
        int i;
        int iIndexOf = str.toLowerCase().indexOf("for=");
        if (iIndexOf >= 0 && (i = iIndexOf + 4) < str.length() - 1) {
            return extractIpAddress(str, i);
        }
        return null;
    }

    @Nullable
    static String extractClientIpFromForwardedForHeader(String str) {
        return extractIpAddress(str, 0);
    }

    @Nullable
    private static String extractProto(String str, int i) {
        if (str.length() == i) {
            return null;
        }
        if (str.charAt(i) == '\"') {
            return extractProto(str, i + 1);
        }
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ',' || cCharAt == ';' || cCharAt == '\"') {
                if (i2 == i) {
                    return null;
                }
                return str.substring(i, i2);
            }
        }
        return str.substring(i);
    }

    @Nullable
    private static String extractIpAddress(String str, int i) {
        if (str.length() == i) {
            return null;
        }
        if (str.charAt(i) == '\"') {
            return extractIpAddress(str, i + 1);
        }
        if (str.charAt(i) == '[') {
            int i2 = i + 1;
            int iIndexOf = str.indexOf(93, i2);
            if (iIndexOf == -1) {
                return null;
            }
            return str.substring(i2, iIndexOf);
        }
        boolean z = false;
        for (int i3 = i; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '.') {
                z = true;
            } else if (cCharAt == ',' || cCharAt == ';' || cCharAt == '\"' || (z && cCharAt == ':')) {
                if (i3 == i) {
                    return null;
                }
                return str.substring(i, i3);
            }
        }
        return str.substring(i);
    }

    private ForwardedHeaderParser() {
    }
}
