package com.pspdfkit.compose.theme;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0010\u0010\u001d\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000eJ\u0010\u0010\u001f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010\u000eJ\u0010\u0010!\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\"\u0010\u000eJ\u0010\u0010#\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b$\u0010\u000eJ\u0010\u0010%\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b&\u0010\u000eJ`\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u000200HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e¨\u00061"}, d2 = {"Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "groupTitleTextColor", "itemTitleTextColor", "itemValueTextColor", "itemValueHintTextColor", "groupIconColor", "fabBackgroundColor", "fabIconColor", "<init>", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getGroupTitleTextColor-0d7_KjU", "getItemTitleTextColor-0d7_KjU", "getItemValueTextColor-0d7_KjU", "getItemValueHintTextColor-0d7_KjU", "getGroupIconColor-0d7_KjU", "getFabBackgroundColor-0d7_KjU", "getFabIconColor-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-FD3wquc", "(JJJJJJJJ)Lcom/pspdfkit/compose/theme/DocumentInfoColorScheme;", "equals", "", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DocumentInfoColorScheme {
    public static final int $stable = 0;
    private final long backgroundColor;
    private final long fabBackgroundColor;
    private final long fabIconColor;
    private final long groupIconColor;
    private final long groupTitleTextColor;
    private final long itemTitleTextColor;
    private final long itemValueHintTextColor;
    private final long itemValueTextColor;

    public /* synthetic */ DocumentInfoColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    /* JADX INFO: renamed from: copy-FD3wquc$default, reason: not valid java name */
    public static /* synthetic */ DocumentInfoColorScheme m13919copyFD3wquc$default(DocumentInfoColorScheme documentInfoColorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, Object obj) {
        long j9;
        long j10;
        long j11 = (i & 1) != 0 ? documentInfoColorScheme.backgroundColor : j;
        long j12 = (i & 2) != 0 ? documentInfoColorScheme.groupTitleTextColor : j2;
        long j13 = (i & 4) != 0 ? documentInfoColorScheme.itemTitleTextColor : j3;
        long j14 = (i & 8) != 0 ? documentInfoColorScheme.itemValueTextColor : j4;
        long j15 = (i & 16) != 0 ? documentInfoColorScheme.itemValueHintTextColor : j5;
        long j16 = (i & 32) != 0 ? documentInfoColorScheme.groupIconColor : j6;
        long j17 = (i & 64) != 0 ? documentInfoColorScheme.fabBackgroundColor : j7;
        if ((i & 128) != 0) {
            j9 = documentInfoColorScheme.fabIconColor;
            j10 = j11;
        } else {
            j9 = j8;
            j10 = j11;
        }
        return documentInfoColorScheme.m13928copyFD3wquc(j10, j12, j13, j14, j15, j16, j17, j9);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getGroupTitleTextColor() {
        return this.groupTitleTextColor;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemTitleTextColor() {
        return this.itemTitleTextColor;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemValueTextColor() {
        return this.itemValueTextColor;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemValueHintTextColor() {
        return this.itemValueHintTextColor;
    }

    /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getGroupIconColor() {
        return this.groupIconColor;
    }

    /* JADX INFO: renamed from: component7-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabBackgroundColor() {
        return this.fabBackgroundColor;
    }

    /* JADX INFO: renamed from: component8-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabIconColor() {
        return this.fabIconColor;
    }

    /* JADX INFO: renamed from: copy-FD3wquc, reason: not valid java name */
    public final DocumentInfoColorScheme m13928copyFD3wquc(long backgroundColor, long groupTitleTextColor, long itemTitleTextColor, long itemValueTextColor, long itemValueHintTextColor, long groupIconColor, long fabBackgroundColor, long fabIconColor) {
        return new DocumentInfoColorScheme(backgroundColor, groupTitleTextColor, itemTitleTextColor, itemValueTextColor, itemValueHintTextColor, groupIconColor, fabBackgroundColor, fabIconColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentInfoColorScheme)) {
            return false;
        }
        DocumentInfoColorScheme documentInfoColorScheme = (DocumentInfoColorScheme) other;
        return Color.m6815equalsimpl0(this.backgroundColor, documentInfoColorScheme.backgroundColor) && Color.m6815equalsimpl0(this.groupTitleTextColor, documentInfoColorScheme.groupTitleTextColor) && Color.m6815equalsimpl0(this.itemTitleTextColor, documentInfoColorScheme.itemTitleTextColor) && Color.m6815equalsimpl0(this.itemValueTextColor, documentInfoColorScheme.itemValueTextColor) && Color.m6815equalsimpl0(this.itemValueHintTextColor, documentInfoColorScheme.itemValueHintTextColor) && Color.m6815equalsimpl0(this.groupIconColor, documentInfoColorScheme.groupIconColor) && Color.m6815equalsimpl0(this.fabBackgroundColor, documentInfoColorScheme.fabBackgroundColor) && Color.m6815equalsimpl0(this.fabIconColor, documentInfoColorScheme.fabIconColor);
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13929getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getFabBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13930getFabBackgroundColor0d7_KjU() {
        return this.fabBackgroundColor;
    }

    /* JADX INFO: renamed from: getFabIconColor-0d7_KjU, reason: not valid java name */
    public final long m13931getFabIconColor0d7_KjU() {
        return this.fabIconColor;
    }

    /* JADX INFO: renamed from: getGroupIconColor-0d7_KjU, reason: not valid java name */
    public final long m13932getGroupIconColor0d7_KjU() {
        return this.groupIconColor;
    }

    /* JADX INFO: renamed from: getGroupTitleTextColor-0d7_KjU, reason: not valid java name */
    public final long m13933getGroupTitleTextColor0d7_KjU() {
        return this.groupTitleTextColor;
    }

    /* JADX INFO: renamed from: getItemTitleTextColor-0d7_KjU, reason: not valid java name */
    public final long m13934getItemTitleTextColor0d7_KjU() {
        return this.itemTitleTextColor;
    }

    /* JADX INFO: renamed from: getItemValueHintTextColor-0d7_KjU, reason: not valid java name */
    public final long m13935getItemValueHintTextColor0d7_KjU() {
        return this.itemValueHintTextColor;
    }

    /* JADX INFO: renamed from: getItemValueTextColor-0d7_KjU, reason: not valid java name */
    public final long m13936getItemValueTextColor0d7_KjU() {
        return this.itemValueTextColor;
    }

    public int hashCode() {
        return Color.m6821hashCodeimpl(this.fabIconColor) + r.a(this.fabBackgroundColor, r.a(this.groupIconColor, r.a(this.itemValueHintTextColor, r.a(this.itemValueTextColor, r.a(this.itemTitleTextColor, r.a(this.groupTitleTextColor, Color.m6821hashCodeimpl(this.backgroundColor) * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "DocumentInfoColorScheme(backgroundColor=" + Color.m6822toStringimpl(this.backgroundColor) + ", groupTitleTextColor=" + Color.m6822toStringimpl(this.groupTitleTextColor) + ", itemTitleTextColor=" + Color.m6822toStringimpl(this.itemTitleTextColor) + ", itemValueTextColor=" + Color.m6822toStringimpl(this.itemValueTextColor) + ", itemValueHintTextColor=" + Color.m6822toStringimpl(this.itemValueHintTextColor) + ", groupIconColor=" + Color.m6822toStringimpl(this.groupIconColor) + ", fabBackgroundColor=" + Color.m6822toStringimpl(this.fabBackgroundColor) + ", fabIconColor=" + Color.m6822toStringimpl(this.fabIconColor) + ")";
    }

    private DocumentInfoColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.backgroundColor = j;
        this.groupTitleTextColor = j2;
        this.itemTitleTextColor = j3;
        this.itemValueTextColor = j4;
        this.itemValueHintTextColor = j5;
        this.groupIconColor = j6;
        this.fabBackgroundColor = j7;
        this.fabIconColor = j8;
    }
}
