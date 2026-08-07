package com.swmansion.rnscreens.gamma.stack.host;

import android.util.Log;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.intune.mam.client.view.MAMViewGroup;
import com.swmansion.rnscreens.gamma.stack.screen.StackScreen;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHost.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001<B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b J\r\u0010!\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0015\u0010%\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0014J0\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0014J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020\u0016H\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010:\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/host/StackHost;", "Landroid/view/ViewGroup;", "Lcom/facebook/react/bridge/UIManagerListener;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerDelegate;", "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerParent;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "renderedScreens", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreen;", "Lkotlin/collections/ArrayList;", "getRenderedScreens$react_native_screens_release", "()Ljava/util/ArrayList;", TtmlNode.RUBY_CONTAINER, "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainer;", "containerUpdateCoordinator", "Lcom/swmansion/rnscreens/gamma/stack/host/StackContainerUpdateCoordinator;", "isLayoutEnqueued", "", "onAttachedToWindow", "", "mountReactSubviewAt", "stackScreen", FirebaseAnalytics.Param.INDEX, "", "mountReactSubviewAt$react_native_screens_release", "unmountReactSubviewAt", "unmountReactSubviewAt$react_native_screens_release", "unmountReactSubview", "reactSubview", "unmountReactSubview$react_native_screens_release", "unmountAllReactSubviews", "unmountAllReactSubviews$react_native_screens_release", "addPushOperationIfNeeded", "addPopOperationIfNeeded", "stackScreenChangedActivityMode", "stackScreenChangedActivityMode$react_native_screens_release", "onScreenDismissCommitted", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", CmcdData.STREAM_TYPE_LIVE, "t", "r", "b", "requestLayout", "refreshLayout", "forceSubtreeMeasureAndLayoutPass", "layoutContainerNow", "didMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "willDispatchViewUpdates", "willMountItems", "didDispatchMountItems", "didScheduleMountItems", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHost extends MAMViewGroup implements UIManagerListener, StackContainerDelegate, StackContainerParent {
    public static final String TAG = "StackHost";
    private final StackContainer container;
    private final StackContainerUpdateCoordinator containerUpdateCoordinator;
    private boolean isLayoutEnqueued;
    private final ThemedReactContext reactContext;
    private final ArrayList<StackScreen> renderedScreens;

    /* JADX INFO: compiled from: StackHost.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackScreen.ActivityMode.values().length];
            try {
                iArr[StackScreen.ActivityMode.DETACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackScreen.ActivityMode.ATTACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

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
    public StackHost(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.renderedScreens = new ArrayList<>();
        StackContainer stackContainer = new StackContainer(reactContext, new WeakReference(this));
        this.container = stackContainer;
        this.containerUpdateCoordinator = new StackContainerUpdateCoordinator();
        addView(stackContainer);
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, 2);
        if (uIManager == null) {
            throw new IllegalStateException("[RNScreens] UIManager must not be null.".toString());
        }
        uIManager.addUIManagerEventListener(this);
    }

    public final ArrayList<StackScreen> getRenderedScreens$react_native_screens_release() {
        return this.renderedScreens;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d(TAG, "StackHost [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    public final void mountReactSubviewAt$react_native_screens_release(StackScreen stackScreen, int index) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        this.renderedScreens.add(index, stackScreen);
        stackScreen.setStackHost$react_native_screens_release(new WeakReference<>(this));
        addPushOperationIfNeeded(stackScreen);
    }

    public final void unmountReactSubviewAt$react_native_screens_release(int index) {
        StackScreen stackScreenRemove = this.renderedScreens.remove(index);
        Intrinsics.checkNotNullExpressionValue(stackScreenRemove, "removeAt(...)");
        addPopOperationIfNeeded(stackScreenRemove);
    }

    public final void unmountReactSubview$react_native_screens_release(StackScreen reactSubview) {
        Intrinsics.checkNotNullParameter(reactSubview, "reactSubview");
        this.renderedScreens.remove(reactSubview);
        addPopOperationIfNeeded(reactSubview);
    }

    public final void unmountAllReactSubviews$react_native_screens_release() {
        Iterator it = CollectionsKt.asReversedMutable(this.renderedScreens).iterator();
        while (it.hasNext()) {
            addPopOperationIfNeeded((StackScreen) it.next());
        }
        this.renderedScreens.clear();
    }

    private final void addPushOperationIfNeeded(StackScreen stackScreen) {
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED) {
            this.containerUpdateCoordinator.addPushOperation$react_native_screens_release(stackScreen);
        }
    }

    private final void addPopOperationIfNeeded(StackScreen stackScreen) {
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED && !stackScreen.getIsNativelyDismissed()) {
            this.containerUpdateCoordinator.addPopOperation$react_native_screens_release(stackScreen);
        } else {
            Log.d(TAG, "Ignoring pop operation of " + stackScreen.getScreenKey() + ", already not attached or natively dismissed");
        }
    }

    public final void stackScreenChangedActivityMode$react_native_screens_release(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        int i = WhenMappings.$EnumSwitchMapping$0[stackScreen.getActivityMode().ordinal()];
        if (i == 1) {
            this.containerUpdateCoordinator.addPopOperation$react_native_screens_release(stackScreen);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.containerUpdateCoordinator.addPushOperation$react_native_screens_release(stackScreen);
        }
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.StackContainerDelegate
    public void onScreenDismissCommitted(StackScreen stackScreen) {
        Intrinsics.checkNotNullParameter(stackScreen, "stackScreen");
        if (stackScreen.getActivityMode() == StackScreen.ActivityMode.ATTACHED) {
            stackScreen.setNativelyDismissed$react_native_screens_release(true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.container.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.container.layout(l, t, r, b);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        refreshLayout();
    }

    private final void refreshLayout() {
        if (this.isLayoutEnqueued) {
            return;
        }
        this.isLayoutEnqueued = true;
        post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.stack.host.StackHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                StackHost.refreshLayout$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshLayout$lambda$2(StackHost stackHost) {
        stackHost.isLayoutEnqueued = false;
        stackHost.forceSubtreeMeasureAndLayoutPass();
    }

    private final void forceSubtreeMeasureAndLayoutPass() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.swmansion.rnscreens.gamma.stack.host.StackContainerParent
    public void layoutContainerNow() {
        if (getMeasuredWidth() != this.container.getMeasuredWidth() || getMeasuredHeight() != this.container.getMeasuredHeight()) {
            this.container.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
        this.container.layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.containerUpdateCoordinator.executePendingOperationsIfNeeded$react_native_screens_release(this.container, this.renderedScreens);
    }
}
