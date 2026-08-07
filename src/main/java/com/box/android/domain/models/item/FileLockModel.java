package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileLockModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JT\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020!HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006,"}, d2 = {"Lcom/box/android/domain/models/item/FileLockModel;", "Landroid/os/Parcelable;", "id", "", "appType", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/domain/models/item/UserModel;", "expiresAt", "isDownloadPrevented", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getAppType", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/domain/models/item/UserModel;", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/domain/models/item/UserModel;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/domain/models/item/FileLockModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileLockModel implements Parcelable {
    public static final Parcelable.Creator<FileLockModel> CREATOR = new Creator();
    private final String appType;
    private final Date createdAt;
    private final UserModel createdBy;
    private final Date expiresAt;
    private final String id;
    private final Boolean isDownloadPrevented;

    /* JADX INFO: compiled from: FileLockModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FileLockModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileLockModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            Boolean boolValueOf = null;
            UserModel userModelCreateFromParcel = parcel.readInt() == 0 ? null : UserModel.CREATOR.createFromParcel(parcel);
            Date date2 = (Date) parcel.readSerializable();
            if (parcel.readInt() != 0) {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FileLockModel(string, string2, date, userModelCreateFromParcel, date2, boolValueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FileLockModel[] newArray(int i) {
            return new FileLockModel[i];
        }
    }

    public static /* synthetic */ FileLockModel copy$default(FileLockModel fileLockModel, String str, String str2, Date date, UserModel userModel, Date date2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileLockModel.id;
        }
        if ((i & 2) != 0) {
            str2 = fileLockModel.appType;
        }
        if ((i & 4) != 0) {
            date = fileLockModel.createdAt;
        }
        if ((i & 8) != 0) {
            userModel = fileLockModel.createdBy;
        }
        if ((i & 16) != 0) {
            date2 = fileLockModel.expiresAt;
        }
        if ((i & 32) != 0) {
            bool = fileLockModel.isDownloadPrevented;
        }
        Date date3 = date2;
        Boolean bool2 = bool;
        return fileLockModel.copy(str, str2, date, userModel, date3, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppType() {
        return this.appType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserModel getCreatedBy() {
        return this.createdBy;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsDownloadPrevented() {
        return this.isDownloadPrevented;
    }

    public final FileLockModel copy(String id, String appType, Date createdAt, UserModel createdBy, Date expiresAt, Boolean isDownloadPrevented) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new FileLockModel(id, appType, createdAt, createdBy, expiresAt, isDownloadPrevented);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileLockModel)) {
            return false;
        }
        FileLockModel fileLockModel = (FileLockModel) other;
        return Intrinsics.areEqual(this.id, fileLockModel.id) && Intrinsics.areEqual(this.appType, fileLockModel.appType) && Intrinsics.areEqual(this.createdAt, fileLockModel.createdAt) && Intrinsics.areEqual(this.createdBy, fileLockModel.createdBy) && Intrinsics.areEqual(this.expiresAt, fileLockModel.expiresAt) && Intrinsics.areEqual(this.isDownloadPrevented, fileLockModel.isDownloadPrevented);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.appType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.createdAt;
        int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
        UserModel userModel = this.createdBy;
        int iHashCode4 = (iHashCode3 + (userModel == null ? 0 : userModel.hashCode())) * 31;
        Date date2 = this.expiresAt;
        int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Boolean bool = this.isDownloadPrevented;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "FileLockModel(id=" + this.id + ", appType=" + this.appType + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", expiresAt=" + this.expiresAt + ", isDownloadPrevented=" + this.isDownloadPrevented + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.appType);
        dest.writeSerializable(this.createdAt);
        UserModel userModel = this.createdBy;
        if (userModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            userModel.writeToParcel(dest, flags);
        }
        dest.writeSerializable(this.expiresAt);
        Boolean bool = this.isDownloadPrevented;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public FileLockModel(String id, String str, Date date, UserModel userModel, Date date2, Boolean bool) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.appType = str;
        this.createdAt = date;
        this.createdBy = userModel;
        this.expiresAt = date2;
        this.isDownloadPrevented = bool;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAppType() {
        return this.appType;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final UserModel getCreatedBy() {
        return this.createdBy;
    }

    public final Date getExpiresAt() {
        return this.expiresAt;
    }

    public final Boolean isDownloadPrevented() {
        return this.isDownloadPrevented;
    }
}
