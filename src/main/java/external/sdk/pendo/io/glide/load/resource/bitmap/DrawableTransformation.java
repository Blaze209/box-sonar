package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class DrawableTransformation implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.wrapped = transformation;
        this.isRequired = z;
    }

    private sdk.pendo.io.h.c<Drawable> newDrawableResource(Context context, sdk.pendo.io.h.c<Bitmap> cVar) {
        return LazyBitmapDrawableResource.obtain(context.getResources(), cVar);
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.wrapped.equals(((DrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public sdk.pendo.io.h.c<Drawable> transform(Context context, sdk.pendo.io.h.c<Drawable> cVar, int i, int i2) {
        sdk.pendo.io.i.b bVarC = external.sdk.pendo.io.glide.a.a(context).c();
        Drawable drawable = cVar.get();
        sdk.pendo.io.h.c<Bitmap> cVarA = c.a(bVarC, drawable, i, i2);
        if (cVarA == null) {
            if (this.isRequired) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return cVar;
        }
        sdk.pendo.io.h.c<Bitmap> cVarTransform = this.wrapped.transform(context, cVarA, i, i2);
        if (!cVarTransform.equals(cVarA)) {
            return newDrawableResource(context, cVarTransform);
        }
        cVarTransform.recycle();
        return cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
