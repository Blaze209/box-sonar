package com.pspdfkit.ui.toolbar.grouping.presets;

import android.content.Context;
import com.pspdfkit.ui.toolbar.ContextualToolbarMenuItem;
import com.pspdfkit.ui.toolbar.grouping.DefaultMenuItemGroupingRule;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PresetMenuItemGroupingRule extends DefaultMenuItemGroupingRule {
    public PresetMenuItemGroupingRule(Context context) {
        super(context);
    }

    private ContextualToolbarMenuItem findMenuItem(List<ContextualToolbarMenuItem> list, int i) {
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            if (contextualToolbarMenuItem.getId() == i) {
                return contextualToolbarMenuItem;
            }
            if (contextualToolbarMenuItem.getSubMenuItems() != null) {
                for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : contextualToolbarMenuItem.getSubMenuItems()) {
                    if (contextualToolbarMenuItem2.getId() == i) {
                        return contextualToolbarMenuItem2;
                    }
                }
            }
        }
        return null;
    }

    public abstract List<MenuItem> getGroupPreset(int i, int i2);

    @Override // com.pspdfkit.ui.toolbar.grouping.DefaultMenuItemGroupingRule, com.pspdfkit.ui.toolbar.grouping.MenuItemGroupingRule
    public List<ContextualToolbarMenuItem> groupMenuItems(List<ContextualToolbarMenuItem> list, int i) {
        List<MenuItem> groupPreset = getGroupPreset(i, list.size());
        ArrayList arrayList = new ArrayList(groupPreset.size());
        for (MenuItem menuItem : groupPreset) {
            if (menuItem.submenuIds == null) {
                ContextualToolbarMenuItem contextualToolbarMenuItemFindMenuItem = findMenuItem(list, menuItem.id);
                if (contextualToolbarMenuItemFindMenuItem != null) {
                    arrayList.add(contextualToolbarMenuItemFindMenuItem);
                }
            } else {
                ArrayList arrayList2 = new ArrayList(menuItem.submenuIds.length);
                for (int i2 : menuItem.submenuIds) {
                    ContextualToolbarMenuItem contextualToolbarMenuItemFindMenuItem2 = findMenuItem(list, i2);
                    if (contextualToolbarMenuItemFindMenuItem2 != null) {
                        arrayList2.add(contextualToolbarMenuItemFindMenuItem2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    ContextualToolbarMenuItem contextualToolbarMenuItemFindMenuItem3 = findMenuItem(list, menuItem.id);
                    if (contextualToolbarMenuItemFindMenuItem3 == null) {
                        contextualToolbarMenuItemFindMenuItem3 = ContextualToolbarMenuItem.createGroupItem(menuItem.id, ((ContextualToolbarMenuItem) arrayList2.get(0)).getPosition(), areGeneratedGroupItemsSelectable(), arrayList2, (ContextualToolbarMenuItem) arrayList2.get(0));
                        contextualToolbarMenuItemFindMenuItem3.setOpenSubmenuOnClick(false);
                    } else {
                        contextualToolbarMenuItemFindMenuItem3.setSubMenuItems(arrayList2, contextualToolbarMenuItemFindMenuItem3.getDefaultSelectedMenuItem());
                    }
                    arrayList.add(contextualToolbarMenuItemFindMenuItem3);
                }
            }
        }
        return super.groupMenuItems(arrayList, i);
    }
}
