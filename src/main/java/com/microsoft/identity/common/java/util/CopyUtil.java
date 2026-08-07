package com.microsoft.identity.common.java.util;

import java.util.Arrays;
import java.util.Date;

/* JADX INFO: loaded from: classes14.dex */
public class CopyUtil {
    public static Date copyIfNotNull(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    public static char[] copyIfNotNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return Arrays.copyOf(cArr, cArr.length);
    }

    public static byte[] copyIfNotNull(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
