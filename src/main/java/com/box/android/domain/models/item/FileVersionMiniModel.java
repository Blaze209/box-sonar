package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionMiniModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/item/FileVersionMiniModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "id", "", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSha1", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileVersionMiniModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<FileVersionMiniModel> CREATOR = new Creator();
    private final String id;
    private final String sha1;

    /* JADX INFO: compiled from: FileVersionMiniModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FileVersionMiniModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileVersionMiniModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FileVersionMiniModel(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileVersionMiniModel[] newArray(int i) {
            return new FileVersionMiniModel[i];
        }
    }

    public static /* synthetic */ FileVersionMiniModel copy$default(FileVersionMiniModel fileVersionMiniModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileVersionMiniModel.id;
        }
        if ((i & 2) != 0) {
            str2 = fileVersionMiniModel.sha1;
        }
        return fileVersionMiniModel.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    public final FileVersionMiniModel copy(String id, String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        return new FileVersionMiniModel(id, sha1);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileVersionMiniModel)) {
            return false;
        }
        FileVersionMiniModel fileVersionMiniModel = (FileVersionMiniModel) other;
        return Intrinsics.areEqual(this.id, fileVersionMiniModel.id) && Intrinsics.areEqual(this.sha1, fileVersionMiniModel.sha1);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.sha1.hashCode();
    }

    public String toString() {
        return "FileVersionMiniModel(id=" + this.id + ", sha1=" + this.sha1 + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.sha1);
    }

    public FileVersionMiniModel(String id, String sha1) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        this.id = id;
        this.sha1 = sha1;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSha1() {
        return this.sha1;
    }
}
