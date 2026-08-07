package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class nw extends k7 {
    public final Rect A;
    public final Path x;
    public final Path y;
    public final Matrix z;

    public nw() {
        this(0, 0, 1.0f, 1.0f, BorderStylePreset.SOLID);
    }

    @Override // com.pspdfkit.internal.n7
    public final void a(Canvas canvas, Paint paint, Paint paint2, float f) {
        if (this.t.size() < 2) {
            return;
        }
        if (i()) {
            a9.a(this.t, this.s, this.x, this.v);
            this.x.setFillType(Path.FillType.WINDING);
        } else {
            this.x.reset();
            this.x.moveTo(((PointF) this.t.get(0)).x, ((PointF) this.t.get(0)).y);
            for (int i = 0; i < this.t.size(); i++) {
                this.x.lineTo(((PointF) this.t.get(i)).x, ((PointF) this.t.get(i)).y);
            }
            if (this.v) {
                this.x.close();
            }
            this.x.setFillType(Path.FillType.EVEN_ODD);
        }
        int iSave = canvas.save();
        if (f()) {
            if (canvas.getClipBounds(this.A)) {
                Rect rect = this.A;
                canvas.saveLayer(rect.left, rect.top, rect.right, rect.bottom, null);
            } else {
                canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
            }
        }
        if (this.m != null && this.k != null && this.j != null) {
            if (this.t.size() <= 2 || !(this.v || c() == 2)) {
                a("", canvas, f);
            } else {
                a(this.m, canvas, f);
            }
        }
        if (paint2 != null && this.t.size() > 2) {
            if (f != 1.0f) {
                this.z.setScale(f, f);
                Path path = this.x;
                Path path2 = this.y;
                Matrix matrix = this.z;
                path2.set(path);
                path2.transform(matrix);
                canvas.drawPath(this.y, paint2);
            } else {
                canvas.drawPath(this.x, paint2);
            }
        }
        if (this.n != BorderStyle.NONE || this.p != BorderEffect.NO_EFFECT) {
            if (f != 1.0f) {
                this.z.setScale(f, f);
                Path path3 = this.x;
                Path path4 = this.y;
                Matrix matrix2 = this.z;
                path4.set(path3);
                path4.transform(matrix2);
                Path path5 = this.y;
                if (paint2 != null && this.t.size() > 2 && f()) {
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    canvas.drawPath(path5, paint);
                    paint.setXfermode(null);
                }
                canvas.drawPath(path5, paint);
            } else {
                Path path6 = this.x;
                if (paint2 != null && this.t.size() > 2 && f()) {
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    canvas.drawPath(path6, paint);
                    paint.setXfermode(null);
                }
                canvas.drawPath(path6, paint);
            }
        }
        canvas.restoreToCount(iSave);
    }

    public nw(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset) {
        super(i, i2, f, f2, borderStylePreset);
        this.x = new Path();
        this.y = new Path();
        this.z = new Matrix();
        this.A = new Rect();
    }

    public final void a(String str, Canvas canvas, float f) {
        int i = 0;
        PointF pointF = (PointF) this.t.get(0);
        ArrayList arrayList = this.t;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PointF pointF2 = (PointF) obj;
            float f2 = pointF2.y;
            float f3 = pointF.y;
            if (f2 < f3 || (f2 == f3 && pointF2.x < pointF.x)) {
                pointF = pointF2;
            }
        }
        float f4 = this.g + 14.0f;
        Matrix matrix = this.c;
        float fA = (s60.a(matrix) / this.b) * f4;
        float f5 = pointF.x;
        float f6 = pointF.y - fA;
        canvas.save();
        if (f != 1.0f) {
            Matrix matrix2 = new Matrix();
            matrix2.setScale(f, f);
            canvas.concat(matrix2);
        }
        canvas.drawText(str, f5, f6, this.j);
        canvas.restore();
    }
}
