package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.shaded.jcip.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class AuthenticatedCipherText {
    private final byte[] authenticationTag;
    private final byte[] cipherText;

    public AuthenticatedCipherText(byte[] bArr, byte[] bArr2) {
        this.cipherText = (byte[]) Objects.requireNonNull(bArr);
        this.authenticationTag = (byte[]) Objects.requireNonNull(bArr2);
    }

    public byte[] getCipherText() {
        return this.cipherText;
    }

    public byte[] getAuthenticationTag() {
        return this.authenticationTag;
    }
}
