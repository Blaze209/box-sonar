package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import java.nio.ByteBuffer;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferBitmapDecoder implements i<ByteBuffer, Bitmap> {
    private final b downsampler;

    public ByteBufferBitmapDecoder(b bVar) {
        this.downsampler = bVar;
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.downsampler.a(byteBuffer, i, i2, options);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.downsampler.a(byteBuffer);
    }
}
