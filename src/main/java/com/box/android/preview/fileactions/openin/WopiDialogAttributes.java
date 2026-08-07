package com.box.android.preview.fileactions.openin;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: WopiDialog.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/fileactions/openin/WopiDialogAttributes;", "", "iconRes", "", "titleRes", "textRes", "<init>", "(III)V", "getIconRes", "()I", "getTitleRes", "getTextRes", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WopiDialogAttributes {
    public static final int $stable = 0;
    private final int iconRes;
    private final int textRes;
    private final int titleRes;

    public static /* synthetic */ WopiDialogAttributes copy$default(WopiDialogAttributes wopiDialogAttributes, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = wopiDialogAttributes.iconRes;
        }
        if ((i4 & 2) != 0) {
            i2 = wopiDialogAttributes.titleRes;
        }
        if ((i4 & 4) != 0) {
            i3 = wopiDialogAttributes.textRes;
        }
        return wopiDialogAttributes.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTitleRes() {
        return this.titleRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTextRes() {
        return this.textRes;
    }

    public final WopiDialogAttributes copy(int iconRes, int titleRes, int textRes) {
        return new WopiDialogAttributes(iconRes, titleRes, textRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WopiDialogAttributes)) {
            return false;
        }
        WopiDialogAttributes wopiDialogAttributes = (WopiDialogAttributes) other;
        return this.iconRes == wopiDialogAttributes.iconRes && this.titleRes == wopiDialogAttributes.titleRes && this.textRes == wopiDialogAttributes.textRes;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.iconRes) * 31) + Integer.hashCode(this.titleRes)) * 31) + Integer.hashCode(this.textRes);
    }

    public String toString() {
        return "WopiDialogAttributes(iconRes=" + this.iconRes + ", titleRes=" + this.titleRes + ", textRes=" + this.textRes + ")";
    }

    public WopiDialogAttributes(int i, int i2, int i3) {
        this.iconRes = i;
        this.titleRes = i2;
        this.textRes = i3;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTextRes() {
        return this.textRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
