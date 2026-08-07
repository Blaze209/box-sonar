package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class s implements sdk.pendo.io.e.f {
    private static final sdk.pendo.io.y.h<Class<?>, byte[]> j = new sdk.pendo.io.y.h<>(50);
    private final sdk.pendo.io.i.a b;
    private final sdk.pendo.io.e.f c;
    private final sdk.pendo.io.e.f d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final Options h;
    private final Transformation<?> i;

    s(sdk.pendo.io.i.a aVar, sdk.pendo.io.e.f fVar, sdk.pendo.io.e.f fVar2, int i, int i2, Transformation<?> transformation, Class<?> cls, Options options) {
        this.b = aVar;
        this.c = fVar;
        this.d = fVar2;
        this.e = i;
        this.f = i2;
        this.i = transformation;
        this.g = cls;
        this.h = options;
    }

    private byte[] a() {
        sdk.pendo.io.y.h<Class<?>, byte[]> hVar = j;
        byte[] bArr = hVar.get(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(sdk.pendo.io.e.f.a);
        hVar.put(this.g, bytes);
        return bytes;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f == sVar.f && this.e == sVar.e && sdk.pendo.io.y.l.b(this.i, sVar.i) && this.g.equals(sVar.g) && this.c.equals(sVar.c) && this.d.equals(sVar.d) && this.h.equals(sVar.h)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        Transformation<?> transformation = this.i;
        if (transformation != null) {
            iHashCode = (iHashCode * 31) + transformation.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.i;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.b.put(bArr);
    }
}
