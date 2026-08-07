package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import java.io.IOException;
import java.io.InputStream;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public class StreamBitmapDecoder implements i<InputStream, Bitmap> {
    private final sdk.pendo.io.i.a byteArrayPool;
    private final b downsampler;

    static class a implements b.InterfaceC0317b {
        private final sdk.pendo.io.n.a a;
        private final sdk.pendo.io.y.d b;

        a(sdk.pendo.io.n.a aVar, sdk.pendo.io.y.d dVar) {
            this.a = aVar;
            this.b = dVar;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0317b
        public void a(sdk.pendo.io.i.b bVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                bVar.put(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0317b
        public void a() {
            this.a.a();
        }
    }

    public StreamBitmapDecoder(b bVar, sdk.pendo.io.i.a aVar) {
        this.downsampler = bVar;
        this.byteArrayPool = aVar;
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        boolean z;
        sdk.pendo.io.n.a aVar;
        if (inputStream instanceof sdk.pendo.io.n.a) {
            aVar = (sdk.pendo.io.n.a) inputStream;
            z = false;
        } else {
            z = true;
            aVar = new sdk.pendo.io.n.a(inputStream, this.byteArrayPool);
        }
        sdk.pendo.io.y.d dVarA = sdk.pendo.io.y.d.a(aVar);
        try {
            return this.downsampler.a(new sdk.pendo.io.y.i(dVarA), i, i2, options, new a(aVar, dVarA));
        } finally {
            dVarA.b();
            if (z) {
                aVar.b();
            }
        }
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(InputStream inputStream, Options options) {
        return this.downsampler.a(inputStream);
    }
}
