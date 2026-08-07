package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) k.a(new DrawableTransformation(transformation, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static sdk.pendo.io.h.c<BitmapDrawable> convertToBitmapDrawableResource(sdk.pendo.io.h.c<Drawable> cVar) {
        if (cVar.get() instanceof BitmapDrawable) {
            return cVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + cVar.get());
    }

    private static sdk.pendo.io.h.c<Drawable> convertToDrawableResource(sdk.pendo.io.h.c<BitmapDrawable> cVar) {
        return cVar;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.wrapped.equals(((BitmapDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public sdk.pendo.io.h.c<BitmapDrawable> transform(Context context, sdk.pendo.io.h.c<BitmapDrawable> cVar, int i, int i2) {
        return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(cVar), i, i2));
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
