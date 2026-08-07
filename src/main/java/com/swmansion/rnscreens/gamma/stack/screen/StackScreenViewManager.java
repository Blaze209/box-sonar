package com.swmansion.rnscreens.gamma.stack.screen;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackScreenManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackScreenManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenNativeDismissPreventedEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillDisappearEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackScreenViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0014J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010%\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010$\u001a\u00020'H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "Lcom/facebook/react/viewmanagers/RNSStackScreenManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "getDelegate", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "view", "removeViewAt", "getChildCount", "getChildAt", "addEventEmitters", "getExportedCustomDirectEventTypeConstants", "", "", "updateState", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "setActivityMode", "value", "setScreenKey", "setPreventNativeDismiss", "", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = StackScreenViewManager.REACT_CLASS)
public final class StackScreenViewManager extends ViewGroupManager<StackScreen> implements RNSStackScreenManagerInterface<StackScreen> {
    public static final String REACT_CLASS = "RNSStackScreen";
    private final ViewManagerDelegate<StackScreen> delegate;

    public StackScreenViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackScreenManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<StackScreen> getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackScreen createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackScreen(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(StackScreen parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof StackHeaderConfig) {
            if (index < parent.getChildCount()) {
                throw new JSApplicationCausedNativeException("[RNScreens] StackHeaderConfig must be the last child of StackScreen. ");
            }
            parent.attachHeaderConfig$react_native_screens_release((StackHeaderConfig) child);
        } else {
            if (index > parent.getChildCount()) {
                throw new JSApplicationCausedNativeException("[RNScreens] StackHeaderConfig must be the last child of StackScreen. ");
            }
            super.addView(parent, child, index);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(StackScreen parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof StackHeaderConfig) {
            parent.detachHeaderConfig$react_native_screens_release((StackHeaderConfig) view);
        } else {
            super.removeView(parent, view);
        }
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(StackScreen parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (index == getChildCount(parent) - 1 && parent.getHeaderConfig() != null) {
            StackHeaderConfig headerConfig = parent.getHeaderConfig();
            if (headerConfig != null) {
                parent.detachHeaderConfig$react_native_screens_release(headerConfig);
                return;
            }
            return;
        }
        super.removeViewAt(parent, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(StackScreen parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getChildCount() + (parent.getHeaderConfig() != null ? 1 : 0);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(StackScreen parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (index == parent.getChildCount() && parent.getHeaderConfig() != null) {
            return parent.getHeaderConfig();
        }
        return parent.getChildAt(index);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, StackScreen view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(StackScreenWillAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(StackScreenWillDisappearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(StackScreenDidAppearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(StackScreenDidDisappearEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(StackScreenDismissEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(StackScreenNativeDismissPreventedEvent.INSTANCE));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(StackScreen view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper$react_native_screens_release(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackScreenManagerInterface
    public void setActivityMode(StackScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(value, "attached")) {
            view.setActivityMode(StackScreen.ActivityMode.ATTACHED);
        } else {
            if (!Intrinsics.areEqual(value, "detached")) {
                throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid activity mode: " + value + ".");
            }
            view.setActivityMode(StackScreen.ActivityMode.DETACHED);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSStackScreenManagerInterface
    public void setScreenKey(StackScreen view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null) {
            throw new IllegalArgumentException("[RNScreens] screenKey must not be null.".toString());
        }
        view.setScreenKey(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackScreenManagerInterface
    public void setPreventNativeDismiss(StackScreen view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreventNativeDismissEnabled$react_native_screens_release(value);
    }
}
