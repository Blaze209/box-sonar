package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes13.dex */
public interface RNSStackHeaderConfigAndroidManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setBackButtonDrawableIconResourceName(T t, String str);

    void setBackButtonHidden(T t, boolean z);

    void setBackButtonImageIconResource(T t, ReadableMap readableMap);

    void setBackButtonTintColor(T t, Integer num);

    void setHidden(T t, boolean z);

    void setScrollFlagEnterAlways(T t, boolean z);

    void setScrollFlagEnterAlwaysCollapsed(T t, boolean z);

    void setScrollFlagExitUntilCollapsed(T t, boolean z);

    void setScrollFlagScroll(T t, boolean z);

    void setScrollFlagSnap(T t, boolean z);

    void setTitle(T t, String str);

    void setTransparent(T t, boolean z);

    void setType(T t, String str);
}
