package com.box.android.base.presentation.utilities;

import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EdgeToEdgeUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/utilities/EdgeToEdgeUtils;", "", "<init>", "()V", "enableDarkEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "enableAutoEdgeToEdge", "statusBarColor", "", "setInsets", "parentLayout", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/base/presentation/utilities/EdgeToEdgeUtils$OnInsetsAppliedListener;", "enableTransparentEdgeToEdge", "OnInsetsAppliedListener", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EdgeToEdgeUtils {
    public static final int $stable = 0;
    public static final EdgeToEdgeUtils INSTANCE = new EdgeToEdgeUtils();

    /* JADX INFO: compiled from: EdgeToEdgeUtils.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/utilities/EdgeToEdgeUtils$OnInsetsAppliedListener;", "", "onInsetsApplied", "", "view", "Landroid/view/View;", "systemBarInsets", "Landroidx/core/graphics/Insets;", "fullWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface OnInsetsAppliedListener {
        void onInsetsApplied(View view, Insets systemBarInsets, WindowInsetsCompat fullWindowInsets);
    }

    private EdgeToEdgeUtils() {
    }

    public final void enableDarkEdgeToEdge(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        EdgeToEdge.enable$default(componentActivity, SystemBarStyle.INSTANCE.dark(ColorKt.m6868toArgb8_81llA(Color.INSTANCE.m6849getTransparent0d7_KjU())), null, 2, null);
    }

    public final void enableAutoEdgeToEdge(ComponentActivity componentActivity, int i) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        EdgeToEdge.enable$default(componentActivity, SystemBarStyle.Companion.auto$default(SystemBarStyle.INSTANCE, i, i, null, 4, null), null, 2, null);
    }

    public static /* synthetic */ void setInsets$default(EdgeToEdgeUtils edgeToEdgeUtils, View view, OnInsetsAppliedListener onInsetsAppliedListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onInsetsAppliedListener = null;
        }
        edgeToEdgeUtils.setInsets(view, onInsetsAppliedListener);
    }

    public final void setInsets(View parentLayout, final OnInsetsAppliedListener listener) {
        if (parentLayout != null) {
            ViewCompat.setOnApplyWindowInsetsListener(parentLayout, new OnApplyWindowInsetsListener() { // from class: com.box.android.base.presentation.utilities.EdgeToEdgeUtils$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return EdgeToEdgeUtils.setInsets$lambda$0$0(listener, view, windowInsetsCompat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setInsets$lambda$0$0(OnInsetsAppliedListener onInsetsAppliedListener, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), insets.top, view.getPaddingRight(), view.getPaddingBottom());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.leftMargin = insets.left;
            marginLayoutParams.rightMargin = insets.right;
        }
        if (onInsetsAppliedListener != null) {
            onInsetsAppliedListener.onInsetsApplied(view, insets, windowInsets);
        }
        return WindowInsetsCompat.CONSUMED;
    }

    public final void enableTransparentEdgeToEdge(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        EdgeToEdge.enable$default(componentActivity, null, null, 3, null);
        componentActivity.getWindow().setNavigationBarContrastEnforced(false);
    }
}
