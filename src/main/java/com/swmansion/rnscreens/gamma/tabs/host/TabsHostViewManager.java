package com.swmansion.rnscreens.gamma.tabs.host;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorScheme;
import com.swmansion.rnscreens.gamma.helpers.EventHelpersKt;
import com.swmansion.rnscreens.gamma.tabs.container.TabsActionOrigin;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateUpdateRequest;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectedEvent;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectionPreventedEvent;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectionRejectedEvent;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001(B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u001f\u0010$\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\"H\u0016J\u001a\u0010'\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;", "Lcom/facebook/react/viewmanagers/RNSTabsHostAndroidManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "removeViewAt", "removeAllViews", "getExportedCustomDirectEventTypeConstants", "", "", "addEventEmitters", "view", "onDropViewInstance", "setNavStateRequest", "value", "Lcom/facebook/react/bridge/ReadableMap;", "setRejectStaleNavStateUpdates", "", "setTabBarHidden", "setNativeContainerBackgroundColor", "(Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;Ljava/lang/Integer;)V", "setTabBarRespectsIMEInsets", "setColorScheme", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = TabsHostViewManager.REACT_CLASS)
public final class TabsHostViewManager extends ViewGroupManager<TabsHost> implements RNSTabsHostAndroidManagerInterface<TabsHost> {
    public static final String REACT_CLASS = "RNSTabsHostAndroid";
    private final ViewManagerDelegate<TabsHost> delegate;

    public TabsHostViewManager() {
        super(null, 1, null);
        this.delegate = new RNSTabsHostAndroidManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public TabsHost createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new TabsHost(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<TabsHost> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(TabsHost parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof TabsScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass".toString());
        }
        parent.mountReactSubviewAt$react_native_screens_release((TabsScreen) child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(TabsHost parent, View child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof TabsScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to detach child that is not of type javaClass".toString());
        }
        parent.unmountReactSubview$react_native_screens_release((TabsScreen) child);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(TabsHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountReactSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(TabsHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountAllReactSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.mutableMapOf(EventHelpersKt.makeEventRegistrationInfo(TabsHostTabSelectedEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(TabsHostTabSelectionPreventedEvent.INSTANCE), EventHelpersKt.makeEventRegistrationInfo(TabsHostTabSelectionRejectedEvent.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext reactContext, TabsHost view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, view);
        view.onViewManagerAddEventEmitters$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(TabsHost view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.tearDown$react_native_screens_release();
        super.onDropViewInstance(view);
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setNavStateRequest(TabsHost view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null) {
            throw new IllegalArgumentException("[RNScreens] navStateRequest must not be nullish".toString());
        }
        String string = value.getString("selectedScreenKey");
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        view.updateJSNavigationStateUpdateRequest$react_native_screens_release(new TabsNavigationStateUpdateRequest(string, value.getInt("baseProvenance"), TabsActionOrigin.PROGRAMMATIC_JS));
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setRejectStaleNavStateUpdates(TabsHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRejectStaleNavigationStateUpdates$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setTabBarHidden(TabsHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarHidden(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setNativeContainerBackgroundColor(TabsHost view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNativeContainerBackgroundColor(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setTabBarRespectsIMEInsets(TabsHost view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTabBarRespectsIMEInsets(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSTabsHostAndroidManagerInterface
    public void setColorScheme(TabsHost view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null) {
            int iHashCode = value.hashCode();
            if (iHashCode != 3075958) {
                if (iHashCode != 102970646) {
                    if (iHashCode == 1946980603 && value.equals("inherit")) {
                        view.setColorScheme$react_native_screens_release(ColorScheme.INHERIT);
                        return;
                    }
                } else if (value.equals("light")) {
                    view.setColorScheme$react_native_screens_release(ColorScheme.LIGHT);
                    return;
                }
            } else if (value.equals("dark")) {
                view.setColorScheme$react_native_screens_release(ColorScheme.DARK);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid color scheme: " + value + ".");
    }
}
