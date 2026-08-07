package com.pspdfkit.internal;

import com.pspdfkit.undo.OnUndoHistoryChangeListener;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class b70<T> implements Consumer {
    public final /* synthetic */ a70 a;

    public b70(a70 a70Var) {
        this.a = a70Var;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Object obj) {
        OnUndoHistoryChangeListener onUndoHistoryChangeListener = (OnUndoHistoryChangeListener) obj;
        onUndoHistoryChangeListener.getClass();
        onUndoHistoryChangeListener.onUndoHistoryChanged(this.a);
    }
}
