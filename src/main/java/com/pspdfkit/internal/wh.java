package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public final class wh extends View {
    public RectF a;

    public wh(Context context, int i) {
        super(context);
        this.a = new RectF();
        setBackgroundColor(i);
    }

    public void setHighlightRect(RectF rectF) {
        if (this.a.equals(rectF)) {
            return;
        }
        this.a = rectF;
        setLayoutParams(new OverlayLayoutParams(this.a, OverlayLayoutParams.SizingMode.LAYOUT));
    }
}
