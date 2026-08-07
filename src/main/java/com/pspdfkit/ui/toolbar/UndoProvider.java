package com.pspdfkit.ui.toolbar;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/toolbar/UndoProvider;", "", "canUndo", "", "canRedo", "undo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redo", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface UndoProvider {
    boolean canRedo();

    boolean canUndo();

    Object redo(Continuation<? super Unit> continuation);

    Object undo(Continuation<? super Unit> continuation);
}
