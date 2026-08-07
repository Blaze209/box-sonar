package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.RenditionAction;
import com.pspdfkit.internal.views.document.DocumentView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class ez implements c<RenditionAction> {
    public final DocumentView a;

    public ez(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        RenditionAction renditionAction = (RenditionAction) action;
        lm document = this.a.getDocument();
        if (document == null) {
            return false;
        }
        renditionAction.getScreenAnnotationAsync(document).observeOn(AndroidSchedulers.mainThread()).subscribe(new cz(this, renditionAction), dz.a);
        return true;
    }
}
