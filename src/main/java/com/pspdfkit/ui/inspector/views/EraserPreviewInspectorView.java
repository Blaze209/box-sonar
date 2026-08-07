package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.pspdfkit.annotations.configuration.AnnotationThicknessConfiguration;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.ff;
import com.pspdfkit.internal.lg;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;

/* JADX INFO: loaded from: classes3.dex */
public class EraserPreviewInspectorView extends View implements PropertyInspectorView, OnAnnotatingModeSettingsChangeListener {
    private static final int PADDING_DP = 8;
    private final AnnotatingController annotationCreationController;
    private final Paint eraserCirclePaint;
    private final Path eraserCirclePath;
    private final dx inspectorStyle;
    private final float maxThickness;

    public EraserPreviewInspectorView(Context context, AnnotatingController annotatingController, AnnotationThicknessConfiguration annotationThicknessConfiguration) {
        super(context);
        this.eraserCirclePath = new Path();
        Paint paint = new Paint();
        this.eraserCirclePaint = paint;
        uw.a(annotatingController, "annotationCreationController", null);
        lg lgVar = new lg(context);
        this.annotationCreationController = annotatingController;
        this.inspectorStyle = new dx(context);
        this.maxThickness = annotationThicknessConfiguration.getMaxThickness();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(lgVar.a);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColorFilter(ff.a(annotatingController.getConfiguration().isToGrayscale(), annotatingController.getConfiguration().isInvertColors()));
    }

    private void refreshAnnotationCreationParams() {
        float f = getResources().getDisplayMetrics().density;
        float thickness = this.annotationCreationController.getThickness() * f;
        this.eraserCirclePath.reset();
        this.eraserCirclePath.setFillType(Path.FillType.EVEN_ODD);
        Path path = this.eraserCirclePath;
        Path.Direction direction = Path.Direction.CW;
        path.addCircle(0.0f, 0.0f, thickness, direction);
        this.eraserCirclePath.addCircle(0.0f, 0.0f, thickness - (f * 3.0f), direction);
        invalidate();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
        this.annotationCreationController.addOnSettingsChangeListener(this);
        refreshAnnotationCreationParams();
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
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.drawPath(this.eraserCirclePath, this.eraserCirclePaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), (int) Math.max(this.inspectorStyle.b, ((this.maxThickness * 2.0f) + 8.0f) * getResources().getDisplayMetrics().density));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
        this.annotationCreationController.removeOnSettingsChangeListener(this);
    }
}
