package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public class e00 extends ViewGroup implements z4<FreeTextAnnotation>, nx, oi {
    public final PdfConfiguration a;
    public final li b;
    public final Matrix c;
    public float d;
    public final Rect e;
    public RectF f;
    public final RectF g;
    public final RectF h;
    public final nw i;
    public List<? extends PointF> j;
    public final Paint k;
    public final Paint l;
    public BlendMode m;
    public Paint n;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e00(Context context, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, AnnotationConfigurationRegistry annotationConfigurationRegistry) {
        super(context);
        context.getClass();
        pdfDocument.getClass();
        pdfConfiguration.getClass();
        annotationConfigurationRegistry.getClass();
        this.a = pdfConfiguration;
        this.b = new li(context, pdfDocument, pdfConfiguration, annotationConfigurationRegistry);
        this.c = new Matrix();
        this.d = 1.0f;
        this.e = new Rect();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
        this.i = new nw(-16777216, 0, 1.0f, 1.0f, BorderStylePreset.SOLID);
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < 4; i++) {
            arrayList.add(new PointF());
        }
        this.j = arrayList;
        Paint paint = new Paint();
        this.k = paint;
        Paint paint2 = new Paint();
        this.l = paint2;
        this.m = BlendMode.NORMAL;
        this.n = new Paint();
        this.b.setApplyAnnotationAlpha(false);
        this.b.setDrawBackground(false);
        paint2.setStyle(Paint.Style.FILL);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.z4
    public void b() {
        if (this.b.getCurrentlyChangingText()) {
            return;
        }
        this.b.b();
        j();
    }

    public void c() {
        li liVar = this.b;
        RectF rectF = this.f;
        liVar.layout((int) rectF.left, (int) rectF.top, (int) Math.ceil(rectF.right), (int) Math.ceil(this.f.bottom));
    }

    public void d() {
        this.b.measure(View.MeasureSpec.makeMeasureSpec((int) Math.ceil(this.f.width()), 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.ceil(this.f.height()), 1073741824));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.getClass();
        this.i.a((List<PointF>) this.j);
        nw nwVar = this.i;
        nwVar.u = false;
        nwVar.v = true;
        nwVar.a(2);
        if (true != nwVar.l) {
            nwVar.h();
            nwVar.l = true;
        }
        this.i.a(canvas, this.k, this.l);
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.getClass();
        int iSave = canvas.save();
        try {
            if (this.m != BlendMode.NORMAL && getLocalVisibleRect(this.e)) {
                canvas.saveLayer(null, this.n);
            }
            super.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean e() {
        li liVar = this.b;
        if (liVar.g) {
            return true;
        }
        boolean zE = liVar.e();
        if (zE) {
            requestLayout();
            invalidate();
        }
        return zE;
    }

    @Override // com.pspdfkit.internal.z4
    public final void f() throws InterruptedException {
        li liVar = this.b;
        if (liVar.g) {
            liVar.j();
            i3 i3Var = liVar.q;
            if (i3Var != null) {
                i3Var.c();
            }
            liVar.q = null;
            requestLayout();
            invalidate();
        }
    }

    public final void g() {
        FreeTextAnnotation annotation = getAnnotation();
        if (annotation == null) {
            return;
        }
        if (annotation.getRotation() % 90 == 0) {
            a(annotation);
            FreeTextAnnotation annotation2 = getAnnotation();
            if (annotation2 != null) {
                float borderWidth = (annotation2.getBorderWidth() * this.d) / 2;
                PointF pointF = this.j.get(0);
                RectF rectF = this.f;
                pointF.set(rectF.left + borderWidth, rectF.top + borderWidth);
                PointF pointF2 = this.j.get(1);
                RectF rectF2 = this.f;
                pointF2.set(rectF2.right - borderWidth, rectF2.top + borderWidth);
                PointF pointF3 = this.j.get(2);
                RectF rectF3 = this.f;
                pointF3.set(rectF3.right - borderWidth, rectF3.bottom - borderWidth);
                PointF pointF4 = this.j.get(3);
                RectF rectF4 = this.f;
                pointF4.set(rectF4.left + borderWidth, rectF4.bottom - borderWidth);
                return;
            }
            return;
        }
        RectF contentSize = annotation.getInternal().getContentSize(this.g);
        if (contentSize == null || Math.abs(contentSize.width()) <= 0.0f || Math.abs(contentSize.height()) <= 0.0f) {
            contentSize = annotation.getBoundingBox(this.h);
        } else if (annotation.getInternal().needsFlippedContentSize()) {
            contentSize = new RectF(0.0f, 0.0f, contentSize.height(), contentSize.width());
        }
        contentSize.sort();
        float fWidth = contentSize.width() * this.d;
        float fHeight = contentSize.height() * this.d;
        RectF boundingBox = annotation.getBoundingBox(this.h);
        boundingBox.sort();
        float fWidth2 = ((boundingBox.width() * this.d) - fWidth) / 2.0f;
        float fHeight2 = ((boundingBox.height() * this.d) - fHeight) / 2.0f;
        this.f.set(fWidth2, fHeight2, fWidth + fWidth2, fHeight + fHeight2);
        FreeTextAnnotation annotation3 = getAnnotation();
        if (annotation3 == null) {
            return;
        }
        RectF contentSize2 = annotation3.getInternal().getContentSize(null);
        if (contentSize2 == null) {
            contentSize2 = annotation3.getBoundingBox();
        }
        float borderWidth2 = annotation3.getBorderWidth();
        contentSize2.top -= borderWidth2;
        contentSize2.right -= borderWidth2;
        this.c.mapRect(contentSize2);
        contentSize2.offset((getWidth() / 2) - contentSize2.centerX(), (getHeight() / 2) - contentSize2.centerY());
        List<? extends PointF> listListOf = CollectionsKt.listOf((Object[]) new PointF[]{new PointF(contentSize2.left, contentSize2.top), new PointF(contentSize2.right, contentSize2.top), new PointF(contentSize2.right, contentSize2.bottom), new PointF(contentSize2.left, contentSize2.bottom)});
        PointF pointF5 = new PointF(contentSize2.centerX(), contentSize2.centerY());
        float rotation = annotation3.getRotation();
        listListOf.getClass();
        if (!listListOf.isEmpty()) {
            Matrix matrix = new Matrix();
            matrix.postRotate(rotation, pointF5.x, pointF5.y);
            ArrayList arrayList = new ArrayList(listListOf.size());
            for (PointF pointF6 : listListOf) {
                float[] fArr = {pointF6.x, pointF6.y};
                matrix.mapPoints(fArr);
                arrayList.add(new PointF(fArr[0], fArr[1]));
            }
            listListOf = arrayList;
        }
        this.j = listListOf;
    }

    @Override // com.pspdfkit.internal.z4
    public l1 getContentScaler() {
        return this;
    }

    public final RectF getEditTextRect() {
        return this.f;
    }

    public final li getEditTextView() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ PageRect getPageRect() {
        return super.getPageRect();
    }

    public Paint getPaintForFontScalingCalculation() {
        TextPaint paint = this.b.getPaint();
        paint.getClass();
        return paint;
    }

    public final float getPdfToViewScale() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean i() {
        return this.b.i();
    }

    public final void j() {
        FreeTextAnnotation annotation = getAnnotation();
        if (annotation == null) {
            return;
        }
        float alpha = annotation.getAlpha();
        setAlpha(alpha);
        if (alpha == 1.0f) {
            BlendMode blendMode = annotation.getBlendMode();
            this.m = blendMode;
            Paint paint = this.n;
            EnumSet<AnnotationType> enumSet = b5.a;
            if (paint == null) {
                paint = new Paint();
            } else {
                paint.reset();
            }
            gf.a(paint, blendMode);
            this.n = paint;
        } else {
            this.m = BlendMode.NORMAL;
        }
        int i = 0;
        if (alpha == 1.0f) {
            BlendMode blendMode2 = annotation.getBlendMode();
            EnumSet<AnnotationType> enumSet2 = b5.a;
            int i2 = b5.a.a[blendMode2.ordinal()];
            if (i2 == 1) {
                i = -1;
            } else if (i2 == 2) {
                i = -16777216;
            }
            setBackgroundColor(i);
        } else {
            setBackgroundColor(0);
        }
        this.i.e = ff.a(annotation.getBorderColor(), this.a.isToGrayscale(), this.a.isInvertColors());
        this.i.f = this.b.getAnnotationBackgroundColor();
        nw nwVar = this.i;
        float borderWidth = annotation.getBorderWidth();
        if (nwVar.g != borderWidth) {
            nwVar.g = borderWidth;
            nwVar.e();
        }
        nw nwVar2 = this.i;
        BorderStylePreset borderStylePreset = new BorderStylePreset(annotation.getBorderStyle(), annotation.getBorderEffect(), annotation.getBorderEffectIntensity(), annotation.getBorderDashArray());
        nwVar2.getClass();
        nwVar2.n = borderStylePreset.getBorderStyle();
        nwVar2.p = borderStylePreset.getBorderEffect();
        float borderEffectIntensity = borderStylePreset.getBorderEffectIntensity();
        if (nwVar2.q != borderEffectIntensity) {
            nwVar2.q = borderEffectIntensity;
            nwVar2.e();
        }
        nwVar2.o = borderStylePreset.getDashArray();
        nwVar2.e();
    }

    @Override // com.pspdfkit.internal.z4
    public void n() {
        if (this.b.getCurrentlyChangingText()) {
            return;
        }
        li liVar = this.b;
        liVar.getClass();
        liVar.setLayoutParams(b5.a(liVar, false));
        setLayoutParams(this.b.getLayoutParams());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        g();
        d();
        c();
    }

    @Override // com.pspdfkit.internal.nx
    public void recycle() {
        this.b.recycle();
    }

    public final void setEditTextRect(RectF rectF) {
        rectF.getClass();
        this.f = rectF;
    }

    public final void setPdfToViewScale(float f) {
        this.d = f;
    }

    @Override // com.pspdfkit.internal.z4
    public final void a(final z4.a<FreeTextAnnotation> aVar) {
        this.b.a(new z4.a() { // from class: com.pspdfkit.internal.e00$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.z4.a
            public final void a(z4 z4Var) {
                e00.a(aVar, this, z4Var);
            }
        });
    }

    @Override // com.pspdfkit.internal.z4
    public FreeTextAnnotation getAnnotation() {
        return this.b.getAnnotation();
    }

    @Override // com.pspdfkit.internal.z4
    public void setAnnotation(FreeTextAnnotation freeTextAnnotation) {
        freeTextAnnotation.getClass();
        if (!this.o) {
            this.o = true;
            addView(this.b);
            setWillNotDraw(false);
        }
        this.b.setAnnotation(freeTextAnnotation);
        setLayoutParams(this.b.getLayoutParams());
        j();
    }

    public static final void a(z4.a aVar, e00 e00Var, z4 z4Var) {
        z4Var.getClass();
        aVar.a(e00Var);
    }

    @Override // com.pspdfkit.internal.z4
    public void a(Matrix matrix, float f) {
        matrix.getClass();
        this.c.set(matrix);
        float fA = s60.a(this.c) * 1.0f;
        if (fA == this.d) {
            return;
        }
        this.d = fA;
        this.b.a(this.c, f);
        this.i.a(1.0f, this.c);
        g();
        if (this.b.getCurrentlyChangingText()) {
            return;
        }
        d();
        c();
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean b(boolean z) {
        this.b.getClass();
        return z;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean a(RectF rectF) {
        return !this.b.g;
    }

    public void a(FreeTextAnnotation freeTextAnnotation) {
        Size sizeA = ji.a(freeTextAnnotation, this.h);
        this.f.set(0.0f, 0.0f, (float) Math.rint(sizeA.width * this.d), (float) Math.rint(sizeA.height * this.d));
    }
}
