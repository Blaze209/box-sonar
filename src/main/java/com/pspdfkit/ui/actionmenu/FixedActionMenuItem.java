package com.pspdfkit.ui.actionmenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.pspdfkit.R;
import com.pspdfkit.internal.no;

/* JADX INFO: loaded from: classes3.dex */
public class FixedActionMenuItem extends ActionMenuItem {
    public FixedActionMenuItem(Context context, int i, int i2, int i3) {
        super(i, ActionMenuItem.MenuItemType.FIXED, ActionMenu.createActionMenuIcon(context, i2), no.a(context, i3, null));
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenuItem
    public boolean isPrintItem() {
        return getItemId() == R.id.pspdf__menu_option_print;
    }

    public FixedActionMenuItem(Context context, int i, int i2, String str) {
        super(i, ActionMenuItem.MenuItemType.FIXED, ActionMenu.createActionMenuIcon(context, i2), str);
    }

    public FixedActionMenuItem(int i, Drawable drawable, String str) {
        super(i, ActionMenuItem.MenuItemType.FIXED, drawable, str);
    }
}
