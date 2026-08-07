package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.internal.k7;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class j7<ShapeDelegate extends k7> extends l8<ShapeDelegate> {
    public int c;

    public j7(ShapeDelegate shapedelegate) {
        super(shapedelegate);
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.f10
    public final void a(PointF pointF, Matrix matrix, float f) {
        this.c = 0;
        pointF.getClass();
        matrix.getClass();
        this.a.a(pointF, matrix, f);
    }

    @Override // com.pspdfkit.internal.l8, com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        boolean zA = super.a(annotation, matrix, f, z);
        List<PointF> listE = ww.e(annotation);
        int iHashCode = listE.hashCode();
        boolean z2 = false;
        if (this.c != iHashCode) {
            this.c = iHashCode;
            Matrix matrix2 = new Matrix(matrix);
            float f2 = 1.0f / f;
            matrix2.postScale(f2, f2);
            ArrayList arrayList = new ArrayList(listE.size());
            for (PointF pointF : listE) {
                PointF pointF2 = new PointF();
                pointF2.set(pointF);
                s60.a(pointF2, matrix2);
                arrayList.add(pointF2);
            }
            ArrayList arrayList2 = ((k7) this.a).t;
            if (arrayList2.size() < 2 || !arrayList.equals(arrayList2)) {
                ((k7) this.a).a(arrayList);
                if (z) {
                    k7 k7Var = (k7) this.a;
                    k7Var.u = false;
                    k7Var.v = true;
                    k7Var.a(2);
                    if (true != k7Var.l) {
                        k7Var.h();
                        k7Var.l = true;
                    }
                }
                z2 = true;
            }
        }
        return zA | z2;
    }

    public final ArrayList a(Matrix matrix, float f) {
        ArrayList arrayList = new ArrayList(((k7) this.a).t.size());
        ArrayList arrayList2 = ((k7) this.a).t;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            PointF pointF = (PointF) obj;
            PointF pointF2 = new PointF();
            pointF2.set(pointF.x * f, pointF.y * f);
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            s60.a(pointF2, matrix2);
            arrayList.add(pointF2);
        }
        return arrayList;
    }

    public boolean a(int i, int i2, float f, BorderStyle borderStyle, BorderEffect borderEffect, float f2, List<Integer> list, float f3, Pair<LineEndType, LineEndType> pair) {
        k7 k7Var = (k7) this.a;
        if (k7Var.e != i || k7Var.f != i2 || k7Var.g != f || k7Var.n != borderStyle || k7Var.p != borderEffect || k7Var.q != f2 || !Objects.equals(k7Var.o, list)) {
            return false;
        }
        k7 k7Var2 = (k7) this.a;
        return k7Var2.h == f3 || k7Var2.i == f3;
    }
}
