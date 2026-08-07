package com.pspdfkit.ui.toolbar.grouping;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.m;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.toolbar.ContextualToolbarMenuItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultMenuItemGroupingRule implements MenuItemGroupingRule {
    protected Context context;
    protected int iconColor;
    protected int iconColorActivated;

    public DefaultMenuItemGroupingRule(Context context) {
        int color;
        int color2;
        uw.a(context, "context", null);
        this.context = context;
        Resources.Theme theme = context.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(null, R.styleable.pspdf__ContextualToolbar, R.attr.pspdf__contextualToolbarStyle, R.style.PSPDFKit_ContextualToolbar) : null;
        if (typedArrayObtainStyledAttributes != null) {
            m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__backgroundColor, androidx.appcompat.R.attr.colorPrimaryDark, R.color.pspdf__onPrimaryContainerLight);
            m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__borderColor, androidx.appcompat.R.attr.colorPrimaryDark, R.color.pspdf__onPrimaryContainerLight);
            m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__submenuBackgroundColor, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight);
            m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__submenuBorderColor, androidx.appcompat.R.attr.colorPrimary, R.color.pspdf__primaryLight);
            color = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__iconsColor, R.color.pspdf__onPrimaryLight);
            color2 = m.a(typedArrayObtainStyledAttributes, context, R.styleable.pspdf__ContextualToolbar_pspdf__iconsColorActivated, R.color.pspdf__onPrimaryLight);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            ContextCompat.getColor(context, R.color.pspdf__primaryLight);
            ContextCompat.getColor(context, R.color.pspdf__primaryLight);
            color = ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight);
            color2 = ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight);
        }
        this.iconColor = color;
        this.iconColorActivated = color2;
    }

    private List<ContextualToolbarMenuItem> collapseItems(List<ContextualToolbarMenuItem> list, int i) {
        if (list.isEmpty() || i <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(i);
        for (int i2 = 0; i2 < i + 1; i2++) {
            arrayList2.add(list.get((list.size() - i2) - 1));
        }
        if (arrayList2.isEmpty()) {
            arrayList.addAll(list);
            return arrayList;
        }
        Drawable drawable = AppCompatResources.getDrawable(this.context, R.drawable.pspdf__ic_more_horizontal);
        if (drawable == null) {
            return arrayList;
        }
        int i3 = R.id.pspdf__toolbar_more_items;
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.END;
        Context context = this.context;
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateGroupItem = ContextualToolbarMenuItem.createGroupItem(i3, position, false, arrayList2, ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_group_more, drawable, no.a(context, R.string.pspdf__more_options, null), this.iconColor, this.iconColorActivated, position, false));
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            if (!arrayList2.contains(contextualToolbarMenuItem)) {
                arrayList.add(contextualToolbarMenuItem);
            }
        }
        arrayList.add(contextualToolbarMenuItemCreateGroupItem);
        return arrayList;
    }

    private List<ContextualToolbarMenuItem> expandItems(List<ContextualToolbarMenuItem> list, int i) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            List<ContextualToolbarMenuItem> subMenuItems = contextualToolbarMenuItem.getSubMenuItems();
            if (subMenuItems == null || i <= 0) {
                arrayList.add(contextualToolbarMenuItem);
            } else {
                ArrayList arrayList2 = new ArrayList(subMenuItems.size());
                for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : subMenuItems) {
                    if (!contextualToolbarMenuItem2.shouldDisplayOutsideOfSubmenuIfPossible() || i <= 0) {
                        arrayList2.add(contextualToolbarMenuItem2);
                    } else {
                        arrayList.add(contextualToolbarMenuItem2);
                        i--;
                    }
                }
                if (!arrayList2.isEmpty()) {
                    ContextualToolbarMenuItem defaultSelectedMenuItem = contextualToolbarMenuItem.getDefaultSelectedMenuItem();
                    if (defaultSelectedMenuItem == null || arrayList2.contains(defaultSelectedMenuItem)) {
                        contextualToolbarMenuItem.setSubMenuItems(arrayList2, defaultSelectedMenuItem);
                    } else {
                        contextualToolbarMenuItem.setSubMenuItems(arrayList2, null);
                    }
                    arrayList.add(contextualToolbarMenuItem);
                }
            }
        }
        return arrayList;
    }

    @Override // com.pspdfkit.ui.toolbar.grouping.MenuItemGroupingRule
    public boolean areGeneratedGroupItemsSelectable() {
        return false;
    }

    @Override // com.pspdfkit.ui.toolbar.grouping.MenuItemGroupingRule
    public List<ContextualToolbarMenuItem> groupMenuItems(List<ContextualToolbarMenuItem> list, int i) {
        if (list.size() != i) {
            list = list.size() < i ? expandItems(list, i - list.size()) : collapseItems(list, list.size() - i);
        }
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            List<ContextualToolbarMenuItem> subMenuItems = contextualToolbarMenuItem.getSubMenuItems();
            if (subMenuItems != null && subMenuItems.size() == 1) {
                ContextualToolbarMenuItem contextualToolbarMenuItem2 = subMenuItems.get(0);
                contextualToolbarMenuItem2.setSelectable(contextualToolbarMenuItem2.isSelectable());
                list.set(list.indexOf(contextualToolbarMenuItem), contextualToolbarMenuItem2);
            }
        }
        return list;
    }
}
