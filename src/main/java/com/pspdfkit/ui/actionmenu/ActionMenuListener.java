package com.pspdfkit.ui.actionmenu;

/* JADX INFO: loaded from: classes3.dex */
public interface ActionMenuListener {
    boolean onActionMenuItemClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem);

    boolean onActionMenuItemLongClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem);

    void onDisplayActionMenu(ActionMenu actionMenu);

    boolean onPrepareActionMenu(ActionMenu actionMenu);

    void onRemoveActionMenu(ActionMenu actionMenu);
}
