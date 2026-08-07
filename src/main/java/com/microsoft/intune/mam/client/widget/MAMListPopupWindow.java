package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListPopupWindow;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.app.LazyInit;

/* JADX INFO: loaded from: classes3.dex */
public class MAMListPopupWindow extends ListPopupWindow {
    private static final LazyInit<PopupStaticBehavior> POPUP_BEHAVIOR = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.widget.MAMListPopupWindow$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return MAMListPopupWindow.lambda$static$0();
        }
    });

    static /* synthetic */ PopupStaticBehavior lambda$static$0() {
        return (PopupStaticBehavior) InterfaceComponentsAccess.get(PopupStaticBehavior.class);
    }

    public MAMListPopupWindow(Context context) {
        super(POPUP_BEHAVIOR.get().wrapContext(context));
    }

    public MAMListPopupWindow(Context context, AttributeSet attributeSet) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet);
    }

    public MAMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet, i);
    }

    public MAMListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet, i, i2);
    }
}
