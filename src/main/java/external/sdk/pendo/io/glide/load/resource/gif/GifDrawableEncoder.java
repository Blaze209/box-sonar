package external.sdk.pendo.io.glide.load.resource.gif;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.io.File;
import java.io.IOException;
import sdk.pendo.io.e.c;
import sdk.pendo.io.y.a;

/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder
    public c getEncodeStrategy(Options options) {
        return c.SOURCE;
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder, sdk.pendo.io.e.d
    public boolean encode(sdk.pendo.io.h.c<GifDrawable> cVar, File file, Options options) throws Throwable {
        try {
            a.a(cVar.get().getBuffer(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 5)) {
                return false;
            }
            Log.w(TAG, "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
