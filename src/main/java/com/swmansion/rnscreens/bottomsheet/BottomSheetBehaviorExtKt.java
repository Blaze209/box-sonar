package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomSheetBehaviorExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\f\u001aW\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u0010\u001ao\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000¨\u0006\u0019"}, d2 = {"updateMetrics", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "maxAllowedHeight", "", "expandedOffsetFromTop", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "useSingleDetent", "forceExpandedState", "", "enableManualInsetsAdjustmentWorkaround", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;ZLjava/lang/Boolean;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "useTwoDetents", "state", "firstHeight", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "useThreeDetents", "halfExpandedRatio", "", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "maybeApplyManualInsetsAdjustmentWorkaround", "", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Ljava/lang/Boolean;)V", "fitToContentsSheetHeight", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BottomSheetBehaviorExtKt {
    public static /* synthetic */ BottomSheetBehavior updateMetrics$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return updateMetrics(bottomSheetBehavior, num, num2);
    }

    public static final <T extends View> BottomSheetBehavior<T> updateMetrics(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setMaxHeight(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            bottomSheetBehavior.setExpandedOffset(num2.intValue());
        }
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useSingleDetent$default(BottomSheetBehavior bottomSheetBehavior, Integer num, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return useSingleDetent(bottomSheetBehavior, num, z, bool);
    }

    public static final <T extends View> BottomSheetBehavior<T> useSingleDetent(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(true);
        bottomSheetBehavior.setFitToContents(true);
        if (z) {
            bottomSheetBehavior.setState(3);
        }
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setMaxHeight(num.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useTwoDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        return useTwoDetents(bottomSheetBehavior, num, num2, num3, bool);
    }

    public static final <T extends View> BottomSheetBehavior<T> useTwoDetents(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, Integer num2, Integer num3, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(true);
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (num3 != null) {
            num3.intValue();
            bottomSheetBehavior.setMaxHeight(num3.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    public static /* synthetic */ BottomSheetBehavior useThreeDetents$default(BottomSheetBehavior bottomSheetBehavior, Integer num, Integer num2, Integer num3, Float f, Integer num4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            f = null;
        }
        if ((i & 16) != 0) {
            num4 = null;
        }
        if ((i & 32) != 0) {
            bool = null;
        }
        return useThreeDetents(bottomSheetBehavior, num, num2, num3, f, num4, bool);
    }

    public static final <T extends View> BottomSheetBehavior<T> useThreeDetents(BottomSheetBehavior<T> bottomSheetBehavior, Integer num, Integer num2, Integer num3, Float f, Integer num4, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        bottomSheetBehavior.setSkipCollapsed(false);
        bottomSheetBehavior.setFitToContents(false);
        if (num != null) {
            num.intValue();
            bottomSheetBehavior.setState(num.intValue());
        }
        if (num2 != null) {
            num2.intValue();
            bottomSheetBehavior.setPeekHeight(num2.intValue());
        }
        if (f != null) {
            f.floatValue();
            bottomSheetBehavior.setHalfExpandedRatio(f.floatValue());
        }
        if (num4 != null) {
            num4.intValue();
            bottomSheetBehavior.setExpandedOffset(num4.intValue());
        }
        if (num3 != null) {
            num3.intValue();
            bottomSheetBehavior.setMaxHeight(num3.intValue());
        }
        maybeApplyManualInsetsAdjustmentWorkaround(bottomSheetBehavior, bool);
        return bottomSheetBehavior;
    }

    private static final <T extends View> void maybeApplyManualInsetsAdjustmentWorkaround(BottomSheetBehavior<T> bottomSheetBehavior, Boolean bool) {
        if (bool != null) {
            bottomSheetBehavior.setGestureInsetBottomIgnored(bool.booleanValue());
        }
    }

    public static final <T extends View> int fitToContentsSheetHeight(BottomSheetBehavior<T> bottomSheetBehavior) {
        Intrinsics.checkNotNullParameter(bottomSheetBehavior, "<this>");
        return bottomSheetBehavior.getMaxHeight();
    }
}
