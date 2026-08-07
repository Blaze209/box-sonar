package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedLinkModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0006\u0010!\u001a\u00020\"J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006-"}, d2 = {"Lcom/box/android/domain/models/item/SharedLinkModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "url", "", "effectiveAccess", "Lcom/box/android/domain/models/item/SharedLinkAccessModel;", "effectivePermission", "Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel;", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/item/SharedLinkAccessModel;Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel;ZLjava/util/Date;Z)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "()Lcom/box/android/domain/models/item/SharedLinkAccessModel;", "getEffectivePermission", "()Lcom/box/android/domain/models/item/SharedLinkEffectivePermissionModel;", "()Z", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SharedLinkModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<SharedLinkModel> CREATOR = new Creator();
    private final boolean canDownload;
    private final SharedLinkAccessModel effectiveAccess;
    private final SharedLinkEffectivePermissionModel effectivePermission;
    private final boolean isPasswordEnabled;
    private final Date unsharedAt;
    private final String url;

    /* JADX INFO: compiled from: SharedLinkModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SharedLinkModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SharedLinkModel createFromParcel(Parcel parcel) {
            boolean z;
            Date date;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            SharedLinkAccessModel sharedLinkAccessModelValueOf = SharedLinkAccessModel.valueOf(parcel.readString());
            SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModelValueOf = SharedLinkEffectivePermissionModel.valueOf(parcel.readString());
            boolean z2 = true;
            if (parcel.readInt() == 0) {
                z2 = false;
            }
            Date date2 = (Date) parcel.readSerializable();
            if (parcel.readInt() != 0) {
                date = date2;
                z = true;
            } else {
                z = false;
                date = date2;
            }
            return new SharedLinkModel(string, sharedLinkAccessModelValueOf, sharedLinkEffectivePermissionModelValueOf, z2, date, z);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SharedLinkModel[] newArray(int i) {
            return new SharedLinkModel[i];
        }
    }

    public static /* synthetic */ SharedLinkModel copy$default(SharedLinkModel sharedLinkModel, String str, SharedLinkAccessModel sharedLinkAccessModel, SharedLinkEffectivePermissionModel sharedLinkEffectivePermissionModel, boolean z, Date date, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sharedLinkModel.url;
        }
        if ((i & 2) != 0) {
            sharedLinkAccessModel = sharedLinkModel.effectiveAccess;
        }
        if ((i & 4) != 0) {
            sharedLinkEffectivePermissionModel = sharedLinkModel.effectivePermission;
        }
        if ((i & 8) != 0) {
            z = sharedLinkModel.isPasswordEnabled;
        }
        if ((i & 16) != 0) {
            date = sharedLinkModel.unsharedAt;
        }
        if ((i & 32) != 0) {
            z2 = sharedLinkModel.canDownload;
        }
        Date date2 = date;
        boolean z3 = z2;
        return sharedLinkModel.copy(str, sharedLinkAccessModel, sharedLinkEffectivePermissionModel, z, date2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SharedLinkAccessModel getEffectiveAccess() {
        return this.effectiveAccess;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SharedLinkEffectivePermissionModel getEffectivePermission() {
        return this.effectivePermission;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsPasswordEnabled() {
        return this.isPasswordEnabled;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getUnsharedAt() {
        return this.unsharedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanDownload() {
        return this.canDownload;
    }

    public final SharedLinkModel copy(String url, SharedLinkAccessModel effectiveAccess, SharedLinkEffectivePermissionModel effectivePermission, boolean isPasswordEnabled, Date unsharedAt, boolean canDownload) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(effectiveAccess, "effectiveAccess");
        Intrinsics.checkNotNullParameter(effectivePermission, "effectivePermission");
        return new SharedLinkModel(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SharedLinkModel)) {
            return false;
        }
        SharedLinkModel sharedLinkModel = (SharedLinkModel) other;
        return Intrinsics.areEqual(this.url, sharedLinkModel.url) && this.effectiveAccess == sharedLinkModel.effectiveAccess && this.effectivePermission == sharedLinkModel.effectivePermission && this.isPasswordEnabled == sharedLinkModel.isPasswordEnabled && Intrinsics.areEqual(this.unsharedAt, sharedLinkModel.unsharedAt) && this.canDownload == sharedLinkModel.canDownload;
    }

    public int hashCode() {
        int iHashCode = ((((((this.url.hashCode() * 31) + this.effectiveAccess.hashCode()) * 31) + this.effectivePermission.hashCode()) * 31) + Boolean.hashCode(this.isPasswordEnabled)) * 31;
        Date date = this.unsharedAt;
        return ((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + Boolean.hashCode(this.canDownload);
    }

    public String toString() {
        return "SharedLinkModel(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.url);
        dest.writeString(this.effectiveAccess.name());
        dest.writeString(this.effectivePermission.name());
        dest.writeInt(this.isPasswordEnabled ? 1 : 0);
        dest.writeSerializable(this.unsharedAt);
        dest.writeInt(this.canDownload ? 1 : 0);
    }

    public SharedLinkModel(String url, SharedLinkAccessModel effectiveAccess, SharedLinkEffectivePermissionModel effectivePermission, boolean z, Date date, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(effectiveAccess, "effectiveAccess");
        Intrinsics.checkNotNullParameter(effectivePermission, "effectivePermission");
        this.url = url;
        this.effectiveAccess = effectiveAccess;
        this.effectivePermission = effectivePermission;
        this.isPasswordEnabled = z;
        this.unsharedAt = date;
        this.canDownload = z2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final SharedLinkAccessModel getEffectiveAccess() {
        return this.effectiveAccess;
    }

    public final SharedLinkEffectivePermissionModel getEffectivePermission() {
        return this.effectivePermission;
    }

    public final boolean isPasswordEnabled() {
        return this.isPasswordEnabled;
    }

    public final Date getUnsharedAt() {
        return this.unsharedAt;
    }

    public final boolean getCanDownload() {
        return this.canDownload;
    }
}
