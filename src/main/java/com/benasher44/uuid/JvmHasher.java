package com.benasher44.uuid;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: namebased.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/benasher44/uuid/JvmHasher;", "Lcom/benasher44/uuid/UuidHasher;", "algorithmName", "", "version", "", "(Ljava/lang/String;I)V", "digest", "Ljava/security/MessageDigest;", "kotlin.jvm.PlatformType", "getVersion", "()I", "", "update", "", "input", "uuid"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class JvmHasher implements UuidHasher {
    private final MessageDigest digest;
    private final int version;

    public JvmHasher(String algorithmName, int i) {
        Intrinsics.checkNotNullParameter(algorithmName, "algorithmName");
        this.version = i;
        this.digest = MessageDigest.getInstance(algorithmName);
    }

    @Override // com.benasher44.uuid.UuidHasher
    public int getVersion() {
        return this.version;
    }

    @Override // com.benasher44.uuid.UuidHasher
    public void update(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.digest.update(input);
    }

    @Override // com.benasher44.uuid.UuidHasher
    public byte[] digest() {
        byte[] bArrDigest = this.digest.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest.digest()");
        return bArrDigest;
    }
}
