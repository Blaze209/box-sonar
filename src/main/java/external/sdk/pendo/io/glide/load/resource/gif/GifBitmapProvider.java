package external.sdk.pendo.io.glide.load.resource.gif;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.gifdecoder.a;
import sdk.pendo.io.i.b;

/* JADX INFO: loaded from: classes4.dex */
public final class GifBitmapProvider implements a.InterfaceC0305a {
    private final sdk.pendo.io.i.a arrayPool;
    private final b bitmapPool;

    public GifBitmapProvider(b bVar) {
        this(bVar, null);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public Bitmap obtain(int i, int i2, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public byte[] obtainByteArray(int i) {
        sdk.pendo.io.i.a aVar = this.arrayPool;
        return aVar == null ? new byte[i] : (byte[]) aVar.get(i, byte[].class);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public int[] obtainIntArray(int i) {
        sdk.pendo.io.i.a aVar = this.arrayPool;
        return aVar == null ? new int[i] : (int[]) aVar.get(i, int[].class);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public void release(Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    public GifBitmapProvider(b bVar, sdk.pendo.io.i.a aVar) {
        this.bitmapPool = bVar;
        this.arrayPool = aVar;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public void release(byte[] bArr) {
        sdk.pendo.io.i.a aVar = this.arrayPool;
        if (aVar == null) {
            return;
        }
        aVar.put(bArr);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a
    public void release(int[] iArr) {
        sdk.pendo.io.i.a aVar = this.arrayPool;
        if (aVar == null) {
            return;
        }
        aVar.put(iArr);
    }
}
