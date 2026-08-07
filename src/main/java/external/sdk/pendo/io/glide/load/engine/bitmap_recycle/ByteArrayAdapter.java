package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes4.dex */
public final class ByteArrayAdapter implements a<byte[]> {
    private static final String TAG = "ByteArrayPool";

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return TAG;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public int getArrayLength(byte[] bArr) {
        return bArr.length;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
