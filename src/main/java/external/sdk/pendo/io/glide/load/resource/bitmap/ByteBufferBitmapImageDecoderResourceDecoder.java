package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import external.sdk.pendo.io.glide.load.Options;
import java.nio.ByteBuffer;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ByteBufferBitmapImageDecoderResourceDecoder implements i<ByteBuffer, Bitmap> {
    private final BitmapImageDecoderResourceDecoder wrapped = new BitmapImageDecoderResourceDecoder();

    @Override // sdk.pendo.io.e.i
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return true;
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.wrapped.decode(ImageDecoder.createSource(byteBuffer), i, i2, options);
    }
}
