package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.utils.PdfUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class mk extends n7 {
    public final boolean n;
    public final ArrayList o;
    public ArrayList p;
    public final Path q;
    public final Path r;
    public final Matrix s;
    public boolean t;

    public mk() {
        this(false, 31);
    }

    @Override // com.pspdfkit.internal.f10
    public final void a(PointF pointF, Matrix matrix, float f) {
        pointF.getClass();
        matrix.getClass();
        this.t = true;
        boolean zIsEmpty = this.p.isEmpty();
        this.p.add(pointF);
        if (zIsEmpty) {
            this.q.moveTo(pointF.x, pointF.y);
            return;
        }
        boolean z = this.n;
        ArrayList arrayList = this.p;
        if (!z) {
            PointF pointF2 = (PointF) arrayList.get(arrayList.size() - 2);
            Path path = this.q;
            float f2 = pointF2.x;
            float f3 = pointF2.y;
            float f4 = 2;
            path.quadTo(f2, f3, (pointF.x + f2) / f4, (pointF.y + f3) / f4);
            return;
        }
        int size = arrayList.size() % 5;
        Path path2 = this.q;
        if (size != 0) {
            path2.lineTo(pointF.x, pointF.y);
        } else {
            path2.reset();
            lk.a(this.q, this.p);
        }
    }

    public final void i() {
        this.q.reset();
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            List list = (List) obj;
            if (list.size() >= 2) {
                boolean z = this.n;
                Path path = this.q;
                if (z) {
                    lk.a(path, (List<? extends PointF>) list);
                } else {
                    path.moveTo(((PointF) list.get(0)).x, ((PointF) list.get(0)).y);
                    int size2 = list.size();
                    for (int i2 = 1; i2 < size2; i2++) {
                        PointF pointF = (PointF) list.get(i2 - 1);
                        PointF pointF2 = (PointF) list.get(i2);
                        Path path2 = this.q;
                        float f = pointF.x;
                        float f2 = pointF.y;
                        float f3 = 2;
                        path2.quadTo(f, f2, (pointF2.x + f) / f3, (pointF2.y + f2) / f3);
                    }
                    if (list.size() > 1) {
                        PointF pointF3 = (PointF) CollectionsKt.last(list);
                        this.q.lineTo(pointF3.x, pointF3.y);
                    }
                }
            }
        }
    }

    public mk(int i, int i2, float f, float f2, boolean z) {
        super(i, i2, f, f2);
        this.n = z;
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        ArrayList arrayList2 = new ArrayList(500);
        arrayList.add(arrayList2);
        this.p = arrayList2;
        this.q = new Path();
        this.r = new Path();
        this.s = new Matrix();
    }

    public /* synthetic */ mk(boolean z, int i) {
        this(0, 0, 1.0f, 1.0f, (i & 16) != 0 ? true : z);
    }

    @Override // com.pspdfkit.internal.n7, com.pspdfkit.internal.f10
    public final void a(int i) {
        if (i != 0) {
            super.a(i);
            if (i == 2 && this.n && this.p.size() >= 2) {
                this.q.reset();
                lk.a(this.q, this.p);
                return;
            }
            return;
        }
        throw null;
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a() {
        return !this.p.isEmpty();
    }

    @Override // com.pspdfkit.internal.n7
    public final void a(Paint paint, Paint paint2, float f) {
        paint.getClass();
        super.a(paint, paint2, f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setPathEffect(null);
    }

    @Override // com.pspdfkit.internal.n7
    public final void a(Canvas canvas, Paint paint, Paint paint2, float f) {
        canvas.getClass();
        paint.getClass();
        if (paint2 != null && this.f != 0) {
            RectF rectFBoundingBoxFromLines = PdfUtils.boundingBoxFromLines(this.o, paint.getStrokeWidth());
            rectFBoundingBoxFromLines.getClass();
            if (f != 1.0f) {
                this.s.setScale(f, f);
                this.s.mapRect(rectFBoundingBoxFromLines);
                float f2 = rectFBoundingBoxFromLines.bottom;
                float f3 = rectFBoundingBoxFromLines.top;
                if (f2 > f3) {
                    rectFBoundingBoxFromLines.top = f2;
                    rectFBoundingBoxFromLines.bottom = f3;
                }
            }
            canvas.drawRect(rectFBoundingBoxFromLines, paint2);
        }
        ArrayList arrayList = this.o;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (((List) obj).size() == 1) {
                arrayList2.add(obj);
            }
        }
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            PointF pointF = (PointF) ((List) obj2).get(0);
            canvas.drawPoint(pointF.x * f, pointF.y * f, paint);
        }
        if (!this.q.isEmpty()) {
            if (f == 1.0f) {
                canvas.drawPath(this.q, paint);
                return;
            }
            this.s.setScale(f, f);
            Path path = this.q;
            Path path2 = this.r;
            Matrix matrix = this.s;
            path2.set(path);
            path2.transform(matrix);
            canvas.drawPath(this.r, paint);
            return;
        }
        ArrayList arrayList3 = this.o;
        int size3 = arrayList3.size();
        while (i < size3) {
            Object obj3 = arrayList3.get(i);
            i++;
            List list = (List) obj3;
            if (list.size() >= 2) {
                this.r.reset();
                PointF pointF2 = (PointF) CollectionsKt.first(list);
                this.r.moveTo(pointF2.x * f, pointF2.y * f);
                for (PointF pointF3 : CollectionsKt.drop(list, 1)) {
                    this.r.lineTo(pointF3.x * f, pointF3.y * f);
                }
                canvas.drawPath(this.r, paint);
            }
        }
    }
}
