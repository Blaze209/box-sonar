package external.sdk.pendo.io.glide.signature;

import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectKey implements f {
    private final Object object;

    public ObjectKey(Object obj) {
        this.object = k.a(obj);
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.object.equals(((ObjectKey) obj).object);
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.object + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.object.toString().getBytes(f.a));
    }
}
