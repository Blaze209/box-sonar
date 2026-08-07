package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.e.i;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class UnitBitmapDecoder implements i<Bitmap, Bitmap> {

    private static final class a implements sdk.pendo.io.h.c<Bitmap> {
        private final Bitmap a;

        a(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // sdk.pendo.io.h.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.a;
        }

        @Override // sdk.pendo.io.h.c
        public Class<Bitmap> getResourceClass() {
            return Bitmap.class;
        }

        @Override // sdk.pendo.io.h.c
        public int getSize() {
            return l.a(this.a);
        }

        @Override // sdk.pendo.io.h.c
        public void recycle() {
        }
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(Bitmap bitmap, int i, int i2, Options options) {
        return new a(bitmap);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }
}
