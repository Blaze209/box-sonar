package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;

/* JADX INFO: loaded from: classes3.dex */
public final class nb implements la {
    public final go<ContentEditingManager.OnContentEditingModeChangeListener> a = new go<>();
    public final go<ContentEditingManager.OnContentEditingContentChangeListener> b = new go<>();

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public final void addOnContentEditingContentChangeListener(ContentEditingManager.OnContentEditingContentChangeListener onContentEditingContentChangeListener) {
        onContentEditingContentChangeListener.getClass();
        this.b.a(onContentEditingContentChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public final void addOnContentEditingModeChangeListener(ContentEditingManager.OnContentEditingModeChangeListener onContentEditingModeChangeListener) {
        onContentEditingModeChangeListener.getClass();
        this.a.a(onContentEditingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public final void removeOnContentEditingContentChangeListener(ContentEditingManager.OnContentEditingContentChangeListener onContentEditingContentChangeListener) {
        onContentEditingContentChangeListener.getClass();
        this.b.b(onContentEditingContentChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public final void removeOnContentEditingModeChangeListener(ContentEditingManager.OnContentEditingModeChangeListener onContentEditingModeChangeListener) {
        onContentEditingModeChangeListener.getClass();
        this.a.b(onContentEditingModeChangeListener);
    }
}
