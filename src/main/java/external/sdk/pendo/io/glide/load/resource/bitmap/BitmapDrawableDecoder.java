package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.e.i;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapDrawableDecoder<DataType> implements i<DataType, BitmapDrawable> {
    private final i<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context, i<DataType, Bitmap> iVar) {
        this(context.getResources(), iVar);
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<BitmapDrawable> decode(DataType datatype, int i, int i2, Options options) {
        return LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i, i2, options));
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(DataType datatype, Options options) {
        return this.decoder.handles(datatype, options);
    }

    public BitmapDrawableDecoder(Resources resources, i<DataType, Bitmap> iVar) {
        this.resources = (Resources) k.a(resources);
        this.decoder = (i) k.a(iVar);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, sdk.pendo.io.i.b bVar, i<DataType, Bitmap> iVar) {
        this(resources, iVar);
    }
}
