package external.sdk.pendo.io.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import sdk.pendo.io.h.c;
import sdk.pendo.io.i.b;
import sdk.pendo.io.q.a;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableTranscoder implements a<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(Context context) {
        this(context.getResources());
    }

    @Override // sdk.pendo.io.q.a
    public c<BitmapDrawable> transcode(c<Bitmap> cVar, Options options) {
        return LazyBitmapDrawableResource.obtain(this.resources, cVar);
    }

    public BitmapDrawableTranscoder(Resources resources) {
        this.resources = (Resources) k.a(resources);
    }

    @Deprecated
    public BitmapDrawableTranscoder(Resources resources, b bVar) {
        this(resources);
    }
}
