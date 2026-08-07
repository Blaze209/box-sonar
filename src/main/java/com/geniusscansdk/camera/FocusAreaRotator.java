package com.geniusscansdk.camera;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes13.dex */
class FocusAreaRotator {
    FocusAreaRotator() {
    }

    public Rect rotate(Rect rect, float f) {
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }
}
