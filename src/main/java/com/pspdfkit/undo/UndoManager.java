package com.pspdfkit.undo;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.undo.exceptions.RedoEditFailedException;
import com.pspdfkit.undo.exceptions.UndoEditFailedException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/undo/UndoManager;", "", "canUndo", "", "canRedo", "undo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redo", "clearHistory", "addOnUndoHistoryChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/undo/OnUndoHistoryChangeListener;", "removeOnUndoHistoryChangeListener", "setOnAddNewEditListener", "Lcom/pspdfkit/undo/OnAddNewEditListener;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface UndoManager {
    void addOnUndoHistoryChangeListener(OnUndoHistoryChangeListener listener);

    boolean canRedo();

    boolean canUndo();

    void clearHistory();

    Object redo(Continuation<? super Unit> continuation) throws RedoEditFailedException;

    void removeOnUndoHistoryChangeListener(OnUndoHistoryChangeListener listener);

    void setOnAddNewEditListener(OnAddNewEditListener listener);

    Object undo(Continuation<? super Unit> continuation) throws UndoEditFailedException;
}
