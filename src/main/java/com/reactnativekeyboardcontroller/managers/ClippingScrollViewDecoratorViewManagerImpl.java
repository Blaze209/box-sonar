package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.ClippingScrollViewDecoratorView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClippingScrollViewDecoratorViewManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/ClippingScrollViewDecoratorViewManagerImpl;", "", "<init>", "()V", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/ClippingScrollViewDecoratorView;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClippingScrollViewDecoratorViewManagerImpl {
    public static final String NAME = "ClippingScrollViewDecoratorView";

    public final ClippingScrollViewDecoratorView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ClippingScrollViewDecoratorView(reactContext);
    }
}
