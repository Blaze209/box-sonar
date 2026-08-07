package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
class k implements sdk.pendo.io.e.f {
    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final sdk.pendo.io.e.f g;
    private final Map<Class<?>, Transformation<?>> h;
    private final Options i;
    private int j;

    k(Object obj, sdk.pendo.io.e.f fVar, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.b = sdk.pendo.io.y.k.a(obj);
        this.g = (sdk.pendo.io.e.f) sdk.pendo.io.y.k.a(fVar, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) sdk.pendo.io.y.k.a(map);
        this.e = (Class) sdk.pendo.io.y.k.a(cls, "Resource class must not be null");
        this.f = (Class) sdk.pendo.io.y.k.a(cls2, "Transcode class must not be null");
        this.i = (Options) sdk.pendo.io.y.k.a(options);
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.b.equals(kVar.b) && this.g.equals(kVar.g) && this.d == kVar.d && this.c == kVar.c && this.h.equals(kVar.h) && this.e.equals(kVar.e) && this.f.equals(kVar.f) && this.i.equals(kVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.h.hashCode();
            this.j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.j = iHashCode5;
            this.j = (iHashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
