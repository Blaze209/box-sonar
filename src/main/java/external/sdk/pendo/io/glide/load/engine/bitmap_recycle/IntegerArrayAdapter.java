package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes4.dex */
public final class IntegerArrayAdapter implements a<int[]> {
    private static final String TAG = "IntegerArrayPool";

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return TAG;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public int getArrayLength(int[] iArr) {
        return iArr.length;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.a
    public int[] newArray(int i) {
        return new int[i];
    }
}
