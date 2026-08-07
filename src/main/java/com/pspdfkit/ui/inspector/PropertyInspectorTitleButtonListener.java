package com.pspdfkit.ui.inspector;

/* JADX INFO: loaded from: classes3.dex */
public interface PropertyInspectorTitleButtonListener {
    default boolean onBackButtonClicked() {
        return false;
    }

    default boolean onCloseButtonClicked() {
        return false;
    }
}
