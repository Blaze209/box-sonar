package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.internal.a30;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.m8;
import com.pspdfkit.internal.nw;
import com.pspdfkit.internal.qw;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.zn;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeAnnotationPreviewInspectorView extends View implements PropertyInspectorView, OnAnnotatingModeSettingsChangeListener {
    protected final AnnotatingController annotationCreationController;
    private final AnnotationType annotationType;
    private final m8 drawnShape;
    private final Paint fillPaint;
    private final dx inspectorStyle;
    private final Paint paint;
    private final Matrix unscaledPageToViewTransformation;

    /* JADX INFO: renamed from: com.pspdfkit.ui.inspector.views.ShapeAnnotationPreviewInspectorView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$annotations$AnnotationType;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            $SwitchMap$com$pspdfkit$annotations$AnnotationType = iArr;
            try {
                iArr[AnnotationType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.POLYGON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pspdfkit$annotations$AnnotationType[AnnotationType.POLYLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ShapeAnnotationPreviewInspectorView(Context context, AnnotationType annotationType, AnnotatingController annotatingController) {
        super(context);
        this.unscaledPageToViewTransformation = new Matrix();
        uw.a(annotationType, "annotationType", null);
        uw.a(annotatingController, "annotationCreationController", null);
        this.annotationCreationController = annotatingController;
        dx dxVar = new dx(context);
        this.inspectorStyle = dxVar;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        this.paint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.FILL);
        this.fillPaint = paint2;
        this.annotationType = annotationType;
        if (annotationType == AnnotationType.LINE) {
            this.drawnShape = new zn();
        } else {
            AnnotationType annotationType2 = AnnotationType.CIRCLE;
            if (annotationType == annotationType2 || annotationType == AnnotationType.SQUARE) {
                this.drawnShape = new a30(annotationType == annotationType2 ? 2 : 1);
            } else if (annotationType == AnnotationType.POLYGON) {
                this.drawnShape = new nw();
            } else {
                if (annotationType != AnnotationType.POLYLINE) {
                    throw new IllegalArgumentException("Unsupported annotation type for preview: " + annotationType);
                }
                this.drawnShape = new qw();
            }
        }
        setLayoutParams(new ViewGroup.LayoutParams(-2, dxVar.b));
    }

    private void refreshAnnotationCreationParams() {
        this.drawnShape.e = this.annotationCreationController.getColor();
        m8 m8Var = this.drawnShape;
        float thickness = this.annotationCreationController.getThickness();
        if (m8Var.g != thickness) {
            m8Var.g = thickness;
            m8Var.e();
        }
        m8 m8Var2 = this.drawnShape;
        BorderStylePreset borderStylePreset = this.annotationCreationController.getBorderStylePreset();
        m8Var2.getClass();
        m8Var2.n = borderStylePreset.getBorderStyle();
        m8Var2.p = borderStylePreset.getBorderEffect();
        float borderEffectIntensity = borderStylePreset.getBorderEffectIntensity();
        if (m8Var2.q != borderEffectIntensity) {
            m8Var2.q = borderEffectIntensity;
            m8Var2.e();
        }
        m8Var2.o = borderStylePreset.getDashArray();
        m8Var2.e();
        this.drawnShape.f = this.annotationCreationController.getFillColor();
        this.drawnShape.a(this.annotationCreationController.getAlpha(), this.annotationCreationController.getAlpha());
        AnnotationType annotationType = this.annotationType;
        if (annotationType == AnnotationType.LINE || annotationType == AnnotationType.POLYLINE) {
            ((qw) this.drawnShape).z = this.annotationCreationController.getLineEnds();
        }
        float fA = s60.a(this.unscaledPageToViewTransformation) * this.annotationCreationController.getThickness();
        dx dxVar = this.inspectorStyle;
        float f = fA / 2.0f;
        int i = (int) (dxVar.e + f);
        int i2 = (int) (dxVar.f + f);
        setPadding(i, i2, i, i2);
        this.drawnShape.a(1.0f, this.unscaledPageToViewTransformation);
        invalidate();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        ex.a(this.annotationCreationController.getFragment(), this.unscaledPageToViewTransformation);
        refreshAnnotationCreationParams();
        this.annotationCreationController.addOnSettingsChangeListener(this);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return 0;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return 0;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public void onAnnotatingModeSettingsChange(AnnotatingController annotatingController) {
        refreshAnnotationCreationParams();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.drawnShape.b(canvas, this.paint, this.fillPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), this.inspectorStyle.b);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = AnonymousClass1.$SwitchMap$com$pspdfkit$annotations$AnnotationType[this.annotationType.ordinal()];
        if (i3 == 1) {
            zn znVar = (zn) this.drawnShape;
            float paddingLeft = getPaddingLeft();
            float f = measuredHeight / 2;
            float paddingRight = measuredWidth - getPaddingRight();
            znVar.getClass();
            znVar.a(Arrays.asList(new PointF(paddingLeft, f), new PointF(paddingRight, f)));
            return;
        }
        if (i3 == 2 || i3 == 3) {
            a30 a30Var = (a30) this.drawnShape;
            a30Var.t.set(getPaddingLeft(), measuredHeight / 4, measuredWidth - getPaddingRight(), measuredHeight * 2);
            a30Var.t.sort();
            a30Var.B = true;
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return;
            }
            qw qwVar = (qw) this.drawnShape;
            float f2 = measuredHeight / 2;
            PointF[] pointFArr = {new PointF(getPaddingLeft(), f2), new PointF(measuredWidth / 3, (measuredHeight * 4) / 5), new PointF((measuredWidth * 2) / 3, measuredHeight / 5), new PointF(measuredWidth - getPaddingRight(), f2)};
            qwVar.getClass();
            qwVar.a(Arrays.asList(pointFArr));
            return;
        }
        nw nwVar = (nw) this.drawnShape;
        float f3 = measuredHeight * 1.5f;
        int i4 = measuredWidth / 6;
        float f4 = measuredHeight / 4;
        PointF[] pointFArr2 = {new PointF(getPaddingLeft(), f3), new PointF(getPaddingLeft() + i4, f4), new PointF((measuredWidth - getPaddingRight()) - i4, f4), new PointF(measuredWidth - getPaddingRight(), f3)};
        nwVar.getClass();
        nwVar.a(Arrays.asList(pointFArr2));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.annotationCreationController.removeOnSettingsChangeListener(this);
    }
}
