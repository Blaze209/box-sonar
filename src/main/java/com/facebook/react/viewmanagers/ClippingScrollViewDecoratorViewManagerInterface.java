package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes13.dex */
public interface ClippingScrollViewDecoratorViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setApplyWorkaroundForContentInsetHitTestBug(T t, boolean z);

    void setContentInsetBottom(T t, double d);

    void setContentInsetTop(T t, double d);
}
