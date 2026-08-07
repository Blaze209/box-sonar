package dev.chrisbanes.haze;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeEffectNode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00032\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Ldev/chrisbanes/haze/HazeProgressive;", "", "LinearGradient", "Companion", "Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HazeProgressive {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: HazeEffectNode.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JL\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "Ldev/chrisbanes/haze/HazeProgressive;", "easing", "Landroidx/compose/animation/core/Easing;", "start", "Landroidx/compose/ui/geometry/Offset;", "startIntensity", "", "end", "endIntensity", "preferPerformance", "", "<init>", "(Landroidx/compose/animation/core/Easing;JFJFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getStart-F1C5BW0", "()J", "J", "getStartIntensity", "()F", "getEnd-F1C5BW0", "getEndIntensity", "getPreferPerformance", "()Z", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "component4-F1C5BW0", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-E2oHoeU", "(Landroidx/compose/animation/core/Easing;JFJFZ)Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "equals", "other", "", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class LinearGradient implements HazeProgressive {
        public static final int $stable = 0;
        private final Easing easing;
        private final long end;
        private final float endIntensity;
        private final boolean preferPerformance;
        private final long start;
        private final float startIntensity;

        public /* synthetic */ LinearGradient(Easing easing, long j, float f, long j2, float f2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(easing, j, f, j2, f2, z);
        }

        /* JADX INFO: renamed from: copy-E2oHoeU$default, reason: not valid java name */
        public static /* synthetic */ LinearGradient m14483copyE2oHoeU$default(LinearGradient linearGradient, Easing easing, long j, float f, long j2, float f2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                easing = linearGradient.easing;
            }
            if ((i & 2) != 0) {
                j = linearGradient.start;
            }
            if ((i & 4) != 0) {
                f = linearGradient.startIntensity;
            }
            if ((i & 8) != 0) {
                j2 = linearGradient.end;
            }
            if ((i & 16) != 0) {
                f2 = linearGradient.endIntensity;
            }
            if ((i & 32) != 0) {
                z = linearGradient.preferPerformance;
            }
            float f3 = f;
            return linearGradient.m14486copyE2oHoeU(easing, j, f3, j2, f2, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Easing getEasing() {
            return this.easing;
        }

        /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name and from getter */
        public final long getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final float getStartIntensity() {
            return this.startIntensity;
        }

        /* JADX INFO: renamed from: component4-F1C5BW0, reason: not valid java name and from getter */
        public final long getEnd() {
            return this.end;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getEndIntensity() {
            return this.endIntensity;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getPreferPerformance() {
            return this.preferPerformance;
        }

        /* JADX INFO: renamed from: copy-E2oHoeU, reason: not valid java name */
        public final LinearGradient m14486copyE2oHoeU(Easing easing, long start, float startIntensity, long end, float endIntensity, boolean preferPerformance) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new LinearGradient(easing, start, startIntensity, end, endIntensity, preferPerformance, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinearGradient)) {
                return false;
            }
            LinearGradient linearGradient = (LinearGradient) other;
            return Intrinsics.areEqual(this.easing, linearGradient.easing) && Offset.m6566equalsimpl0(this.start, linearGradient.start) && Float.compare(this.startIntensity, linearGradient.startIntensity) == 0 && Offset.m6566equalsimpl0(this.end, linearGradient.end) && Float.compare(this.endIntensity, linearGradient.endIntensity) == 0 && this.preferPerformance == linearGradient.preferPerformance;
        }

        public int hashCode() {
            return (((((((((this.easing.hashCode() * 31) + Offset.m6571hashCodeimpl(this.start)) * 31) + Float.hashCode(this.startIntensity)) * 31) + Offset.m6571hashCodeimpl(this.end)) * 31) + Float.hashCode(this.endIntensity)) * 31) + Boolean.hashCode(this.preferPerformance);
        }

        public String toString() {
            return "LinearGradient(easing=" + this.easing + ", start=" + Offset.m6577toStringimpl(this.start) + ", startIntensity=" + this.startIntensity + ", end=" + Offset.m6577toStringimpl(this.end) + ", endIntensity=" + this.endIntensity + ", preferPerformance=" + this.preferPerformance + ")";
        }

        private LinearGradient(Easing easing, long j, float f, long j2, float f2, boolean z) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            this.easing = easing;
            this.start = j;
            this.startIntensity = f;
            this.end = j2;
            this.endIntensity = f2;
            this.preferPerformance = z;
        }

        public /* synthetic */ LinearGradient(Easing easing, long j, float f, long j2, float f2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? EasingFunctionsKt.getEaseIn() : easing, (i & 2) != 0 ? Offset.INSTANCE.m6585getZeroF1C5BW0() : j, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? Offset.INSTANCE.m6583getInfiniteF1C5BW0() : j2, (i & 16) != 0 ? 1.0f : f2, (i & 32) != 0 ? false : z, null);
        }

        public final Easing getEasing() {
            return this.easing;
        }

        /* JADX INFO: renamed from: getStart-F1C5BW0, reason: not valid java name */
        public final long m14488getStartF1C5BW0() {
            return this.start;
        }

        public final float getStartIntensity() {
            return this.startIntensity;
        }

        /* JADX INFO: renamed from: getEnd-F1C5BW0, reason: not valid java name */
        public final long m14487getEndF1C5BW0() {
            return this.end;
        }

        public final float getEndIntensity() {
            return this.endIntensity;
        }

        public final boolean getPreferPerformance() {
            return this.preferPerformance;
        }
    }

    /* JADX INFO: compiled from: HazeEffectNode.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eJB\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Ldev/chrisbanes/haze/HazeProgressive$Companion;", "", "<init>", "()V", "verticalGradient", "Ldev/chrisbanes/haze/HazeProgressive$LinearGradient;", "easing", "Landroidx/compose/animation/core/Easing;", "startY", "", "startIntensity", "endY", "endIntensity", "preferPerformance", "", "horizontalGradient", "startX", "endX", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ LinearGradient verticalGradient$default(Companion companion, Easing easing, float f, float f2, float f3, float f4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                easing = EasingFunctionsKt.getEaseIn();
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            if ((i & 4) != 0) {
                f2 = 0.0f;
            }
            if ((i & 8) != 0) {
                f3 = Float.POSITIVE_INFINITY;
            }
            if ((i & 16) != 0) {
                f4 = 1.0f;
            }
            if ((i & 32) != 0) {
                z = false;
            }
            return companion.verticalGradient(easing, f, f2, f3, f4, z);
        }

        public final LinearGradient verticalGradient(Easing easing, float startY, float startIntensity, float endY, float endIntensity, boolean preferPerformance) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new LinearGradient(easing, OffsetKt.Offset(0.0f, startY), startIntensity, OffsetKt.Offset(0.0f, endY), endIntensity, preferPerformance, null);
        }

        public static /* synthetic */ LinearGradient horizontalGradient$default(Companion companion, Easing easing, float f, float f2, float f3, float f4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                easing = EasingFunctionsKt.getEaseIn();
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            if ((i & 4) != 0) {
                f2 = 0.0f;
            }
            if ((i & 8) != 0) {
                f3 = Float.POSITIVE_INFINITY;
            }
            if ((i & 16) != 0) {
                f4 = 1.0f;
            }
            if ((i & 32) != 0) {
                z = false;
            }
            return companion.horizontalGradient(easing, f, f2, f3, f4, z);
        }

        public final LinearGradient horizontalGradient(Easing easing, float startX, float startIntensity, float endX, float endIntensity, boolean preferPerformance) {
            Intrinsics.checkNotNullParameter(easing, "easing");
            return new LinearGradient(easing, OffsetKt.Offset(startX, 0.0f), startIntensity, OffsetKt.Offset(endX, 0.0f), endIntensity, preferPerformance, null);
        }
    }
}
