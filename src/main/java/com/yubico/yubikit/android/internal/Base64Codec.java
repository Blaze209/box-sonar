package com.yubico.yubikit.android.internal;

import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public class Base64Codec implements com.yubico.yubikit.core.internal.codec.Base64Codec {
    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public String toUrlSafeString(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public String toString(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public byte[] fromUrlSafeString(String str) {
        return Base64.decode(str, 11);
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public byte[] fromString(String str) {
        return Base64.decode(str, 3);
    }
}
