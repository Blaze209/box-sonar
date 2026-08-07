package com.facebook.react.modules.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/facebook/react/modules/dialog/AlertFragment$Companion$getAccessibleTitle$1", "Landroidx/core/view/AccessibilityDelegateCompat;", "onInitializeAccessibilityNodeInfo", "", "view", "Landroid/view/View;", BoxRepresentation.FIELD_INFO, "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlertFragment$Companion$getAccessibleTitle$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ TextView $accessibleTitle;

    AlertFragment$Companion$getAccessibleTitle$1(TextView textView) {
        this.$accessibleTitle = textView;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(this.$accessibleTitle, info);
        info.setHeading(true);
    }
}
