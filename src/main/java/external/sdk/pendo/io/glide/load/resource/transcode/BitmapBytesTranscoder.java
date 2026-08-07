package external.sdk.pendo.io.glide.load.resource.transcode;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;
import sdk.pendo.io.h.c;
import sdk.pendo.io.q.a;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapBytesTranscoder implements a<Bitmap, byte[]> {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // sdk.pendo.io.q.a
    public c<byte[]> transcode(c<Bitmap> cVar, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        cVar.get().compress(this.compressFormat, this.quality, byteArrayOutputStream);
        cVar.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }
}
