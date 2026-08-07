package com.yubico.yubikit.core.internal.codec;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultBase64Codec implements Base64Codec {
    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public String toUrlSafeString(byte[] bArr) {
        return new String(java.util.Base64.getUrlEncoder().withoutPadding().encode(bArr));
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public String toString(byte[] bArr) {
        return new String(java.util.Base64.getEncoder().withoutPadding().encode(bArr));
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public byte[] fromUrlSafeString(String str) {
        return java.util.Base64.getUrlDecoder().decode(str);
    }

    @Override // com.yubico.yubikit.core.internal.codec.Base64Codec
    public byte[] fromString(String str) {
        return java.util.Base64.getDecoder().decode(str);
    }
}
