package sdk.pendo.io.c8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.b.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.s7.d;
import sdk.pendo.io.s7.s0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010H\u001a\u00020\u001c\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010K\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\bL\u0010MJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0010R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0010R\u0016\u0010/\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010&R\u0014\u00103\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010&R\u0014\u00105\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010&R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010E\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010@¨\u0006N"}, d2 = {"Lsdk/pendo/io/c8/a;", "Landroid/graphics/drawable/BitmapDrawable;", "", "bitmapWidth", "bitmapHeight", "viewWidth", "viewHeight", "", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "invalidateSelf", "Landroid/graphics/Canvas;", "canvas", "draw", "getIntrinsicHeight", "getIntrinsicWidth", "I", "mBorderColor", "mBorderWidth", "", "c", "F", "mCornerRadius", "Lsdk/pendo/io/b/f$a;", "d", "Lsdk/pendo/io/b/f$a;", "mTile", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "e", "Ljava/lang/ref/WeakReference;", "mViewWeakReference", "Landroid/graphics/Matrix;", "f", "Landroid/graphics/Matrix;", "mDrawMatrix", "", "g", "Z", "mIsValid", CmcdData.STREAMING_FORMAT_HLS, "lastViewWidth", "i", "lastViewHeight", "Landroid/graphics/Shader$TileMode;", "j", "Landroid/graphics/Shader$TileMode;", "mTileMode", "k", "hasBackground", CmcdData.STREAM_TYPE_LIVE, "hasBorder", CmcdData.OBJECT_TYPE_MANIFEST, "hasRoundedCorners", "Landroid/graphics/Path;", "n", "Landroid/graphics/Path;", "clipPath", "Landroid/graphics/RectF;", "o", "Landroid/graphics/RectF;", "drawRect", "Landroid/graphics/Paint;", "p", "Landroid/graphics/Paint;", "backgroundPaint", "q", "bitmapPaint", "r", "borderPaint", "Landroid/graphics/Bitmap;", "bitmap", "view", "", "tile", "backgroundColor", "<init>", "(Landroid/graphics/Bitmap;Landroid/view/View;Ljava/lang/String;IIIF)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends BitmapDrawable {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final int mBorderColor;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final int mBorderWidth;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final float mCornerRadius;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final f.a mTile;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final WeakReference<View> mViewWeakReference;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Matrix mDrawMatrix;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private boolean mIsValid;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private int lastViewWidth;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private int lastViewHeight;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Shader.TileMode mTileMode;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final boolean hasBackground;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final boolean hasBorder;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final boolean hasRoundedCorners;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Path clipPath;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final RectF drawRect;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Paint backgroundPaint;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Paint bitmapPaint;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final Paint borderPaint;

    /* JADX INFO: renamed from: sdk.pendo.io.c8.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class C0367a {
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
            try {
                iArr[f.a.SCALE_TO_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Bitmap bitmap, View view, String tile, int i, int i2, int i3, float f) {
        super(s0.c(), bitmap);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tile, "tile");
        this.mBorderColor = i2;
        this.mBorderWidth = i3;
        this.mCornerRadius = f;
        f.a aVarB = f.a.b(tile);
        this.mTile = aVarB;
        this.mViewWeakReference = new WeakReference<>(view);
        this.mDrawMatrix = new Matrix();
        this.hasBackground = i != 0;
        this.hasBorder = i3 > 0;
        this.hasRoundedCorners = f > 0.0f;
        this.clipPath = new Path();
        this.drawRect = new RectF();
        Paint paint = new Paint(1);
        paint.setColor(i);
        this.backgroundPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setAlpha(255);
        this.bitmapPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(i2);
        paint3.setStrokeWidth(i3);
        this.borderPaint = paint3;
        if (aVarB != null) {
            Shader.TileMode tileModeB = aVarB.b();
            this.mTileMode = tileModeB;
            if (tileModeB != null) {
                setTileModeXY(tileModeB, tileModeB);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "wrong tile given: " + tile);
            d.a(g.b.ERROR_REASON_CONFIGURATION, jSONObject);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
        throw new IllegalArgumentException("Given bad tile: " + tile);
    }

    private final void a(int bitmapWidth, int bitmapHeight, int viewWidth, int viewHeight) {
        float f;
        float f2;
        f.a aVar = this.mTile;
        int i = aVar == null ? -1 : C0367a.a[aVar.ordinal()];
        float f3 = 0.0f;
        if (i != 1) {
            if (i == 2) {
                this.mDrawMatrix.setRectToRect(new RectF(0.0f, 0.0f, bitmapWidth, bitmapHeight), new RectF(0.0f, 0.0f, viewWidth, viewHeight), Matrix.ScaleToFit.CENTER);
                return;
            } else {
                if (i != 3) {
                    return;
                }
                this.mDrawMatrix.setRectToRect(new RectF(0.0f, 0.0f, bitmapWidth, bitmapHeight), new RectF(0.0f, 0.0f, viewWidth, viewHeight), Matrix.ScaleToFit.FILL);
                return;
            }
        }
        if (bitmapWidth * viewHeight > viewWidth * bitmapHeight) {
            f2 = viewHeight / bitmapHeight;
            float f4 = (viewWidth - (bitmapWidth * f2)) * 0.5f;
            f = 0.0f;
            f3 = f4;
        } else {
            float f5 = viewWidth / bitmapWidth;
            f = (viewHeight - (bitmapHeight * f5)) * 0.5f;
            f2 = f5;
        }
        this.mDrawMatrix.setScale(f2, f2);
        this.mDrawMatrix.postTranslate(Math.round(f3), Math.round(f));
    }

    private final void b(int bitmapWidth, int bitmapHeight, int viewWidth, int viewHeight) {
        float f = this.mBorderWidth / 2.0f;
        this.drawRect.set(f, f, viewWidth - f, viewHeight - f);
        this.clipPath.reset();
        Path path = this.clipPath;
        RectF rectF = this.drawRect;
        float f2 = this.mCornerRadius;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        a(bitmapWidth, bitmapHeight, viewWidth, viewHeight);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Bitmap bitmap = getBitmap();
        View view = this.mViewWeakReference.get();
        if (this.mTileMode != null) {
            super.draw(canvas);
            return;
        }
        if (bitmap == null || view == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = view.getWidth();
        int height2 = view.getHeight();
        if (!this.mIsValid || width2 != this.lastViewWidth || height2 != this.lastViewHeight) {
            b(width, height, width2, height2);
            this.lastViewWidth = width2;
            this.lastViewHeight = height2;
            this.mIsValid = true;
        }
        int iSave = canvas.save();
        try {
            if (this.hasRoundedCorners) {
                canvas.clipPath(this.clipPath);
            }
            if (this.hasBackground) {
                RectF rectF = this.drawRect;
                float f = this.mCornerRadius;
                canvas.drawRoundRect(rectF, f, f, this.backgroundPaint);
            }
            canvas.drawBitmap(bitmap, this.mDrawMatrix, this.bitmapPaint);
            canvas.restoreToCount(iSave);
            if (this.hasBorder) {
                RectF rectF2 = this.drawRect;
                float f2 = this.mCornerRadius;
                canvas.drawRoundRect(rectF2, f2, f2, this.borderPaint);
            }
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.mIsValid = false;
    }
}
