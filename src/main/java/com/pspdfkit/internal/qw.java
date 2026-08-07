package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class qw extends k7 {
    public float A;
    public float B;
    public float C;
    public final Path x;
    public final Path y;
    public Pair<LineEndType, LineEndType> z;

    public static class a {
        public float a = 0.0f;
        public float b = 0.0f;
        public float c = 0.0f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public qw() {
        BorderStylePreset borderStylePreset = BorderStylePreset.SOLID;
        LineEndType lineEndType = LineEndType.NONE;
        this(0, 0, 1.0f, 1.0f, borderStylePreset, Pair.create(lineEndType, lineEndType));
    }

    public final a a(LineEndType lineEndType, PointF pointF, PointF pointF2) {
        a aVar = new a();
        aVar.a = pointF.x;
        aVar.b = pointF.y;
        float f = pointF2.x;
        float f2 = pointF2.y;
        if (lineEndType == LineEndType.NONE) {
            return aVar;
        }
        float f3 = pointF.equals(pointF2) ? 0.0f : this.C + (this.r * 1.75f);
        float f4 = aVar.a;
        if (f4 == f) {
            f += 0.01f;
        }
        if (aVar.b == f2) {
            f2 += 0.01f;
        }
        float fSqrt = (float) Math.sqrt(Math.pow(f2 - aVar.b, 2.0d) + Math.pow(f - f4, 2.0d));
        if (fSqrt <= 0.001f) {
            fSqrt = 0.001f;
        }
        float f5 = f - aVar.a;
        float f6 = f5 / fSqrt;
        float f7 = aVar.b;
        float f8 = (f2 - f7) / fSqrt;
        aVar.c = (float) (3.141592653589793d - Math.atan2(f7 - f2, f5));
        int i = yn.a.a[lineEndType.ordinal()];
        float f9 = pointF.x;
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            aVar.a = f9;
            aVar.b = pointF.y;
            return aVar;
        }
        aVar.a = (f6 * f3) + f9;
        aVar.b = (f8 * f3) + pointF.y;
        return aVar;
    }

    @Override // com.pspdfkit.internal.m8, com.pspdfkit.internal.n7
    public final void e() {
        super.e();
        this.C = (s60.a(this.c) * 12.0f) / this.b;
    }

    public qw(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset, Pair<LineEndType, LineEndType> pair) {
        super(i, i2, f, f2, borderStylePreset);
        this.x = new Path();
        this.y = new Path();
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = 12.0f;
        this.z = pair;
    }

    public final void a(Canvas canvas, Paint paint, Paint paint2, float f, LineEndType lineEndType, PointF pointF, float f2, float f3) {
        if (this.t.size() < 2) {
            return;
        }
        Path pathA = yn.a(lineEndType, this.r, f2);
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postRotate((float) Math.toDegrees(f3));
        matrix.postTranslate(pointF.x * f, pointF.y * f);
        Path path = this.y;
        path.set(pathA);
        path.transform(matrix);
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Cap strokeCap = paint.getStrokeCap();
        paint.setPathEffect(null);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        if (paint2 != null) {
            switch (yn.a.a[lineEndType.ordinal()]) {
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    if (paint2.getColor() != 0) {
                        canvas.drawPath(this.y, paint2);
                    }
                    break;
            }
        }
        canvas.drawPath(this.y, paint);
        paint.setPathEffect(pathEffect);
        paint.setStrokeCap(strokeCap);
    }

    @Override // com.pspdfkit.internal.n7
    public final void a(Canvas canvas, Paint paint, Paint paint2, float f) {
        String str;
        float textSize;
        if (this.t.size() < 2) {
            return;
        }
        PointF pointF = (PointF) this.t.get(0);
        PointF pointF2 = (PointF) this.t.get(1);
        ArrayList arrayList = this.t;
        PointF pointF3 = (PointF) arrayList.get(arrayList.size() - 2);
        ArrayList arrayList2 = this.t;
        PointF pointF4 = (PointF) arrayList2.get(arrayList2.size() - 1);
        a aVarA = a(this.z.first, pointF, pointF2);
        this.A = aVarA.c;
        a aVarA2 = a(this.z.second, pointF4, pointF3);
        this.B = aVarA2.c;
        if (!i()) {
            this.x.reset();
            this.x.moveTo(aVarA.a, aVarA.b);
            Path path = this.x;
            if (pointF2 == pointF4) {
                path.lineTo(aVarA2.a, aVarA2.b);
            } else {
                path.lineTo(pointF2.x, pointF2.y);
            }
            if (this.t.size() > 3) {
                for (int i = 2; i < this.t.size() - 1; i++) {
                    this.x.lineTo(((PointF) this.t.get(i)).x, ((PointF) this.t.get(i)).y);
                }
            }
            if (pointF2 != pointF4) {
                this.x.lineTo(aVarA2.a, aVarA2.b);
            }
        } else {
            ArrayList arrayList3 = new ArrayList(this.t.size());
            arrayList3.add(new PointF(aVarA.a, aVarA.b));
            if (pointF2 == pointF4) {
                arrayList3.add(new PointF(aVarA2.a, aVarA2.b));
            } else {
                arrayList3.add(new PointF(pointF2.x, pointF2.y));
            }
            if (this.t.size() > 3) {
                for (int i2 = 2; i2 < this.t.size() - 1; i2++) {
                    arrayList3.add((PointF) this.t.get(i2));
                }
            }
            if (pointF2 != pointF4) {
                arrayList3.add(new PointF(aVarA2.a, aVarA2.b));
            }
            a9.a(arrayList3, this.s, this.x, false);
        }
        if (f != 1.0f) {
            Matrix matrix = new Matrix();
            matrix.setScale(f, f);
            Path path2 = this.x;
            Path path3 = this.y;
            path3.set(path2);
            path3.transform(matrix);
            canvas.drawPath(this.y, paint);
        } else {
            canvas.drawPath(this.x, paint);
        }
        xp xpVar = this.k;
        if (xpVar != null && this.j != null && (str = this.m) != null) {
            MeasurementMode measurementMode = xpVar.c;
            MeasurementMode measurementMode2 = MeasurementMode.DISTANCE;
            ArrayList arrayList4 = this.t;
            if (measurementMode == measurementMode2) {
                PointF pointF5 = (PointF) arrayList4.get(0);
                PointF pointF6 = (PointF) this.t.get(1);
                double d = this.A;
                if (d < 4.71238898038469d && d > 1.5707963267948966d) {
                    d = d > 3.141592653589793d ? d - 3.141592653589793d : d + 3.141592653589793d;
                }
                double d2 = d;
                double degrees = Math.toDegrees(d2);
                double dA = (s60.a(this.c) / this.b) * (this.g + 14.0f);
                double d3 = d2 - 1.5707963267948966d;
                double dCos = (Math.cos(d3) * dA) + ((double) ((pointF5.x + pointF6.x) / 2.0f));
                double dSin = (Math.sin(d3) * dA) + ((double) ((pointF5.y + pointF6.y) / 2.0f));
                double dAtan2 = Math.atan2(dSin, dCos);
                double dSqrt = Math.sqrt((dSin * dSin) + (dCos * dCos));
                double d4 = dAtan2 - d2;
                float fCos = (float) (Math.cos(d4) * dSqrt);
                float fSin = (float) (Math.sin(d4) * dSqrt);
                canvas.save();
                canvas.rotate((float) degrees);
                if (f != 1.0f) {
                    Matrix matrix2 = new Matrix();
                    matrix2.setScale(f, f);
                    canvas.concat(matrix2);
                }
                canvas.drawText(str, fCos, fSin, this.j);
                canvas.restore();
            } else {
                PointF pointF7 = (PointF) arrayList4.get(arrayList4.size() - 1);
                double d5 = this.B;
                if (d5 > 3.141592653589793d && d5 < 6.283185307179586d) {
                    textSize = -((s60.a(this.c) / this.b) * (this.g + 14.0f));
                } else {
                    textSize = this.j.getTextSize() + ((s60.a(this.c) / this.b) * (this.g + 8.0f));
                }
                float f2 = pointF7.x;
                float f3 = pointF7.y + textSize;
                canvas.save();
                if (f != 1.0f) {
                    Matrix matrix3 = new Matrix();
                    matrix3.setScale(f, f);
                    canvas.concat(matrix3);
                }
                canvas.drawText(str, f2, f3, this.j);
                canvas.restore();
            }
        }
        LineEndType lineEndType = this.z.first;
        LineEndType lineEndType2 = LineEndType.NONE;
        if (lineEndType != lineEndType2) {
            a(canvas, paint, paint2, f, lineEndType, pointF, pointF.equals(pointF2) ? 0.0f : (this.r * 1.75f) + this.C, aVarA.c);
        }
        LineEndType lineEndType3 = this.z.second;
        if (lineEndType3 != lineEndType2) {
            a(canvas, paint, paint2, f, lineEndType3, pointF4, pointF3.equals(pointF4) ? 0.0f : (this.r * 1.75f) + this.C, aVarA2.c);
        }
    }
}
