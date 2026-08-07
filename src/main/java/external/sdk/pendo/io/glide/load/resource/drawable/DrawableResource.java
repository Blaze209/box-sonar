package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import sdk.pendo.io.h.b;
import sdk.pendo.io.h.c;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DrawableResource<T extends Drawable> implements c<T>, b {
    protected final T drawable;

    public DrawableResource(T t) {
        this.drawable = (T) k.a(t);
    }

    @Override // sdk.pendo.io.h.c
    public final T get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        return constantState == null ? this.drawable : (T) constantState.newDrawable();
    }

    @Override // sdk.pendo.io.h.c
    public abstract /* synthetic */ Class getResourceClass();

    @Override // sdk.pendo.io.h.c
    public abstract /* synthetic */ int getSize();

    public void initialize() {
        Bitmap firstFrame;
        T t = this.drawable;
        if (t instanceof BitmapDrawable) {
            firstFrame = ((BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof GifDrawable)) {
            return;
        } else {
            firstFrame = ((GifDrawable) t).getFirstFrame();
        }
        firstFrame.prepareToDraw();
    }

    @Override // sdk.pendo.io.h.c
    public abstract /* synthetic */ void recycle();
}
