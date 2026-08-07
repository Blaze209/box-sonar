package com.swmansion.rnscreens.gamma.stack.header.config;

import android.view.View;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderConfigViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = StackHeaderConfigViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0002H\u0014J\u001a\u0010$\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u001f\u0010*\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010+J\u001a\u0010,\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010-\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010.H\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u00100\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u00101\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016J\u0018\u00103\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "Lcom/facebook/react/viewmanagers/RNSStackHeaderConfigAndroidManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "needsCustomLayoutForChildren", "", "addView", "", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "", "removeView", "view", "removeViewAt", "removeAllViews", "getChildCount", "getChildAt", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "setType", "value", "setTitle", "setHidden", "setTransparent", "setBackButtonHidden", "setBackButtonTintColor", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;Ljava/lang/Integer;)V", "setBackButtonDrawableIconResourceName", "setBackButtonImageIconResource", "Lcom/facebook/react/bridge/ReadableMap;", "setScrollFlagScroll", "setScrollFlagEnterAlways", "setScrollFlagEnterAlwaysCollapsed", "setScrollFlagExitUntilCollapsed", "setScrollFlagSnap", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StackHeaderConfigViewManager extends ViewGroupManager<StackHeaderConfig> implements RNSStackHeaderConfigAndroidManagerInterface<StackHeaderConfig> {
    public static final String REACT_CLASS = "RNSStackHeaderConfigAndroid";
    private final ViewManagerDelegate<StackHeaderConfig> delegate;

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public StackHeaderConfigViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackHeaderConfigAndroidManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackHeaderConfig createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackHeaderConfig(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<StackHeaderConfig> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(StackHeaderConfig parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (!(child instanceof StackHeaderSubview)) {
            throw new IllegalArgumentException(("[RNScreens] StackHeaderConfig can only have children of type StackHeaderSubview. Received " + child + " instead.").toString());
        }
        parent.addConfigSubview$react_native_screens_release((StackHeaderSubview) child);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(StackHeaderConfig parent, View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof StackHeaderSubview)) {
            throw new IllegalArgumentException(("[RNScreens] StackHeaderConfig can only have children of type StackHeaderSubview. Attempted to remove " + view + " instead.").toString());
        }
        parent.removeConfigSubview$react_native_screens_release((StackHeaderSubview) view);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(StackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeConfigSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(StackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.removeAllConfigSubviews$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(StackHeaderConfig parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewsCount$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(StackHeaderConfig parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getConfigSubviewAt$react_native_screens_release(index);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(StackHeaderConfig view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper$react_native_screens_release(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(StackHeaderConfig view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.resolveBackButtonIconIfNeeded$react_native_screens_release();
        view.notifyConfigChanged$react_native_screens_release();
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setType(StackHeaderConfig view, String value) {
        StackHeaderType stackHeaderType;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null) {
            int iHashCode = value.hashCode();
            if (iHashCode != -1078030475) {
                if (iHashCode != 102742843) {
                    if (iHashCode == 109548807 && value.equals(BoxRequestsFile.DownloadAvatar.SMALL)) {
                        stackHeaderType = StackHeaderType.SMALL;
                        view.setType$react_native_screens_release(stackHeaderType);
                        return;
                    }
                } else if (value.equals(BoxRequestsFile.DownloadAvatar.LARGE)) {
                    stackHeaderType = StackHeaderType.LARGE;
                    view.setType$react_native_screens_release(stackHeaderType);
                    return;
                }
            } else if (value.equals(FirebaseAnalytics.Param.MEDIUM)) {
                stackHeaderType = StackHeaderType.MEDIUM;
                view.setType$react_native_screens_release(stackHeaderType);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid StackHeaderConfig type: " + value + ".");
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setTitle(StackHeaderConfig view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (value == null) {
            value = "";
        }
        view.setTitle$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setHidden(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setHidden$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setTransparent(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTransparent$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonHidden(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonHidden$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonTintColor(StackHeaderConfig view, Integer value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonTintColor$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonDrawableIconResourceName(StackHeaderConfig view, String value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonDrawableIconResourceName$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setBackButtonImageIconResource(StackHeaderConfig view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackButtonImageIconUri$react_native_screens_release(value != null ? value.getString("uri") : null);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagScroll(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagScroll$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagEnterAlways(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagEnterAlways$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagEnterAlwaysCollapsed(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagEnterAlwaysCollapsed$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagExitUntilCollapsed(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagExitUntilCollapsed$react_native_screens_release(value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderConfigAndroidManagerInterface
    public void setScrollFlagSnap(StackHeaderConfig view, boolean value) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollFlagSnap$react_native_screens_release(value);
    }
}
