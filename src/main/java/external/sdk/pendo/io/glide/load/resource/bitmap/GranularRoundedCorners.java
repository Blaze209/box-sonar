package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class GranularRoundedCorners extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.GranularRoundedCorners";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public GranularRoundedCorners(float f, float f2, float f3, float f4) {
        this.topLeft = f;
        this.topRight = f2;
        this.bottomRight = f3;
        this.bottomLeft = f4;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof GranularRoundedCorners) {
            GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
            if (this.topLeft == granularRoundedCorners.topLeft && this.topRight == granularRoundedCorners.topRight && this.bottomRight == granularRoundedCorners.bottomRight && this.bottomLeft == granularRoundedCorners.bottomLeft) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return l.a(this.bottomLeft, l.a(this.bottomRight, l.a(this.topRight, l.a(-1675666904, l.a(this.topLeft)))));
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.n.b.a(bVar, bitmap, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }
}
