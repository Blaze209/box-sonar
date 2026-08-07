package external.sdk.pendo.io.glide.load.resource.gif;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.gifdecoder.a;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapResource;
import sdk.pendo.io.e.i;
import sdk.pendo.io.h.c;
import sdk.pendo.io.i.b;

/* JADX INFO: loaded from: classes4.dex */
public final class GifFrameResourceDecoder implements i<a, Bitmap> {
    private final b bitmapPool;

    public GifFrameResourceDecoder(b bVar) {
        this.bitmapPool = bVar;
    }

    @Override // sdk.pendo.io.e.i
    public c<Bitmap> decode(a aVar, int i, int i2, Options options) {
        return BitmapResource.obtain(aVar.getNextFrame(), this.bitmapPool);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(a aVar, Options options) {
        return true;
    }
}
