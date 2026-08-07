package external.sdk.pendo.io.glide.signature;

import java.security.MessageDigest;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptySignature implements f {
    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    private EmptySignature() {
    }

    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
