package com.swmansion.rnscreens.gamma.tabs.screen;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.tabs.screen.event.TabsScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.screen.event.TabsScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.tabs.screen.event.TabsScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.tabs.screen.event.TabsScreenWillDisappearEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsScreenEventEmitter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/screen/TabsScreenEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/BaseEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "viewTag", "", "<init>", "(Lcom/facebook/react/bridge/ReactContext;I)V", "emitOnWillAppear", "", "emitOnDidAppear", "emitOnWillDisappear", "emitOnDidDisappear", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabsScreenEventEmitter extends BaseEventEmitter {
    public static final String TAG = "TabsScreenEventEmitter";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsScreenEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    public final void emitOnWillAppear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onWillAppear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidAppear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onDidAppear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnWillDisappear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onWillDisappear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDidDisappear() {
        TabsScreenEventEmitterKt.logEventDispatch(getViewTag(), "onDidDisappear");
        getReactEventDispatcher().dispatchEvent(new TabsScreenDidDisappearEvent(getSurfaceId(), getViewTag()));
    }
}
