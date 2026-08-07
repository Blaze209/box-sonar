package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.io.IOException;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapImageDecoderResourceDecoder implements i<ImageDecoder.Source, Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final sdk.pendo.io.i.b bitmapPool = new BitmapPoolAdapter();

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(ImageDecoder.Source source, int i, int i2, Options options) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new sdk.pendo.io.m.a(i, i2, options));
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new BitmapResource(bitmapDecodeBitmap, this.bitmapPool);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(ImageDecoder.Source source, Options options) {
        return true;
    }
}
