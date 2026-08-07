package sdk.pendo.io.i;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface b {
    void clearMemory();

    Bitmap get(int i, int i2, Bitmap.Config config);

    Bitmap getDirty(int i, int i2, Bitmap.Config config);

    void put(Bitmap bitmap);

    void trimMemory(int i);
}
