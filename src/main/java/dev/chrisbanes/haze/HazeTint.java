package dev.chrisbanes.haze;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HazeStyle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u001f"}, d2 = {"Ldev/chrisbanes/haze/HazeTint;", "", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "<init>", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getBlendMode-0nO6VwU", "()I", "I", "isSpecified", "", "()Z", "component1", "component1-0d7_KjU", "component2", "component2-0nO6VwU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-xETnrds", "(JI)Ldev/chrisbanes/haze/HazeTint;", "equals", "other", "hashCode", "", "toString", "", "Companion", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HazeTint {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HazeTint Unspecified = new HazeTint(Color.INSTANCE.m6850getUnspecified0d7_KjU(), 0, 2, null);
    private final int blendMode;
    private final long color;

    public /* synthetic */ HazeTint(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i);
    }

    /* JADX INFO: renamed from: copy-xETnrds$default, reason: not valid java name */
    public static /* synthetic */ HazeTint m14503copyxETnrds$default(HazeTint hazeTint, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = hazeTint.color;
        }
        if ((i2 & 2) != 0) {
            i = hazeTint.blendMode;
        }
        return hazeTint.m14506copyxETnrds(j, i);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    /* JADX INFO: renamed from: copy-xETnrds, reason: not valid java name */
    public final HazeTint m14506copyxETnrds(long color, int blendMode) {
        return new HazeTint(color, blendMode, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HazeTint)) {
            return false;
        }
        HazeTint hazeTint = (HazeTint) other;
        return Color.m6815equalsimpl0(this.color, hazeTint.color) && BlendMode.m6723equalsimpl0(this.blendMode, hazeTint.blendMode);
    }

    public int hashCode() {
        return (Color.m6821hashCodeimpl(this.color) * 31) + BlendMode.m6724hashCodeimpl(this.blendMode);
    }

    public String toString() {
        return "HazeTint(color=" + Color.m6822toStringimpl(this.color) + ", blendMode=" + BlendMode.m6725toStringimpl(this.blendMode) + ")";
    }

    private HazeTint(long j, int i) {
        this.color = j;
        this.blendMode = i;
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m14508getColor0d7_KjU() {
        return this.color;
    }

    public /* synthetic */ HazeTint(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? BlendMode.INSTANCE.m6754getSrcOver0nO6VwU() : i, null);
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m14507getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    /* JADX INFO: compiled from: HazeStyle.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldev/chrisbanes/haze/HazeTint$Companion;", "", "<init>", "()V", "Unspecified", "Ldev/chrisbanes/haze/HazeTint;", "getUnspecified", "()Ldev/chrisbanes/haze/HazeTint;", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HazeTint getUnspecified() {
            return HazeTint.Unspecified;
        }
    }

    public final boolean isSpecified() {
        return this.color != 16;
    }
}
