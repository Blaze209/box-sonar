package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapPoolAdapter implements sdk.pendo.io.i.b {
    @Override // sdk.pendo.io.i.b
    public void clearMemory() {
    }

    @Override // sdk.pendo.io.i.b
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // sdk.pendo.io.i.b
    public Bitmap getDirty(int i, int i2, Bitmap.Config config) {
        return get(i, i2, config);
    }

    public long getMaxSize() {
        return 0L;
    }

    @Override // sdk.pendo.io.i.b
    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void setSizeMultiplier(float f) {
    }

    @Override // sdk.pendo.io.i.b
    public void trimMemory(int i) {
    }
}
