package com.swmansion.rnscreens.gamma.stack.header.subview;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderSubviewAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSStackHeaderSubviewAndroidManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderSubviewViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = StackHeaderSubviewViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "Lcom/facebook/react/viewmanagers/RNSStackHeaderSubviewAndroidManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "setType", "", "view", "value", "setCollapseMode", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StackHeaderSubviewViewManager extends ViewGroupManager<StackHeaderSubview> implements RNSStackHeaderSubviewAndroidManagerInterface<StackHeaderSubview> {
    public static final String REACT_CLASS = "RNSStackHeaderSubviewAndroid";
    private final ViewManagerDelegate<StackHeaderSubview> delegate;

    public StackHeaderSubviewViewManager() {
        super(null, 1, null);
        this.delegate = new RNSStackHeaderSubviewAndroidManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public StackHeaderSubview createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new StackHeaderSubview(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<StackHeaderSubview> getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.viewmanagers.RNSStackHeaderSubviewAndroidManagerInterface
    public void setType(StackHeaderSubview view, String value) {
        StackHeaderSubviewType stackHeaderSubviewType;
        Intrinsics.checkNotNullParameter(view, "view");
        if (value != null) {
            switch (value.hashCode()) {
                case -1364013995:
                    if (value.equals(TtmlNode.CENTER)) {
                        stackHeaderSubviewType = StackHeaderSubviewType.CENTER;
                        view.setType$react_native_screens_release(stackHeaderSubviewType);
                        return;
                    }
                    break;
                case -1332194002:
                    if (value.equals(AppStateModule.APP_STATE_BACKGROUND)) {
                        stackHeaderSubviewType = StackHeaderSubviewType.BACKGROUND;
                        view.setType$react_native_screens_release(stackHeaderSubviewType);
                        return;
                    }
                    break;
                case 50359046:
                    if (value.equals("leading")) {
                        stackHeaderSubviewType = StackHeaderSubviewType.LEADING;
                        view.setType$react_native_screens_release(stackHeaderSubviewType);
                        return;
                    }
                    break;
                case 1276059676:
                    if (value.equals("trailing")) {
                        stackHeaderSubviewType = StackHeaderSubviewType.TRAILING;
                        view.setType$react_native_screens_release(stackHeaderSubviewType);
                        return;
                    }
                    break;
            }
        }
        throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid StackHeaderSubview type: " + value);
    }

    @Override // com.facebook.react.viewmanagers.RNSStackHeaderSubviewAndroidManagerInterface
    public void setCollapseMode(StackHeaderSubview view, String value) {
        StackHeaderSubviewCollapseMode stackHeaderSubviewCollapseMode;
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(value, "off")) {
            stackHeaderSubviewCollapseMode = StackHeaderSubviewCollapseMode.OFF;
        } else {
            if (!Intrinsics.areEqual(value, "parallax")) {
                throw new JSApplicationIllegalArgumentException("[RNScreens] Invalid StackHeaderSubview collapseMode: " + value);
            }
            stackHeaderSubviewCollapseMode = StackHeaderSubviewCollapseMode.PARALLAX;
        }
        view.setCollapseMode$react_native_screens_release(stackHeaderSubviewCollapseMode);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(StackHeaderSubview view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper$react_native_screens_release(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }
}
