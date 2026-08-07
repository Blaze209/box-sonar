package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.rendering.AnnotationRenderConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public class vy extends FrameLayout implements z4<Annotation>, nx {
    public static final /* synthetic */ int v = 0;
    public final PdfConfiguration a;
    public final Handler b;
    public final int c;
    public final int d;
    public final Integer e;
    public final Integer f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public Annotation j;
    public Bitmap k;
    public int l;
    public int m;
    public Disposable n;
    public boolean o;
    public final ft<Annotation> p;
    public Matrix q;
    public a r;
    public final b s;
    public boolean t;
    public final PageRect u;

    public interface a {
        void a();
    }

    public static class b extends AppCompatImageView implements nx {
        public Annotation a;
        public final Matrix b;
        public Paint c;
        public final Rect d;
        public final RectF e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            context.getClass();
            this.b = new Matrix();
            this.d = new Rect();
            this.e = new RectF();
            setWillNotDraw(false);
        }

        public final void a() {
            RectF contentSize;
            Drawable drawable = getDrawable();
            Annotation annotation = this.a;
            if (drawable == null || annotation == null || getScaleType() != ImageView.ScaleType.MATRIX || (contentSize = annotation.getInternal().getContentSize(this.e)) == null) {
                return;
            }
            contentSize.sort();
            double radians = Math.toRadians(annotation.getInternal().getRotation());
            double dAbs = Math.abs(Math.sin(radians) * ((double) contentSize.height())) + Math.abs(Math.cos(radians) * ((double) contentSize.width()));
            double dAbs2 = Math.abs(Math.cos(radians) * ((double) contentSize.height())) + Math.abs(Math.sin(radians) * ((double) contentSize.width()));
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            double dMin = Math.min(((double) intrinsicWidth) / dAbs, ((double) intrinsicHeight) / dAbs2);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            float height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            float f = width;
            float fMin = Math.min(height / ((float) (dAbs2 * dMin)), f / ((float) (dAbs * dMin)));
            this.b.setScale(fMin, fMin);
            this.b.postTranslate((float) Math.rint((f - (intrinsicWidth * fMin)) * 0.5f), (float) Math.rint((height - (intrinsicHeight * fMin)) * 0.5f));
            setImageMatrix(this.b);
        }

        @Override // android.view.View
        public final void draw(Canvas canvas) {
            canvas.getClass();
            if (getLocalVisibleRect(this.d)) {
                int iSave = canvas.save();
                try {
                    Paint paint = this.c;
                    if (paint != null) {
                        canvas.saveLayer(null, paint);
                    }
                    Drawable drawable = getDrawable();
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    Bitmap bitmap = bitmapDrawable != null ? bitmapDrawable.getBitmap() : null;
                    if (bitmap == null || !bitmap.isRecycled()) {
                        try {
                            super.draw(canvas);
                        } catch (RuntimeException e) {
                            int i = vy.v;
                            for (Throwable cause = e; cause != null; cause = cause.getCause()) {
                                String message = cause.getMessage();
                                if (message != null && StringsKt.contains((CharSequence) message, (CharSequence) "recycled bitmap", true)) {
                                    setImageBitmap(null);
                                    PdfLog.w("Nutri.RenderedAnnotView", "Skipping draw for recycled annotation bitmap.", new Object[0]);
                                }
                            }
                            throw e;
                        }
                    } else {
                        setImageBitmap(null);
                        PdfLog.w("Nutri.RenderedAnnotView", "Skipping draw for recycled annotation bitmap.", new Object[0]);
                    }
                    canvas.restoreToCount(iSave);
                } catch (Throwable th) {
                    canvas.restoreToCount(iSave);
                    throw th;
                }
            }
        }

        @Override // com.pspdfkit.internal.nx
        public final void recycle() {
            setImageBitmap(null);
            this.a = null;
            this.c = null;
        }

        public final void setAnnotation(Annotation annotation) {
            annotation.getClass();
            Annotation annotation2 = this.a;
            if (annotation2 == null || !Intrinsics.areEqual(annotation2, annotation)) {
                this.a = annotation;
                RectF contentSize = annotation.getInternal().getContentSize(this.e);
                if (contentSize == null || contentSize.isEmpty()) {
                    setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    setScaleType(ImageView.ScaleType.MATRIX);
                    a();
                }
            }
        }

        public final void setBlendMode(BlendMode blendMode) {
            int i;
            blendMode.getClass();
            if (blendMode == BlendMode.NORMAL) {
                this.c = null;
                setBackground(null);
                return;
            }
            Paint paint = this.c;
            EnumSet<AnnotationType> enumSet = b5.a;
            if (paint == null) {
                paint = new Paint();
            } else {
                paint.reset();
            }
            gf.a(paint, blendMode);
            this.c = paint;
            int i2 = b5.a.a[blendMode.ordinal()];
            if (i2 != 1) {
                i = i2 != 2 ? 0 : -16777216;
            } else {
                i = -1;
            }
            setBackgroundColor(i);
        }

        public final void setBlendPaintProperties(PdfConfiguration pdfConfiguration) {
            pdfConfiguration.getClass();
            Paint paint = this.c;
            if (paint == null) {
                paint = new Paint();
                this.c = paint;
            }
            paint.reset();
            gf.a(paint, pdfConfiguration.isInvertColors() ? BlendMode.SCREEN : BlendMode.MULTIPLY);
            if (pdfConfiguration.isToGrayscale()) {
                paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
            }
        }
    }

    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public d(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            bitmap.getClass();
            vy vyVar = vy.this;
            Bitmap bitmap2 = vyVar.k;
            vyVar.n = null;
            vyVar.a(bitmap);
            if (bitmap2 != bitmap) {
                vy.this.b(bitmap2);
            }
            vy.this.p.a();
            if (this.b != bitmap.getWidth() || this.c != bitmap.getHeight()) {
                vy.this.b();
            }
            a aVar = vy.this.r;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Annotation a;
        public final /* synthetic */ vy b;

        public e(Annotation annotation, vy vyVar) {
            this.a = annotation;
            this.b = vyVar;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th) {
            th.getClass();
            PdfLog.e("Nutri.RenderedAnnotView", th, "Could not render annotation: " + this.a, new Object[0]);
            this.b.p.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vy(Context context, PdfConfiguration pdfConfiguration, PdfDocument pdfDocument) {
        int i;
        int i2;
        Integer numValueOf;
        super(context);
        context.getClass();
        pdfConfiguration.getClass();
        pdfDocument.getClass();
        this.a = pdfConfiguration;
        this.b = new Handler(Looper.getMainLooper());
        this.p = new ft<>(this);
        this.u = new PageRect();
        b bVar = new b(context);
        this.s = bVar;
        bVar.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(bVar, new FrameLayout.LayoutParams(-1, -1));
        int i3 = 0;
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar = ca.b;
            if (ciVar == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
            i = ciVar.a;
        } else {
            i = 0;
        }
        this.c = i;
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar2 = ca.b;
            if (ciVar2 == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
            i2 = ciVar2.f;
        } else {
            i2 = 0;
        }
        this.d = i2;
        if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
            ci ciVar3 = ca.b;
            if (ciVar3 == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
            int i4 = ciVar3.b;
            numValueOf = i4 == 0 ? null : Integer.valueOf(i4);
        } else {
            numValueOf = 0;
        }
        this.e = numValueOf;
        if (ar.b().b(pdfConfiguration, pdfDocument)) {
            ci ciVar4 = ca.b;
            if (ciVar4 == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
            }
            i3 = ciVar4.g;
        }
        this.f = Integer.valueOf(i3);
        this.g = pdfConfiguration.isInvertColors();
        this.h = pdfConfiguration.isToGrayscale();
        this.i = pdfConfiguration.getShowSignHereOverlay();
        setBackground(null);
    }

    public static final SingleSource a(Annotation annotation, int i, int i2, AnnotationRenderConfiguration annotationRenderConfiguration) {
        y7 y7Var = q10.c;
        if (y7Var == null) {
            y7Var = new y7();
            q10.c = y7Var;
        }
        Bitmap bitmapA = y7Var.a(i, i2);
        bitmapA.getClass();
        annotationRenderConfiguration.getClass();
        return annotation.renderToBitmapAsync(bitmapA, annotationRenderConfiguration);
    }

    public static final void c(Bitmap bitmap) {
        y7 y7Var = q10.c;
        if (y7Var == null) {
            y7Var = new y7();
            q10.c = y7Var;
        }
        y7Var.c(bitmap);
    }

    @Override // com.pspdfkit.internal.z4
    public View a() {
        return this;
    }

    public void b() {
        this.o = true;
        o();
    }

    @Override // com.pspdfkit.internal.z4
    public Annotation getAnnotation() {
        return this.j;
    }

    public final PdfConfiguration getConfiguration() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ l1 getContentScaler() {
        return super.getContentScaler();
    }

    public final b getImageView() {
        return this.s;
    }

    @Override // com.pspdfkit.internal.z4
    public PageRect getPageRect() {
        if (this.t) {
            return this.u;
        }
        PageRect pageRect = super.getPageRect();
        pageRect.getClass();
        return pageRect;
    }

    public final Bitmap getRenderedAnnotationBitmap() {
        return this.k;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean h() {
        Annotation annotation = getAnnotation();
        if (annotation == null || annotation.get_appearanceStreamGenerator() != null) {
            return true;
        }
        switch (c.a[annotation.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return false;
            default:
                return true;
        }
    }

    @Override // com.pspdfkit.internal.z4
    public void n() {
        if (this.j == null) {
            return;
        }
        if (this.t) {
            this.u.set(b5.a(this, false).pageRect);
            return;
        }
        EnumSet<AnnotationType> enumSet = b5.a;
        a().setLayoutParams(b5.a(this, false));
        this.s.a();
    }

    public final void o() {
        final int iMin;
        final int iMin2;
        g60 g60VarC;
        final Annotation annotation = this.j;
        Matrix matrix = this.q;
        if (annotation == null || !annotation.isAttached() || matrix == null) {
            return;
        }
        RectF boundingBox = annotation.getBoundingBox();
        float fWidth = boundingBox.width();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        this.l = (int) (fArr[0] * fWidth);
        float f = -boundingBox.height();
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        int i = (int) (fArr2[0] * f);
        this.m = i;
        int i2 = this.l;
        if (i2 > i) {
            iMin2 = Math.min(2048, i2);
            iMin = (int) (this.m * (iMin2 / (this.l + 0.0f)));
        } else {
            iMin = Math.min(2048, i);
            iMin2 = (int) (this.l * (iMin / (this.m + 0.0f)));
        }
        if (iMin2 == 0 || iMin == 0) {
            this.p.a();
            return;
        }
        yz.a(this.n);
        final AnnotationRenderConfiguration annotationRenderConfigurationBuild = p().build();
        Single singleDefer = Single.defer(new Supplier() { // from class: com.pspdfkit.internal.vy$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return vy.a(annotation, iMin2, iMin, annotationRenderConfigurationBuild);
            }
        });
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        this.n = singleDefer.delaySubscription(20L, timeUnit, ((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(iMin2, iMin), new e(annotation, this));
        this.o = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.o) {
            o();
        }
        if (z) {
            this.s.a();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!this.o && this.k != null && (Math.abs(i - this.l) > 10 || Math.abs(i2 - this.m) > 10)) {
            this.o = true;
        }
        this.s.a();
    }

    public AnnotationRenderConfiguration.Builder p() {
        AnnotationRenderConfiguration.Builder builderShowSignHereOverlay = new AnnotationRenderConfiguration.Builder().formHighlightColor(Integer.valueOf(this.c)).formItemHighlightColor(this.e).formRequiredFieldBorderColor(Integer.valueOf(this.d)).signHereOverlayBackgroundColor(this.f).toGrayscale(this.h).invertColors(this.g).showSignHereOverlay(this.i);
        builderShowSignHereOverlay.getClass();
        return builderShowSignHereOverlay;
    }

    public void q() {
        Annotation annotation = this.j;
        if (annotation == null) {
            return;
        }
        this.s.setBlendMode(annotation.getBlendMode());
    }

    public void recycle() {
        yz.a(this.n);
        this.n = null;
        Bitmap bitmap = this.k;
        this.k = null;
        this.s.recycle();
        this.j = null;
        this.m = 0;
        this.l = 0;
        this.o = false;
        b(bitmap);
        this.p.b.clear();
    }

    public void setAnnotation(Annotation annotation) {
        annotation.getClass();
        Annotation annotation2 = this.j;
        if (annotation2 == null || !Intrinsics.areEqual(annotation2, annotation)) {
            this.j = annotation;
            this.o = true;
            setLayoutParams(new OverlayLayoutParams(annotation.getBoundingBox(), OverlayLayoutParams.SizingMode.LAYOUT));
            setLayoutParams(b5.a(this, false));
            this.s.setAnnotation(annotation);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.s.setImageBitmap(bitmap);
    }

    public final void setOnRenderedListener(a aVar) {
        this.r = aVar;
    }

    public final void setRefreshBoundingBoxAfterRendering(boolean z) {
        this.t = z;
        this.u.set(b5.a(this, false).pageRect);
    }

    public final void b(final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.pspdfkit.internal.vy$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                vy.c(bitmap);
            }
        });
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.internal.z4
    public final void a(z4.a<Annotation> aVar) {
        this.p.b.a((z4.a<T>) aVar);
        Disposable disposable = this.n;
        if (this.o) {
            return;
        }
        if (disposable == null || disposable.isDisposed()) {
            this.p.a();
        }
    }

    @Override // com.pspdfkit.internal.z4
    public final void a(Matrix matrix, float f) {
        matrix.getClass();
        Matrix matrix2 = this.q;
        if (matrix2 == null) {
            matrix2 = new Matrix();
            this.q = matrix2;
        }
        matrix2.set(matrix);
        if (this.o) {
            o();
        } else {
            this.s.invalidate();
        }
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean a(RectF rectF) {
        Annotation annotation = this.j;
        return (annotation == null || TextUtils.isEmpty(annotation.getContents())) ? false : true;
    }

    public void a(Bitmap bitmap) {
        bitmap.getClass();
        this.k = bitmap;
        setImageBitmap(bitmap);
        this.s.a();
        q();
        if (this.t) {
            EnumSet<AnnotationType> enumSet = b5.a;
            a().setLayoutParams(b5.a(this, false));
            this.s.a();
        }
    }
}
