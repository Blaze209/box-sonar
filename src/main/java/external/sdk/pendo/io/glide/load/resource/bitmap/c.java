package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes4.dex */
final class c {
    private static final sdk.pendo.io.i.b a = new a();

    class a extends BitmapPoolAdapter {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, sdk.pendo.io.i.b
        public void put(Bitmap bitmap) {
        }
    }

    static sdk.pendo.io.h.c<Bitmap> a(sdk.pendo.io.i.b bVar, Drawable drawable, int i, int i2) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(bVar, current, i, i2);
            z = true;
        }
        if (!z) {
            bVar = a;
        }
        return BitmapResource.obtain(bitmapB, bVar);
    }

    private static Bitmap b(sdk.pendo.io.i.b bVar, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock lockA = sdk.pendo.io.n.b.a();
        lockA.lock();
        Bitmap bitmap = bVar.get(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmap;
        } finally {
            lockA.unlock();
        }
    }
}
