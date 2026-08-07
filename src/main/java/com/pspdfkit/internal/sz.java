package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.RichMediaExecuteAction;
import com.pspdfkit.internal.views.document.DocumentView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class sz implements c<RichMediaExecuteAction> {
    public final DocumentView a;

    public sz(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        RichMediaExecuteAction richMediaExecuteAction = (RichMediaExecuteAction) action;
        lm document = this.a.getDocument();
        if (document == null) {
            return false;
        }
        richMediaExecuteAction.getRichMediaAnnotationAsync(document).observeOn(AndroidSchedulers.mainThread()).subscribe(new qz(this, richMediaExecuteAction), rz.a);
        return true;
    }
}
