package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.configuration.FreeTextAnnotationConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.ScaleMode;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ki extends d3 implements OnAnnotatingModeSettingsChangeListener {
    public final AnnotationTool c;
    public final GestureDetector d;
    public a e;
    public FreeTextAnnotation f;
    public Point g;
    public final AnnotationToolVariant h;
    public boolean i;

    public class a implements InternalDocumentListener {
        public a() {
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public final void onPageChanged(PdfDocument pdfDocument, int i) {
            m40 state;
            au auVarL = ki.this.l();
            if (auVarL == null || (state = auVarL.getState()) == null || i == state.b || auVarL.getLocalVisibleRect(new Rect())) {
                return;
            }
            ki kiVar = ki.this;
            if (kiVar.f == null) {
                return;
            }
            au auVarL2 = kiVar.l();
            if (auVarL2 != null) {
                vt pageEditor = auVarL2.getPageEditor();
                pageEditor.getClass();
                vt.a(pageEditor, false, false, 12);
            }
            kiVar.f = null;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            ki.this.g = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ki kiVar = ki.this;
            if (kiVar.g != null) {
                Context context = kiVar.a.a;
                context.getClass();
                Point point = ki.this.g;
                if (!a80.a(context, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    ArrayList arrayList = ki.this.a.o;
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            ki.this.a(motionEvent.getX(), motionEvent.getY());
                            return true;
                        }
                        Object obj = arrayList.get(i);
                        i++;
                        d3 d3Var = (d3) obj;
                        if (d3Var instanceof ki) {
                            ki kiVar2 = (ki) d3Var;
                            boolean z = d3Var == ki.this;
                            if (kiVar2.f != null) {
                                au auVarL = kiVar2.l();
                                if (auVarL != null) {
                                    vt pageEditor = auVarL.getPageEditor();
                                    pageEditor.getClass();
                                    vt.a(pageEditor, false, z, 12);
                                }
                                kiVar2.f = null;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public ki(q0 q0Var, AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        this.f = null;
        this.i = false;
        this.h = annotationToolVariant;
        this.c = annotationTool;
        this.d = new GestureDetector(q0Var.a, new b());
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.a(this);
        this.a.a(this);
        a aVar = new a();
        this.e = aVar;
        this.a.f.addDocumentListener(aVar);
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        a aVar = this.e;
        if (aVar == null) {
            return false;
        }
        this.a.f.removeDocumentListener(aVar);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        a aVar = this.e;
        if (aVar != null) {
            this.a.f.removeDocumentListener(aVar);
        }
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean e() {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return this.c == AnnotationTool.FREETEXT_CALLOUT ? 6 : 5;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        a aVar = this.e;
        if (aVar != null) {
            this.a.f.removeDocumentListener(aVar);
        }
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.h;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public final void onAnnotatingModeSettingsChange(AnnotatingController annotatingController) {
        au auVarL;
        if (this.f == null || (auVarL = l()) == null) {
            return;
        }
        this.f.setColor(annotatingController.getColor());
        this.f.setTextSize(annotatingController.getTextSize());
        this.f.setFillColor(annotatingController.getFillColor());
        this.f.setAlpha(annotatingController.getAlpha());
        vt pageEditor = auVarL.getPageEditor();
        Iterator<T> it = pageEditor.d().iterator();
        while (it.hasNext()) {
            z4 z4Var = (z4) it.next();
            ViewGroup.LayoutParams layoutParams = z4Var.a().getLayoutParams();
            layoutParams.getClass();
            OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
            Annotation annotation = z4Var.getAnnotation();
            if (annotation != null) {
                boolean zAreEqual = Intrinsics.areEqual(overlayLayoutParams.pageRect.getPageRect(), annotation.getBoundingBox());
                boolean z = pageEditor.v;
                if (zAreEqual) {
                    if (!z) {
                        z4Var.n();
                    }
                    z4Var.b();
                } else {
                    if (!z) {
                        z4Var.n();
                    }
                    pageEditor.k.b();
                    z4Var.b();
                }
            }
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3) {
            this.g = null;
            this.i = false;
            return false;
        }
        au auVarL = l();
        boolean z = !(this.f == null || auVarL == null || !auVarL.getPageEditor().a(motionEvent)) || this.d.onTouchEvent(motionEvent);
        if (actionMasked == 0) {
            this.i = z;
        }
        if (!this.i) {
            return z;
        }
        if (actionMasked == 1) {
            this.i = false;
        }
        return true;
    }

    public final void a(float f, float f2) {
        au auVarL;
        m40 state;
        DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController;
        if (j() == null || (auVarL = l()) == null || (state = auVarL.getState()) == null) {
            return;
        }
        Matrix matrixA = auVarL.a((Matrix) null);
        q0.a aVar = this.a.p;
        float fMax = Math.max((ji.a(aVar.e) * 2) + aVar.f, s60.a(a80.a(auVarL.getContext(), 80) * state.f, matrixA));
        PointF pointF = new PointF(f, f2);
        Matrix matrix = new Matrix();
        matrixA.invert(matrix);
        s60.a(pointF, matrix);
        float f3 = pointF.x;
        float f4 = pointF.y;
        RectF rectF = new RectF(f3, f4, f3 + fMax, f4 - fMax);
        Size pageSize = j().getPageSize(state.b);
        ff.a(rectF, new RectF(0.0f, pageSize.height, pageSize.width, 0.0f));
        DocumentView parentView = auVarL.getParentView();
        int i = state.b;
        ln lnVar = parentView.C;
        if (lnVar != null) {
            lnVar.a(rectF, i, 200L, false);
        }
        FreeTextAnnotation freeTextAnnotation = new FreeTextAnnotation(state.b, rectF, "");
        this.f = freeTextAnnotation;
        q0 q0Var = this.a;
        q0Var.getClass();
        ww.a(q0Var.g, freeTextAnnotation);
        freeTextAnnotation.getInternal().setVariant(q0Var.t);
        this.f.setColor(this.a.p.b);
        this.f.setTextSize(this.a.p.f);
        this.f.setFillColor(this.a.p.c);
        this.f.setAlpha(this.a.p.i);
        BorderStylePreset borderStylePreset = this.a.p.g;
        this.f.setBorderStyle(borderStylePreset.getBorderStyle());
        this.f.setBorderEffect(borderStylePreset.getBorderEffect());
        this.f.setBorderEffectIntensity(borderStylePreset.getBorderEffectIntensity());
        this.f.setBorderDashArray(borderStylePreset.getDashArray());
        boolean zHasBorder = borderStylePreset.hasBorder();
        FreeTextAnnotation freeTextAnnotation2 = this.f;
        if (zHasBorder) {
            freeTextAnnotation2.setBorderWidth(this.a.p.e);
        } else {
            freeTextAnnotation2.setBorderWidth(1.0f);
        }
        this.f.setFontName(this.a.p.a.getName());
        if (this.c == AnnotationTool.FREETEXT_CALLOUT) {
            Point point = new Point(-50, -40);
            this.f.setIntent(FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT);
            this.f.setLineEnd(this.a.p.h.first);
            FreeTextAnnotation freeTextAnnotation3 = this.f;
            ScaleMode scaleMode = ScaleMode.SCALE;
            ji.a(freeTextAnnotation3, pageSize, scaleMode, scaleMode, null, null);
            RectF boundingBox = this.f.getBoundingBox(rectF);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PointF(Math.max(0.0f, boundingBox.left + point.x), Math.max(0.0f, boundingBox.centerY() + point.y)));
            arrayList.add(new PointF());
            arrayList.add(new PointF());
            this.f.setCallOutPoints(arrayList);
            FreeTextAnnotation freeTextAnnotation4 = this.f;
            freeTextAnnotation4.getClass();
            ji.a(freeTextAnnotation4, false);
        } else {
            FreeTextAnnotationConfiguration freeTextAnnotationConfiguration = (FreeTextAnnotationConfiguration) this.a.f.getAnnotationConfiguration().get(this.c, this.h, FreeTextAnnotationConfiguration.class);
            this.f.setRotation(0);
            if (freeTextAnnotationConfiguration != null) {
                if (freeTextAnnotationConfiguration.isHorizontalResizingEnabled()) {
                    FreeTextAnnotation freeTextAnnotation5 = this.f;
                    ScaleMode scaleMode2 = ScaleMode.SCALE;
                    ji.a(freeTextAnnotation5, pageSize, scaleMode2, scaleMode2, null, null);
                } else if (freeTextAnnotationConfiguration.isVerticalResizingEnabled()) {
                    ji.a(this.f, pageSize, ScaleMode.FIXED, ScaleMode.SCALE, null, null);
                }
            }
        }
        q0 q0Var2 = this.a;
        AnnotationInspectorController annotationInspectorController = q0Var2.v;
        final boolean z = true;
        if ((annotationInspectorController == null || !annotationInspectorController.isAnnotationInspectorVisible()) && ((defaultAnnotationEditingInspectorController = q0Var2.w) == null || !defaultAnnotationEditingInspectorController.isAnnotationInspectorVisible())) {
            z = false;
        }
        this.a.f.addAnnotationToPage(this.f, false, new Runnable() { // from class: com.pspdfkit.internal.ki$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z);
            }
        });
    }

    public final void a(boolean z) {
        au auVarL = l();
        if (auVarL != null) {
            if (z) {
                q0 q0Var = this.a;
                AnnotationInspectorController annotationInspectorController = q0Var.v;
                if (annotationInspectorController != null) {
                    annotationInspectorController.hideAnnotationInspector(true);
                }
                DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController = q0Var.w;
                if (defaultAnnotationEditingInspectorController != null) {
                    defaultAnnotationEditingInspectorController.hideAnnotationInspector(true);
                }
            }
            auVarL.getPageEditor().a(true, (Collection<? extends Annotation>) Collections.singletonList(this.f));
            q0 q0Var2 = this.a;
            if (q0Var2.s == this.c) {
                AnnotationTool annotationTool = AnnotationTool.NONE;
                AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                annotationTool.getClass();
                annotationToolVariantDefaultVariant.getClass();
                q0Var2.b.enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
            }
        }
    }
}
