package external.sdk.pendo.io.glide.load.engine;

import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class c implements sdk.pendo.io.e.f {
    private final sdk.pendo.io.e.f b;
    private final sdk.pendo.io.e.f c;

    c(sdk.pendo.io.e.f fVar, sdk.pendo.io.e.f fVar2) {
        this.b = fVar;
        this.c = fVar2;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.b.equals(cVar.b) && this.c.equals(cVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
    }
}
