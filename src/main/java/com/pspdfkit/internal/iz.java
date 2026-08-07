package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.ResetFormAction;
import com.pspdfkit.internal.views.document.DocumentView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class iz implements c<ResetFormAction> {
    public final DocumentView a;

    public iz(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        ResetFormAction resetFormAction = (ResetFormAction) action;
        lm document = this.a.getDocument();
        if (document == null) {
            return false;
        }
        resetFormAction.getTargetFormFieldsAsync(document).observeOn(AndroidSchedulers.mainThread()).subscribe(new gz(document, resetFormAction), hz.a);
        return true;
    }
}
