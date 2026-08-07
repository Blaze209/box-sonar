package com.pspdfkit.annotations;

import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LineAnnotation extends BaseLineAnnotation {
    private boolean isCalibration;

    public LineAnnotation(int i, PointF pointF, PointF pointF2) {
        super(i);
        this.isCalibration = false;
        uw.a(pointF, "point1", null);
        uw.a(pointF2, "point2", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(100, linesFromPairOfPoints(pointF, pointF2), true);
        j3Var.l();
    }

    public static LineAnnotation createCalibrationLineAnnotation(int i, PointF pointF, PointF pointF2) {
        LineAnnotation lineAnnotation = new LineAnnotation(i, pointF, pointF2);
        lineAnnotation.isCalibration = true;
        return lineAnnotation;
    }

    public static List<List<PointF>> linesFromPairOfPoints(PointF pointF, PointF pointF2) {
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(2);
        arrayList2.add(pointF);
        arrayList2.add(pointF2);
        arrayList.add(arrayList2);
        return arrayList;
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public Pair<LineEndType, LineEndType> getLineEnds() {
        return super.getLineEnds();
    }

    public Pair<PointF, PointF> getPoints() {
        List<?> listE = this.propertyManager.e(100);
        if (listE == null || listE.isEmpty()) {
            return new Pair<>(new PointF(), new PointF());
        }
        List list = (List) listE.get(0);
        return list.size() < 2 ? new Pair<>(new PointF(), new PointF()) : new Pair<>(new PointF(((PointF) list.get(0)).x, ((PointF) list.get(0)).y), new PointF(((PointF) list.get(1)).x, ((PointF) list.get(1)).y));
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public List<PointF> getPointsList() {
        Pair<PointF, PointF> points = getPoints();
        return Arrays.asList(points.first, points.second);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.LINE;
    }

    public boolean isCalibration() {
        return this.isCalibration;
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public void setLineEnds(LineEndType lineEndType, LineEndType lineEndType2) {
        super.setLineEnds(lineEndType, lineEndType2);
    }

    public void setPoints(PointF pointF, PointF pointF2) {
        uw.a(pointF, "point1", "Points may not be null.");
        uw.a(pointF2, "point2", "Points may not be null.");
        j3 j3Var = this.propertyManager;
        j3Var.f.a(100, linesFromPairOfPoints(pointF, pointF2), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public LineAnnotation getCopy() {
        LineAnnotation lineAnnotation = new LineAnnotation(this.propertyManager, true);
        lineAnnotation.getInternal().prepareForCopy();
        return lineAnnotation;
    }

    @Override // com.pspdfkit.annotations.BaseLineAnnotation
    public void setPoints(List<PointF> list) {
        uw.a(list, "points", "Points may not be null.");
        if (list.size() < 2) {
            return;
        }
        setPoints(list.get(0), list.get(1));
    }

    public LineAnnotation(int i, PointF pointF, PointF pointF2, Scale scale, MeasurementPrecision measurementPrecision) {
        this(i, pointF, pointF2);
        setMeasurementProperties(scale, measurementPrecision);
        setLineStyle(BorderStyle.SOLID);
        LineEndType lineEndType = LineEndType.BUTT;
        setLineEnds(lineEndType, lineEndType);
    }

    public LineAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
        this.isCalibration = false;
    }
}
