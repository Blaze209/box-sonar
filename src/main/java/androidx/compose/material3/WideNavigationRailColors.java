package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tB)\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\nJ?\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/WideNavigationRailColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "modalContainerColor", "modalScrimColor", "modalContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getModalContainerColor-0d7_KjU", "getModalScrimColor-0d7_KjU", "getModalContentColor-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/WideNavigationRailColors;", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long modalContainerColor;
    private final long modalContentColor;
    private final long modalScrimColor;

    public /* synthetic */ WideNavigationRailColors(long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of constructor with modalContentColor parameter", replaceWith = @ReplaceWith(expression = "WideNavigationRailColors(containerColor, contentColor, modalContainerColor, modalScrimColor, modalContentColor)", imports = {}))
    public /* synthetic */ WideNavigationRailColors(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    private WideNavigationRailColors(long j, long j2, long j3, long j4, long j5) {
        this.containerColor = j;
        this.contentColor = j2;
        this.modalContainerColor = j3;
        this.modalScrimColor = j4;
        this.modalContentColor = j5;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getModalContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getModalContainerColor() {
        return this.modalContainerColor;
    }

    /* JADX INFO: renamed from: getModalScrimColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getModalScrimColor() {
        return this.modalScrimColor;
    }

    /* JADX INFO: renamed from: getModalContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getModalContentColor() {
        return this.modalContentColor;
    }

    private WideNavigationRailColors(long j, long j2, long j3, long j4) {
        this(j, j2, j3, j4, j2, null);
    }

    /* JADX INFO: renamed from: copy-t635Npw$default, reason: not valid java name */
    public static /* synthetic */ WideNavigationRailColors m4824copyt635Npw$default(WideNavigationRailColors wideNavigationRailColors, long j, long j2, long j3, long j4, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j = wideNavigationRailColors.containerColor;
        }
        long j6 = j;
        if ((i & 2) != 0) {
            j2 = wideNavigationRailColors.contentColor;
        }
        return wideNavigationRailColors.m4826copyt635Npw(j6, j2, (i & 4) != 0 ? wideNavigationRailColors.modalContainerColor : j3, (i & 8) != 0 ? wideNavigationRailColors.modalScrimColor : j4, (i & 16) != 0 ? wideNavigationRailColors.modalContentColor : j5);
    }

    /* JADX INFO: renamed from: copy-t635Npw, reason: not valid java name */
    public final WideNavigationRailColors m4826copyt635Npw(long containerColor, long contentColor, long modalContainerColor, long modalScrimColor, long modalContentColor) {
        return new WideNavigationRailColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, modalContainerColor != 16 ? modalContainerColor : this.modalContainerColor, modalScrimColor != 16 ? modalScrimColor : this.modalScrimColor, modalContentColor != 16 ? modalContentColor : this.modalContentColor, null);
    }

    /* JADX INFO: renamed from: copy-jRlVdoo$default, reason: not valid java name */
    public static /* synthetic */ WideNavigationRailColors m4823copyjRlVdoo$default(WideNavigationRailColors wideNavigationRailColors, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = wideNavigationRailColors.containerColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = wideNavigationRailColors.contentColor;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = wideNavigationRailColors.modalContainerColor;
        }
        return wideNavigationRailColors.m4825copyjRlVdoo(j5, j6, j3, (i & 8) != 0 ? wideNavigationRailColors.modalScrimColor : j4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with modalContentColor parameter")
    /* JADX INFO: renamed from: copy-jRlVdoo, reason: not valid java name */
    public final /* synthetic */ WideNavigationRailColors m4825copyjRlVdoo(long containerColor, long contentColor, long modalContainerColor, long modalScrimColor) {
        return m4826copyt635Npw(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, modalContainerColor != 16 ? modalContainerColor : this.modalContainerColor, modalScrimColor != 16 ? modalScrimColor : this.modalScrimColor, contentColor != 16 ? contentColor : this.contentColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof WideNavigationRailColors)) {
            return false;
        }
        WideNavigationRailColors wideNavigationRailColors = (WideNavigationRailColors) other;
        return Color.m6815equalsimpl0(this.containerColor, wideNavigationRailColors.containerColor) && Color.m6815equalsimpl0(this.contentColor, wideNavigationRailColors.contentColor) && Color.m6815equalsimpl0(this.modalContainerColor, wideNavigationRailColors.modalContainerColor) && Color.m6815equalsimpl0(this.modalScrimColor, wideNavigationRailColors.modalScrimColor);
    }

    public int hashCode() {
        return (((((((Color.m6821hashCodeimpl(this.containerColor) * 31) + Color.m6821hashCodeimpl(this.contentColor)) * 31) + Color.m6821hashCodeimpl(this.modalContainerColor)) * 31) + Color.m6821hashCodeimpl(this.modalScrimColor)) * 31) + Color.m6821hashCodeimpl(this.modalContentColor);
    }
}
