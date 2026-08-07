package com.box.android.domain.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006)"}, d2 = {"Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainModel;", "Landroid/os/Parcelable;", "id", "", "type", "Lcom/box/android/domain/models/CollectionType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/domain/models/CollectionType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionModel implements DomainModel, Parcelable {
    private final Date createdAt;
    private final String id;
    private final String name;
    private final CollectionType type;
    private final Date updatedAt;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CollectionModel> CREATOR = new Creator();

    /* JADX INFO: compiled from: CollectionModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CollectionModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectionModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CollectionModel(parcel.readString(), CollectionType.CREATOR.createFromParcel(parcel), parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectionModel[] newArray(int i) {
            return new CollectionModel[i];
        }
    }

    public static /* synthetic */ CollectionModel copy$default(CollectionModel collectionModel, String str, CollectionType collectionType, String str2, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collectionModel.id;
        }
        if ((i & 2) != 0) {
            collectionType = collectionModel.type;
        }
        if ((i & 4) != 0) {
            str2 = collectionModel.name;
        }
        if ((i & 8) != 0) {
            date = collectionModel.createdAt;
        }
        if ((i & 16) != 0) {
            date2 = collectionModel.updatedAt;
        }
        Date date3 = date2;
        String str3 = str2;
        return collectionModel.copy(str, collectionType, str3, date, date3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CollectionType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final CollectionModel copy(String id, CollectionType type, String name, Date createdAt, Date updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CollectionModel(id, type, name, createdAt, updatedAt);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionModel)) {
            return false;
        }
        CollectionModel collectionModel = (CollectionModel) other;
        return Intrinsics.areEqual(this.id, collectionModel.id) && this.type == collectionModel.type && Intrinsics.areEqual(this.name, collectionModel.name) && Intrinsics.areEqual(this.createdAt, collectionModel.createdAt) && Intrinsics.areEqual(this.updatedAt, collectionModel.updatedAt);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.name.hashCode()) * 31;
        Date date = this.createdAt;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.updatedAt;
        return iHashCode2 + (date2 != null ? date2.hashCode() : 0);
    }

    public String toString() {
        return "CollectionModel(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        this.type.writeToParcel(dest, flags);
        dest.writeString(this.name);
        dest.writeSerializable(this.createdAt);
        dest.writeSerializable(this.updatedAt);
    }

    public CollectionModel(String id, CollectionType type, String name, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.type = type;
        this.name = name;
        this.createdAt = date;
        this.updatedAt = date2;
    }

    public final String getId() {
        return this.id;
    }

    public final CollectionType getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: compiled from: CollectionModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/CollectionModel$Companion;", "", "<init>", "()V", "createFavorites", "Lcom/box/android/domain/models/CollectionModel;", "id", "", "createFromId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionModel createFavorites(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new CollectionModel(id, CollectionType.FAVORITES, CommonBoxUtil.LS(CommonBoxUtil.getStringResIdByName("favorites")), null, null);
        }

        public final CollectionModel createFromId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new CollectionModel(id, CollectionType.PERSONAL, "", null, null);
        }
    }
}
