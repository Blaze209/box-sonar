package sdk.pendo.io.s7;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.ActivationManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\u001a\u0010\u0010\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Landroid/view/MotionEvent;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/content/Context;", "context", "", "Landroid/view/View;", "view", "", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    public static final void a(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(R.id.tag_accessibility_actions);
        ArrayList arrayList = tag instanceof ArrayList ? (ArrayList) tag : null;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2 = (AccessibilityNodeInfoCompat.AccessibilityActionCompat) it.next();
                    if (accessibilityActionCompat2.getId() == 16) {
                        if (!(accessibilityActionCompat2 instanceof sdk.pendo.io.q5.a)) {
                            arrayList.remove(accessibilityActionCompat2);
                            accessibilityActionCompat = accessibilityActionCompat2;
                            break;
                        }
                        return;
                    }
                }
            }
            CharSequence label = accessibilityActionCompat != null ? accessibilityActionCompat.getLabel() : null;
            sdk.pendo.io.w6.a aVar = sdk.pendo.io.w6.a.a;
            ActivationManager activationManager = ActivationManager.INSTANCE;
            b1 b1Var = b1.a;
            sdk.pendo.io.b8.b bVar = sdk.pendo.io.b8.b.a;
            sdk.pendo.io.d6.c cVarH = sdk.pendo.io.d6.c.h();
            Intrinsics.checkNotNullExpressionValue(cVarH, "getInstance(...)");
            arrayList.add(new sdk.pendo.io.q5.a(aVar, activationManager, accessibilityActionCompat, b1Var, bVar, cVarH, label, 16));
        }
        arrayList = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList);
        if (ViewCompat.getAccessibilityDelegate(view) == null) {
            ViewCompat.enableAccessibleClickableSpanSupport(view);
        }
        accessibilityActionCompat = null;
        if (accessibilityActionCompat != null) {
        }
        sdk.pendo.io.w6.a aVar2 = sdk.pendo.io.w6.a.a;
        ActivationManager activationManager2 = ActivationManager.INSTANCE;
        b1 b1Var2 = b1.a;
        sdk.pendo.io.b8.b bVar2 = sdk.pendo.io.b8.b.a;
        sdk.pendo.io.d6.c cVarH2 = sdk.pendo.io.d6.c.h();
        Intrinsics.checkNotNullExpressionValue(cVarH2, "getInstance(...)");
        arrayList.add(new sdk.pendo.io.q5.a(aVar2, activationManager2, accessibilityActionCompat, b1Var2, bVar2, cVarH2, label, 16));
    }

    public static final boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public static final MotionEvent a(MotionEvent motionEvent) {
        int i;
        Intrinsics.checkNotNullParameter(motionEvent, "<this>");
        int action = motionEvent.getAction();
        if (action == 7) {
            i = 2;
        } else if (action == 9) {
            i = 0;
        } else {
            if (action != 10) {
                return motionEvent;
            }
            i = 1;
        }
        motionEvent.setAction(i);
        return motionEvent;
    }
}
