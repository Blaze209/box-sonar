package com.pspdfkit.ui.actionmenu;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleActionMenuListener implements ActionMenuListener {
    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public boolean onActionMenuItemClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem) {
        return false;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public boolean onActionMenuItemLongClicked(ActionMenu actionMenu, ActionMenuItem actionMenuItem) {
        return false;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public void onDisplayActionMenu(ActionMenu actionMenu) {
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public boolean onPrepareActionMenu(ActionMenu actionMenu) {
        return true;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuListener
    public void onRemoveActionMenu(ActionMenu actionMenu) {
    }
}
