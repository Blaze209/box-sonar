package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public class CenterInside extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.CenterInside";
    private static final byte[] ID_BYTES = ID.getBytes(f.a);

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        return obj instanceof CenterInside;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return 137706184;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.n.b.b(bVar, bitmap, i, i2);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
