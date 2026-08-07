package com.swmansion.rnscreens.gamma.tabs.appearance;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.facebook.react.common.assets.ReactFontManager;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.utils.ColorUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TabsAppearanceApplicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J/\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearanceApplicator;", "", "bottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "<init>", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;)V", "states", "", "", "[[I", "updateSharedAppearance", "", "context", "Landroid/content/Context;", "tabBarAppearance", "Lcom/swmansion/rnscreens/gamma/tabs/appearance/TabsAppearance;", "isTabBarHidden", "", "updateFontStyles", "updateMenuItemAppearance", "menuItem", "Landroid/view/MenuItem;", "tabsScreen", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "updateBadgeAppearance", "appearance", "updateBadgeAppearance$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsAppearanceApplicator {
    public static final String TAG = "TabsAppearanceApplicator";
    private final BottomNavigationView bottomNavigationView;
    private final int[][] states;

    public TabsAppearanceApplicator(BottomNavigationView bottomNavigationView) {
        Intrinsics.checkNotNullParameter(bottomNavigationView, "bottomNavigationView");
        this.bottomNavigationView = bottomNavigationView;
        this.states = new int[][]{new int[]{-16842910}, new int[]{R.attr.state_selected}, new int[]{R.attr.state_focused}, new int[0]};
    }

    /* JADX WARN: Code duplicated, block: B:94:0x0156  */
    public final void updateSharedAppearance(Context context, TabsAppearance tabBarAppearance, boolean isTabBarHidden) {
        int i;
        Boolean tabBarItemActiveIndicatorEnabled;
        Integer tabBarItemActiveIndicatorColor;
        Integer tabBarItemRippleColor;
        ItemStateAppearance normal;
        Integer tabBarItemIconColor;
        ItemStateAppearance selected;
        Integer tabBarItemIconColor2;
        ItemStateAppearance focused;
        Integer tabBarItemIconColor3;
        ItemStateAppearance disabled;
        Integer tabBarItemIconColor4;
        ItemStateAppearance normal2;
        Integer tabBarItemTitleFontColor;
        ItemStateAppearance selected2;
        Integer tabBarItemTitleFontColor2;
        ItemStateAppearance focused2;
        Integer tabBarItemTitleFontColor3;
        ItemStateAppearance disabled2;
        Integer tabBarItemTitleFontColor4;
        Integer tabBarBackgroundColor;
        Intrinsics.checkNotNullParameter(context, "context");
        this.bottomNavigationView.setVisibility(!isTabBarHidden ? 0 : 8);
        this.bottomNavigationView.setBackgroundColor((tabBarAppearance == null || (tabBarBackgroundColor = tabBarAppearance.getTabBarBackgroundColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorSurfaceContainer, 0, 4, null) : tabBarBackgroundColor.intValue());
        this.bottomNavigationView.setItemTextColor(new ColorStateList(this.states, new int[]{(tabBarAppearance == null || (disabled2 = tabBarAppearance.getDisabled()) == null || (tabBarItemTitleFontColor4 = disabled2.getTabBarItemTitleFontColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurfaceVariant, 0, 4, null) : tabBarItemTitleFontColor4.intValue(), (tabBarAppearance == null || (selected2 = tabBarAppearance.getSelected()) == null || (tabBarItemTitleFontColor2 = selected2.getTabBarItemTitleFontColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurface, 0, 4, null) : tabBarItemTitleFontColor2.intValue(), (tabBarAppearance == null || (focused2 = tabBarAppearance.getFocused()) == null || (tabBarItemTitleFontColor3 = focused2.getTabBarItemTitleFontColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurfaceVariant, 0, 4, null) : tabBarItemTitleFontColor3.intValue(), (tabBarAppearance == null || (normal2 = tabBarAppearance.getNormal()) == null || (tabBarItemTitleFontColor = normal2.getTabBarItemTitleFontColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorSecondary, 0, 4, null) : tabBarItemTitleFontColor.intValue()}));
        this.bottomNavigationView.setItemIconTintList(new ColorStateList(this.states, new int[]{(tabBarAppearance == null || (disabled = tabBarAppearance.getDisabled()) == null || (tabBarItemIconColor4 = disabled.getTabBarItemIconColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurfaceVariant, 0, 4, null) : tabBarItemIconColor4.intValue(), (tabBarAppearance == null || (selected = tabBarAppearance.getSelected()) == null || (tabBarItemIconColor2 = selected.getTabBarItemIconColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSecondaryContainer, 0, 4, null) : tabBarItemIconColor2.intValue(), (tabBarAppearance == null || (focused = tabBarAppearance.getFocused()) == null || (tabBarItemIconColor3 = focused.getTabBarItemIconColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurfaceVariant, 0, 4, null) : tabBarItemIconColor3.intValue(), (tabBarAppearance == null || (normal = tabBarAppearance.getNormal()) == null || (tabBarItemIconColor = normal.getTabBarItemIconColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnSurfaceVariant, 0, 4, null) : tabBarItemIconColor.intValue()}));
        String tabBarItemLabelVisibilityMode = tabBarAppearance != null ? tabBarAppearance.getTabBarItemLabelVisibilityMode() : null;
        boolean zBooleanValue = true;
        if (tabBarItemLabelVisibilityMode == null) {
            i = -1;
        } else {
            int iHashCode = tabBarItemLabelVisibilityMode.hashCode();
            if (iHashCode != -63201645) {
                if (iHashCode != 1191572123) {
                    if (iHashCode == 1648599514 && tabBarItemLabelVisibilityMode.equals("unlabeled")) {
                        i = 2;
                    } else {
                        i = -1;
                    }
                } else if (tabBarItemLabelVisibilityMode.equals("selected")) {
                    i = 0;
                } else {
                    i = -1;
                }
            } else if (tabBarItemLabelVisibilityMode.equals("labeled")) {
                i = 1;
            } else {
                i = -1;
            }
        }
        this.bottomNavigationView.setLabelVisibilityMode(i);
        this.bottomNavigationView.setItemRippleColor(ColorStateList.valueOf((tabBarAppearance == null || (tabBarItemRippleColor = tabBarAppearance.getTabBarItemRippleColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.itemRippleColor, 0, 4, null) : tabBarItemRippleColor.intValue()));
        int iResolveColorAttr$default = (tabBarAppearance == null || (tabBarItemActiveIndicatorColor = tabBarAppearance.getTabBarItemActiveIndicatorColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorSecondaryContainer, 0, 4, null) : tabBarItemActiveIndicatorColor.intValue();
        BottomNavigationView bottomNavigationView = this.bottomNavigationView;
        if (tabBarAppearance != null && (tabBarItemActiveIndicatorEnabled = tabBarAppearance.getTabBarItemActiveIndicatorEnabled()) != null) {
            zBooleanValue = tabBarItemActiveIndicatorEnabled.booleanValue();
        }
        bottomNavigationView.setItemActiveIndicatorEnabled(zBooleanValue);
        this.bottomNavigationView.setItemActiveIndicatorColor(ColorStateList.valueOf(iResolveColorAttr$default));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6  */
    public final void updateFontStyles(Context context, TabsAppearance tabBarAppearance) {
        String tabBarItemTitleFontWeight;
        Integer intOrNull;
        String tabBarItemTitleFontFamily;
        float dimension;
        float dimension2;
        Float tabBarItemTitleLargeLabelFontSize;
        Float tabBarItemTitleSmallLabelFontSize;
        Intrinsics.checkNotNullParameter(context, "context");
        View childAt = this.bottomNavigationView.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        for (View view : ViewGroupKt.getChildren((ViewGroup) childAt)) {
            TextView textView = (TextView) view.findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
            TextView textView2 = (TextView) view.findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
            boolean zAreEqual = Intrinsics.areEqual(tabBarAppearance != null ? tabBarAppearance.getTabBarItemTitleFontStyle() : null, "italic");
            int iIntValue = Intrinsics.areEqual(tabBarAppearance != null ? tabBarAppearance.getTabBarItemTitleFontWeight() : null, "bold") ? 700 : (tabBarAppearance == null || (tabBarItemTitleFontWeight = tabBarAppearance.getTabBarItemTitleFontWeight()) == null || (intOrNull = StringsKt.toIntOrNull(tabBarItemTitleFontWeight)) == null) ? 400 : intOrNull.intValue();
            ReactFontManager companion = ReactFontManager.INSTANCE.getInstance();
            if (tabBarAppearance == null || (tabBarItemTitleFontFamily = tabBarAppearance.getTabBarItemTitleFontFamily()) == null) {
                tabBarItemTitleFontFamily = "";
            }
            Typeface typeface = companion.getTypeface(tabBarItemTitleFontFamily, iIntValue, zAreEqual, context.getAssets());
            if (tabBarAppearance == null || (tabBarItemTitleSmallLabelFontSize = tabBarAppearance.getTabBarItemTitleSmallLabelFontSize()) == null) {
                dimension = context.getResources().getDimension(com.google.android.material.R.dimen.design_bottom_navigation_text_size);
            } else {
                if (tabBarItemTitleSmallLabelFontSize.floatValue() <= 0.0f) {
                    tabBarItemTitleSmallLabelFontSize = null;
                }
                if (tabBarItemTitleSmallLabelFontSize != null) {
                    dimension = PixelUtil.toPixelFromSP$default(tabBarItemTitleSmallLabelFontSize.floatValue(), 0.0f, 2, null);
                } else {
                    dimension = context.getResources().getDimension(com.google.android.material.R.dimen.design_bottom_navigation_text_size);
                }
            }
            if (tabBarAppearance == null || (tabBarItemTitleLargeLabelFontSize = tabBarAppearance.getTabBarItemTitleLargeLabelFontSize()) == null) {
                dimension2 = context.getResources().getDimension(com.google.android.material.R.dimen.design_bottom_navigation_text_size);
            } else {
                if (tabBarItemTitleLargeLabelFontSize.floatValue() <= 0.0f) {
                    tabBarItemTitleLargeLabelFontSize = null;
                }
                if (tabBarItemTitleLargeLabelFontSize != null) {
                    dimension2 = PixelUtil.toPixelFromSP$default(tabBarItemTitleLargeLabelFontSize.floatValue(), 0.0f, 2, null);
                } else {
                    dimension2 = context.getResources().getDimension(com.google.android.material.R.dimen.design_bottom_navigation_text_size);
                }
            }
            textView2.setTextSize(0, dimension);
            textView2.setTypeface(typeface);
            textView.setTextSize(0, dimension2);
            textView.setTypeface(typeface);
        }
    }

    public final void updateMenuItemAppearance(MenuItem menuItem, TabsScreen tabsScreen) {
        StateListDrawable icon;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        if (!Intrinsics.areEqual(menuItem.getTitle(), tabsScreen.getTabTitle())) {
            menuItem.setTitle(tabsScreen.getTabTitle());
        }
        if (tabsScreen.getSelectedIcon() != null && tabsScreen.getIcon() != null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] iArr = {R.attr.state_checked};
            Drawable selectedIcon = tabsScreen.getSelectedIcon();
            stateListDrawable.addState(iArr, selectedIcon != null ? selectedIcon.mutate() : null);
            int[] iArr2 = new int[0];
            Drawable icon2 = tabsScreen.getIcon();
            stateListDrawable.addState(iArr2, icon2 != null ? icon2.mutate() : null);
            icon = stateListDrawable;
        } else {
            icon = tabsScreen.getIcon();
        }
        if (Intrinsics.areEqual(menuItem.getIcon(), icon)) {
            return;
        }
        menuItem.setIcon(icon);
    }

    public final void updateBadgeAppearance$react_native_screens_release(Context context, MenuItem menuItem, TabsScreen tabsScreen, TabsAppearance appearance) {
        Integer tabBarItemBadgeBackgroundColor;
        Integer tabBarItemBadgeTextColor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        int itemId = menuItem.getItemId();
        String badgeValue = tabsScreen.getBadgeValue();
        if (badgeValue == null) {
            BadgeDrawable badge = this.bottomNavigationView.getBadge(itemId);
            if (badge != null) {
                badge.setVisible(false);
                return;
            }
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(badgeValue);
        BadgeDrawable orCreateBadge = this.bottomNavigationView.getOrCreateBadge(itemId);
        Intrinsics.checkNotNullExpressionValue(orCreateBadge, "getOrCreateBadge(...)");
        orCreateBadge.setVisible(true);
        orCreateBadge.clearText();
        orCreateBadge.clearNumber();
        if (intOrNull != null) {
            orCreateBadge.setNumber(intOrNull.intValue());
        } else if (!Intrinsics.areEqual(badgeValue, "")) {
            orCreateBadge.setText(badgeValue);
        }
        orCreateBadge.setBadgeTextColor((appearance == null || (tabBarItemBadgeTextColor = appearance.getTabBarItemBadgeTextColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, com.google.android.material.R.attr.colorOnError, 0, 4, null) : tabBarItemBadgeTextColor.intValue());
        orCreateBadge.setBackgroundColor((appearance == null || (tabBarItemBadgeBackgroundColor = appearance.getTabBarItemBadgeBackgroundColor()) == null) ? ColorUtilsKt.resolveColorAttr$default(context, androidx.appcompat.R.attr.colorError, 0, 4, null) : tabBarItemBadgeBackgroundColor.intValue());
    }
}
