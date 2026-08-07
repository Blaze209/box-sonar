package com.pspdfkit.internal;

import android.content.Context;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class rf extends MAMRelativeLayout {
    public sf a;
    public final g20 b;

    public rf(Context context, g20 g20Var) {
        super(context);
        this.b = g20Var;
    }

    public abstract void e();

    public abstract com.pspdfkit.internal.ui.dialog.signatures.e getCanvasView();

    public final g20 getStyle() {
        return this.b;
    }

    public void setActive(boolean z) {
        com.pspdfkit.internal.ui.dialog.signatures.e canvasView = getCanvasView();
        if (canvasView != null) {
            canvasView.setActive(Boolean.valueOf(z));
        }
    }

    public final void setListener(sf sfVar) {
        this.a = sfVar;
    }
}
