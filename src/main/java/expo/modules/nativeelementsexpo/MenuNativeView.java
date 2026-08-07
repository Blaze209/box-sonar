package expo.modules.nativeelementsexpo;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.widget.MAMListPopupWindow;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.viewevent.ViewEventDelegateKt;
import expo.modules.kotlin.views.ExpoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MenuNativeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0011H\u0002J\u001e\u00100\u001a\u00020*2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u00020\u0011H\u0002J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u000208H\u0002J\u001c\u00109\u001a\b\u0012\u0004\u0012\u000203022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000202H\u0002J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020\u0011H\u0002J\u0014\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\u0018H\u0002J\b\u0010D\u001a\u00020*H\u0016J\u0010\u0010E\u001a\u00020*2\u0006\u00106\u001a\u00020\u000bH\u0002J\u0016\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0018J\u000e\u0010J\u001a\u00020*2\u0006\u0010G\u001a\u00020HJ\u000e\u0010K\u001a\u00020*2\u0006\u0010I\u001a\u00020\u0018R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR-\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001f¨\u0006M"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuNativeView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/nativeelementsexpo/MenuAction;", "Lexpo/modules/nativeelementsexpo/MenuUpdatable;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "mPopupWindow", "Landroid/widget/ListPopupWindow;", "mAdapter", "Lexpo/modules/nativeelementsexpo/MenuListAdapter;", "mGestureDetector", "Landroid/view/GestureDetector;", "isMenuShowing", "", "skipNextDismissLifecycle", "actions", "", "getActions", "()Ljava/util/List;", "nonMenuChildCount", "", "onMenuOpen", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "", "", "getOnMenuOpen", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onMenuOpen$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onMenuDismiss", "getOnMenuDismiss", "onMenuDismiss$delegate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "prepareMenu", "", "showSubmenuPopup", "submenuItem", "Lexpo/modules/nativeelementsexpo/MenuListItem$Submenu;", "closeMenuState", "notifyDismiss", "showListPopup", AlertFragment.ARG_ITEMS, "", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "emitOpen", "applyPopupContainerPadding", "popup", "createPopupBackground", "Landroid/graphics/drawable/GradientDrawable;", "buildItems", "markAsFirstInSection", "item", "value", "resolveIcon", "Landroid/graphics/drawable/Drawable;", "iconName", "dpToPx", "dp", "", "resolvePopupBackgroundColor", "updateMenu", "handlePopupDismissed", "addChild", "view", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "removeChild", "removeChildAt", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuNativeView extends ExpoView implements MenuAction, MenuUpdatable {
    private static final float POPUP_ANCHOR_GAP_DP = 8.0f;
    private static final float POPUP_CORNER_RADIUS_DP = 8.0f;
    private static final String POPUP_MENU_FILL_COLOR_NAME = "popup_menu_fill";
    private static final float POPUP_WIDTH_DP = 200.0f;
    private static final String TAG = "MenuNativeView";
    private final List<MenuAction> actions;
    private boolean isMenuShowing;
    private MenuListAdapter mAdapter;
    private GestureDetector mGestureDetector;
    private ListPopupWindow mPopupWindow;
    private int nonMenuChildCount;

    /* JADX INFO: renamed from: onMenuDismiss$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMenuDismiss;

    /* JADX INFO: renamed from: onMenuOpen$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMenuOpen;
    private boolean skipNextDismissLifecycle;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MenuNativeView.class, "onMenuOpen", "getOnMenuOpen()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(MenuNativeView.class, "onMenuDismiss", "getOnMenuDismiss()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuNativeView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.actions = new ArrayList();
        MenuNativeView menuNativeView = this;
        this.onMenuOpen = ViewEventDelegateKt.MapEventDispatcher$default(menuNativeView, null, 1, null);
        this.onMenuDismiss = ViewEventDelegateKt.MapEventDispatcher$default(menuNativeView, null, 1, null);
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: expo.modules.nativeelementsexpo.MenuNativeView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                MenuNativeView.this.prepareMenu();
                return true;
            }
        });
    }

    @Override // expo.modules.nativeelementsexpo.MenuAction
    public void parseActions(Menu menu, List<? extends MenuAction> list, int i) {
        MenuAction.DefaultImpls.parseActions(this, menu, list, i);
    }

    public final List<MenuAction> getActions() {
        return this.actions;
    }

    public final ViewEventCallback<Map<String, Object>> getOnMenuOpen() {
        return this.onMenuOpen.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnMenuDismiss() {
        return this.onMenuDismiss.getValue(this, $$delegatedProperties[1]);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        this.mGestureDetector.onTouchEvent(ev);
        return true;
    }

    public final void prepareMenu() {
        List<MenuListItem> listBuildItems = buildItems(this.actions);
        if (listBuildItems.isEmpty()) {
            closeMenuState(true);
        } else {
            showListPopup(listBuildItems, !this.isMenuShowing);
        }
    }

    private final void showSubmenuPopup(MenuListItem.Submenu submenuItem) {
        List<MenuListItem> listBuildItems = buildItems(submenuItem.getActions());
        if (listBuildItems.isEmpty()) {
            closeMenuState(true);
        } else {
            showListPopup(listBuildItems, false);
        }
    }

    private final void closeMenuState(boolean notifyDismiss) {
        this.mPopupWindow = null;
        this.mAdapter = null;
        this.skipNextDismissLifecycle = false;
        if (this.isMenuShowing) {
            this.isMenuShowing = false;
            if (notifyDismiss) {
                getOnMenuDismiss().invoke(MapsKt.emptyMap());
            }
        }
    }

    private final void showListPopup(List<? extends MenuListItem> items, boolean emitOpen) {
        final MAMListPopupWindow mAMListPopupWindow = new MAMListPopupWindow(getContext());
        mAMListPopupWindow.setAnchorView(this);
        mAMListPopupWindow.setModal(true);
        mAMListPopupWindow.setBackgroundDrawable(createPopupBackground());
        mAMListPopupWindow.setWidth(dpToPx(200.0f));
        mAMListPopupWindow.setHeight(-2);
        mAMListPopupWindow.setVerticalOffset(dpToPx(8.0f));
        mAMListPopupWindow.setSoftInputMode(3);
        int width = getRootView().getWidth();
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (iArr[0] > width / 2) {
            mAMListPopupWindow.setDropDownGravity(GravityCompat.END);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final MenuListAdapter menuListAdapter = new MenuListAdapter(context, items, 0.0f, 0.0f, 12, null);
        mAMListPopupWindow.setAdapter(menuListAdapter);
        mAMListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: expo.modules.nativeelementsexpo.MenuNativeView$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                MenuNativeView.showListPopup$lambda$0(menuListAdapter, mAMListPopupWindow, this, adapterView, view, i, j);
            }
        });
        mAMListPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: expo.modules.nativeelementsexpo.MenuNativeView$$ExternalSyntheticLambda1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.f$0.handlePopupDismissed(mAMListPopupWindow);
            }
        });
        this.mPopupWindow = mAMListPopupWindow;
        this.mAdapter = menuListAdapter;
        if (emitOpen) {
            getOnMenuOpen().invoke(MapsKt.emptyMap());
        }
        this.isMenuShowing = true;
        mAMListPopupWindow.show();
        applyPopupContainerPadding(mAMListPopupWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showListPopup$lambda$0(MenuListAdapter menuListAdapter, ListPopupWindow listPopupWindow, MenuNativeView menuNativeView, AdapterView adapterView, View view, int i, long j) {
        MenuListItem item = menuListAdapter.getItem(i);
        if (item instanceof MenuListItem.Action) {
            listPopupWindow.dismiss();
            ((MenuListItem.Action) item).getOnSelected().invoke();
        } else if (item instanceof MenuListItem.Submenu) {
            menuNativeView.skipNextDismissLifecycle = true;
            listPopupWindow.dismiss();
            menuNativeView.showSubmenuPopup((MenuListItem.Submenu) item);
        }
    }

    private final void applyPopupContainerPadding(ListPopupWindow popup) {
        ListView listView = popup.getListView();
        if (listView != null) {
            listView.setBackground(createPopupBackground());
            listView.setVerticalScrollBarEnabled(false);
            listView.setHorizontalScrollBarEnabled(false);
        }
    }

    private final GradientDrawable createPopupBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dpToPx(8.0f));
        gradientDrawable.setColor(resolvePopupBackgroundColor());
        return gradientDrawable;
    }

    private final List<MenuListItem> buildItems(List<? extends MenuAction> actions) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        int i = 0;
        for (final MenuAction menuAction : actions) {
            int i2 = i + 1;
            if (menuAction instanceof SubmenuNativeView) {
                SubmenuNativeView submenuNativeView = (SubmenuNativeView) menuAction;
                if (Intrinsics.areEqual(submenuNativeView.getMode(), "inline") || Intrinsics.areEqual(submenuNativeView.getMode(), "palette")) {
                    if (!arrayList.isEmpty() && !(CollectionsKt.last((List) arrayList) instanceof MenuListItem.Divider)) {
                        arrayList.add(new MenuListItem.Divider(null, 1, null));
                    }
                    String string = StringsKt.trim((CharSequence) submenuNativeView.getTitle()).toString();
                    if (string.length() > 0) {
                        arrayList.add(new MenuListItem.SectionHeader(string, submenuNativeView.getSectionTitleColor(), true));
                        z = false;
                    } else {
                        z = true;
                    }
                    int i3 = 0;
                    for (MenuListItem menuListItemMarkAsFirstInSection : buildItems(submenuNativeView.getActions())) {
                        int i4 = i3 + 1;
                        if (i3 == 0 && z) {
                            menuListItemMarkAsFirstInSection = markAsFirstInSection(menuListItemMarkAsFirstInSection, true);
                        } else if (i3 == 0 && !z) {
                            menuListItemMarkAsFirstInSection = markAsFirstInSection(menuListItemMarkAsFirstInSection, true);
                        }
                        arrayList.add(menuListItemMarkAsFirstInSection);
                        i3 = i4;
                    }
                    if (i < actions.size() - 1) {
                        arrayList.add(new MenuListItem.Divider(null, 1, null));
                    }
                    z2 = true;
                } else {
                    arrayList.add(new MenuListItem.Submenu(submenuNativeView.getTitle(), submenuNativeView.getDisabled(), submenuNativeView.getActions(), z2));
                    z2 = false;
                }
            } else if (menuAction instanceof MenuActionNativeView) {
                MenuActionNativeView menuActionNativeView = (MenuActionNativeView) menuAction;
                arrayList.add(new MenuListItem.Action(menuActionNativeView.getTitle(), resolveIcon(menuActionNativeView.getIcon()), menuActionNativeView.getDisabled(), menuActionNativeView.getDestructive(), menuActionNativeView.getDestructiveColor(), menuActionNativeView.getTextColor(), menuActionNativeView.getDisabledTextColor(), z2, new Function0() { // from class: expo.modules.nativeelementsexpo.MenuNativeView$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MenuNativeView.buildItems$lambda$4(menuAction);
                    }
                }));
                z2 = false;
            }
            i = i2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildItems$lambda$4(MenuAction menuAction) {
        ((MenuActionNativeView) menuAction).getOnSelected().invoke(MapsKt.emptyMap());
        return Unit.INSTANCE;
    }

    private final MenuListItem markAsFirstInSection(MenuListItem item, boolean value) {
        if (item instanceof MenuListItem.Action) {
            return MenuListItem.Action.copy$default((MenuListItem.Action) item, null, null, false, false, null, null, null, value, null, 383, null);
        }
        if (item instanceof MenuListItem.SectionHeader) {
            return MenuListItem.SectionHeader.copy$default((MenuListItem.SectionHeader) item, null, null, value, 3, null);
        }
        if (item instanceof MenuListItem.Submenu) {
            return MenuListItem.Submenu.copy$default((MenuListItem.Submenu) item, null, false, null, value, 7, null);
        }
        if (item instanceof MenuListItem.Divider) {
            return item;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Drawable resolveIcon(String iconName) {
        if (iconName == null) {
            return null;
        }
        int identifier = getContext().getResources().getIdentifier(iconName, "drawable", getContext().getPackageName());
        if (identifier != 0) {
            return ContextCompat.getDrawable(getContext(), identifier);
        }
        Log.e(TAG, "Unable to resolve drawable resource '" + iconName + "' for menu action.");
        return null;
    }

    private final int dpToPx(float dp) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return MenuUtilsKt.dpToPx(context, dp);
    }

    private final int resolvePopupBackgroundColor() {
        int identifier = getContext().getResources().getIdentifier(POPUP_MENU_FILL_COLOR_NAME, "color", getContext().getPackageName());
        if (identifier != 0) {
            return ContextCompat.getColor(getContext(), identifier);
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return MenuUtilsKt.resolveThemeColor(context, R.attr.colorBackground, -1);
    }

    @Override // expo.modules.nativeelementsexpo.MenuUpdatable
    public void updateMenu() {
        if (this.isMenuShowing) {
            ListPopupWindow listPopupWindow = this.mPopupWindow;
            MenuListAdapter menuListAdapter = this.mAdapter;
            if (listPopupWindow == null || menuListAdapter == null || !listPopupWindow.isShowing()) {
                prepareMenu();
                return;
            }
            List<MenuListItem> listBuildItems = buildItems(this.actions);
            if (listBuildItems.isEmpty()) {
                closeMenuState(true);
                listPopupWindow.dismiss();
            } else {
                menuListAdapter.updateItems(listBuildItems);
                listPopupWindow.show();
                applyPopupContainerPadding(listPopupWindow);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePopupDismissed(ListPopupWindow popup) {
        if (this.mPopupWindow != popup) {
            this.skipNextDismissLifecycle = false;
            return;
        }
        this.mPopupWindow = null;
        this.mAdapter = null;
        if (this.skipNextDismissLifecycle) {
            this.skipNextDismissLifecycle = false;
        } else {
            this.isMenuShowing = false;
            getOnMenuDismiss().invoke(MapsKt.emptyMap());
        }
    }

    public final void addChild(View view, int index) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof MenuAction) {
            this.actions.add(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(index - this.nonMenuChildCount, 0), this.actions.size()), view);
        } else {
            this.nonMenuChildCount++;
        }
        if (view instanceof SubmenuNativeView) {
            ((SubmenuNativeView) view).setParentMenuUpdatable(this);
        }
        addView(view, index);
        updateMenu();
    }

    public final void removeChild(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof MenuAction) {
            this.actions.remove(view);
        } else {
            this.nonMenuChildCount = RangesKt.coerceAtLeast(this.nonMenuChildCount - 1, 0);
        }
        if (view instanceof SubmenuNativeView) {
            ((SubmenuNativeView) view).setParentMenuUpdatable(null);
        }
        removeView(view);
        updateMenu();
    }

    public final void removeChildAt(int index) {
        View childAt = getChildAt(index);
        if (childAt instanceof MenuAction) {
            this.actions.remove(childAt);
        } else {
            this.nonMenuChildCount = RangesKt.coerceAtLeast(this.nonMenuChildCount - 1, 0);
        }
        if (childAt instanceof SubmenuNativeView) {
            ((SubmenuNativeView) childAt).setParentMenuUpdatable(null);
        }
        removeViewAt(index);
        updateMenu();
    }
}
