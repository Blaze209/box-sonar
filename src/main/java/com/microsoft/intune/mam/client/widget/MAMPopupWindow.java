package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.app.LazyInit;

/* JADX INFO: loaded from: classes3.dex */
public class MAMPopupWindow extends PopupWindow {
    private static final LazyInit<PopupStaticBehavior> POPUP_BEHAVIOR = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.widget.MAMPopupWindow$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return MAMPopupWindow.lambda$static$0();
        }
    });
    private PopupInstanceBehavior mPopupBehavior;

    static /* synthetic */ PopupStaticBehavior lambda$static$0() {
        return (PopupStaticBehavior) InterfaceComponentsAccess.get(PopupStaticBehavior.class);
    }

    public MAMPopupWindow(Context context) {
        super(POPUP_BEHAVIOR.get().wrapContext(context));
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow(Context context, AttributeSet attributeSet) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet);
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet, i);
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(POPUP_BEHAVIOR.get().wrapContext(context), attributeSet, i, i2);
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow() {
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow(View view) {
        super(POPUP_BEHAVIOR.get().getAndWrapContext(view));
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
        setContentView(view);
        setWidth(0);
        setHeight(0);
    }

    public MAMPopupWindow(int i, int i2) {
        super(i, i2);
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
    }

    public MAMPopupWindow(View view, int i, int i2) {
        super(POPUP_BEHAVIOR.get().getAndWrapContext(view));
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
        setContentView(view);
        setWidth(i);
        setHeight(i2);
    }

    public MAMPopupWindow(View view, int i, int i2, boolean z) {
        super(POPUP_BEHAVIOR.get().getAndWrapContext(view));
        this.mPopupBehavior = (PopupInstanceBehavior) InterfaceComponentsAccess.get(PopupInstanceBehavior.class);
        setContentView(view);
        setWidth(i);
        setHeight(i2);
        setFocusable(z);
    }

    @Override // android.widget.PopupWindow
    public View getContentView() {
        return this.mPopupBehavior.getContentView();
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        this.mPopupBehavior.setContentView(view);
        super.setContentView(this.mPopupBehavior.getMAMContentView());
    }
}
