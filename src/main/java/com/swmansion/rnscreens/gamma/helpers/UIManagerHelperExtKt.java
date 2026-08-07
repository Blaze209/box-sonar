package com.swmansion.rnscreens.gamma.helpers;

import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UIManagerHelperExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getFabricUIManagerNotNull", "Lcom/facebook/react/bridge/UIManager;", "Lcom/facebook/react/uimanager/UIManagerHelper;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UIManagerHelperExtKt {
    public static final UIManager getFabricUIManagerNotNull(UIManagerHelper uIManagerHelper, ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(uIManagerHelper, "<this>");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, 2);
        if (uIManager != null) {
            return uIManager;
        }
        throw new IllegalStateException("[RNScreens] UIManager must not be null".toString());
    }
}
