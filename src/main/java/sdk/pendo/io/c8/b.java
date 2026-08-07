package sdk.pendo.io.c8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010#\u001a\u00020!\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020*¢\u0006\u0004\bS\u0010TJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0017J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0003R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010$R\u0014\u0010'\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010>\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010J\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010ER\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010M¨\u0006U"}, d2 = {"Lsdk/pendo/io/c8/b;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "", "gifWidth", "gifHeight", "viewWidth", "viewHeight", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/graphics/Canvas;", "canvas", "draw", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "", ViewProps.VISIBLE, "restart", "setVisible", "alpha", "setAlpha", "Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "start", "stop", "isRunning", "loopCount", "Lexternal/sdk/pendo/io/glide/load/resource/gif/GifDrawable;", "Lexternal/sdk/pendo/io/glide/load/resource/gif/GifDrawable;", "gifDrawable", "I", "backgroundColor", "c", ViewProps.BORDER_COLOR, "d", ViewProps.BORDER_WIDTH, "", "e", "F", "cornerRadius", "Lsdk/pendo/io/b/f$a;", "f", "Lsdk/pendo/io/b/f$a;", "tileType", "Landroid/graphics/Matrix;", "g", "Landroid/graphics/Matrix;", "drawMatrix", CmcdData.STREAMING_FORMAT_HLS, "Z", "isValid", "i", "hasBackground", "j", "hasBorder", "k", "hasRoundedCorners", "Landroid/graphics/Path;", CmcdData.STREAM_TYPE_LIVE, "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/RectF;", CmcdData.OBJECT_TYPE_MANIFEST, "Landroid/graphics/RectF;", "drawRect", "n", "srcRect", "o", "dstRect", "Landroid/graphics/Paint;", "p", "Landroid/graphics/Paint;", "borderPaint", "q", "backgroundPaint", "", "tile", "<init>", "(Lexternal/sdk/pendo/io/glide/load/resource/gif/GifDrawable;Ljava/lang/String;IIIF)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final GifDrawable gifDrawable;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int backgroundColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int borderColor;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final int borderWidth;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final float cornerRadius;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final f.a tileType;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Matrix drawMatrix;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean isValid;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final boolean hasBackground;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean hasBorder;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final boolean hasRoundedCorners;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Path clipPath;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final RectF drawRect;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final RectF srcRect;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final RectF dstRect;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Paint borderPaint;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Paint backgroundPaint;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"sdk/pendo/io/c8/b$a", "Landroid/graphics/drawable/Drawable$Callback;", "Landroid/graphics/drawable/Drawable;", "who", "", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", "when", "scheduleDrawable", "unscheduleDrawable", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            b.this.scheduleSelf(what, when);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
            b.this.unscheduleSelf(what);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.c8.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class C0368b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f.a.values().length];
            try {
                iArr[f.a.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[f.a.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public b(GifDrawable gifDrawable, String str, int i, int i2, int i3, float f) {
        Intrinsics.checkNotNullParameter(gifDrawable, "gifDrawable");
        this.gifDrawable = gifDrawable;
        this.backgroundColor = i;
        this.borderColor = i2;
        this.borderWidth = i3;
        this.cornerRadius = f;
        this.tileType = str != null ? f.a.b(str) : null;
        this.drawMatrix = new Matrix();
        this.hasBackground = i != 0;
        this.hasBorder = i3 > 0;
        this.hasRoundedCorners = f > 0.0f;
        this.clipPath = new Path();
        this.drawRect = new RectF();
        this.srcRect = new RectF();
        this.dstRect = new RectF();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i2);
        paint.setStrokeWidth(i3);
        this.borderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(i);
        this.backgroundPaint = paint2;
        gifDrawable.setCallback(new a());
    }

    private final void a(int gifWidth, int gifHeight, int viewWidth, int viewHeight) {
        float f;
        float f2;
        f.a aVar = this.tileType;
        int i = aVar == null ? -1 : C0368b.a[aVar.ordinal()];
        float f3 = 0.0f;
        if (i != 1) {
            if (i != 2) {
                this.srcRect.set(0.0f, 0.0f, gifWidth, gifHeight);
                this.dstRect.set(0.0f, 0.0f, viewWidth, viewHeight);
                this.drawMatrix.setRectToRect(this.srcRect, this.dstRect, Matrix.ScaleToFit.FILL);
                return;
            } else {
                this.srcRect.set(0.0f, 0.0f, gifWidth, gifHeight);
                this.dstRect.set(0.0f, 0.0f, viewWidth, viewHeight);
                this.drawMatrix.setRectToRect(this.srcRect, this.dstRect, Matrix.ScaleToFit.CENTER);
                return;
            }
        }
        if (gifWidth * viewHeight > viewWidth * gifHeight) {
            f2 = viewHeight / gifHeight;
            float f4 = (viewWidth - (gifWidth * f2)) * 0.5f;
            f = 0.0f;
            f3 = f4;
        } else {
            float f5 = viewWidth / gifWidth;
            f = (viewHeight - (gifHeight * f5)) * 0.5f;
            f2 = f5;
        }
        this.drawMatrix.setScale(f2, f2);
        this.drawMatrix.postTranslate(f3, f);
    }

    private final void b(int gifWidth, int gifHeight, int viewWidth, int viewHeight) {
        float f = this.borderWidth / 2.0f;
        this.drawRect.set(f, f, viewWidth - f, viewHeight - f);
        if (this.hasRoundedCorners) {
            this.clipPath.reset();
            Path path = this.clipPath;
            RectF rectF = this.drawRect;
            float f2 = this.cornerRadius;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        }
        a(gifWidth, gifHeight, viewWidth, viewHeight);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth <= 0 || iHeight <= 0) {
            return;
        }
        int intrinsicWidth = this.gifDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.gifDrawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            this.gifDrawable.setBounds(0, 0, iWidth, iHeight);
            this.gifDrawable.draw(canvas);
            return;
        }
        if (!this.isValid) {
            b(intrinsicWidth, intrinsicHeight, iWidth, iHeight);
            this.isValid = true;
        }
        int iSave = canvas.save();
        try {
            if (this.hasRoundedCorners) {
                canvas.clipPath(this.clipPath);
            }
            if (this.hasBackground) {
                RectF rectF = this.drawRect;
                float f = this.cornerRadius;
                canvas.drawRoundRect(rectF, f, f, this.backgroundPaint);
            }
            canvas.concat(this.drawMatrix);
            this.gifDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.gifDrawable.draw(canvas);
            canvas.restoreToCount(iSave);
            if (this.hasBorder) {
                RectF rectF2 = this.drawRect;
                float f2 = this.cornerRadius;
                canvas.drawRoundRect(rectF2, f2, f2, this.borderPaint);
            }
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return this.gifDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.gifDrawable.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.isValid = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.gifDrawable.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.gifDrawable.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean visible2 = super.setVisible(visible, restart);
        this.gifDrawable.setVisible(visible, restart);
        return visible2;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.gifDrawable.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.gifDrawable.stop();
    }

    public final void a(int loopCount) {
        this.gifDrawable.setLoopCount(loopCount);
    }
}
