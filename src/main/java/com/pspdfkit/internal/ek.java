package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class ek {
    public final Context a;

    public ek(Context context) {
        this.a = context;
    }

    public final Single a(final lm lmVar, final int i, final PointF pointF, Uri uri) {
        return z7.d(this.a, uri).map(new Function() { // from class: com.pspdfkit.internal.ek$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(lmVar, i, pointF, (u7) obj);
            }
        });
    }

    public final StampAnnotation a(PdfDocument pdfDocument, int i, PointF pointF, u7 u7Var) throws Throwable {
        float f;
        float fHeight;
        float fHeight2;
        RectF rectF;
        Size pageSize = pdfDocument.getPageSize(i);
        float f2 = u7Var.c;
        float f3 = u7Var.d;
        float fHeight3 = 250.0f;
        if (ip.a(1.0f, f2 / f3)) {
            f = 250.0f;
        } else {
            RectF rectF2 = new RectF(0.0f, 0.0f, 250.0f, 250.0f);
            RectF rectF3 = new RectF(0.0f, 0.0f, f2, f3);
            if (rectF3.width() < rectF2.width() && rectF3.height() < rectF2.height()) {
                rectF = new RectF(rectF3);
            } else {
                if (rectF3.width() / rectF3.height() >= rectF2.width() / rectF2.height()) {
                    fHeight = rectF2.width();
                    fHeight2 = rectF3.width();
                } else {
                    fHeight = rectF2.height();
                    fHeight2 = rectF3.height();
                }
                float f4 = fHeight / fHeight2;
                float fWidth = rectF3.width() * f4;
                float fHeight4 = rectF3.height() * f4;
                float fWidth2 = ((rectF2.width() - fWidth) / 2.0f) + rectF2.left;
                float fHeight5 = ((rectF2.height() - fHeight4) / 2.0f) + rectF2.top;
                rectF = new RectF(fWidth2, fHeight5, fWidth + fWidth2, fHeight4 + fHeight5);
            }
            float fWidth3 = rectF.width();
            fHeight3 = rectF.height();
            f = fWidth3;
        }
        float fMax = Math.max(32.0f, Math.min(f, pageSize.width));
        float fMax2 = Math.max(32.0f, Math.min(fHeight3, pageSize.height));
        float f5 = pointF.x;
        float f6 = pointF.y;
        float f7 = fMax / 2.0f;
        float f8 = fMax2 / 2.0f;
        RectF rectF4 = new RectF(f5 - f7, f6 + f8, f5 + f7, f6 - f8);
        ff.a(rectF4, new RectF(0.0f, pageSize.height, pageSize.width, 0.0f));
        StampAnnotation stampAnnotation = new StampAnnotation(i, rectF4, u7Var.b);
        stampAnnotation.setRotation(0, new Size(rectF4.width(), -rectF4.height()));
        return stampAnnotation;
    }
}
