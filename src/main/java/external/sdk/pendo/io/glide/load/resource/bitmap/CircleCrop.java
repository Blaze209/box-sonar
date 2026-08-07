package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public class CircleCrop extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);
    private static final int VERSION = 1;

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return 1909665626;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.n.b.c(bVar, bitmap, i, i2);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
