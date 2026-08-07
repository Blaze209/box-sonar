package com.pspdfkit.ui.toolbar;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"applyWindowInsets", "", "Landroid/view/View;", "left", "", ViewProps.TOP, "right", ViewProps.BOTTOM, "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ToolbarExtKt {
    public static final void applyWindowInsets(View view, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        view.getClass();
        ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.ui.toolbar.ToolbarExtKt$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ToolbarExtKt.applyWindowInsets$lambda$0(z, z2, z3, z4, view2, windowInsetsCompat);
            }
        });
    }

    public static /* synthetic */ void applyWindowInsets$default(View view, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        if ((i & 8) != 0) {
            z4 = false;
        }
        applyWindowInsets(view, z, z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyWindowInsets$lambda$0(boolean z, boolean z2, boolean z3, boolean z4, View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        insets.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z) {
            marginLayoutParams.leftMargin = insets.left;
        }
        if (z2) {
            marginLayoutParams.topMargin = insets.top;
        }
        if (z3) {
            marginLayoutParams.rightMargin = insets.right;
        }
        if (z4) {
            marginLayoutParams.bottomMargin = insets.bottom;
        }
        view.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.CONSUMED;
    }
}
