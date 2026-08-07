package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/RepresentationPropertiesModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, "", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_PAGED, "", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_THUMB, "<init>", "(Ljava/lang/String;ZZ)V", "getDimensions", "()Ljava/lang/String;", "getPaged", "()Z", "getThumb", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationPropertiesModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<RepresentationPropertiesModel> CREATOR = new Creator();
    private final String dimensions;
    private final boolean paged;
    private final boolean thumb;

    /* JADX INFO: compiled from: RepresentationModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RepresentationPropertiesModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationPropertiesModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RepresentationPropertiesModel(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationPropertiesModel[] newArray(int i) {
            return new RepresentationPropertiesModel[i];
        }
    }

    public static /* synthetic */ RepresentationPropertiesModel copy$default(RepresentationPropertiesModel representationPropertiesModel, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = representationPropertiesModel.dimensions;
        }
        if ((i & 2) != 0) {
            z = representationPropertiesModel.paged;
        }
        if ((i & 4) != 0) {
            z2 = representationPropertiesModel.thumb;
        }
        return representationPropertiesModel.copy(str, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDimensions() {
        return this.dimensions;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getPaged() {
        return this.paged;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getThumb() {
        return this.thumb;
    }

    public final RepresentationPropertiesModel copy(String dimensions, boolean paged, boolean thumb) {
        return new RepresentationPropertiesModel(dimensions, paged, thumb);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationPropertiesModel)) {
            return false;
        }
        RepresentationPropertiesModel representationPropertiesModel = (RepresentationPropertiesModel) other;
        return Intrinsics.areEqual(this.dimensions, representationPropertiesModel.dimensions) && this.paged == representationPropertiesModel.paged && this.thumb == representationPropertiesModel.thumb;
    }

    public int hashCode() {
        String str = this.dimensions;
        return ((((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.paged)) * 31) + Boolean.hashCode(this.thumb);
    }

    public String toString() {
        return "RepresentationPropertiesModel(dimensions=" + this.dimensions + ", paged=" + this.paged + ", thumb=" + this.thumb + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.dimensions);
        dest.writeInt(this.paged ? 1 : 0);
        dest.writeInt(this.thumb ? 1 : 0);
    }

    public RepresentationPropertiesModel(String str, boolean z, boolean z2) {
        this.dimensions = str;
        this.paged = z;
        this.thumb = z2;
    }

    public final String getDimensions() {
        return this.dimensions;
    }

    public final boolean getPaged() {
        return this.paged;
    }

    public final boolean getThumb() {
        return this.thumb;
    }
}
