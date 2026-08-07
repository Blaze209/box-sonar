package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/item/WatermarkModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "isWatermarked", "", "isWatermarkInherited", "isWatermarkedByAccessPolicy", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatermarkModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<WatermarkModel> CREATOR = new Creator();
    private final boolean isWatermarkInherited;
    private final boolean isWatermarked;
    private final boolean isWatermarkedByAccessPolicy;

    /* JADX INFO: compiled from: WatermarkModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WatermarkModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WatermarkModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WatermarkModel(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WatermarkModel[] newArray(int i) {
            return new WatermarkModel[i];
        }
    }

    public WatermarkModel() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ WatermarkModel copy$default(WatermarkModel watermarkModel, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = watermarkModel.isWatermarked;
        }
        if ((i & 2) != 0) {
            z2 = watermarkModel.isWatermarkInherited;
        }
        if ((i & 4) != 0) {
            z3 = watermarkModel.isWatermarkedByAccessPolicy;
        }
        return watermarkModel.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsWatermarked() {
        return this.isWatermarked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsWatermarkInherited() {
        return this.isWatermarkInherited;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsWatermarkedByAccessPolicy() {
        return this.isWatermarkedByAccessPolicy;
    }

    public final WatermarkModel copy(boolean isWatermarked, boolean isWatermarkInherited, boolean isWatermarkedByAccessPolicy) {
        return new WatermarkModel(isWatermarked, isWatermarkInherited, isWatermarkedByAccessPolicy);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatermarkModel)) {
            return false;
        }
        WatermarkModel watermarkModel = (WatermarkModel) other;
        return this.isWatermarked == watermarkModel.isWatermarked && this.isWatermarkInherited == watermarkModel.isWatermarkInherited && this.isWatermarkedByAccessPolicy == watermarkModel.isWatermarkedByAccessPolicy;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isWatermarked) * 31) + Boolean.hashCode(this.isWatermarkInherited)) * 31) + Boolean.hashCode(this.isWatermarkedByAccessPolicy);
    }

    public String toString() {
        return "WatermarkModel(isWatermarked=" + this.isWatermarked + ", isWatermarkInherited=" + this.isWatermarkInherited + ", isWatermarkedByAccessPolicy=" + this.isWatermarkedByAccessPolicy + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.isWatermarked ? 1 : 0);
        dest.writeInt(this.isWatermarkInherited ? 1 : 0);
        dest.writeInt(this.isWatermarkedByAccessPolicy ? 1 : 0);
    }

    public WatermarkModel(boolean z, boolean z2, boolean z3) {
        this.isWatermarked = z;
        this.isWatermarkInherited = z2;
        this.isWatermarkedByAccessPolicy = z3;
    }

    public /* synthetic */ WatermarkModel(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public final boolean isWatermarked() {
        return this.isWatermarked;
    }

    public final boolean isWatermarkInherited() {
        return this.isWatermarkInherited;
    }

    public final boolean isWatermarkedByAccessPolicy() {
        return this.isWatermarkedByAccessPolicy;
    }
}
