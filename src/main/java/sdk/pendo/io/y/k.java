package sdk.pendo.io.y;

import android.text.TextUtils;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public final class k {
    public static void a(boolean z) {
        a(z, "");
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static <T extends Collection<Y>, Y> T a(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    public static <T> T a(T t) {
        return (T) a(t, "Argument must not be null");
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
