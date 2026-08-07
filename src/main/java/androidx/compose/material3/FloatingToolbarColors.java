package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/FloatingToolbarColors;", "", "toolbarContainerColor", "Landroidx/compose/ui/graphics/Color;", "toolbarContentColor", "fabContainerColor", "fabContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getToolbarContainerColor-0d7_KjU", "()J", "J", "getToolbarContentColor-0d7_KjU", "getFabContainerColor-0d7_KjU", "getFabContentColor-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/FloatingToolbarColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingToolbarColors {
    public static final int $stable = 0;
    private final long fabContainerColor;
    private final long fabContentColor;
    private final long toolbarContainerColor;
    private final long toolbarContentColor;

    public /* synthetic */ FloatingToolbarColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private FloatingToolbarColors(long j, long j2, long j3, long j4) {
        this.toolbarContainerColor = j;
        this.toolbarContentColor = j2;
        this.fabContainerColor = j3;
        this.fabContentColor = j4;
    }

    /* JADX INFO: renamed from: getToolbarContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getToolbarContainerColor() {
        return this.toolbarContainerColor;
    }

    /* JADX INFO: renamed from: getToolbarContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getToolbarContentColor() {
        return this.toolbarContentColor;
    }

    /* JADX INFO: renamed from: getFabContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabContainerColor() {
        return this.fabContainerColor;
    }

    /* JADX INFO: renamed from: getFabContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabContentColor() {
        return this.fabContentColor;
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ FloatingToolbarColors m3413copyjRlVdoo$default(FloatingToolbarColors floatingToolbarColors, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = floatingToolbarColors.toolbarContainerColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = floatingToolbarColors.toolbarContentColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = floatingToolbarColors.fabContainerColor;
        }
        return floatingToolbarColors.m3414copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? floatingToolbarColors.fabContentColor : j4);
    }

    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final FloatingToolbarColors m3414copyjRlVdoo(long toolbarContainerColor, long toolbarContentColor, long fabContainerColor, long fabContentColor) {
        return new FloatingToolbarColors(toolbarContainerColor != 16 ? toolbarContainerColor : this.toolbarContainerColor, toolbarContentColor != 16 ? toolbarContentColor : this.toolbarContentColor, fabContainerColor != 16 ? fabContainerColor : this.fabContainerColor, fabContentColor != 16 ? fabContentColor : this.fabContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof FloatingToolbarColors)) {
            return false;
        }
        FloatingToolbarColors floatingToolbarColors = (FloatingToolbarColors) other;
        return Color.m6815equalsimpl0(this.toolbarContainerColor, floatingToolbarColors.toolbarContainerColor) && Color.m6815equalsimpl0(this.toolbarContentColor, floatingToolbarColors.toolbarContentColor) && Color.m6815equalsimpl0(this.fabContainerColor, floatingToolbarColors.fabContainerColor) && Color.m6815equalsimpl0(this.fabContentColor, floatingToolbarColors.fabContentColor);
    }

    public int hashCode() {
        return (((((Color.m6821hashCodeimpl(this.toolbarContainerColor) * 31) + Color.m6821hashCodeimpl(this.toolbarContentColor)) * 31) + Color.m6821hashCodeimpl(this.fabContainerColor)) * 31) + Color.m6821hashCodeimpl(this.fabContentColor);
    }
}
