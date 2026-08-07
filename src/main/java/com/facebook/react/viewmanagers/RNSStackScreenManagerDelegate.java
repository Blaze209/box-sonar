package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSStackScreenManagerInterface;

/* JADX INFO: loaded from: classes13.dex */
public class RNSStackScreenManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSStackScreenManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSStackScreenManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "preventNativeDismiss":
                ((RNSStackScreenManagerInterface) this.mViewManager).setPreventNativeDismiss(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "screenKey":
                ((RNSStackScreenManagerInterface) this.mViewManager).setScreenKey(t, obj == null ? null : (String) obj);
                break;
            case "activityMode":
                ((RNSStackScreenManagerInterface) this.mViewManager).setActivityMode(t, (String) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
