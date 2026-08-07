package com.pspdfkit.internal;

import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;

/* JADX INFO: loaded from: classes3.dex */
public final class x50 implements w50 {
    public final go<TextSelectionManager.OnTextSelectionModeChangeListener> a = new go<>();
    public final go<TextSelectionManager.OnTextSelectionChangeListener> b = new go<>();

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public final void addOnTextSelectionChangeListener(TextSelectionManager.OnTextSelectionChangeListener onTextSelectionChangeListener) {
        this.b.a(onTextSelectionChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public final void addOnTextSelectionModeChangeListener(TextSelectionManager.OnTextSelectionModeChangeListener onTextSelectionModeChangeListener) {
        this.a.a(onTextSelectionModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public final void removeOnTextSelectionChangeListener(TextSelectionManager.OnTextSelectionChangeListener onTextSelectionChangeListener) {
        this.b.b(onTextSelectionChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public final void removeOnTextSelectionModeChangeListener(TextSelectionManager.OnTextSelectionModeChangeListener onTextSelectionModeChangeListener) {
        this.a.b(onTextSelectionModeChangeListener);
    }
}
