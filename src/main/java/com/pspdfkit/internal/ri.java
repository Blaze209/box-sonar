package com.pspdfkit.internal;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ri {
    public final qi a = new qi();

    public static String a(String str, int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "d[%s]p[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i)}, 2));
    }
}
