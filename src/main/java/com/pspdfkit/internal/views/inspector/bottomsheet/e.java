package com.pspdfkit.internal.views.inspector.bottomsheet;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends BottomSheetBehavior.b {
    public final /* synthetic */ d<View> a;

    public e(d<View> dVar) {
        this.a = dVar;
    }

    @Override // com.pspdfkit.internal.views.inspector.bottomsheet.BottomSheetBehavior.b
    public final void a(View view) {
    }

    @Override // com.pspdfkit.internal.views.inspector.bottomsheet.BottomSheetBehavior.b
    public final void a(View view, int i) {
        if (i == 5) {
            d<View> dVar = this.a;
            dVar.setVisibility(8);
            d.a aVar = dVar.b;
            if (aVar != null) {
                aVar.onHide(dVar);
            }
        }
    }
}
