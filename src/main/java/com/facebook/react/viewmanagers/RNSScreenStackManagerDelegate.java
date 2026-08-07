package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSScreenStackManagerInterface;

/* JADX INFO: loaded from: classes13.dex */
public class RNSScreenStackManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSScreenStackManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSScreenStackManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "iosPreventReattachmentOfDismissedModals":
                ((RNSScreenStackManagerInterface) this.mViewManager).setIosPreventReattachmentOfDismissedModals(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "nativeContainerBackgroundColor":
                ((RNSScreenStackManagerInterface) this.mViewManager).setNativeContainerBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "iosPreventReattachmentOfDismissedScreens":
                ((RNSScreenStackManagerInterface) this.mViewManager).setIosPreventReattachmentOfDismissedScreens(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
