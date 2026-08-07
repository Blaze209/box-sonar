package com.swmansion.rnscreens.gamma.stack.host;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHostManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHostManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHostViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u001bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/StackHostViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "Lcom/facebook/react/viewmanagers/RNSStackHostManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "getDelegate", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "view", "removeViewAt", "removeAllViews", "getChildAt", "getChildCount", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ReactModule(name = StackHostViewManager.REACT_CLASS)
public final class StackHostViewManager extends ViewGroupManager<StackHost> implements RNSStackHostManagerInterface<StackHost> {
    public static final String REACT_CLASS = "RNSStackHost";
    private final ViewManagerDelegate<StackHost> delegate;

    public StackHostViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackHostManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<StackHost> getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackHost createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackHost(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(StackHost parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof StackScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass".toString());
        }
        parent.mountReactSubviewAt$react_native_screens_release((StackScreen) child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(StackHost parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof StackScreen)) {
            throw new IllegalArgumentException("[RNScreens] Attempt to attach child that is not of type javaClass".toString());
        }
        parent.unmountReactSubview$react_native_screens_release((StackScreen) view);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(StackHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountReactSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(StackHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.unmountAllReactSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(StackHost parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return (View) CollectionsKt.getOrNull(parent.getRenderedScreens$react_native_screens_release(), index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(StackHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getRenderedScreens$react_native_screens_release().size();
    }
}
