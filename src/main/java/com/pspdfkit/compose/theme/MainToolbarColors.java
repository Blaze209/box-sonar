package com.pspdfkit.compose.theme;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000bJ8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\""}, d2 = {"Lcom/pspdfkit/compose/theme/MainToolbarColors;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "popup", "Lcom/pspdfkit/compose/theme/ToolbarPopupColors;", "titleTextColor", "<init>", "(JJLcom/pspdfkit/compose/theme/ToolbarPopupColors;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getTextColor-0d7_KjU", "getPopup", "()Lcom/pspdfkit/compose/theme/ToolbarPopupColors;", "getTitleTextColor-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component4", "component4-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-JLJoQG0", "(JJLcom/pspdfkit/compose/theme/ToolbarPopupColors;J)Lcom/pspdfkit/compose/theme/MainToolbarColors;", "equals", "", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MainToolbarColors {
    public static final int $stable = 0;
    private final long backgroundColor;
    private final ToolbarPopupColors popup;
    private final long textColor;
    private final long titleTextColor;

    public /* synthetic */ MainToolbarColors(long j, long j2, ToolbarPopupColors toolbarPopupColors, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, toolbarPopupColors, j3);
    }

    /* JADX INFO: renamed from: copy-JLJoQG0$default, reason: not valid java name */
    public static /* synthetic */ MainToolbarColors m13937copyJLJoQG0$default(MainToolbarColors mainToolbarColors, long j, long j2, ToolbarPopupColors toolbarPopupColors, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = mainToolbarColors.backgroundColor;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = mainToolbarColors.textColor;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            toolbarPopupColors = mainToolbarColors.popup;
        }
        ToolbarPopupColors toolbarPopupColors2 = toolbarPopupColors;
        if ((i & 8) != 0) {
            j3 = mainToolbarColors.titleTextColor;
        }
        return mainToolbarColors.m13941copyJLJoQG0(j4, j5, toolbarPopupColors2, j3);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ToolbarPopupColors getPopup() {
        return this.popup;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleTextColor() {
        return this.titleTextColor;
    }

    /* JADX INFO: renamed from: copy-JLJoQG0, reason: not valid java name */
    public final MainToolbarColors m13941copyJLJoQG0(long backgroundColor, long textColor, ToolbarPopupColors popup, long titleTextColor) {
        popup.getClass();
        return new MainToolbarColors(backgroundColor, textColor, popup, titleTextColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainToolbarColors)) {
            return false;
        }
        MainToolbarColors mainToolbarColors = (MainToolbarColors) other;
        return Color.m6815equalsimpl0(this.backgroundColor, mainToolbarColors.backgroundColor) && Color.m6815equalsimpl0(this.textColor, mainToolbarColors.textColor) && Intrinsics.areEqual(this.popup, mainToolbarColors.popup) && Color.m6815equalsimpl0(this.titleTextColor, mainToolbarColors.titleTextColor);
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13942getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final ToolbarPopupColors getPopup() {
        return this.popup;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m13943getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getTitleTextColor-0d7_KjU, reason: not valid java name */
    public final long m13944getTitleTextColor0d7_KjU() {
        return this.titleTextColor;
    }

    public int hashCode() {
        return Color.m6821hashCodeimpl(this.titleTextColor) + ((this.popup.hashCode() + r.a(this.textColor, Color.m6821hashCodeimpl(this.backgroundColor) * 31, 31)) * 31);
    }

    public String toString() {
        return "MainToolbarColors(backgroundColor=" + Color.m6822toStringimpl(this.backgroundColor) + ", textColor=" + Color.m6822toStringimpl(this.textColor) + ", popup=" + this.popup + ", titleTextColor=" + Color.m6822toStringimpl(this.titleTextColor) + ")";
    }

    private MainToolbarColors(long j, long j2, ToolbarPopupColors toolbarPopupColors, long j3) {
        toolbarPopupColors.getClass();
        this.backgroundColor = j;
        this.textColor = j2;
        this.popup = toolbarPopupColors;
        this.titleTextColor = j3;
    }
}
