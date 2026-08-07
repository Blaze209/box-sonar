package com.pspdfkit.internal;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class mx {
    public final RectF a;
    public final RectF b;

    public mx(RectF rectF, RectF rectF2) {
        this.a = rectF;
        this.b = rectF2;
    }

    public final float a() {
        return this.a.bottom + this.b.bottom;
    }

    public final float b() {
        return this.a.left + this.b.left;
    }

    public final float c() {
        return this.a.right + this.b.right;
    }

    public final float d() {
        return this.a.top + this.b.top;
    }
}
