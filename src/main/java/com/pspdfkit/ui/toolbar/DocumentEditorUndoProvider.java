package com.pspdfkit.ui.toolbar;

import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/pspdfkit/ui/toolbar/DocumentEditorUndoProvider;", "Lcom/pspdfkit/ui/toolbar/UndoProvider;", "controller", "Lcom/pspdfkit/ui/special_mode/controller/DocumentEditingController;", "<init>", "(Lcom/pspdfkit/ui/special_mode/controller/DocumentEditingController;)V", "canUndo", "", "canRedo", "undo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redo", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocumentEditorUndoProvider implements UndoProvider {
    public static final int $stable = 8;
    private final DocumentEditingController controller;

    public DocumentEditorUndoProvider(DocumentEditingController documentEditingController) {
        documentEditingController.getClass();
        this.controller = documentEditingController;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public boolean canRedo() {
        return this.controller.isRedoEnabled();
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public boolean canUndo() {
        return this.controller.isUndoEnabled();
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public Object redo(Continuation<? super Unit> continuation) {
        this.controller.redo();
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoProvider
    public Object undo(Continuation<? super Unit> continuation) {
        this.controller.undo();
        return Unit.INSTANCE;
    }
}
