package com.pspdfkit.ui.actionmenu;

import android.graphics.drawable.Drawable;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActionMenuItem {
    private final Drawable icon;
    private boolean isEnabled = true;
    private final int itemId;
    private final MenuItemType itemType;
    private final String label;

    public enum MenuItemType {
        STANDARD,
        FIXED
    }

    public ActionMenuItem(int i, MenuItemType menuItemType, Drawable drawable, String str) {
        uw.a(menuItemType, "itemType", null);
        uw.a(drawable, HubsObservability.HUB_ASSET_ICON, null);
        uw.a(str, "label", null);
        this.itemId = i;
        this.itemType = menuItemType;
        this.icon = drawable;
        this.label = str;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getItemId() {
        return this.itemId;
    }

    public MenuItemType getItemType() {
        return this.itemType;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public abstract boolean isPrintItem();

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
