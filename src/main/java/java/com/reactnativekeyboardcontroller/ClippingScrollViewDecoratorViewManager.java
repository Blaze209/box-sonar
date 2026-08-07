package java.com.reactnativekeyboardcontroller;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.ClippingScrollViewDecoratorViewManagerDelegate;
import com.facebook.react.viewmanagers.ClippingScrollViewDecoratorViewManagerInterface;
import com.reactnativekeyboardcontroller.managers.ClippingScrollViewDecoratorViewManagerImpl;
import com.reactnativekeyboardcontroller.views.ClippingScrollViewDecoratorView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClippingScrollViewDecoratorViewManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00000\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ljava/com/reactnativekeyboardcontroller/ClippingScrollViewDecoratorViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativekeyboardcontroller/views/ClippingScrollViewDecoratorView;", "Lcom/facebook/react/viewmanagers/ClippingScrollViewDecoratorViewManagerInterface;", "<init>", "()V", "manager", "Lcom/reactnativekeyboardcontroller/managers/ClippingScrollViewDecoratorViewManagerImpl;", "mDelegate", "Lcom/facebook/react/viewmanagers/ClippingScrollViewDecoratorViewManagerDelegate;", "kotlin.jvm.PlatformType", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setContentInsetBottom", "", "view", "value", "", "setContentInsetTop", "setApplyWorkaroundForContentInsetHitTestBug", "", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClippingScrollViewDecoratorViewManager extends ViewGroupManager<ClippingScrollViewDecoratorView> implements ClippingScrollViewDecoratorViewManagerInterface<ClippingScrollViewDecoratorView> {
    private final ClippingScrollViewDecoratorViewManagerDelegate<ClippingScrollViewDecoratorView, ClippingScrollViewDecoratorViewManager> mDelegate;
    private final ClippingScrollViewDecoratorViewManagerImpl manager;

    public ClippingScrollViewDecoratorViewManager() {
        super(null, 1, null);
        this.manager = new ClippingScrollViewDecoratorViewManagerImpl();
        this.mDelegate = new ClippingScrollViewDecoratorViewManagerDelegate<>(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ClippingScrollViewDecoratorView> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return ClippingScrollViewDecoratorViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ClippingScrollViewDecoratorView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.manager.createViewInstance(context);
    }

    @Override // com.facebook.react.viewmanagers.ClippingScrollViewDecoratorViewManagerInterface
    public void setContentInsetBottom(ClippingScrollViewDecoratorView view, double value) {
        if (view != null) {
            view.setContentInsetBottom(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.ClippingScrollViewDecoratorViewManagerInterface
    public void setContentInsetTop(ClippingScrollViewDecoratorView view, double value) {
        if (view != null) {
            view.setContentInsetTop(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.ClippingScrollViewDecoratorViewManagerInterface
    public void setApplyWorkaroundForContentInsetHitTestBug(ClippingScrollViewDecoratorView view, boolean value) {
        if (view != null) {
            view.setApplyWorkaroundForContentInsetHitTestBug(value);
        }
    }
}
