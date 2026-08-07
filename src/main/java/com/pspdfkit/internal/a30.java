package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a30 extends m8 {
    public float A;
    public boolean B;
    public final Rect C;
    public final RectF t;
    public final Path u;
    public final Path v;
    public final Matrix w;
    public final RectF x;
    public final int y;
    public float z;

    public a30(int i) {
        this(0, 0, 1.0f, 1.0f, BorderStylePreset.SOLID, i);
    }

    @Override // com.pspdfkit.internal.f10
    public final void a(PointF pointF, Matrix matrix, float f) {
        if (this.z == -1.0f || this.A == -1.0f) {
            this.z = pointF.x;
            this.A = pointF.y;
            return;
        }
        float fA = (s60.a(matrix) * 32.0f) / f;
        float f2 = this.g;
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f3 = (fArr[0] * f2) / f;
        if (i()) {
            f3 += this.s * 4.25f;
        }
        float fMax = Math.max(f3 * 2.0f, fA);
        if (Math.abs(pointF.x - this.z) >= fMax && Math.abs(pointF.y - this.A) >= fMax) {
            this.t.set(this.z, this.A, pointF.x, pointF.y);
            this.t.sort();
            this.B = true;
        } else if (!this.B) {
            float f4 = pointF.x - this.z;
            float fAbs = f4 / Math.abs(f4);
            float f5 = pointF.y - this.A;
            float fAbs2 = f5 / Math.abs(f5);
            RectF rectF = this.t;
            float f6 = this.z;
            float f7 = this.A;
            rectF.set(f6, f7, (fAbs * fMax) + f6, (fAbs2 * fMax) + f7);
            this.t.sort();
            this.B = true;
        }
        h();
    }

    @Override // com.pspdfkit.internal.n7
    public final void h() {
        if (this.k == null || this.b <= 0.0f) {
            return;
        }
        int iA = y30.a(this.y);
        rp rpVarA = null;
        if (iA == 0) {
            RectF rectF = this.t;
            PointF pointF = new PointF(rectF.left, rectF.top);
            RectF rectF2 = this.t;
            PointF pointF2 = new PointF(rectF2.right, rectF2.top);
            RectF rectF3 = this.t;
            PointF pointF3 = new PointF(rectF3.right, rectF3.bottom);
            RectF rectF4 = this.t;
            List<PointF> listAsList = Arrays.asList(pointF, pointF2, pointF3, new PointF(rectF4.left, rectF4.bottom));
            xp xpVar = this.k;
            float f = this.b;
            Matrix matrix = this.c;
            xpVar.getClass();
            listAsList.getClass();
            matrix.getClass();
            if (!listAsList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (PointF pointF4 : listAsList) {
                    PointF pointF5 = new PointF();
                    pointF5.set(pointF4.x * f, pointF4.y * f);
                    Matrix matrix2 = new Matrix();
                    matrix.invert(matrix2);
                    s60.a(pointF5, matrix2);
                    arrayList.add(pointF5);
                }
                rpVarA = qp.a(xpVar, arrayList);
            }
        } else if (iA == 1) {
            float fA = s60.a(this.c) / this.b;
            float fWidth = this.t.width() / fA;
            float fHeight = this.t.height() / fA;
            xp xpVar2 = this.k;
            xpVar2.getClass();
            double measurementCircularArea = NativeMeasurementCalculator.getMeasurementCircularArea(Math.abs(fWidth), Math.abs(fHeight), mr.a(xpVar2.a));
            DecimalFormat decimalFormat = di.a;
            float f2 = (float) measurementCircularArea;
            rpVarA = new rp(di.a.a(xpVar2, f2), f2);
        }
        if (rpVarA != null) {
            this.m = rpVarA.a;
        }
    }

    public a30(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset, int i3) {
        super(i, i2, f, f2, borderStylePreset);
        this.t = new RectF();
        this.u = new Path();
        this.v = new Path();
        this.w = new Matrix();
        this.x = new RectF();
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = false;
        this.C = new Rect();
        this.y = i3;
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a() {
        return this.B;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0397 A[PHI: r5
      0x0397: PHI (r5v14 float) = (r5v13 float), (r5v19 float), (r5v19 float), (r5v13 float) binds: [B:123:0x0382, B:133:0x03c2, B:135:0x03d2, B:125:0x0392] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:130:0x039b  */
    /* JADX WARN: Code duplicated, block: B:134:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:41:0x0133  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x0397 -> B:129:0x0399). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x03d2 -> B:127:0x0395). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.pspdfkit.internal.n7
    public final void a(android.graphics.Canvas r25, android.graphics.Paint r26, android.graphics.Paint r27, float r28) {
        /*
            Method dump skipped, instruction units count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.a30.a(android.graphics.Canvas, android.graphics.Paint, android.graphics.Paint, float):void");
    }
}
