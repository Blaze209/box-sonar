package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.l;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.rb;
import com.pspdfkit.internal.x40;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.special_mode.controller.base.SpecialModeController;
import com.pspdfkit.ui.toolbar.grouping.DefaultMenuItemGroupingRule;
import com.pspdfkit.ui.toolbar.grouping.MenuItemGroupingRule;
import com.pspdfkit.ui.toolbar.rx.TranslateSubmenuToolbarCompletableOnSubscribe;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ContextualToolbar<T extends SpecialModeController> extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {
    private static final int CONTEXTUAL_TOOLBAR_ELEVATION_DP = 3;
    public static final int CONTEXTUAL_TOOLBAR_PADDING_DP = 5;
    public static final int DEFAULT_TOOLBAR_HEIGHT = 58;
    public static final int DRAG_BUTTON_ALPHA = 186;
    private static final long MENU_ITEMS_FADE_MS = 60;
    private static final int MIN_CAPACITY_TO_SHOW_DRAG_BUTTON = 4;
    public static final int MIN_TOOLBAR_CAPACITY = 4;
    private static final long SUBMENU_DROP_ANIMATION_MS = 150;
    private static final int SUBMENU_HEIGHT = 58;
    protected ContextualToolbarMenuItem closeButton;
    private rb contextualToolbarStyle;
    protected ToolbarCoordinatorLayoutController coordinatorController;
    private ContextualToolbarMenuItem currentlySelectedMenuItem;
    private ContextualToolbarMenuItem dragButton;
    private MenuItemGroupingRule groupingRule;
    private boolean isAttached;
    private boolean isDraggable;
    private final boolean isStylusConnected;
    private ToolbarCoordinatorLayout.LayoutParams.Position lastPosition;
    private ContextualToolbarMenuBar mainMenuBar;
    private int mainMenuBarBackgroundColor;
    private List<ContextualToolbarMenuItem> menuItems;
    private OnMenuItemClickListener onMenuItemClickListener;
    private OnMenuItemLongClickListener onMenuItemLongClickListener;
    final View.OnLayoutChangeListener onToolbarLayoutChangeListener;
    private ContextualToolbarMenuItem openedSubmenuParentMenuItem;
    protected List<ContextualToolbarMenuItem> originalMenuItems;
    protected final PSPDFKitPreferences preferences;
    private boolean requestLayoutPending;
    private boolean showDragButton;
    protected ContextualToolbarMenuItem stylusButton;
    private final Map<ContextualToolbarMenuItem, ContextualToolbarSubMenu> submenuMap;
    private boolean useBackButtonForCloseWhenHorizontal;

    public class DragButtonOnTouchListener implements View.OnTouchListener {
        private DragButtonOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ToolbarCoordinatorLayoutController toolbarCoordinatorLayoutController;
            ToolbarCoordinatorLayoutController toolbarCoordinatorLayoutController2;
            if (ContextualToolbar.this.coordinatorController == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 && ContextualToolbar.this.isAttached() && (toolbarCoordinatorLayoutController2 = ContextualToolbar.this.coordinatorController) != null) {
                toolbarCoordinatorLayoutController2.detachContextualToolbar();
            } else if (actionMasked == 1 && !ContextualToolbar.this.isAttached() && (toolbarCoordinatorLayoutController = ContextualToolbar.this.coordinatorController) != null) {
                toolbarCoordinatorLayoutController.attachContextualToolbar();
            }
            return true;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onToolbarMenuItemClick(ContextualToolbar contextualToolbar, ContextualToolbarMenuItem contextualToolbarMenuItem);
    }

    public interface OnMenuItemLongClickListener {
        boolean onToolbarMenuItemLongClick(ContextualToolbar contextualToolbar, ContextualToolbarMenuItem contextualToolbarMenuItem);
    }

    public ContextualToolbar(Context context) {
        super(context);
        this.originalMenuItems = new ArrayList();
        this.menuItems = new ArrayList();
        this.currentlySelectedMenuItem = null;
        this.submenuMap = new HashMap();
        this.isDraggable = false;
        this.showDragButton = true;
        this.isAttached = true;
        this.useBackButtonForCloseWhenHorizontal = true;
        this.requestLayoutPending = false;
        this.preferences = PSPDFKitPreferences.get(getContext());
        this.isStylusConnected = x40.a();
        this.onToolbarLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$new$0(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        init(context);
    }

    private void addMenuItemsAsViews(List<ContextualToolbarMenuItem> list) {
        int iEstimateItemCapacity = ContextualToolbarMenuBar.estimateItemCapacity(getContext(), isHorizontal() ? getWidth() : getHeight());
        int i = iEstimateItemCapacity - 2;
        boolean z = this.isStylusConnected && shouldShowStylusButton();
        if (z) {
            i = iEstimateItemCapacity - 3;
        }
        boolean z2 = isDraggable() && i >= 4;
        this.showDragButton = z2;
        if (!z2) {
            i++;
        }
        int iMax = Math.max(i, 4);
        MenuItemGroupingRule menuItemGroupingRule = this.groupingRule;
        if (menuItemGroupingRule != null && iMax > 0) {
            list = menuItemGroupingRule.groupMenuItems(list, iMax);
        }
        List<ContextualToolbarMenuItem> listOnMenuItemsGrouped = onMenuItemsGrouped(list);
        for (ContextualToolbarSubMenu contextualToolbarSubMenu : this.submenuMap.values()) {
            contextualToolbarSubMenu.removeAllViews();
            removeView(contextualToolbarSubMenu);
        }
        this.mainMenuBar.removeAllViews();
        this.submenuMap.clear();
        this.openedSubmenuParentMenuItem = null;
        int iIndexOf = -1;
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : listOnMenuItemsGrouped) {
            contextualToolbarMenuItem.setOnClickListener(this);
            if (contextualToolbarMenuItem.getId() == R.id.pspdf__annotation_toolbar_item_picker) {
                iIndexOf = listOnMenuItemsGrouped.indexOf(contextualToolbarMenuItem) + 1;
            }
            List<ContextualToolbarMenuItem> subMenuItems = contextualToolbarMenuItem.getSubMenuItems();
            if (subMenuItems != null && !subMenuItems.isEmpty()) {
                contextualToolbarMenuItem.setOnLongClickListener(this);
                ContextualToolbarSubMenu contextualToolbarSubMenu2 = new ContextualToolbarSubMenu(getContext());
                contextualToolbarSubMenu2.setMenuItems(subMenuItems);
                this.submenuMap.put(contextualToolbarMenuItem, contextualToolbarSubMenu2);
                contextualToolbarSubMenu2.setDescendantFocusability(393216);
                addView(contextualToolbarSubMenu2, 0);
                Iterator<ContextualToolbarMenuItem> it = subMenuItems.iterator();
                while (it.hasNext()) {
                    it.next().setOnClickListener(this);
                }
            }
        }
        ArrayList arrayList = new ArrayList(listOnMenuItemsGrouped.size() + 3);
        if (this.useBackButtonForCloseWhenHorizontal && isHorizontal()) {
            arrayList.add(this.closeButton);
            arrayList.addAll(listOnMenuItemsGrouped);
        } else {
            arrayList.addAll(listOnMenuItemsGrouped);
            arrayList.add(this.closeButton);
        }
        if (z && iIndexOf > 0) {
            arrayList.add(iIndexOf, this.stylusButton);
        }
        arrayList.add(this.dragButton);
        refreshDragButtonVisibility();
        this.mainMenuBar.setMenuItems(arrayList);
        this.mainMenuBar.showMenuItems(false).subscribe();
        this.menuItems = listOnMenuItemsGrouped;
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = this.currentlySelectedMenuItem;
        if (contextualToolbarMenuItem2 != null) {
            selectMenuItem(contextualToolbarMenuItem2);
        } else {
            deselectCurrentMenuItem();
        }
        this.requestLayoutPending = true;
    }

    private Completable closeSubmenu(final ContextualToolbarSubMenu contextualToolbarSubMenu) {
        return Completable.create(new TranslateSubmenuToolbarCompletableOnSubscribe(contextualToolbarSubMenu, getSubmenuTranslationX(false), getSubmenuTranslationY(false), 150L, new DecelerateInterpolator())).doOnSubscribe(new Consumer() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                contextualToolbarSubMenu.setDescendantFocusability(393216);
            }
        });
    }

    private ContextualToolbarSubMenu getOpenedSubmenuBar() {
        ContextualToolbarMenuItem contextualToolbarMenuItem = this.openedSubmenuParentMenuItem;
        if (contextualToolbarMenuItem == null) {
            return null;
        }
        return this.submenuMap.get(contextualToolbarMenuItem);
    }

    private int getSubmenuTranslationX(boolean z) {
        ToolbarCoordinatorLayout.LayoutParams layoutParams;
        if (!z || (layoutParams = (ToolbarCoordinatorLayout.LayoutParams) getLayoutParams()) == null) {
            return 0;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position = layoutParams.forcedPosition;
        if (position == null) {
            position = layoutParams.position;
        }
        int submenuSizePx = getSubmenuSizePx() - a80.a(getContext(), 1);
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT) {
            return submenuSizePx;
        }
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            return -submenuSizePx;
        }
        return 0;
    }

    private int getSubmenuTranslationY(boolean z) {
        ToolbarCoordinatorLayout.LayoutParams layoutParams;
        if (!z || (layoutParams = (ToolbarCoordinatorLayout.LayoutParams) getLayoutParams()) == null) {
            return 0;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position = layoutParams.forcedPosition;
        if (position == null) {
            position = layoutParams.position;
        }
        int submenuSizePx = getSubmenuSizePx();
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT || position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            return 0;
        }
        return submenuSizePx;
    }

    private void handleSubmenuBasedOnClickedMainMenuItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        if (contextualToolbarMenuItem.hasSubmenu() && contextualToolbarMenuItem.shouldOpenSubmenuOnClick() && !contextualToolbarMenuItem.isSelectable() && contextualToolbarMenuItem != this.openedSubmenuParentMenuItem) {
            openSubmenuForItem(contextualToolbarMenuItem).subscribe();
            return;
        }
        ContextualToolbarMenuItem contextualToolbarMenuItem2 = this.openedSubmenuParentMenuItem;
        if (contextualToolbarMenuItem2 == null || !contextualToolbarMenuItem2.shouldCloseSubmenuOnItemClick(contextualToolbarMenuItem)) {
            return;
        }
        closeSubmenuForItem(this.openedSubmenuParentMenuItem).subscribe();
    }

    private void handleSubmenuBasedOnLongClickedMainMenuItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        ContextualToolbarMenuItem contextualToolbarMenuItem2;
        if ((!this.submenuMap.containsKey(contextualToolbarMenuItem) || contextualToolbarMenuItem == this.openedSubmenuParentMenuItem) && (contextualToolbarMenuItem2 = this.openedSubmenuParentMenuItem) != null) {
            closeSubmenuForItem(contextualToolbarMenuItem2).subscribe();
        } else {
            openSubmenuForItem(contextualToolbarMenuItem).subscribe();
        }
    }

    private void init(Context context) {
        this.contextualToolbarStyle = (rb) new l(getContext()).b.getValue();
        setWillNotDraw(false);
        this.groupingRule = new DefaultMenuItemGroupingRule(getContext());
        int i = R.id.pspdf__toolbar_close_button;
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.pspdf__ic_close_circled);
        String strA = no.a(getContext(), R.string.pspdf__close, null);
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.END;
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, i, drawable, strA, -1, -1, position, false);
        this.closeButton = contextualToolbarMenuItemCreateSingleItem;
        contextualToolbarMenuItemCreateSingleItem.setUseAlternateBackground(getUseAlternateBackground());
        this.closeButton.setOnClickListener(this);
        updateCloseButton();
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__annotation_toolbar_item_stylus, (Drawable) Objects.requireNonNull(AppCompatResources.getDrawable(context, R.drawable.pspdf__ic_pen_connected)), no.a(getContext(), R.string.pspdf__use_stylus_for_annotating, null), -16777216, -16777216, position, true);
        this.stylusButton = contextualToolbarMenuItemCreateSingleItem2;
        contextualToolbarMenuItemCreateSingleItem2.setSelected(this.preferences.useStylusForAnnotating().booleanValue());
        this.stylusButton.setUseAlternateBackground(getUseAlternateBackground());
        this.stylusButton.setOnClickListener(this);
        int iArgb = Color.argb(Token.LET, 255, 255, 255);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem3 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__toolbar_drag_button, AppCompatResources.getDrawable(context, R.drawable.pspdf__ic_drag_handle), "", iArgb, iArgb, position, false);
        this.dragButton = contextualToolbarMenuItemCreateSingleItem3;
        contextualToolbarMenuItemCreateSingleItem3.setUseAlternateBackground(getUseAlternateBackground());
        this.dragButton.setFocusable(false);
        this.dragButton.setOnTouchListener(new DragButtonOnTouchListener());
        ContextualToolbarMenuBar contextualToolbarMenuBar = new ContextualToolbarMenuBar(context);
        this.mainMenuBar = contextualToolbarMenuBar;
        addView(contextualToolbarMenuBar);
        if (this.isDraggable) {
            this.mainMenuBar.setOnTouchListener(new DragButtonOnTouchListener());
        }
        updateMenuBars();
        setFocusable(true);
        setDescendantFocusability(131072);
    }

    private boolean isHorizontal() {
        return getWidth() >= getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        updateCloseButton();
        updateElevation();
        updateMenuBars();
        if (getLayoutParams() instanceof ToolbarCoordinatorLayout.LayoutParams) {
            this.preferences.setLastToolbarPosition(this, ((ToolbarCoordinatorLayout.LayoutParams) getLayoutParams()).position);
        }
        if ((i == i5 && i2 == i6 && i3 == i7 && i4 == i8) || this.originalMenuItems.isEmpty()) {
            return;
        }
        addMenuItemsAsViews(this.originalMenuItems);
    }

    static /* synthetic */ void lambda$setMenuItemVisibility$1(ContextualToolbarMenuItem contextualToolbarMenuItem, int i) {
        if (contextualToolbarMenuItem.getRequestedVisibility() == i) {
            contextualToolbarMenuItem.setVisibility(i);
            contextualToolbarMenuItem.setScaleX(1.0f);
            contextualToolbarMenuItem.setScaleY(1.0f);
        }
    }

    private void layoutSubmenu(ToolbarCoordinatorLayout.LayoutParams.Position position, ContextualToolbarMenuItem contextualToolbarMenuItem, ContextualToolbarSubMenu contextualToolbarSubMenu) {
        int measuredWidth = (contextualToolbarMenuItem.getMeasuredWidth() / 2) + ((int) contextualToolbarMenuItem.getX());
        int measuredHeight = (contextualToolbarMenuItem.getMeasuredHeight() / 2) + ((int) contextualToolbarMenuItem.getY());
        int cornerRadiusPx = this.mainMenuBar.getCornerRadiusPx();
        int measuredWidth2 = contextualToolbarSubMenu.getMeasuredWidth();
        int measuredHeight2 = contextualToolbarSubMenu.getMeasuredHeight();
        Rect rect = new Rect();
        ToolbarCoordinatorLayout.LayoutParams.Position position2 = ToolbarCoordinatorLayout.LayoutParams.Position.LEFT;
        if (position == position2) {
            int measuredWidth3 = getMeasuredWidth() - measuredWidth2;
            int i = (measuredHeight - (measuredHeight2 / 2)) + cornerRadiusPx;
            rect.set(measuredWidth3 - measuredWidth2, i, measuredWidth3, measuredHeight2 + i);
        } else if (position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            int i2 = (measuredHeight - (measuredHeight2 / 2)) + cornerRadiusPx;
            rect.set(measuredWidth2, i2, measuredWidth2 + measuredWidth2, measuredHeight2 + i2);
        } else {
            int i3 = measuredWidth - (measuredWidth2 / 2);
            int measuredHeight3 = getMeasuredHeight() - measuredHeight2;
            rect.set(i3, measuredHeight3 - measuredHeight2, measuredWidth2 + i3, measuredHeight3);
        }
        if (position == position2 || position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            int i4 = rect.top;
            if (i4 < cornerRadiusPx) {
                rect.offset(0, cornerRadiusPx - i4);
            } else if (rect.bottom > this.mainMenuBar.getHeight() - cornerRadiusPx) {
                rect.offset(0, -(rect.bottom - (this.mainMenuBar.getHeight() - cornerRadiusPx)));
            }
        } else {
            int i5 = rect.left;
            if (i5 < cornerRadiusPx) {
                rect.offset(cornerRadiusPx - i5, 0);
            } else if (rect.right > getMeasuredWidth() - cornerRadiusPx) {
                rect.offset(-(rect.right - (getMeasuredWidth() - cornerRadiusPx)), 0);
            }
        }
        contextualToolbarSubMenu.layout(rect.left, rect.top, rect.right, rect.bottom);
    }

    private Completable openSubmenu(final ContextualToolbarSubMenu contextualToolbarSubMenu) {
        return Completable.create(new TranslateSubmenuToolbarCompletableOnSubscribe(contextualToolbarSubMenu, getSubmenuTranslationX(true), getSubmenuTranslationY(true), 150L, new DecelerateInterpolator())).doFinally(new Action() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                contextualToolbarSubMenu.setDescendantFocusability(262144);
            }
        });
    }

    private void refreshDragButtonVisibility() {
        this.dragButton.setVisibility((this.isDraggable && this.showDragButton) ? 0 : 8);
    }

    private void updateCloseButton() {
        this.closeButton.setPosition(this.useBackButtonForCloseWhenHorizontal ? ContextualToolbarMenuItem.Position.START : ContextualToolbarMenuItem.Position.END);
        Drawable drawable = AppCompatResources.getDrawable(getContext(), (isHorizontal() && this.useBackButtonForCloseWhenHorizontal) ? R.drawable.pspdf__ic_arrow_back : R.drawable.pspdf__ic_close_circled);
        if (drawable != null) {
            this.closeButton.setIcon(drawable);
        }
    }

    private void updateElevation() {
        updateSubmenuElevation();
        ViewCompat.setElevation(this.mainMenuBar, a80.a(getContext(), 3));
    }

    private void updateMenuBars() {
        rb rbVar = this.contextualToolbarStyle;
        int i = rbVar.a;
        this.mainMenuBarBackgroundColor = i;
        this.mainMenuBar.setBorderAndBackgroundColor(rbVar.b, i);
        Iterator<Map.Entry<ContextualToolbarMenuItem, ContextualToolbarSubMenu>> it = this.submenuMap.entrySet().iterator();
        while (it.hasNext()) {
            ContextualToolbarSubMenu value = it.next().getValue();
            rb rbVar2 = this.contextualToolbarStyle;
            value.setBorderAndBackroundColor(rbVar2.d, rbVar2.c);
        }
    }

    private void updateSubmenuElevation() {
        Iterator<Map.Entry<ContextualToolbarMenuItem, ContextualToolbarSubMenu>> it = this.submenuMap.entrySet().iterator();
        while (it.hasNext()) {
            ViewCompat.setElevation(it.next().getValue(), 0.0f);
        }
        if (getOpenedSubmenuBar() != null) {
            ViewCompat.setElevation(getOpenedSubmenuBar(), a80.a(getContext(), 2));
        }
    }

    public abstract void bindController(T t);

    public Completable closeSubmenuForItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        ContextualToolbarMenuItem contextualToolbarMenuItem2;
        if (!this.submenuMap.containsKey(contextualToolbarMenuItem) || (contextualToolbarMenuItem2 = this.openedSubmenuParentMenuItem) != contextualToolbarMenuItem) {
            return Completable.complete();
        }
        ContextualToolbarSubMenu contextualToolbarSubMenu = this.submenuMap.get(contextualToolbarMenuItem2);
        this.openedSubmenuParentMenuItem = null;
        updateSubmenuElevation();
        return contextualToolbarSubMenu != null ? contextualToolbarSubMenu.hideMenuItems(true).andThen(closeSubmenu(contextualToolbarSubMenu)) : Completable.complete();
    }

    public void deselectCurrentMenuItem() {
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : this.menuItems) {
            if (contextualToolbarMenuItem.isSelected()) {
                contextualToolbarMenuItem.setSelected(false);
            } else if (contextualToolbarMenuItem.getSubMenuItems() != null && !contextualToolbarMenuItem.getSubMenuItems().isEmpty()) {
                for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : contextualToolbarMenuItem.getSubMenuItems()) {
                    if (contextualToolbarMenuItem2.isSelected()) {
                        contextualToolbarMenuItem2.setSelected(false);
                    }
                }
            }
        }
        this.currentlySelectedMenuItem = null;
    }

    public ContextualToolbarMenuItem findItemById(int i) {
        return findItemById(i, this.menuItems);
    }

    public ContextualToolbarMenuItem getCloseButton() {
        return this.closeButton;
    }

    public ContextualToolbarMenuItem getCurrentlySelectedMenuItem() {
        return this.currentlySelectedMenuItem;
    }

    public int getDefaultIconsColor() {
        return this.contextualToolbarStyle.e;
    }

    public int getDefaultIconsColorActivated() {
        return this.contextualToolbarStyle.f;
    }

    public ContextualToolbarMenuItem getDragButton() {
        return this.dragButton;
    }

    public List<ContextualToolbarMenuItem> getGroupedMenuItems() {
        return this.menuItems;
    }

    public List<ContextualToolbarMenuItem> getMenuItems() {
        return this.originalMenuItems;
    }

    public int getParentMenuId(int i) {
        for (Map.Entry<ContextualToolbarMenuItem, ContextualToolbarSubMenu> entry : this.submenuMap.entrySet()) {
            if (entry.getKey().getId() == i) {
                return i;
            }
            Iterator<ContextualToolbarMenuItem> it = entry.getValue().getMenuBar().getMenuItems().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == i) {
                    return entry.getKey().getId();
                }
            }
        }
        return 0;
    }

    public ToolbarCoordinatorLayout.LayoutParams.Position getPosition() {
        ToolbarCoordinatorLayout.LayoutParams layoutParams = (ToolbarCoordinatorLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            return ToolbarCoordinatorLayout.LayoutParams.DEFAULT_POSITION;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position = layoutParams.forcedPosition;
        return position != null ? position : layoutParams.position;
    }

    public int getStatusBarColor() {
        return this.mainMenuBarBackgroundColor;
    }

    public int getSubmenuSizePx() {
        return a80.a(getContext(), 58);
    }

    public boolean getUseAlternateBackground() {
        return false;
    }

    public abstract void handleMenuItemClick(ContextualToolbarMenuItem contextualToolbarMenuItem);

    public boolean hasOpenedSubmenu() {
        return this.openedSubmenuParentMenuItem != null;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public abstract boolean isControllerBound();

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public void notifyToolbarChanged() {
        ToolbarCoordinatorLayoutController toolbarCoordinatorLayoutController = this.coordinatorController;
        if (toolbarCoordinatorLayoutController != null) {
            toolbarCoordinatorLayoutController.onContextualToolbarChanged(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnLayoutChangeListener(this.onToolbarLayoutChangeListener);
    }

    public boolean onBackPressed() {
        this.closeButton.callOnClick();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof ContextualToolbarMenuItem) {
            ContextualToolbarMenuItem contextualToolbarMenuItem = (ContextualToolbarMenuItem) view;
            if (isControllerBound() && !onMenuItemClick(contextualToolbarMenuItem)) {
                if (contextualToolbarMenuItem != this.stylusButton) {
                    handleMenuItemClick(contextualToolbarMenuItem);
                } else {
                    this.preferences.setUseStylusForAnnotating(!contextualToolbarMenuItem.isSelected());
                    this.stylusButton.setSelected(this.preferences.useStylusForAnnotating().booleanValue());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.onToolbarLayoutChangeListener);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.requestLayoutPending) {
            requestLayout();
            this.requestLayoutPending = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ToolbarCoordinatorLayout.LayoutParams.Position position = getPosition();
        if (position == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT) {
            ContextualToolbarMenuBar contextualToolbarMenuBar = this.mainMenuBar;
            contextualToolbarMenuBar.layout(0, 0, contextualToolbarMenuBar.getMeasuredWidth(), this.mainMenuBar.getMeasuredHeight());
        } else {
            ToolbarCoordinatorLayout.LayoutParams.Position position2 = ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT;
            ContextualToolbarMenuBar contextualToolbarMenuBar2 = this.mainMenuBar;
            if (position == position2) {
                contextualToolbarMenuBar2.layout(getMeasuredWidth() - this.mainMenuBar.getMeasuredWidth(), 0, getMeasuredWidth(), this.mainMenuBar.getMeasuredHeight());
            } else {
                contextualToolbarMenuBar2.layout(0, 0, contextualToolbarMenuBar2.getMeasuredWidth(), this.mainMenuBar.getMeasuredHeight());
            }
        }
        for (Map.Entry<ContextualToolbarMenuItem, ContextualToolbarSubMenu> entry : this.submenuMap.entrySet()) {
            layoutSubmenu(position, entry.getKey(), entry.getValue());
        }
        if (z && getOpenedSubmenuBar() != null) {
            getOpenedSubmenuBar().setTranslationX(getSubmenuTranslationX(true));
            getOpenedSubmenuBar().setTranslationY(getSubmenuTranslationY(true));
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position3 = this.lastPosition;
        if (position3 != position) {
            ToolbarCoordinatorLayoutController toolbarCoordinatorLayoutController = this.coordinatorController;
            if (toolbarCoordinatorLayoutController != null) {
                toolbarCoordinatorLayoutController.onContextualToolbarPositionChanged(this, position3, position);
            }
            this.lastPosition = position;
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view instanceof ContextualToolbarMenuItem) {
            return onMenuItemLongClick((ContextualToolbarMenuItem) view);
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int submenuSizePx;
        int measuredHeight;
        super.onMeasure(i, i2);
        ToolbarCoordinatorLayout.LayoutParams layoutParams = (ToolbarCoordinatorLayout.LayoutParams) getLayoutParams();
        ToolbarCoordinatorLayout.LayoutParams.Position position = layoutParams.forcedPosition;
        if (position == null) {
            position = layoutParams.position;
        }
        ToolbarCoordinatorLayout.LayoutParams.Position position2 = ToolbarCoordinatorLayout.LayoutParams.Position.LEFT;
        if (position == position2 || position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            measuredWidth = getMeasuredWidth();
            this.mainMenuBar.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
        } else {
            measuredWidth = getMeasuredWidth();
            this.mainMenuBar.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getSubmenuSizePx(), 1073741824));
        }
        if (position == position2 || position == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT) {
            submenuSizePx = getSubmenuSizePx();
            measuredHeight = this.mainMenuBar.getMeasuredHeight() - (this.mainMenuBar.getCornerRadiusPx() * 2);
        } else {
            submenuSizePx = measuredWidth - (this.mainMenuBar.getCornerRadiusPx() * 2);
            measuredHeight = getSubmenuSizePx();
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != this.mainMenuBar) {
                ToolbarCoordinatorLayout.LayoutParams.Position position3 = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(submenuSizePx, position == position3 ? Integer.MIN_VALUE : 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, position == position3 ? 1073741824 : Integer.MIN_VALUE));
            }
        }
    }

    public boolean onMenuItemClick(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        OnMenuItemClickListener onMenuItemClickListener = this.onMenuItemClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onToolbarMenuItemClick(this, contextualToolbarMenuItem)) {
            return true;
        }
        if (!contextualToolbarMenuItem.isSelectable()) {
            handleSubmenuBasedOnClickedMainMenuItem(contextualToolbarMenuItem);
            return false;
        }
        if (this.menuItems.contains(contextualToolbarMenuItem)) {
            selectMenuItem(contextualToolbarMenuItem.getDefaultSelectedMenuItem() != null ? contextualToolbarMenuItem.getDefaultSelectedMenuItem() : contextualToolbarMenuItem);
            handleSubmenuBasedOnClickedMainMenuItem(contextualToolbarMenuItem);
            return false;
        }
        ContextualToolbarSubMenu openedSubmenuBar = getOpenedSubmenuBar();
        if (openedSubmenuBar == null) {
            return false;
        }
        openedSubmenuBar.hideMenuItems(true).andThen(closeSubmenu(openedSubmenuBar)).subscribe();
        this.openedSubmenuParentMenuItem = null;
        return false;
    }

    public boolean onMenuItemLongClick(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        OnMenuItemLongClickListener onMenuItemLongClickListener = this.onMenuItemLongClickListener;
        if (onMenuItemLongClickListener != null && onMenuItemLongClickListener.onToolbarMenuItemLongClick(this, contextualToolbarMenuItem)) {
            return true;
        }
        if (!this.menuItems.contains(contextualToolbarMenuItem) || !contextualToolbarMenuItem.hasSubmenu()) {
            return false;
        }
        handleSubmenuBasedOnLongClickedMainMenuItem(contextualToolbarMenuItem);
        return true;
    }

    public List<ContextualToolbarMenuItem> onMenuItemsGrouped(List<ContextualToolbarMenuItem> list) {
        return list;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public Completable openSubmenuForItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        ContextualToolbarMenuItem contextualToolbarMenuItem2;
        if (!contextualToolbarMenuItem.hasSubmenu() || ((contextualToolbarMenuItem2 = this.openedSubmenuParentMenuItem) != null && contextualToolbarMenuItem2 == contextualToolbarMenuItem)) {
            return Completable.complete();
        }
        Map<ContextualToolbarMenuItem, ContextualToolbarSubMenu> map = this.submenuMap;
        if (contextualToolbarMenuItem2 == null) {
            ContextualToolbarSubMenu contextualToolbarSubMenu = map.get(contextualToolbarMenuItem);
            this.openedSubmenuParentMenuItem = contextualToolbarMenuItem;
            updateSubmenuElevation();
            return openSubmenu(contextualToolbarSubMenu).andThen(contextualToolbarSubMenu.showMenuItems(true));
        }
        ContextualToolbarSubMenu contextualToolbarSubMenu2 = map.get(contextualToolbarMenuItem2);
        ContextualToolbarSubMenu contextualToolbarSubMenu3 = this.submenuMap.get(contextualToolbarMenuItem);
        this.openedSubmenuParentMenuItem = contextualToolbarMenuItem;
        updateSubmenuElevation();
        return contextualToolbarSubMenu2.hideMenuItems(true).andThen(closeSubmenu(contextualToolbarSubMenu2)).andThen(openSubmenu(contextualToolbarSubMenu3)).andThen(contextualToolbarSubMenu3.showMenuItems(true));
    }

    public boolean selectMenuItem(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        deselectCurrentMenuItem();
        if (this.menuItems.contains(contextualToolbarMenuItem)) {
            this.currentlySelectedMenuItem = contextualToolbarMenuItem;
            contextualToolbarMenuItem.setSelected(true);
        } else {
            for (ContextualToolbarMenuItem contextualToolbarMenuItem2 : this.menuItems) {
                if (contextualToolbarMenuItem2.getSubMenuItems() != null && contextualToolbarMenuItem2.getSubMenuItems().contains(contextualToolbarMenuItem)) {
                    this.currentlySelectedMenuItem = contextualToolbarMenuItem;
                    contextualToolbarMenuItem2.setSelected(true);
                    contextualToolbarMenuItem2.setDefaultSelectedMenuItem(contextualToolbarMenuItem);
                }
            }
        }
        return true;
    }

    public final void setAttached(boolean z) {
        this.isAttached = z;
        invalidate();
    }

    public void setCloseButton(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        this.closeButton = contextualToolbarMenuItem;
        requestLayout();
    }

    public void setDragButton(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        this.dragButton = contextualToolbarMenuItem;
        requestLayout();
    }

    public void setDragButtonColor(int i) {
        this.dragButton.setIconColor(Color.argb(DRAG_BUTTON_ALPHA, Color.red(i), Color.green(i), Color.blue(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setDraggable(boolean z) {
        if (this.isDraggable == z) {
            return;
        }
        this.isDraggable = z;
        refreshDragButtonVisibility();
        this.mainMenuBar.setOnTouchListener(this.isDraggable ? new DragButtonOnTouchListener() : null);
    }

    public boolean setMenuItemEnabled(int i, boolean z) {
        ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById = findItemById(i);
        if (contextualToolbarMenuItemFindItemById == null) {
            return false;
        }
        contextualToolbarMenuItemFindItemById.setEnabled(z);
        return true;
    }

    public void setMenuItemGroupingRule(MenuItemGroupingRule menuItemGroupingRule) {
        this.groupingRule = menuItemGroupingRule;
        setMenuItems(this.originalMenuItems);
    }

    public boolean setMenuItemVisibility(int i, final int i2) {
        final ContextualToolbarMenuItem contextualToolbarMenuItemFindItemById = findItemById(i);
        if (contextualToolbarMenuItemFindItemById == null) {
            return false;
        }
        if (contextualToolbarMenuItemFindItemById.getVisibility() == 8 || i2 == 8) {
            contextualToolbarMenuItemFindItemById.setVisibility(i2);
            return true;
        }
        if (contextualToolbarMenuItemFindItemById.getVisibility() == 0 && i2 == 4) {
            contextualToolbarMenuItemFindItemById.setRequestedVisibility(i2);
            contextualToolbarMenuItemFindItemById.animate().alpha(0.0f).scaleY(0.5f).scaleX(0.5f).setInterpolator(new AccelerateInterpolator()).setDuration(60L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ContextualToolbar.lambda$setMenuItemVisibility$1(contextualToolbarMenuItemFindItemById, i2);
                }
            });
            return true;
        }
        if (contextualToolbarMenuItemFindItemById.getVisibility() != 4 || i2 != 0) {
            return true;
        }
        contextualToolbarMenuItemFindItemById.setVisibility(i2);
        contextualToolbarMenuItemFindItemById.setScaleX(0.5f);
        contextualToolbarMenuItemFindItemById.setScaleY(0.5f);
        contextualToolbarMenuItemFindItemById.setAlpha(0.0f);
        contextualToolbarMenuItemFindItemById.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new DecelerateInterpolator()).setDuration(60L);
        return true;
    }

    public void setMenuItems(List<ContextualToolbarMenuItem> list) {
        this.originalMenuItems = list;
        addMenuItemsAsViews(list);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnMenuItemLongClickListener(OnMenuItemLongClickListener onMenuItemLongClickListener) {
        this.onMenuItemLongClickListener = onMenuItemLongClickListener;
    }

    public void setPosition(ToolbarCoordinatorLayout.LayoutParams.Position position) {
        boolean z = this.isDraggable;
        if (!z) {
            position = ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        }
        setLayoutParams(new ToolbarCoordinatorLayout.LayoutParams(position, z ? EnumSet.allOf(ToolbarCoordinatorLayout.LayoutParams.Position.class) : EnumSet.of(ToolbarCoordinatorLayout.LayoutParams.Position.TOP)));
    }

    public void setToolbarCoordinatorController(ToolbarCoordinatorLayoutController toolbarCoordinatorLayoutController) {
        this.coordinatorController = toolbarCoordinatorLayoutController;
    }

    public void setUseBackButtonForCloseWhenHorizontal(boolean z) {
        this.useBackButtonForCloseWhenHorizontal = z;
        updateCloseButton();
    }

    public boolean shouldShowStylusButton() {
        return false;
    }

    public abstract void unbindController();

    public ContextualToolbarMenuItem findItemById(int i, List<ContextualToolbarMenuItem> list) {
        for (ContextualToolbarMenuItem contextualToolbarMenuItem : list) {
            if (contextualToolbarMenuItem.getId() == i) {
                return contextualToolbarMenuItem;
            }
            if (contextualToolbarMenuItem.getSubMenuItems() != null && findItemById(i, contextualToolbarMenuItem.getSubMenuItems()) != null) {
                return findItemById(i, contextualToolbarMenuItem.getSubMenuItems());
            }
        }
        return null;
    }

    public ContextualToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.originalMenuItems = new ArrayList();
        this.menuItems = new ArrayList();
        this.currentlySelectedMenuItem = null;
        this.submenuMap = new HashMap();
        this.isDraggable = false;
        this.showDragButton = true;
        this.isAttached = true;
        this.useBackButtonForCloseWhenHorizontal = true;
        this.requestLayoutPending = false;
        this.preferences = PSPDFKitPreferences.get(getContext());
        this.isStylusConnected = x40.a();
        this.onToolbarLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$new$0(view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        init(context);
    }

    public ContextualToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.originalMenuItems = new ArrayList();
        this.menuItems = new ArrayList();
        this.currentlySelectedMenuItem = null;
        this.submenuMap = new HashMap();
        this.isDraggable = false;
        this.showDragButton = true;
        this.isAttached = true;
        this.useBackButtonForCloseWhenHorizontal = true;
        this.requestLayoutPending = false;
        this.preferences = PSPDFKitPreferences.get(getContext());
        this.isStylusConnected = x40.a();
        this.onToolbarLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.ui.toolbar.ContextualToolbar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                this.f$0.lambda$new$0(view, i2, i3, i4, i5, i6, i7, i8, i9);
            }
        };
        init(context);
    }
}
