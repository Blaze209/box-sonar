package external.sdk.pendo.io.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.gifdecoder.a$a, reason: collision with other inner class name */
    public interface InterfaceC0305a {
        Bitmap obtain(int i, int i2, Bitmap.Config config);

        byte[] obtainByteArray(int i);

        int[] obtainIntArray(int i);

        void release(Bitmap bitmap);

        void release(byte[] bArr);

        void release(int[] iArr);
    }

    void advance();

    void clear();

    int getByteSize();

    int getCurrentFrameIndex();

    ByteBuffer getData();

    int getFrameCount();

    int getNextDelay();

    Bitmap getNextFrame();

    int getTotalIterationCount();

    void resetFrameIndex();

    void setDefaultBitmapConfig(Bitmap.Config config);
}
