package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.GoToAction;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.navigation.PageNavigator;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class cj implements c<GoToAction> {
    public final PageNavigator a;

    public cj(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        this.a = pdfFragment;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        int pageIndex = ((GoToAction) action).getPageIndex();
        if (pageIndex < 0 || pageIndex > this.a.getPageCount() - 1) {
            PdfLog.i("Nutri.GoToActionExec", "Go to page action executed, but the target page doesn't exist in the current document.", new Object[0]);
            return false;
        }
        this.a.beginNavigation();
        this.a.setPageIndex(pageIndex);
        this.a.endNavigation();
        return true;
    }
}
