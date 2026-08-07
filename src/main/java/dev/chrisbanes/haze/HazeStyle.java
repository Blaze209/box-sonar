package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rB=\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0016J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003JH\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Ldev/chrisbanes/haze/HazeStyle;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "tints", "", "Ldev/chrisbanes/haze/HazeTint;", "blurRadius", "Landroidx/compose/ui/unit/Dp;", "noiseFactor", "", "fallbackTint", "<init>", "(JLjava/util/List;FFLdev/chrisbanes/haze/HazeTint;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "tint", "(JLdev/chrisbanes/haze/HazeTint;FFLdev/chrisbanes/haze/HazeTint;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getTints", "()Ljava/util/List;", "getBlurRadius-D9Ej5fM", "()F", "F", "getNoiseFactor", "getFallbackTint", "()Ldev/chrisbanes/haze/HazeTint;", "component1", "component1-0d7_KjU", "component2", "component3", "component3-D9Ej5fM", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-cq6XJ1M", "(JLjava/util/List;FFLdev/chrisbanes/haze/HazeTint;)Ldev/chrisbanes/haze/HazeStyle;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HazeStyle {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HazeStyle Unspecified = new HazeStyle(0, CollectionsKt.emptyList(), 0.0f, 0.0f, (HazeTint) null, 29, (DefaultConstructorMarker) null);
    private final long backgroundColor;
    private final float blurRadius;
    private final HazeTint fallbackTint;
    private final float noiseFactor;
    private final List<HazeTint> tints;

    public /* synthetic */ HazeStyle(long j, HazeTint hazeTint, float f, float f2, HazeTint hazeTint2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, hazeTint, f, f2, hazeTint2);
    }

    public /* synthetic */ HazeStyle(long j, List list, float f, float f2, HazeTint hazeTint, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (List<HazeTint>) list, f, f2, hazeTint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-cq6XJ1M$default, reason: not valid java name */
    public static /* synthetic */ HazeStyle m14496copycq6XJ1M$default(HazeStyle hazeStyle, long j, List list, float f, float f2, HazeTint hazeTint, int i, Object obj) {
        if ((i & 1) != 0) {
            j = hazeStyle.backgroundColor;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = hazeStyle.tints;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            f = hazeStyle.blurRadius;
        }
        float f3 = f;
        if ((i & 8) != 0) {
            f2 = hazeStyle.noiseFactor;
        }
        float f4 = f2;
        if ((i & 16) != 0) {
            hazeTint = hazeStyle.fallbackTint;
        }
        return hazeStyle.m14499copycq6XJ1M(j2, list2, f3, f4, hazeTint);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<HazeTint> component2() {
        return this.tints;
    }

    /* JADX INFO: renamed from: component3-D9Ej5fM, reason: not valid java name and from getter */
    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getNoiseFactor() {
        return this.noiseFactor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final HazeTint getFallbackTint() {
        return this.fallbackTint;
    }

    /* JADX INFO: renamed from: copy-cq6XJ1M, reason: not valid java name */
    public final HazeStyle m14499copycq6XJ1M(long backgroundColor, List<HazeTint> tints, float blurRadius, float noiseFactor, HazeTint fallbackTint) {
        Intrinsics.checkNotNullParameter(tints, "tints");
        Intrinsics.checkNotNullParameter(fallbackTint, "fallbackTint");
        return new HazeStyle(backgroundColor, tints, blurRadius, noiseFactor, fallbackTint, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HazeStyle)) {
            return false;
        }
        HazeStyle hazeStyle = (HazeStyle) other;
        return Color.m6815equalsimpl0(this.backgroundColor, hazeStyle.backgroundColor) && Intrinsics.areEqual(this.tints, hazeStyle.tints) && Dp.m9692equalsimpl0(this.blurRadius, hazeStyle.blurRadius) && Float.compare(this.noiseFactor, hazeStyle.noiseFactor) == 0 && Intrinsics.areEqual(this.fallbackTint, hazeStyle.fallbackTint);
    }

    public int hashCode() {
        return (((((((Color.m6821hashCodeimpl(this.backgroundColor) * 31) + this.tints.hashCode()) * 31) + Dp.m9693hashCodeimpl(this.blurRadius)) * 31) + Float.hashCode(this.noiseFactor)) * 31) + this.fallbackTint.hashCode();
    }

    public String toString() {
        return "HazeStyle(backgroundColor=" + Color.m6822toStringimpl(this.backgroundColor) + ", tints=" + this.tints + ", blurRadius=" + Dp.m9698toStringimpl(this.blurRadius) + ", noiseFactor=" + this.noiseFactor + ", fallbackTint=" + this.fallbackTint + ")";
    }

    private HazeStyle(long j, List<HazeTint> tints, float f, float f2, HazeTint fallbackTint) {
        Intrinsics.checkNotNullParameter(tints, "tints");
        Intrinsics.checkNotNullParameter(fallbackTint, "fallbackTint");
        this.backgroundColor = j;
        this.tints = tints;
        this.blurRadius = f;
        this.noiseFactor = f2;
        this.fallbackTint = fallbackTint;
    }

    public /* synthetic */ HazeStyle(long j, List list, float f, float f2, HazeTint hazeTint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 8) != 0 ? -1.0f : f2, (i & 16) != 0 ? HazeTint.INSTANCE.getUnspecified() : hazeTint, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m14500getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final List<HazeTint> getTints() {
        return this.tints;
    }

    /* JADX INFO: renamed from: getBlurRadius-D9Ej5fM, reason: not valid java name */
    public final float m14501getBlurRadiusD9Ej5fM() {
        return this.blurRadius;
    }

    public final float getNoiseFactor() {
        return this.noiseFactor;
    }

    public final HazeTint getFallbackTint() {
        return this.fallbackTint;
    }

    public /* synthetic */ HazeStyle(long j, HazeTint hazeTint, float f, float f2, HazeTint hazeTint2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j, (i & 2) != 0 ? null : hazeTint, (i & 4) != 0 ? Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM() : f, (i & 8) != 0 ? -1.0f : f2, (i & 16) != 0 ? HazeTint.INSTANCE.getUnspecified() : hazeTint2, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private HazeStyle(long j, HazeTint hazeTint, float f, float f2, HazeTint fallbackTint) {
        this(j, CollectionsKt.listOfNotNull(hazeTint), f, f2, fallbackTint, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fallbackTint, "fallbackTint");
    }

    /* JADX INFO: compiled from: HazeStyle.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldev/chrisbanes/haze/HazeStyle$Companion;", "", "<init>", "()V", "Unspecified", "Ldev/chrisbanes/haze/HazeStyle;", "getUnspecified", "()Ldev/chrisbanes/haze/HazeStyle;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HazeStyle getUnspecified() {
            return HazeStyle.Unspecified;
        }
    }
}
