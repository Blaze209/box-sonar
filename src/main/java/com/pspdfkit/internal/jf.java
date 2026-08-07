package com.pspdfkit.internal;

import android.graphics.RectF;
import android.util.SparseArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.utils.Size;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class jf {
    public final kf a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final RectF f;
    public final SparseArray<a> g = new SparseArray<>();
    public float h;
    public float i;

    public static final class a {
        public final RectF a;
        public final Size b;

        public a(RectF rectF, Size size) {
            this.a = rectF;
            this.b = size;
        }
    }

    public jf(kf kfVar, boolean z, boolean z2, boolean z3, boolean z4, RectF rectF, List<? extends Annotation> list) {
        this.a = kfVar;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = rectF;
        for (Annotation annotation : list) {
            RectF boundingBox = annotation.getBoundingBox();
            SparseArray<a> sparseArray = this.g;
            int objectNumber = annotation.getObjectNumber();
            RectF rectF2 = new RectF(boundingBox);
            boundingBox.getClass();
            boundingBox.sort();
            Size minimumSize = annotation.getMinimumSize();
            float fWidth = minimumSize.width;
            fWidth = fWidth > boundingBox.width() ? boundingBox.width() : fWidth;
            float fHeight = minimumSize.height;
            if (fHeight > boundingBox.height()) {
                fHeight = boundingBox.height();
            }
            sparseArray.put(objectNumber, new a(rectF2, new Size(fWidth, fHeight)));
        }
    }

    public final boolean equals(Object obj) {
        jf jfVar = obj instanceof jf ? (jf) obj : null;
        return jfVar != null && jfVar.e == this.e && jfVar.d == this.d && jfVar.c == this.c && jfVar.b == this.b && Intrinsics.areEqual(jfVar.a, this.a);
    }
}
