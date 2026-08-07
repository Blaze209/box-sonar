package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e¨\u0006("}, d2 = {"Lexpo/modules/ui/ListItemColors;", "Lexpo/modules/kotlin/records/Record;", "containerColor", "Landroid/graphics/Color;", "headlineColor", "leadingIconColor", "trailingIconColor", "supportingColor", "overlineColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getContainerColor$annotations", "()V", "getContainerColor", "()Landroid/graphics/Color;", "getHeadlineColor$annotations", "getHeadlineColor", "getLeadingIconColor$annotations", "getLeadingIconColor", "getTrailingIconColor$annotations", "getTrailingIconColor", "getSupportingColor$annotations", "getSupportingColor", "getOverlineColor$annotations", "getOverlineColor", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ListItemColors implements Record {
    public static final int $stable = 8;
    private final Color containerColor;
    private final Color headlineColor;
    private final Color leadingIconColor;
    private final Color overlineColor;
    private final Color supportingColor;
    private final Color trailingIconColor;

    public ListItemColors() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ListItemColors copy$default(ListItemColors listItemColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, Object obj) {
        if ((i & 1) != 0) {
            color = listItemColors.containerColor;
        }
        if ((i & 2) != 0) {
            color2 = listItemColors.headlineColor;
        }
        if ((i & 4) != 0) {
            color3 = listItemColors.leadingIconColor;
        }
        if ((i & 8) != 0) {
            color4 = listItemColors.trailingIconColor;
        }
        if ((i & 16) != 0) {
            color5 = listItemColors.supportingColor;
        }
        if ((i & 32) != 0) {
            color6 = listItemColors.overlineColor;
        }
        Color color7 = color5;
        Color color8 = color6;
        return listItemColors.copy(color, color2, color3, color4, color7, color8);
    }

    @Field
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeadlineColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getLeadingIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getOverlineColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSupportingColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTrailingIconColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getHeadlineColor() {
        return this.headlineColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getLeadingIconColor() {
        return this.leadingIconColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getTrailingIconColor() {
        return this.trailingIconColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getSupportingColor() {
        return this.supportingColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getOverlineColor() {
        return this.overlineColor;
    }

    public final ListItemColors copy(Color containerColor, Color headlineColor, Color leadingIconColor, Color trailingIconColor, Color supportingColor, Color overlineColor) {
        return new ListItemColors(containerColor, headlineColor, leadingIconColor, trailingIconColor, supportingColor, overlineColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListItemColors)) {
            return false;
        }
        ListItemColors listItemColors = (ListItemColors) other;
        return Intrinsics.areEqual(this.containerColor, listItemColors.containerColor) && Intrinsics.areEqual(this.headlineColor, listItemColors.headlineColor) && Intrinsics.areEqual(this.leadingIconColor, listItemColors.leadingIconColor) && Intrinsics.areEqual(this.trailingIconColor, listItemColors.trailingIconColor) && Intrinsics.areEqual(this.supportingColor, listItemColors.supportingColor) && Intrinsics.areEqual(this.overlineColor, listItemColors.overlineColor);
    }

    public int hashCode() {
        Color color = this.containerColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.headlineColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.leadingIconColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.trailingIconColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.supportingColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.overlineColor;
        return iHashCode5 + (color6 != null ? color6.hashCode() : 0);
    }

    public String toString() {
        return "ListItemColors(containerColor=" + this.containerColor + ", headlineColor=" + this.headlineColor + ", leadingIconColor=" + this.leadingIconColor + ", trailingIconColor=" + this.trailingIconColor + ", supportingColor=" + this.supportingColor + ", overlineColor=" + this.overlineColor + ")";
    }

    public ListItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.containerColor = color;
        this.headlineColor = color2;
        this.leadingIconColor = color3;
        this.trailingIconColor = color4;
        this.supportingColor = color5;
        this.overlineColor = color6;
    }

    public /* synthetic */ ListItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6);
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final Color getHeadlineColor() {
        return this.headlineColor;
    }

    public final Color getLeadingIconColor() {
        return this.leadingIconColor;
    }

    public final Color getTrailingIconColor() {
        return this.trailingIconColor;
    }

    public final Color getSupportingColor() {
        return this.supportingColor;
    }

    public final Color getOverlineColor() {
        return this.overlineColor;
    }
}
