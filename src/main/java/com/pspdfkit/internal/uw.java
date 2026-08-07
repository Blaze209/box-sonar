package com.pspdfkit.internal;

import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class uw {
    public static final <T> T a(T t, String str, String str2) {
        str.getClass();
        if (t != null) {
            return t;
        }
        String str3 = "Argument '" + str + "' may not be null.";
        if (str2 != null) {
            str3 = str3 + " " + str2;
        }
        throw new IllegalArgumentException(str3);
    }

    public static final void b(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str.toString());
        }
    }

    public static final void a(Collection<?> collection, String str) {
        a((collection == null || collection.isEmpty()) ? false : true, str);
    }

    public static final void a(Object[] objArr, String str) {
        a((objArr == null || objArr.length == 0) ? false : true, str);
    }

    public static final void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str.toString());
        }
    }
}
