package com.swmansion.rnscreens.gamma.stack.screen;

import com.facebook.react.bridge.ReactContext;
import com.swmansion.rnscreens.gamma.common.event.BaseEventEmitter;
import com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDidDisappearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenNativeDismissPreventedEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillAppearEvent;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenWillDisappearEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackScreenEventEmitter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/screen/StackScreenEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/BaseEventEmitter;", "Lcom/swmansion/rnscreens/gamma/common/event/ViewAppearanceEventEmitter;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "viewTag", "", "<init>", "(Lcom/facebook/react/bridge/ReactContext;I)V", "emitOnWillAppear", "", "emitOnDidAppear", "emitOnWillDisappear", "emitOnDidDisappear", "emitOnDismiss", "isNativeDismiss", "", "emitOnDismiss$react_native_screens_release", "emitOnNativeDismissPrevented", "emitOnNativeDismissPrevented$react_native_screens_release", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackScreenEventEmitter extends BaseEventEmitter implements ViewAppearanceEventEmitter {
    public static final String TAG = "StackScreenEventEmitter";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackScreenEventEmitter(ReactContext reactContext, int i) {
        super(reactContext, i);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillAppear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenWillAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidAppear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenDidAppearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnWillDisappear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenWillDisappearEvent(getSurfaceId(), getViewTag()));
    }

    @Override // com.swmansion.rnscreens.gamma.common.event.ViewAppearanceEventEmitter
    public void emitOnDidDisappear() {
        getReactEventDispatcher().dispatchEvent(new StackScreenDidDisappearEvent(getSurfaceId(), getViewTag()));
    }

    public final void emitOnDismiss$react_native_screens_release(boolean isNativeDismiss) {
        getReactEventDispatcher().dispatchEvent(new StackScreenDismissEvent(getSurfaceId(), getViewTag(), isNativeDismiss));
    }

    public final void emitOnNativeDismissPrevented$react_native_screens_release() {
        getReactEventDispatcher().dispatchEvent(new StackScreenNativeDismissPreventedEvent(getSurfaceId(), getViewTag()));
    }
}
