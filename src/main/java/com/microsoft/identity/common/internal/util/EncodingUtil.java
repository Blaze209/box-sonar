package com.microsoft.identity.common.internal.util;

import android.util.Base64;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes14.dex */
public final class EncodingUtil {
    private EncodingUtil() {
    }

    public static String base64UrlEncodeToString(String str) {
        return Base64.encodeToString(str.getBytes(Charset.forName("UTF-8")), 10);
    }
}
