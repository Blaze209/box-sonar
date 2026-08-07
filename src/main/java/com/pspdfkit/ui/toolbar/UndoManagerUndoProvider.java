package com.pspdfkit.ui.toolbar;

import com.pspdfkit.undo.UndoManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/pspdfkit/ui/toolbar/UndoManagerUndoProvider;", "Lcom/pspdfkit/ui/toolbar/UndoProvider;", "undoManager", "Lcom/pspdfkit/undo/UndoManager;", "<init>", "(Lcom/pspdfkit/undo/UndoManager;)V", "canUndo", "", "canRedo", "undo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redo", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UndoManagerUndoProvider implements UndoProvider {
    public static final int $stable = 8;
    private final UndoManager undoManager;

    public UndoManagerUndoProvider(UndoManager undoManager) {
        undoManager.getClass();
        this.undoManager = undoManager;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public boolean canRedo() {
        return this.undoManager.canRedo();
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public boolean canUndo() {
        return this.undoManager.canUndo();
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public Object redo(Continuation<? super Unit> continuation) {
        Object objRedo = this.undoManager.redo(continuation);
        return objRedo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRedo : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public Object undo(Continuation<? super Unit> continuation) {
        Object objUndo = this.undoManager.undo(continuation);
        return objUndo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUndo : Unit.INSTANCE;
    }
}
