package com.swmansion.rnscreens.gamma.tabs.host;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.container.TabsActionOrigin;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationState;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateRejectionReason;
import com.swmansion.rnscreens.gamma.tabs.container.TabsNavigationStateUpdateRequest;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectedEvent;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectionPreventedEvent;
import com.swmansion.rnscreens.gamma.tabs.host.event.TabsHostTabSelectionRejectedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsHostEventEmitter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000b¨\u0006\u001b"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/host/TabsHostEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/BaseEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "viewTag", "", "<init>", "(Lcom/facebook/react/bridge/ReactContext;I)V", "emitOnTabSelectedEvent", "", "selectedScreenKey", "", "provenance", "isRepeated", "", "hasTriggeredSpecialEffect", "actionOrigin", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "emitOnTabSelectionRejectedEvent", "currentNavState", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationState;", "rejectedRequest", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateUpdateRequest;", "rejectionReason", "Lcom/swmansion/rnscreens/gamma/tabs/container/TabsNavigationStateRejectionReason;", "emitOnTabSelectionPreventedEvent", "preventedScreenKey", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsHostEventEmitter extends BaseEventEmitter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnTabSelectedEvent(String selectedScreenKey, int provenance, boolean isRepeated, boolean hasTriggeredSpecialEffect, TabsActionOrigin actionOrigin) {
        Intrinsics.checkNotNullParameter(selectedScreenKey, "selectedScreenKey");
        Intrinsics.checkNotNullParameter(actionOrigin, "actionOrigin");
        getReactEventDispatcher().dispatchEvent(new TabsHostTabSelectedEvent(getSurfaceId(), getViewTag(), selectedScreenKey, provenance, isRepeated, hasTriggeredSpecialEffect, actionOrigin));
    }

    public final void emitOnTabSelectionRejectedEvent(TabsNavigationState currentNavState, TabsNavigationStateUpdateRequest rejectedRequest, TabsNavigationStateRejectionReason rejectionReason) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(rejectedRequest, "rejectedRequest");
        Intrinsics.checkNotNullParameter(rejectionReason, "rejectionReason");
        getReactEventDispatcher().dispatchEvent(new TabsHostTabSelectionRejectedEvent(getSurfaceId(), getViewTag(), currentNavState, rejectedRequest, rejectionReason));
    }

    public final void emitOnTabSelectionPreventedEvent(TabsNavigationState currentNavState, String preventedScreenKey) {
        Intrinsics.checkNotNullParameter(currentNavState, "currentNavState");
        Intrinsics.checkNotNullParameter(preventedScreenKey, "preventedScreenKey");
        getReactEventDispatcher().dispatchEvent(new TabsHostTabSelectionPreventedEvent(getSurfaceId(), getViewTag(), currentNavState, preventedScreenKey));
    }
}
