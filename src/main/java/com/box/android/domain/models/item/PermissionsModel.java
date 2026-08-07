package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u007f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004HÆ\u0001J\u0006\u0010,\u001a\u00020-J\u0013\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020-HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020-R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00069"}, d2 = {"Lcom/box/android/domain/models/item/PermissionsModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "canDelete", "", "canRename", "canDownload", "canPreview", "canUpload", "canComment", "canShare", "canInviteCollaborators", "canSetShareAccess", "canViewAnnotations", "canCreateAnnotations", "canApplyWatermark", "<init>", "(ZZZZZZZZZZZZ)V", "getCanDelete", "()Z", "getCanRename", "getCanDownload", "getCanPreview", "getCanUpload", "getCanComment", "getCanShare", "getCanInviteCollaborators", "getCanSetShareAccess", "getCanViewAnnotations", "getCanCreateAnnotations", "getCanApplyWatermark", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PermissionsModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<PermissionsModel> CREATOR = new Creator();
    private final boolean canApplyWatermark;
    private final boolean canComment;
    private final boolean canCreateAnnotations;
    private final boolean canDelete;
    private final boolean canDownload;
    private final boolean canInviteCollaborators;
    private final boolean canPreview;
    private final boolean canRename;
    private final boolean canSetShareAccess;
    private final boolean canShare;
    private final boolean canUpload;
    private final boolean canViewAnnotations;

    /* JADX INFO: compiled from: PermissionsModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PermissionsModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermissionsModel createFromParcel(Parcel parcel) {
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
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            if (parcel.readInt() != 0) {
                z2 = z;
            }
            return new PermissionsModel(z, z2, z2, z2, z2, z2, z2, z2, z2, z2, z2, parcel.readInt() != 0 ? z : false);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermissionsModel[] newArray(int i) {
            return new PermissionsModel[i];
        }
    }

    public PermissionsModel() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, 4095, null);
    }

    public static /* synthetic */ PermissionsModel copy$default(PermissionsModel permissionsModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            z = permissionsModel.canDelete;
        }
        if ((i & 2) != 0) {
            z2 = permissionsModel.canRename;
        }
        if ((i & 4) != 0) {
            z3 = permissionsModel.canDownload;
        }
        if ((i & 8) != 0) {
            z4 = permissionsModel.canPreview;
        }
        if ((i & 16) != 0) {
            z5 = permissionsModel.canUpload;
        }
        if ((i & 32) != 0) {
            z6 = permissionsModel.canComment;
        }
        if ((i & 64) != 0) {
            z7 = permissionsModel.canShare;
        }
        if ((i & 128) != 0) {
            z8 = permissionsModel.canInviteCollaborators;
        }
        if ((i & 256) != 0) {
            z9 = permissionsModel.canSetShareAccess;
        }
        if ((i & 512) != 0) {
            z10 = permissionsModel.canViewAnnotations;
        }
        if ((i & 1024) != 0) {
            z11 = permissionsModel.canCreateAnnotations;
        }
        if ((i & 2048) != 0) {
            z12 = permissionsModel.canApplyWatermark;
        }
        boolean z13 = z11;
        boolean z14 = z12;
        boolean z15 = z9;
        boolean z16 = z10;
        boolean z17 = z7;
        boolean z18 = z8;
        boolean z19 = z5;
        boolean z20 = z6;
        return permissionsModel.copy(z, z2, z3, z4, z19, z20, z17, z18, z15, z16, z13, z14);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanViewAnnotations() {
        return this.canViewAnnotations;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCanCreateAnnotations() {
        return this.canCreateAnnotations;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanApplyWatermark() {
        return this.canApplyWatermark;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanRename() {
        return this.canRename;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanPreview() {
        return this.canPreview;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanUpload() {
        return this.canUpload;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanComment() {
        return this.canComment;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanInviteCollaborators() {
        return this.canInviteCollaborators;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanSetShareAccess() {
        return this.canSetShareAccess;
    }

    public final PermissionsModel copy(boolean canDelete, boolean canRename, boolean canDownload, boolean canPreview, boolean canUpload, boolean canComment, boolean canShare, boolean canInviteCollaborators, boolean canSetShareAccess, boolean canViewAnnotations, boolean canCreateAnnotations, boolean canApplyWatermark) {
        return new PermissionsModel(canDelete, canRename, canDownload, canPreview, canUpload, canComment, canShare, canInviteCollaborators, canSetShareAccess, canViewAnnotations, canCreateAnnotations, canApplyWatermark);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsModel)) {
            return false;
        }
        PermissionsModel permissionsModel = (PermissionsModel) other;
        return this.canDelete == permissionsModel.canDelete && this.canRename == permissionsModel.canRename && this.canDownload == permissionsModel.canDownload && this.canPreview == permissionsModel.canPreview && this.canUpload == permissionsModel.canUpload && this.canComment == permissionsModel.canComment && this.canShare == permissionsModel.canShare && this.canInviteCollaborators == permissionsModel.canInviteCollaborators && this.canSetShareAccess == permissionsModel.canSetShareAccess && this.canViewAnnotations == permissionsModel.canViewAnnotations && this.canCreateAnnotations == permissionsModel.canCreateAnnotations && this.canApplyWatermark == permissionsModel.canApplyWatermark;
    }

    public int hashCode() {
        return (((((((((((((((((((((Boolean.hashCode(this.canDelete) * 31) + Boolean.hashCode(this.canRename)) * 31) + Boolean.hashCode(this.canDownload)) * 31) + Boolean.hashCode(this.canPreview)) * 31) + Boolean.hashCode(this.canUpload)) * 31) + Boolean.hashCode(this.canComment)) * 31) + Boolean.hashCode(this.canShare)) * 31) + Boolean.hashCode(this.canInviteCollaborators)) * 31) + Boolean.hashCode(this.canSetShareAccess)) * 31) + Boolean.hashCode(this.canViewAnnotations)) * 31) + Boolean.hashCode(this.canCreateAnnotations)) * 31) + Boolean.hashCode(this.canApplyWatermark);
    }

    public String toString() {
        return "PermissionsModel(canDelete=" + this.canDelete + ", canRename=" + this.canRename + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canUpload=" + this.canUpload + ", canComment=" + this.canComment + ", canShare=" + this.canShare + ", canInviteCollaborators=" + this.canInviteCollaborators + ", canSetShareAccess=" + this.canSetShareAccess + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ", canApplyWatermark=" + this.canApplyWatermark + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.canDelete ? 1 : 0);
        dest.writeInt(this.canRename ? 1 : 0);
        dest.writeInt(this.canDownload ? 1 : 0);
        dest.writeInt(this.canPreview ? 1 : 0);
        dest.writeInt(this.canUpload ? 1 : 0);
        dest.writeInt(this.canComment ? 1 : 0);
        dest.writeInt(this.canShare ? 1 : 0);
        dest.writeInt(this.canInviteCollaborators ? 1 : 0);
        dest.writeInt(this.canSetShareAccess ? 1 : 0);
        dest.writeInt(this.canViewAnnotations ? 1 : 0);
        dest.writeInt(this.canCreateAnnotations ? 1 : 0);
        dest.writeInt(this.canApplyWatermark ? 1 : 0);
    }

    public PermissionsModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12) {
        this.canDelete = z;
        this.canRename = z2;
        this.canDownload = z3;
        this.canPreview = z4;
        this.canUpload = z5;
        this.canComment = z6;
        this.canShare = z7;
        this.canInviteCollaborators = z8;
        this.canSetShareAccess = z9;
        this.canViewAnnotations = z10;
        this.canCreateAnnotations = z11;
        this.canApplyWatermark = z12;
    }

    public /* synthetic */ PermissionsModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7, (i & 128) != 0 ? false : z8, (i & 256) != 0 ? false : z9, (i & 512) != 0 ? false : z10, (i & 1024) != 0 ? false : z11, (i & 2048) != 0 ? false : z12);
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanRename() {
        return this.canRename;
    }

    public final boolean getCanDownload() {
        return this.canDownload;
    }

    public final boolean getCanPreview() {
        return this.canPreview;
    }

    public final boolean getCanUpload() {
        return this.canUpload;
    }

    public final boolean getCanComment() {
        return this.canComment;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanInviteCollaborators() {
        return this.canInviteCollaborators;
    }

    public final boolean getCanSetShareAccess() {
        return this.canSetShareAccess;
    }

    public final boolean getCanViewAnnotations() {
        return this.canViewAnnotations;
    }

    public final boolean getCanCreateAnnotations() {
        return this.canCreateAnnotations;
    }

    public final boolean getCanApplyWatermark() {
        return this.canApplyWatermark;
    }
}
