package com.pspdfkit.internal;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes3.dex */
public final class d50 {
    public final float a;
    public final float b;

    public d50(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d50)) {
            return false;
        }
        d50 d50Var = (d50) obj;
        return Dp.m9692equalsimpl0(this.a, d50Var.a) && Dp.m9692equalsimpl0(this.b, d50Var.b);
    }

    public final int hashCode() {
        return Dp.m9693hashCodeimpl(this.b) + (Dp.m9693hashCodeimpl(this.a) * 31);
    }

    public final String toString() {
        return "SwipeDeleteBackgroundStyling(itemHorizontalPadding=" + Dp.m9698toStringimpl(this.a) + ", itemVerticalPadding=" + Dp.m9698toStringimpl(this.b) + ")";
    }
}
