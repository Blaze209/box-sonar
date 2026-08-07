package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes13.dex */
public interface RNSTabsScreenAndroidManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setBadgeValue(T t, String str);

    void setDrawableIconResourceName(T t, String str);

    void setImageIconResource(T t, ReadableMap readableMap);

    void setPreventNativeSelection(T t, boolean z);

    void setScreenKey(T t, String str);

    void setSelectedDrawableIconResourceName(T t, String str);

    void setSelectedImageIconResource(T t, ReadableMap readableMap);

    void setSpecialEffects(T t, ReadableMap readableMap);

    void setStandardAppearance(T t, ReadableMap readableMap);

    void setTabBarItemAccessibilityLabel(T t, String str);

    void setTabBarItemTestID(T t, String str);

    void setTitle(T t, String str);
}
