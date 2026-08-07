package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.drawable.ResourceDrawableDecoder;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public class ResourceBitmapDecoder implements i<Uri, Bitmap> {
    private final sdk.pendo.io.i.b bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, sdk.pendo.io.i.b bVar) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bVar;
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(Uri uri, int i, int i2, Options options) {
        sdk.pendo.io.h.c<Drawable> cVarDecode = this.drawableDecoder.decode(uri, i, i2, options);
        if (cVarDecode == null) {
            return null;
        }
        return c.a(this.bitmapPool, cVarDecode.get(), i, i2);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(Uri uri, Options options) {
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme());
    }
}
