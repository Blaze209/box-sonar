package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.appcompat.widget.AppCompatImageView;
import com.pspdfkit.signatures.Signature;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k20 extends AppCompatImageView {
    public final Paint a;
    public Signature b;
    public Bitmap c;
    public int d;
    public int e;

    public k20(Context context) {
        super(context);
        Paint paint = new Paint();
        this.a = paint;
        Context context2 = getContext();
        int iA = a80.a(context2, 16);
        int iA2 = (int) un.a(context2, 1, 4);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        setPadding(iA, iA2, iA, iA2);
    }

    public final synchronized void a() {
        setImageBitmap(null);
        this.d = getWidth();
        int height = getHeight();
        this.e = height;
        if (this.b != null && this.d > 0 && height > 0) {
            Context context = getContext();
            int iA = a80.a(context, 16);
            int iA2 = (int) un.a(context, 1, 4);
            int i = this.d - (iA * 2);
            int i2 = this.e - (iA2 * 2);
            if (i > 0 && i2 > 0) {
                boolean zIsEmpty = this.b.getLines().isEmpty();
                Signature signature = this.b;
                if (!zIsEmpty) {
                    RectF boundingBox = signature.getBoundingBox();
                    float fA = a80.a(getContext(), this.b.getLineWidth()) * 2.0f;
                    float f = fA * 2.0f;
                    float fWidth = boundingBox.width() + f;
                    float f2 = (-boundingBox.height()) + f;
                    float fMin = Math.min(i / fWidth, i2 / f2);
                    int i3 = (int) (fWidth * fMin);
                    int i4 = (int) (f2 * fMin);
                    Bitmap bitmap = this.c;
                    if (bitmap == null || bitmap.getWidth() != i3 || this.c.getHeight() != i4) {
                        this.c = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                    }
                    this.a.setColor(this.b.getInkColor());
                    this.a.setStrokeWidth(this.b.getLineWidth() * fMin);
                    Canvas canvas = new Canvas(this.c);
                    for (List<PointF> list : this.b.getLines()) {
                        Path path = new Path();
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            PointF pointF = list.get(i5);
                            float f3 = (pointF.x + fA) * fMin;
                            float f4 = (((-boundingBox.height()) - pointF.y) + fA) * fMin;
                            if (i5 == 0) {
                                path.moveTo(f3, f4);
                            } else {
                                PointF pointF2 = list.get(i5 - 1);
                                float f5 = (pointF2.x + fA) * fMin;
                                float f6 = (((-boundingBox.height()) - pointF2.y) + fA) * fMin;
                                path.quadTo(f5, f6, (f3 + f5) / 2.0f, (f4 + f6) / 2.0f);
                            }
                        }
                        canvas.drawPath(path, this.a);
                    }
                } else {
                    if (signature.getBitmap() == null) {
                        throw new IllegalStateException("Signature has not been created correctly: " + this.b.toString());
                    }
                    if (this.c == null) {
                        this.c = this.b.getBitmap();
                    }
                }
                setImageBitmap(this.c);
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if ((this.d == getWidth() && this.e == getHeight()) || this.b == null) {
            return;
        }
        a();
    }

    public void setSignature(Signature signature) {
        this.b = signature;
        a();
    }
}
