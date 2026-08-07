package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import external.sdk.pendo.io.glide.load.Options;
import java.io.InputStream;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public final class InputStreamBitmapImageDecoderResourceDecoder implements i<InputStream, Bitmap> {
    private final BitmapImageDecoderResourceDecoder wrapped = new BitmapImageDecoderResourceDecoder();

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return this.wrapped.decode(ImageDecoder.createSource(sdk.pendo.io.y.a.a(inputStream)), i, i2, options);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(InputStream inputStream, Options options) {
        return true;
    }
}
