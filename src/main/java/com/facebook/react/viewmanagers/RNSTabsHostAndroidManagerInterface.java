package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes13.dex */
public interface RNSTabsHostAndroidManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setColorScheme(T t, String str);

    void setNativeContainerBackgroundColor(T t, Integer num);

    void setNavStateRequest(T t, ReadableMap readableMap);

    void setRejectStaleNavStateUpdates(T t, boolean z);

    void setTabBarHidden(T t, boolean z);

    void setTabBarRespectsIMEInsets(T t, boolean z);
}
