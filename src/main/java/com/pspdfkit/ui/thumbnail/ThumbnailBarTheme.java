package com.pspdfkit.ui.thumbnail;

import androidx.core.view.ViewCompat;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.internal.kv;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\bD\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\f\u001a\u00020\u0003\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\t\u0010J\u001a\u00020\u0012HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\t\u0010L\u001a\u00020\u0012HÆ\u0003J\t\u0010M\u001a\u00020\u0012HÆ\u0003J\t\u0010N\u001a\u00020\u0012HÆ\u0003J\t\u0010O\u001a\u00020\u0012HÆ\u0003J\t\u0010P\u001a\u00020\u0012HÆ\u0003J\t\u0010Q\u001a\u00020\u0012HÆ\u0003Jù\u0001\u0010R\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0012HÆ\u0001J\u0014\u0010S\u001a\u00020\n2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010U\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010V\u001a\u00020WHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\u0016\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u0017\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\u0018\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0011\u0010\u0019\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0011\u0010\u001a\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0011\u0010\u001b\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0011\u0010\u001c\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/¨\u0006X"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "", "backgroundColor", "", ViewProps.BORDER_COLOR, "thumbnailBorderColor", "thumbnailSelectedBorderColor", "thumbnailWidth", "thumbnailHeight", "usePageAspectRatio", "", "thumbnailPaddingPx", "contentPaddingPx", "borderSizePx", "thumbnailBorderWidth", "thumbnailSelectionBorderWidth", "thumbnailMarginPx", "selectionBorderCornerRadiusPx", "", "viewPaddingPx", "thumbnailWidthDp", "thumbnailHeightDp", "selectionBorderWidthDp", "thumbnailMarginDp", "viewPaddingDp", "thumbnailBorderWidthDp", "selectionBorderCornerRadiusDp", "floatingCornerRadiusDp", "thumbnailCornerRadiusDp", "<init>", "(IIIIIIZIIIIIIFIFFFFFFFFF)V", "getBackgroundColor", "()I", "getBorderColor", "getThumbnailBorderColor", "getThumbnailSelectedBorderColor", "getThumbnailWidth", "getThumbnailHeight", "getUsePageAspectRatio", "()Z", "getThumbnailPaddingPx", "getContentPaddingPx", "getBorderSizePx", "getThumbnailBorderWidth", "getThumbnailSelectionBorderWidth", "getThumbnailMarginPx", "getSelectionBorderCornerRadiusPx", "()F", "getViewPaddingPx", "getThumbnailWidthDp", "getThumbnailHeightDp", "getSelectionBorderWidthDp", "getThumbnailMarginDp", "getViewPaddingDp", "getThumbnailBorderWidthDp", "getSelectionBorderCornerRadiusDp", "getFloatingCornerRadiusDp", "getThumbnailCornerRadiusDp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ThumbnailBarTheme {
    public static final int $stable = 0;
    private final int backgroundColor;
    private final int borderColor;
    private final int borderSizePx;
    private final int contentPaddingPx;
    private final float floatingCornerRadiusDp;
    private final float selectionBorderCornerRadiusDp;
    private final float selectionBorderCornerRadiusPx;
    private final float selectionBorderWidthDp;
    private final int thumbnailBorderColor;
    private final int thumbnailBorderWidth;
    private final float thumbnailBorderWidthDp;
    private final float thumbnailCornerRadiusDp;
    private final int thumbnailHeight;
    private final float thumbnailHeightDp;
    private final float thumbnailMarginDp;
    private final int thumbnailMarginPx;
    private final int thumbnailPaddingPx;
    private final int thumbnailSelectedBorderColor;
    private final int thumbnailSelectionBorderWidth;
    private final int thumbnailWidth;
    private final float thumbnailWidthDp;
    private final boolean usePageAspectRatio;
    private final float viewPaddingDp;
    private final int viewPaddingPx;

    public ThumbnailBarTheme() {
        this(0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ViewCompat.MEASURED_SIZE_MASK, null);
    }

    public static /* synthetic */ ThumbnailBarTheme copy$default(ThumbnailBarTheme thumbnailBarTheme, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i14, Object obj) {
        float f11;
        float f12;
        int i15 = (i14 & 1) != 0 ? thumbnailBarTheme.backgroundColor : i;
        int i16 = (i14 & 2) != 0 ? thumbnailBarTheme.borderColor : i2;
        int i17 = (i14 & 4) != 0 ? thumbnailBarTheme.thumbnailBorderColor : i3;
        int i18 = (i14 & 8) != 0 ? thumbnailBarTheme.thumbnailSelectedBorderColor : i4;
        int i19 = (i14 & 16) != 0 ? thumbnailBarTheme.thumbnailWidth : i5;
        int i20 = (i14 & 32) != 0 ? thumbnailBarTheme.thumbnailHeight : i6;
        boolean z2 = (i14 & 64) != 0 ? thumbnailBarTheme.usePageAspectRatio : z;
        int i21 = (i14 & 128) != 0 ? thumbnailBarTheme.thumbnailPaddingPx : i7;
        int i22 = (i14 & 256) != 0 ? thumbnailBarTheme.contentPaddingPx : i8;
        int i23 = (i14 & 512) != 0 ? thumbnailBarTheme.borderSizePx : i9;
        int i24 = (i14 & 1024) != 0 ? thumbnailBarTheme.thumbnailBorderWidth : i10;
        int i25 = (i14 & 2048) != 0 ? thumbnailBarTheme.thumbnailSelectionBorderWidth : i11;
        int i26 = (i14 & 4096) != 0 ? thumbnailBarTheme.thumbnailMarginPx : i12;
        float f13 = (i14 & 8192) != 0 ? thumbnailBarTheme.selectionBorderCornerRadiusPx : f;
        int i27 = i15;
        int i28 = (i14 & 16384) != 0 ? thumbnailBarTheme.viewPaddingPx : i13;
        float f14 = (i14 & 32768) != 0 ? thumbnailBarTheme.thumbnailWidthDp : f2;
        float f15 = (i14 & 65536) != 0 ? thumbnailBarTheme.thumbnailHeightDp : f3;
        float f16 = (i14 & 131072) != 0 ? thumbnailBarTheme.selectionBorderWidthDp : f4;
        float f17 = (i14 & 262144) != 0 ? thumbnailBarTheme.thumbnailMarginDp : f5;
        float f18 = (i14 & 524288) != 0 ? thumbnailBarTheme.viewPaddingDp : f6;
        float f19 = (i14 & 1048576) != 0 ? thumbnailBarTheme.thumbnailBorderWidthDp : f7;
        float f20 = (i14 & 2097152) != 0 ? thumbnailBarTheme.selectionBorderCornerRadiusDp : f8;
        float f21 = (i14 & 4194304) != 0 ? thumbnailBarTheme.floatingCornerRadiusDp : f9;
        if ((i14 & 8388608) != 0) {
            f12 = f21;
            f11 = thumbnailBarTheme.thumbnailCornerRadiusDp;
        } else {
            f11 = f10;
            f12 = f21;
        }
        return thumbnailBarTheme.copy(i27, i16, i17, i18, i19, i20, z2, i21, i22, i23, i24, i25, i26, f13, i28, f14, f15, f16, f17, f18, f19, f20, f12, f11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getBorderSizePx() {
        return this.borderSizePx;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getThumbnailBorderWidth() {
        return this.thumbnailBorderWidth;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getThumbnailSelectionBorderWidth() {
        return this.thumbnailSelectionBorderWidth;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getThumbnailMarginPx() {
        return this.thumbnailMarginPx;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final float getSelectionBorderCornerRadiusPx() {
        return this.selectionBorderCornerRadiusPx;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getViewPaddingPx() {
        return this.viewPaddingPx;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final float getThumbnailWidthDp() {
        return this.thumbnailWidthDp;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final float getThumbnailHeightDp() {
        return this.thumbnailHeightDp;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final float getSelectionBorderWidthDp() {
        return this.selectionBorderWidthDp;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final float getThumbnailMarginDp() {
        return this.thumbnailMarginDp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBorderColor() {
        return this.borderColor;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final float getViewPaddingDp() {
        return this.viewPaddingDp;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final float getThumbnailBorderWidthDp() {
        return this.thumbnailBorderWidthDp;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final float getSelectionBorderCornerRadiusDp() {
        return this.selectionBorderCornerRadiusDp;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final float getFloatingCornerRadiusDp() {
        return this.floatingCornerRadiusDp;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final float getThumbnailCornerRadiusDp() {
        return this.thumbnailCornerRadiusDp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getThumbnailBorderColor() {
        return this.thumbnailBorderColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getThumbnailSelectedBorderColor() {
        return this.thumbnailSelectedBorderColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getUsePageAspectRatio() {
        return this.usePageAspectRatio;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getThumbnailPaddingPx() {
        return this.thumbnailPaddingPx;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getContentPaddingPx() {
        return this.contentPaddingPx;
    }

    public final ThumbnailBarTheme copy(int backgroundColor, int borderColor, int thumbnailBorderColor, int thumbnailSelectedBorderColor, int thumbnailWidth, int thumbnailHeight, boolean usePageAspectRatio, int thumbnailPaddingPx, int contentPaddingPx, int borderSizePx, int thumbnailBorderWidth, int thumbnailSelectionBorderWidth, int thumbnailMarginPx, float selectionBorderCornerRadiusPx, int viewPaddingPx, float thumbnailWidthDp, float thumbnailHeightDp, float selectionBorderWidthDp, float thumbnailMarginDp, float viewPaddingDp, float thumbnailBorderWidthDp, float selectionBorderCornerRadiusDp, float floatingCornerRadiusDp, float thumbnailCornerRadiusDp) {
        return new ThumbnailBarTheme(backgroundColor, borderColor, thumbnailBorderColor, thumbnailSelectedBorderColor, thumbnailWidth, thumbnailHeight, usePageAspectRatio, thumbnailPaddingPx, contentPaddingPx, borderSizePx, thumbnailBorderWidth, thumbnailSelectionBorderWidth, thumbnailMarginPx, selectionBorderCornerRadiusPx, viewPaddingPx, thumbnailWidthDp, thumbnailHeightDp, selectionBorderWidthDp, thumbnailMarginDp, viewPaddingDp, thumbnailBorderWidthDp, selectionBorderCornerRadiusDp, floatingCornerRadiusDp, thumbnailCornerRadiusDp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbnailBarTheme)) {
            return false;
        }
        ThumbnailBarTheme thumbnailBarTheme = (ThumbnailBarTheme) other;
        return this.backgroundColor == thumbnailBarTheme.backgroundColor && this.borderColor == thumbnailBarTheme.borderColor && this.thumbnailBorderColor == thumbnailBarTheme.thumbnailBorderColor && this.thumbnailSelectedBorderColor == thumbnailBarTheme.thumbnailSelectedBorderColor && this.thumbnailWidth == thumbnailBarTheme.thumbnailWidth && this.thumbnailHeight == thumbnailBarTheme.thumbnailHeight && this.usePageAspectRatio == thumbnailBarTheme.usePageAspectRatio && this.thumbnailPaddingPx == thumbnailBarTheme.thumbnailPaddingPx && this.contentPaddingPx == thumbnailBarTheme.contentPaddingPx && this.borderSizePx == thumbnailBarTheme.borderSizePx && this.thumbnailBorderWidth == thumbnailBarTheme.thumbnailBorderWidth && this.thumbnailSelectionBorderWidth == thumbnailBarTheme.thumbnailSelectionBorderWidth && this.thumbnailMarginPx == thumbnailBarTheme.thumbnailMarginPx && Float.compare(this.selectionBorderCornerRadiusPx, thumbnailBarTheme.selectionBorderCornerRadiusPx) == 0 && this.viewPaddingPx == thumbnailBarTheme.viewPaddingPx && Float.compare(this.thumbnailWidthDp, thumbnailBarTheme.thumbnailWidthDp) == 0 && Float.compare(this.thumbnailHeightDp, thumbnailBarTheme.thumbnailHeightDp) == 0 && Float.compare(this.selectionBorderWidthDp, thumbnailBarTheme.selectionBorderWidthDp) == 0 && Float.compare(this.thumbnailMarginDp, thumbnailBarTheme.thumbnailMarginDp) == 0 && Float.compare(this.viewPaddingDp, thumbnailBarTheme.viewPaddingDp) == 0 && Float.compare(this.thumbnailBorderWidthDp, thumbnailBarTheme.thumbnailBorderWidthDp) == 0 && Float.compare(this.selectionBorderCornerRadiusDp, thumbnailBarTheme.selectionBorderCornerRadiusDp) == 0 && Float.compare(this.floatingCornerRadiusDp, thumbnailBarTheme.floatingCornerRadiusDp) == 0 && Float.compare(this.thumbnailCornerRadiusDp, thumbnailBarTheme.thumbnailCornerRadiusDp) == 0;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderSizePx() {
        return this.borderSizePx;
    }

    public final int getContentPaddingPx() {
        return this.contentPaddingPx;
    }

    public final float getFloatingCornerRadiusDp() {
        return this.floatingCornerRadiusDp;
    }

    public final float getSelectionBorderCornerRadiusDp() {
        return this.selectionBorderCornerRadiusDp;
    }

    public final float getSelectionBorderCornerRadiusPx() {
        return this.selectionBorderCornerRadiusPx;
    }

    public final float getSelectionBorderWidthDp() {
        return this.selectionBorderWidthDp;
    }

    public final int getThumbnailBorderColor() {
        return this.thumbnailBorderColor;
    }

    public final int getThumbnailBorderWidth() {
        return this.thumbnailBorderWidth;
    }

    public final float getThumbnailBorderWidthDp() {
        return this.thumbnailBorderWidthDp;
    }

    public final float getThumbnailCornerRadiusDp() {
        return this.thumbnailCornerRadiusDp;
    }

    public final int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public final float getThumbnailHeightDp() {
        return this.thumbnailHeightDp;
    }

    public final float getThumbnailMarginDp() {
        return this.thumbnailMarginDp;
    }

    public final int getThumbnailMarginPx() {
        return this.thumbnailMarginPx;
    }

    public final int getThumbnailPaddingPx() {
        return this.thumbnailPaddingPx;
    }

    public final int getThumbnailSelectedBorderColor() {
        return this.thumbnailSelectedBorderColor;
    }

    public final int getThumbnailSelectionBorderWidth() {
        return this.thumbnailSelectionBorderWidth;
    }

    public final int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public final float getThumbnailWidthDp() {
        return this.thumbnailWidthDp;
    }

    public final boolean getUsePageAspectRatio() {
        return this.usePageAspectRatio;
    }

    public final float getViewPaddingDp() {
        return this.viewPaddingDp;
    }

    public final int getViewPaddingPx() {
        return this.viewPaddingPx;
    }

    public int hashCode() {
        return Float.hashCode(this.thumbnailCornerRadiusDp) + kv.a(this.floatingCornerRadiusDp, kv.a(this.selectionBorderCornerRadiusDp, kv.a(this.thumbnailBorderWidthDp, kv.a(this.viewPaddingDp, kv.a(this.thumbnailMarginDp, kv.a(this.selectionBorderWidthDp, kv.a(this.thumbnailHeightDp, kv.a(this.thumbnailWidthDp, nd.a(this.viewPaddingPx, kv.a(this.selectionBorderCornerRadiusPx, nd.a(this.thumbnailMarginPx, nd.a(this.thumbnailSelectionBorderWidth, nd.a(this.thumbnailBorderWidth, nd.a(this.borderSizePx, nd.a(this.contentPaddingPx, nd.a(this.thumbnailPaddingPx, mv.a(this.usePageAspectRatio, nd.a(this.thumbnailHeight, nd.a(this.thumbnailWidth, nd.a(this.thumbnailSelectedBorderColor, nd.a(this.thumbnailBorderColor, nd.a(this.borderColor, Integer.hashCode(this.backgroundColor) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "ThumbnailBarTheme(backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", thumbnailBorderColor=" + this.thumbnailBorderColor + ", thumbnailSelectedBorderColor=" + this.thumbnailSelectedBorderColor + ", thumbnailWidth=" + this.thumbnailWidth + ", thumbnailHeight=" + this.thumbnailHeight + ", usePageAspectRatio=" + this.usePageAspectRatio + ", thumbnailPaddingPx=" + this.thumbnailPaddingPx + ", contentPaddingPx=" + this.contentPaddingPx + ", borderSizePx=" + this.borderSizePx + ", thumbnailBorderWidth=" + this.thumbnailBorderWidth + ", thumbnailSelectionBorderWidth=" + this.thumbnailSelectionBorderWidth + ", thumbnailMarginPx=" + this.thumbnailMarginPx + ", selectionBorderCornerRadiusPx=" + this.selectionBorderCornerRadiusPx + ", viewPaddingPx=" + this.viewPaddingPx + ", thumbnailWidthDp=" + this.thumbnailWidthDp + ", thumbnailHeightDp=" + this.thumbnailHeightDp + ", selectionBorderWidthDp=" + this.selectionBorderWidthDp + ", thumbnailMarginDp=" + this.thumbnailMarginDp + ", viewPaddingDp=" + this.viewPaddingDp + ", thumbnailBorderWidthDp=" + this.thumbnailBorderWidthDp + ", selectionBorderCornerRadiusDp=" + this.selectionBorderCornerRadiusDp + ", floatingCornerRadiusDp=" + this.floatingCornerRadiusDp + ", thumbnailCornerRadiusDp=" + this.thumbnailCornerRadiusDp + ")";
    }

    public ThumbnailBarTheme(int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.backgroundColor = i;
        this.borderColor = i2;
        this.thumbnailBorderColor = i3;
        this.thumbnailSelectedBorderColor = i4;
        this.thumbnailWidth = i5;
        this.thumbnailHeight = i6;
        this.usePageAspectRatio = z;
        this.thumbnailPaddingPx = i7;
        this.contentPaddingPx = i8;
        this.borderSizePx = i9;
        this.thumbnailBorderWidth = i10;
        this.thumbnailSelectionBorderWidth = i11;
        this.thumbnailMarginPx = i12;
        this.selectionBorderCornerRadiusPx = f;
        this.viewPaddingPx = i13;
        this.thumbnailWidthDp = f2;
        this.thumbnailHeightDp = f3;
        this.selectionBorderWidthDp = f4;
        this.thumbnailMarginDp = f5;
        this.viewPaddingDp = f6;
        this.thumbnailBorderWidthDp = f7;
        this.selectionBorderCornerRadiusDp = f8;
        this.floatingCornerRadiusDp = f9;
        this.thumbnailCornerRadiusDp = f10;
    }

    public /* synthetic */ ThumbnailBarTheme(int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? -1 : i, (i14 & 2) != 0 ? -3355444 : i2, (i14 & 4) != 0 ? -16777216 : i3, (i14 & 8) != 0 ? -16750849 : i4, (i14 & 16) != 0 ? 20 : i5, (i14 & 32) != 0 ? 28 : i6, (i14 & 64) != 0 ? true : z, (i14 & 128) != 0 ? 8 : i7, (i14 & 256) != 0 ? 16 : i8, (i14 & 512) != 0 ? 1 : i9, (i14 & 1024) == 0 ? i10 : 1, (i14 & 2048) != 0 ? 2 : i11, (i14 & 4096) != 0 ? 0 : i12, (i14 & 8192) != 0 ? 15.0f : f, (i14 & 16384) != 0 ? 0 : i13, (i14 & 32768) != 0 ? 0.0f : f2, (i14 & 65536) != 0 ? 0.0f : f3, (i14 & 131072) != 0 ? 0.0f : f4, (i14 & 262144) != 0 ? 0.0f : f5, (i14 & 524288) != 0 ? 0.0f : f6, (i14 & 1048576) != 0 ? 0.0f : f7, (i14 & 2097152) == 0 ? f8 : 0.0f, (i14 & 4194304) != 0 ? 8.0f : f9, (i14 & 8388608) != 0 ? 2.0f : f10);
    }
}
