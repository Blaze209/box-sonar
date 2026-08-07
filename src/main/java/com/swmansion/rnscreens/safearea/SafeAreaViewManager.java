package com.swmansion.rnscreens.safearea;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSSafeAreaViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSSafeAreaViewManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeAreaViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = SafeAreaViewManager.REACT_CLASS)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/safearea/SafeAreaViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/safearea/SafeAreaView;", "Lcom/facebook/react/viewmanagers/RNSSafeAreaViewManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "setEdges", "", "view", "value", "Lcom/facebook/react/bridge/ReadableMap;", "setInsetType", "updateState", "", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SafeAreaViewManager extends ViewGroupManager<SafeAreaView> implements RNSSafeAreaViewManagerInterface<SafeAreaView> {
    public static final String REACT_CLASS = "RNSSafeAreaView";
    private final ViewManagerDelegate<SafeAreaView> delegate;

    public SafeAreaViewManager() {
        super(null, 1, null);
        this.delegate = new RNSSafeAreaViewManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SafeAreaView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new SafeAreaView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<SafeAreaView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.viewmanagers.RNSSafeAreaViewManagerInterface
    public void setEdges(SafeAreaView view, ReadableMap value) {
        Intrinsics.checkNotNullParameter(view, "view");
        SafeAreaViewEdges safeAreaViewEdgesFromProp = SafeAreaViewEdges.INSTANCE.fromProp(value);
        if (safeAreaViewEdgesFromProp != null) {
            view.setEdges(safeAreaViewEdgesFromProp);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r3.equals("all") != false) goto L21;
     */
    @Override // com.facebook.react.viewmanagers.RNSSafeAreaViewManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setInsetType(com.swmansion.rnscreens.safearea.SafeAreaView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r1 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            if (r3 == 0) goto L50
            int r1 = r3.hashCode()
            r0 = -887328209(0xffffffffcb1c722f, float:-1.0252847E7)
            if (r1 == r0) goto L2f
            r0 = 96673(0x179a1, float:1.35468E-40)
            if (r1 == r0) goto L26
            r0 = 502623545(0x1df56d39, float:6.4963894E-21)
            if (r1 != r0) goto L3b
            java.lang.String r1 = "interface"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L3b
            com.swmansion.rnscreens.safearea.InsetType r1 = com.swmansion.rnscreens.safearea.InsetType.INTERFACE
            goto L52
        L26:
            java.lang.String r1 = "all"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L3b
            goto L50
        L2f:
            java.lang.String r1 = "system"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L3b
            com.swmansion.rnscreens.safearea.InsetType r1 = com.swmansion.rnscreens.safearea.InsetType.SYSTEM
            goto L52
        L3b:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "Unknown inset type "
            r2.<init>(r0)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L50:
            com.swmansion.rnscreens.safearea.InsetType r1 = com.swmansion.rnscreens.safearea.InsetType.ALL
        L52:
            r2.setInsetType(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.safearea.SafeAreaViewManager.setInsetType(com.swmansion.rnscreens.safearea.SafeAreaView, java.lang.String):void");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(SafeAreaView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }
}
