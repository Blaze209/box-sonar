package com.pspdfkit.ui.actionmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.f;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.h;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.wc;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ActionMenu {
    private FragmentActivity activity;
    private f dialog;
    private String dialogTitle;
    private boolean isShowing;
    private List<ActionMenuItem> menuItems = new ArrayList();
    private final go<ActionMenuListener> listeners = new go<>();

    public class ActionMenuDialogListener implements f.a {
        private ActionMenuDialogListener() {
        }

        @Override // com.pspdfkit.internal.f.a
        public void onClickOnMenuItem(f fVar, ActionMenuItem actionMenuItem) {
            ActionMenu.this.onMenuItemClicked(actionMenuItem);
        }

        @Override // com.pspdfkit.internal.f.a
        public void onDismiss(f fVar) {
            ActionMenu.this.onRemoveActionMenu();
        }

        @Override // com.pspdfkit.internal.f.a
        public boolean onLongClickOnMenuItem(f fVar, ActionMenuItem actionMenuItem) {
            return ActionMenu.this.onMenuItemLongClicked(actionMenuItem);
        }

        @Override // com.pspdfkit.internal.f.a
        public void onShow(f fVar) {
            ActionMenu.this.onDisplayActionMenu();
        }
    }

    public ActionMenu(FragmentActivity fragmentActivity) {
        uw.a(fragmentActivity, "activity", null);
        onAttach(fragmentActivity);
    }

    private void clearMenuItems(final ActionMenuItem.MenuItemType menuItemType) {
        uw.a(menuItemType, "itemTypeToClear", null);
        setMenuItems((List) Observable.fromIterable(this.menuItems).filter(new Predicate() { // from class: com.pspdfkit.ui.actionmenu.ActionMenu$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Predicate
            public final boolean test(Object obj) {
                return ActionMenu.lambda$clearMenuItems$0(menuItemType, (ActionMenuItem) obj);
            }
        }).toList().blockingGet());
    }

    public static Drawable createActionMenuIcon(Context context, int i) {
        uw.a(context, "context", null);
        int i2 = f.e;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, h.k, h.l, h.m);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ActionMenu_pspdf__fixedActionsIconColor, -1);
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawableA = a80.a(context, i, color);
        if (drawableA != null) {
            return drawableA;
        }
        throw new IllegalArgumentException("Can't retrieve drawable with id: " + i);
    }

    static /* synthetic */ boolean lambda$clearMenuItems$0(ActionMenuItem.MenuItemType menuItemType, ActionMenuItem actionMenuItem) throws Throwable {
        return actionMenuItem.getItemType() != menuItemType;
    }

    private void refreshDialog() {
        f fVar = this.dialog;
        if (fVar == null) {
            return;
        }
        String str = this.dialogTitle;
        fVar.c = str;
        h hVar = fVar.a;
        if (hVar != null) {
            wc wcVar = hVar.f;
            if (str == null) {
                wcVar.setVisibility(8);
            } else {
                wcVar.setVisibility(0);
                hVar.f.setTitle(str);
            }
        }
        f fVar2 = this.dialog;
        List<ActionMenuItem> list = this.menuItems;
        fVar2.b = list;
        h hVar2 = fVar2.a;
        if (hVar2 != null) {
            hVar2.a(list);
        }
        this.dialog.d = new ActionMenuDialogListener();
    }

    public void addActionMenuListener(ActionMenuListener actionMenuListener) {
        uw.a(actionMenuListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.a(actionMenuListener);
    }

    public void addMenuItem(ActionMenuItem actionMenuItem) {
        uw.a(actionMenuItem, "menuItem", null);
        this.menuItems.add(actionMenuItem);
        f fVar = this.dialog;
        if (fVar != null) {
            List<ActionMenuItem> list = this.menuItems;
            fVar.b = list;
            h hVar = fVar.a;
            if (hVar != null) {
                hVar.a(list);
            }
        }
    }

    public void addMenuItems(List<ActionMenuItem> list) {
        List<ActionMenuItem> list2 = this.menuItems;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        list2.addAll(list);
        f fVar = this.dialog;
        if (fVar != null) {
            List<ActionMenuItem> list3 = this.menuItems;
            fVar.b = list3;
            h hVar = fVar.a;
            if (hVar != null) {
                hVar.a(list3);
            }
        }
    }

    public void clearFixedMenuItems() {
        clearMenuItems(ActionMenuItem.MenuItemType.FIXED);
    }

    public void clearStandardMenuItems() {
        clearMenuItems(ActionMenuItem.MenuItemType.STANDARD);
    }

    public void dismiss() {
        f fVar = this.dialog;
        if (fVar != null && fVar.isAdded()) {
            this.dialog.dismiss();
            this.dialog = null;
        }
        this.isShowing = false;
    }

    public Context getContext() {
        return this.activity;
    }

    public f getDialog() {
        return this.dialog;
    }

    public List<ActionMenuItem> getMenuItems() {
        return this.menuItems;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    public void onAttach(FragmentActivity fragmentActivity) {
        uw.a(fragmentActivity, "activity", null);
        this.activity = fragmentActivity;
        if (this.isShowing) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            int i = f.e;
            f fVar = (f) supportFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.ActionMenuDialog.FRAGMENT_TAG");
            if (fVar == null) {
                fVar = new f();
                fVar.setArguments(new Bundle());
            }
            if (!fVar.isAdded()) {
                fVar.show(supportFragmentManager, "com.pspdfkit.ui.dialog.ActionMenuDialog.FRAGMENT_TAG");
            }
            this.dialog = fVar;
            refreshDialog();
        }
    }

    public void onDetach() {
        this.activity = null;
        f fVar = this.dialog;
        if (fVar != null) {
            fVar.d = null;
            fVar.dismiss();
            this.dialog = null;
        }
    }

    public void onDisplayActionMenu() {
        Iterator<ActionMenuListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onDisplayActionMenu(this);
        }
    }

    public boolean onMenuItemClicked(ActionMenuItem actionMenuItem) {
        Iterator<ActionMenuListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (it.next().onActionMenuItemClicked(this, actionMenuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean onMenuItemLongClicked(ActionMenuItem actionMenuItem) {
        Iterator<ActionMenuListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (it.next().onActionMenuItemLongClicked(this, actionMenuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onNoActionsVisible() {
    }

    public void onRemoveActionMenu() {
        this.isShowing = false;
        Iterator<ActionMenuListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRemoveActionMenu(this);
        }
    }

    public void removeActionMenuListener(ActionMenuListener actionMenuListener) {
        uw.a(actionMenuListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.b(actionMenuListener);
    }

    public void setMenuItems(List<ActionMenuItem> list) {
        if (this.menuItems == list) {
            return;
        }
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list);
        this.menuItems = arrayList;
        f fVar = this.dialog;
        if (fVar != null) {
            fVar.b = arrayList;
            h hVar = fVar.a;
            if (hVar != null) {
                hVar.a(arrayList);
            }
        }
    }

    public void setTitle(int i) {
        if (getContext() == null) {
            throw new IllegalStateException("Can't set title from string resource when action menu is detached from activity!");
        }
        setTitle(no.a(getContext(), i, null));
    }

    public boolean show() {
        if (this.activity == null) {
            return false;
        }
        Iterator<ActionMenuListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (!it.next().onPrepareActionMenu(this)) {
                return false;
            }
        }
        if (this.menuItems.isEmpty()) {
            onNoActionsVisible();
            return false;
        }
        if (this.menuItems.size() == 1) {
            onMenuItemClicked(this.menuItems.get(0));
            return false;
        }
        FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
        int i = f.e;
        f fVar = (f) supportFragmentManager.findFragmentByTag("com.pspdfkit.ui.dialog.ActionMenuDialog.FRAGMENT_TAG");
        if (fVar == null) {
            fVar = new f();
            fVar.setArguments(new Bundle());
        }
        if (!fVar.isAdded()) {
            fVar.show(supportFragmentManager, "com.pspdfkit.ui.dialog.ActionMenuDialog.FRAGMENT_TAG");
        }
        this.dialog = fVar;
        this.isShowing = true;
        refreshDialog();
        return true;
    }

    public void clearMenuItems() {
        setMenuItems(Collections.EMPTY_LIST);
    }

    public void setTitle(String str) {
        this.dialogTitle = str;
        f fVar = this.dialog;
        if (fVar != null) {
            fVar.c = str;
            h hVar = fVar.a;
            if (hVar != null) {
                wc wcVar = hVar.f;
                if (str == null) {
                    wcVar.setVisibility(8);
                } else {
                    wcVar.setVisibility(0);
                    hVar.f.setTitle(str);
                }
            }
        }
    }
}
