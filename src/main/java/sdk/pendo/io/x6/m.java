package sdk.pendo.io.x6;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b0;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.views.custom.PendoBackCapture;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\"\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\b\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/x6/m;", "Lsdk/pendo/io/s7/b0;", "Landroid/view/View;", "view", "", "rawX", "rawY", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;)V", "b", "x", "y", "", "Landroid/view/MotionEvent;", "event", "", "Lsdk/pendo/io/x6/i;", "Lsdk/pendo/io/x6/i;", "getScreenManagerBase", "()Lsdk/pendo/io/x6/i;", "screenManagerBase", "<init>", "(Lsdk/pendo/io/x6/i;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class m implements b0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final i screenManagerBase;

    public m(i screenManagerBase) {
        Intrinsics.checkNotNullParameter(screenManagerBase, "screenManagerBase");
        this.screenManagerBase = screenManagerBase;
    }

    private final View a(float x, float y) {
        View viewB = b();
        if (viewB == null) {
            return null;
        }
        return a(viewB, (int) x, (int) y);
    }

    private final View b() {
        Window window;
        Activity activity = this.screenManagerBase.getCurrentActivity().get();
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }

    private final View a(View view, int x, int y) {
        if (!(view instanceof sdk.pendo.io.s5.b) && !(view instanceof PendoBackCapture) && view.isShown() && view.getVisibility() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth() + i;
            int height = view.getHeight() + i2;
            if (i <= x && x <= width && i2 <= y && y <= height) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                        View childAt = viewGroup.getChildAt(childCount);
                        Intrinsics.checkNotNull(childAt);
                        View viewA = a(childAt, x, y);
                        if (viewA != null) {
                            return viewA;
                        }
                    }
                }
                return view;
            }
        }
        return null;
    }

    public boolean b(MotionEvent motionEvent) {
        return b0.a.a(this, motionEvent);
    }

    @Override // sdk.pendo.io.s7.b0
    public boolean a(MotionEvent event) throws JSONException {
        if (event == null) {
            return true;
        }
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        if (b(event)) {
            PendoLogger.d("ViewMotionEventHandler", "isClickOnBannerOrTooltipOrBackdrop guide is visible and click should not be handled for touch event x=" + rawX + ", y=" + rawY);
            return true;
        }
        View viewA = a(event.getX(), event.getY());
        TouchDelegate touchDelegate = viewA != null ? viewA.getTouchDelegate() : null;
        PendoTouchDelegate pendoTouchDelegate = touchDelegate instanceof PendoTouchDelegate ? (PendoTouchDelegate) touchDelegate : null;
        if (pendoTouchDelegate == null || PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(pendoTouchDelegate.b(), PendoTouchDelegate.OnTouchEventState.NONE, PendoTouchDelegate.OnTouchEventState.GLOBAL_INTERCEPTOR)) {
            a(viewA, Float.valueOf(rawX), Float.valueOf(rawY));
            return true;
        }
        PendoLogger.d("ViewMotionEventHandler", "Touch event was already handled " + pendoTouchDelegate.b().get());
        return true;
    }

    @Override // sdk.pendo.io.s7.b0
    public void a() {
        b0.a.a(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void a(View view, Float rawX, Float rawY) throws JSONException {
        if (view == null) {
            return;
        }
        JSONObject jSONObjectA = b1.a.a(view);
        if (rawX != null && rawY != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", (int) rawX.floatValue());
            jSONObject.put("y", (int) rawY.floatValue());
            jSONObjectA.put("tapLocation", jSONObject);
        }
        sdk.pendo.io.w6.a.a.a(jSONObjectA, false);
    }
}
