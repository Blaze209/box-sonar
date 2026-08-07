package org.jose4j.base64url;

/* JADX INFO: loaded from: classes5.dex */
public class SimplePEMEncoder {
    public static String encode(byte[] bArr) {
        return getCodec().encodeToString(bArr);
    }

    public static byte[] decode(String str) {
        return getCodec().decode(str);
    }

    static org.jose4j.base64url.internal.apache.commons.codec.binary.Base64 getCodec() {
        return new org.jose4j.base64url.internal.apache.commons.codec.binary.Base64(64);
    }
}
