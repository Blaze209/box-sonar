package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);
    private final int roundingRadius;

    public RoundedCorners(int i) {
        k.a(i > 0, "roundingRadius must be greater than 0.");
        this.roundingRadius = i;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.roundingRadius == ((RoundedCorners) obj).roundingRadius;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return l.a(-1519465048, l.b(this.roundingRadius));
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.n.b.b(bVar, bitmap, this.roundingRadius);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
