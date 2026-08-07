package com.pspdfkit.internal;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m8 extends n7 {
    public BorderStyle n;
    public List<Integer> o;
    public BorderEffect p;
    public float q;
    public float r;
    public float s;

    public m8(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset) {
        super(i, i2, f, f2);
        this.n = borderStylePreset.getBorderStyle();
        this.p = borderStylePreset.getBorderEffect();
        float borderEffectIntensity = borderStylePreset.getBorderEffectIntensity();
        if (this.q != borderEffectIntensity) {
            this.q = borderEffectIntensity;
            e();
        }
        this.o = borderStylePreset.getDashArray();
        e();
    }

    @Override // com.pspdfkit.internal.n7
    public final void a(Paint paint, Paint paint2, float f) {
        List<Integer> list;
        float[] fArr;
        super.a(paint, paint2, f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeMiter(10.0f);
        Paint.Cap cap = Paint.Cap.SQUARE;
        paint.setStrokeCap(cap);
        paint.setPathEffect(null);
        float fA = (s60.a(this.c) * this.g) / f;
        if (this.n != BorderStyle.DASHED || (list = this.o) == null || list.size() <= 0) {
            paint.setPathEffect(null);
            paint.setStrokeCap(cap);
            return;
        }
        int size = this.o.size();
        List<Integer> list2 = this.o;
        if (size >= 2) {
            fArr = new float[list2.size()];
            for (int i = 0; i < this.o.size(); i++) {
                fArr[i] = this.o.get(i).intValue() * fA;
            }
        } else {
            fArr = new float[]{list2.get(0).intValue() * fA, this.o.get(0).intValue() * fA};
        }
        paint.setPathEffect(new DashPathEffect(fArr, 0.0f));
        paint.setStrokeCap(Paint.Cap.BUTT);
    }

    @Override // com.pspdfkit.internal.n7
    public void e() {
        this.r = (s60.a(this.c) * this.g) / this.b;
        this.s = (s60.a(this.c) * this.q) / this.b;
    }

    public final boolean i() {
        return this.p == BorderEffect.CLOUDY && this.q > 0.0f;
    }
}
