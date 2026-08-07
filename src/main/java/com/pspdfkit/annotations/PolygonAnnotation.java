package com.pspdfkit.annotations;

import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.uw;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PolygonAnnotation extends BaseLineAnnotation {
    public PolygonAnnotation(int i, List<PointF> list) {
        super(i);
        uw.a(list, "points", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(103, list, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public BorderStyle getBorderStyle() {
        BorderStyle borderStyle = super.getBorderStyle();
        return borderStyle == BorderStyle.NONE ? BorderStyle.SOLID : borderStyle;
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public Pair<LineEndType, LineEndType> getLineEnds() {
        LineEndType lineEndType = LineEndType.NONE;
        return Pair.create(lineEndType, lineEndType);
    }

    public List<PointF> getPoints() {
        return getPointsList();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.POLYGON;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setBorderStyle(BorderStyle borderStyle) {
        if (borderStyle == BorderStyle.NONE) {
            super.setBorderStyle(BorderStyle.SOLID);
        } else {
            super.setBorderStyle(borderStyle);
        }
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public void setPoints(List<PointF> list) {
        super.setPoints(list);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public PolygonAnnotation getCopy() {
        PolygonAnnotation polygonAnnotation = new PolygonAnnotation(this.propertyManager, true);
        polygonAnnotation.getInternal().prepareForCopy();
        return polygonAnnotation;
    }

    public PolygonAnnotation(int i, List<PointF> list, Scale scale, MeasurementPrecision measurementPrecision) {
        this(i, list);
        setMeasurementProperties(scale, measurementPrecision);
        setLineStyle(BorderStyle.SOLID);
    }

    public PolygonAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
