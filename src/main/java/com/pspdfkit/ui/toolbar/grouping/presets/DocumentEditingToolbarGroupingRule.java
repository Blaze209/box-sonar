package com.pspdfkit.ui.toolbar.grouping.presets;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentEditingToolbarGroupingRule extends PresetMenuItemGroupingRule {
    public DocumentEditingToolbarGroupingRule(Context context) {
        super(context);
    }

    @Override // com.pspdfkit.ui.toolbar.grouping.presets.PresetMenuItemGroupingRule
    public List<MenuItem> getGroupPreset(int i, int i2) {
        if (i < 4) {
            return new ArrayList(i);
        }
        if (i == 4) {
            return DocumentEditingToolbarItemPresets.FOUR_ITEMS_GROUPING;
        }
        if (i == 5) {
            return DocumentEditingToolbarItemPresets.FIVE_ITEMS_GROUPING;
        }
        return (i < 6 || i >= i2) ? DocumentEditingToolbarItemPresets.ALL_ITEMS_GROUPING : DocumentEditingToolbarItemPresets.SIX_ITEMS_GROUPING;
    }
}
