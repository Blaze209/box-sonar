package com.pspdfkit.annotations;

import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.uw;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PolylineAnnotation extends BaseLineAnnotation {
    public PolylineAnnotation(int i, List<PointF> list) {
        super(i);
        uw.a(list, "points", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(103, list, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public Pair<LineEndType, LineEndType> getLineEnds() {
        return super.getLineEnds();
    }

    public List<PointF> getPoints() {
        return getPointsList();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.POLYLINE;
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public void setLineEnds(LineEndType lineEndType, LineEndType lineEndType2) {
        super.setLineEnds(lineEndType, lineEndType2);
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public void setPoints(List<PointF> list) {
        super.setPoints(list);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public PolylineAnnotation getCopy() {
        PolylineAnnotation polylineAnnotation = new PolylineAnnotation(this.propertyManager, true);
        polylineAnnotation.getInternal().prepareForCopy();
        return polylineAnnotation;
    }

    public PolylineAnnotation(int i, List<PointF> list, Scale scale, MeasurementPrecision measurementPrecision) {
        this(i, list);
        setMeasurementProperties(scale, measurementPrecision);
        setLineStyle(BorderStyle.SOLID);
        setLineEnds(LineEndType.BUTT, LineEndType.OPEN_ARROW);
    }

    public PolylineAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
