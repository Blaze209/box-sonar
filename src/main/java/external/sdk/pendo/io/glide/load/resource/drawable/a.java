package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
final class a extends DrawableResource<Drawable> {
    private a(Drawable drawable) {
        super(drawable);
    }

    static c<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new a(drawable);
        }
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public Class<Drawable> getResourceClass() {
        return this.drawable.getClass();
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public int getSize() {
        return Math.max(1, this.drawable.getIntrinsicWidth() * this.drawable.getIntrinsicHeight() * 4);
    }

    @Override // external.sdk.pendo.io.glide.load.resource.drawable.DrawableResource, sdk.pendo.io.h.c
    public void recycle() {
    }
}
