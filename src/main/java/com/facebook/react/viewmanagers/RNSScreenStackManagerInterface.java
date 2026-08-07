package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes13.dex */
public interface RNSScreenStackManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void setIosPreventReattachmentOfDismissedModals(T t, boolean z);

    void setIosPreventReattachmentOfDismissedScreens(T t, boolean z);

    void setNativeContainerBackgroundColor(T t, Integer num);
}
