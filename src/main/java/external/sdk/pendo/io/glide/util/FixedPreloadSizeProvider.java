package external.sdk.pendo.io.glide.util;

/* JADX INFO: loaded from: classes4.dex */
public class FixedPreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.size = new int[]{i, i2};
    }

    public int[] getPreloadSize(T t, int i, int i2) {
        return this.size;
    }
}
