package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface;

/* JADX INFO: loaded from: classes13.dex */
public class RNSTabsHostAndroidManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSTabsHostAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSTabsHostAndroidManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "rejectStaleNavStateUpdates":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setRejectStaleNavStateUpdates(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "tabBarHidden":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setTabBarHidden(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "nativeContainerBackgroundColor":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setNativeContainerBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                break;
            case "tabBarRespectsIMEInsets":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setTabBarRespectsIMEInsets(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "colorScheme":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setColorScheme(t, (String) obj);
                break;
            case "navStateRequest":
                ((RNSTabsHostAndroidManagerInterface) this.mViewManager).setNavStateRequest(t, (ReadableMap) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
