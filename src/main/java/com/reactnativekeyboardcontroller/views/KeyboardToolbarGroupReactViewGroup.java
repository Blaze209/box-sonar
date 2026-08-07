package com.reactnativekeyboardcontroller.views;

import android.content.Context;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardToolbarGroupReactViewGroup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/KeyboardToolbarGroupReactViewGroup;", "Lcom/facebook/react/views/view/ReactViewGroup;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardToolbarGroupReactViewGroup extends ReactViewGroup {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardToolbarGroupReactViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardToolbarGroupReactViewGroup(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
