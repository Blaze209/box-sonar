package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k7 extends m8 {
    public final ArrayList t;
    public boolean u;
    public boolean v;
    public final float w;

    public k7(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset) {
        super(i, i2, f, f2, borderStylePreset);
        this.t = new ArrayList();
        this.u = false;
        this.v = false;
        this.w = 1.0f;
    }

    @Override // com.pspdfkit.internal.f10
    public void a(PointF pointF, Matrix matrix, float f) {
        if (!this.u || this.t.size() < 2) {
            this.t.add(pointF);
        } else {
            ArrayList arrayList = this.t;
            ((PointF) arrayList.get(arrayList.size() - 1)).set(pointF);
        }
        h();
    }

    @Override // com.pspdfkit.internal.n7
    public final boolean g() {
        return this.t.size() >= 2;
    }

    @Override // com.pspdfkit.internal.n7
    public final void h() {
        rp rpVarA;
        xp xpVar = this.k;
        if (xpVar != null) {
            float f = this.b;
            if (f > 0.0f) {
                ArrayList arrayList = this.t;
                Matrix matrix = this.c;
                arrayList.getClass();
                matrix.getClass();
                if (arrayList.isEmpty()) {
                    rpVarA = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        PointF pointF = (PointF) obj;
                        PointF pointF2 = new PointF();
                        pointF2.set(pointF.x * f, pointF.y * f);
                        Matrix matrix2 = new Matrix();
                        matrix.invert(matrix2);
                        s60.a(pointF2, matrix2);
                        arrayList2.add(pointF2);
                    }
                    rpVarA = qp.a(xpVar, arrayList2);
                }
                if (rpVarA != null) {
                    this.m = rpVarA.a;
                }
            }
        }
    }

    public final void a(List<PointF> list) {
        this.t.clear();
        this.t.addAll(list);
        h();
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a() {
        if (this.t.size() < 2) {
            return false;
        }
        return Math.abs(((PointF) this.t.get(0)).x - ((PointF) this.t.get(1)).x) >= this.w || Math.abs(((PointF) this.t.get(0)).y - ((PointF) this.t.get(1)).y) >= this.w;
    }
}
