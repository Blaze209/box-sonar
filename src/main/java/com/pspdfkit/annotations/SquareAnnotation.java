package com.pspdfkit.annotations;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.qp;
import com.pspdfkit.internal.rp;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.xp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SquareAnnotation extends ShapeAnnotation {
    public SquareAnnotation(int i, RectF rectF) {
        super(i);
        uw.a(rectF, "rect", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public rp getMeasurementLabelValue(xp xpVar) {
        RectF boundingBox = getBoundingBox();
        return qp.a(xpVar, (List<? extends PointF>) Arrays.asList(new PointF(boundingBox.left, boundingBox.top), new PointF(boundingBox.right, boundingBox.top), new PointF(boundingBox.right, boundingBox.bottom), new PointF(boundingBox.left, boundingBox.bottom)));
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.SQUARE;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public SquareAnnotation getCopy() {
        SquareAnnotation squareAnnotation = new SquareAnnotation(this.propertyManager, true);
        squareAnnotation.getInternal().prepareForCopy();
        return squareAnnotation;
    }

    public SquareAnnotation(int i, RectF rectF, Scale scale, MeasurementPrecision measurementPrecision) {
        this(i, rectF);
        setMeasurementProperties(scale, measurementPrecision);
    }

    public SquareAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
