package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\u0003*\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\f\u001a\u00020\r*\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\t*\u00020\rH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\rH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0003H\u0017¢\u0006\u0004\b\u0016\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\u0003H\u0017¢\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0017J\u0013\u0010\u001f\u001a\u00020 *\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020!*\u00020 H\u0017¢\u0006\u0004\b%\u0010#R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "toPx", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Density extends FontScaling {
    float getDensity();

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m9675toDpGaN1DYA(Density density, long j) {
            return Density.super.mo749toDpGaN1DYA(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m9682toSp0xMU5do(Density density, float f) {
            return Density.super.mo756toSp0xMU5do(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m9680toPx0680j_4(Density density, float f) {
            return Density.super.mo754toPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m9674roundToPx0680j_4(Density density, float f) {
            return Density.super.mo748roundToPx0680j_4(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m9679toPxR2X_6o(Density density, long j) {
            return Density.super.mo753toPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m9673roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo747roundToPxR2X_6o(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m9677toDpu2uoSUM(Density density, int i) {
            return Density.super.mo751toDpu2uoSUM(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m9684toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo758toSpkPz2Gy4(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m9676toDpu2uoSUM(Density density, float f) {
            return Density.super.mo750toDpu2uoSUM(f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m9683toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo757toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m9681toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo755toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m9678toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo752toDpSizekrfVVM(j);
        }
    }

    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo754toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo748roundToPx0680j_4(float f) {
        float fMo754toPx0680j_4 = mo754toPx0680j_4(f);
        if (Float.isInfinite(fMo754toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo754toPx0680j_4);
    }

    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo753toPxR2X_6o(long j) {
        if (!TextUnitType.m9909equalsimpl0(TextUnit.m9880getTypeUIouoOA(j), TextUnitType.INSTANCE.m9914getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        return mo754toPx0680j_4(mo749toDpGaN1DYA(j));
    }

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo747roundToPxR2X_6o(long j) {
        return Math.round(mo753toPxR2X_6o(j));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo751toDpu2uoSUM(int i) {
        return Dp.m9687constructorimpl(i / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo758toSpkPz2Gy4(int i) {
        return mo756toSp0xMU5do(mo751toDpu2uoSUM(i));
    }

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo750toDpu2uoSUM(float f) {
        return Dp.m9687constructorimpl(f / getDensity());
    }

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo757toSpkPz2Gy4(float f) {
        return mo756toSp0xMU5do(mo750toDpu2uoSUM(f));
    }

    default Rect toRect(DpRect dpRect) {
        return new Rect(mo754toPx0680j_4(dpRect.m9770getLeftD9Ej5fM()), mo754toPx0680j_4(dpRect.m9772getTopD9Ej5fM()), mo754toPx0680j_4(dpRect.m9771getRightD9Ej5fM()), mo754toPx0680j_4(dpRect.m9769getBottomD9Ej5fM()));
    }

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo755toSizeXkaWNTQ(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            float fMo754toPx0680j_4 = mo754toPx0680j_4(DpSize.m9785getWidthD9Ej5fM(j));
            float fMo754toPx0680j_5 = mo754toPx0680j_4(DpSize.m9783getHeightD9Ej5fM(j));
            return Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo754toPx0680j_5)) & 4294967295L));
        }
        return Size.INSTANCE.m6646getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo752toDpSizekrfVVM(long j) {
        if (j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
            return DpKt.m9709DpSizeYgX7TsA(mo750toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), mo750toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
        }
        return DpSize.INSTANCE.m9794getUnspecifiedMYxV2XQ();
    }
}
