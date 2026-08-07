package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);
    private final int degreesToRotate;

    public Rotate(int i) {
        this.degreesToRotate = i;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.degreesToRotate == ((Rotate) obj).degreesToRotate;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return l.a(34013362, l.b(this.degreesToRotate));
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.n.b.a(bitmap, this.degreesToRotate);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
