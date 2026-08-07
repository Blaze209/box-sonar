package sdk.pendo.io.q5;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.actions.IActivationManager;
import sdk.pendo.io.d6.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.s;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.w6.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001\u0005BK\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lsdk/pendo/io/q5/a;", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;", "Landroid/view/View;", "view", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/os/Bundle;", "arguments", "", "perform", "Lsdk/pendo/io/w6/c;", "Lsdk/pendo/io/w6/c;", "analyticsManager", "Lsdk/pendo/io/actions/IActivationManager;", "b", "Lsdk/pendo/io/actions/IActivationManager;", "activationManager", "c", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;", "originalCustomAction", "Lsdk/pendo/io/s7/s;", "d", "Lsdk/pendo/io/s7/s;", "viewHierarchyUtility", "Lsdk/pendo/io/b8/a;", "e", "Lsdk/pendo/io/b8/a;", "pendoViewDelegateHelper", "Lsdk/pendo/io/d6/d;", "f", "Lsdk/pendo/io/d6/d;", "applicationObservers", "", "label", "", "actionId", "<init>", "(Lsdk/pendo/io/w6/c;Lsdk/pendo/io/actions/IActivationManager;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$AccessibilityActionCompat;Lsdk/pendo/io/s7/s;Lsdk/pendo/io/b8/a;Lsdk/pendo/io/d6/d;Ljava/lang/CharSequence;I)V", "g", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends AccessibilityNodeInfoCompat.AccessibilityActionCompat {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final c analyticsManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final IActivationManager activationManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat originalCustomAction;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final s viewHierarchyUtility;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final sdk.pendo.io.b8.a pendoViewDelegateHelper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final d applicationObservers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c analyticsManager, IActivationManager activationManager, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, s viewHierarchyUtility, sdk.pendo.io.b8.a pendoViewDelegateHelper, d applicationObservers, CharSequence charSequence, int i) {
        super(i, charSequence);
        Intrinsics.checkNotNullParameter(analyticsManager, "analyticsManager");
        Intrinsics.checkNotNullParameter(activationManager, "activationManager");
        Intrinsics.checkNotNullParameter(viewHierarchyUtility, "viewHierarchyUtility");
        Intrinsics.checkNotNullParameter(pendoViewDelegateHelper, "pendoViewDelegateHelper");
        Intrinsics.checkNotNullParameter(applicationObservers, "applicationObservers");
        this.analyticsManager = analyticsManager;
        this.activationManager = activationManager;
        this.originalCustomAction = accessibilityActionCompat;
        this.viewHierarchyUtility = viewHierarchyUtility;
        this.pendoViewDelegateHelper = pendoViewDelegateHelper;
        this.applicationObservers = applicationObservers;
    }

    private final void a(View view) {
        try {
            JSONObject jSONObjectA = this.viewHierarchyUtility.a(view);
            this.pendoViewDelegateHelper.a(view, PlatformStateManager.INSTANCE);
            this.analyticsManager.a(jSONObjectA, false);
            boolean z = this.applicationObservers.a() != null;
            PendoLogger.d("Clicked view: " + view, new Object[0]);
            if (z) {
                IActivationManager.DefaultImpls.handleClick$default(this.activationManager, jSONObjectA, null, 2, null);
            }
        } catch (Exception e) {
            PendoLogger.e("PendoAccessibilityAction createClickAnalyticAndCheckForGuides failed " + e.getMessage(), e);
        }
    }

    @Override // androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
    public boolean perform(View view, Bundle arguments) {
        if (view != null) {
            a(view);
        }
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = this.originalCustomAction;
        if (accessibilityActionCompat != null) {
            return accessibilityActionCompat.perform(view, arguments);
        }
        return false;
    }
}
