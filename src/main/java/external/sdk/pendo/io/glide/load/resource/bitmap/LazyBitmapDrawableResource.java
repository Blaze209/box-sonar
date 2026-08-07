package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public final class LazyBitmapDrawableResource implements sdk.pendo.io.h.c<BitmapDrawable>, sdk.pendo.io.h.b {
    private final sdk.pendo.io.h.c<Bitmap> bitmapResource;
    private final Resources resources;

    private LazyBitmapDrawableResource(Resources resources, sdk.pendo.io.h.c<Bitmap> cVar) {
        this.resources = (Resources) k.a(resources);
        this.bitmapResource = (sdk.pendo.io.h.c) k.a(cVar);
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(context.getResources(), BitmapResource.obtain(bitmap, external.sdk.pendo.io.glide.a.a(context).c()));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // sdk.pendo.io.h.c
    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, this.bitmapResource.get());
    }

    @Override // sdk.pendo.io.h.c
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // sdk.pendo.io.h.c
    public int getSize() {
        return this.bitmapResource.getSize();
    }

    @Override // sdk.pendo.io.h.b
    public void initialize() {
        sdk.pendo.io.h.c<Bitmap> cVar = this.bitmapResource;
        if (cVar instanceof sdk.pendo.io.h.b) {
            ((sdk.pendo.io.h.b) cVar).initialize();
        }
    }

    @Override // sdk.pendo.io.h.c
    public void recycle() {
        this.bitmapResource.recycle();
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, sdk.pendo.io.i.b bVar, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) obtain(resources, BitmapResource.obtain(bitmap, bVar));
    }

    public static sdk.pendo.io.h.c<BitmapDrawable> obtain(Resources resources, sdk.pendo.io.h.c<Bitmap> cVar) {
        if (cVar == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, cVar);
    }
}
