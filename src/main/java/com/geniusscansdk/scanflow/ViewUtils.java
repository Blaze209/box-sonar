package com.geniusscansdk.scanflow;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.ColorUtils;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005H\u0007J\u001e\u0010\r\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005J \u0010\u000f\u001a\u00020\t*\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0005H\u0002J\u001e\u0010\b\u001a\u00020\t*\u00020\u00112\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\t*\u00020\u00122\b\b\u0001\u0010\f\u001a\u00020\u0005H\u0002J\u001c\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\b\u0001\u0010\u0017\u001a\u00020\u0005H\u0002J\u0016\u0010\b\u001a\u00020\t*\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0005H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0019\u001a\u00020\u0005J'\u0010\u001c\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/geniusscansdk/scanflow/ViewUtils;", "", "<init>", "()V", "RIPPLE_COLOR_DARK", "", "RIPPLE_COLOR_LIGHT", "DISABLED_COLOR", "applyColor", "", "Lcom/google/android/material/button/MaterialButton;", ViewProps.FOREGROUND_COLOR, "backgroundColor", "applyColorForFilled", "applyColorForOutlined", "applyBackgroundColor", "disabledColor", "Landroid/widget/TextView;", "Landroid/view/View;", "getColorStateList", "Landroid/content/res/ColorStateList;", "enabledColor", "getColorStateSelectedList", ColorPickerFragment.EXTRA_SELECTED_COLOR, "Landroid/widget/ProgressBar;", "color", "isColorDark", "", "calculateItemSize", "", "itemInitialSize", "totalWidth", "(Ljava/util/List;II)Ljava/lang/Integer;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewUtils {
    private static final int DISABLED_COLOR = -7829368;
    public static final ViewUtils INSTANCE = new ViewUtils();
    private static final int RIPPLE_COLOR_DARK = Color.parseColor("#33ffffff");
    private static final int RIPPLE_COLOR_LIGHT = Color.parseColor("#1f000000");

    private ViewUtils() {
    }

    @JvmStatic
    public static final void applyColor(MaterialButton materialButton, int i, int i2) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        ViewUtils viewUtils = INSTANCE;
        materialButton.setTextColor(getColorStateList$default(viewUtils, i, 0, 2, null));
        viewUtils.applyBackgroundColor(materialButton, i2, i2);
        materialButton.setIconTint(getColorStateList$default(viewUtils, i, 0, 2, null));
    }

    public final void applyColorForFilled(MaterialButton materialButton, int i, int i2) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        materialButton.setTextColor(getColorStateList(i2, -1));
        applyBackgroundColor(materialButton, i, DISABLED_COLOR);
    }

    public final void applyColorForOutlined(MaterialButton materialButton, int i, int i2) {
        Intrinsics.checkNotNullParameter(materialButton, "<this>");
        applyColor(materialButton, i, i2);
        materialButton.setStrokeColor(getColorStateList$default(this, i, 0, 2, null));
    }

    private final void applyBackgroundColor(MaterialButton materialButton, int i, int i2) {
        materialButton.setBackgroundTintList(getColorStateList(i, i2));
        materialButton.setRippleColor(ColorStateList.valueOf(isColorDark(i) ? RIPPLE_COLOR_DARK : RIPPLE_COLOR_LIGHT));
    }

    public final void applyColor(TextView textView, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(getColorStateSelectedList(i));
        applyBackgroundColor(textView, i2);
    }

    private final void applyBackgroundColor(View view, int i) {
        if (view.getBackground() instanceof RippleDrawable) {
            int i2 = isColorDark(i) ? RIPPLE_COLOR_DARK : RIPPLE_COLOR_LIGHT;
            Drawable background = view.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.RippleDrawable");
            ((RippleDrawable) background).setColor(ColorStateList.valueOf(i2));
        }
    }

    static /* synthetic */ ColorStateList getColorStateList$default(ViewUtils viewUtils, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = DISABLED_COLOR;
        }
        return viewUtils.getColorStateList(i, i2);
    }

    private final ColorStateList getColorStateList(int enabledColor, int disabledColor) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{enabledColor, disabledColor});
    }

    private final ColorStateList getColorStateSelectedList(int selectedColor) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{-16842913}}, new int[]{selectedColor, DISABLED_COLOR});
    }

    @JvmStatic
    public static final void applyColor(ProgressBar progressBar, int i) {
        Intrinsics.checkNotNullParameter(progressBar, "<this>");
        progressBar.getIndeterminateDrawable().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(i, BlendModeCompat.SRC_IN));
    }

    public final boolean isColorDark(int color) {
        return ColorUtils.calculateLuminance(color) < 0.5d;
    }

    public final Integer calculateItemSize(List<? extends Object> list, int i, int i2) {
        float f;
        float f2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        float size = i2 / list.size();
        float f3 = i;
        if (size >= f3) {
            return null;
        }
        float f4 = i2;
        float f5 = f4 / f3;
        double d = f5 % 1;
        if (0.2d <= d && d <= 0.8d) {
            return null;
        }
        if (d < 0.2d) {
            f = (int) f5;
            f2 = 0.3f;
        } else {
            f = (int) f5;
            f2 = 0.7f;
        }
        return Integer.valueOf((int) (f4 / (f + f2)));
    }
}
