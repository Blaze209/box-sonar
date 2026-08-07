package com.yubico.yubikit.core.internal.codec;

/* JADX INFO: loaded from: classes3.dex */
public interface Base64Codec {
    byte[] fromString(String str);

    byte[] fromUrlSafeString(String str);

    String toString(byte[] bArr);

    String toUrlSafeString(byte[] bArr);
}
