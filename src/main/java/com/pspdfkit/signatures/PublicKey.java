package com.pspdfkit.signatures;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/signatures/PublicKey;", "", "publicKeyScheme", "", "keyLength", "", "<init>", "(Ljava/lang/String;I)V", "getPublicKeyScheme", "()Ljava/lang/String;", "getKeyLength", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PublicKey {
    public static final int $stable = 0;
    private final int keyLength;
    private final String publicKeyScheme;

    public PublicKey(String str, int i) {
        str.getClass();
        this.publicKeyScheme = str;
        this.keyLength = i;
    }

    public final int getKeyLength() {
        return this.keyLength;
    }

    public final String getPublicKeyScheme() {
        return this.publicKeyScheme;
    }
}
