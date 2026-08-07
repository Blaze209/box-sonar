package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/box/android/domain/models/RepresentationModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "contentUrlTemplate", "", "infoUrl", "properties", "Lcom/box/android/domain/models/RepresentationPropertiesModel;", "representationType", "Lcom/box/android/domain/models/RepresentationType;", "status", "Lcom/box/android/domain/models/RepresentationStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/RepresentationPropertiesModel;Lcom/box/android/domain/models/RepresentationType;Lcom/box/android/domain/models/RepresentationStatus;)V", "getContentUrlTemplate", "()Ljava/lang/String;", "getInfoUrl", "getProperties", "()Lcom/box/android/domain/models/RepresentationPropertiesModel;", "getRepresentationType", "()Lcom/box/android/domain/models/RepresentationType;", "getStatus", "()Lcom/box/android/domain/models/RepresentationStatus;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RepresentationModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<RepresentationModel> CREATOR = new Creator();
    private final String contentUrlTemplate;
    private final String infoUrl;
    private final RepresentationPropertiesModel properties;
    private final RepresentationType representationType;
    private final RepresentationStatus status;

    /* JADX INFO: compiled from: RepresentationModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RepresentationModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RepresentationModel(parcel.readString(), parcel.readString(), RepresentationPropertiesModel.CREATOR.createFromParcel(parcel), RepresentationType.valueOf(parcel.readString()), RepresentationStatus.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RepresentationModel[] newArray(int i) {
            return new RepresentationModel[i];
        }
    }

    public static /* synthetic */ RepresentationModel copy$default(RepresentationModel representationModel, String str, String str2, RepresentationPropertiesModel representationPropertiesModel, RepresentationType representationType, RepresentationStatus representationStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = representationModel.contentUrlTemplate;
        }
        if ((i & 2) != 0) {
            str2 = representationModel.infoUrl;
        }
        if ((i & 4) != 0) {
            representationPropertiesModel = representationModel.properties;
        }
        if ((i & 8) != 0) {
            representationType = representationModel.representationType;
        }
        if ((i & 16) != 0) {
            representationStatus = representationModel.status;
        }
        RepresentationStatus representationStatus2 = representationStatus;
        RepresentationPropertiesModel representationPropertiesModel2 = representationPropertiesModel;
        return representationModel.copy(str, str2, representationPropertiesModel2, representationType, representationStatus2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContentUrlTemplate() {
        return this.contentUrlTemplate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getInfoUrl() {
        return this.infoUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RepresentationPropertiesModel getProperties() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RepresentationType getRepresentationType() {
        return this.representationType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final RepresentationStatus getStatus() {
        return this.status;
    }

    public final RepresentationModel copy(String contentUrlTemplate, String infoUrl, RepresentationPropertiesModel properties, RepresentationType representationType, RepresentationStatus status) {
        Intrinsics.checkNotNullParameter(contentUrlTemplate, "contentUrlTemplate");
        Intrinsics.checkNotNullParameter(infoUrl, "infoUrl");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(representationType, "representationType");
        Intrinsics.checkNotNullParameter(status, "status");
        return new RepresentationModel(contentUrlTemplate, infoUrl, properties, representationType, status);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RepresentationModel)) {
            return false;
        }
        RepresentationModel representationModel = (RepresentationModel) other;
        return Intrinsics.areEqual(this.contentUrlTemplate, representationModel.contentUrlTemplate) && Intrinsics.areEqual(this.infoUrl, representationModel.infoUrl) && Intrinsics.areEqual(this.properties, representationModel.properties) && this.representationType == representationModel.representationType && Intrinsics.areEqual(this.status, representationModel.status);
    }

    public int hashCode() {
        return (((((((this.contentUrlTemplate.hashCode() * 31) + this.infoUrl.hashCode()) * 31) + this.properties.hashCode()) * 31) + this.representationType.hashCode()) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "RepresentationModel(contentUrlTemplate=" + this.contentUrlTemplate + ", infoUrl=" + this.infoUrl + ", properties=" + this.properties + ", representationType=" + this.representationType + ", status=" + this.status + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.contentUrlTemplate);
        dest.writeString(this.infoUrl);
        this.properties.writeToParcel(dest, flags);
        dest.writeString(this.representationType.name());
        this.status.writeToParcel(dest, flags);
    }

    public RepresentationModel(String contentUrlTemplate, String infoUrl, RepresentationPropertiesModel properties, RepresentationType representationType, RepresentationStatus status) {
        Intrinsics.checkNotNullParameter(contentUrlTemplate, "contentUrlTemplate");
        Intrinsics.checkNotNullParameter(infoUrl, "infoUrl");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(representationType, "representationType");
        Intrinsics.checkNotNullParameter(status, "status");
        this.contentUrlTemplate = contentUrlTemplate;
        this.infoUrl = infoUrl;
        this.properties = properties;
        this.representationType = representationType;
        this.status = status;
    }

    public final String getContentUrlTemplate() {
        return this.contentUrlTemplate;
    }

    public final String getInfoUrl() {
        return this.infoUrl;
    }

    public final RepresentationPropertiesModel getProperties() {
        return this.properties;
    }

    public final RepresentationType getRepresentationType() {
        return this.representationType;
    }

    public final RepresentationStatus getStatus() {
        return this.status;
    }
}
