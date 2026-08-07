package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.e.i;
import sdk.pendo.io.h.c;

/* JADX INFO: loaded from: classes4.dex */
public class UnitDrawableDecoder implements i<Drawable, Drawable> {
    @Override // sdk.pendo.io.e.i
    public c<Drawable> decode(Drawable drawable, int i, int i2, Options options) {
        return a.a(drawable);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(Drawable drawable, Options options) {
        return true;
    }
}
