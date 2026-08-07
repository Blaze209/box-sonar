package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;

/* JADX INFO: loaded from: classes3.dex */
public interface c<T extends Action> {
    boolean executeAction(T t, ActionSender actionSender);
}
