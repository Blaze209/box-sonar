package sdk.pendo.io;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.b8.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.r5.e;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.w6.a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002\u0006)B'\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0006\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR%\u0010#\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0013\u0010\"¨\u0006*"}, d2 = {"Lsdk/pendo/io/PendoTouchDelegate;", "Landroid/view/TouchDelegate;", "Landroid/view/View$OnTouchListener;", "Landroid/view/MotionEvent;", "event", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONObject;", "viewElementInfo", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "v", "onTouch", "touchDelegate", "onTouchEvent", "onTouchExplorationHoverEvent", "Landroid/view/View;", "delegateView", "b", "Ljava/lang/ref/WeakReference;", "analyticsView", "c", "Landroid/view/TouchDelegate;", "originalTouchDelegate", "", "d", "J", "mLastEventTime", "Ljava/util/concurrent/atomic/AtomicReference;", "Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "kotlin.jvm.PlatformType", "e", "Ljava/util/concurrent/atomic/AtomicReference;", "()Ljava/util/concurrent/atomic/AtomicReference;", "onTouchEventHandlerState", "Landroid/graphics/Rect;", "bounds", "<init>", "(Landroid/graphics/Rect;Landroid/view/View;Ljava/lang/ref/WeakReference;)V", "f", "OnTouchEventState", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PendoTouchDelegate extends TouchDelegate implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final View delegateView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final WeakReference<View> analyticsView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private TouchDelegate originalTouchDelegate;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private long mLastEventTime;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final AtomicReference<OnTouchEventState> onTouchEventHandlerState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/PendoTouchDelegate$OnTouchEventState;", "", "(Ljava/lang/String;I)V", "GLOBAL_INTERCEPTOR", "PENDO_TOUCH_DELEGATE", "EXTERNAL_API", "NONE", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum OnTouchEventState {
        GLOBAL_INTERCEPTOR,
        PENDO_TOUCH_DELEGATE,
        EXTERNAL_API,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoTouchDelegate(Rect rect, View delegateView, WeakReference<View> analyticsView) {
        super(rect, delegateView);
        Intrinsics.checkNotNullParameter(delegateView, "delegateView");
        Intrinsics.checkNotNullParameter(analyticsView, "analyticsView");
        this.delegateView = delegateView;
        this.analyticsView = analyticsView;
        this.onTouchEventHandlerState = new AtomicReference<>(OnTouchEventState.NONE);
    }

    public final WeakReference<View> a() {
        return this.analyticsView;
    }

    public final AtomicReference<OnTouchEventState> b() {
        return this.onTouchEventHandlerState;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return onTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v5, types: [T, org.json.JSONObject] */
    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e.a.c(event);
        if (!PendoInternal.Z()) {
            return a(event);
        }
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.onTouchEventHandlerState, OnTouchEventState.NONE, OnTouchEventState.PENDO_TOUCH_DELEGATE);
        if (this.onTouchEventHandlerState.get() == OnTouchEventState.EXTERNAL_API) {
            return a(event);
        }
        if (event.getAction() == 1) {
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            if (platformStateManager.isReactNativeAnalyticsEnabled()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.mLastEventTime < 500) {
                    return a(event);
                }
                this.mLastEventTime = jCurrentTimeMillis;
            }
            try {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = new JSONObject();
                View view = this.analyticsView.get();
                if (!platformStateManager.isTrackEventSolutionOnly() && view != null) {
                    objectRef.element = b1.a.a(view);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", (int) event.getRawX());
                    jSONObject.put("y", (int) event.getRawY());
                    ((JSONObject) objectRef.element).put("tapLocation", jSONObject);
                    a.a.a((JSONObject) objectRef.element, false);
                }
                if (event.getEventTime() - event.getDownTime() < ViewConfiguration.getLongPressTimeout()) {
                    this.delegateView.post(new Runnable() { // from class: sdk.pendo.io.PendoTouchDelegate$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PendoTouchDelegate.a(this.f$0, objectRef);
                        }
                    });
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "PendoTouchDelegate onTouchEvent event action " + event.getAction());
            }
        }
        return a(event);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchExplorationHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        TouchDelegate touchDelegate = this.originalTouchDelegate;
        if (touchDelegate != null) {
            return touchDelegate.onTouchExplorationHoverEvent(event);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(PendoTouchDelegate this$0, Ref.ObjectRef viewElementInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewElementInfo, "$viewElementInfo");
        this$0.a((JSONObject) viewElementInfo.element);
    }

    private final boolean a(MotionEvent event) {
        TouchDelegate touchDelegate = this.originalTouchDelegate;
        if (touchDelegate != null) {
            return touchDelegate.onTouchEvent(event);
        }
        return false;
    }

    public final void a(TouchDelegate touchDelegate) {
        Intrinsics.checkNotNullParameter(touchDelegate, "touchDelegate");
        this.originalTouchDelegate = touchDelegate;
    }

    private final void a(JSONObject viewElementInfo) {
        try {
            PendoLogger.d("Clicked view: " + this.delegateView, new Object[0]);
            b.a.a(this.delegateView, PlatformStateManager.INSTANCE);
            ActivationManager.INSTANCE.handleClick(viewElementInfo, new WeakReference<>(this.delegateView));
        } catch (Exception e) {
            PendoLogger.d("PendoTouchDelegateshowGuidesRelevantToClick failed to verify if guide appeared, with error:" + e, new Object[0]);
        }
    }
}
