package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJI\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Landroidx/compose/material3/ToggleButtonColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", "<init>", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getCheckedContainerColor-0d7_KjU", "getCheckedContentColor-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/ToggleButtonColors;", "enabled", "", "checked", "containerColor-WaAFU9c$material3", "(ZZ)J", "contentColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ ToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    private ToggleButtonColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this.containerColor = j;
        this.contentColor = j2;
        this.disabledContainerColor = j3;
        this.disabledContentColor = j4;
        this.checkedContainerColor = j5;
        this.checkedContentColor = j6;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    /* JADX INFO: renamed from: getCheckedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContainerColor() {
        return this.checkedContainerColor;
    }

    /* JADX INFO: renamed from: getCheckedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContentColor() {
        return this.checkedContentColor;
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ ToggleButtonColors m4593copytNS2XkQ$default(ToggleButtonColors toggleButtonColors, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = toggleButtonColors.containerColor;
        }
        return toggleButtonColors.m4596copytNS2XkQ(j, (i & 2) != 0 ? toggleButtonColors.contentColor : j2, (i & 4) != 0 ? toggleButtonColors.disabledContainerColor : j3, (i & 8) != 0 ? toggleButtonColors.disabledContentColor : j4, (i & 16) != 0 ? toggleButtonColors.checkedContainerColor : j5, (i & 32) != 0 ? toggleButtonColors.checkedContentColor : j6);
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final ToggleButtonColors m4596copytNS2XkQ(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor) {
        return new ToggleButtonColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledContentColor != 16 ? disabledContentColor : this.disabledContentColor, checkedContainerColor != 16 ? checkedContainerColor : this.checkedContainerColor, checkedContentColor != 16 ? checkedContentColor : this.checkedContentColor, null);
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m4594containerColorWaAFU9c$material3(boolean enabled, boolean checked) {
        if (enabled && checked) {
            return this.checkedContainerColor;
        }
        if (enabled && !checked) {
            return this.containerColor;
        }
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: contentColor-WaAFU9c$material3, reason: not valid java name */
    public final long m4595contentColorWaAFU9c$material3(boolean enabled, boolean checked) {
        if (enabled && checked) {
            return this.checkedContentColor;
        }
        if (enabled && !checked) {
            return this.contentColor;
        }
        return this.disabledContentColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ToggleButtonColors)) {
            return false;
        }
        ToggleButtonColors toggleButtonColors = (ToggleButtonColors) other;
        return Color.m6815equalsimpl0(this.containerColor, toggleButtonColors.containerColor) && Color.m6815equalsimpl0(this.contentColor, toggleButtonColors.contentColor) && Color.m6815equalsimpl0(this.disabledContainerColor, toggleButtonColors.disabledContainerColor) && Color.m6815equalsimpl0(this.disabledContentColor, toggleButtonColors.disabledContentColor) && Color.m6815equalsimpl0(this.checkedContainerColor, toggleButtonColors.checkedContainerColor) && Color.m6815equalsimpl0(this.checkedContentColor, toggleButtonColors.checkedContentColor);
    }

    public int hashCode() {
        return (((((((((Color.m6821hashCodeimpl(this.containerColor) * 31) + Color.m6821hashCodeimpl(this.contentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContentColor)) * 31) + Color.m6821hashCodeimpl(this.checkedContainerColor)) * 31) + Color.m6821hashCodeimpl(this.checkedContentColor);
    }
}
