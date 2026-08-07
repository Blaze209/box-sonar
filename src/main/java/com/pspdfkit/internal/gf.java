package com.pspdfkit.internal;

import android.graphics.Paint;
import com.pspdfkit.annotations.BlendMode;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class gf {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BlendMode.values().length];
            try {
                iArr[BlendMode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlendMode.MULTIPLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlendMode.SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlendMode.OVERLAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BlendMode.DARKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BlendMode.LIGHTEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BlendMode.COLOR_DODGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[BlendMode.COLOR_BURN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[BlendMode.SOFT_LIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[BlendMode.HARD_LIGHT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[BlendMode.DIFFERENCE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[BlendMode.EXCLUSION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            a = iArr;
        }
    }

    public static final void a(Paint paint, BlendMode blendMode) {
        android.graphics.BlendMode blendMode2;
        blendMode.getClass();
        switch (a.a[blendMode.ordinal()]) {
            case 1:
                blendMode2 = null;
                break;
            case 2:
                blendMode2 = android.graphics.BlendMode.MULTIPLY;
                break;
            case 3:
                blendMode2 = android.graphics.BlendMode.SCREEN;
                break;
            case 4:
                blendMode2 = android.graphics.BlendMode.OVERLAY;
                break;
            case 5:
                blendMode2 = android.graphics.BlendMode.DARKEN;
                break;
            case 6:
                blendMode2 = android.graphics.BlendMode.LIGHTEN;
                break;
            case 7:
                blendMode2 = android.graphics.BlendMode.COLOR_DODGE;
                break;
            case 8:
                blendMode2 = android.graphics.BlendMode.COLOR_BURN;
                break;
            case 9:
                blendMode2 = android.graphics.BlendMode.SOFT_LIGHT;
                break;
            case 10:
                blendMode2 = android.graphics.BlendMode.HARD_LIGHT;
                break;
            case 11:
                blendMode2 = android.graphics.BlendMode.DIFFERENCE;
                break;
            case 12:
                blendMode2 = android.graphics.BlendMode.EXCLUSION;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        paint.setBlendMode(blendMode2);
    }

    public static final void a(androidx.compose.ui.graphics.Paint paint, BlendMode blendMode) {
        int iM6754getSrcOver0nO6VwU;
        paint.getClass();
        blendMode.getClass();
        switch (a.a[blendMode.ordinal()]) {
            case 1:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6754getSrcOver0nO6VwU();
                break;
            case 2:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6744getMultiply0nO6VwU();
                break;
            case 3:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6748getScreen0nO6VwU();
                break;
            case 4:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6745getOverlay0nO6VwU();
                break;
            case 5:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6731getDarken0nO6VwU();
                break;
            case 6:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6741getLighten0nO6VwU();
                break;
            case 7:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6730getColorDodge0nO6VwU();
                break;
            case 8:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6729getColorBurn0nO6VwU();
                break;
            case 9:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6749getSoftlight0nO6VwU();
                break;
            case 10:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6739getHardlight0nO6VwU();
                break;
            case 11:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6732getDifference0nO6VwU();
                break;
            case 12:
                iM6754getSrcOver0nO6VwU = androidx.compose.ui.graphics.BlendMode.INSTANCE.m6738getExclusion0nO6VwU();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        paint.mo6689setBlendModes9anfk8(iM6754getSrcOver0nO6VwU);
    }
}
