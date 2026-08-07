package sdk.pendo.io.d8;

import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoBackCapture;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\f\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\t*\u00020\u000b\"7\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00070\fj\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u000e8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroid/view/View;", "", "c", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "pendoBackCapture", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View$OnKeyListener;", "b", "Landroidx/core/graphics/Insets;", "d", "Landroid/view/ViewGroup;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getOriginalListeners", "()Ljava/util/HashMap;", "originalListeners", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    private static final HashMap<Integer, View.OnKeyListener> a = new HashMap<>();

    public static final boolean a(View view, PendoBackCapture pendoBackCapture) {
        if (view == null) {
            return false;
        }
        if (view instanceof PendoBackCapture) {
            return true;
        }
        View.OnKeyListener onKeyListenerA = a(view);
        if (onKeyListenerA instanceof sdk.pendo.io.e8.a) {
            return true;
        }
        a.put(Integer.valueOf(view.hashCode()), onKeyListenerA);
        view.setOnKeyListener(new sdk.pendo.io.e8.a(onKeyListenerA, pendoBackCapture));
        return true;
    }

    public static final boolean b(View view) {
        TouchDelegate touchDelegate = view != null ? view.getTouchDelegate() : null;
        if (touchDelegate == null || !(touchDelegate instanceof PendoTouchDelegate)) {
            return false;
        }
        PendoTouchDelegate pendoTouchDelegate = (PendoTouchDelegate) touchDelegate;
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(pendoTouchDelegate.b(), PendoTouchDelegate.OnTouchEventState.NONE, PendoTouchDelegate.OnTouchEventState.EXTERNAL_API);
        PendoTouchDelegate.OnTouchEventState onTouchEventState = pendoTouchDelegate.b().get();
        return onTouchEventState == PendoTouchDelegate.OnTouchEventState.PENDO_TOUCH_DELEGATE || onTouchEventState == PendoTouchDelegate.OnTouchEventState.GLOBAL_INTERCEPTOR;
    }

    public static final void c(View view) {
        if (view == null || (view instanceof PendoBackCapture)) {
            return;
        }
        view.setOnKeyListener(a.remove(Integer.valueOf(view.hashCode())));
    }

    public static final Insets d(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
            if (rootWindowInsets != null) {
                Insets insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
                return insets;
            }
        } catch (Exception unused) {
            PendoLogger.w("ViewExt", "Unable to calculate WindowInsets");
        }
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    public static final Insets a(ViewGroup viewGroup) {
        int paddingTop;
        int paddingBottom;
        Insets insetsOf;
        String str;
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View rootView = viewGroup.getRootView();
        if (rootView == null) {
            insetsOf = Insets.NONE;
            str = "NONE";
        } else {
            int height = rootView.getHeight();
            int[] iArr = new int[2];
            viewGroup.getLocationInWindow(iArr);
            int i = iArr[1];
            int iMin = Math.min(viewGroup.getMeasuredHeight() + i, height);
            if (viewGroup.getChildCount() == 0) {
                paddingTop = viewGroup.getPaddingTop();
                paddingBottom = viewGroup.getPaddingBottom();
            } else {
                View childAt = viewGroup.getChildAt(0);
                childAt.getLocationInWindow(iArr);
                int i2 = iArr[1];
                int measuredHeight = childAt.getMeasuredHeight() + i2;
                Intrinsics.checkNotNull(childAt);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                iMin = Math.min(measuredHeight, iMin - (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0)) - viewGroup.getPaddingBottom();
                int paddingTop2 = childAt.getPaddingTop();
                int paddingBottom2 = childAt.getPaddingBottom();
                i = i2;
                paddingTop = paddingTop2;
                paddingBottom = paddingBottom2;
            }
            Insets insetsD = d(viewGroup);
            insetsOf = Insets.of(0, Math.max(0, (insetsD.top - i) - paddingTop), 0, Math.max(0, (insetsD.bottom - (height - iMin)) - paddingBottom));
            str = "of(...)";
        }
        Intrinsics.checkNotNullExpressionValue(insetsOf, str);
        return insetsOf;
    }

    public static final View.OnKeyListener a(View view) {
        Field declaredField;
        Intrinsics.checkNotNullParameter(view, "<this>");
        try {
            Field declaredField2 = View.class.getDeclaredField("mListenerInfo");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = obj.getClass().getDeclaredField("mOnKeyListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View.OnKeyListener");
            return (View.OnKeyListener) obj2;
        } catch (Exception unused) {
            return null;
        }
    }
}
