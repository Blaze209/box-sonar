package com.box.android.domain.models.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jx\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020.HÖ\u0001J\t\u00103\u001a\u00020\u0004HÖ\u0001J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\t\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00069"}, d2 = {"Lcom/box/android/domain/models/item/UserModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "id", "", "name", "login", "enterprise", "Lcom/box/android/domain/models/item/EnterpriseModel;", "isPaidUser", "", "spaceAmount", "", "spaceUsed", "maxUploadSize", "createdDate", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/item/EnterpriseModel;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getName", "getLogin", "getEnterprise", "()Lcom/box/android/domain/models/item/EnterpriseModel;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSpaceAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSpaceUsed", "getMaxUploadSize", "getCreatedDate", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/item/EnterpriseModel;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;)Lcom/box/android/domain/models/item/UserModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class UserModel implements DomainModel, Parcelable {
    public static final Parcelable.Creator<UserModel> CREATOR = new Creator();
    private final Date createdDate;
    private final EnterpriseModel enterprise;
    private final String id;
    private final Boolean isPaidUser;
    private final String login;
    private final Long maxUploadSize;
    private final String name;
    private final Long spaceAmount;
    private final Long spaceUsed;

    /* JADX INFO: compiled from: UserModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserModel createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            EnterpriseModel enterpriseModelCreateFromParcel = parcel.readInt() == 0 ? null : EnterpriseModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new UserModel(string, string2, string3, enterpriseModelCreateFromParcel, boolValueOf, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserModel[] newArray(int i) {
            return new UserModel[i];
        }
    }

    public static /* synthetic */ UserModel copy$default(UserModel userModel, String str, String str2, String str3, EnterpriseModel enterpriseModel, Boolean bool, Long l, Long l2, Long l3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userModel.id;
        }
        if ((i & 2) != 0) {
            str2 = userModel.name;
        }
        if ((i & 4) != 0) {
            str3 = userModel.login;
        }
        if ((i & 8) != 0) {
            enterpriseModel = userModel.enterprise;
        }
        if ((i & 16) != 0) {
            bool = userModel.isPaidUser;
        }
        if ((i & 32) != 0) {
            l = userModel.spaceAmount;
        }
        if ((i & 64) != 0) {
            l2 = userModel.spaceUsed;
        }
        if ((i & 128) != 0) {
            l3 = userModel.maxUploadSize;
        }
        if ((i & 256) != 0) {
            date = userModel.createdDate;
        }
        Long l4 = l3;
        Date date2 = date;
        Long l5 = l;
        Long l6 = l2;
        Boolean bool2 = bool;
        String str4 = str3;
        return userModel.copy(str, str2, str4, enterpriseModel, bool2, l5, l6, l4, date2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EnterpriseModel getEnterprise() {
        return this.enterprise;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIsPaidUser() {
        return this.isPaidUser;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getSpaceAmount() {
        return this.spaceAmount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getSpaceUsed() {
        return this.spaceUsed;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getMaxUploadSize() {
        return this.maxUploadSize;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Date getCreatedDate() {
        return this.createdDate;
    }

    public final UserModel copy(String id, String name, String login, EnterpriseModel enterprise, Boolean isPaidUser, Long spaceAmount, Long spaceUsed, Long maxUploadSize, Date createdDate) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new UserModel(id, name, login, enterprise, isPaidUser, spaceAmount, spaceUsed, maxUploadSize, createdDate);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserModel)) {
            return false;
        }
        UserModel userModel = (UserModel) other;
        return Intrinsics.areEqual(this.id, userModel.id) && Intrinsics.areEqual(this.name, userModel.name) && Intrinsics.areEqual(this.login, userModel.login) && Intrinsics.areEqual(this.enterprise, userModel.enterprise) && Intrinsics.areEqual(this.isPaidUser, userModel.isPaidUser) && Intrinsics.areEqual(this.spaceAmount, userModel.spaceAmount) && Intrinsics.areEqual(this.spaceUsed, userModel.spaceUsed) && Intrinsics.areEqual(this.maxUploadSize, userModel.maxUploadSize) && Intrinsics.areEqual(this.createdDate, userModel.createdDate);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.login;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        EnterpriseModel enterpriseModel = this.enterprise;
        int iHashCode4 = (iHashCode3 + (enterpriseModel == null ? 0 : enterpriseModel.hashCode())) * 31;
        Boolean bool = this.isPaidUser;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.spaceAmount;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.spaceUsed;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.maxUploadSize;
        int iHashCode8 = (iHashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Date date = this.createdDate;
        return iHashCode8 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "UserModel(id=" + this.id + ", name=" + this.name + ", login=" + this.login + ", enterprise=" + this.enterprise + ", isPaidUser=" + this.isPaidUser + ", spaceAmount=" + this.spaceAmount + ", spaceUsed=" + this.spaceUsed + ", maxUploadSize=" + this.maxUploadSize + ", createdDate=" + this.createdDate + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.login);
        EnterpriseModel enterpriseModel = this.enterprise;
        if (enterpriseModel == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            enterpriseModel.writeToParcel(dest, flags);
        }
        Boolean bool = this.isPaidUser;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l = this.spaceAmount;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        Long l2 = this.spaceUsed;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        Long l3 = this.maxUploadSize;
        if (l3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l3.longValue());
        }
        dest.writeSerializable(this.createdDate);
    }

    public UserModel(String id, String str, String str2, EnterpriseModel enterpriseModel, Boolean bool, Long l, Long l2, Long l3, Date date) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.name = str;
        this.login = str2;
        this.enterprise = enterpriseModel;
        this.isPaidUser = bool;
        this.spaceAmount = l;
        this.spaceUsed = l2;
        this.maxUploadSize = l3;
        this.createdDate = date;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLogin() {
        return this.login;
    }

    public final EnterpriseModel getEnterprise() {
        return this.enterprise;
    }

    public final Boolean isPaidUser() {
        return this.isPaidUser;
    }

    public final Long getSpaceAmount() {
        return this.spaceAmount;
    }

    public final Long getSpaceUsed() {
        return this.spaceUsed;
    }

    public final Long getMaxUploadSize() {
        return this.maxUploadSize;
    }

    public final Date getCreatedDate() {
        return this.createdDate;
    }
}
