package org.jose4j.lang;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultByteGenerator implements ByteGenerator {
    private final SecureRandom random = new SecureRandom();

    @Override // org.jose4j.lang.ByteGenerator
    public byte[] randomBytes(int i) {
        byte[] bArr = new byte[i];
        this.random.nextBytes(bArr);
        return bArr;
    }
}
