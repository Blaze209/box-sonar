package com.pspdfkit.ui.toolbar.grouping;

import com.pspdfkit.ui.toolbar.ContextualToolbarMenuItem;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface MenuItemGroupingRule {
    boolean areGeneratedGroupItemsSelectable();

    List<ContextualToolbarMenuItem> groupMenuItems(List<ContextualToolbarMenuItem> list, int i);
}
