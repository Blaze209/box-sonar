package com.pspdfkit.ui.actionmenu;

import android.graphics.drawable.Drawable;
import com.pspdfkit.document.sharing.ShareTarget;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class SharingMenuItem extends ActionMenuItem {
    private final ShareTarget shareTarget;

    public SharingMenuItem(ShareTarget shareTarget, Drawable drawable, String str) {
        super(-1, ActionMenuItem.MenuItemType.STANDARD, drawable, str);
        uw.a(shareTarget, "shareTarget", null);
        this.shareTarget = shareTarget;
    }

    public ShareTarget getShareTarget() {
        return this.shareTarget;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuItem
    public boolean isPrintItem() {
        return this.shareTarget.isPrintTarget();
    }
}
