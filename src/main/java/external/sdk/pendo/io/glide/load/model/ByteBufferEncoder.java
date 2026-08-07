package external.sdk.pendo.io.glide.load.model;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferEncoder implements sdk.pendo.io.e.d<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    @Override // sdk.pendo.io.e.d
    public boolean encode(ByteBuffer byteBuffer, File file, Options options) throws Throwable {
        try {
            sdk.pendo.io.y.a.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 3)) {
                return false;
            }
            Log.d(TAG, "Failed to write data", e);
            return false;
        }
    }
}
