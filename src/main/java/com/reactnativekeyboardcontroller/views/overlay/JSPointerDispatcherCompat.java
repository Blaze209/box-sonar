package com.reactnativekeyboardcontroller.views.overlay;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JSPointerDispatcherCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/reactnativekeyboardcontroller/views/overlay/JSPointerDispatcherCompat;", "", "viewGroup", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "delegate", "Lcom/facebook/react/uimanager/JSPointerDispatcher;", "handleMotionEventMethod", "Ljava/lang/reflect/Method;", "getHandleMotionEventMethod", "()Ljava/lang/reflect/Method;", "handleMotionEventMethod$delegate", "Lkotlin/Lazy;", "handleMotionEventCompat", "", "event", "Landroid/view/MotionEvent;", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "isCapture", "", "onChildStartedNativeGesture", "childView", "Landroid/view/View;", "ev", "onChildEndedNativeGesture", "Companion", "react-native-keyboard-controller_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSPointerDispatcherCompat {
    private static final String HANDLE_MOTION_EVENT = "handleMotionEvent";
    private static final int RN_72_PARAMS_COUNT = 3;
    private final JSPointerDispatcher delegate;

    /* JADX INFO: renamed from: handleMotionEventMethod$delegate, reason: from kotlin metadata */
    private final Lazy handleMotionEventMethod;

    public JSPointerDispatcherCompat(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.delegate = new JSPointerDispatcher(viewGroup);
        this.handleMotionEventMethod = LazyKt.lazy(new Function0() { // from class: com.reactnativekeyboardcontroller.views.overlay.JSPointerDispatcherCompat$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JSPointerDispatcherCompat.handleMotionEventMethod_delegate$lambda$0();
            }
        });
    }

    private final Method getHandleMotionEventMethod() {
        return (Method) this.handleMotionEventMethod.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method handleMotionEventMethod_delegate$lambda$0() {
        try {
            try {
                return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class, Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                return JSPointerDispatcher.class.getMethod(HANDLE_MOTION_EVENT, MotionEvent.class, EventDispatcher.class);
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public final void handleMotionEventCompat(MotionEvent event, EventDispatcher eventDispatcher, boolean isCapture) {
        Method handleMotionEventMethod = getHandleMotionEventMethod();
        if (handleMotionEventMethod != null) {
            if (handleMotionEventMethod.getParameterCount() == 3) {
                handleMotionEventMethod.invoke(this.delegate, event, eventDispatcher, Boolean.valueOf(isCapture));
            } else {
                handleMotionEventMethod.invoke(this.delegate, event, eventDispatcher);
            }
        }
    }

    public final void onChildStartedNativeGesture(View childView, MotionEvent ev, EventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        this.delegate.onChildStartedNativeGesture(childView, ev, eventDispatcher);
    }

    public final void onChildEndedNativeGesture() {
        this.delegate.onChildEndedNativeGesture();
    }
}
