package com.box.android.base.compose;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: ViewInteropNestedScrollConnection.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0082\b\u001a\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u000f*\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"rememberViewInteropNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ceilAwayFromZero", "", "toOffset", "Landroidx/compose/ui/geometry/Offset;", GuideCapping.INSERT_CAPPING_CONSUMED, "", "originalOffset", "toOffset-Uv8p0NA", "([IJ)J", "toViewType", "", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "guessScrollAxis", "guessScrollAxis-k-4lQ0M", "(J)I", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewInteropNestedScrollConnectionKt {
    public static final NestedScrollConnection rememberViewInteropNestedScrollConnection(View view, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1859209206, "C(rememberViewInteropNestedScrollConnection)N(view)25@1027L7,25@1062L62:ViewInteropNestedScrollConnection.kt#vejmn0");
        if ((i2 & 1) != 0) {
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composer);
            view = (View) objConsume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1859209206, i, -1, "com.box.android.base.compose.rememberViewInteropNestedScrollConnection (ViewInteropNestedScrollConnection.kt:25)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -6344780, "CC(remember):ViewInteropNestedScrollConnection.kt#9igjgp");
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ViewInteropNestedScrollConnection(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        ViewInteropNestedScrollConnection viewInteropNestedScrollConnection = (ViewInteropNestedScrollConnection) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return viewInteropNestedScrollConnection;
    }

    private static final float ceilAwayFromZero(float f) {
        return (float) (f >= 0.0f ? Math.ceil(f) : Math.floor(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toOffset-Uv8p0NA, reason: not valid java name */
    public static final long m11674toOffsetUv8p0NA(int[] iArr, long j) {
        float fCoerceAtLeast;
        float fCoerceAtLeast2;
        if (iArr.length != 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        float f = iArr[0] * (-1.0f);
        int i = (int) (j >> 32);
        if (Float.intBitsToFloat(i) >= 0.0f) {
            fCoerceAtLeast = RangesKt.coerceAtMost(f, Float.intBitsToFloat(i));
        } else {
            fCoerceAtLeast = RangesKt.coerceAtLeast(f, Float.intBitsToFloat(i));
        }
        float f2 = iArr[1] * (-1.0f);
        int i2 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i2) >= 0.0f) {
            fCoerceAtLeast2 = RangesKt.coerceAtMost(f2, Float.intBitsToFloat(i2));
        } else {
            fCoerceAtLeast2 = RangesKt.coerceAtLeast(f2, Float.intBitsToFloat(i2));
        }
        return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fCoerceAtLeast)) << 32) | (((long) Float.floatToRawIntBits(fCoerceAtLeast2)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toViewType-GyEprt8, reason: not valid java name */
    public static final int m11675toViewTypeGyEprt8(int i) {
        return !NestedScrollSource.m8002equalsimpl0(i, NestedScrollSource.INSTANCE.m8010getDragWNlRxjI()) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: guessScrollAxis-k-4lQ0M, reason: not valid java name */
    public static final int m11673guessScrollAxisk4lQ0M(long j) {
        int i = Math.abs(Float.intBitsToFloat((int) (j >> 32))) >= 0.5f ? 1 : 0;
        return Math.abs(Float.intBitsToFloat((int) (j & 4294967295L))) >= 0.5f ? i | 2 : i;
    }
}
