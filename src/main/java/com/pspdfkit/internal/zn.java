package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;

/* JADX INFO: loaded from: classes3.dex */
public final class zn extends qw {
    /* JADX WARN: Illegal instructions before constructor call */
    public zn() {
        BorderStylePreset borderStylePreset = BorderStylePreset.SOLID;
        LineEndType lineEndType = LineEndType.NONE;
        super(0, 0, 1.0f, 1.0f, borderStylePreset, new Pair(lineEndType, lineEndType));
    }

    @Override // com.pspdfkit.internal.k7, com.pspdfkit.internal.f10
    public final void a(PointF pointF, Matrix matrix, float f) {
        if (this.t.size() < 2) {
            super.a(pointF, matrix, f);
        } else {
            ((PointF) this.t.get(1)).set(pointF);
            h();
        }
    }

    public zn(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset, Pair<LineEndType, LineEndType> pair) {
        super(i, i2, f, f2, borderStylePreset, pair);
    }
}
