package com.box.android.domain.models.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "Landroid/os/Parcelable;", "activityId", "", "type", "Lcom/box/android/domain/models/annotations/FileActivityType;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityType;)V", "getActivityId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/annotations/FileActivityType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityIdModel implements Parcelable {
    public static final Parcelable.Creator<FileActivityIdModel> CREATOR = new Creator();
    private final String activityId;
    private final FileActivityType type;

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FileActivityIdModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileActivityIdModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FileActivityIdModel(parcel.readString(), FileActivityType.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileActivityIdModel[] newArray(int i) {
            return new FileActivityIdModel[i];
        }
    }

    public static /* synthetic */ FileActivityIdModel copy$default(FileActivityIdModel fileActivityIdModel, String str, FileActivityType fileActivityType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileActivityIdModel.activityId;
        }
        if ((i & 2) != 0) {
            fileActivityType = fileActivityIdModel.type;
        }
        return fileActivityIdModel.copy(str, fileActivityType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileActivityType getType() {
        return this.type;
    }

    public final FileActivityIdModel copy(String activityId, FileActivityType type) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FileActivityIdModel(activityId, type);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityIdModel)) {
            return false;
        }
        FileActivityIdModel fileActivityIdModel = (FileActivityIdModel) other;
        return Intrinsics.areEqual(this.activityId, fileActivityIdModel.activityId) && this.type == fileActivityIdModel.type;
    }

    public int hashCode() {
        return (this.activityId.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "FileActivityIdModel(activityId=" + this.activityId + ", type=" + this.type + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.activityId);
        dest.writeString(this.type.name());
    }

    public FileActivityIdModel(String activityId, FileActivityType type) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.activityId = activityId;
        this.type = type;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final FileActivityType getType() {
        return this.type;
    }
}
