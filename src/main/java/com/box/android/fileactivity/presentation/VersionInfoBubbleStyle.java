package com.box.android.fileactivity.presentation;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/box/android/fileactivity/presentation/VersionInfoBubbleStyle;", "", "fontColor", "Landroidx/compose/ui/graphics/Color;", ViewProps.BORDER_COLOR, "backgroundColor", "text", "", "<init>", "(JJJLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontColor-0d7_KjU", "()J", "J", "getBorderColor-0d7_KjU", "getBackgroundColor-0d7_KjU", "getText", "()Ljava/lang/String;", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-qwTeutE", "(JJJLjava/lang/String;)Lcom/box/android/fileactivity/presentation/VersionInfoBubbleStyle;", "equals", "", "other", "hashCode", "", "toString", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class VersionInfoBubbleStyle {
    private final long backgroundColor;
    private final long borderColor;
    private final long fontColor;
    private final String text;

    public /* synthetic */ VersionInfoBubbleStyle(long j, long j2, long j3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, str);
    }

    /* JADX INFO: renamed from: copy-qwTeutE$default, reason: not valid java name */
    public static /* synthetic */ VersionInfoBubbleStyle m12610copyqwTeutE$default(VersionInfoBubbleStyle versionInfoBubbleStyle, long j, long j2, long j3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = versionInfoBubbleStyle.fontColor;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = versionInfoBubbleStyle.borderColor;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = versionInfoBubbleStyle.backgroundColor;
        }
        long j6 = j3;
        if ((i & 8) != 0) {
            str = versionInfoBubbleStyle.text;
        }
        return versionInfoBubbleStyle.m12614copyqwTeutE(j4, j5, j6, str);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getFontColor() {
        return this.fontColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: copy-qwTeutE, reason: not valid java name */
    public final VersionInfoBubbleStyle m12614copyqwTeutE(long fontColor, long borderColor, long backgroundColor, String text) {
        return new VersionInfoBubbleStyle(fontColor, borderColor, backgroundColor, text, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VersionInfoBubbleStyle)) {
            return false;
        }
        VersionInfoBubbleStyle versionInfoBubbleStyle = (VersionInfoBubbleStyle) other;
        return Color.m6815equalsimpl0(this.fontColor, versionInfoBubbleStyle.fontColor) && Color.m6815equalsimpl0(this.borderColor, versionInfoBubbleStyle.borderColor) && Color.m6815equalsimpl0(this.backgroundColor, versionInfoBubbleStyle.backgroundColor) && Intrinsics.areEqual(this.text, versionInfoBubbleStyle.text);
    }

    public int hashCode() {
        int iM6821hashCodeimpl = ((((Color.m6821hashCodeimpl(this.fontColor) * 31) + Color.m6821hashCodeimpl(this.borderColor)) * 31) + Color.m6821hashCodeimpl(this.backgroundColor)) * 31;
        String str = this.text;
        return iM6821hashCodeimpl + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VersionInfoBubbleStyle(fontColor=" + Color.m6822toStringimpl(this.fontColor) + ", borderColor=" + Color.m6822toStringimpl(this.borderColor) + ", backgroundColor=" + Color.m6822toStringimpl(this.backgroundColor) + ", text=" + this.text + ")";
    }

    private VersionInfoBubbleStyle(long j, long j2, long j3, String str) {
        this.fontColor = j;
        this.borderColor = j2;
        this.backgroundColor = j3;
        this.text = str;
    }

    /* JADX INFO: renamed from: getFontColor-0d7_KjU, reason: not valid java name */
    public final long m12617getFontColor0d7_KjU() {
        return this.fontColor;
    }

    /* JADX INFO: renamed from: getBorderColor-0d7_KjU, reason: not valid java name */
    public final long m12616getBorderColor0d7_KjU() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m12615getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    public final String getText() {
        return this.text;
    }
}
