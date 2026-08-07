package com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.KeyboardToolbarGroupViewManagerDelegate;
import com.facebook.react.viewmanagers.KeyboardToolbarGroupViewManagerInterface;
import com.reactnativekeyboardcontroller.managers.KeyboardToolbarGroupViewManagerImpl;
import com.reactnativekeyboardcontroller.views.KeyboardToolbarGroupReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardToolbarGroupViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reactnativekeyboardcontroller/KeyboardToolbarGroupViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativekeyboardcontroller/views/KeyboardToolbarGroupReactViewGroup;", "Lcom/facebook/react/viewmanagers/KeyboardToolbarGroupViewManagerInterface;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/KeyboardToolbarGroupViewManagerImpl;", "mDelegate", "Lcom/facebook/react/viewmanagers/KeyboardToolbarGroupViewManagerDelegate;", "kotlin.jvm.PlatformType", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardToolbarGroupViewManager extends ViewGroupManager<KeyboardToolbarGroupReactViewGroup> implements KeyboardToolbarGroupViewManagerInterface<KeyboardToolbarGroupReactViewGroup> {
    private final KeyboardToolbarGroupViewManagerDelegate<KeyboardToolbarGroupReactViewGroup, KeyboardToolbarGroupViewManager> mDelegate;
    private final KeyboardToolbarGroupViewManagerImpl manager;

    public KeyboardToolbarGroupViewManager() {
        super(null, 1, null);
        this.manager = new KeyboardToolbarGroupViewManagerImpl();
        this.mDelegate = new KeyboardToolbarGroupViewManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<KeyboardToolbarGroupReactViewGroup> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return KeyboardToolbarGroupViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public KeyboardToolbarGroupReactViewGroup createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }
}
