package com.pspdfkit.compose.theme;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/compose/theme/ToolbarPopupColors;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "component1", "component1-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-8_81llA", "(J)Lcom/pspdfkit/compose/theme/ToolbarPopupColors;", "equals", "", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ToolbarPopupColors {
    public static final int $stable = 0;
    private final long backgroundColor;

    public /* synthetic */ ToolbarPopupColors(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* JADX INFO: renamed from: copy-8_81llA$default, reason: not valid java name */
    public static /* synthetic */ ToolbarPopupColors m13962copy8_81llA$default(ToolbarPopupColors toolbarPopupColors, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = toolbarPopupColors.backgroundColor;
        }
        return toolbarPopupColors.m13964copy8_81llA(j);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: copy-8_81llA, reason: not valid java name */
    public final ToolbarPopupColors m13964copy8_81llA(long backgroundColor) {
        return new ToolbarPopupColors(backgroundColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ToolbarPopupColors) && Color.m6815equalsimpl0(this.backgroundColor, ((ToolbarPopupColors) other).backgroundColor);
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13965getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public int hashCode() {
        return Color.m6821hashCodeimpl(this.backgroundColor);
    }

    public String toString() {
        return "ToolbarPopupColors(backgroundColor=" + Color.m6822toStringimpl(this.backgroundColor) + ")";
    }

    private ToolbarPopupColors(long j) {
        this.backgroundColor = j;
    }
}
