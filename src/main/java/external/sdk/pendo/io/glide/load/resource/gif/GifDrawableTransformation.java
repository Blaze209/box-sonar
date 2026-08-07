package external.sdk.pendo.io.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;
import sdk.pendo.io.h.c;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) k.a(transformation);
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.wrapped.equals(((GifDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public c<GifDrawable> transform(Context context, c<GifDrawable> cVar, int i, int i2) {
        GifDrawable gifDrawable = cVar.get();
        c<Bitmap> bitmapResource = new BitmapResource(gifDrawable.getFirstFrame(), a.a(context).c());
        c<Bitmap> cVarTransform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(cVarTransform)) {
            bitmapResource.recycle();
        }
        gifDrawable.setFrameTransformation(this.wrapped, cVarTransform.get());
        return cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
