package external.sdk.pendo.io.glide.load.resource.gif;

import external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource;

/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public int getSize() {
        return ((GifDrawable) this.drawable).getSize();
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.b
    public void initialize() {
        ((GifDrawable) this.drawable).getFirstFrame().prepareToDraw();
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }
}
