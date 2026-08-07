package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupMenu;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.app.LazyInit;

/* JADX INFO: loaded from: classes3.dex */
public class MAMPopupMenu extends PopupMenu {
    private static final LazyInit<PopupStaticBehavior> POPUP_BEHAVIOR = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.widget.MAMPopupMenu$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return MAMPopupMenu.lambda$static$0();
        }
    });

    static /* synthetic */ PopupStaticBehavior lambda$static$0() {
        return (PopupStaticBehavior) InterfaceComponentsAccess.get(PopupStaticBehavior.class);
    }

    public MAMPopupMenu(Context context, View view) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), view);
    }

    public MAMPopupMenu(Context context, View view, int i) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), view, i);
    }

    public MAMPopupMenu(Context context, View view, int i, int i2, int i3) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), view, i, i2, i3);
    }
}
