package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.reactnativekeyboardcontroller.events.FocusedInputLayoutChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputSelectionChangedEvent;
import com.reactnativekeyboardcontroller.events.FocusedInputTextChangedEvent;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.listeners.FocusedInputObserver;
import com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback;
import com.reactnativekeyboardcontroller.listeners.WindowDimensionListener;
import com.reactnativekeyboardcontroller.views.EdgeToEdgeReactViewGroup;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyboardControllerViewManagerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0011J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tJ\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/reactnativekeyboardcontroller/managers/KeyboardControllerViewManagerImpl;", "", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/reactnativekeyboardcontroller/listeners/WindowDimensionListener;", "listenerContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createViewInstance", "Lcom/reactnativekeyboardcontroller/views/EdgeToEdgeReactViewGroup;", "reactContext", "invalidate", "", "synchronizeFocusedInputLayout", "view", "setEnabled", "enabled", "", "setStatusBarTranslucent", "isStatusBarTranslucent", "setNavigationBarTranslucent", "isNavigationBarTranslucent", "setPreserveEdgeToEdge", "isPreservingEdgeToEdge", "setEdgeToEdge", "getExportedCustomDirectEventTypeConstants", "", "", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardControllerViewManagerImpl {
    public static final String NAME = "KeyboardControllerView";
    private WindowDimensionListener listener;
    private ThemedReactContext listenerContext;

    public final EdgeToEdgeReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        WindowDimensionListener windowDimensionListener = this.listener;
        if (windowDimensionListener == null || this.listenerContext != reactContext) {
            if (windowDimensionListener != null) {
                windowDimensionListener.detachListener();
            }
            WindowDimensionListener windowDimensionListener2 = new WindowDimensionListener(reactContext);
            this.listener = windowDimensionListener2;
            windowDimensionListener2.attachListener();
            this.listenerContext = reactContext;
        }
        return new EdgeToEdgeReactViewGroup(reactContext);
    }

    public final void invalidate() {
        WindowDimensionListener windowDimensionListener = this.listener;
        if (windowDimensionListener != null) {
            windowDimensionListener.detachListener();
        }
        this.listener = null;
        this.listenerContext = null;
    }

    public final void synchronizeFocusedInputLayout(EdgeToEdgeReactViewGroup view) {
        FocusedInputObserver layoutObserver;
        Intrinsics.checkNotNullParameter(view, "view");
        KeyboardAnimationCallback callback$react_native_keyboard_controller_release = view.getCallback$react_native_keyboard_controller_release();
        if (callback$react_native_keyboard_controller_release != null && (layoutObserver = callback$react_native_keyboard_controller_release.getLayoutObserver()) != null) {
            layoutObserver.syncUpLayout();
        }
        ThemedReactContextKt.emitEvent(view.getReactContext(), "KeyboardController::layoutDidSynchronize", Arguments.createMap());
    }

    public final void setEnabled(EdgeToEdgeReactViewGroup view, boolean enabled) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(enabled);
    }

    public final void setStatusBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isStatusBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStatusBarTranslucent(isStatusBarTranslucent);
    }

    public final void setNavigationBarTranslucent(EdgeToEdgeReactViewGroup view, boolean isNavigationBarTranslucent) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNavigationBarTranslucent(isNavigationBarTranslucent);
    }

    public final void setPreserveEdgeToEdge(EdgeToEdgeReactViewGroup view, boolean isPreservingEdgeToEdge) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreserveEdgeToEdge(isPreservingEdgeToEdge);
    }

    public final void setEdgeToEdge(EdgeToEdgeReactViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEdgeToEdge();
    }

    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(KeyboardTransitionEvent.INSTANCE.getMove().getValue(), MapBuilder.of("registrationName", "onKeyboardMove"), KeyboardTransitionEvent.INSTANCE.getStart().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveStart"), KeyboardTransitionEvent.INSTANCE.getEnd().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveEnd"), KeyboardTransitionEvent.INSTANCE.getInteractive().getValue(), MapBuilder.of("registrationName", "onKeyboardMoveInteractive"), FocusedInputLayoutChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputLayoutChanged"), FocusedInputTextChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputTextChanged"), FocusedInputSelectionChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onFocusedInputSelectionChanged"));
    }
}
