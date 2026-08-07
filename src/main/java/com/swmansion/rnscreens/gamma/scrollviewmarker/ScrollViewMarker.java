package com.swmansion.rnscreens.gamma.scrollviewmarker;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.gamma.helpers.UIManagerHelperExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollViewMarker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\r\u0010\u0017\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewMarker;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/facebook/react/bridge/UIManagerListener;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "hasAttemptedRegistration", "", "findScrollView", "Landroid/view/ViewGroup;", "findFirstSeekingAncestor", "Lcom/swmansion/rnscreens/gamma/scrollviewmarker/ScrollViewSeeking;", "registerWithSeekingAncestor", "", "maybeRegisterWithSeekingAncestor", "didMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "willDispatchViewUpdates", "willMountItems", "didDispatchMountItems", "didScheduleMountItems", "onViewManagerDropViewInstance", "onViewManagerDropViewInstance$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollViewMarker extends ReactViewGroup implements UIManagerListener {
    private boolean hasAttemptedRegistration;
    private final ThemedReactContext reactContext;

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollViewMarker(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, reactContext).addUIManagerEventListener(this);
    }

    private final ViewGroup findScrollView() {
        View next;
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            view = next;
            if (view instanceof ScrollView) {
                break;
            }
        } while (!(view instanceof NestedScrollView));
        if (next == null) {
            throw new IllegalStateException("[RNScreens] Failed to find supported type of ScrollView in children of ScrollViewMarker".toString());
        }
        View view2 = next;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) view2;
    }

    private final ScrollViewSeeking findFirstSeekingAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ScrollViewSeeking) {
                return (ScrollViewSeeking) parent;
            }
        }
        return null;
    }

    private final void registerWithSeekingAncestor() {
        ViewGroup viewGroupFindScrollView = findScrollView();
        ScrollViewSeeking scrollViewSeekingFindFirstSeekingAncestor = findFirstSeekingAncestor();
        if (scrollViewSeekingFindFirstSeekingAncestor != null) {
            scrollViewSeekingFindFirstSeekingAncestor.registerScrollView(this, viewGroupFindScrollView);
        }
    }

    private final void maybeRegisterWithSeekingAncestor() {
        if (this.hasAttemptedRegistration) {
            return;
        }
        registerWithSeekingAncestor();
        this.hasAttemptedRegistration = true;
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        maybeRegisterWithSeekingAncestor();
    }

    public final void onViewManagerDropViewInstance$react_native_screens_release() {
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, this.reactContext).removeUIManagerEventListener(this);
    }
}
