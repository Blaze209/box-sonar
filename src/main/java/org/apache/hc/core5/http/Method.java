package org.apache.hc.core5.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public enum Method {
    GET(true, true),
    HEAD(true, true),
    POST(false, false),
    PUT(false, true),
    DELETE(false, true),
    CONNECT(false, false),
    TRACE(true, true),
    OPTIONS(true, true),
    PATCH(false, false);

    private final boolean idempotent;
    private final boolean safe;

    Method(boolean z, boolean z2) {
        this.safe = z;
        this.idempotent = z2;
    }

    public boolean isSafe() {
        return this.safe;
    }

    public boolean isIdempotent() {
        return this.idempotent;
    }

    public static boolean isSafe(String str) {
        if (str == null) {
            return false;
        }
        try {
            return normalizedValueOf(str).safe;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean isIdempotent(String str) {
        if (str == null) {
            return false;
        }
        try {
            return normalizedValueOf(str).idempotent;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static Method normalizedValueOf(String str) {
        return valueOf(((String) Args.notNull(str, FirebaseAnalytics.Param.METHOD)).toUpperCase(Locale.ROOT));
    }

    public boolean isSame(String str) {
        if (str == null) {
            return false;
        }
        return name().equalsIgnoreCase(str);
    }
}
