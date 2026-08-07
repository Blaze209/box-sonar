package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.HideAction;
import com.pspdfkit.internal.views.document.DocumentView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: classes3.dex */
public final class nj implements c<HideAction> {
    public final DocumentView a;

    public nj(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        HideAction hideAction = (HideAction) action;
        lm document = this.a.getDocument();
        if (document == null) {
            return false;
        }
        hideAction.getAnnotationsAsync(document).observeOn(AndroidSchedulers.mainThread()).subscribe(new lj(this, hideAction), mj.a);
        return true;
    }
}
