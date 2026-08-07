package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;

/* JADX INFO: loaded from: classes3.dex */
public class InkAnnotationPreviewInspectorView extends View implements PropertyInspectorView, OnAnnotatingModeSettingsChangeListener {
    private final AnnotatingController annotationCreationController;
    private final RectF boundingBox;
    private final Paint fillPaint;
    private final Paint inkPaint;
    private final dx inspectorStyle;
    private final Path path;
    private final Matrix unscaledPageToViewTransformation;

    public InkAnnotationPreviewInspectorView(Context context, AnnotatingController annotatingController) {
        super(context);
        Paint paint = new Paint();
        this.inkPaint = paint;
        Paint paint2 = new Paint();
        this.fillPaint = paint2;
        this.unscaledPageToViewTransformation = new Matrix();
        this.path = new Path();
        this.boundingBox = new RectF();
        uw.a(annotatingController, "annotationCreationController", null);
        this.annotationCreationController = annotatingController;
        dx dxVar = new dx(context);
        this.inspectorStyle = dxVar;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.FILL);
        setLayoutParams(new ViewGroup.LayoutParams(-2, dxVar.b));
    }

    private void refreshAnnotationCreationParams() {
        this.inkPaint.setColor(this.annotationCreationController.getColor());
        this.inkPaint.setStrokeWidth(s60.a(this.unscaledPageToViewTransformation) * this.annotationCreationController.getThickness());
        this.inkPaint.setAlpha((int) (this.annotationCreationController.getAlpha() * 255.0f));
        this.fillPaint.setColor(this.annotationCreationController.getFillColor());
        if (Color.alpha(this.annotationCreationController.getFillColor()) != 0) {
            this.fillPaint.setAlpha((int) (this.annotationCreationController.getAlpha() * 255.0f));
        }
        int strokeWidth = (int) ((this.inkPaint.getStrokeWidth() / 2.0f) + this.inspectorStyle.e);
        int strokeWidth2 = (int) ((this.inkPaint.getStrokeWidth() / 2.0f) + this.inspectorStyle.f);
        setPadding(strokeWidth, strokeWidth2, strokeWidth, strokeWidth2);
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
        canvas.drawRect(this.boundingBox, this.fillPaint);
        canvas.drawPath(this.path, this.inkPaint);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), this.inspectorStyle.b);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i3 = measuredHeight / 4;
        this.path.reset();
        float f = measuredHeight / 2;
        this.path.moveTo(getPaddingLeft(), f);
        this.path.cubicTo(measuredWidth / 3, measuredHeight + i3, (measuredWidth * 2) / 3, -i3, measuredWidth - getPaddingRight(), f);
        float strokeWidth = this.inkPaint.getStrokeWidth();
        this.boundingBox.set(getPaddingLeft(), i3, measuredWidth - getPaddingRight(), measuredHeight - i3);
        float f2 = (-strokeWidth) / 2.0f;
        this.boundingBox.inset(f2, f2);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.annotationCreationController.removeOnSettingsChangeListener(this);
    }
}
