package external.sdk.pendo.io.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import external.sdk.pendo.io.glide.load.Transformation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.i.b;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.b, Animatable, Animatable2Compat {
    private static final int GRAVITY = 119;
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    private boolean applyGravity;
    private Rect destRect;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private Paint paint;
    private final a state;

    static final class a extends Drawable.ConstantState {
        final GifFrameLoader a;

        a(GifFrameLoader gifFrameLoader) {
            this.a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public GifDrawable(Context context, external.sdk.pendo.io.glide.gifdecoder.a aVar, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(new a(new GifFrameLoader(external.sdk.pendo.io.glide.a.a(context), aVar, i, i2, transformation, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.drawable.Drawable$Callback] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private Drawable.Callback findCallback() {
        ?? r1 = this;
        while (true) {
            ?? callback = r1.getCallback();
            if (!(callback instanceof Drawable)) {
                return callback;
            }
            r1 = (Drawable) callback;
        }
    }

    private Rect getDestRect() {
        if (this.destRect == null) {
            this.destRect = new Rect();
        }
        return this.destRect;
    }

    private Paint getPaint() {
        if (this.paint == null) {
            this.paint = new Paint(2);
        }
        return this.paint;
    }

    private void notifyAnimationEndToListeners() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.animationCallbacks.get(i).onAnimationEnd(this);
            }
        }
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        k.a(!this.isRecycled, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.state.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.state.a.a(this);
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.state.a.b(this);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), getDestRect());
            this.applyGravity = false;
        }
        canvas.drawBitmap(this.state.a.c(), (Rect) null, getDestRect(), getPaint());
    }

    public ByteBuffer getBuffer() {
        return this.state.a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public Bitmap getFirstFrame() {
        return this.state.a.e();
    }

    public int getFrameCount() {
        return this.state.a.f();
    }

    public int getFrameIndex() {
        return this.state.a.d();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.a.l();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.state.a.k();
    }

    boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.gif.GifFrameLoader.b
    public void onFrameReady() {
        if (findCallback() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.loopCount++;
        }
        int i = this.maxLoopCount;
        if (i == -1 || this.loopCount < i) {
            return;
        }
        stop();
        notifyAnimationEndToListeners();
    }

    public void recycle() {
        this.isRecycled = true;
        this.state.a.a();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        this.animationCallbacks.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        getPaint().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.state.a.a(transformation, bitmap);
    }

    void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    public void setLoopCount(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i == 0 && (i = this.state.a.j()) == 0) {
            i = -1;
        }
        this.maxLoopCount = i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        k.a(!this.isRecycled, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    public void startFromFirstFrame() {
        k.a(!this.isRunning, "You cannot restart a currently running animation.");
        this.state.a.o();
        start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.animationCallbacks;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    @Deprecated
    public GifDrawable(Context context, external.sdk.pendo.io.glide.gifdecoder.a aVar, b bVar, Transformation<Bitmap> transformation, int i, int i2, Bitmap bitmap) {
        this(context, aVar, transformation, i, i2, bitmap);
    }

    GifDrawable(a aVar) {
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.state = (a) k.a(aVar);
    }

    GifDrawable(GifFrameLoader gifFrameLoader, Paint paint) {
        this(new a(gifFrameLoader));
        this.paint = paint;
    }
}
