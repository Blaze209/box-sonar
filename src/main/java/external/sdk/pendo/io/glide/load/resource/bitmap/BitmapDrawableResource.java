package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> {
    private final sdk.pendo.io.i.b bitmapPool;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, sdk.pendo.io.i.b bVar) {
        super(bitmapDrawable);
        this.bitmapPool = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public int getSize() {
        return l.a(((BitmapDrawable) this.drawable).getBitmap());
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.b
    public void initialize() {
        ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable) this.drawable).getBitmap());
    }
}
