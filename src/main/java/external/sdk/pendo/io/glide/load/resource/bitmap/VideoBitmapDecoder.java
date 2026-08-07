package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context context) {
        this(external.sdk.pendo.io.glide.a.a(context).c());
    }

    public VideoBitmapDecoder(sdk.pendo.io.i.b bVar) {
        super(bVar, new VideoDecoder.g());
    }
}
