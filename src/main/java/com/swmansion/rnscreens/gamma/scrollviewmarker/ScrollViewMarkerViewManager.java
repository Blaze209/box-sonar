package com.swmansion.rnscreens.gamma.scrollviewmarker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerDelegate;
import com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollViewMarkerViewManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = ScrollViewMarkerViewManager.REACT_CLASS)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001c\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewMarkerViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewMarker;", "Lcom/facebook/react/viewmanagers/RNSScrollViewMarkerManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "getDelegate", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "view", "setLeftScrollEdgeEffect", "value", "setTopScrollEdgeEffect", "setRightScrollEdgeEffect", "setBottomScrollEdgeEffect", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollViewMarkerViewManager extends ViewGroupManager<ScrollViewMarker> implements RNSScrollViewMarkerManagerInterface<ScrollViewMarker> {
    public static final String REACT_CLASS = "RNSScrollViewMarker";
    private final ViewManagerDelegate<ScrollViewMarker> delegate;

    @Override // com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerInterface
    public void setBottomScrollEdgeEffect(ScrollViewMarker view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerInterface
    public void setLeftScrollEdgeEffect(ScrollViewMarker view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerInterface
    public void setRightScrollEdgeEffect(ScrollViewMarker view, String value) {
    }

    @Override // com.facebook.react.viewmanagers.RNSScrollViewMarkerManagerInterface
    public void setTopScrollEdgeEffect(ScrollViewMarker view, String value) {
    }

    public ScrollViewMarkerViewManager() {
        super(null, 1, null);
        this.delegate = new RNSScrollViewMarkerManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ScrollViewMarker> getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ScrollViewMarker createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScrollViewMarker(reactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ScrollViewMarker view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onDropViewInstance(view);
        view.onViewManagerDropViewInstance$react_native_screens_release();
    }
}
