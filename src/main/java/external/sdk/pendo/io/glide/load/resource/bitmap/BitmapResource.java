package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapResource implements sdk.pendo.io.h.c<Bitmap>, sdk.pendo.io.h.b {
    private final Bitmap bitmap;
    private final sdk.pendo.io.i.b bitmapPool;

    public BitmapResource(Bitmap bitmap, sdk.pendo.io.i.b bVar) {
        this.bitmap = (Bitmap) k.a(bitmap, "Bitmap must not be null");
        this.bitmapPool = (sdk.pendo.io.i.b) k.a(bVar, "BitmapPool must not be null");
    }

    public static BitmapResource obtain(Bitmap bitmap, sdk.pendo.io.i.b bVar) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // sdk.pendo.io.h.c
    public Bitmap get() {
        return this.bitmap;
    }

    @Override // sdk.pendo.io.h.c
    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    @Override // sdk.pendo.io.h.c
    public int getSize() {
        return l.a(this.bitmap);
    }

    @Override // sdk.pendo.io.h.b
    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    @Override // sdk.pendo.io.h.c
    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}
