package external.sdk.pendo.io.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapResource;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import sdk.pendo.io.h.c;
import sdk.pendo.io.i.b;
import sdk.pendo.io.q.a;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawableBytesTranscoder implements a<Drawable, byte[]> {
    private final a<Bitmap, byte[]> bitmapBytesTranscoder;
    private final b bitmapPool;
    private final a<GifDrawable, byte[]> gifDrawableBytesTranscoder;

    public DrawableBytesTranscoder(b bVar, a<Bitmap, byte[]> aVar, a<GifDrawable, byte[]> aVar2) {
        this.bitmapPool = bVar;
        this.bitmapBytesTranscoder = aVar;
        this.gifDrawableBytesTranscoder = aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static c<GifDrawable> toGifDrawableResource(c<Drawable> cVar) {
        return cVar;
    }

    @Override // sdk.pendo.io.q.a
    public c<byte[]> transcode(c<Drawable> cVar, Options options) {
        Drawable drawable = cVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.bitmapBytesTranscoder.transcode(BitmapResource.obtain(((BitmapDrawable) drawable).getBitmap(), this.bitmapPool), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.gifDrawableBytesTranscoder.transcode(toGifDrawableResource(cVar), options);
        }
        return null;
    }
}
