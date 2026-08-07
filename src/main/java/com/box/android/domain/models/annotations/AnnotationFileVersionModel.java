package com.box.android.domain.models.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0007J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "Landroid/os/Parcelable;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "fileId", "number", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getFileId", "getNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/box/android/domain/models/annotations/AnnotationFileVersionModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnnotationFileVersionModel implements Parcelable, DomainModel {
    public static final Parcelable.Creator<AnnotationFileVersionModel> CREATOR = new Creator();
    private final String fileId;
    private final String id;
    private final Integer number;

    /* JADX INFO: compiled from: AnnotationModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AnnotationFileVersionModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnnotationFileVersionModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AnnotationFileVersionModel(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AnnotationFileVersionModel[] newArray(int i) {
            return new AnnotationFileVersionModel[i];
        }
    }

    public static /* synthetic */ AnnotationFileVersionModel copy$default(AnnotationFileVersionModel annotationFileVersionModel, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = annotationFileVersionModel.id;
        }
        if ((i & 2) != 0) {
            str2 = annotationFileVersionModel.fileId;
        }
        if ((i & 4) != 0) {
            num = annotationFileVersionModel.number;
        }
        return annotationFileVersionModel.copy(str, str2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getNumber() {
        return this.number;
    }

    public final AnnotationFileVersionModel copy(String id, String fileId, Integer number) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return new AnnotationFileVersionModel(id, fileId, number);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotationFileVersionModel)) {
            return false;
        }
        AnnotationFileVersionModel annotationFileVersionModel = (AnnotationFileVersionModel) other;
        return Intrinsics.areEqual(this.id, annotationFileVersionModel.id) && Intrinsics.areEqual(this.fileId, annotationFileVersionModel.fileId) && Intrinsics.areEqual(this.number, annotationFileVersionModel.number);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.fileId.hashCode()) * 31;
        Integer num = this.number;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "AnnotationFileVersionModel(id=" + this.id + ", fileId=" + this.fileId + ", number=" + this.number + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.fileId);
        Integer num = this.number;
        if (num == null) {
            iIntValue = 0;
        } else {
            dest.writeInt(1);
            iIntValue = num.intValue();
        }
        dest.writeInt(iIntValue);
    }

    public AnnotationFileVersionModel(String id, String fileId, Integer num) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.id = id;
        this.fileId = fileId;
        this.number = num;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getNumber() {
        return this.number;
    }
}
