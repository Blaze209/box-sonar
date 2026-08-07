package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSTabsScreenAndroidManagerInterface;

/* JADX INFO: loaded from: classes13.dex */
public class RNSTabsScreenAndroidManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSTabsScreenAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public RNSTabsScreenAndroidManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: setProperty */
    public void kotlinCompat$setProperty(T t, String str, Object obj) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1770963447:
                if (str.equals("specialEffects")) {
                    b = 0;
                }
                break;
            case -558395241:
                if (str.equals("tabBarItemAccessibilityLabel")) {
                    b = 1;
                }
                break;
            case -113697461:
                if (str.equals("selectedDrawableIconResourceName")) {
                    b = 2;
                }
                break;
            case -10721392:
                if (str.equals("drawableIconResourceName")) {
                    b = 3;
                }
                break;
            case 28389121:
                if (str.equals("standardAppearance")) {
                    b = 4;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    b = 5;
                }
                break;
            case 125075027:
                if (str.equals("screenKey")) {
                    b = 6;
                }
                break;
            case 1072026510:
                if (str.equals("badgeValue")) {
                    b = 7;
                }
                break;
            case 1465115197:
                if (str.equals("preventNativeSelection")) {
                    b = 8;
                }
                break;
            case 1479286599:
                if (str.equals("selectedImageIconResource")) {
                    b = 9;
                }
                break;
            case 1577043198:
                if (str.equals("tabBarItemTestID")) {
                    b = 10;
                }
                break;
            case 2109188258:
                if (str.equals("imageIconResource")) {
                    b = 11;
                }
                break;
        }
        switch (b) {
            case 0:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setSpecialEffects(t, (ReadableMap) obj);
                break;
            case 1:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setTabBarItemAccessibilityLabel(t, obj != null ? (String) obj : null);
                break;
            case 2:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setSelectedDrawableIconResourceName(t, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setDrawableIconResourceName(t, obj != null ? (String) obj : null);
                break;
            case 4:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setStandardAppearance(t, (ReadableMap) obj);
                break;
            case 5:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setTitle(t, obj != null ? (String) obj : null);
                break;
            case 6:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setScreenKey(t, obj != null ? (String) obj : null);
                break;
            case 7:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setBadgeValue(t, obj != null ? (String) obj : null);
                break;
            case 8:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setPreventNativeSelection(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 9:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setSelectedImageIconResource(t, (ReadableMap) obj);
                break;
            case 10:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setTabBarItemTestID(t, obj != null ? (String) obj : null);
                break;
            case 11:
                ((RNSTabsScreenAndroidManagerInterface) this.mViewManager).setImageIconResource(t, (ReadableMap) obj);
                break;
            default:
                super.kotlinCompat$setProperty(t, str, obj);
                break;
        }
    }
}
