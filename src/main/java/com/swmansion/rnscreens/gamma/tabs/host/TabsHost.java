package com.swmansion.rnscreens.gamma.tabs.host;

import android.graphics.drawable.ColorDrawable;
import android.view.Choreographer;
import android.view.View;
import android.widget.FrameLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.colorscheme.ColorScheme;
import com.swmansion.rnscreens.gamma.helpers.UIManagerHelperExtKt;
import com.swmansion.rnscreens.gamma.tabs.container.TabsActionOrigin;
import com.swmansion.rnscreens.gamma.tabs.container.TabsContainer;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationState;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserver;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateRejectionReason;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateUpdateRequest;
import com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen;
import com.swmansion.rnscreens.utils.RNSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TabsHost.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00109\u001a\u00020:H\u0014J\b\u0010;\u001a\u00020:H\u0014J\u001d\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020&H\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u00020:2\u0006\u0010>\u001a\u00020&H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\fH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020:H\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\u000fH\u0000¢\u0006\u0002\bIJ\b\u0010L\u001a\u00020:H\u0002J\b\u0010M\u001a\u00020:H\u0016J\b\u0010N\u001a\u00020:H\u0002J\r\u0010O\u001a\u00020:H\u0000¢\u0006\u0002\bPJ(\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\u00132\u0006\u0010V\u001a\u00020WH\u0016J \u0010X\u001a\u00020:2\u0006\u0010Y\u001a\u00020S2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\H\u0016J\u0018\u0010]\u001a\u00020:2\u0006\u0010Y\u001a\u00020S2\u0006\u0010^\u001a\u00020_H\u0016J\u0010\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020bH\u0016J\r\u0010c\u001a\u00020:H\u0000¢\u0006\u0002\bdJ\u0010\u0010e\u001a\u00020:2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010f\u001a\u00020:2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010g\u001a\u00020:2\u0006\u0010a\u001a\u00020bH\u0016J\u0010\u0010h\u001a\u00020:2\u0006\u0010a\u001a\u00020bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a*\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\"\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a*\u0004\b#\u0010\u0016R/\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0012\u001a\u0004\u0018\u00010&8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u0010/\u001a\u00020.2\u0006\u0010\u0012\u001a\u00020.8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b1\u00102\"\u0004\b3\u00104*\u0004\b0\u0010\u0016R+\u00105\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001a*\u0004\b6\u0010\u0016R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;", "Landroid/widget/FrameLayout;", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateObserver;", "Lcom/facebook/react/bridge/UIManagerListener;", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/facebook/react/uimanager/ThemedReactContext;)V", "getReactContext", "()Lcom/facebook/react/uimanager/ThemedReactContext;", "renderedScreens", "Ljava/util/ArrayList;", "Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreen;", "Lkotlin/collections/ArrayList;", "jsNavStateRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", TtmlNode.RUBY_CONTAINER, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsContainer;", "<set-?>", "", "rejectStaleNavigationStateUpdates", "getRejectStaleNavigationStateUpdates$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHost;)Ljava/lang/Object;", "getRejectStaleNavigationStateUpdates$react_native_screens_release", "()Z", "setRejectStaleNavigationStateUpdates$react_native_screens_release", "(Z)V", "eventEmitter", "Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostEventEmitter;", "getEventEmitter$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostEventEmitter;", "setEventEmitter$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostEventEmitter;)V", "isLayoutEnqueued", "tabBarHidden", "getTabBarHidden$delegate", "getTabBarHidden", "setTabBarHidden", "", "nativeContainerBackgroundColor", "getNativeContainerBackgroundColor", "()Ljava/lang/Integer;", "setNativeContainerBackgroundColor", "(Ljava/lang/Integer;)V", "nativeContainerBackgroundColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "colorScheme", "getColorScheme$react_native_screens_release$delegate", "getColorScheme$react_native_screens_release", "()Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;", "setColorScheme$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/common/colorscheme/ColorScheme;)V", "tabBarRespectsIMEInsets", "getTabBarRespectsIMEInsets$delegate", "getTabBarRespectsIMEInsets", "setTabBarRespectsIMEInsets", "onAttachedToWindow", "", "onDetachedFromWindow", "mountReactSubviewAt", "tabsScreen", FirebaseAnalytics.Param.INDEX, "mountReactSubviewAt$react_native_screens_release", "unmountReactSubviewAt", "unmountReactSubviewAt$react_native_screens_release", "unmountReactSubview", "reactSubview", "unmountReactSubview$react_native_screens_release", "unmountAllReactSubviews", "unmountAllReactSubviews$react_native_screens_release", "updateJSNavigationStateUpdateRequest", "navStateRequest", "updateJSNavigationStateUpdateRequest$react_native_screens_release", "layoutCallback", "Landroid/view/Choreographer$FrameCallback;", "refreshLayout", "requestLayout", "forceSubtreeMeasureAndLayoutPass", "onViewManagerAddEventEmitters", "onViewManagerAddEventEmitters$react_native_screens_release", "onNavigationStateUpdate", "navState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "isRepeated", "hasTriggeredSpecialEffect", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "onNavigationStateUpdateRejected", "currentNavState", "rejectedRequest", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "onNavigationStateUpdatePrevented", "preventedScreenKey", "", "didMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "tearDown", "tearDown$react_native_screens_release", "willDispatchViewUpdates", "willMountItems", "didDispatchMountItems", "didScheduleMountItems", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHost extends FrameLayout implements TabsNavigationStateObserver, UIManagerListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsHost.class, "nativeContainerBackgroundColor", "getNativeContainerBackgroundColor()Ljava/lang/Integer;", 0))};
    public static final String TAG = "TabsHost";
    private final TabsContainer container;
    public TabsHostEventEmitter eventEmitter;
    private boolean isLayoutEnqueued;
    private TabsNavigationStateUpdateRequest jsNavStateRequest;
    private final Choreographer.FrameCallback layoutCallback;

    /* JADX INFO: renamed from: nativeContainerBackgroundColor$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty nativeContainerBackgroundColor;
    private final ThemedReactContext reactContext;
    private final ArrayList<TabsScreen> renderedScreens;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unmountReactSubview$lambda$5(TabsScreen tabsScreen, TabsScreen it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it == tabsScreen;
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

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHost(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.renderedScreens = new ArrayList<>();
        TabsContainer tabsContainer = new TabsContainer(reactContext);
        tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.container = tabsContainer;
        Delegates delegates = Delegates.INSTANCE;
        final Object obj = null;
        this.nativeContainerBackgroundColor = new ObservableProperty<Integer>(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHost$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, Integer oldValue, Integer newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                Integer num = newValue;
                if (Intrinsics.areEqual(num, oldValue)) {
                    return;
                }
                this.container.setBackground(num != null ? new ColorDrawable(num.intValue()) : null);
            }
        };
        addView(tabsContainer);
        if (!tabsContainer.addNavigationStateObserver(this)) {
            throw new IllegalStateException("[RNScreens] Failed to register TabsHost as navigation state observer".toString());
        }
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, reactContext).addUIManagerEventListener(this);
        this.layoutCallback = new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHost$$ExternalSyntheticLambda2
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                TabsHost.layoutCallback$lambda$8(this.f$0, j);
            }
        };
    }

    public final boolean getRejectStaleNavigationStateUpdates$react_native_screens_release() {
        return this.container.getRejectStaleNavigationStateUpdates();
    }

    public final void setRejectStaleNavigationStateUpdates$react_native_screens_release(boolean z) {
        this.container.setRejectStaleNavigationStateUpdates$react_native_screens_release(z);
    }

    public final TabsHostEventEmitter getEventEmitter$react_native_screens_release() {
        TabsHostEventEmitter tabsHostEventEmitter = this.eventEmitter;
        if (tabsHostEventEmitter != null) {
            return tabsHostEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(TabsHostEventEmitter tabsHostEventEmitter) {
        Intrinsics.checkNotNullParameter(tabsHostEventEmitter, "<set-?>");
        this.eventEmitter = tabsHostEventEmitter;
    }

    public final boolean getTabBarHidden() {
        return this.container.getTabBarHidden$react_native_screens_release();
    }

    public final void setTabBarHidden(boolean z) {
        this.container.setTabBarHidden$react_native_screens_release(z);
    }

    public final Integer getNativeContainerBackgroundColor() {
        return (Integer) this.nativeContainerBackgroundColor.getValue(this, $$delegatedProperties[0]);
    }

    public final void setNativeContainerBackgroundColor(Integer num) {
        this.nativeContainerBackgroundColor.setValue(this, $$delegatedProperties[0], num);
    }

    public final ColorScheme getColorScheme$react_native_screens_release() {
        return this.container.getColorScheme$react_native_screens_release();
    }

    public final void setColorScheme$react_native_screens_release(ColorScheme colorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "<set-?>");
        this.container.setColorScheme$react_native_screens_release(colorScheme);
    }

    public final boolean getTabBarRespectsIMEInsets() {
        return this.container.getTabBarRespectsIMEInsets();
    }

    public final void setTabBarRespectsIMEInsets(boolean z) {
        this.container.setTabBarRespectsIMEInsets$react_native_screens_release(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.i(TAG, "TabsHost [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void mountReactSubviewAt$react_native_screens_release(TabsScreen tabsScreen, int index) {
        Intrinsics.checkNotNullParameter(tabsScreen, "tabsScreen");
        int maxItemCount = this.container.getBottomNavigationView().getMaxItemCount();
        if (index >= maxItemCount) {
            throw new IllegalArgumentException(("[RNScreens] Attempt to insert TabsScreen at index " + index + "; BottomNavigationView supports at most " + maxItemCount + " items").toString());
        }
        this.renderedScreens.add(index, tabsScreen);
        tabsScreen.setTabsScreenDelegate$react_native_screens_release(this.container);
        this.container.addTabsScreenAt$react_native_screens_release(index, tabsScreen);
    }

    public final void unmountReactSubviewAt$react_native_screens_release(int index) {
        TabsScreen tabsScreenRemove = this.renderedScreens.remove(index);
        this.container.removeTabsScreenAt$react_native_screens_release(index);
        tabsScreenRemove.setTabsScreenDelegate$react_native_screens_release(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unmountReactSubview$lambda$6(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    public final void unmountReactSubview$react_native_screens_release(final TabsScreen reactSubview) {
        Intrinsics.checkNotNullParameter(reactSubview, "reactSubview");
        ArrayList<TabsScreen> arrayList = this.renderedScreens;
        final Function1 function1 = new Function1() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHost$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TabsHost.unmountReactSubview$lambda$5(reactSubview, (TabsScreen) obj));
            }
        };
        if (arrayList.removeIf(new Predicate() { // from class: com.swmansion.rnscreens.gamma.tabs.host.TabsHost$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return TabsHost.unmountReactSubview$lambda$6(function1, obj);
            }
        })) {
            this.container.removeTabsScreen$react_native_screens_release(reactSubview);
            reactSubview.setTabsScreenDelegate$react_native_screens_release(null);
        }
    }

    public final void unmountAllReactSubviews$react_native_screens_release() {
        Iterator<T> it = this.renderedScreens.iterator();
        while (it.hasNext()) {
            ((TabsScreen) it.next()).setTabsScreenDelegate$react_native_screens_release(null);
        }
        this.renderedScreens.clear();
        this.container.removeAllTabsScreens$react_native_screens_release();
    }

    public final void updateJSNavigationStateUpdateRequest$react_native_screens_release(TabsNavigationStateUpdateRequest navStateRequest) {
        Intrinsics.checkNotNullParameter(navStateRequest, "navStateRequest");
        this.jsNavStateRequest = navStateRequest;
        this.container.setPendingNavigationStateUpdate$react_native_screens_release(TabsNavigationStateUpdateRequest.copy$default(navStateRequest, null, 0, null, 7, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutCallback$lambda$8(TabsHost tabsHost, long j) {
        tabsHost.isLayoutEnqueued = false;
        tabsHost.forceSubtreeMeasureAndLayoutPass();
    }

    private final void refreshLayout() {
        if (this.isLayoutEnqueued || this.layoutCallback == null) {
            return;
        }
        this.isLayoutEnqueued = true;
        ReactChoreographer.INSTANCE.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.layoutCallback);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        refreshLayout();
    }

    private final void forceSubtreeMeasureAndLayoutPass() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabsHost must have its tag set when registering event emitters".toString());
        }
        setEventEmitter$react_native_screens_release(new TabsHostEventEmitter(this.reactContext, getId()));
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserver
    public void onNavigationStateUpdate(TabsNavigationState navState, boolean isRepeated, boolean hasTriggeredSpecialEffect, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(navState, "navState");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        getEventEmitter$react_native_screens_release().emitOnTabSelectedEvent(navState.getSelectedScreenKey(), navState.getProvenance(), isRepeated, hasTriggeredSpecialEffect, actionOrigin);
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserver
    public void onNavigationStateUpdateRejected(TabsNavigationState currentNavState, TabsNavigationStateUpdateRequest rejectedRequest, TabsNavigationStateRejectionReason reason) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(rejectedRequest, "rejectedRequest");
        Intrinsics.checkNotNullParameter(reason, "reason");
        getEventEmitter$react_native_screens_release().emitOnTabSelectionRejectedEvent(currentNavState, rejectedRequest, reason);
    }

    @Override // com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateObserver
    public void onNavigationStateUpdatePrevented(TabsNavigationState currentNavState, String preventedScreenKey) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(preventedScreenKey, "preventedScreenKey");
        getEventEmitter$react_native_screens_release().emitOnTabSelectionPreventedEvent(currentNavState, preventedScreenKey);
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        this.container.flushPendingUpdates();
    }

    public final void tearDown$react_native_screens_release() {
        this.container.removeNavigationStateObserver(this);
        this.container.tearDown$react_native_screens_release();
        UIManagerHelperExtKt.getFabricUIManagerNotNull(UIManagerHelper.INSTANCE, this.reactContext).removeUIManagerEventListener(this);
    }
}
