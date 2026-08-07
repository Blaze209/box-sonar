package com.yubico.yubikit.core.internal.codec;

import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes3.dex */
public class Base64 {
    private static final Base64Codec base64Codec;

    static {
        Iterator it = ServiceLoader.load(Base64Codec.class).iterator();
        base64Codec = it.hasNext() ? (Base64Codec) it.next() : new DefaultBase64Codec();
    }

    public static String toUrlSafeString(byte[] bArr) {
        return base64Codec.toUrlSafeString(bArr);
    }

    public static byte[] fromUrlSafeString(String str) {
        return base64Codec.fromUrlSafeString(str);
    }

    public static Base64Codec getBase64Codec() {
        return base64Codec;
    }
}
