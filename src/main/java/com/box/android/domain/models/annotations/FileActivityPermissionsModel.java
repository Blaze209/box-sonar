package com.box.android.domain.models.annotations;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006$"}, d2 = {"Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "canDelete", "", WopiPropertyBuilder.IS_FILE_EDITABLE_PROPERTY, "canReply", "canResolve", "canChangeStatus", "<init>", "(ZZZZZ)V", "getCanDelete", "()Z", "getCanEdit", "getCanReply", "getCanResolve", "getCanChangeStatus", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivityPermissionsModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<FileActivityPermissionsModel> CREATOR = new Creator();
    private final boolean canChangeStatus;
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canReply;
    private final boolean canResolve;

    /* JADX INFO: compiled from: FileActivityModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FileActivityPermissionsModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileActivityPermissionsModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z = true;
            boolean z2 = false;
            if (parcel.readInt() == 0) {
                z = false;
            }
            if (parcel.readInt() != 0) {
                z2 = true;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            return new FileActivityPermissionsModel(z, z2, z2, z2, parcel.readInt() != 0 ? z : false);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileActivityPermissionsModel[] newArray(int i) {
            return new FileActivityPermissionsModel[i];
        }
    }

    public static /* synthetic */ FileActivityPermissionsModel copy$default(FileActivityPermissionsModel fileActivityPermissionsModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileActivityPermissionsModel.canDelete;
        }
        if ((i & 2) != 0) {
            z2 = fileActivityPermissionsModel.canEdit;
        }
        if ((i & 4) != 0) {
            z3 = fileActivityPermissionsModel.canReply;
        }
        if ((i & 8) != 0) {
            z4 = fileActivityPermissionsModel.canResolve;
        }
        if ((i & 16) != 0) {
            z5 = fileActivityPermissionsModel.canChangeStatus;
        }
        boolean z6 = z5;
        boolean z7 = z3;
        return fileActivityPermissionsModel.copy(z, z2, z7, z4, z6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanReply() {
        return this.canReply;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanResolve() {
        return this.canResolve;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanChangeStatus() {
        return this.canChangeStatus;
    }

    public final FileActivityPermissionsModel copy(boolean canDelete, boolean canEdit, boolean canReply, boolean canResolve, boolean canChangeStatus) {
        return new FileActivityPermissionsModel(canDelete, canEdit, canReply, canResolve, canChangeStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivityPermissionsModel)) {
            return false;
        }
        FileActivityPermissionsModel fileActivityPermissionsModel = (FileActivityPermissionsModel) other;
        return this.canDelete == fileActivityPermissionsModel.canDelete && this.canEdit == fileActivityPermissionsModel.canEdit && this.canReply == fileActivityPermissionsModel.canReply && this.canResolve == fileActivityPermissionsModel.canResolve && this.canChangeStatus == fileActivityPermissionsModel.canChangeStatus;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.canDelete) * 31) + Boolean.hashCode(this.canEdit)) * 31) + Boolean.hashCode(this.canReply)) * 31) + Boolean.hashCode(this.canResolve)) * 31) + Boolean.hashCode(this.canChangeStatus);
    }

    public String toString() {
        return "FileActivityPermissionsModel(canDelete=" + this.canDelete + ", canEdit=" + this.canEdit + ", canReply=" + this.canReply + ", canResolve=" + this.canResolve + ", canChangeStatus=" + this.canChangeStatus + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.canDelete ? 1 : 0);
        dest.writeInt(this.canEdit ? 1 : 0);
        dest.writeInt(this.canReply ? 1 : 0);
        dest.writeInt(this.canResolve ? 1 : 0);
        dest.writeInt(this.canChangeStatus ? 1 : 0);
    }

    public FileActivityPermissionsModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.canDelete = z;
        this.canEdit = z2;
        this.canReply = z3;
        this.canResolve = z4;
        this.canChangeStatus = z5;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }

    public final boolean getCanResolve() {
        return this.canResolve;
    }

    public final boolean getCanChangeStatus() {
        return this.canChangeStatus;
    }
}
