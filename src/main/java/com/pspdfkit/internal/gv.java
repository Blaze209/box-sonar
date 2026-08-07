package com.pspdfkit.internal;

import android.view.View;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.navigation.NavigationBackStack;

/* JADX INFO: loaded from: classes3.dex */
public final class gv implements NavigationBackStack.BackStackListener<NavigationBackStack.NavigationItem<Integer>> {
    public final /* synthetic */ dv a;

    public gv(dv dvVar) {
        this.a = dvVar;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    @Override // com.pspdfkit.ui.navigation.NavigationBackStack.BackStackListener
    public final void onBackStackChanged() {
        boolean z;
        PdfFragment pdfFragment = this.a.j;
        if (pdfFragment == null) {
            return;
        }
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory = pdfFragment.getNavigationHistory();
        navigationHistory.getClass();
        dv dvVar = this.a;
        if (dvVar.l && dvVar.A) {
            jv jvVar = (jv) dvVar.b;
            if (jvVar.e == null || jvVar.f == null || !dvVar.e.isShowNavigationButtonsEnabled() || ((jv) dvVar.b).getActiveViewType() != PSPDFKitViews.Type.VIEW_NONE) {
                z = false;
            } else {
                PdfFragment pdfFragment2 = dvVar.j;
                if ((pdfFragment2 != null ? pdfFragment2.getContentEditingState() : null) != null) {
                    z = false;
                } else {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        im imVar = this.a.b;
        if (!z) {
            View view = ((jv) imVar).e;
            if (view != null) {
                view.setVisibility(4);
            }
            View view2 = ((jv) this.a.b).f;
            if (view2 != null) {
                view2.setVisibility(4);
                return;
            }
            return;
        }
        View view3 = ((jv) imVar).e;
        if (view3 != null) {
            view3.setVisibility(navigationHistory.getBackItem() != null ? 0 : 4);
        }
        View view4 = ((jv) this.a.b).f;
        if (view4 != null) {
            view4.setVisibility(navigationHistory.getForwardItem() == null ? 4 : 0);
        }
        if (navigationHistory.getBackItem() == null && navigationHistory.getForwardItem() == null) {
            this.a.d(true);
        } else {
            this.a.j(true);
        }
    }

    @Override // com.pspdfkit.ui.navigation.NavigationBackStack.BackStackListener
    public final void visitedItem(NavigationBackStack.NavigationItem<Integer> navigationItem) {
        navigationItem.getClass();
    }
}
