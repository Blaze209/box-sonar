package com.box.android.base.compose.textfield;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxSimpleTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/box/android/base/compose/textfield/BoxSimpleTextFieldColorConfigs;", "", "contentColor", "Landroidx/compose/ui/graphics/Color;", "hintColor", "clearButtonColor", "cursorColor", "textSelectionColor", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "<init>", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentColor-0d7_KjU", "()J", "J", "getHintColor-0d7_KjU", "getClearButtonColor-0d7_KjU", "getCursorColor-0d7_KjU", "getTextSelectionColor", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-gPfMexM", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;)Lcom/box/android/base/compose/textfield/BoxSimpleTextFieldColorConfigs;", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxSimpleTextFieldColorConfigs {
    public static final int $stable = 0;
    private final long clearButtonColor;
    private final long contentColor;
    private final long cursorColor;
    private final long hintColor;
    private final TextSelectionColors textSelectionColor;

    public /* synthetic */ BoxSimpleTextFieldColorConfigs(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, textSelectionColors);
    }

    /* JADX INFO: renamed from: copy-gPfMexM$default, reason: not valid java name */
    public static /* synthetic */ BoxSimpleTextFieldColorConfigs m11741copygPfMexM$default(BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs, long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, int i, Object obj) {
        if ((i & 1) != 0) {
            j = boxSimpleTextFieldColorConfigs.contentColor;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = boxSimpleTextFieldColorConfigs.hintColor;
        }
        return boxSimpleTextFieldColorConfigs.m11746copygPfMexM(j5, j2, (i & 4) != 0 ? boxSimpleTextFieldColorConfigs.clearButtonColor : j3, (i & 8) != 0 ? boxSimpleTextFieldColorConfigs.cursorColor : j4, (i & 16) != 0 ? boxSimpleTextFieldColorConfigs.textSelectionColor : textSelectionColors);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getHintColor() {
        return this.hintColor;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getClearButtonColor() {
        return this.clearButtonColor;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getCursorColor() {
        return this.cursorColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextSelectionColors getTextSelectionColor() {
        return this.textSelectionColor;
    }

    /* JADX INFO: renamed from: copy-gPfMexM, reason: not valid java name */
    public final BoxSimpleTextFieldColorConfigs m11746copygPfMexM(long contentColor, long hintColor, long clearButtonColor, long cursorColor, TextSelectionColors textSelectionColor) {
        return new BoxSimpleTextFieldColorConfigs(contentColor, hintColor, clearButtonColor, cursorColor, textSelectionColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxSimpleTextFieldColorConfigs)) {
            return false;
        }
        BoxSimpleTextFieldColorConfigs boxSimpleTextFieldColorConfigs = (BoxSimpleTextFieldColorConfigs) other;
        return Color.m6815equalsimpl0(this.contentColor, boxSimpleTextFieldColorConfigs.contentColor) && Color.m6815equalsimpl0(this.hintColor, boxSimpleTextFieldColorConfigs.hintColor) && Color.m6815equalsimpl0(this.clearButtonColor, boxSimpleTextFieldColorConfigs.clearButtonColor) && Color.m6815equalsimpl0(this.cursorColor, boxSimpleTextFieldColorConfigs.cursorColor) && Intrinsics.areEqual(this.textSelectionColor, boxSimpleTextFieldColorConfigs.textSelectionColor);
    }

    public int hashCode() {
        int iM6821hashCodeimpl = ((((((Color.m6821hashCodeimpl(this.contentColor) * 31) + Color.m6821hashCodeimpl(this.hintColor)) * 31) + Color.m6821hashCodeimpl(this.clearButtonColor)) * 31) + Color.m6821hashCodeimpl(this.cursorColor)) * 31;
        TextSelectionColors textSelectionColors = this.textSelectionColor;
        return iM6821hashCodeimpl + (textSelectionColors == null ? 0 : textSelectionColors.hashCode());
    }

    public String toString() {
        return "BoxSimpleTextFieldColorConfigs(contentColor=" + Color.m6822toStringimpl(this.contentColor) + ", hintColor=" + Color.m6822toStringimpl(this.hintColor) + ", clearButtonColor=" + Color.m6822toStringimpl(this.clearButtonColor) + ", cursorColor=" + Color.m6822toStringimpl(this.cursorColor) + ", textSelectionColor=" + this.textSelectionColor + ")";
    }

    private BoxSimpleTextFieldColorConfigs(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors) {
        this.contentColor = j;
        this.hintColor = j2;
        this.clearButtonColor = j3;
        this.cursorColor = j4;
        this.textSelectionColor = textSelectionColors;
    }

    public /* synthetic */ BoxSimpleTextFieldColorConfigs(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, (i & 16) != 0 ? null : textSelectionColors, null);
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m11748getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getHintColor-0d7_KjU, reason: not valid java name */
    public final long m11750getHintColor0d7_KjU() {
        return this.hintColor;
    }

    /* JADX INFO: renamed from: getClearButtonColor-0d7_KjU, reason: not valid java name */
    public final long m11747getClearButtonColor0d7_KjU() {
        return this.clearButtonColor;
    }

    /* JADX INFO: renamed from: getCursorColor-0d7_KjU, reason: not valid java name */
    public final long m11749getCursorColor0d7_KjU() {
        return this.cursorColor;
    }

    public final TextSelectionColors getTextSelectionColor() {
        return this.textSelectionColor;
    }
}
